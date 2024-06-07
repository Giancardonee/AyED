package Practica2.eje4;

import clases_genericas.BinaryTree;

public class RedBinariaLlena {

    private BinaryTree<Integer> red;

    public RedBinariaLlena(BinaryTree<Integer> unArbol) {
        this.red = unArbol;
    }

    public int retardoReenvio() {
        return !red.isEmpty() ? calcularRetardoRecursivo(red) : -1;
    }

    private int calcularRetardoRecursivo(BinaryTree<Integer> a) {
        int HI = 0;
        int HD = 0;
        if (a.esHoja()) {
            return a.getData();
        } else {
            if (a.tieneHijoIzq()) {
                HI = calcularRetardoRecursivo(a.getHijoIZquierdo());
            }
            if (a.tieneHijoDer()) {
                HD = calcularRetardoRecursivo(a.getHijoDerecho());
            }
            return (Math.max(HI, HD) + a.getData());
        }
    }

}
