package EjeParcialAG_1;

import clases_genericas.GeneralTree;
import clases_genericas.Queue;
import java.util.LinkedList;
import java.util.List;

/*
    ESTE METODO RETORNA UNA LISTA CON IMAGENES DE UN NIVEL DEL AG RECIBIDO POR PARAMETRO.
 */

public class DevolverImagenes {

    public static List<Recurso> getImagenes(GeneralTree<Recurso> ag, int nivel_pedido) {

        List<Recurso> result = new LinkedList<Recurso>(); // en esta lista vamos a retornar las imagenes
        Queue<GeneralTree<Recurso>> cola = new Queue<GeneralTree<Recurso>>(); // creamos la cola para encolar y desencolar
        GeneralTree<Recurso> arbol_aux;    // arbol auxiliar

        cola.encolar(ag);   // encolamos la raiz
        cola.encolar(null); // encolamos null para saber el fin del nivel
        int nivel = 0;
        while (!cola.isEmpty() && nivel <= nivel_pedido) {
            arbol_aux = cola.desencolar(); // nos traemos el nodo
            if (arbol_aux != null) {
                Recurso rec = arbol_aux.getData(); // nos traemos el dato del nodo actual.
                if (nivel == nivel_pedido && rec.esImagen()) // si cumple con ambas condiciones, lo agregamos a la lista.
                {
                    result.add(arbol_aux.getData());
                }
                if (arbol_aux.hasChildren() && nivel < nivel_pedido) { // si tiene hijos, y el nivel es menor al buscado
                    List<GeneralTree<Recurso>> children = arbol_aux.getChildren();
                    for (GeneralTree<Recurso> child : children) {
                        cola.encolar(child);    // encolamos todos los hijos.
                    }
                }
            } else { // aca va a entrar cuando el dato sea null, si es null y la cola no esta vacia es porque hay que seguir procesando datos.
                if (!cola.isEmpty()) {
                    nivel++;
                    cola.encolar(null);
                }
            }
        }
        
        return result; //lista de imagenes del nivel recibido. 
    }

}
