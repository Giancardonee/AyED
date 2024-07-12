package parcialesgrafos.Parcial5;


import java.util.LinkedList;
import java.util.List;
import parcialesgrafos.clasesGenericas.AdjListGraph;
import parcialesgrafos.clasesGenericas.Edge;
import parcialesgrafos.clasesGenericas.Graph;
import parcialesgrafos.clasesGenericas.Vertex;

public class Parcial5 {

    public List<String> estadios(Graph<Estadio> mapaEstadios, String estadioOrigen, int cantKm) {
        List<String> listaReturn = new LinkedList<>();

        if (mapaEstadios != null && !mapaEstadios.isEmpty() && cantKm > 0) {
            Vertex<Estadio> vOrigen = buscarVertice(mapaEstadios, estadioOrigen);
            if (vOrigen != null) {
                recorridos(mapaEstadios, vOrigen, cantKm, new boolean[mapaEstadios.getSize()], listaReturn, new LinkedList<>(), 0);
            }
        }

        return listaReturn;
    }

    private Vertex<Estadio> buscarVertice(Graph<Estadio> mapaEstadios, String estadioOrigen) {
        List<Vertex<Estadio>> vertices = mapaEstadios.getVertices();
        for (Vertex<Estadio> vActual : vertices) {
            if (vActual.getData().getNombre().equals(estadioOrigen)) {
                return vActual;
            }
        }
        return null;
    }

    private void recorridos(Graph<Estadio> mapaEstadios, Vertex<Estadio> vActual, int cantKm, boolean[] marca, List<String> listaReturn, List<String> listaActual, int kmRecorridos) {
        marca[vActual.getPosition()] = true;
        listaActual.add(vActual.getData().getNombre());
        
        List<Edge<Estadio>> adyacentes = mapaEstadios.getEdges(vActual);
        for (Edge<Estadio> ady : adyacentes) {
            Vertex<Estadio> vAdy = ady.getTarget();
            int kmViaje = ady.getWeight();
            int j = vAdy.getPosition();
            if (!marca[j] && (kmRecorridos + kmViaje) <= cantKm) {
                recorridos(mapaEstadios, vAdy, cantKm, marca, listaReturn, listaActual, kmRecorridos + kmViaje);
            }
        }

        if (listaActual.size() > listaReturn.size()) {
            listaReturn.clear();
            listaReturn.addAll(listaActual);
        }
        
        marca[vActual.getPosition()] = false;
        listaReturn.remove(listaReturn.size() - 1);
    }

    public static void main(String args[]) {
        Graph<Estadio> grafo = new AdjListGraph<>();
        Vertex<Estadio> v1 = grafo.createVertex(new Estadio("Jor", "AI BAYT STADIUM"));
        Vertex<Estadio> v2 = grafo.createVertex(new Estadio("Lusail", "LUSAIL STADIUM"));
        Vertex<Estadio> v3 = grafo.createVertex(new Estadio("Rayán", "EDUCATION CITY STADIUM"));
        Vertex<Estadio> v4 = grafo.createVertex(new Estadio("Rayán", "AL RAYYAN STADIUM"));
        Vertex<Estadio> v5 = grafo.createVertex(new Estadio("Doha", "STADIUM 947"));
        Vertex<Estadio> v6 = grafo.createVertex(new Estadio("Doha", "KHALIFA INTERNATIONAL STADIUM"));
        Vertex<Estadio> v7 = grafo.createVertex(new Estadio("Doha", "AL THUMAMA STADIUM"));
        Vertex<Estadio> v8 = grafo.createVertex(new Estadio("Wakrah", "AL JANOUB STADIUM"));

        grafo.connect(v1, v2, 42);
        grafo.connect(v2, v1, 42);
        grafo.connect(v2, v3, 24);
        grafo.connect(v3, v2, 24);
        grafo.connect(v2, v5, 52);
        grafo.connect(v5, v2, 52);
        grafo.connect(v3, v4, 11);
        grafo.connect(v4, v3, 11);
        grafo.connect(v4, v6, 8);
        grafo.connect(v6, v4, 8);
        grafo.connect(v6, v7, 12);
        grafo.connect(v7, v6, 12);
        grafo.connect(v7, v8, 12);
        grafo.connect(v8, v7, 12);
        grafo.connect(v8, v5, 19);
        grafo.connect(v5, v8, 19);

        Parcial5 p = new Parcial5();

        System.out.println(p.estadios(grafo, "AI BAYT STADIUM", 100));
    }
}
