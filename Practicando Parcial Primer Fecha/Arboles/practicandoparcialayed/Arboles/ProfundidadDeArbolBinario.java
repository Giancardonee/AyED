/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicandoparcialayed.Arboles;

import practicandoparcialayed.BinaryTree;
import practicandoparcialayed.Queue;

public class ProfundidadDeArbolBinario {

    private BinaryTree<Integer> arbol;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> a) {
        this.arbol = a;
    }

    public int sumaElementosProfundidad(int p) {
        if (this.arbol.isEmpty()) {
            return 0;
        } else if (this.arbol.isLeaf()) {
            return this.arbol.getData();
        } else {
            return sumarProfundidad(p);
        }
    }

    private int sumarProfundidad(int profundidadBuscada) {
        int sumaProfundidad = 0;
        int profundidadActual = 0;
        BinaryTree<Integer> aux = null;
        Queue<BinaryTree<Integer>> cola = new Queue<>();
        cola.enqueue(this.arbol);
        cola.enqueue(null);
        while ((!cola.isEmpty()) && (profundidadActual <= profundidadBuscada)) {
            aux = cola.dequeue();
            if (aux != null) {
                if (profundidadActual == profundidadBuscada) {
                    sumaProfundidad += aux.getData();
                } else {
                    if (aux.hasLeftChild()) {
                        cola.enqueue(aux.getLeftChild());
                    }
                    if (aux.hasRightChild()) {
                        cola.enqueue(aux.getRightChild());
                    }
                }
            }
            else if (!cola.isEmpty())
            {
                profundidadActual++;
                cola.enqueue(null);
            }
        }
        return sumaProfundidad;
    }

}
