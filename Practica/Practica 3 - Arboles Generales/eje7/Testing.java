package Practica3.eje7;

import clases_genericas.GeneralTree;
import java.util.LinkedList;
import java.util.List;

public class Testing {
    public static void main(String[] args) {
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<>();
        subChildren1.add(new GeneralTree<>(1));
        GeneralTree<Integer> subA = new GeneralTree<>(6, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<>();
        subChildren2.add(new GeneralTree<>(10));
        subChildren2.add(subA);
        GeneralTree<Integer> a1 = new GeneralTree<>(17, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<>();
        subChildren3.add(new GeneralTree<>(8));
        GeneralTree<Integer> a2 = new GeneralTree<>(9, subChildren3);
        
        List<GeneralTree<Integer>> subChildren4 = new LinkedList<>();
        subChildren4.add(new GeneralTree<>(16));
        subChildren4.add(new GeneralTree<>(7));
        GeneralTree<Integer> subB = new GeneralTree<>(14, subChildren4);
        List<GeneralTree<Integer>> subChildren5 = new LinkedList<>();
        subChildren5.add(subB);
        subChildren5.add(new GeneralTree<>(18));
        GeneralTree<Integer> a3 = new GeneralTree<>(15, subChildren5);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(a3);
        GeneralTree<Integer> a = new GeneralTree<>(12, arbol);
        
        Caminos eje7 = new Caminos(a);
        
        List<Integer> caminoMasLargo = eje7.caminoAHojaMasLejana();
        
        for (Integer datoAct : caminoMasLargo){
            System.out.print(datoAct+" ");
        }
        System.out.println("Longitud: "+(caminoMasLargo.size()-1));
        
    }
    
}
