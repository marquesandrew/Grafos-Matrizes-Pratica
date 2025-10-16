package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class GrafoNaoDirecionado {
    int numeroVertices;
    int [][] matrizAdjacencia;
    List<Aresta> arestas;

    public GrafoNaoDirecionado(int numeroVertices){
        this.numeroVertices = numeroVertices;
        matrizAdjacencia = new int[numeroVertices][numeroVertices];
        arestas = new ArrayList<>();

        // inicializa matriz adjacencia sem arestas
        for(int i=0; i<numeroVertices; i++){
            for(int j=0; j<numeroVertices; j++){
                matrizAdjacencia[i][j] = (i == j) ? 0 : Integer.MAX_VALUE / 2;
            }
        }
    }
    public void addAresta(int vOrigem, int vDestino, int peso){
        matrizAdjacencia[vOrigem][vDestino] = peso;
        matrizAdjacencia[vDestino][vOrigem] = peso;
        arestas.add(new Aresta(vOrigem, vDestino, peso));
    }

    static class Aresta{
        int vOrigem, vDestino, peso;
        Aresta(int vOrigem, int vDestino, int peso){
            this.vOrigem = vOrigem;
            this.vDestino = vDestino;
            this.peso = peso;
        }
    }


    public int getNumeroVertices(){
        return numeroVertices;
    }

    public int[][] getMatrizAdjacencia(){
        return matrizAdjacencia;
    }
}
