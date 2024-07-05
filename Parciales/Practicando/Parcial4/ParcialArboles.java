package parciales.Parcial4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import parciales.ClasesGenericas.GeneralTree;
import parciales.ClasesGenericas.Queue;

public class ParcialArboles {
    
    public static boolean resolver(GeneralTree<Integer> arbol) {
        return (arbol != null && !arbol.isEmpty()) ? helper(arbol) : false;
    }
    
    private static boolean helper(GeneralTree<Integer> arbol) {
        boolean cumple = true;
        int nodosNivelAnterior = 0;
        int nodosNivelActual = 0;
        GeneralTree<Integer> aux;
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.encolar(arbol);
        cola.encolar(null);
        while (!cola.isEmpty() && cumple) {
            aux = cola.desencolar();
            if (aux != null) {
                nodosNivelActual++;
                if (nodosNivelActual <= nodosNivelAnterior + 1) {
                    for (GeneralTree<Integer> child : aux.getChildren()) {
                        cola.encolar(child);
                    }
                } else {
                    return false;
                }
            } else {
                System.out.println("Nodos nivel actual: " + nodosNivelActual + "|| Nodos nivel anterior: " + nodosNivelAnterior);     
                if (nodosNivelActual != nodosNivelAnterior + 1) {
                    return false;
                } else {
                    if (!cola.isEmpty()) {
                        nodosNivelAnterior ++;
                        nodosNivelActual = 0;
                        cola.encolar(null);
                    }
                }              
            }
        }
        return cumple;
    }
    
    public static void main(String[] args) {
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(83));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(18, subChildren1);
        
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(subAb1);
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(5, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(33));
        subChildren3.add(new GeneralTree<Integer>(12));
        subChildren3.add(new GeneralTree<Integer>(17));
        subChildren3.add(new GeneralTree<Integer>(9));
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(3, subChildren3);
        
        List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(7));
        subChildren4.add(new GeneralTree<Integer>(11));
        subChildren4.add(subAb3);
        GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(4, subChildren4);
        
        List<GeneralTree<Integer>> subArbIzq = new LinkedList<GeneralTree<Integer>>();
        subArbIzq.add(subAb2);
        subArbIzq.add(subAb4);
        GeneralTree<Integer> arbIzq = new GeneralTree<Integer>(1, subArbIzq);
        
        List<GeneralTree<Integer>> subArbDer = new LinkedList<GeneralTree<Integer>>();
        subArbDer.add(new GeneralTree<Integer>(13));
        GeneralTree<Integer> arbDer = new GeneralTree<Integer>(25, subArbDer);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(arbIzq);
        arbol.add(arbDer);
        GeneralTree<Integer> a = new GeneralTree<Integer>(2, arbol);
        
        System.out.println("Es creciente el arbol 1: " + ParcialArboles.resolver(a));
        System.out.println("")
                ;
        List<GeneralTree<Integer>> subChildren5 = new LinkedList<GeneralTree<Integer>>();
        subChildren5.add(new GeneralTree<Integer>(7));
        subChildren5.add(subAb3);
        GeneralTree<Integer> subAb5 = new GeneralTree<Integer>(4, subChildren5);
        
        List<GeneralTree<Integer>> subArbIzq2 = new LinkedList<GeneralTree<Integer>>();
        subArbIzq2.add(subAb2);
        subArbIzq2.add(subAb5);
        GeneralTree<Integer> arbIzq2 = new GeneralTree<Integer>(1, subArbIzq2);
        
        List<GeneralTree<Integer>> arbol2 = new LinkedList<GeneralTree<Integer>>();
        arbol2.add(arbIzq2);
        arbol2.add(arbDer);
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, arbol2);
        
        System.out.println("Es creciente el arbol 2: " + ParcialArboles.resolver(a));
         System.out.println("");
        //Mas casos para evaluar
        List<GeneralTree<Integer>> arbol3 = new LinkedList<GeneralTree<Integer>>();
        arbol3.add(new GeneralTree<Integer>(1));
        arbol3.add(new GeneralTree<Integer>(2));
        arbol3.add(new GeneralTree<Integer>(3));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(4, arbol3);
        
        System.out.println("Es creciente el arbol 3: " + ParcialArboles.resolver(a));
        System.out.println("");
        GeneralTree<Integer> ultimoArbol = new GeneralTree<>(34);
        ultimoArbol.addChild(new GeneralTree<>(3));
        
        System.out.println("Es creciente este ultimo arbol? " + ParcialArboles.resolver(ultimoArbol));
        
    }
}
