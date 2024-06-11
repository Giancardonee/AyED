/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicandoparcialayed.Arboles;

import practicandoparcialayed.BinaryTree;


/**
 *
 * @author Usuario
 */
public class PracticandoParcialAyED {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // creamos el arbol: 
        BinaryTree<Integer> raiz = new BinaryTree<>(200); 
        raiz.addLeftChild(new BinaryTree<>(100));
        raiz.addRightChild(new BinaryTree<>(300));
        // agrego hijos al subarbol izq
        raiz.getLeftChild().addLeftChild(new BinaryTree<>(50));
        raiz.getLeftChild().addRightChild(new BinaryTree<>(150));
        // agrego hijos al subarbol der
        raiz.getRightChild().addLeftChild(new BinaryTree<>(250));
        raiz.getRightChild().addRightChild(new BinaryTree<>(350));
        // este linea siguiente esta de mas. 
        raiz.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(30));
        /*
                           200
                       /         \
                    100          300
                  /    \        /   \
                 50     150    250   350 
               /
             30     
        */
        
        // ===> Imprimimos entre niveles
        raiz.entreNiveles();
        
        // Distintas formas de calcular la altura maxima. 
        System.out.println("Altura Maxima: "+raiz.devolverAlturaMax());
        System.out.println("Altura Maxima v2: "+raiz.devolverAlturaMaxV2());
        
        // Eje4
        RedBinariaLlena eje4 = new RedBinariaLlena(raiz);
        System.out.println("Eje 4 ==> Retardo maximo: "+eje4.RetardoReenvio());
        
        // Eje5
        ProfundidadDeArbolBinario eje5 = new ProfundidadDeArbolBinario(raiz);
        int profundidad = 1; 
        System.out.println("Eje 5 ===> Suma de la profundidad "+profundidad+" :"+eje5.sumaElementosProfundidad(profundidad));
        
        // Eje7
        
        Eje7PracticaBinario eje7 = new Eje7PracticaBinario(raiz);
        System.out.println("Eje 7: " + eje7.isLeftTree(150));
        
    }
    
}
