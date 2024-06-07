package EjeParcialAG_3;

import clases_genericas.GeneralTree;
import java.util.LinkedList;
import java.util.List;

/*
    Implementar una clase con un método que reciba un árbol general de enteros y guarde todos los árboles cuya
raíz tenga un valor más pequeño que la suma de los valores de sus hijos.
*/
public class ArbolesPadresPequeños {
  public static List<GeneralTree<Integer>> devolverListaPadrePequeños(GeneralTree<Integer>arbolParametro){
      List <GeneralTree<Integer>> listaReturn = new LinkedList<GeneralTree<Integer>>();
      helper(arbolParametro,listaReturn);
      return listaReturn; 
  }  
  
  private static int helper(GeneralTree<Integer> a, List<GeneralTree<Integer>> lista){
      if (a.isLeaf()) return a.getData();
      else{ 
            int cont=0; 
            // necesito traerme la lista de hijos, para poder recorrerla e ir contando
            List<GeneralTree<Integer>> children = a.getChildren();
            for(GeneralTree<Integer> child : children){
                cont += helper(child, lista);
            }
        if (a.getData()<cont){
            lista.add(a);
        }
       return a.getData()+cont;
      }
  } 

//  
  private static int devolverSumaHijos(GeneralTree<Integer> arbol){
      int suma=0;
      List<GeneralTree<Integer>> listaHijos = arbol.getChildren();
      for (GeneralTree<Integer> child : listaHijos){
          suma+= child.getData();
      }
     return suma;
  }
//
  
  
private static int sumarHijos(GeneralTree<Integer> nodo) {
        int suma = 0;
        for (GeneralTree<Integer> hijo : nodo.getChildren()) {
            suma += hijo.getData();
        }
        return suma;
    }

    private static void dfs(GeneralTree<Integer> nodo, List<GeneralTree<Integer>> lista) {
        int sumaHijos = sumarHijos(nodo);
        if (nodo.getData() < sumaHijos) {
            lista.add(nodo);
        }
        for (GeneralTree<Integer> hijo : nodo.getChildren()) {
            dfs(hijo, lista);
        }
    }
    
    private static int devolverValoresHijo(List<GeneralTree<Integer>> lista){
        int suma =0;
        for (GeneralTree<Integer> child : lista){
            suma+= child.getData();
            helper(child, lista);
        }
        return suma;
    }
    
    private static void helperAux (GeneralTree<Integer> arbol, List<GeneralTree<Integer>>lista){
        if (arbol.isLeaf()) return; // caso base
        else{
            int cont=0;
            cont = devolverValoresHijo(arbol.getChildren());
            
        }
    }
    
    
    
}


