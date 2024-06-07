package Practica3.eje10;

import clases_genericas.GeneralTree;
import java.util.LinkedList;
import java.util.List;

public class ParcialArboles {

    public static List<Integer> resolver(GeneralTree<Integer> arbol) {
        List<Integer> caminoMax = new LinkedList<>();
        if ((arbol != null) || !arbol.isEmpty()) {
            helper(arbol, caminoMax,new LinkedList<Integer>(), 0, 0, 0);
        }
        return caminoMax;
    }

    /*
        Tengo que buscar los valores 1. 
            Si es 1:
                sumo el nivel al costo total
                Agrego el 1 a la lista del camino actual
            Si no es hoja: 
                hago la recursion con sus hijos, e incremento el nivel
            Si es hoja, y si total > max, tengo que: 
                Actualizar maximo
                Actualizar Total
                Actualizar la lista del camino max
            Si dato == 1 
                Elimino el elemento cargado previamente, al volver de la recursion.
                 
     */
    private static int helper(GeneralTree<Integer> arbol, List<Integer> caminoMax, List<Integer> caminoAct, int costoMax, int costoAct, int nivel) {
        int datoActual = arbol.getData();
        if (datoActual == 1) {
            costoAct += nivel;
            caminoAct.add(datoActual); // agregamos el 1 
        }
        if (arbol.isLeaf()) {
            if (costoMax > costoAct) {
                costoMax = costoAct;
                caminoMax.clear();
                caminoMax.addAll(caminoAct);
            }
        } else {
            for (GeneralTree<Integer> child : arbol.getChildren() )
                costoMax =  helper(child, caminoMax, caminoAct, costoMax, costoAct, nivel+1);
        }
        if (datoActual == 1) caminoAct.remove(caminoAct.size()-1);
        
        return costoMax;
    }

}
