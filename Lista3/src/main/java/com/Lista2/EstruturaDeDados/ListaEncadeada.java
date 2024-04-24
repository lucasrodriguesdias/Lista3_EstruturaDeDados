package com.Lista2.EstruturaDeDados;

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
        Nodo nodo = new Nodo();
        nodo.setNumero(elemento);
        nodo.setProximo(primeiro);
        primeiro = nodo;
        tamanho++;
    }

    // Método para inserir um elemento no fim da lista
    public void inserirFim(int elemento) {
        Nodo nodo = new Nodo();
        nodo.setNumero(elemento);
        if (primeiro == null) {
            nodo.setProximo(null);
            primeiro = nodo;
        } else {
            Nodo aux = primeiro;
            while (aux.getProximo() != null) {
                aux = aux.getProximo();
            }
            aux.setProximo(nodo);
            nodo.setProximo(null);
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
        }
        else if (posicao == tamanho){
            inserirFim(elemento);
        }
        else {
            Nodo nodo = new Nodo();
            nodo.setNumero(elemento);
            Nodo aux = primeiro;
            for (int i = 0; i < posicao - 1; i++) {
                aux = aux.getProximo();
            }
            nodo.setProximo(aux.getProximo());
            aux.setProximo(nodo);
            tamanho++;
        }
    }

    // Método para remover um elemento no início da lista
    public Integer removerInicio() {
        if (primeiro == null) {
            return null;
        }
        else{
            int info = primeiro.getNumero();
            primeiro = primeiro.getProximo();
            tamanho--;

            return  info;
        }
    }

    // Método para remover um elemento no fim da lista
    public Integer removerFim() {
        if (primeiro == null) {
            return null;
        }
        else {
            Nodo aux = primeiro;
            Nodo anteriorAux = null;
            while (aux.getProximo() != null) {
                anteriorAux = aux;
                aux = aux.getProximo();
                }
            anteriorAux.setProximo(null);
            tamanho--;
            return aux.getNumero();
            }
        }



    // Método para remover um elemento em uma posição específica da lista
    public Integer removerPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        if (posicao == 0) {
            return removerInicio();
        } else {
            Nodo aux = primeiro;
            Nodo anteriorAux = null;
            for (int i = 0; i < posicao; i++) {
                anteriorAux = aux;
                aux = aux.getProximo();
            }
            int info = aux.getNumero();
            anteriorAux.setProximo(aux.getProximo());
            tamanho--;

            return info;
        }
    }

    // Método para remover um elemento específico da lista
    public void removerElemento(int elemento) {
        Nodo aux = primeiro;
        Nodo anteriorAux = null;

        while (aux != null && aux.getNumero() != elemento) {
            anteriorAux = aux;
            aux = aux.getProximo();
        }

        if (aux != null) {
            if (anteriorAux == null) {
                primeiro = aux.getProximo();
            } else {
                anteriorAux.setProximo(aux.getProximo());
            }
            tamanho--;
        }
    }

    // Método para exibir o conteúdo da lista
    public void exibir() {
        Nodo aux = primeiro;
        System.out.print("[");
        while (aux != null) {
            System.out.print(aux.getNumero());
            if (aux.getProximo() != null) {
                System.out.print(", ");
            }
            aux = aux.getProximo();
        }
        System.out.println("]");
    }

    // Método para pesquisar por um elemento específico em uma lista e informar sua posição
    public void pesquisar(int elemento) {
        Nodo aux = primeiro;
        int posicao = 0;
        while (aux != null && aux.getNumero() != elemento) {
            aux = aux.getProximo();
            posicao++;
        }
        if (aux != null) {
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

