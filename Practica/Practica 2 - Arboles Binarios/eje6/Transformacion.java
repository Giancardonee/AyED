package Practica2.eje6;

import clases_genericas.BinaryTree;
import clases_genericas.Queue;

public class Transformacion {
    private BinaryTree<Integer> arbol;
    
    public Transformacion (BinaryTree nodoRaiz){
        this.arbol = nodoRaiz;
    }
    
    
    // Este metodo devuelve el mismo BinaryTree pero modificado.
    public BinaryTree<Integer> suma (){
       if (this.arbol.isEmpty())
           return new BinaryTree<Integer>();
       else{
           sumaAux(this.arbol);
           return (this.arbol); 
       }
    }
    
    private int sumaAux (BinaryTree <Integer> a){
        int suma=0; 
        int izq=0; int der=0; 
        if (a.esHoja()){
            int valor = a.getData();
            a.setData(0);
            return valor;
        }
        else{
            if (a.tieneHijoIzq())
            {
                izq = sumaAux(a.getHijoIZquierdo());
            }
            if (a.tieneHijoDer()) {
                der = sumaAux(a.getHijoDerecho());
            }
          }
        suma = izq + der;
        int valorActual = a.getData();
        a.setData(suma);
       return suma + valorActual; 
    }
    
    // Este metodo devuelve una nueva instancia de BinaryTree, es decir un nuevo arbol, en vez de modificar el que recibe
    public BinaryTree<Integer> suma2 (){
        BinaryTree<Integer> arbolReturn = new BinaryTree<>();
        return this.arbol.isEmpty() ? arbolReturn :sumaAux2(this.arbol); 
    }
    
    private BinaryTree<Integer> sumaAux2(BinaryTree<Integer> arbol){
        if (arbol.isEmpty())
            return new BinaryTree<Integer>(0);
        else{
            int suma=0;
            BinaryTree <Integer> izq = null; 
            BinaryTree <Integer> der = null;
            if (arbol.tieneHijoIzq()){ 
            izq = sumaAux2(arbol.getHijoIZquierdo()); 
            suma+= izq.getData();
            suma += arbol.getHijoIZquierdo().getData();
            }
            if (arbol.tieneHijoDer()){
            der = sumaAux2(arbol.getHijoDerecho()); 
            suma+= der.getData();
            suma+= arbol.getHijoDerecho().getData();
            }
            
            BinaryTree <Integer> arbolSuma = new BinaryTree<>(suma);
            arbolSuma.agregarHijoIzq(izq);
            arbolSuma.agregarHijoDer(der);
            return arbolSuma;
        }
    }
    
    // esto es para imprimir nada mas
        public void entreNivelesCatedra(int n, int m) {
        if (!this.arbol.isEmpty() || n < 0 || m < n) {
            BinaryTree<Integer> arbol = null;
            Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
            cola.encolar(this.arbol); // encolamos el nodo raiz.
            cola.encolar(null);// separador de niveles

            int nivelActual = 0;

            while (!cola.isEmpty() && nivelActual <= m) {
                arbol = cola.desencolar();
                if (arbol != null) {
                    if (nivelActual >= n && nivelActual <= m) {
                        System.out.print(arbol.getData() + " ");
                    }
                    if (arbol.tieneHijoIzq()) {
                        cola.encolar(arbol.getHijoIZquierdo());
                    }
                    if (arbol.tieneHijoDer()) {
                        cola.encolar(arbol.getHijoDerecho());
                    }
                } else {
                    System.out.println(""); //salto de linea
                    nivelActual++;
                    if (!cola.isEmpty()) {
                        cola.encolar(null);
                    }

                }
            }
        }
    }
    
}
