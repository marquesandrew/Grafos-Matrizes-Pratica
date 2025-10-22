package org.example;

public class FloydWarshall {

    final static double INF = Double.POSITIVE_INFINITY;

    public static void floydWarshall(double[][] grafo) {
        int tamanhoGrafo = grafo.length;
        double[][] matrizMenorDistancia = new double[tamanhoGrafo][tamanhoGrafo];
        int[][] matrizPredecessores = new int[tamanhoGrafo][tamanhoGrafo];

        // inicializa matriz de distancias com os valores do grafo
        for(int i=0; i<tamanhoGrafo; i++){
            for(int j =0; j<tamanhoGrafo; j++){
                matrizMenorDistancia[i][j] = grafo[i][j];

                //predecessores
                if (i == j || grafo[i][j] == INF){
                    matrizPredecessores[i][j] = -1; //sem predecessor
                } else {
                    matrizPredecessores[i][j] = i; // antecessor de j é i
                }
            }
        }

        //loop principal do algoritmo
        for (int k =0; k<tamanhoGrafo; k++){
            for (int i=0; i<tamanhoGrafo; i++){
                for (int j=0; j<tamanhoGrafo; j++){
                    if (matrizMenorDistancia[i][k] + matrizMenorDistancia[k][j] < matrizMenorDistancia[i][j]){
                        matrizMenorDistancia[i][j] = matrizMenorDistancia[i][k] + matrizMenorDistancia[k][j];
                        matrizPredecessores[i][j] = matrizPredecessores[k][j];
                    }
                }
            }
        }

        //exibe resultado
        exibeMatrizDistancia(matrizMenorDistancia);
        exibeMatrizPredecessores(matrizPredecessores);
    }

    public static void exibeMatrizPredecessores(int[][] matrizPredecessores){
        int tamanho = matrizPredecessores.length;
        System.out.println("\nMatriz de predecessores: ");
        for (int i=0; i<tamanho; i++){
            for (int j=0; j<tamanho; j++) {
                if (matrizPredecessores[i][j] == -1)
                    System.out.printf("%6s", "-");
                else
                    System.out.printf("%6d", matrizPredecessores[i][j]);
            }
            System.out.println();
        }
    }

    //método exibeSolucao
    public static void exibeMatrizDistancia(double[][] matrizDistanciaMinima) {
        int tamanho = matrizDistanciaMinima.length;

        System.out.println("Matriz de distâncias mínimas entre os vértices:");
        for(int i=0; i<tamanho; i++){
            for(int j=0; j<tamanho; j++){
                if(matrizDistanciaMinima[i][j] == INF){
                    System.out.printf("%6s", "INF ");
                } else {
                    System.out.printf("%6.1f", matrizDistanciaMinima[i][j]);
                }
            }
            System.out.println();
        }
    }
}
