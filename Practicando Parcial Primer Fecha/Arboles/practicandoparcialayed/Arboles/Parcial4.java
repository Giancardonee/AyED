package practicandoparcialayed.Arboles;

import practicandoparcialayed.BinaryTree;
import practicandoparcialayed.Queue;

public class Parcial4 {
    
    public static boolean esArbolCreciente (BinaryTree<Integer>arbol)
    {
        return ( arbol.isEmpty() || arbol == null)? false : nivelesHelper(arbol);
    }
    
    //nodosNivelAux1 = contador de nodos 
    //nodosNivelAux2 = contador de nodos del siguiente nivel
    private static boolean nivelesHelper(BinaryTree<Integer >arbol)
    {
        boolean cumple = true; 
        int nodosNivelAux1=0; 
        int nodosNivelAux2 = 0;
        BinaryTree<Integer> aux;
        Queue<BinaryTree<Integer>> cola = new Queue<>();
        cola.enqueue(arbol);
        cola.enqueue(null);
        while (!cola.isEmpty() && cumple)
        {
            System.out.println("NodoAux1: "+nodosNivelAux1);
            System.out.println("NodoAux2: "+nodosNivelAux2);
            aux = cola.dequeue();
            if (aux != null){
                nodosNivelAux2++;
                if (aux.hasLeftChild()) cola.enqueue(aux.getLeftChild());
                if (aux.hasRightChild()) cola.enqueue(aux.getRightChild());
            }
            else {
                cumple = (( nodosNivelAux1 +1) == nodosNivelAux2);
                if (!cola.isEmpty() && cumple){
                    nodosNivelAux1=nodosNivelAux2;
                    nodosNivelAux2=0;
                    cola.enqueue(null);
                }
            }
        }
        return cumple;
    }
      public static void main(String[] args) 
      {
        BinaryTree<Integer> raiz = new BinaryTree<>(2);
        raiz.addLeftChild(new BinaryTree <>(7));
        raiz.addRightChild(new BinaryTree<>(5));
        // HI y HD del 7
        raiz.getLeftChild().addLeftChild(new BinaryTree<>(2));
        raiz.getLeftChild().addRightChild(new BinaryTree<>(6));
        // HD del 5
        raiz.getRightChild().addRightChild(new BinaryTree<>(9));
        //raiz.getRightChild().addLeftChild(new BinaryTree<>(33)); si descomentamos esto, nos devuelve FALSE 
        /*
                 2
               /   \
             7      5
            / \       \
          2    6       9
        */
          System.out.println(Parcial4.esArbolCreciente(raiz)); // con el arbol asi como esta, devuelve true :)    
      }
}

