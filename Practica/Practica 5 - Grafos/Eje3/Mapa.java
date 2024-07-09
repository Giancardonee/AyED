
import grafos.Eje3.AuxMin;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import only.grafos.clases_genericas.AdjListGraph;
import only.grafos.clases_genericas.Edge;
import only.grafos.clases_genericas.Graph;
import only.grafos.clases_genericas.Vertex;

public class Mapa {

    private Graph<String> mapaCiudades;

    public Mapa(Graph<String> grafo) {
        this.mapaCiudades = grafo;
    }
    
    /* 
    1. devolverCamino (String ciudad1, String ciudad2): List<String>
    Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso de que se
    pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible)
    */
    public List<String> devolverCamino(String ciudad1, String ciudad2) {
        List<String> listaReturn= null;
        if (this.mapaCiudades != null && !this.mapaCiudades.isEmpty()) {
            Vertex<String> ciudadOrigen = mapaCiudades.search(ciudad1);
            Vertex<String> ciudadDestino = mapaCiudades.search(ciudad2);
            if (ciudadOrigen != null && ciudadDestino != null) {
                listaReturn = new LinkedList<>();
                devolverCamino(new boolean[mapaCiudades.getSize()], ciudadOrigen, ciudadDestino, listaReturn);
            } else {
                System.out.println("No existe un camino entre las ciudades " + ciudad1 + " y " + ciudad2);
            }
        }
        return listaReturn;
    }

    private boolean devolverCamino(boolean[] marca, Vertex<String> ciudadOrigen, Vertex<String> ciudadDestino, List<String> listaReturn) {
        marca[ciudadOrigen.getPosition()] = true; // marcamos la ciudad como visitada
        listaReturn.add(ciudadOrigen.getData());
        boolean caminoEncontrado = false;
        if (ciudadOrigen.equals(ciudadDestino)) // si coinciden las ciudades, encontramos el camino
        {
            return true;
        } else {
            List<Edge<String>> adyacentes = mapaCiudades.getEdges(ciudadOrigen);
            Iterator<Edge<String>> iterador = adyacentes.iterator();
            while (iterador.hasNext() && !caminoEncontrado) {
                Vertex<String> v = iterador.next().getTarget();
                int j = v.getPosition();
                if (!marca[j]) {
                    caminoEncontrado = devolverCamino(marca, v, ciudadDestino, listaReturn);
                }
            }
        }
        // si no encontramos todavia el camino, caminoEncontrado = false
        // si caminoEncontrado = false, le restamos uno para al volver de la recursion tener la lista actualizada
        if (!caminoEncontrado) {
            listaReturn.remove(listaReturn.size() - 1);
            // marca[ciudadOrigen.getPosition()] = false; no es necesario en este caso. 
        }
        return caminoEncontrado;
    }
    //================================================================================================================
    /* 
    2. devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades): List<String>
    Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades
    que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
    vacía. (Sin tener en cuenta el combustible).
    */
        
