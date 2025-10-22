package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    int numeroVertices;
    boolean direcionado;
    double [][] matrizAdjacencia;
    List<Aresta> arestas;

    public Grafo(int numeroVertices, boolean direcionado){
        this.numeroVertices = numeroVertices;
        this.direcionado = direcionado;
        matrizAdjacencia = new double[numeroVertices][numeroVertices];
        arestas = new ArrayList<>();

        // inicializa matriz adjacencia sem arestas
        for(int i=0; i<numeroVertices; i++){
            for(int j=0; j<numeroVertices; j++){
                if (i == j){
                    matrizAdjacencia[i][j] = 0.0;
                } else {
                    matrizAdjacencia[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }
    }

    public void addAresta(int vOrigem, int vDestino, double peso){
        matrizAdjacencia[vOrigem][vDestino] = peso;
        arestas.add(new Aresta(vOrigem,vDestino,peso));

        if (!direcionado){
            matrizAdjacencia[vDestino][vOrigem] = peso;
            arestas.add(new Aresta(vDestino,vOrigem,peso));
        }
    }

    public List<Aresta> getArestas(){
        return arestas;
    }

    public int getNumeroVertices(){
        return numeroVertices;
    }

    public double[][] getMatrizAdjacencia(){
        return matrizAdjacencia;
    }

    //imprimir arestas do grafo
    public void imprimirArestas(){
        System.out.println("Arestas do grafo: ");
        for (Aresta a : arestas){
            System.out.printf("%d -> %d (%.2f)%n", a.getOrigem(), a.getDestino(), a.getPeso());
        }
    }
}
