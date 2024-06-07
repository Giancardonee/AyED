package EjeParcialAG_2;

import clases_genericas.GeneralTree;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
Implementar un método que devuelva una lista con un camino desde la raíz a una Princesa sin
pasar por un Dragón –sin necesidad de ser el más cercano a la raíz-. Asuma que existe al menos
un camino accesible.
*/
public class ParcialPrincesa {
    
    
    // OPCION 1 
    public static List<Personaje> encontrarPrincesa(GeneralTree<Personaje> arbol) {
        List<Personaje> lista = new LinkedList<Personaje>();
        lista.add(arbol.getData());
        List<Personaje> camino = new LinkedList<Personaje>();
        encontrarPrincesa(arbol, lista, camino);
        return camino;
    }
    
    private static void encontrarPrincesa(GeneralTree<Personaje> arbol, List<Personaje> lista, List<Personaje> camino) {
        Personaje p = arbol.getData(); // nos traemos el dato del nodo 
        if (p.esPrincesa()) {
            camino.addAll(lista);
        }   
        if (camino.isEmpty()) {  // si el camino esta vacio, es porque no se encontro a la princesa
            List<GeneralTree<Personaje>> children = arbol.getChildren(); // nos traemos la lista de hijos
            for (GeneralTree<Personaje> child: children) { // recorremos los hijos
                if (!child.getData().esDragon()) {
                    lista.add(child.getData()); // si no es un dragon, lo agregamos a la lista.
                    encontrarPrincesa(child, lista, camino); // llamado recursivo
                    lista.remove(lista.size() - 1); //borramos el ultimo elemento agregado.
                }
            }
            
        }
    }
    
    // OPCION 2
    public static List<Personaje> encontrarPrincesa2(GeneralTree<Personaje> arbol) {
    List<Personaje> lista = null;
    
    if (arbol.getData().esPrincesa() || arbol.getData().esDragon() || arbol.isLeaf()) { // CASOS BASE
        if (arbol.getData().esPrincesa()) {
            Personaje p = arbol.getData();
            lista=new LinkedList<Personaje>();
            lista.add(0, p);
        }
        return lista;
    }
    
    List<GeneralTree<Personaje>> hijos = arbol.getChildren();
    Iterator<GeneralTree<Personaje>> it = hijos.iterator();
    while (it.hasNext() && lista==null) { // iteramos sobre los hijos, mientras no encontremos la princesa.
        lista = encontrarPrincesa(it.next());
        if (lista!=null) {  // si la lista es != null es porque se encontro la princesa.
            lista.add(0, arbol.getData()); // agregamos adelante en la lista, mientras volvemos de la recursion
            // break; o lista==null en el while
        }
    }
    return lista;
    }


}
