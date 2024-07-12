package parcialesgrafos.Parcial3;

import java.util.Iterator;
import java.util.List;
import parcialesgrafos.clasesGenericas.AdjListGraph;
import parcialesgrafos.clasesGenericas.Edge;
import parcialesgrafos.clasesGenericas.Graph;
import parcialesgrafos.clasesGenericas.Vertex;

public class Parcial3 {

    public String resolver(Graph<Recinto> sitios, int tiempo) {
        boolean esAlcanzable = false;

        if (sitios != null && !sitios.isEmpty() && tiempo>0) {
            Vertex<Recinto> verticeEntrada = buscarVerticeEntrada(sitios);
            if (verticeEntrada != null && verticeEntrada.getData().getTiempo() < tiempo) {
                esAlcanzable = helper(verticeEntrada, sitios, tiempo, 0, new boolean[sitios.getSize()]);

            }
        }
        return (esAlcanzable == true) ? "Alcanzable" : "No alcanzable";
    }

    private Vertex<Recinto> buscarVerticeEntrada(Graph<Recinto> sitios) {
        List<Vertex<Recinto>> vertices = sitios.getVertices();
        for (Vertex<Recinto> vActual : vertices) {
            if (vActual.getData().getNombre().equals("Entrada")) {
                return vActual;
            }
        }
        return null;
    }

    public boolean helper(Vertex<Recinto> actual, Graph<Recinto> sitios, int tiempoMax, int tiempoActual, boolean[] marca) {
        boolean cumpleCondicion = true;
        marca[actual.getPosition()] = true;
        tiempoActual += actual.getData().getTiempo();

        if (tiempoActual > tiempoMax) {
            cumpleCondicion = false;
        } else {
            List<Edge<Recinto>> adyacentes = sitios.getEdges(actual);
            Iterator<Edge<Recinto>> iterador = adyacentes.iterator();

            while (iterador.hasNext() && cumpleCondicion) {
                Edge<Recinto> e = iterador.next();
                Vertex<Recinto> v = e.getTarget();
                int tiempoViaje = e.getWeight();
                int tiempoTranscurrido = tiempoActual + tiempoViaje;

                if (!marca[v.getPosition()]) {
                    cumpleCondicion = helper(v, sitios, tiempoMax, tiempoTranscurrido, marca);
                }
            }
        }

        marca[actual.getPosition()] = false; // Desmarcar el vértice para permitir otros caminos
        return cumpleCondicion;
    }

    public static void main(String args[]) {
        Graph<Recinto> grafo = new AdjListGraph<Recinto>();
        Vertex<Recinto> Entrada = grafo.createVertex(new Recinto("Entrada", 15));
        Vertex<Recinto> Cebras = grafo.createVertex(new Recinto("Cebras", 10));
        Vertex<Recinto> Tigres = grafo.createVertex(new Recinto("Tigres", 10));
        Vertex<Recinto> Flamencos = grafo.createVertex(new Recinto("Flamencos", 10));
        Vertex<Recinto> Murcielagos = grafo.createVertex(new Recinto("Murciélagos", 20));
        Vertex<Recinto> Wallabies = grafo.createVertex(new Recinto("Wallabies", 30));
        Vertex<Recinto> Tortugas = grafo.createVertex(new Recinto("Tortugas", 10));
        Vertex<Recinto> Pumas = grafo.createVertex(new Recinto("Pumas", 10));

        grafo.connect(Entrada, Cebras, 10);
        grafo.connect(Cebras, Entrada, 10);
        grafo.connect(Entrada, Tigres, 15);
        grafo.connect(Tigres, Entrada, 15);
        grafo.connect(Entrada, Murcielagos, 20);
        grafo.connect(Murcielagos, Entrada, 20);
        grafo.connect(Entrada, Flamencos, 25);
        grafo.connect(Flamencos, Entrada, 25);

        grafo.connect(Tigres, Cebras, 8);
        grafo.connect(Cebras, Tigres, 8);
        grafo.connect(Cebras, Tortugas, 5);
        grafo.connect(Tortugas, Cebras, 5);
        grafo.connect(Flamencos, Murcielagos, 25);
        grafo.connect(Murcielagos, Flamencos, 25);
        grafo.connect(Murcielagos, Wallabies, 10);
        grafo.connect(Wallabies, Murcielagos, 10);
        grafo.connect(Wallabies, Tortugas, 10);
        grafo.connect(Tortugas, Wallabies, 10);
        grafo.connect(Tortugas, Pumas, 15);
        grafo.connect(Pumas, Tortugas, 15);
        grafo.connect(Pumas, Wallabies, 2);
        grafo.connect(Wallabies, Pumas, 2);

        Parcial3 p = new Parcial3();

        System.out.println(p.resolver(grafo, 400));
        System.out.println(p.resolver(grafo, 205));
        System.out.println(p.resolver(grafo, 195));
        System.out.println(p.resolver(grafo, 100));
    }
}
