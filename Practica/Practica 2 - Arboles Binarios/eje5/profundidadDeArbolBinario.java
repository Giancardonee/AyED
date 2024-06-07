package Practica2.eje5;

import clases_genericas.BinaryTree;
import clases_genericas.Queue;

public class profundidadDeArbolBinario {

    private BinaryTree<Integer> arbol;

    public profundidadDeArbolBinario(BinaryTree a) {
        this.arbol = a;
    }
    
    
    //opcion 1: Usando Queue y BinaryTree
    public int sumaElementosProfundidad1(int profundidad) {
        if (this.arbol.isEmpty() || profundidad < 0) {
            return 0;
        } else {
            return suma1(profundidad);
        }
    }

    public int suma1(int profundidad) {
        int nivelAct = 0;
        int suma = 0;
        BinaryTree<Integer> a = null;
        Queue<BinaryTree<Integer>> cola = new Queue();
        cola.encolar(this.arbol);
        cola.encolar(null);
        while (!cola.isEmpty() && nivelAct <= profundidad) {
            a = cola.desencolar();
            if (a != null) {
                if (nivelAct == profundidad) {
                    suma += a.getData();
                }
                if (a.tieneHijoIzq()) {
                    cola.encolar(a.getHijoIZquierdo());
                }
                if (a.tieneHijoDer()) {
                    cola.encolar(a.getHijoDerecho());
                }
            } else {
                nivelAct++;
                if (!cola.isEmpty()) {
                    cola.encolar(null);// para avanzar al otro nivel
                }
            }
        }
        return suma;
    }

    
    // opcion 2: 
    public int sumaElementosProfundidad2(BinaryTree<Integer> a, int prof) {
        return sumarRecursivo(a, prof);
    }

    public int sumarRecursivo(BinaryTree<Integer> a, int prof) {
        if (a == null || a.isEmpty() || prof < 0) {
            return 0;
        }
        if (prof == 0) {
            return a.getData();
        }
        int nuevaProf = prof - 1;
        return sumarRecursivo(a.getHijoIZquierdo(), nuevaProf) + sumarRecursivo(a.getHijoDerecho(), nuevaProf);
    }

}
