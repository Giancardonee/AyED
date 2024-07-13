package parcialesgrafos.ParcialSegundaFecha;

import java.util.List;
import parcialesgrafos.clasesGenericas.AdjListGraph;
import parcialesgrafos.clasesGenericas.Edge;
import parcialesgrafos.clasesGenericas.Graph;
import parcialesgrafos.clasesGenericas.Queue;
import parcialesgrafos.clasesGenericas.Vertex;

public class ParcialGrafos {

    public auxReturn nivelPopularidad(Graph<String> red, String usuario, int distancia, int umbral) {
        auxReturn aux = null;
        if (red != null && !red.isEmpty() && distancia > 0) {
            Vertex<String> verticeUsuario = red.search(usuario);
            if (verticeUsuario != null) {
                aux = new auxReturn();
                bfsEficiente(verticeUsuario, distancia, umbral, aux, red);
            }
        }
        return aux;
    }

    /*
        Seria mas eficiente si los vamos contando antes de encolarlos, para esto tenemos que ir evaluando
    si la distanciaActual+1 == distancia, e ir contandolos, no hace falta encolar y desencolarlos para irlos contando
    seria mas eficiente. Lo hice en el otro metodo.
     */
    private void bfs(Vertex<String> vUsuario, int distancia, int umbral, auxReturn auxiliar, Graph<String> red) {
        boolean marca[] = new boolean[red.getSize()];
        int distanciaActual = 0;
        int cantAmigosDistanciaBuscada = 0;
        Queue<Vertex<String>> cola = new Queue<>();
        cola.enqueue(vUsuario);
        cola.enqueue(null);

        marca[vUsuario.getPosition()] = true;

        while (!cola.isEmpty() && distanciaActual <= distancia) {
            Vertex<String> aux = cola.dequeue();
            if (aux != null) {
                if (distanciaActual == distancia) {
                    cantAmigosDistanciaBuscada++;
                } else {
                    List<Edge<String>> adyacentes = red.getEdges(aux);
                    for (Edge<String> ady : adyacentes) {
                        Vertex<String> v = ady.getTarget();
                        int j = v.getPosition();
                        if (!marca[j]) {
                            cola.enqueue(v);
                            marca[j] = true;
                        }
                    }
                }
            } else {
                if (!cola.isEmpty()) {
                    distanciaActual++;
                    cola.enqueue(null);
                }
            }
        }
        auxiliar.setCantUsuariosDistancia(cantAmigosDistanciaBuscada);
        auxiliar.setEsPopular(cantAmigosDistanciaBuscada >= umbral);
    }

    private void bfsEficiente(Vertex<String> vUsuario, int distancia, int umbral, auxReturn auxiliar, Graph<String> red) {
        boolean marca[] = new boolean[red.getSize()];
        int distanciaActual = 0;
        int cantAmigosDistanciaBuscada = 0;

        Queue<Vertex<String>> cola = new Queue<>();
        cola.enqueue(vUsuario);
        cola.enqueue(null);

        marca[vUsuario.getPosition()] = true;

        while (!cola.isEmpty() && distanciaActual < distancia) {
            Vertex<String> aux = cola.dequeue();
            if (aux != null) {
                List<Edge<String>> adyacentes = red.getEdges(aux);
                for (Edge<String> ady : adyacentes) {
                    Vertex<String> v = ady.getTarget();
                    int j = v.getPosition();
                    if (!marca[j]) {
                        marca[j] = true;
                        if (distanciaActual + 1 == distancia) {
                            cantAmigosDistanciaBuscada++;
                        } else {
                            cola.enqueue(v);
                        }
                    }
                }
            } else {
                if (!cola.isEmpty()) {
                    distanciaActual++;
                    cola.enqueue(null);
                }
            }
        }
        auxiliar.setCantUsuariosDistancia(cantAmigosDistanciaBuscada);
        auxiliar.setEsPopular(cantAmigosDistanciaBuscada >= umbral);
    }

    public static void main(String args[]) {
        Graph<String> grafo = new AdjListGraph<String>();
        Vertex<String> v1 = grafo.createVertex("Lionel");
        Vertex<String> v2 = grafo.createVertex("Rodrigo");
        Vertex<String> v3 = grafo.createVertex("Ángel");
        Vertex<String> v4 = grafo.createVertex("Emiliano");
        Vertex<String> v5 = grafo.createVertex("Julián");
        Vertex<String> v6 = grafo.createVertex("Diego");
        Vertex<String> v7 = grafo.createVertex("Lautaro");
        Vertex<String> v8 = grafo.createVertex("Enzo");

        grafo.connect(v1, v2);
        grafo.connect(v2, v1);

        grafo.connect(v1, v3);
        grafo.connect(v3, v1);

        grafo.connect(v2, v4);
        grafo.connect(v4, v2);

        grafo.connect(v2, v5);
        grafo.connect(v5, v2);

        grafo.connect(v3, v5);
        grafo.connect(v5, v3);

        grafo.connect(v3, v6);
        grafo.connect(v6, v3);

        grafo.connect(v6, v7);
        grafo.connect(v7, v6);

        grafo.connect(v5, v7);
        grafo.connect(v7, v5);

        grafo.connect(v6, v8);
        grafo.connect(v8, v6);

        grafo.connect(v4, v8);
        grafo.connect(v8, v4);

        grafo.connect(v4, v7);
        grafo.connect(v7, v4);

        ParcialGrafos p = new ParcialGrafos();

        System.out.println(p.nivelPopularidad(grafo, "Lionel", 2, 3));
        System.out.println(p.nivelPopularidad(grafo, "Lionel", 1, 3));
        System.out.println(p.nivelPopularidad(grafo, "Gianca", 1, 0));
    }
}
