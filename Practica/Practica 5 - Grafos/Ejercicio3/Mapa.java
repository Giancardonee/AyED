package Practica5.Ejercicio3;

import clases_genericas.AdjListGraph;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Mapa {

    private Graph<String> mapaCiudades;

    public Mapa(Graph<String> mapa) {
        this.mapaCiudades = mapa;
    }

    /*
    Inciso 1: 
     Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso de que se
    pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).
     */
    public List<String> devolverCamino(String ciudad1, String ciudad2) {
        List<String> camino = new LinkedList<>();
        if (!this.mapaCiudades.isEmpty()) {
            // buscamos si existen los vertices origen y destino
            Vertex<String> Origen = mapaCiudades.search(ciudad1);
            Vertex<String> Destino = mapaCiudades.search(ciudad2);
            // si alguno de los dos es null, es porque no existe, no tiene sentido recorrer el grafo
            if (Origen != null && Destino != null) {
                auxiliar1(new boolean[this.mapaCiudades.getSize()], Origen, Destino, camino);
            }
        }
        return camino;
    }

    private boolean auxiliar1(boolean[] visitado, Vertex origen, Vertex destino, List<String> camino) {
        visitado[origen.getPosition()] = true;
        camino.add(origen.getData().toString());

        boolean seguir = true;

        // si estamos en el vertice destino, retornamos false para dejar de hacer llamados recursivos
        if (origen.getData().equals(destino.getData())) {
            return false;
        } else {

            List<Edge<String>> ady = this.mapaCiudades.getEdges(origen); // nos traemos los adyacentes
            Iterator<Edge<String>> iterador = ady.iterator();
            while (iterador.hasNext() && seguir) // mientras tengamos adyacentes y mientras no encontremos el destino
            {
                Vertex<String> v = iterador.next().getTarget(); // traemos el adyacente
                int j = v.getPosition(); // nos traemos la posicion del adyacente
                if (!visitado[j]) // si no esta visitado, hacemos la llamada recursiva desde ese vertice
                {
                    seguir = auxiliar1(visitado, v, destino, camino);
                }
            }
        }
        // si todavia no encontramos el destino, cuando volvemos de la recursion, tenemos que 
        // ir eliminando elementos, de esta manera tenemos la lista actualizada.
        if (seguir) {
            camino.remove(camino.size() - 1);
        }
        return seguir;
    }

    /*
    Inciso 2:
    Retorna una lista de ciudades que forman un camino desde ciudad1 hasta ciudad2, sin pasar por las ciudades
    que esten contenidas en la lista pasada por parametro. 
    Si no existe un camino retorna la lista vacia. (sin tener en cuenta el combustible.)
     
    opcion 1: Reutilizando el procedimiento auxiliar del inciso 1
     */
    public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades) {
        List<String> listaReturn = new LinkedList<>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex<String> verticeOrigen = this.mapaCiudades.search(ciudad1);
            Vertex<String> verticeDestino = this.mapaCiudades.search(ciudad2);
            if (verticeOrigen != null && verticeDestino != null) {
                boolean[] ciudadesRestringidas = new boolean[this.mapaCiudades.getSize()];
                marcarCiudadesRestringidas(ciudadesRestringidas, ciudades);

                // reutilizo el codigo del ejercicio1
                auxiliar1(ciudadesRestringidas, verticeOrigen, verticeDestino, listaReturn);
            }
        }
        return listaReturn;
    }

    private void marcarCiudadesRestringidas(boolean[] ciudadesRestringidas, List<String> ciudades) {
        for (String ciudad : ciudades) {
            Vertex<String> vertice = this.mapaCiudades.search(ciudad);
            if (vertice != null) {
                int posicion = vertice.getPosition();
                if (!ciudadesRestringidas[posicion]) {
                    ciudadesRestringidas[posicion] = true;
                }
            }
        }
    }

    /*
    Inciso 2: Opcion 2: Haciandolo sin tener en cuenta el metodo auxiliar del inciso 1
     */
    public List<String> devolverCaminoExceptuando2(String ciudad1, String ciudad2, List<String> ciudades) {
        List<String> listaReturn = new LinkedList<>();
        if (!mapaCiudades.isEmpty()) {
            Vertex<String> origen = mapaCiudades.search(ciudad1);
            Vertex<String> destino = mapaCiudades.search(ciudad2);
            if (origen != null && destino != null) {
                auxiliar2(new boolean[mapaCiudades.getSize()], origen, destino, ciudades, listaReturn);
            }
        }
        return listaReturn;
    }

    private boolean auxiliar2(boolean[] visitado, Vertex<String> origen, Vertex<String> destino, List<String> ciudadesRestringidas, List<String> camino) {
        visitado[origen.getPosition()] = true;
        boolean encontre = false;
        if (!ciudadesRestringidas.contains(origen.getData())) {
            camino.add(origen.getData());
            if (!origen.getData().equals(destino.getData())) {
                List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(origen);
                for (Edge<String> ady : adyacentes) {
                    Vertex<String> v = ady.getTarget();
                    int j = v.getPosition();
                    if (!visitado[j]) {
                        encontre = auxiliar2(visitado, v, destino, ciudadesRestringidas, camino);
                    }
                }
            } else { // la ciudad origen coincide con la ciudad destino.
                return true;
            }
            if (!encontre) {
                camino.remove(camino.size() - 1);
            }
        }
        return encontre;
    }

    public static void main(String[] args) {
        Graph<String> mapaCiudades = new AdjListGraph<>();
        Vertex<String> v1 = mapaCiudades.createVertex("La Plata"); //Casa Caperucita
        Vertex<String> v2 = mapaCiudades.createVertex("Ensenada"); //Claro 3
        Vertex<String> v3 = mapaCiudades.createVertex("Berisso"); //Claro 1
        Vertex<String> v4 = mapaCiudades.createVertex("Berazategui"); //Claro 2
        Vertex<String> v5 = mapaCiudades.createVertex("Florencio Varela"); //Claro 5
        Vertex<String> v6 = mapaCiudades.createVertex("Presidente Peron"); //Claro 4
        Vertex<String> v7 = mapaCiudades.createVertex("San Vicente"); //Casa Abuelita
        mapaCiudades.connect(v1, v2, 4);
        mapaCiudades.connect(v2, v1, 4);
        mapaCiudades.connect(v1, v3, 3);
        mapaCiudades.connect(v3, v1, 3);
        mapaCiudades.connect(v1, v4, 4);
        mapaCiudades.connect(v4, v1, 4);
        mapaCiudades.connect(v2, v5, 15);
        mapaCiudades.connect(v5, v2, 15);
        mapaCiudades.connect(v3, v5, 3);
        mapaCiudades.connect(v5, v3, 3);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v4, v5, 11);
        mapaCiudades.connect(v5, v4, 11);
        mapaCiudades.connect(v4, v6, 10);
        mapaCiudades.connect(v6, v4, 10);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v5, v7, 4);
        mapaCiudades.connect(v7, v5, 4);
        mapaCiudades.connect(v6, v7, 9);
        mapaCiudades.connect(v7, v6, 9);

        Mapa Ejercicio3 = new Mapa(mapaCiudades);

        System.out.println("Inciso 1: ");
        String origen = "La Plata";
        String destino = "San Vicente";
        System.out.println("Un camino desde " + origen + " hasta " + destino + " es : ");
        System.out.println(Ejercicio3.devolverCamino(origen, destino));

        System.out.println("=========================");
        System.out.println("Inciso 2: ");
        List<String> localidadesRestringidas = new LinkedList<>();
        localidadesRestringidas.add("Berisso");

        System.out.println(Ejercicio3.devolverCaminoExceptuando2(origen, destino, localidadesRestringidas));

    }

}
