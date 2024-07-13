
package parcialesgrafos.ParcialSegundaFechaTema1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import parcialesgrafos.clasesGenericas.AdjListGraph;
import parcialesgrafos.clasesGenericas.Edge;
import parcialesgrafos.clasesGenericas.Graph;
import parcialesgrafos.clasesGenericas.Queue;
import parcialesgrafos.clasesGenericas.Vertex;

public class Parcial {

    public List<auxiliar> invitacionMasterClass (Graph<String> red, String usuario, int distancia, int limite)
    {
        List<auxiliar> listaReturn = new LinkedList<>();
        if (red != null & !red.isEmpty() && distancia>0 && limite >0)
        {
            Vertex<String> verticeUsuario = red.search(usuario);
            if (verticeUsuario != null)
            {
               bfs(red,verticeUsuario,distancia,limite,listaReturn);
            }
        }
        
        return listaReturn;
    }

    private void bfs (Graph<String> red, Vertex<String> verticeUsuario, int distancia , int limite,List<auxiliar> listaReturn)
    {
        boolean [] marca = new boolean[red.getSize()];
        marca[verticeUsuario.getPosition()] = true;  
        int distanciaActual=0;
        Queue<Vertex<String>> cola = new Queue<>();
        int contadorPersonasAgregadas=0; 
        cola.enqueue(verticeUsuario);
        cola.enqueue(null);
        
        Vertex<String> aux;
        while (!cola.isEmpty() && distanciaActual < distancia && hayCapacidadEnLista(contadorPersonasAgregadas,limite))
        {
            aux = cola.dequeue();
            if (aux != null)
            {
                List<Edge<String>> adyacentes = red.getEdges(aux);
                Iterator<Edge<String>> iterador = adyacentes.iterator();
                
                while (iterador.hasNext() && hayCapacidadEnLista(contadorPersonasAgregadas, limite))
                {
                    Edge<String> e = iterador.next();
                    Vertex<String> v = e.getTarget();
                    int j = v.getPosition();
                    if (!marca[j])
                    {
                           contadorPersonasAgregadas++;
                           listaReturn.add(new auxiliar(v.getData(),distanciaActual+1)); // +1 porque son los adyacentes. 
                           marca[v.getPosition()] = true;
                           cola.enqueue(v);                  
                    }          
                }     
            }
            else if (!cola.isEmpty())
            {
                cola.enqueue(null);
                distanciaActual++;
            }      
        }
        
      
    }
    
    private boolean hayCapacidadEnLista(int capacidadLista, int limite)
    {
        return capacidadLista<limite;
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
        
        Parcial p = new Parcial();
        
        System.out.println(p.invitacionMasterClass(grafo, "Lionel", 2, 4));
        System.out.println(p.invitacionMasterClass(grafo, "Juancito", 1, 2));
    }
}
