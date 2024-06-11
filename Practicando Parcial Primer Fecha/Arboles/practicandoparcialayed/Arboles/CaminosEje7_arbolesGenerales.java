package practicandoparcialayed.Arboles;

import java.util.LinkedList;
import java.util.List;
import practicandoparcialayed.GeneralTree;

public class CaminosEje7_arbolesGenerales {
    private GeneralTree<Integer>arbol; 
    
    public CaminosEje7_arbolesGenerales (GeneralTree<Integer> a)
    {
        this.arbol = a;
    }
    
    public List<Integer> caminoAHojaMasLejana()
    {
        List<Integer>  caminoMax = new LinkedList<>();
        if (!this.arbol.isEmpty() || this.arbol != null) 
            helper(caminoMax,new LinkedList<>(),this.arbol);
        return caminoMax;
    }
    
    private void helper(List<Integer> camMax, List<Integer>camAct,GeneralTree<Integer> arb)
    {
        camAct.add(arb.getData());
        if (arb.isLeaf())
        {
            if (camAct.size() > camMax.size()){
                camMax.clear();      
                camMax.addAll(camAct);
            }
        }
        else
        {
            for (GeneralTree<Integer> child : arb.getChildren())
                helper(camMax, camAct, child);
        }
        camAct.remove(camAct.size() -1 );
    }
    
     public static void main(String[] args) {
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subA = new GeneralTree<Integer>(6, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(new GeneralTree<Integer>(10));
        subChildren2.add(subA);
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(17, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(9, subChildren3);
        
        List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(16));
        subChildren4.add(new GeneralTree<Integer>(7));
        GeneralTree<Integer> subB = new GeneralTree<Integer>(14, subChildren4);
        List<GeneralTree<Integer>> subChildren5 = new LinkedList<GeneralTree<Integer>>();
        subChildren5.add(subB);
        subChildren5.add(new GeneralTree<Integer>(18));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(15, subChildren5);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(12, arbol);
        
        CaminosEje7_arbolesGenerales cam = new CaminosEje7_arbolesGenerales(a);
        
        System.out.println("Camino a hoja mas lejana: " + cam.caminoAHojaMasLejana());
 }
}
