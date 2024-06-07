/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2.eje6;

import clases_genericas.BinaryTree;

public class main {
    public static void main(String[] args) {
        
        BinaryTree <Integer> raiz = new BinaryTree(1);
        raiz.agregarHijoIzq(new BinaryTree<>(2));
        raiz.getHijoIZquierdo().agregarHijoDer(new BinaryTree<>(4));
    
        BinaryTree <Integer> subDer = new BinaryTree<>(3);
        
        BinaryTree<Integer> subDer2 = new BinaryTree<>(5);
        subDer2.agregarHijoIzq(new BinaryTree <> (7));
        subDer2.agregarHijoDer(new BinaryTree<> (8));
        
        subDer.agregarHijoDer(new BinaryTree<>(6));
        subDer.agregarHijoIzq(subDer2);
        raiz.agregarHijoDer(subDer);
        
        
        raiz.entreNivelesCatedra(0, 3);
        Transformacion eje6 = new Transformacion(raiz);
        
        System.out.println("Transformando devolviendo otro arbol");
        BinaryTree <Integer> arbolNuevo = eje6.suma2();
        
        arbolNuevo.entreNivelesCatedra(0,3);
        
        System.out.println("Transformando sobre el mismo arbol:");
        //Transformacion eje6 = new Transformacion(raiz);
        eje6.suma();
        
        eje6.entreNivelesCatedra(0,3);
        
    }
    
}
