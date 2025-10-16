package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class GrafoNaoDirecionado {
    int numeroVertices;
    double [][] matrizAdjacencia;
    List<Aresta> arestas;

    public GrafoNaoDirecionado(int numeroVertices){
        this.numeroVertices = numeroVertices;
        matrizAdjacencia = new double[numeroVertices][numeroVertices];
        arestas = new ArrayList<>();

        // inicializa matriz adjacencia sem arestas
        for(int i=0; i<numeroVertices; i++){
            for(int j=0; j<numeroVertices; j++){
                matrizAdjacencia[i][j] = (i == j) ? 0 : Double.POSITIVE_INFINITY /2;
            }
        }
    }
    public void addAresta(int vOrigem, int vDestino, double peso){
        matrizAdjacencia[vOrigem][vDestino] = peso;
        matrizAdjacencia[vDestino][vOrigem] = peso;
        arestas.add(new Aresta(vOrigem, vDestino, peso));
    }

    static class Aresta{
        int vOrigem, vDestino;
        double peso;
        Aresta(int vOrigem, int vDestino, double peso){
            this.vOrigem = vOrigem;
            this.vDestino = vDestino;
            this.peso = peso;
        }
    }


    public int getNumeroVertices(){
        return numeroVertices;
    }

    public double[][] getMatrizAdjacencia(){
        return matrizAdjacencia;
    }

    public double getPeso(){
        return peso;
    }
}
