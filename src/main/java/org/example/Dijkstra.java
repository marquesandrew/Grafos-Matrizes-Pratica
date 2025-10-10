package org.example;

import java.util.Arrays;

public class Dijkstra {

    public static void dijkstra(int[][] grafo, int origem){
        int quantidadeVertices = grafo.length;
        int [] distancia = new int[quantidadeVertices];
        boolean[] visitado = new boolean[quantidadeVertices];

        Arrays.fill(distancia, Integer.MAX_VALUE);
        distancia[origem] = 0;

        // Percorre todos os vértices
        for (int count =0; count< quantidadeVertices; count++){
            int u = menorDistancia(distancia,visitado);
            visitado[u] = true;

            // atualiza as distancias dos vertices vizinhos
            for (int v=0; v<quantidadeVertices; v++){
                if (!visitado[v] && grafo[u][v] !=0 && distancia[u] != Integer.MAX_VALUE && distancia[u] + grafo[u][v] < distancia[v]){
                    distancia[v] = distancia[u] + grafo[u][v];
                }
            }
        }
        //exibe resultado
        exibeSolucao(distancia, origem);
    }

    private static int menorDistancia(int[] distancia, boolean[] visitado){
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v=0; v<distancia.length; v++){
            if(!visitado[v] && distancia[v] <=min){
                min = distancia[v];
                minIndex =v;
            }
        }
        return minIndex;
    }

    private static void exibeSolucao(int[] distancia, int origem) {
        System.out.println("Distâncias mínimas a partir do vértice " + origem + ": ");
        for (int i = 0; i < distancia.length; i++) {
            if (distancia[i] == Integer.MAX_VALUE) {
                System.out.println("Vértice " + i + "-> INF");
            } else {
                System.out.println("Vértice " + i + "->" + distancia[i]);
            }
        }
    }
}
