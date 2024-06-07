package Practica2.eje7;
import clases_genericas.BinaryTree;
public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> raiz = new BinaryTree(50);
        
        BinaryTree<Integer> subArbIzq = new BinaryTree(40);
        subArbIzq.agregarHijoIzq(new BinaryTree (21)); 
        subArbIzq.agregarHijoDer(new BinaryTree(45));

        BinaryTree <Integer> subArbDer = new BinaryTree(60);
        subArbDer.agregarHijoIzq(new BinaryTree (30));
        subArbDer.agregarHijoDer(new BinaryTree (24)); 
        subArbDer.getHijoIZquierdo().agregarHijoIzq(new BinaryTree(20));
        
        raiz.agregarHijoDer(subArbDer);
        raiz.agregarHijoIzq(subArbIzq);
        
        ParcialArboles eje7 = new ParcialArboles(raiz);
        System.out.println(eje7.isLeftTree(60));
        
        /* ESTE ES EL ARBOL QUE CREE. 
               50
           /        \
         40          60
         / \         / \
       21  45      30   24 
                  /
                20 
        */
    }
    /*
        Con el unico que deberia dar true en este caso, es con el numero 60. 
      Funciona, lo tengo que consultar en alguna practica :) 
    */
}
