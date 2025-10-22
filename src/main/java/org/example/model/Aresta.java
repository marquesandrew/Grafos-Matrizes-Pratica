package org.example.model;

public class Aresta {
    private  int origem;
    private  int destino;
    private  double peso;

    public Aresta(int origem, int destino, double peso){
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public int getOrigem(){
        return origem;
    }

    public int getDestino(){
        return destino;
    }

    public double getPeso(){
        return peso;
    }
}
