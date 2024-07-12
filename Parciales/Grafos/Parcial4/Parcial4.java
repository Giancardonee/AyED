package parcialesgrafos.Parcial4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import parcialesgrafos.clasesGenericas.AdjListGraph;
import parcialesgrafos.clasesGenericas.Edge;
import parcialesgrafos.clasesGenericas.Graph;
import parcialesgrafos.clasesGenericas.Vertex;

public class Parcial4 {
    
    public List<List<String>> resolver(Graph<String> sitios, String origen, String destino, List<String> evitarPasarPor)
    {
        List<List<String>> listaReturn = new LinkedList<>();
        if (sitios != null && !sitios.isEmpty())
        {
            VerticesAux vertices = buscarVertices(sitios,origen,destino);
            if (vertices.verticesEncontrados() && evitarPasarPor != null)
            {
                boolean [] marca = marcarEvitarPasar(sitios,evitarPasarPor);
                dfs(listaReturn,sitios,vertices.getOrigen(),vertices.getDestino(),marca,0,new LinkedList<>());
            }
        }
        
        
        return listaReturn;
    }
    
    private boolean [] marcarEvitarPasar(Graph<String> sitios, List<String> evitarPasar)
    {
        boolean [] marca = new boolean [sitios.getSize()];
        for (String st : evitarPasar)
        {
            Vertex<String> v = sitios.search(st);
            if (v != null)
            {
                marca[v.getPosition()]= true;
            }
        }
        return marca;
    }
    
    private VerticesAux buscarVertices(Graph<String> sitios,String origen, String destino)
    {
        VerticesAux verticesReturn = new VerticesAux();
        Vertex<String> verticeAux;
         
        List<Vertex<String>> adyacentes = sitios.getVertices();
        Iterator<Vertex<String>> iterador = adyacentes.iterator();
        while (iterador.hasNext() && !verticesReturn.verticesEncontrados())
        {
            Vertex<String> v = iterador.next();
            if (v.getData().equals(origen))  verticesReturn.setOrigen(v);
            else if (v.getData().equals(destino)) verticesReturn.setDestino(v);   
        }
        return verticesReturn;
    }

    private void dfs (List<List<String>> listaReturn, Graph<String> sitios, Vertex<String> actual, Vertex<String> destino, boolean[] marca, int cantCuadras,List<String> listActual)
    {
        marca[actual.getPosition()] = true;    
        listActual.add(actual.getData());
        
        if (actual.getData().equals(destino.getData()))
        {
            List<String> nuevaLista = new LinkedList<>(listActual);
            nuevaLista.add("Distancia total = "+cantCuadras+ " cuadras.");
            listaReturn.add(nuevaLista);
        }
        else
        {
            List<Edge<String>> adyacentes = sitios.getEdges(actual);
            for (Edge<String> ady : adyacentes)
            {
                Vertex<String> vAdy = ady.getTarget();
                int cuadrasDestino = ady.getWeight(); // nos traemos el peso de la arista
                if (!marca[vAdy.getPosition()])
                {
                    dfs(listaReturn,sitios,vAdy,destino,marca,cantCuadras+cuadrasDestino,listActual);
                }
            }       
        }
        
        listActual.remove(listActual.size() - 1);
        marca[actual.getPosition()] = false;
    }
    
        public static void main(String args[]) {
        Graph<String> grafo = new AdjListGraph<>();
        Vertex v1 = grafo.createVertex("Estadio Diego Armando Maradona");
        Vertex v2 = grafo.createVertex("Legislatura");
        Vertex v3 = grafo.createVertex("Coliseo Podestá");
        Vertex v4 = grafo.createVertex("MACLA");
        Vertex v5 = grafo.createVertex("Catedral La Plata");
        Vertex v6 = grafo.createVertex("Palacio Campodónico");
        Vertex v7 = grafo.createVertex("Rectorado UNLP");
        Vertex v8 = grafo.createVertex("Museo UNLP");
        
        grafo.connect(v1, v2, 25);
        grafo.connect(v2, v1, 25);
        grafo.connect(v1, v3, 20);
        grafo.connect(v3, v1, 20);
        grafo.connect(v1, v4, 35);
        grafo.connect(v4, v1, 35);
        grafo.connect(v1, v5, 40);
        grafo.connect(v5, v1, 40);
        grafo.connect(v2, v3, 25);
        grafo.connect(v3, v2, 25);
        grafo.connect(v4, v5, 8);
        grafo.connect(v5, v4, 8);
        grafo.connect(v5, v7, 5);
        grafo.connect(v7, v5, 5);
        grafo.connect(v3, v6, 10);
        grafo.connect(v6, v3, 10);
        grafo.connect(v6, v7, 30);
        grafo.connect(v7, v6, 30);
        grafo.connect(v7, v8, 15);
        grafo.connect(v8, v7, 15);
        
        List<String> evitarPasarPor = new LinkedList<String>();
        evitarPasarPor.add("Legislatura");
        evitarPasarPor.add("MACLA");
        
        Parcial4 p = new Parcial4();
        List<List<String>> lis = p.resolver(grafo, "Estadio Diego Armando Maradona", "Palacio Campodónico", evitarPasarPor);
        
        for(List<String>aux: lis) {
            System.out.println(aux);
        }
    }
}
