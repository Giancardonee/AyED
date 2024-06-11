package practicandoparcialayed.Arboles;

import java.util.LinkedList;
import java.util.List;
import practicandoparcialayed.GeneralTree;
import practicandoparcialayed.Queue;

public class RecorridosAG {

    /*
     Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
         pasados como parámetros, recorrido en preorden
     */
    public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> listaReturn = new LinkedList<>();
        if (a != null && !a.isEmpty()) {
            helperPreOrden(a, n, listaReturn);
        }
        return listaReturn;
    }

    private void helperPreOrden(GeneralTree<Integer> a, Integer n, List<Integer> lista) {
        int datoActual = a.getData();
        agregarSiCumple(a.getData(),n,lista);
        for (GeneralTree<Integer> child : a.getChildren()) {
            helperPreOrden(child, n, lista);
        }
    }

    /*
      Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
            pasados como parámetros, recorrido en postorden
     */
    public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> listaReturn = new LinkedList<>();
        if (a != null && !a.isEmpty()) {
            helperInorden(a, n, listaReturn);
        }
        return listaReturn;
    }

    private void helperInorden(GeneralTree<Integer> a, Integer n, List<Integer> lista) {
        List<GeneralTree<Integer>> children = a.getChildren();
        if (a.hasChildren()) {
            helperInorden(children.get(0), n, lista);  // procesamos primer hijo.
        }
        // procesamos la raiz  
        agregarSiCumple(a.getData(),n,lista);
        // procesamos los demas hijos
        for (int i = 1; i < children.size(); i++) {
            helperInorden(children.get(i), n, lista);
        }
    }
    
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n)
    {
        List<Integer> listaReturn = new LinkedList<>();
        if (a != null && !a.isEmpty()) entreNiveles (a,n,listaReturn);
        return listaReturn;
    }
    
    private void entreNiveles (GeneralTree<Integer> a , Integer n , List<Integer> lista)
    {
        GeneralTree<Integer> aux; 
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(a);
        cola.enqueue(null);
        while (!cola.isEmpty()){
            aux = cola.dequeue();
            if (aux != null)
            {   
                agregarSiCumple(aux.getData(),n,lista);
                for (GeneralTree<Integer> child : aux.getChildren())
                    cola.enqueue(child);
            }else if (!cola.isEmpty()){
                cola.enqueue(null);
            }
        }
    }

    private void agregarSiCumple (int datoActual, Integer n, List<Integer> lista)
    {
          if ((datoActual > n) && (datoActual % 2 != 0)) {
            lista.add(datoActual);
          }
    }
}
