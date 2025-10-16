package org.example;

import org.example.model.GrafoNaoDirecionado;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Kruskal {

    //classe auxiliar Union-Find
    static class SubConjunto {
        int pai, rank;
    }

    //contra o pai de um elemento com compressao de caminho
    private static int find(SubConjunto[] subConjuntos, int i) {
        if (subConjuntos[i].pai != i)
            subConjuntos[i].pai = find(subConjuntos, subConjuntos[i].pai);
        return subConjuntos[i].pai;
    }

    //unicao de dois subconjuntos por rank
    private static void union(SubConjunto[] subConjuntos, int x, int y) {
        int raizX = find(subConjuntos, x);
        int raizY = find(subConjuntos, y);

        if (subConjuntos[raizX].rank < subConjuntos[raizY].rank) {
            subConjuntos[raizX].pai = raizY;
        } else if (subConjuntos[raizX].rank > subConjuntos[raizY].rank) {
            subConjuntos[raizY].pai = raizX;
        } else {
            subConjuntos[raizY].pai = raizX;
            subConjuntos[raizX].rank++;
        }
    }

    //kruskal
    public static void encontrarMST(GrafoNaoDirecionado grafo) {
        List<GrafoNaoDirecionado.Aresta> arestas = new ArrayList<>(grafo.getArestas());
        int numeroVertices = grafo.getNumeroVertices();

        //Ordena arestas por peso menor -> maior
        arestas.sort(Comparator.comparingDouble(GrafoNaoDirecionado.Aresta::getPeso));

        //cria subconjuntos
        SubConjunto[] subConjuntos = new SubConjunto[numeroVertices];
        for (int i = 0; i < numeroVertices; ++i) {
            subConjuntos[i] = new SubConjunto();
            subConjuntos[i].pai = i;
            subConjuntos[i].rank = 0;
        }

        List<GrafoNaoDirecionado.Aresta> resultado = new ArrayList<>();
        double custoTotal = 0.0;

        //Itera sobre arestas ordenadas
        for (GrafoNaoDirecionado.Aresta aresta : arestas) {
            int x = find(subConjuntos, aresta.getOrigem());
            int y = find(subConjuntos, aresta.getDestino());

            //se não for cliclo, acidiona na arvore
            if (x != y) {
                resultado.add(aresta);
                custoTotal += aresta.getPeso();
                union(subConjuntos, x, y);
            }
            //se ja tem v-1 arestas, break
            if (resultado.size() == numeroVertices - 1) {
                break;
            }
        }

        //imprime resultado
        System.out.println("Arestas MST Kruskal");
        System.out.println("Aresta\tPeso");
        for (GrafoNaoDirecionado.Aresta aresta: resultado){
            System.out.printf("%d - %d\t%.2f%n", aresta.getOrigem(), aresta.getDestino(), aresta.getPeso());
        }
        System.out.printf("\nCusto Total: %.2f%n", custoTotal);
    }
}