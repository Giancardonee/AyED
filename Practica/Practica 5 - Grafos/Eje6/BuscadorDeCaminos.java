package grafos.Eje6;

import java.util.LinkedList;
import java.util.List;
import only.grafos.clases_genericas.AdjListGraph;
import only.grafos.clases_genericas.Edge;
import only.grafos.clases_genericas.Graph;
import only.grafos.clases_genericas.Vertex;

public class BuscadorDeCaminos {
    private Graph<String> bosque;
    
    public BuscadorDeCaminos(Graph<String> grafo)
    {
        this.bosque = grafo;
    }
    
    public List <List<String>> recorridosMasSeguro()
    {
        List<List<String>> listaReturn = new LinkedList<>();
        if (this.bosque != null && !this.bosque.isEmpty())
        {
            Vertex<String> casaCaperucita = this.bosque.search("Casa Caperucita");
            if (casaCaperucita!= null)
            {
                recorridosHelper(casaCaperucita,this.bosque,listaReturn,new LinkedList<>(), new boolean [this.bosque.getSize()]);
            }
        }
        return listaReturn;
    }
    
    private boolean esCaminoSeguro(int frutales)
    {
        return frutales<5;
    }
    
    private void recorridosHelper (Vertex<String> lugarAct, Graph<String> grafo, List<List<String>> listaReturn,List<String> caminoActual,boolean[] marca )
    {
        marca[lugarAct.getPosition()] = true; 
        String lugar = lugarAct.getData();
        caminoActual.add(lugar);
        if (lugar.equals("Casa Abuelita"))
        {
            listaReturn.add(new LinkedList<>(caminoActual));
        }
        else
        {
            List<Edge<String>> adyacentes = this.bosque.getEdges(lugarAct);
            for (Edge<String> ady : adyacentes)
            {
                int cantFrutales = ady.getWeight(); // retorna el peso de la arista
                int j = ady.getTarget().getPosition();
                if (!marca[j] && esCaminoSeguro(cantFrutales))
                {
                    recorridosHelper(ady.getTarget(),grafo,listaReturn,caminoActual,marca);
                }
                
            }       
        }
        caminoActual.remove(caminoActual.size() - 1);
        marca[lugarAct.getPosition()] = false;
    }
    
        public static void main (String[] args) {
        Graph<String> bosque = new AdjListGraph<String>();
        Vertex<String> v1 = bosque.createVertex("Casa Caperucita");
        Vertex<String> v2 = bosque.createVertex("Claro 3");
        Vertex<String> v3 = bosque.createVertex("Claro 1");
        Vertex<String> v4 = bosque.createVertex("Claro 2");
        Vertex<String> v5 = bosque.createVertex("Claro 5");
        Vertex<String> v6 = bosque.createVertex("Claro 4");
        Vertex<String> v7 = bosque.createVertex("Casa Abuelita");
        bosque.connect(v1, v2, 4);
        bosque.connect(v2, v1, 4);
        bosque.connect(v1, v3, 3);
        bosque.connect(v3, v1, 3);
        bosque.connect(v1, v4, 4);
        bosque.connect(v4, v1, 4);
        bosque.connect(v2, v5, 15);
        bosque.connect(v5, v2, 15);
        bosque.connect(v3, v5, 3);
        bosque.connect(v5, v3, 3);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v4, v5, 11);
        bosque.connect(v5, v4, 11);
        bosque.connect(v4, v6, 10);
        bosque.connect(v6, v4, 10);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v5, v7, 4);
        bosque.connect(v7, v5, 4);
        bosque.connect(v6, v7, 9);
        bosque.connect(v7, v6, 9);
        BuscadorDeCaminos Eje6 = new BuscadorDeCaminos(bosque);
        List<List<String>> lis = Eje6.recorridosMasSeguro();
        for(List<String> l: lis) {
            System.out.println(l);
        }

    }
}
