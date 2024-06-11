package practicandoparcialayed.Arboles;

import practicandoparcialayed.BinaryTree;
import java.util.LinkedList;
import java.util.List;

/**
 * Devolver una lista con todos los nodos hojas del arbol, que superen a un valor indicado por parametro y que sean impares
 */
public class PracticandoEjercicios1 {
    
    
    public static List<BinaryTree<Integer>> devolverNodos (BinaryTree<Integer> arbol,int valor)
    {
        List<BinaryTree<Integer>> listaReturn = new LinkedList<>();
        if (arbol != null && !arbol.isEmpty()) helper(arbol,valor,listaReturn);
        return listaReturn;
    }
    
    private static void helper(BinaryTree<Integer> arbol, int valor,List<BinaryTree<Integer>> lista)
    {
        if (cumpleCondicionParaAgregar(arbol, valor))
            lista.add(arbol);
        if (arbol.hasLeftChild()) helper(arbol.getLeftChild(), valor, lista);
        if (arbol.hasRightChild()) helper(arbol.getRightChild(),valor,lista);
    }
    
    private static boolean cumpleCondicionParaAgregar(BinaryTree<Integer> arbol, int valor) 
    {
        return ( (arbol.isLeaf() && arbol.getData() > valor) && (arbol.getData() % 2 != 0));
    }
}
