package practicandoparcialayed.PracticaArbolBinario;

import practicandoparcialayed.Queue;

/**
 * Implemente la clase parcial com el siguiente metodo: colorearArbol (ArbolBinario string> arbol, integer MaxColor)
 *
 * Tecnica de resolucion: Recorrido por niveles, contanto la cantida de nodos. - Si la cant de nodos supera al max, los nodos restantes los pinto de verde - Niveles Impares: Negros - Niveles Pares: Rojos
 */
public class Parcial3 {

    public static void colorearArbol(BinaryTree<String> arbol, Integer MaxColor) {
        if (!arbol.isEmpty() && arbol != null) {
            helper(arbol, MaxColor);
        }
    }

    private static void helper(BinaryTree<String> arbol, Integer Max) {
        int nodosPorNivel = 0;
        int nivelActual = 1;
        BinaryTree<String> aux = null;
        Queue<BinaryTree<String>> cola = new Queue<>();
        cola.enqueue(arbol);
        cola.enqueue(null);
        while (!cola.isEmpty()) {
            aux = cola.dequeue();
            if (aux != null) 
            {
                nodosPorNivel++;
                pintarNodoActual(aux,nivelActual,Max,nodosPorNivel);
                if (aux.hasLeftChild()) cola.enqueue(aux.getLeftChild());
                if (aux.hasRightChild()) cola.enqueue(aux.getRightChild());
                System.out.print(aux.getData()+ " ");
            } else if (!cola.isEmpty()) {
                nivelActual++;
                nodosPorNivel = 0;
                cola.enqueue(null);
                System.out.println("");
            }
        }
    }

    private static void pintarNodoActual(BinaryTree<String> nodo, int nivelActual, int nodosMax, int nodosPorNivel) 
    {
        if (nodosPorNivel <= nodosMax) // pinto de rojo o negro segun el nivel
        {
            if (nivelActual %2 == 0) nodo.setData("Rojo");
            else nodo.setData("Negro");
        }
        // tengo que pintar de verde, porque en teoria la cantidad de nodos es mayor al max
        else  nodo.setData("Verde");
    }
    
      public static void main(String[] args) {
        System.out.println("Ejercicio Parcial 3: ");
        
        // creamos el arbol: 
        BinaryTree<String> raiz = new BinaryTree<>("Sin color"); 
        raiz.addLeftChild(new BinaryTree<>("Sin color"));
        raiz.addRightChild(new BinaryTree<>("Sin color"));
        // agrego hijos al subarbol izq
        raiz.getLeftChild().addLeftChild(new BinaryTree<>("Sin color"));
        raiz.getLeftChild().addRightChild(new BinaryTree<>("Sin color"));
        // agrego hijos al subarbol der
        raiz.getRightChild().addLeftChild(new BinaryTree<>("Sin color"));
        raiz.getRightChild().getLeftChild().addLeftChild(new BinaryTree<>("Sin color"));
        raiz.getRightChild().addRightChild(new BinaryTree<>("Sin color"));
        // este linea siguiente esta de mas. 
        raiz.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>("Sin color"));
        /*
                              "Sin color"  
                       /                     \
               "Sin color"                    "Sin color"
                  /    \                     /          \
       "Sin color"     "Sin color"   "Sin color"        "Sin color" 
               /                          /
    "Sin color"                   "Sin color"
        
        */
        Parcial3.colorearArbol(raiz, 3); 

    }
}
