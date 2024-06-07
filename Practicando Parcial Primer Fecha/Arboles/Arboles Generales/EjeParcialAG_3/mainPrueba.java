package EjeParcialAG_3;

import clases_genericas.GeneralTree;
import java.util.LinkedList;
import java.util.List;

public class mainPrueba {
    public static void main(String[] args) {
        
        GeneralTree<Integer> raiz = new GeneralTree<Integer>(100);
        
        
        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>(); 
        children2.add(new GeneralTree<>(5));
        GeneralTree<Integer> nodo2 = new GeneralTree<Integer>(2,children2); 
        
        List<GeneralTree<Integer>> children33 = new LinkedList<GeneralTree<Integer>>();
        children33.add(new GeneralTree<>(6));
        children33.add(new GeneralTree<>(2));
        children33.add(new GeneralTree<>(8));
        GeneralTree<Integer> nodo33 = new GeneralTree<Integer>(33,children33);
        
        
        List<GeneralTree<Integer>> children4 = new LinkedList<GeneralTree<Integer>>();
        children4.add(new GeneralTree<>(6));
        children4.add(new GeneralTree<>(1000));
        GeneralTree<Integer> nodo4 = new GeneralTree<Integer>(4,children4);
        

        raiz.addChild(nodo2); 
        raiz.addChild(nodo33);
        raiz.addChild(nodo4); 
        
        //GeneralTree.imprimirEntreNiveles(raiz);
        
        
        List<GeneralTree<Integer>> lista = ArbolesPadresPequeños.devolverListaPadrePequeños(raiz);
    }
    
}