    public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudadesRestringidas) {
        List<String> listaReturn = null;
        if (mapaCiudades != null && !mapaCiudades.isEmpty()) {
            Vertex<String> origen = mapaCiudades.search(ciudad1);
            Vertex<String> destino = mapaCiudades.search(ciudad2);
            if (origen != null && destino != null) {
                listaReturn = new LinkedList<>();
                caminoExceptuandoHelper(origen, destino, listaReturn, ciudadesRestringidas, new boolean[mapaCiudades.getSize()]);
            }
        }
        return listaReturn;
    }

    private boolean caminoExceptuandoHelper(Vertex<String> actual, Vertex<String> destino, List<String> listaReturn, List<String> ciudadesRestringidas, boolean[] marca) {
        marca[actual.getPosition()] = true; // marcamos como visitado
        boolean encontre = false;
        // si es una ciudad restringida no la procesamos.
        if (!ciudadesRestringidas.contains(actual.getData())) {
            listaReturn.add(actual.getData());
            if (actual.equals(destino)) { // retornamos true porque encontramos el destino. 
                return true;
            } else {
                List<Edge<String>> adyacentes = mapaCiudades.getEdges(actual);
                Iterator<Edge<String>> iterador = adyacentes.iterator();
                // iteramos mientras tengamos adyacentes y mientras no encontremos el destino
                while (iterador.hasNext() && !encontre) {
                    Vertex<String> v = iterador.next().getTarget();
                    int j = v.getPosition();
                    if (!marca[j]) {
                        encontre = caminoExceptuandoHelper(v, destino, listaReturn, ciudadesRestringidas, marca);
                    }
                }     
         //Si no encontramos, al volver de la recursion, le restamos la ultima ciudad, para mantenerla lista actualizada.
                if (!encontre) {
                    listaReturn.remove(listaReturn.size() - 1);
                    //marca[actual.getPosition()] = false; En este caso no es necesario. 
                }
            }
        }
        return encontre;
    }
  //================================================================================================================
    /*
    3. caminoMasCorto(String ciudad1, String ciudad2): List<String>
    Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no
    existe camino retorna la lista vacía. (Las rutas poseen la distancia).
    */
    
    // Version 1: Usando una clase Auxiliar 
    public List<String> caminoMasCorto(String ciudad1, String ciudad2)
    {
         AuxMin auxiliar = new AuxMin();
        if (mapaCiudades != null && !mapaCiudades.isEmpty())
        {
            Vertex<String> origen = mapaCiudades.search(ciudad1);
            Vertex<String> destino = mapaCiudades.search(ciudad2);
            if (origen != null && destino!= null)
            {
                caminoMasCortoHelper(origen,destino,new LinkedList<>(),new boolean[mapaCiudades.getSize()],auxiliar,0);
            }
        }
        return auxiliar.getCiudades();
    }
   
    
    private void caminoMasCortoHelper(Vertex<String> actual, Vertex<String> destino,List<String> listaActual, boolean[] marca, AuxMin aux,int distanciaAct)
    {
        int distanciaMin = aux.getDistancia();
        marca[actual.getPosition()] = true;
        listaActual.add(actual.getData());
        if (actual.equals(destino))
        {
            if (distanciaAct < distanciaMin)
            {
                aux.setDistancia(distanciaAct);
                aux.actualizarLista(listaActual);
            }
        }
        else
        {
            List <Edge<String>> adyacentes = mapaCiudades.getEdges(actual);
            for (Edge<String> ady : adyacentes)
            {
                int j = ady.getTarget().getPosition();
                int pesoArista = ady.getWeight();
                if (!marca[j] && ( distanciaAct + pesoArista) < distanciaMin)
                {
                    caminoMasCortoHelper(ady.getTarget(), destino, listaActual, marca,aux, distanciaAct + pesoArista);
                }
            }
        }
        listaActual.remove(listaActual.size() - 1 );
        marca[actual.getPosition()] = false;
   }
   // version 2: Sin usar una clase auxiliar.
     public List<String> caminoMasCorto2(String ciudad1, String ciudad2)
    {
        List<String> listaReturn = new LinkedList<>();
        if (mapaCiudades != null && !mapaCiudades.isEmpty())
        {
            Vertex<String> origen = mapaCiudades.search(ciudad1);
            Vertex<String> destino = mapaCiudades.search(ciudad2);
            if (origen != null && destino!= null)
            {
                caminoMasCortoHelper2(origen, destino, new LinkedList<>(), listaReturn, 0, new boolean[mapaCiudades.getSize()], Integer.MAX_VALUE);
            }
        }
        return listaReturn;
    } 
    
   private int caminoMasCortoHelper2(Vertex<String> actual, Vertex<String> destino, List<String> listaActual,List<String> listaMin, int distanciaAct, boolean[] marca,int min)
   {       
       marca[actual.getPosition()] = true ;
       listaActual.add(actual.getData());
       
       if (actual.equals(destino) && distanciaAct < min )
       {
           listaMin.clear();
           listaMin.addAll(listaActual);
           min = distanciaAct;
       }
       else
       {
           List<Edge<String>> adyacentes = mapaCiudades.getEdges(actual);
           Iterator<Edge<String>> iterador = adyacentes.iterator();
           while (iterador.hasNext() && distanciaAct < min)
           {
               Edge<String> e = iterador.next();
               int j = e.getTarget().getPosition();
               int total = distanciaAct + e.getWeight();
               if (!marca[j] && total < min)
                   min = caminoMasCortoHelper2(e.getTarget(), destino, listaActual, listaMin, total, marca,min);
           }
       }
       listaActual.remove(listaActual.size() - 1 );
       marca[actual.getPosition()] = false;
       return min;  
   }
   
   
   /* inciso 4: 
    caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto): List<String>
    Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe
    quedarse sin combustible y no puede cargar. Si no existe camino retorna la lista vacía.
   */ 
   public List<String>caminoSinCargarCombustible (String ciudad1, String ciudad2, int tanqueAuto)
   {
       List<String> listaReturn = new LinkedList<>();
       if (mapaCiudades != null && !mapaCiudades.isEmpty())
       {
           Vertex<String> origen = mapaCiudades.search(ciudad1); 
           Vertex<String> destino = mapaCiudades.search(ciudad2);
           if (origen != null && destino != null && tanqueAuto > 0)
           {
               caminoSinCargarCombustibleHelper(origen,destino, new boolean[mapaCiudades.getSize()],tanqueAuto,listaReturn);
           }
       }
       return listaReturn; 
   } 
   
   private boolean caminoSinCargarCombustibleHelper (Vertex<String> ciudadActual, Vertex<String> destino, boolean[] marca, int tanqueAuto, List<String> listaReturn)
   {
       boolean encontreDestino = false;
       marca[ciudadActual.getPosition()] = true;
       listaReturn.add(ciudadActual.getData());
       
       if (ciudadActual.equals(destino) && tanqueAuto > 0)
       {
           return true;
       }
       else
       {
           List<Edge<String>> adyacentes = mapaCiudades.getEdges(ciudadActual); 
           Iterator<Edge<String>> iterador = adyacentes.iterator(); 
           while (iterador.hasNext() && !encontreDestino && tanqueAuto > 0)
           {
               Edge<String> e = iterador.next();
               int j = e.getTarget().getPosition();
               int costoCombustible = e.getWeight();
               if (!marca[j] && (tanqueAuto - costoCombustible) > 0)
               {
                   encontreDestino = caminoSinCargarCombustibleHelper(e.getTarget(), destino, marca, tanqueAuto - costoCombustible, listaReturn);
               }
           }
       }
       if (!encontreDestino)
       {
           listaReturn.remove(listaReturn.size() - 1 );
       }    
       marca[ciudadActual.getPosition()] = false;
       return encontreDestino;
   }
   
   /*
    Inciso 5 : 
    caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto): List<String>
    Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2 teniendo en cuenta
    que el auto debe cargar la menor cantidad de veces. El auto no se debe quedar sin combustible en
    medio de una ruta, además puede completar su tanque al llegar a cualquier ciudad. Si no existe camino
    retorna la lista vacía.
   */
   
   public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto)
   {
       List<String> listaReturn = new LinkedList<>();
       if (mapaCiudades != null && !mapaCiudades.isEmpty())
       {
           Vertex<String> origen = mapaCiudades.search(ciudad1);
           Vertex<String> destino = mapaCiudades.search(ciudad2);
           if (origen != null && destino != null)
           {
               inciso5Helper(origen,destino,new boolean[mapaCiudades.getSize()],tanqueAuto,Integer.MAX_VALUE,0,listaReturn,new LinkedList<>());
           }
       }
       return listaReturn;
   }
   
   private int inciso5Helper(Vertex<String> ciudadActual, Vertex<String> ciudadDestino, boolean[] marca, int tanqueAuto, int min, int vecesCargadas,List<String> caminoMin, List<String> caminoAct)
   {
       marca[ciudadActual.getPosition()] = true;
       caminoAct.add(ciudadActual.getData());
       
       if (ciudadActual.equals(ciudadDestino) && (tanqueAuto > 0) && (vecesCargadas < min) )
       {
          caminoMin.clear();
          caminoMin.addAll(caminoAct);
          min = vecesCargadas;
       }
       else
       {
           List<Edge<String>> adyacentes = mapaCiudades.getEdges(ciudadActual);
           for (Edge<String> ady : adyacentes)
           {
               int j = ady.getTarget().getPosition();
               int costoCombustible = ady.getWeight();
               if (!marca[j])
               {
                   if (tanqueAuto - costoCombustible <= 0)
                   {
                       tanqueAuto = 100;
                       vecesCargadas++;
                   }
                   //System.out.println("Minimo: "+min);
                   //System.out.println("Veces cargadas: "+vecesCargadas);
                   min = inciso5Helper(ady.getTarget(),ciudadDestino,marca,tanqueAuto,min,vecesCargadas,caminoMin,caminoAct);
               }
           }
       }
       caminoAct.remove(caminoAct.size() - 1 );
       marca[ciudadActual.getPosition()] = false;  
       return min;
   }
   
   
    public static void main(String[] args) {
        Graph<String> mapaCiudades = new AdjListGraph<>();
        Vertex<String> v1 = mapaCiudades.createVertex("La Plata"); //Casa Caperucita
        Vertex<String> v2 = mapaCiudades.createVertex("Ensenada"); //Claro 3
        Vertex<String> v3 = mapaCiudades.createVertex("Berisso"); //Claro 1
        Vertex<String> v4 = mapaCiudades.createVertex("Berazategui"); //Claro 2
        Vertex<String> v5 = mapaCiudades.createVertex("Florencio Varela"); //Claro 5
        Vertex<String> v6 = mapaCiudades.createVertex("Presidente Peron"); //Claro 4
        Vertex<String> v7 = mapaCiudades.createVertex("San Vicente"); //Casa Abuelita
        mapaCiudades.connect(v1, v2, 4);
        mapaCiudades.connect(v2, v1, 4);
        mapaCiudades.connect(v1, v3, 3);
        mapaCiudades.connect(v3, v1, 3);
        mapaCiudades.connect(v1, v4, 4);
        mapaCiudades.connect(v4, v1, 4);
        mapaCiudades.connect(v2, v5, 15);
        mapaCiudades.connect(v5, v2, 15);
        mapaCiudades.connect(v3, v5, 3);
        mapaCiudades.connect(v5, v3, 3);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v4, v5, 11);
        mapaCiudades.connect(v5, v4, 11);
        mapaCiudades.connect(v4, v6, 10);
        mapaCiudades.connect(v6, v4, 10);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v5, v7, 4);
        mapaCiudades.connect(v7, v5, 4);
        mapaCiudades.connect(v6, v7, 9);
        mapaCiudades.connect(v7, v6, 9);

        Mapa Ejercicio3 = new Mapa(mapaCiudades);

        System.out.println("Inciso 1: ");
        String origen = "La Plata";
        String destino = "San Vicente";
        System.out.println("Un camino desde " + origen + " hasta " + destino + " es : ");
        System.out.println(Ejercicio3.devolverCamino(origen, destino));

        System.out.println("=====================================================================");
        System.out.println("");
        
        
        System.out.println("Inciso 2: ");
        List<String> localidadesRestringidas = new LinkedList<>();
        localidadesRestringidas.add("Berisso");
        System.out.println(Ejercicio3.devolverCaminoExceptuando(origen, destino, localidadesRestringidas));
        
       System.out.println("=====================================================================");
        System.out.println("");
        
        System.out.println("Inciso 3: ");
        System.out.println("========> Camino mas corto: ");
        System.out.println(Ejercicio3.caminoMasCorto(origen, destino));
        
        System.out.println("Con la version 2: ");
        System.out.println("========> Camino mas corto v2 : ");
        System.out.println(Ejercicio3.caminoMasCorto2(origen, destino));
        
       System.out.println("=====================================================================");
        System.out.println("");
        
        System.out.println("Inciso 4: ");
        System.out.println("==========> Camino sin cargar combustible  ");
        System.out.println(Ejercicio3.caminoSinCargarCombustible("La Plata", "San Vicente", 30));
        
        System.out.println("=====================================================================");
        System.out.println("");
        System.out.println("=======> Camino con menor cantidad de combustible cargado");
        System.out.println(Ejercicio3.caminoConMenorCargaDeCombustible(origen, destino, 10));
        
    }
}
