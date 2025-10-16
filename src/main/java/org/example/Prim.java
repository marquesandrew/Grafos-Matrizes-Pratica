package org.example;

import org.example.model.GrafoNaoDirecionado;

import java.util.Arrays;

public class Prim {

    private static final int INF = Integer.MAX_VALUE / 2;

    public static void encontrarMST(GrafoNaoDirecionado grafo) {
        int numeroVertices = grafo.getNumeroVertices();
        int[][] matriz = grafo.getMatrizAdjacencia();

        int[] chave = new int[numeroVertices]; //menor peso para conectar cada vertice
        int[] pai = new int[numeroVertices]; //quem é o pai na arvore

        boolean[] incluido = new boolean[numeroVertices]; //se o vertice ja foi incluido

        Arrays.fill(chave, INF);
        Arrays.fill(incluido, false);
        chave[0] = 0; //comeca pelo vertice zero
        pai[0] = -1; // o primeiro nao tem pai

        for (int i =0; i<numeroVertices -1; i++){
            int u = menorChave(chave, incluido, numeroVertices);
            incluido[u] = true;

            for (int v=0; v<numeroVertices; v++){
                if (matriz[u][v] !=0 && matriz[u][v] < INF && !incluido[v] && matriz[u][v] < chave[v]){
                    pai[v] = u;
                    chave[v] = matriz[u][v];
                }
            }
        }

        imprimeResultado(pai, matriz);
    }

    private static int menorChave(int[] chave, boolean[] incluido, int numeroVertices){
        int min = INF, minIndex = -1;
        for (int v=0; v<numeroVertices; v++){
            if (!incluido[v] && chave[v] < min){
                min = chave[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private static void imprimeResultado(int[] pai, int[][] matriz){
        int custoTotal = 0;
        System.out.println("Arestas da Árvore Geradora Mínima:");
        System.out.println("Aresta\tPeso");
        for (int i =1; i< matriz.length; i++){
            System.out.println(pai[i] + " - " + i + "\t" + matriz[i][pai[i]]);
            custoTotal += matriz[i][pai[i]];
        }
        System.out.println("\nCusto Total: " + custoTotal);
    }
}
