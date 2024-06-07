package Practica3.eje4;

import clases_genericas.GeneralTree;
import clases_genericas.Queue;
import java.util.List;

public class AnalizadorArbol {    

    // si es null o es vacio retorno -1. 
    public static double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol){
        if ( (arbol == null) || (arbol.isEmpty()) )return -1;
        else return maximoPromEntreNiveles(arbol);
    }
    
    private static double maximoPromEntreNiveles(GeneralTree<AreaEmpresa> arbol){
        double promedio=0; double max= Double.MIN_VALUE;
        int cantNodos=0; int suma=0; 
        
        GeneralTree<AreaEmpresa> aux;
        Queue<GeneralTree<AreaEmpresa>> cola = new Queue<>();
        
        cola.encolar(arbol);
        cola.encolar(null);
        while (!cola.isEmpty()){
            aux = cola.desencolar();
            if (aux!=null){
                cantNodos++; 
                suma+= aux.getData().getTardanza();
                // encolo los hijos: 
                List<GeneralTree<AreaEmpresa>> children = aux.getChildren();
                for(GeneralTree<AreaEmpresa> child : children){
                    cola.encolar(child);
                }
            }else{
                promedio=(double)suma/cantNodos; // convierto uno en double para que me devuelva un double
                suma=0; cantNodos=0;
                max = Math.max(max, promedio); 
                if (!cola.isEmpty()){
                    cola.encolar(null);
                }
            }
        }
        return max;
    }
}
