package practicandoparcialayed.PracticaArbolBinario;

import java.util.LinkedList;
import java.util.List;

/*
    Devolver el camino a la hoja mas lejana. 
Si hubiese mas de un camino de igual longitud maxima, devolver el primero que encontremos.
*/
public class Parcial2 {
    
    
    public List<Integer> caminoMax (BinaryTree<Integer> arbol)
    {
        List<Integer> camMax = new LinkedList<>();
        if (arbol.isEmpty() || arbol == null) return camMax; // va a estar vacia
        else {
            helper(new LinkedList<Integer>(),camMax,arbol); 
            return camMax;
        }
    }
    
    private void helper( List<Integer> camAct, List<Integer> camMax,BinaryTree<Integer> arbol)
    {
        camAct.add(arbol.getData());
        if (!arbol.isLeaf()) // si no es hoja, hacemos llamada recursivas con los hijos que tenga
        {
            if (arbol.hasLeftChild())
                helper(camAct,camMax,arbol.getLeftChild());
            if (arbol.hasRightChild())
                helper(camAct,camMax,arbol.getRightChild());
           //camAct.remove(camAct.size()-1); 
        }
        else if (camAct.size() > camMax.size()) // si es hoja,y el camino actual supera al maximo, lo actualizamos
        {
            camMax.clear();
            camMax.addAll(camAct);
        }
        camAct.remove(camAct.size()-1); // al volver de la recursion, eliminamos uno en camino actual para que siempre este actualizada
    }
    
         public static void main(String[] args) {
        System.out.println("Ejercicio Parcial 2: ");
        
        // creamos el arbol: 
        BinaryTree<Integer> raiz = new BinaryTree<>(200); 
        raiz.addLeftChild(new BinaryTree<>(100));
        raiz.addRightChild(new BinaryTree<>(300));
        // agrego hijos al subarbol izq
        raiz.getLeftChild().addLeftChild(new BinaryTree<>(50));
        raiz.getLeftChild().addRightChild(new BinaryTree<>(150));
        // agrego hijos al subarbol der
        raiz.getRightChild().addLeftChild(new BinaryTree<>(251));
        raiz.getRightChild().getLeftChild().addLeftChild(new BinaryTree<>(230));
        raiz.getRightChild().addRightChild(new BinaryTree<>(351));
        // este linea siguiente esta de mas. 
        raiz.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(30));
        /*
                              200  
                       /             \
                    100               300
                  /    \             /   \
                 50     150       251    351 
               /                  /
             30                230
        */
        Parcial2 p2 = new Parcial2();
        List<Integer> ccaminoMax = p2.caminoMax(raiz);
        
        ccaminoMax.forEach((n) -> {
            System.out.print(n+" ");
        });

    }
}
