package org.example;

import org.example.model.Aresta;
import org.example.model.Grafo;

import java.util.Arrays;
import java.util.List;

public class BellmanFord {
    public static void bellmanFord(Grafo grafo, int origem){
        int vertices = grafo.getNumeroVertices();
        List<Aresta> arestas = grafo.getArestas();

        double [] distancia = new double[vertices];
        int[] predecessor = new int[vertices];

        Arrays.fill(distancia, Double.POSITIVE_INFINITY);
        Arrays.fill(predecessor, -1);
        distancia[origem] = 0.0;

        //relaxa todas as arestas V -1 vezes
        for (int i=0; i < vertices -1; i++){
            boolean houveMudanca = false;

            for (Aresta aresta: arestas){
                int u = aresta.getOrigem();
                int v = aresta.getDestino();
                double peso = aresta.getPeso();

                //verifica distancia u intangivel
                if ( distancia[u] != Double.POSITIVE_INFINITY){
                    //cond relaxamento
                    if(distancia[u] + peso < distancia[v]){
                        distancia[v] = distancia[u] + peso;
                        predecessor[v] = u;
                        houveMudanca = true;
                    }
                }
            }
            // Otimiza senao houve mudanca
            if (!houveMudanca) break;
        }

        //verifica ciclo negativo
        for (Aresta aresta: arestas) {
            int u = aresta.getOrigem();
            int v = aresta.getDestino();
            double peso = aresta.getPeso();

            if (distancia[u] != Integer.MAX_VALUE && distancia[u] + peso < distancia[v]) {
                System.out.println("O grafo contém ciclo de peso negativo!");
                System.out.println("O algoritmo BellmanFord não pode garantir caminho mínimo");
                return;
            }
        }

        // exibe resultado
        System.out.println("BelmmanFord partir do vértice: " + origem + ":");
        System.out.println("Distancias Mínimas");
        for (int i=0; i<vertices; i++) {
            if (distancia[i] == Integer.MAX_VALUE){
                System.out.println("Vértice " + i + " -> INF");
            } else {
                System.out.printf("Vértice %d ->  %.1f%n ", i, distancia[i]);
            }
        }

        System.out.println("Predecessores");
        for (int i=0; i < predecessor.length; i++){
            if (i == origem){
                System.out.printf("Vértice %d -> Origem (-) %n",i);
            } else if (predecessor[i] == -1){
                System.out.printf("Vértice %d -> Não alcançável (-) %n",i);
            } else{
                System.out.printf("Vértice %d -> Vértice %d (Aresta na MST: V%d -> V%d)%n", i, predecessor[i], predecessor[i],i);
            }
        }
        System.out.println();
    }
}
