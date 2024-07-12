package parcialesgrafos.Parcial2;

import java.util.List;
import parcialesgrafos.clasesGenericas.AdjListGraph;
import parcialesgrafos.clasesGenericas.Edge;
import parcialesgrafos.clasesGenericas.Graph;
import parcialesgrafos.clasesGenericas.Vertex;

public class Parcial2 {
    
    public int resolver (Graph<Recinto> sitios, int tiempo)
    {
        int valorReturn = 0;
        if (sitios!= null && !sitios.isEmpty() && tiempo>0 )
        {
            Vertex<Recinto> verticeEntrada = buscarVerticeEntrada(sitios);
            if (verticeEntrada != null)
            {
                if (verticeEntrada.getData().getTiempo() < tiempo)
                {
                    valorReturn = helper(verticeEntrada,sitios,tiempo,0,Integer.MIN_VALUE,1,new boolean[sitios.getSize()]);
                }
            }
        }
            
        return valorReturn;
    }
    
    private Vertex<Recinto> buscarVerticeEntrada(Graph<Recinto> sitios)
    {
        List<Vertex<Recinto>> vertices = sitios.getVertices();
        for (Vertex<Recinto> vActual : vertices)
        {
            if (vActual.getData().getNombre().equals("Entrada")) return vActual;
        }
        return null;
    }
    
    private int helper (Vertex<Recinto> vActual , Graph<Recinto> mapa, int tiempoMaximo,int tiempoActual,int max,int cantVisitados,boolean[]marca)
    {
        marca[vActual.getPosition()] = true; 
        int tiempoRecinto= vActual.getData().getTiempo();
        
        List<Edge<Recinto>> adyacentes =  mapa.getEdges(vActual);
        for (Edge<Recinto> ady : adyacentes)
        {
            Vertex<Recinto> verticeAdyacente = ady.getTarget();
            int j = verticeAdyacente.getPosition();// nos traemos la posicion del arista destino
            int tiempoViaje = ady.getWeight();// peso de la arista = peso del viaje 
            int tiempoProximoRecinto = verticeAdyacente.getData().getTiempo(); // nos traemos el tiempo del proximo recinto
            int tiempoTranscurrido = (tiempoRecinto+tiempoViaje + tiempoProximoRecinto) +tiempoActual;
            if (!marca[j] && (tiempoTranscurrido)  <= tiempoMaximo)
            {
                max = helper(verticeAdyacente, mapa, tiempoMaximo, tiempoTranscurrido, max, cantVisitados++, marca);
            }
        }
        
        max = Math.max(cantVisitados, max);
        marca[vActual.getPosition()] = false;
        
        return max;
    }
      public static void main(String args[]) {
        Graph<Recinto> grafo = new AdjListGraph<>();
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
        grafo.connect(Entrada, Tigres, 10);
        grafo.connect(Tigres, Entrada, 10);
        grafo.connect(Entrada, Murcielagos, 20);
        grafo.connect(Murcielagos, Entrada, 20);
        grafo.connect(Entrada, Flamencos, 25);
        grafo.connect(Flamencos, Entrada, 25);
        
        grafo.connect(Tigres, Cebras, 8);
        grafo.connect(Cebras, Tigres, 8);
        grafo.connect(Cebras, Tortugas, 10);
        grafo.connect(Tortugas, Cebras, 10);
        grafo.connect(Flamencos, Murcielagos, 25);
        grafo.connect(Murcielagos, Flamencos, 25);
        grafo.connect(Murcielagos, Wallabies, 10);
        grafo.connect(Wallabies, Murcielagos, 10);
        grafo.connect(Wallabies, Tortugas, 10);
        grafo.connect(Tortugas, Wallabies, 10);
        grafo.connect(Tortugas, Pumas, 15);
        grafo.connect(Pumas, Tortugas, 15);
        
        Parcial2 p = new Parcial2();
        
        System.out.println(p.resolver(grafo, 100));
        System.out.println(p.resolver(grafo, 30));
    }
    
}
