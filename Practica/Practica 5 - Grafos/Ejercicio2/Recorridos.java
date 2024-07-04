package Practica5.Ejercicio2;

import clases_genericas.AdjListGraph;
import clases_genericas.Queue;
import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Recorridos {
    public static List<String> dfs (Graph<String> grafo)
    {
        List<String> listaReturn = new LinkedList<>();
        boolean [] visitado = new boolean[grafo.getSize()];
        for (int i = 0; i < grafo.getSize() ; i++)
        {
            if (!visitado[i])
            {
                listaReturn.add(grafo.getVertex(i).getData());
                dfs(i,grafo,listaReturn,visitado);
            }
        }
        return listaReturn;
    }
    
    private static void dfs (int i, Graph<String> grafo, List<String> listaReturn, boolean[] visitado)
    {
        visitado[i]= true;
        Vertex<String> v = grafo.getVertex(i);
        listaReturn.add(v.getData());
        List<Edge<String>> adyacentes = grafo.getEdges(v);
        for (Edge<String> ady : adyacentes)
        {
            int j = ady.getTarget().getPosition();
            if (!visitado[j])
            {
                dfs(j,grafo,listaReturn,visitado);
            }
        }
    }
    
    
    
    public static List<String> bfs (Graph<String> grafo)
    {
        List<String> listaReturn = new LinkedList<>();
        boolean [] visitado = new boolean[grafo.getSize()];
        for (int i = 0; i < visitado.length;i++)
        {
            if (!visitado[i]) {
                bfs(i,grafo,visitado,listaReturn);
            }
        }
        
        return listaReturn;
    }
    
    private static void bfs (int i, Graph<String> grafo ,boolean [] visitado, List<String> listaReturn)
    {
        Vertex<String> aux;
        Queue<Vertex<String>> cola = new Queue<>();
        cola.encolar(grafo.getVertex(i));
        visitado[i] = true;
        while (!cola.isEmpty())
        {
            aux = cola.desencolar();
            listaReturn.add(aux.getData());
            List<Edge<String>> adyacentes = grafo.getEdges(aux);
            for (Edge<String> ady : adyacentes)
            {
                int j = ady.getTarget().getPosition();
                if (!visitado[j])
                {
                    visitado[j]= true;
                    cola.encolar(ady.getTarget());
                }
            }
        }
    }
    
    
     public static void main(String[] args) {
        Graph<String> ciudades = new AdjListGraph<String>();
        
        Vertex<String> v1 = ciudades.createVertex("Buenos Aires");
        Vertex<String> v2 = ciudades.createVertex("Santiago");
        Vertex<String> v3 = ciudades.createVertex("Asunción");
        Vertex<String> v4 = ciudades.createVertex("Tokio");
        Vertex<String> v5 = ciudades.createVertex("Roma");
        Vertex<String> v6 = ciudades.createVertex("Paris");
        Vertex<String> v7 = ciudades.createVertex("Madrid");
        Vertex<String> v8 = ciudades.createVertex("Caracas");
        ciudades.connect(v1, v2);
        ciudades.connect(v1, v3);
        ciudades.connect(v2, v5);
        ciudades.connect(v3, v7);
        ciudades.connect(v3, v8);
        ciudades.connect(v8, v7);
        ciudades.connect(v8, v4);
        ciudades.connect(v5, v4);
        ciudades.connect(v7, v4);
        ciudades.connect(v6, v5);
        ciudades.connect(v6, v7);
        ciudades.connect(v6, v4);
        ciudades.connect(v4, v1);
        
        List<String> lisDFS = Recorridos.dfs(ciudades);
        //List<String> lisBFS = rec.bfs(ciudades);
        
        System.out.print("Lista DFS: ");
        for (String e: lisDFS){
            System.out.print(e + " ~ ");
        }
        
        System.out.println("");
        
        
        System.out.print("Lista BFS: ");
        List<String> lisBFS = Recorridos.bfs(ciudades);
        
        for (String e: lisBFS){
            System.out.print(e + " ~ ");
        }

    }
    
}
