/* 
    Devolver el camino a la hoja mas lejana.
 */
package parciales.Parcial5;

import java.util.LinkedList;
import java.util.List;
import parciales.ClasesGenericas.BinaryTree;
import parciales.ClasesGenericas.GeneralTree;

public class CaminoHojaMasLejana {

    // con arbol binario.
    public static List<Integer> caminoMasLejano(BinaryTree<Integer> arbol) {
        List<Integer> caminoMax = new LinkedList<>();
        if (arbol != null && !arbol.isEmpty()) {
            buscarCamino(arbol, caminoMax, new LinkedList<Integer>());
        }
        return caminoMax;
    }

    private static void buscarCamino(BinaryTree<Integer> arbol, List<Integer> caminoMax, List<Integer> caminoActual) {
        caminoActual.add(arbol.getData());
        if (arbol.isLeaf()) {
            if (caminoActual.size() > caminoMax.size()) {
                caminoMax.clear();
                caminoMax.addAll(caminoActual);
            }
        } else {
            if (arbol.hasLeftChild()) {
                buscarCamino(arbol.getLeftChild(), caminoMax, caminoActual);
            }
            if (arbol.hasRightChild()) {
                buscarCamino(arbol.getRightChild(), caminoMax, caminoActual);
            }
        }
        // eliminamos el ultimo elemento al volver de la recursion, asi tenemos el camino actual, actualizado
        caminoActual.remove(caminoActual.size() - 1);
    }

    // con arbol general
    public static List<Integer> buscarCamino(GeneralTree<Integer> arbol) {
        List<Integer> caminoMax = new LinkedList<Integer>();
        if (arbol != null && !arbol.isEmpty())
            buscarCamino(arbol,caminoMax,new LinkedList<Integer>());
        return caminoMax;
    }
    
    private static void buscarCamino(GeneralTree<Integer> arbol, List<Integer> caminoMax, List<Integer> caminoActual)
    {
        caminoActual.add(arbol.getData());
        if (arbol.isLeaf())
        {
            if (caminoActual.size() > caminoMax.size())
            {
                caminoMax.clear();
                caminoMax.addAll(caminoActual);
            }
        }
        else
        {
            for (GeneralTree<Integer> child : arbol.getChildren())
            {
                buscarCamino(child,caminoMax,caminoActual);
            }
        }
        caminoActual.remove(caminoActual.size() -1); 
    }
    
    
    
}
