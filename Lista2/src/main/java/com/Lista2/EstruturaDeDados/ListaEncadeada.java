package com.Lista2.EstruturaDeDados;

import org.w3c.dom.Node;

public class ListaEncadeada {
    private Nodo primeiro;
    private int tamanho;

    // Método para criar uma lista vazia
    public ListaEncadeada() {
        this.primeiro = null;
        this.tamanho = 0;
    }

    // Método para inserir um elemento no início da lista
    public void inserirInicio(int elemento) {
        Nodo novoNodo = new Nodo();
        novoNodo.setNumeros(elemento);
        novoNodo.setProximo(primeiro);
        primeiro = novoNodo;
        tamanho++;
    }

    // Método para inserir um elemento no fim da lista
    public void inserirFim(int elemento) {
        Nodo novoNodo = new Nodo();
        novoNodo.setNumeros(elemento);
        if (primeiro == null) {
            primeiro = novoNodo;
        } else {
            Nodo atual = primeiro;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNodo);
        }
        tamanho++;
    }

    // Método para inserir um elemento em uma posição específica da lista
    public void inserirPosicao(int posicao, int elemento) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        if (posicao == 0) {
            inserirInicio(elemento);
        } else {
            Nodo novoNodo = new Nodo();
            novoNodo.setNumeros(elemento);
            Nodo anterior = primeiro;
            for (int i = 0; i < posicao - 1; i++) {
                anterior = anterior.getProximo();
            }
            novoNodo.setProximo(anterior.getProximo());
            anterior.setProximo(novoNodo);
            tamanho++;
        }
    }

    // Método para remover um elemento no início da lista
    public void removerInicio() {
        if (primeiro != null) {
            primeiro = primeiro.getProximo();
            tamanho--;
        }
    }

    // Método para remover um elemento no fim da lista
    public void removerFim() {
        if (primeiro != null) {
            if (primeiro.getProximo() == null) {
                primeiro = null;
            } else {
                Nodo atual = primeiro;
                Nodo anterior = null;
                while (atual.getProximo() != null) {
                    anterior = atual;
                    atual = atual.getProximo();
                }
                anterior.setProximo(null);
            }
            tamanho--;
        }
    }

    // Método para remover um elemento em uma posição específica da lista
    public void removerPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        if (posicao == 0) {
            removerInicio();
        } else {
            Nodo atual = primeiro;
            Nodo anterior = null;
            for (int i = 0; i < posicao; i++) {
                anterior = atual;
                atual = atual.getProximo();
            }
            anterior.setProximo(atual.getProximo());
            tamanho--;
        }
    }

    // Método para remover um elemento específico da lista
    public void removerElemento(int elemento) {
        Nodo atual = primeiro;
        Nodo anterior = null;

        while (atual != null && atual.getNumeros() != elemento) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual != null) {
            if (anterior == null) {
                primeiro = atual.getProximo();
            } else {
                anterior.setProximo(atual.getProximo());
            }
            tamanho--;
        }
    }

    // Método para exibir o conteúdo da lista
    public void exibir() {
        Nodo atual = primeiro;
        System.out.print("[");
        while (atual != null) {
            System.out.print(atual.getNumeros());
            if (atual.getProximo() != null) {
                System.out.print(", ");
            }
            atual = atual.getProximo();
        }
        System.out.println("]");
    }

    // Método para pesquisar por um elemento específico em uma lista e informar sua posição
    public void pesquisar(int elemento) {
        Nodo atual = primeiro;
        int posicao = 0;
        while (atual != null && atual.getNumeros() != elemento) {
            atual = atual.getProximo();
            posicao++;
        }
        if (atual != null) {
            System.out.println("O elemento " + elemento + " está na posição " + posicao + " da lista.");
        } else {
            System.out.println("O elemento " + elemento + " não está na lista.");
        }
    }

    // Método que retorna o número de elementos existentes na lista
    public int tamanho() {
        return tamanho;
    }

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.inserirInicio(10);
        lista.inserirFim(20);
        lista.inserirPosicao(1, 15);
        lista.exibir();

        lista.removerInicio();
        lista.removerFim();
        lista.removerPosicao(0);
        lista.exibir();

        lista.inserirInicio(5);
        lista.inserirFim(25);
        lista.inserirPosicao(2, 30);
        lista.exibir();

        lista.removerElemento(30);
        lista.exibir();

        lista.pesquisar(15);
        lista.pesquisar(30);

        System.out.println("Número de elementos na lista: " + lista.tamanho());
    }
}

