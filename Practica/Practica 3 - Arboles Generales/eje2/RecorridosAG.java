package Practica3.eje2;

import clases_genericas.GeneralTree;
import clases_genericas.Queue;
import java.util.LinkedList;
import java.util.List;

public class RecorridosAG {
    /* 
        Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
        pasados como parámetros, recorrido en preorden.
    */
    public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,Integer n)
    {
        List<Integer> listaReturn = new LinkedList<Integer>();
        if ( (a != null) && (!a.isEmpty()) ){
            preOrdenAux(a,n,listaReturn);
        }
        return listaReturn;
    }
    private void preOrdenAux(GeneralTree<Integer> a, Integer n, List<Integer> lista){
            int datoActual = a.getData();  // no es necesario,pero es mas legible el codigo
            chequearCumple(datoActual, n, lista);
            
            List<GeneralTree<Integer>> children = a.getChildren();
            for (GeneralTree<Integer> child : children){
                preOrdenAux(child, n, lista);
            }
    }
    //===================================================================================
    /*
        Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
        pasados como parámetros, recorrido en inorden.
    */
    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
        List<Integer> listaReturn = new LinkedList<Integer>();
        if ( (a!= null) && (!a.isEmpty()) ) inOrdenAux(a,n,listaReturn);
        return listaReturn;
    }
    
    private void inOrdenAux (GeneralTree<Integer> a, Integer n, List<Integer> lista){
        List<GeneralTree<Integer>> children = a.getChildren();
        
        if (a.hasChildren())
          inOrdenAux(children.get(0),n,lista);  // procesamos primerhijo.
        // procesamos la raiz  
        int datoActual = a.getData();
        chequearCumple(datoActual, n, lista);
        
        // procesamos los demas hijos
        for (int i=1; i < children.size(); i++){
            inOrdenAux(children.get(i),n,lista);
        }
    }
    //===================================================================================
    /*
        Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
         pasados como parámetros, recorrido en postorden.
    */
    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,Integer n){
        List<Integer> listaReturn = new LinkedList<Integer>();
        if ( ( a != null) && (!a.isEmpty())) postOrdenAux(a,n,listaReturn);
        return listaReturn;
    }

    private void postOrdenAux (GeneralTree<Integer>a,Integer n,List<Integer>lista){
        List<GeneralTree<Integer>> children = a.getChildren();
        for (GeneralTree<Integer> child : children){
            postOrdenAux(child, n, lista);
        }
        int datoActual = a.getData(); // no es necesario,pero es mas legible el codigo
        chequearCumple(datoActual, n, lista);
    }
    //===================================================================================
    /*
        Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
        pasados como parámetros, recorrido por niveles.
    */
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n){
       List<Integer> listaReturn = new LinkedList<Integer>();
       if ( (a != null) && (!a.isEmpty())) entreNivelesAux(a, n, listaReturn);
       return listaReturn;
    }    
    
    private void entreNivelesAux(GeneralTree<Integer> a , Integer n,List<Integer> listaReturn){    
        GeneralTree<Integer> aux;
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        cola.encolar(a);
        while (!cola.isEmpty()){
            aux = cola.desencolar();
            
            int datoActual = aux.getData();
            chequearCumple(datoActual, n, listaReturn); //agregamos en la lista (si cumple la condicion)
            
            List<GeneralTree<Integer>> children = aux.getChildren();
            for (GeneralTree<Integer> child : children){
                cola.encolar(child);
            }
        }
    }
    
    //===================================================================================
    // VAMOS A USAR ESTOS DOS METODOS PARA REUTILIZAR Y NO REPETIR CODIGO.
    private boolean cumpleCondicion (Integer datoActual, Integer n){
        return ( (datoActual>n) && (datoActual %2 != 0) );
    }
    private void chequearCumple (Integer datoActual, Integer n, List<Integer> lista){
        if (cumpleCondicion(datoActual, n)){
            lista.add(datoActual);
        }
    }
    //===================================================================================
    /*
        In orden con FOR:
       private void recorridoAux(GeneralTree <Integer> a,Integer n, List<Integer> L ){
           List<GeneralTree<Integer>> children = a.getChildren();
           // primer hijo
            if(a.hasChildren())
                recorridoAux(children.get(0),n,L);
           
            // procesa la raiz
             if ((a.getData() %2 != 0) && (a.getData() > n)){
                    L.add(a.getData());
             }
                
            // hijos restantes
               for (int i=1;i<children.size();i++) {
                   recorridoAux(children.get(i),n,L);
                }
         }
   ========================================================================================     
       In orden con ITERATOR:   
       private void inOrdenPrivado(GeneralTree<Integer> a,Integer n,List<Integer> l) {
              if(a.hasChildren()) {
                   Iterator<GeneralTree<Integer>> it=a.getChildren().iterator();
                    inOrdenPrivado(it.next(),n,l);
                    procesarElemento(a.getData(),n,l);
                    while(it.hasNext())
                      inOrdenPrivado(it.next(),n,l);
               }else
                   procesarElemento(a.getData(),n,l); 
         }
    
    
    
         private void procesarElemento(int dato,int n,List<Integer> l) {
                 if(dato%2==1&&dato>n)
                         l.add(dato);
         }
    ==============================================================================
     
        
    
    */
}
