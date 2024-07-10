package grafos.Eje5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import only.grafos.clases_genericas.AdjListGraph;
import only.grafos.clases_genericas.Edge;
import only.grafos.clases_genericas.Graph;
import only.grafos.clases_genericas.Queue;
import only.grafos.clases_genericas.Vertex;

public class Banco_Itaú {

    /*
    retorna una lista de hasta 40 jubilados que no hayan percibido la jubilación del mes y se encuentre a una distancia menor a
    recibido como parámetro.
     */
    public List<Persona> QuedateEnCasa(Graph<Persona> grafo, Persona empleado, int distanciaMax) {
        List<Persona> listaJubilados = new LinkedList<>();
        if (grafo != null && !grafo.isEmpty() && empleado != null && distanciaMax >= 0) {
            Vertex<Persona> vEmpleado = grafo.search(empleado);
            if (vEmpleado!= null)
            {
                QuedateEnCasaBFS(grafo, vEmpleado, distanciaMax, listaJubilados, 40);
            }
        }
        return listaJubilados;
    }

    private void QuedateEnCasaBFS(Graph<Persona> grafo, Vertex<Persona> empleado, int distanciaMax, List<Persona> listaJubilados, int jubiladosMaximos) {
        int distanciaActual = 0;

        Queue<Vertex<Persona>> cola = new Queue<>();
        boolean[] marca = new boolean[grafo.getSize()];
        marca[empleado.getPosition()] = true;

        cola.enqueue(empleado);
        cola.enqueue(null);
        boolean seguir = true;
        while (!cola.isEmpty() && seguir) 
        {
            
            Vertex<Persona> aux = cola.dequeue();
            if (aux != null) { ;
                List<Edge<Persona>> adyacentes = grafo.getEdges(aux);
                Iterator<Edge<Persona>> iterador = adyacentes.iterator();
                
                while (iterador.hasNext() && seguir) {
                    Edge<Persona> v = iterador.next();
                    int j = v.getTarget().getPosition();
                    if (!marca[j]) {
                        System.out.println("Proceso: "+v.getTarget().getData());
                        System.out.println("====> Distancia actual: "+distanciaActual+ " Distancia max: "+distanciaMax);
                        if ((distanciaActual + 1 <= distanciaMax) && (listaJubilados.size() < jubiladosMaximos)) {
                            marca[j] = true;
                            cola.enqueue(v.getTarget());
                            Persona persona = v.getTarget().getData();
                            if (persona.esJubilado() && !persona.cobroSueldo()) {
                                listaJubilados.add(v.getTarget().getData());
                            }
                        } else { // es porque: se supero la distancia maxima, o se supero la capacidad de jubilados en la lista.
                            seguir = false;
                        }
                    }

                }
            } else if (!cola.isEmpty()) {
                distanciaActual++;
                if (listaJubilados.size() == jubiladosMaximos) {
                    seguir = false;
                }
                if (distanciaActual<= distanciaMax)
                {
                    cola.enqueue(null);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph<Persona> grafo = new AdjListGraph<>();
        Persona empleado = new Persona ("Empleado", "Gianca", "AAA", true);
        Vertex v1 = grafo.createVertex(empleado);
        Vertex v2 = grafo.createVertex(new Persona("Jubilado", "Franco", "BBB", false));
        Vertex v3 = grafo.createVertex(new Persona("Jubilado", "Nahuel", "CCC", false));
        Vertex v4 = grafo.createVertex(new Persona("Empleado", "Mauro", "DDD", true));
        Vertex v5 = grafo.createVertex(new Persona("Jubilado", "LeoMessi", "EEE", true));
        Vertex v6 = grafo.createVertex(new Persona("Empleado", "Rosana", "FFF", true));
        Vertex v7 = grafo.createVertex(new Persona("Jubilado", "Maria", "GGG", false));
        Vertex v8 = grafo.createVertex(new Persona("Jubilado", "Sandra", "HHH", false));
        Vertex v9 = grafo.createVertex(new Persona("Jubilado", "Matheo", "III", false));

        
        grafo.connect(v1, v2);
        grafo.connect(v1, v3);
        grafo.connect(v2, v7);
        grafo.connect(v7, v8);
        grafo.connect(v7, v9);
        
        Banco_Itaú Eje5 = new Banco_Itaú();
        
        System.out.println(Eje5.QuedateEnCasa(grafo, empleado, 2));
    }

}
