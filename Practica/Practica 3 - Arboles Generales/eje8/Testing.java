package Practica3.eje8;

import clases_genericas.GeneralTree;
import java.util.LinkedList;
import java.util.List;

public class Testing {
    public static void main(String[] args) {
        List<GeneralTree<Integer>> subArb1 = new LinkedList<>();
        subArb1.add(new GeneralTree<>(2));
        subArb1.add(new GeneralTree<>(3));
        subArb1.add(new GeneralTree<>(4));
        GeneralTree<Integer> a1 = new GeneralTree<>(1, subArb1);
        
        List<GeneralTree<Integer>> subArb2A = new LinkedList<>();
        subArb2A.add(new GeneralTree<>(5));
        subArb2A.add(new GeneralTree<>(6));
        subArb2A.add(new GeneralTree<>(7));
        GeneralTree<Integer> subA2 = new GeneralTree<>(2, subArb2A);
        List<GeneralTree<Integer>> subArb2B = new LinkedList<>();
        subArb2B.add(subA2);
        subArb2B.add(new GeneralTree<>(3));
        subArb2B.add(new GeneralTree<>(4));
        GeneralTree<Integer> a2 = new GeneralTree<>(1, subArb2B);
        
        List<GeneralTree<Integer>> subArb3A = new LinkedList<>();
        subArb3A.add(new GeneralTree<>(6));
        subArb3A.add(new GeneralTree<>(7));
        subArb3A.add(new GeneralTree<>(8));
        GeneralTree<Integer> subA3 = new GeneralTree<>(3, subArb3A);
        List<GeneralTree<Integer>> subArb3B = new LinkedList<>();
        subArb3B.add(new GeneralTree<>(2));
        subArb3B.add(subA3);
        subArb3B.add(new GeneralTree<>(4));
        subArb3B.add(new GeneralTree<>(5));
        GeneralTree<Integer> a3 = new GeneralTree<>(1, subArb3B);
        
        Navidad nav1 = new Navidad(a1);
        Navidad nav2 = new Navidad(a2);
        Navidad nav3 = new Navidad(a3);
        
        System.out.println("Arbol 1 Es Abeto Navideño ? "+nav1.esAbetoNavidenio());
        System.out.println("Arbol 2 Es Abeto Navideño ? "+nav2.esAbetoNavidenio());
        System.out.println("Arbol 3 Es Abeto Navideño ? "+nav3.esAbetoNavidenio());
        
    }
    
}
