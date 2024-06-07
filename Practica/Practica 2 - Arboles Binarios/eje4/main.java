package Practica2.eje4;

import clases_genericas.BinaryTree;



public class main {
    public static void main(String[] args) {
       /* para este tipo de ejercicios, nos conviene hacer el
       recorrido por profundidad, ya que nos interesa saber el mayor retardo 
       */ 
        BinaryTree<Integer> raiz = new BinaryTree(50);
        
        BinaryTree<Integer> subArbIzq = new BinaryTree(40);
        subArbIzq.agregarHijoIzq(new BinaryTree (30)); 
        subArbIzq.agregarHijoDer(new BinaryTree(45));

        BinaryTree <Integer> subArbDer = new BinaryTree(60);
        subArbDer.agregarHijoIzq(new BinaryTree (30));
        subArbDer.agregarHijoDer(new BinaryTree (24)); 

        
        raiz.agregarHijoDer(subArbDer);
        raiz.agregarHijoIzq(subArbIzq);
        
        /*
            50
           /  \
         40    60
         / \   / \
        30 45 30 24 
        Esta bien que retorne el retardo maximo 140
        */

        RedBinariaLlena red = new RedBinariaLlena(raiz);
        System.out.println("El mayor retardo es: "+red.retardoReenvio());
            
    }
        
       
 }

    
    

