package Practica3.eje11;

import clases_genericas.GeneralTree;
import clases_genericas.Queue;
import java.util.List;

public class ParcialArboles {
    
    public static boolean resolver(GeneralTree<Integer> arbol){
        return arbol == null ? false : arbol.isEmpty() ? false : auxiliar (arbol);
    }
 
    private static boolean auxiliar (GeneralTree<Integer> arbol){
        GeneralTree<Integer> aux; 
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.encolar(arbol);
        cola.encolar(null);
        
        int nodosNivelAct=1; 
        int nodosNivelSig=0;
        while (!cola.isEmpty()){
            aux = cola.desencolar();
            if (aux!= null){             
                // encolamos los hijos
                List<GeneralTree<Integer>> children = aux.getChildren();
                for (GeneralTree<Integer> child : children){
                    cola.encolar(child);
                    nodosNivelSig++;
                    if (nodosNivelSig > (nodosNivelAct +1)) return false; 
                    // si se encuentra que no cumple la condicion, dejamos de encolar a los hijos y retornamos false
                }
            }
            else if (!cola.isEmpty()){
                if (nodosNivelSig != (nodosNivelAct+1)) return false;
                nodosNivelAct = nodosNivelSig;
                nodosNivelSig =0;
                cola.encolar(null);
            }
        }   
        return true;
    }
    
}
