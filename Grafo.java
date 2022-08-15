package Grafo;

import java.util.*;

class Grafo<T> {

    private Map<String, List<String> > map = new HashMap<>();
    private Map<String, Integer> peso = new HashMap<>();
    private Map<String, Integer> distanciaDestino = new HashMap<>();
    private Integer flag = 0;
    public ArrayList<String> visitados = new ArrayList<>();
    public ArrayList<String> vizinhosVisitados = new ArrayList<>();
    public ArrayList<String> escolhidos = new ArrayList<>();

    public void addVertex(String s)
    {
        map.put(s, new LinkedList<String>());
    }

    public void addDistanciaDestino(String source,
                        String destination,
                        Integer distancia)
    {
        if(!distanciaDestino.containsKey(source+destination)){
            distanciaDestino.put(source+destination, distancia);
        }
    }

    public void addEdge(String source,
                        String destination,
                        boolean bidirectional, Integer distancia)
    {

        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);
        if (bidirectional == true) {
            map.get(destination).add(source);
            if(!peso.containsKey(destination+source)){
                peso.put(destination+source, distancia);
            }
        }
        if(!peso.containsKey(source+destination)){
            peso.put(source+destination, distancia);
        }

    }

    void aEstrela(String entrada, String saida)
    {
        Integer flag = 0;
        LinkedList<String> vizinhos = new LinkedList<String>();
        Integer menorValor = 999999999;
        String menorNo = "";
        Integer menorValorAnterior = 999999999;
        String menorAnterior = "";
        Integer distanciaTotal = 0;

        visitados.add(entrada);
        vizinhos.add(entrada);

        while (vizinhos.size() != 0)
        {

            if(entrada.equals(saida)){
                return;
            }
            if (flag == 0){
                entrada = vizinhos.poll();
                flag++;
            }
            else{
                entrada = menorNo;
                escolhidos.add(menorNo);
                System.out.print("Já foram visitados " + escolhidos+"");
                System.out.println();
                
                if(!entrada.equals(saida)){
                    System.out.print("Você está em " + entrada+"");
                    System.out.println();
                }
                else {
                    System.out.print("Chegou a " + entrada + "!");
                    System.out.println("\n");
                    System.out.print("Distancia percorrida: " + distanciaTotal);
                    System.out.println();
                    break;
                }

            }

            checkVisitados(entrada, vizinhos);
            
            for(String no : vizinhosVisitados){
                distanciaDestino.put(no, distanciaDestino.get(no+saida)+peso.get(entrada+no));
                if(distanciaDestino.get(no+saida)+peso.get(entrada+no) < menorValor){
                    menorValor = distanciaDestino.get(no+saida)+peso.get(entrada+no);
                    menorNo = no;
                }
                if((distanciaDestino.get(no+saida)+peso.get(entrada+no) > menorValor) && (distanciaDestino.get(no+saida)+peso.get(entrada+no)) < menorValorAnterior) {
                	menorAnterior = no;
                	menorValorAnterior = distanciaDestino.get(no+saida)+peso.get(entrada+no);
                }
            }
            if (escolhidos.contains(menorNo)) {
        	   menorNo = menorAnterior;
            }
            
            if(!entrada.equals(saida)) {
                for (String cidade : vizinhosVisitados) {
                    System.out.print(cidade + ": " + distanciaDestino.get(cidade));
                    System.out.print(" | ");

                }
                System.out.println("\n");

            }

            distanciaTotal += peso.get(entrada+menorNo);
            vizinhosVisitados.clear();
            menorValor = 99999999;
        }
    }
    
    void checkVisitados(String entrada, LinkedList<String> vizinhos) {
    	Iterator<String> x = map.get(entrada).listIterator();
        while (x.hasNext())
        {
            String cidadeVisitada = x.next();
            vizinhosVisitados.add(cidadeVisitada);
            if(!x.hasNext()){
            }
            if (!visitados.contains(cidadeVisitada))
            {
                visitados.add(cidadeVisitada);
                vizinhos.add(cidadeVisitada);
            }
        }
    }
}