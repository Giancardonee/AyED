package grafos.Eje4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import only.grafos.clases_genericas.AdjListGraph;
import only.grafos.clases_genericas.Edge;
import only.grafos.clases_genericas.Graph;
import only.grafos.clases_genericas.Vertex;

// El “Ayuntamiento” debe ser buscado antes de comenzar el recorrido para encontrar un camino.
// Debe retornar el primer camino que encuentre que cumple las restricciones.
public class VisitaOslo {

    public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos) {
        List<String> listaReturn = new LinkedList<>();
        if (lugares != null && !lugares.isEmpty()) {
            // encontramos el vertice "Ayuntamiento" 
            Vertex<String> vAyuntamiento = lugares.search("Ayuntamiento");
            if (vAyuntamiento != null && !destino.isEmpty() && maxTiempo > 0) {
                boolean[] marca = marcarRestringidos(lugares, lugaresRestringidos);
                helper(vAyuntamiento, lugares, destino, maxTiempo, lugaresRestringidos, listaReturn, marca);
            }
        }
        return listaReturn;
    }

    private boolean[] marcarRestringidos(Graph<String> grafo, List<String> ciudadesRestringidas) {
        boolean[] marca = new boolean[grafo.getSize()];
        for (String actual : ciudadesRestringidas) {
            Vertex<String> verticeActual = grafo.search(actual);
            if (verticeActual != null) {
                marca[verticeActual.getPosition()] = true;
            }
        }
        return marca;
    }

    private boolean helper(Vertex<String> vActual, Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos, List<String> listaReturn, boolean[] marca) {
        boolean encontreDestino = false;
        marca[vActual.getPosition()] = true;

        String lugarActual = vActual.getData();
        listaReturn.add(lugarActual);

        if (lugarActual.equals(destino)) // && (maxTiempo > 0) no la veo necesaria, porque lo evaluo en el while al hacer la recursion. 
        {
            encontreDestino = true;
        } else {
            List<Edge<String>> adyacentes = lugares.getEdges(vActual);
            Iterator<Edge<String>> iterador = adyacentes.iterator();
            while (iterador.hasNext() && !encontreDestino) {
                Edge<String> e = iterador.next();
                int j = e.getTarget().getPosition();
                int costoTiempo = e.getWeight();
                String ciudadVecina = e.getTarget().getData();
                if (!marca[j] && ((maxTiempo - costoTiempo) >= 0)) {
                    encontreDestino = helper(e.getTarget(), lugares, destino, maxTiempo - costoTiempo, lugaresRestringidos, listaReturn, marca);
                }
            }
        }
        if (!encontreDestino) {
            listaReturn.remove(listaReturn.size() - 1);
        }
        marca[vActual.getPosition()] = false;
        return encontreDestino;
    }

    public static void main(String[] args) {
        Graph<String> lugares = new AdjListGraph<String>();
        Vertex<String> v1 = lugares.createVertex("Holmenkollen");
        Vertex<String> v2 = lugares.createVertex("Parque Vigeland");
        Vertex<String> v3 = lugares.createVertex("Galería Nacional");
        Vertex<String> v4 = lugares.createVertex("Parque Botánico");
        Vertex<String> v5 = lugares.createVertex("Museo Munch");
        Vertex<String> v6 = lugares.createVertex("FolkMuseum");
        Vertex<String> v7 = lugares.createVertex("Palacio Real");
        Vertex<String> v8 = lugares.createVertex("Ayuntamiento");
        Vertex<String> v9 = lugares.createVertex("El Tigre");
        Vertex<String> v10 = lugares.createVertex("Akker Brigge");
        Vertex<String> v11 = lugares.createVertex("Museo Fram");
        Vertex<String> v12 = lugares.createVertex("Museo Vikingo");
        Vertex<String> v13 = lugares.createVertex("La Opera");
        Vertex<String> v14 = lugares.createVertex("Museo del Barco Polar");
        Vertex<String> v15 = lugares.createVertex("Fortaleza Akershus");

        lugares.connect(v1, v2, 30);
        lugares.connect(v2, v1, 30);
        lugares.connect(v2, v3, 10);
        lugares.connect(v3, v2, 10);
        lugares.connect(v3, v4, 15);
        lugares.connect(v4, v3, 15);
        lugares.connect(v4, v5, 1);
        lugares.connect(v5, v4, 1);

        lugares.connect(v5, v9, 15);
        lugares.connect(v9, v5, 15);
        lugares.connect(v9, v13, 5);
        lugares.connect(v13, v9, 5);
        lugares.connect(v13, v15, 10);
        lugares.connect(v15, v13, 10);

        lugares.connect(v2, v6, 20);
        lugares.connect(v6, v2, 20);
        lugares.connect(v6, v7, 5);
        lugares.connect(v7, v6, 5);
        lugares.connect(v7, v8, 5);
        lugares.connect(v8, v7, 5);
        lugares.connect(v6, v10, 30);
        lugares.connect(v10, v6, 30);
        lugares.connect(v10, v8, 20);
        lugares.connect(v8, v10, 20);
        lugares.connect(v8, v4, 10);
        lugares.connect(v4, v8, 10);
        lugares.connect(v8, v9, 15);
        lugares.connect(v9, v8, 15);

        lugares.connect(v6, v11, 5);
        lugares.connect(v11, v6, 5);
        lugares.connect(v10, v12, 30);
        lugares.connect(v12, v10, 30);
        lugares.connect(v11, v14, 5);
        lugares.connect(v14, v11, 5);
        lugares.connect(v12, v14, 5);
        lugares.connect(v14, v12, 5);

        List<String> lugaresRestringidos = new LinkedList<>();
        lugaresRestringidos.add("Akker Brigge");
        lugaresRestringidos.add("Palacio Real");

        VisitaOslo eje4 = new VisitaOslo();
        System.out.println(eje4.paseoEnBici(lugares, "Museo Vikingo", 120, lugaresRestringidos));
    }
}
