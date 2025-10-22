package org.example;

import org.example.model.Grafo;

public class Main {
    public static void main(String[] args) {

        //GRAFO NAO DIRECIONADO
        Grafo grafoNDirecionado = new Grafo(6,false);
        grafoNDirecionado.addAresta(0, 1, 1.0);
        grafoNDirecionado.addAresta(0, 2, 5.0);
        grafoNDirecionado.addAresta(0, 3, 5.3);

        grafoNDirecionado.addAresta(1, 2, 0.3);
        grafoNDirecionado.addAresta(1, 4, 1.9);

        grafoNDirecionado.addAresta(2, 3, 0.5);
        grafoNDirecionado.addAresta(2, 4, 0.3);
        grafoNDirecionado.addAresta(2, 5, 9.1);

        grafoNDirecionado.addAresta(3, 5, 5.0);

        grafoNDirecionado.addAresta(4, 5, 1.3);


        //PRIM
        System.out.println("====PRIM====");
        Prim.encontrarMST(grafoNDirecionado);

        //KRUSKAL
        System.out.println("====KRUSKAL====");
        Kruskal.encontrarMST(grafoNDirecionado);


        // GRAFO DIRECIONADO
        Grafo grafoDirecionado = new Grafo(6, true);
        grafoDirecionado.addAresta(0,1,1.0);
        grafoDirecionado.addAresta(0,3,5.3);
        grafoDirecionado.addAresta(0,2,5.0);

        grafoDirecionado.addAresta(1,2,0.3);
        grafoDirecionado.addAresta(1,4,1.9);

        grafoDirecionado.addAresta(2, 3, 0.5);
        grafoDirecionado.addAresta(2, 4, 0.3);
        grafoDirecionado.addAresta(2, 5, 9.1);

        grafoDirecionado.addAresta(3, 5, 5.0);

        grafoDirecionado.addAresta(4, 5, 1.3);

        //FLOYD WARSHALL
        System.out.println("====FLOYD WARSHALL====");
        FloydWarshall.floydWarshall(grafoDirecionado.getMatrizAdjacencia());
        System.out.println();


        //BELMMAN FORD
        System.out.println("====BELMANN FORD====");
        BellmanFord.bellmanFord(grafoDirecionado,0);
        System.out.println();

        //Dijkstra
        System.out.println("====DIJKSTRA====");
        Dijkstra.dijkstra(grafoDirecionado,0);
    }
}