package org.example;

public class FloydWarshall {

    final static int INFINITO=99999;

    public static void floydWarshall(int[][] grafo) {
        int tamanhoGrafo = grafo.length;
        int[][] matrizMenorDistancia = new int[tamanhoGrafo][tamanhoGrafo];

        // inicializa matriz de distancias com os valores do grafo
        for(int i=0; i<tamanhoGrafo; i++){
            for(int j =0; j<tamanhoGrafo; j++){
                matrizMenorDistancia[i][j] = grafo[i][j];
            }
        }

        //loop principal do algoritmo
        for (int k =0; k<tamanhoGrafo; k++){
            for (int i=0; i<tamanhoGrafo; i++){
                for (int j=0; j<tamanhoGrafo; j++){
                    if (matrizMenorDistancia[i][k] + matrizMenorDistancia[k][j] < matrizMenorDistancia[i][j]){
                        matrizMenorDistancia[i][j] = matrizMenorDistancia[i][k] + matrizMenorDistancia[k][j];
                    }
                }
            }
        }

        //exibe resultado
        exibeSolucao(matrizMenorDistancia);
    }

    //método exibeSolucao
    public static void exibeSolucao(int[][] matrizDistanciaMinima) {
        int tamanho = matrizDistanciaMinima.length;

        System.out.println("Matriz de distâncias mínimas entre os vértices:");
        for(int i=0; i<tamanho; i++){
            for(int j=0; j<tamanho; j++){
                if(matrizDistanciaMinima[i][j] == INFINITO){
                    System.out.printf("%6s", "INF ");
                } else {
                    System.out.printf("%6s", matrizDistanciaMinima[i][j]);
                }
            }
            System.out.println();
        }
    }
}
