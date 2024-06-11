/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicandoparcialayed;

import practicandoparcialayed.Queue;

public class BinaryTree<T> {

    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;

    public BinaryTree() {
        super();
    }

    public BinaryTree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * Preguntar antes de invocar si hasLeftChild()
     *
     * @return
     */
    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }

    /**
     * Preguntar antes de invocar si hasRightChild()
     *
     * @return
     */
    public BinaryTree<T> getRightChild() {
        return this.rightChild;
    }

    public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
    }

    public void removeLeftChild() {
        this.leftChild = null;
    }

    public void removeRightChild() {
        this.rightChild = null;
    }

    public boolean isEmpty() {
        return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() {
        return (!this.hasLeftChild() && !this.hasRightChild());

    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    @Override
    public String toString() {
        return this.getData().toString();
    }

    public int contarHojas() {
        return this.isEmpty() ? 0 : contarHojasAux();
    }

    private int contarHojasAux() {
        if (this.isLeaf()) {
            return 1;
        } else {
            int suma = 0;
            if (this.hasLeftChild()) {
                suma += this.getLeftChild().contarHojasAux();
            }
            if (this.hasRightChild()) {
                suma += this.getRightChild().contarHojasAux();
            }
            return suma;
        }
    }

    public void entreNiveles() {
        BinaryTree<T> aux = null;
        Queue<BinaryTree<T>> cola = new Queue<>();
        cola.enqueue(this);
        cola.enqueue(null);
        while (!cola.isEmpty()) {
            aux = cola.dequeue();
            if (aux != null) {
                if (aux.hasLeftChild()) {
                    cola.enqueue(aux.getLeftChild());
                }
                if (aux.hasRightChild()) {
                    cola.enqueue(aux.getRightChild());
                }
                System.out.print(aux.getData() + " ");
            } else if (!cola.isEmpty()) {
                System.out.println("");
                cola.enqueue(null);
            }
        }
    }

    
    /*
        Distintas variantes de devolver la altura
        la v2 es la mejor opcion. Ambas opciones son recorridos en profundidad
    
        Tambien se podria resolver en recorrido por niveles, de manera iterativa.
    */
    // en este modulo, agarro cada hijo de la raiz, y lo mando a que calcule cada uno su parte. Para desp sacar el max
    public int devolverAlturaMax() {
        if (this.isEmpty()) {
            return 0;
        } else {
            int alturaIzq = 0;
            int alturaDer = 0;
            if (this.hasLeftChild()) {
                alturaIzq = this.getLeftChild().devolverAlturaAux();
            }
            if (this.hasRightChild()) {
                alturaDer = this.getRightChild().devolverAlturaAux();
            }
            return Math.max(alturaDer, alturaIzq);
        }
    }

    public int devolverAlturaAux() {
        int sum = 0;
        if (this.hasLeftChild()) {
            sum += this.getLeftChild().devolverAlturaAux();
        }
        if (this.hasRightChild()) {
            sum += this.getRightChild().devolverAlturaAux();
        }
        sum++;
        return sum;
    }
    
    // Este enfoque es mas eficiente y aprovecha la recursividad mejor.
    public int devolverAlturaMaxV2() {
        return devolverAlturaAuxV2(this);
    }

    private int devolverAlturaAuxV2(BinaryTree<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        
        int alturaIzq = devolverAlturaAuxV2(nodo.getLeftChild());
        int alturaDer = devolverAlturaAuxV2(nodo.getRightChild());

        return 1 + Math.max(alturaIzq, alturaDer);
    }

}
