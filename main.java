package Grafo;

public class main {

    public static void main(String args[])
    {

        Grafo<Integer> rota= new Grafo<Integer>();

        // Figura 3.2 Mapa rodoviario simplificado de parte da Romenia
        rota.addEdge("Oradea", "Zerind", true, 71);
        rota.addEdge("Oradea", "Sibiu", true, 151);
        rota.addEdge("Zerind", "Arad", true, 75);
        rota.addEdge("Arad", "Sibiu", true, 140);
        rota.addEdge("Sibiu", "Fagaras", true, 99);
        rota.addEdge("Fagaras", "Bucareste", true, 211);
        rota.addEdge("Arad", "Timisoara", true, 118);
        rota.addEdge("Timisoara", "Lugoj", true, 111);
        rota.addEdge("Lugoj", "Mehadia", true, 70);
        rota.addEdge("Mehadia", "Drobeta", true, 75);
        rota.addEdge("Drobeta", "Craiova", true, 120);
        rota.addEdge("Craiova", "Pitesti", true, 138);
        rota.addEdge("Pitesti", "Bucareste", true, 101);
        rota.addEdge("Sibiu", "Rimnieu Vilcea", true, 80);
        rota.addEdge("Rimnieu Vilcea", "Craiova", true, 146);
        rota.addEdge("Rimnieu Vilcea", "Pitesti", true, 97);
        rota.addEdge("Giurgiu", "Bucareste", true, 90);
        rota.addEdge("Eforie", "Hirsova", true, 86);
        rota.addEdge("Hirsova", "Urziceni", true, 98);
        rota.addEdge("Urziceni", "Bucareste", true, 85);
        rota.addEdge("Neamt", "Iasi", true, 87);
        rota.addEdge("Iasi", "Vaslui", true, 92);
        rota.addEdge("Vaslui", "Urziceni", true, 142);
        rota.addEdge("Bucareste", "Bucareste", true, 0);
        
        // Figura 3.22 Valores de hDLR - distancias em linha reta para Bucareste
        rota.addDistanciaDestino("Arad", "Bucareste", 366);
        rota.addDistanciaDestino("Craiova", "Bucareste", 160);
        rota.addDistanciaDestino("Drobeta", "Bucareste", 242);
        rota.addDistanciaDestino("Eforie", "Bucareste", 161);
        rota.addDistanciaDestino("Fagaras", "Bucareste", 176);
        rota.addDistanciaDestino("Giurgiu", "Bucareste", 77);
        rota.addDistanciaDestino("Hirsova", "Bucareste", 151);
        rota.addDistanciaDestino("Iasi", "Bucareste", 226);
        rota.addDistanciaDestino("Lugoj", "Bucareste", 244);
        rota.addDistanciaDestino("Mehadia", "Bucareste", 241);
        rota.addDistanciaDestino("Neamt", "Bucareste", 234);
        rota.addDistanciaDestino("Oradea", "Bucareste", 380);
        rota.addDistanciaDestino("Pitesti", "Bucareste", 100);
        rota.addDistanciaDestino("Rimnieu Vilcea", "Bucareste", 193);
        rota.addDistanciaDestino("Sibiu", "Bucareste", 253);
        rota.addDistanciaDestino("Timisoara", "Bucareste", 329);
        rota.addDistanciaDestino("Urziceni", "Bucareste", 80);
        rota.addDistanciaDestino("Vaslui", "Bucareste", 199);
        rota.addDistanciaDestino("Zerind", "Bucareste", 374);
        rota.addDistanciaDestino("Bucareste", "Bucareste", 0);

        rota.aEstrela("Timisoara","Bucareste");

    }
}