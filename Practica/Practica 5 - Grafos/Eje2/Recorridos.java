import java.util.LinkedList;
import java.util.List;
import only.grafos.clases_genericas.AdjListGraph;
import only.grafos.clases_genericas.Edge;
import only.grafos.clases_genericas.Graph;
import only.grafos.clases_genericas.Queue;
import only.grafos.clases_genericas.Vertex;


public class Recorridos {
    public static List<String> dfs (Graph<String> grafo)
    {
        List<String> listaReturn = new LinkedList<>();
        boolean [] marca = new boolean[grafo.getSize()];
        for (int i=0; i < grafo.getSize(); i++)
        {
            if (!marca[i])
            {
                //System.out.println("Dato del vertice: "+grafo.getVertex(i).getData());
                dfs(i,grafo,marca,listaReturn);
            }
        }
        return listaReturn;
    }
    
    private static void dfs (int i , Graph<String> grafo, boolean[] marca,List<String> listaReturn)
    {
        marca[i]=true;
        Vertex<String> v = grafo.getVertex(i);
        listaReturn.add(v.getData());
        List<Edge<String>> adyacentes = grafo.getEdges(v);
        for (Edge<String> ady : adyacentes)
        {
            int j = ady.getTarget().getPosition();
            if (!marca[j])
            {
                dfs(j,grafo,marca,listaReturn); 
            }
        }
    }
    
    public static List<String> bfs (Graph<String> grafo)
    {
        List<String> listaReturn = new LinkedList<>();
        boolean [] marca = new boolean [grafo.getSize()];
        for (int i=0; i < grafo.getSize(); i++)
        {
            if (!marca[i])
            {
                bfs(i,grafo,marca,listaReturn);
            }
        }
        return listaReturn;
    }
    
    private static void bfs(int i, Graph<String> grafo, boolean [] marca, List<String> listaReturn)
    {
        Queue<Vertex<String>> cola = new Queue<>();
        cola.enqueue(grafo.getVertex(i));
        marca[i]=true;
        while (!cola.isEmpty())
        {
            Vertex<String> v = cola.dequeue();
            listaReturn.add(v.getData());
            // para todos los adyacentes de v: 
            List<Edge<String>> adyacentes = grafo.getEdges(v);
            for (Edge<String> ady : adyacentes)
            {
                int j = ady.getTarget().getPosition();
                if (!marca[j])
                {
                    marca[j] = true;
                    cola.enqueue(ady.getTarget());
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
