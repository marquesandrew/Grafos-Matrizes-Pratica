package org.example;

import java.util.Arrays;

public class BellmanFord {

    //Classe interna para representar uma aresta
    static class Aresta {
        int origem, destino, peso;

        Aresta(int origem, int destino, int peso) {
            this.origem = origem;
            this.destino = destino;
            this.peso = peso;
        }
    }

    public static void bellmanFord(Aresta[] arestas, int vertices, int origem){
        int [] distancia = new int[vertices];
        Arrays.fill(distancia, Integer.MAX_VALUE);
        distancia[origem] = 0;

        //relaxa todas as arestas V -1 vezes
        for (int i=1; i < vertices; i++){
            for (Aresta aresta: arestas){
                int u = aresta.origem;
                int v = aresta.destino;
                int peso = aresta.peso;

                if (distancia[u] != Integer.MAX_VALUE && distancia[u] + peso < distancia[v]) {
                    distancia[v] = distancia[u] + peso;
                }
            }
        }

        //verifica ciclo negativo
        for (Aresta aresta: arestas) {
            int u = aresta.origem;
            int v = aresta.destino;
            int peso = aresta.peso;

            if (distancia[u] != Integer.MAX_VALUE && distancia[u] + peso < distancia[v]) {
                System.out.println("O grafo contém ciclo de peso negativo!");
                return;
            }
        }

        // exibe resultado
        System.out.println("Distâncias mínimas a partir do vértice" + origem + ":");
        for (int i=0; i<vertices; i++) {
            if (distancia[i] == Integer.MAX_VALUE){
                System.out.println("Vértice " + i + " -> INF");
            } else {
                System.out.println("Vértice " + i + " -> " + distancia[i]);
            }
        }
    }
}
