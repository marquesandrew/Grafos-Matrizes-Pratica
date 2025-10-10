package org.example;

import org.example.model.Dijkstra;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // FLOYD WARSHALL
        System.out.println("====FLOYD WARSHALL====");
        int INF = FloydWarshall.INFINITO;
        int [][] grafo = {
                {0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}
        };
        FloydWarshall.floydWarshall(grafo);
        System.out.println();


        // BELMMAN FORD
        System.out.println("====BELMANN FORD====");
        int vertices = 5;
        int arestasCount = 8;

        BellmanFord.Aresta[] arestas = new BellmanFord.Aresta[arestasCount];
        //define arestas
        arestas[0] = new BellmanFord.Aresta(0, 1, -1);
        arestas[1] = new BellmanFord.Aresta(0, 2, 4);
        arestas[2] = new BellmanFord.Aresta(1, 2, 3);
        arestas[3] = new BellmanFord.Aresta(1, 3, 2);
        arestas[4] = new BellmanFord.Aresta(1, 4, 2);
        arestas[5] = new BellmanFord.Aresta(3, 2, 5);
        arestas[6] = new BellmanFord.Aresta(3, 1, 1);
        arestas[7] = new BellmanFord.Aresta(4, 3, -3);

        BellmanFord.bellmanFord(arestas, vertices, 0);
        System.out.println();

        //Dijkstra
        System.out.println("====DIJKSTRA====");
        int origemDijkstra=0;
        int [][] grafoDijkstra = {
                {0, 10, 0, 30, 100},
                {10, 0, 50, 0, 0},
                {0, 50, 0, 20, 10},
                {30, 0, 20, 0, 60},
                {100, 0, 10, 60, 0}
        };
        Dijkstra.dijkstra(grafoDijkstra, origemDijkstra);
    }
}