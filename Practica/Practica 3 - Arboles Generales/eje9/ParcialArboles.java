package Practica3.eje9;

import clases_genericas.GeneralTree;
import clases_genericas.Queue;
import java.util.Iterator;
import java.util.List;

public class ParcialArboles {

    public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
        if (arbol.isEmpty() || arbol == null || arbol.isLeaf()) {
            return false;
        } else {
            return helper2(arbol);
        }
    }

    /*
       ------- HELPER CON FOR 
       Esta manera de resolverlo con un for es ineficiente en el caso que se sepa 
    que no cumple la condicion, no corta y sigue procesando todo el arbol. Por eso, 
    esto deberia hacerse con un while.
     */
    
    private static boolean helper1(GeneralTree<Integer> a) {
        boolean result = true;
        if (a.isLeaf()) {
            return true;
        } else {
            int min = Integer.MAX_VALUE;
            List<GeneralTree<Integer>> children = a.getChildren();
            for (GeneralTree<Integer> child : children) {
                min = Math.min(min, child.getData());
                result = result && helper1(child);
            }
            if (min != a.getData()) {
                result = false;
            }
        }
        return result;
    }

    /*
        ------- HELPER CON WHILE 
        La idea de usar el while, es que no siga procesando todo el arbol si se encuentra un caso que no cumpla la condicion.
    */
    private static boolean helper2(GeneralTree<Integer> a) {
        if (a.isLeaf()) return true;

        int min = Integer.MAX_VALUE;
        List<GeneralTree<Integer>> children = a.getChildren();
        Iterator<GeneralTree<Integer>> iterador = children.iterator();
        boolean result = true; 
        while (iterador.hasNext() && result) { 
            GeneralTree<Integer> child = iterador.next();
            min = Math.min(min, child.getData());
            result = helper2(child);
        } 
  
        return ((result) && (min == a.getData())); 
    }
    
}
