package practicandoparcialayed.Arboles;

import java.util.LinkedList;
import java.util.List;
import practicandoparcialayed.GeneralTree;

public class ChequeandoEje5 {

    /**
     * @param args the command line arguments
     */
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
        
        GeneralTree.imprimirEntreNivelesInt(raiz);
        System.out.println(raiz.esAncestro(33,100));
   
        
    }
    
}
