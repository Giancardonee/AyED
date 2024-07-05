package parciales.Parcial3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import parciales.ClasesGenericas.GeneralTree;

public class Parcial {
    
    public boolean esDeSeleccion (GeneralTree<Integer> arbol )
    {
        return (arbol != null && !arbol.isEmpty()) ? helper(arbol) : false;
    }
    
    private boolean helper (GeneralTree<Integer> a) 
    {
        boolean cumple = true; 
        int min = Integer.MAX_VALUE;    
        if (!a.isLeaf())
        {
            Iterator<GeneralTree<Integer>> iterador = a.getChildren().iterator();
            while (iterador.hasNext() && cumple)
            {
                GeneralTree<Integer> hijo = iterador.next();
                min = Math.min(min,hijo.getData());
                cumple = helper(hijo);
            }
            cumple = cumple && a.getData() == min;
        }
      return cumple;
    }
    
     public static void main(String args[]) {
         List <GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(35));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(35, subChildren1);
        
        List <GeneralTree<Integer>> subChildren2 = new LinkedList <GeneralTree<Integer>>();
        subChildren2.add(subAb1);
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(35, subChildren2);
        
        List <GeneralTree<Integer>> subChildren3 = new LinkedList <GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(35));
        subChildren3.add(new GeneralTree<Integer>(83));
        subChildren3.add(new GeneralTree<Integer>(90));
        subChildren3.add(new GeneralTree<Integer>(33));
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(33, subChildren3);
        
        List <GeneralTree<Integer>> subChildren4 = new LinkedList <GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(14));
        subChildren4.add(new GeneralTree<Integer>(12));
        //subChildren4.add(new GeneralTree<Integer>(18));
        subChildren4.add(subAb3);
        GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(12, subChildren4);
        //GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(18, subChildren4);
        
        List <GeneralTree<Integer>> subArbIzq = new LinkedList <GeneralTree<Integer>>();
        subArbIzq.add(subAb2);
        subArbIzq.add(subAb4);
        GeneralTree<Integer> arbIzq = new GeneralTree<Integer>(12, subArbIzq);
        
        List <GeneralTree<Integer>> subArbDer = new LinkedList <GeneralTree<Integer>>();
        subArbDer.add(new GeneralTree<Integer>(25));
        GeneralTree<Integer> arbDer = new GeneralTree<Integer>(25, subArbDer);
        
        List <GeneralTree<Integer>> arbol = new LinkedList <GeneralTree<Integer>>();
        arbol.add(arbIzq);
        arbol.add(arbDer);
        GeneralTree<Integer> a = new GeneralTree<Integer>(12, arbol); 

        Parcial p = new Parcial();
        
        System.out.println("Es de seleccion el primer arbol: " + p.esDeSeleccion(a));
    }
    
}
