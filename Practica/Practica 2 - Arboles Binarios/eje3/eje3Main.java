package Practica2.eje3;

import clases_genericas.BinaryTree;
import java.util.List;

public class eje3Main {
    public static void main(String[] args) {
        BinaryTree <Integer> arbol = new BinaryTree<Integer>(50);
        arbol.agregarHijoDer(new BinaryTree<Integer> (70));
        BinaryTree <Integer> subArbolIzq = new BinaryTree<Integer>(43); 
        subArbolIzq.agregarHijoIzq(new BinaryTree <Integer>(30));
        subArbolIzq.agregarHijoDer(new BinaryTree<Integer> (46));
        arbol.agregarHijoIzq(subArbolIzq);
        
        ContadorArbol contador = new ContadorArbol(arbol);
        
        System.out.println("Imprimiento la lista de los numeros pares in orden");
        List<Integer> listaParesInOrden = contador.numerosParesInOrden();
        imprimirLista(listaParesInOrden);
        
        System.out.println("Imprimiendo la lista de los numeros pares post orden");
        List <Integer> listaParesPostOrden = contador.numerosParesPostOrden();
        imprimirLista(listaParesPostOrden);
        
    }
    
    private static void imprimirLista (List <Integer> lista){
        if (lista != null){
              for ( Integer num : lista){
                System.out.println(num+" ");
              }
            }
        else System.out.println("Arbol vacio, o no se encontraron numeros pares en el arbol.");
    }
   
}
