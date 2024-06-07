package Practica3.eje3;

import java.util.LinkedList;
import java.util.List;

public class testing {
    public static void main(String[] args) {
         GeneralTree<Integer> raiz = new GeneralTree<>(100);
        
        
        List<GeneralTree<Integer>> children2 = new LinkedList<>(); 
        children2.add(new GeneralTree<>(5));
        GeneralTree<Integer> nodo2 = new GeneralTree<>(2,children2); 
        
        List<GeneralTree<Integer>> children33 = new LinkedList<>();
        children33.add(new GeneralTree<>(6));
        children33.add(new GeneralTree<>(2));
        children33.add(new GeneralTree<>(8));
        GeneralTree<Integer> nodo33 = new GeneralTree<>(33,children33);
        
        
        List<GeneralTree<Integer>> children4 = new LinkedList<>();
        children4.add(new GeneralTree<>(6));
        children4.add(new GeneralTree<>(1000));
        GeneralTree<Integer> nodo4 = new GeneralTree<>(4,children4);
       
        raiz.addChild(nodo2); 
        raiz.addChild(nodo33);
        raiz.addChild(nodo4); 
        
        GeneralTree.imprimirEntreNiveles(raiz);
        System.out.println("");
        System.out.println("Imprimimos la altura del arbol, la longitud del camino mas largo desde la raiz hasta una hoja: ");
        System.out.println("La altura del arbol es: "+raiz.altura());
        
        System.out.println("");
        System.out.println("Imprimimos el nivel de un dato pasado por parametro. \n Si el dato no se encuentra, imprime -1");
        System.out.println("El nivel del dato 100 es: "+raiz.nivel(100));
        System.out.println("El nivel del dato 2 es: "+raiz.nivel(2));
        System.out.println("El nivel del dato 1000 es: "+raiz.nivel(1000));
        System.out.println("El nivel del dato 456 es: "+raiz.nivel(456));
        
        System.out.println("");
        System.out.println("Imprimimos el ancho del arbol. \n (el ancho de un árbol se define como la cantidad de nodos que\n" +
"se encuentran en el nivel que posee la mayor cantidad de nodos.)");
        System.out.println("El ancho del arbol es: "+raiz.ancho());
       
    }
    
}
