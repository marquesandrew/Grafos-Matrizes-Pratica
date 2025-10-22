package org.example;

import org.example.model.Grafo;

import java.util.Arrays;

public class Dijkstra {

    public static void dijkstra(Grafo grafo, int origem){
        int quantidadeVertices = grafo.getNumeroVertices();
        double[][] matrizAdjacencia = grafo.getMatrizAdjacencia();

        double[] distancia = new double[quantidadeVertices];
        boolean[] visitado = new boolean[quantidadeVertices];
        int[] predecessor = new int[quantidadeVertices];

        Arrays.fill(distancia, Double.POSITIVE_INFINITY);
        Arrays.fill(predecessor, -1);
        distancia[origem] = 0.0;
        predecessor[origem] = -1; //Vertice origem n tem predecessor

        // Percorre todos os vértices
        for (int count =0; count< quantidadeVertices; count++){
            int u = menorDistancia(distancia,visitado);
            //se menordistancia retornar -1, todos verifices restanttes sao inacessiveis INF
            if (u == -1) break;

            visitado[u] = true;

            // atualiza as distancias dos vertices vizinhos
            for (int v=0; v<quantidadeVertices; v++){
                double pesoAresta = matrizAdjacencia[u][v];
                if (!visitado[v] && pesoAresta != Double.POSITIVE_INFINITY && distancia[u] != Double.POSITIVE_INFINITY && distancia[u] + pesoAresta < distancia[v]){
                    distancia[v] = distancia[u] + pesoAresta;
                    predecessor[v] = u;
                }
            }
        }
        //exibe resultado
        exibeSolucao(origem, distancia, predecessor);
    }

    private static int menorDistancia(double[] distancia, boolean[] visitado){
        double min = Double.POSITIVE_INFINITY;
        int minIndex = -1;

        for (int v=0; v<distancia.length; v++){
            if(!visitado[v] && distancia[v] <=min){
                min = distancia[v];
                minIndex =v;
            }
        }
        return minIndex;
    }

    private static void exibeSolucao(int origem, double[] distancia, int[] predecessor) {
        System.out.println("Dijkstra a partir do Vértice: " + origem);

        //distancias
        System.out.println("Distâncias mínimas");
        for (int i = 0; i < distancia.length; i++) {
            if (distancia[i] == Double.POSITIVE_INFINITY) {
                System.out.printf("Vértice %d -> INF%n",i);
            } else {
                System.out.printf("Vértice %d -> %.1f%n", i, distancia[i]);
            }
        }
        //predecessores e MST
        System.out.println("Predecessores (Árvore de Custo Mínimo): ");
        for (int i=0; i< predecessor.length; i++){
            if (i == origem){
                System.out.printf("Vértice %d -> Origem (-) %n", i);
            } else if (predecessor[i] == -1){
                System.out.printf("Vértice %d -> Não Alcançável (-) %n", i);
            } else {
                System.out.printf("Vértice %d -> Vértice %d (Aresta na MST: V%d -> V%d) %n", i,predecessor[i],predecessor[i],i);
            }
        }
    }
}
