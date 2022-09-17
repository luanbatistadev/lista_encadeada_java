/**
 * Esta classe implementa uma lista encadeada
 * Basicamente cada nó contém um valor e aponta para o próximo
 */
// void addFirst(int valor) - Adicionar um elemento ao início da lista
// void addLast(int valor) - Adicionar um elemento ao fim da lista ( é só chamar
// o add que já foi feito)
// void add(int indice, int valor) - Adicionar na posição especificada pelo
// indice
public class ListaEncadeada {

    /**
     * Define um único nó ou elemento, que contém um valor int e aponta para outro
     * nó (que pode ser null)
     */
    public static class No {
        /** Valor salvo neste nó */
        public int valor;
        /** Referência ao próximo */
        public No proximo;

        public No(int valor) {
            this.valor = valor;
        }
    }

    public No inicio;

    public int getFirst() {
        return inicio.valor;
    }

    public void addLast(int valor) {
        No novo = new No(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            No aux = inicio;
            while (aux.proximo != null) {
                aux = aux.proximo;
            }
            aux.proximo = novo;
        }
    }

    public void add(int indice, int valor) {
        No novo = new No(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            No aux = inicio;
            int cont = 0;
            while (aux.proximo != null && cont < indice) {
                aux = aux.proximo;
                cont++;
            }
            novo.proximo = aux.proximo;
            aux.proximo = novo;
        }
    }

    public int get(int indice) {
        No aux = inicio;
        for (int i = 0; i < indice; i++) {
            aux = aux.proximo;
        }
        return aux.valor;
    }

    public int getLast() {
        No aux = inicio;
        while (aux.proximo != null) {
            aux = aux.proximo;
        }
        return aux.valor;
    }

    public int set(int indice, int valor) {
        No no = inicio;
        int valorAnterior = 0;
        for (int i = 0; i < indice; i++) {
            no = no.proximo;
        }
        valorAnterior = no.valor;
        no.valor = valor;
        return valorAnterior;
    }

    public void clear() {
        inicio = null;
    }

    public int size() {
        int tamanho = 0;
        No aux = inicio;
        while (aux != null) {
            tamanho++;
            aux = aux.proximo;
        }
        return tamanho;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public int removeFirst() {
        int valor = inicio.valor;
        inicio = inicio.proximo;
        return valor;
    }

    public int removeLast() {
        No no = inicio;
        while (no.proximo.proximo != null) {
            no = no.proximo;
        }
        int valor = no.proximo.valor;
        no.proximo = null;
        return valor;
    }

    public int remove(int indice) {
        No no = inicio;
        for (int i = 0; i < indice - 1; i++) {
            no = no.proximo;
        }
        int valor = no.proximo.valor;
        no.proximo = no.proximo.proximo;
        return valor;
    }

    public int lastIndexOf(int valor) {
        int posicao = -1;
        int contador = 0;
        No no = inicio;
        while (no != null) {
            if (no.valor == valor) {
                posicao = contador;
            }
            no = no.proximo;
            contador++;
        }
        return posicao;
    }

    public void addFirst(int valor) {
        No novo = new No(valor);
        novo.proximo = inicio;
        inicio = novo;
    }

    public boolean contains(int valor) {
        No atual = inicio;
        while (atual != null) {
            if (atual.valor == valor) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public int indexOf(int valor) {
        No atual = inicio;
        int posicao = 0;
        while (atual != null) {
            if (atual.valor == valor) {
                return posicao;
            }
            atual = atual.proximo;
            posicao++;
        }
        return -1;
    }

    /**
     * Atravessa cada elemento da lista, escrevendo-os na tela
     */
    public void exibirLista() {
        No atual = inicio;
        while (atual != null) {
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
    }

    /**
     * Método principal, usado aqui para testar a minha implementação da
     * ListaEncadeada
     */
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.addLast(-1);
        lista.addLast(-3);
        lista.addLast(-5);
        lista.addLast(-7);
        lista.addLast(100);
        lista.addLast(200);
        lista.addLast(300);
        lista.addLast(400);
        lista.addLast(500);
        lista.addLast(600);
        lista.addLast(700);
        //
        lista.exibirLista();
        //Acessar Elementos
        System.out.println(lista.get(3));
        System.out.println(lista.getFirst());
        System.out.println(lista.getLast());
        //Encontrar Elementos
        System.out.println(lista.contains(700));
        System.out.println(lista.lastIndexOf(700));
        System.out.println(lista.indexOf(-1));
        //Informações e controle
        System.out.println(lista.size());
        System.out.println(lista.isEmpty());
        System.out.println(lista.set(7, 800));
        lista.clear();
        //Adicionando todos os elementos novamente
        lista.addLast(-1);
        lista.addLast(-3);
        lista.addLast(-5);
        lista.addLast(-7);
        lista.addLast(100);
        lista.addLast(200);
        lista.addLast(300);
        lista.addLast(400);
        lista.addLast(500);
        lista.addLast(600);
        lista.addLast(700);
        //Remover Elementos
        System.out.println(lista.remove(1));
        System.out.println(lista.removeLast());
        System.out.println(lista.removeFirst());
    }
}
