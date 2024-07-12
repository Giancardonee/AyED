package parcialesgrafos.Parcial7;

import java.util.LinkedList;
import java.util.List;
import parcialesgrafos.clasesGenericas.AdjListGraph;
import parcialesgrafos.clasesGenericas.Edge;
import parcialesgrafos.clasesGenericas.Graph;
import parcialesgrafos.clasesGenericas.Vertex;

public class Parcial {

    public List<String> recorrido(Graph<String> grafo, int cantLocalidadesMinimas, int cantNafta, List<String> localidadesExceptuadas) {
        List<String> listaReturn = new LinkedList<>();
        if (grafo != null && !grafo.isEmpty() && cantNafta > 0) {
            int localidadesGrafo = grafo.getSize();
            if (localidadesGrafo >= cantLocalidadesMinimas) { // si el grafo no tiene las localidades minimas requeridas, no vale la pena recorrerlo. 
                Vertex<String> vOrigen = grafo.search("Mendoza");
                boolean[] marca = marcarExceptuadas(grafo, localidadesExceptuadas);
                recorridosHelper(grafo, marca, listaReturn, vOrigen, cantNafta, 0, cantLocalidadesMinimas);
            }
        }
        return listaReturn;
    }

    private boolean[] marcarExceptuadas(Graph<String> grafo, List<String> localidadesExceptuadas) {
        boolean[] marca = new boolean[grafo.getSize()];
        for (String localidadActual : localidadesExceptuadas) {
            Vertex<String> v = grafo.search(localidadActual);
            if (v != null) {
                marca[v.getPosition()] = true;
            }
        }
        return marca;
    }

    public boolean recorridosHelper(Graph<String> grafo, boolean[] marca, List<String> listaReturn, Vertex<String> vActual, int cantNafta, int naftaConsumida, int cantLocalidadesMin) {
        boolean encontreCamino = false;
        marca[vActual.getPosition()] = true;

        listaReturn.add(vActual.getData());

        List<Edge<String>> adyacentes = grafo.getEdges(vActual);
        for (Edge<String> ady : adyacentes) {
            Vertex<String> vAdy = ady.getTarget();
            int naftaCamino = ady.getWeight();
            int j = vAdy.getPosition();
            if (!marca[j] && (naftaConsumida + naftaCamino) <= cantNafta) {
                encontreCamino = recorridosHelper(grafo, marca, listaReturn, vAdy, cantNafta, (naftaConsumida + naftaCamino), cantLocalidadesMin);
            }
        }

        if (listaReturn.size() >= cantLocalidadesMin) {
            return true;
        }

        if (!encontreCamino) {
            listaReturn.remove(listaReturn.size() - 1);
        }

        marca[vActual.getPosition()] = false;

        return encontreCamino;
    }

    public static void main(String args[]) {
        Graph<String> grafo = new AdjListGraph<String>();
        Vertex<String> v1 = grafo.createVertex("Mendoza");
        Vertex<String> v2 = grafo.createVertex("Tunuyán");
        Vertex<String> v3 = grafo.createVertex("San Martin");
        Vertex<String> v4 = grafo.createVertex("La Paz");
        Vertex<String> v5 = grafo.createVertex("Santa Rosa");
        Vertex<String> v6 = grafo.createVertex("San Rafael");
        Vertex<String> v7 = grafo.createVertex("Malargue");
        Vertex<String> v8 = grafo.createVertex("General Alvear");

        grafo.connect(v1, v2, 10);
        grafo.connect(v1, v3, 6);
        grafo.connect(v2, v3, 10);
        grafo.connect(v3, v4, 8);
        grafo.connect(v4, v5, 2);
        grafo.connect(v3, v6, 13);
        grafo.connect(v6, v2, 11);
        grafo.connect(v6, v8, 7);
        grafo.connect(v2, v7, 12);
        grafo.connect(v8, v7, 6);

        List<String> localidadesExceptuadas = new LinkedList<String>();
        localidadesExceptuadas.add("General Alvear");
        localidadesExceptuadas.add("La Paz");

        Parcial p = new Parcial();

        System.out.println(p.recorrido(grafo, 5, 80, localidadesExceptuadas));
    }
}
