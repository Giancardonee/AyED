package Practica2.eje9;

import clases_genericas.BinaryTree;

public class ParcialArboles {
    
    
    /*
        En estos metodos: Primero se fija si el arbol esta vacio o no. 
    Si el arbol esta vacio, devuelve un arbol SyD vacio.
    Si el arbol tiene elementos, se van agregando los elementos con la suma del camino y la diferencia de su padre
    */
    
    //En llamado a metodoAux, el primer 0 hace referencia a la suma total, el segundo 0 hace referencia al valor del nodo padre.
    public static BinaryTree<SyD> sumAndDif(BinaryTree<Integer> arbolParametro){
         BinaryTree<SyD> arbolReturn = new BinaryTree<SyD>();
         if (arbolParametro.isEmpty()) return arbolReturn;
         else {
             metodoAux(arbolParametro,arbolReturn,0,0); // primer 0 corresponde a suma, segundo 0 corresponde a nodo padre.
             return arbolReturn;
         }
    }
    
    private static void metodoAux(BinaryTree<Integer> arbolParametro, BinaryTree<SyD> arbolReturn,int suma, int padre){
        int valorArbP = arbolParametro.getData();
        SyD dato = new SyD(valorArbP+suma, valorArbP-padre);
        arbolReturn.setData(dato); // seteo el dato en el nuevo arbol.
        if (arbolReturn.tieneHijoIzq()){
            arbolReturn.agregarHijoIzq(new BinaryTree<>()); // debo crear una nueva instancia en su hijo
            metodoAux(arbolParametro.getHijoIZquierdo(),arbolReturn.getHijoIZquierdo(),valorArbP+suma,valorArbP);
        }
        if (arbolReturn.tieneHijoDer()){
            arbolParametro.agregarHijoDer(new BinaryTree<>());// debo crear una nueva instancia en su hijo
            metodoAux(arbolParametro.getHijoDerecho(),arbolReturn.getHijoDerecho(),valorArbP+suma,valorArbP);
        }
    }
    
    
    
    
}
