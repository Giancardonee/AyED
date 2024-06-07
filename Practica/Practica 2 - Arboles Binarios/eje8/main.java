/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2.eje8;

import clases_genericas.BinaryTree;

/**
 *
 * @author Usuario
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree<Integer> arbol1 = new BinaryTree<Integer>(10);
        arbol1.agregarHijoIzq(new BinaryTree(7)); // agrego hijo izquierdo
        arbol1.agregarHijoDer(new BinaryTree(20)); // agrego hijo derecho

        arbol1.getHijoIZquierdo().agregarHijoIzq(new BinaryTree(4));
        arbol1.getHijoIZquierdo().agregarHijoDer(new BinaryTree(9));

        arbol1.getHijoDerecho().agregarHijoDer(new BinaryTree(30));
        /*  El arbol1 quedaria asi: 
                  10 
                 /   \
                7     20 
               / \      \
              4   9      30
         */
        
       /*  El arbol2 quedaria asi: 
                  10 
                 /   \
                7     20 
               / \    / \
              4   9  4   30
         */
        
        BinaryTree<Integer> arbol2 = arbol1;
        arbol2.getHijoDerecho().agregarHijoIzq(new BinaryTree(4));
        System.out.println(ParcialArboles.esPrefijo(arbol1, arbol2));
        
        arbol1.getHijoDerecho().setData(5);
        /*  El arbol1 quedaria asi: 
                  10 
                 /   \
                7     5 
               / \      \
              4   9      30
         */
        System.out.println(ParcialArboles.esPrefijo(arbol1, arbol2));
    }
    
}
