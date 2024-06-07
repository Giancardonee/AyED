package practica1.eje7prac1;

import java.util.ArrayList;
import java.util.Iterator;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList <Integer> listaNumeros = new ArrayList<>(); 
        for (String arg : args) {
            Integer numero = Integer.parseInt(arg); // Parseamos el String a Integer
            listaNumeros.add(numero); // Agregamos el Integer a la lista
        }  
        
        // ===>  Probamos distintas formas de recorrer un ArrayList
        
        // recorremos el ArrayList usando un iterator
        Iterator <Integer> it = listaNumeros.iterator(); 
        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }
        
        // recorremos el ArrayList usando un foreach
        for (int i : listaNumeros){
            System.out.print(i+" ");
        }
        
        // recorremos el ArrayList usando un for y get
        for (int i=0; i< listaNumeros.size(); i++){
            System.out.println(listaNumeros.get(i)+" ");
        }
    }
    
}
