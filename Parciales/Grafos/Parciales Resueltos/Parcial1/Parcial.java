package parcialesgrafos.Parcial1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import parcialesgrafos.clasesGenericas.AdjListGraph;
import parcialesgrafos.clasesGenericas.Edge;
import parcialesgrafos.clasesGenericas.Graph;
import parcialesgrafos.clasesGenericas.Vertex;


public class Parcial {
    
    public List<String> resolver (Graph<Ciudad> mapa, String ciudad, int cantDiasVacas)
    {
        List<String> listaReturn = new LinkedList<>();
        if (mapa!= null && !mapa.isEmpty())
        {
            
            Vertex<Ciudad> origen = buscarCiudadEnMapa(ciudad,mapa);
            if (origen != null)
            {
                helper(origen,mapa,listaReturn,cantDiasVacas,new LinkedList<>(), new boolean [mapa.getSize()],origen.getData().getDias());
            }
        }
        
        return listaReturn;
    }
    
    private Vertex<Ciudad> buscarCiudadEnMapa (String ciudad, Graph<Ciudad> mapa)
    {
        List<Vertex<Ciudad>> vertices = mapa.getVertices();
        for (Vertex<Ciudad> vActual : vertices)
        {
            if (vActual.getData().getNombre().equals(ciudad)) return vActual;
        }
       return null;
    }
    
    private void helper (Vertex<Ciudad> actual, Graph<Ciudad> mapa, List<String> listaReturn,int diasVacaciones,List<String> listaActual, boolean[] marca, int diasOcupados)
    {
        marca[actual.getPosition()] = true;
        listaActual.add(actual.getData().getNombre());
        
        if ( (diasOcupados == diasVacaciones) && (listaActual.size() > listaReturn.size()))
        {
            listaReturn.clear();
            listaReturn.addAll(listaActual);
        }
        else
        {
           
            List<Edge<Ciudad>> adyacentes = mapa.getEdges(actual);
            for (Edge<Ciudad> ady : adyacentes)
            {
                Vertex<Ciudad> v = ady.getTarget();
                int j = v.getPosition();
                int diasNecesariosVisitaCiudad = v.getData().getDias();
                if (!marca[j] && (diasNecesariosVisitaCiudad + diasOcupados) <= diasVacaciones)
                {
                    helper(ady.getTarget(),mapa,listaReturn,diasVacaciones,listaActual,marca,(diasOcupados+diasNecesariosVisitaCiudad));
                }
            }
        }
        
        listaActual.remove(listaActual.size() - 1 );
        marca[actual.getPosition()] = false;
    }
    
    
    public static void main(String args[]) {
        Graph<Ciudad> mapa = new AdjListGraph<Ciudad>();
        Vertex<Ciudad> MarDelPlata = mapa.createVertex(new Ciudad(7, "Mar Del Plata"));
        Vertex<Ciudad> Pila = mapa.createVertex(new Ciudad(1, "Pila"));
        Vertex<Ciudad> Dolores = mapa.createVertex(new Ciudad(1, "Dolores"));
        Vertex<Ciudad> Chascomus = mapa.createVertex(new Ciudad(1, "Chascomús"));
        Vertex<Ciudad> MarAzul = mapa.createVertex(new Ciudad(3, "Mar Azul"));
        Vertex<Ciudad> Pinamar = mapa.createVertex(new Ciudad(4, "Pinamar"));
        Vertex<Ciudad> Madariaga = mapa.createVertex(new Ciudad(1, "Madariaga"));
        Vertex<Ciudad> LaPlata = mapa.createVertex(new Ciudad(5, "La Plata"));
        Vertex<Ciudad> LasGaviotas = mapa.createVertex(new Ciudad(1, "Las Gaviotas"));
        Vertex<Ciudad> Querandi = mapa.createVertex(new Ciudad(1, "Querandi"));
        Vertex<Ciudad> Hudson = mapa.createVertex(new Ciudad(1, "Hudson"));
        
        mapa.connect(MarDelPlata, Pila);
        mapa.connect(Pila, MarDelPlata);
        mapa.connect(Pila, Dolores);
        mapa.connect(Dolores, Pila);
        mapa.connect(Dolores, Chascomus);
        mapa.connect(Chascomus, Dolores);
        
        mapa.connect(MarDelPlata, MarAzul);
        mapa.connect(MarAzul, MarDelPlata);
        mapa.connect(MarAzul, Pinamar);
        mapa.connect(Pinamar, MarAzul);
        mapa.connect(Pinamar, Madariaga);
        mapa.connect(Madariaga, Pinamar);
        mapa.connect(Dolores, Madariaga);
        mapa.connect(Madariaga, Dolores);
        mapa.connect(Madariaga, LaPlata);
        mapa.connect(LaPlata, Madariaga);
        mapa.connect(Chascomus, LaPlata);
        mapa.connect(LaPlata, Chascomus);
        
        mapa.connect(MarAzul, LasGaviotas);
        mapa.connect(LasGaviotas, MarAzul);
        mapa.connect(MarAzul, Querandi);
        mapa.connect(Querandi, MarAzul);
        mapa.connect(LaPlata, Hudson);
        mapa.connect(Hudson, LaPlata);
        
        Parcial p = new Parcial();
        System.out.println(p.resolver(mapa, "Mar Del Plata", 15));
    }
}
