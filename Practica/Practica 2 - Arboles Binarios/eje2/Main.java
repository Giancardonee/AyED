package Practica2.eje2;

import clases_genericas.BinaryTree;

public class Main {

    public static void main(String[] args) {

        BinaryTree<Integer> arbol = new BinaryTree<Integer>(10);
        arbol.agregarHijoIzq(new BinaryTree(7)); // agrego hijo izquierdo
        arbol.agregarHijoDer(new BinaryTree(20)); // agrego hijo derecho

        arbol.getHijoIZquierdo().agregarHijoIzq(new BinaryTree(4));
        arbol.getHijoIZquierdo().agregarHijoDer(new BinaryTree(9));

        arbol.getHijoDerecho().agregarHijoDer(new BinaryTree(30));

        //Ejercicio 2
        System.out.println("Cantidad de hojas con metodo1: ");
        System.out.println(arbol.contarHojas1());
        
        System.out.println("Cantidad de hojas con metdo2: ");
        System.out.println(arbol.contarHojas2());
        
        /*  El arbol quedaria asi: 
                  10 
              /       \
             7         20 
            / \        / \
           4   9      17   30
        
        Por lo tanto, 4 , 9 y 30 son hojas. Por eso imprime 3
         */

        // Imprimimos el arbol antes de espejarlo.
        System.out.println("Sin espejar: ");
        arbol.imprimirPreOrden();
        
        BinaryTree espejo1 = arbol.espejo1();
        System.out.println("Espejado con metodo1:");
        
        espejo1.imprimirPreOrden();
        
        BinaryTree espejo2 = arbol.espejo2();
        System.out.println("Espejado con metodo 2:");
        espejo2.imprimirPreOrden();
        
        System.out.println("Entre niveles: ");
        arbol.entreNivelesModularizado(0, 2);
       
       
        
        
    }

}
