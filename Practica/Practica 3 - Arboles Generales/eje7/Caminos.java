package Practica3.eje7;

import clases_genericas.GeneralTree;
import java.util.LinkedList;
import java.util.List;

public class Caminos {
    private GeneralTree<Integer> arbol;
    public Caminos(GeneralTree<Integer> a){
        this.arbol = a;
    }
    
    public List<Integer> caminoAHojaMasLejana(){
        List<Integer> caminoActual = new LinkedList<>();
        List<Integer> caminoMax = new LinkedList<>();
        if (!this.arbol.isEmpty() || this.arbol!= null)
            auxCamino(this.arbol,caminoActual,caminoMax);
        return caminoMax;
    }
    
    /*
        En este metodo: Siempre vamos a agregar el dato actual a la lista caminoActual
        Si el nodo no es una hoja: Significa que tenemos que seguir haciendo la recursion
            - Invocamos el metodo recursivo con sus hijos
            - Cuando vuelve de la recursion, eliminamos los elementos actuales, asi dejamos la lista vacia 
                para cada camino
       Si el nodo es una hoja: Significa que llegamos al final de un camino. 
            -Debemos evaluar si el camino actual es mayor al camino maximo, y en caso de que sea asi,
                actualizamos la nueva lisa con el camino maximo.
                
       Es decir, mientras hagamos llamadas recursivas, la lista estará cargada con elementos. 
        La lista se vaciará cuando se llegue a una hoja, y se chequee si es maximo o no. 
        Cuando vuelva de la recursion, va sacando elemento por elemento de la lista.
    */
    
    private void auxCamino(GeneralTree<Integer> arbol, List<Integer>caminoActual, List<Integer> caminoMax){
        caminoActual.add(arbol.getData());
        if (!arbol.isLeaf()){
            List<GeneralTree<Integer>> children = arbol.getChildren();
            for (GeneralTree<Integer> child : children){
                auxCamino(child, caminoActual, caminoMax);
                caminoActual.remove(caminoActual.size()-1); // borramos el elemento actual cuando volvemos de la recursion
            }
        }
        else if (caminoActual.size() > caminoMax.size()){ // si se cumple esto, actualizamos el camino max
            caminoMax.clear();
            caminoMax.addAll(caminoActual);
        }
    }
    
}
