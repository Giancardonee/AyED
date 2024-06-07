package Practica2.eje3;

import clases_genericas.BinaryTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ContadorArbol {
       private BinaryTree <Integer> arbol;
       
       public ContadorArbol(BinaryTree <Integer> unArbol){
           this.arbol = unArbol; 
       }
       
       public List <Integer> numerosParesInOrden(){
          List <Integer> lista =  new LinkedList<>();
          if (! arbol.isEmpty()) paresRecursivoInOrden(lista,this.arbol);
          else lista = null;
          
          return lista; 
       }
       
       private void paresRecursivoInOrden(List<Integer> lista , BinaryTree <Integer> a){
           if (a.tieneHijoIzq()) 
               paresRecursivoInOrden(lista, a.getHijoIZquierdo());
           if (a.getData() % 2 == 0) lista.add(a.getData()); 
           if (a.tieneHijoDer())
               paresRecursivoInOrden(lista, a.getHijoDerecho());
       }
       
       public List <Integer> numerosParesPostOrden(){
           List<Integer> lista = new ArrayList();
           if (!arbol.isEmpty()) paresRecursivoPostOrden(lista,this.arbol); 
           else lista = null; 
           
           return lista;
       }
       
       private void paresRecursivoPostOrden(List<Integer> lista, BinaryTree<Integer> a){
           if (a.tieneHijoIzq())
               paresRecursivoPostOrden(lista, a.getHijoIZquierdo());
           if (a.tieneHijoDer())
               paresRecursivoPostOrden(lista, a.getHijoDerecho());
           if (a.getData() % 2 == 0) lista.add(a.getData()); 
       }
       
}
