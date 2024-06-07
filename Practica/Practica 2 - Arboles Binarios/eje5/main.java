package Practica2.eje5;

import clases_genericas.BinaryTree;

public class main {
    public static void main(String[] args) {
                       
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(10);
        arbol.agregarHijoIzq(new BinaryTree(7)); // agrego hijo izquierdo
        arbol.agregarHijoDer(new BinaryTree(20)); // agrego hijo derecho

        arbol.getHijoIZquierdo().agregarHijoIzq(new BinaryTree(4));
        arbol.getHijoIZquierdo().agregarHijoDer(new BinaryTree(9));

        arbol.getHijoDerecho().agregarHijoDer(new BinaryTree(30));
        /*  El arbol quedaria asi: 
                  10 
                 /   \
                7     20 
               / \      \
              4   9      30
         */
           profundidadDeArbolBinario eje5 = new profundidadDeArbolBinario(arbol);
           System.out.println(eje5.sumaElementosProfundidad1(2));
           
           System.out.println(eje5.sumaElementosProfundidad2(arbol, 2));
           
           
    }
    
}
