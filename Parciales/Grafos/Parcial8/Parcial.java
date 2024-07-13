package parcialesgrafos.Parcial8;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import parcialesgrafos.clasesGenericas.AdjListGraph;
import parcialesgrafos.clasesGenericas.Edge;
import parcialesgrafos.clasesGenericas.Graph;
import parcialesgrafos.clasesGenericas.Vertex;

public class Parcial {
    
    public List<Ciudad> resolver (Graph<Ciudad> ciudades, String origen, String destino)
    {
        List<Ciudad> listaReturn = new LinkedList<>();
        if (ciudades != null && !ciudades.isEmpty() && !origen.isEmpty() && !destino.isEmpty())
        {
            VerticesAuxiliar aux = buscarVertices(ciudades,origen,destino);
            if (aux.encontreAmbosVertices())
            {
                dfs(ciudades,aux.getvOrigen(), aux.getvDestino(), new boolean[ciudades.getSize()],listaReturn);
            }
        }   
        return listaReturn;
    }
    
    
    private VerticesAuxiliar buscarVertices(Graph<Ciudad> ciudades, String origen, String destino)
    {
        VerticesAuxiliar auxReturn = new VerticesAuxiliar();
        
        List<Vertex<Ciudad>> adyacentes = ciudades.getVertices();
        Iterator<Vertex<Ciudad>> iterator = adyacentes.iterator();
        while (iterator.hasNext() && !auxReturn.encontreAmbosVertices())
        {
            Vertex<Ciudad> vAux = iterator.next();
            if (vAux.getData().getNombre().equals(origen)) auxReturn.setvOrigen(vAux);
            else if (vAux.getData().getNombre().equals(destino)) auxReturn.setvDestino(vAux);       
        }
        return auxReturn;
    }
    
    private boolean dfs (Graph<Ciudad> ciudades, Vertex<Ciudad>vActual, Vertex<Ciudad>vDestino, boolean[]marca, List<Ciudad> listaReturn)
    {
        marca[vActual.getPosition()] = true;
        listaReturn.add(vActual.getData());
        
        boolean encontreDestino=false;
        if (vActual.equals(vDestino)) return true;
        
        List<Edge<Ciudad>> adyacentes = ciudades.getEdges(vActual);
        Iterator<Edge<Ciudad>> iterador = adyacentes.iterator();
       
        while (iterador.hasNext() && !encontreDestino)
        {
            Edge<Ciudad> e = iterador.next();
            Vertex<Ciudad> vAdy = e.getTarget();
            int j = vAdy.getPosition();
            if (!marca[j] && vAdy.getData().getFase()!= 1)
            {
                marca[j] = true;
                encontreDestino = dfs(ciudades,vAdy,vDestino,marca,listaReturn);
            }
        }
       
        if (!encontreDestino)
        {
            listaReturn.remove(listaReturn.size() - 1 );
        }
        marca[vActual.getPosition()] = false; 
        return encontreDestino;
    }
    
     public static void main(String args[]) {
        Graph<Ciudad> grafo = new AdjListGraph<Ciudad>();
        //Descarte Saladillo, Lobos y Pinamar
        Vertex<Ciudad> v1 = grafo.createVertex(new Ciudad("Suipacha", 5));
        Vertex<Ciudad> v2 = grafo.createVertex(new Ciudad("Carlos Keen", 3));
        Vertex<Ciudad> v3 = grafo.createVertex(new Ciudad("Moreno", 1));
        Vertex<Ciudad> v4 = grafo.createVertex(new Ciudad("Quilmes", 1));
        Vertex<Ciudad> v5 = grafo.createVertex(new Ciudad("Navarro", 4));
        Vertex<Ciudad> v6 = grafo.createVertex(new Ciudad("Cañuelas", 3));
        Vertex<Ciudad> v7 = grafo.createVertex(new Ciudad("Abasto", 2));
        Vertex<Ciudad> v8 = grafo.createVertex(new Ciudad("La Plata", 2));
        
        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);
        grafo.connect(v3, v4);
        grafo.connect(v4, v3);
        grafo.connect(v1, v5);
        grafo.connect(v5, v1);
        grafo.connect(v5, v6);
        grafo.connect(v6, v5);
        grafo.connect(v6, v7);
        grafo.connect(v7, v6);
        grafo.connect(v7, v3);
        grafo.connect(v3, v7);
        grafo.connect(v7, v8);
        grafo.connect(v8, v7);
        grafo.connect(v8, v4);
        grafo.connect(v4, v8);
        
        Parcial p = new Parcial();
        
        System.out.println(p.resolver(grafo, "La Plata", "Carlos Keen"));
        
    }
}
