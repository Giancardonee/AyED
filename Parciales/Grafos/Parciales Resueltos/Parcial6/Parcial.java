package parcialesgrafos.Parcial6;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import parcialesgrafos.clasesGenericas.AdjListGraph;
import parcialesgrafos.clasesGenericas.Edge;
import parcialesgrafos.clasesGenericas.Graph;
import parcialesgrafos.clasesGenericas.Vertex;

public class Parcial {
    public List<String> caminoConPresupuesto(Graph<String> ciudades, String origen, String destino, int montoMaximo)
    {
        List<String> listaReturn = new LinkedList<>();
        if (ciudades != null && !ciudades.isEmpty() && montoMaximo > 0 )
        {
            Vertex<String> vOrigen = ciudades.search(origen);
            Vertex<String> vDestino = ciudades.search(destino);
            if (vOrigen != null && vDestino != null)
            {
                recorrido(ciudades,vOrigen,vDestino,montoMaximo,0,listaReturn, new boolean[ciudades.getSize()]);
            }
            
        }
        return listaReturn;
    }
    
    private boolean recorrido(Graph<String> ciudades, Vertex<String> vActual, Vertex<String> vDestino, int montoMaximo, int montoActual, List<String> listaReturn, boolean[]marca)
    {
        boolean encontreDestino = false ; 
        marca[vActual.getPosition()] = true;
        
        listaReturn.add(vActual.getData());
        
        if (vActual.getData().equals(vDestino.getData()))
        {
            return true;
        }
        else
        {
            List<Edge<String>> adyacentes = ciudades.getEdges(vActual);
            Iterator<Edge<String>> iterador = adyacentes.iterator();
            while (iterador.hasNext() && !encontreDestino)
            {
                Edge<String> e = iterador.next();
                int precioPeaje = e.getWeight();
                Vertex<String> vAdy = e.getTarget();
                int j = vAdy.getPosition();
                
                if (!marca[j] && (montoActual+precioPeaje) <= montoMaximo)
                {
                    encontreDestino = recorrido(ciudades,vAdy,vDestino,montoMaximo,(montoActual+precioPeaje),listaReturn,marca);
                }
            }
            
           if (!encontreDestino)
           {
               listaReturn.remove(listaReturn.size() - 1 );
               marca[vActual.getPosition()] = false;
           }
           
        }
        
        return encontreDestino;
    }
    public static void main(String args[]) {
        Graph<String> grafo = new AdjListGraph<String>();
        Vertex<String> v1 = grafo.createVertex("Lincoln");
        Vertex<String> v2 = grafo.createVertex("Chascomús");
        Vertex<String> v3 = grafo.createVertex("Cañuelas");
        Vertex<String> v4 = grafo.createVertex("Dolores");
        Vertex<String> v5 = grafo.createVertex("Verónica");
        Vertex<String> v6 = grafo.createVertex("Villa Urquiza");
        Vertex<String> v7 = grafo.createVertex("Ranchos");
        Vertex<String> v8 = grafo.createVertex("Berisso");
        
        grafo.connect(v1, v2, 70);
        grafo.connect(v2, v1, 70);
        grafo.connect(v1, v3, 50);
        grafo.connect(v3, v1, 50);
        grafo.connect(v1, v4, 90);
        grafo.connect(v4, v1, 90);
        grafo.connect(v2, v5, 80);
        grafo.connect(v5, v2, 80);
        grafo.connect(v2, v6, 60);
        grafo.connect(v6, v2, 60);
        grafo.connect(v3, v5, 85);
        grafo.connect(v5, v3, 85);
        grafo.connect(v3, v7, 90);
        grafo.connect(v7, v3, 90);
        grafo.connect(v4, v6, 70);
        grafo.connect(v6, v4, 70);
        grafo.connect(v4, v7, 70);
        grafo.connect(v7, v4, 70);
        grafo.connect(v5, v8, 60);
        grafo.connect(v8, v5, 60);
        grafo.connect(v6, v8, 90);
        grafo.connect(v8, v6, 90);
        grafo.connect(v7, v8, 75);
        grafo.connect(v8, v7, 75);
        
        Parcial p = new Parcial();
        
        System.out.println(p.caminoConPresupuesto(grafo, "Lincoln", "Berisso", 200));
    }
}
