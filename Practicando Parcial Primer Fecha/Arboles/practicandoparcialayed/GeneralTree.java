/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicandoparcialayed;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class GeneralTree<T> {

    private T data;
    private List<GeneralTree<T>> children =new LinkedList<GeneralTree<T>>();
    public GeneralTree(T data) {
        this.data = data;
    }
    
    public GeneralTree(T data,List<GeneralTree<T>> children){
        this(data);
        this.children = children;
    }
    
    public boolean hasChildren() {
        return children!=null && !children.isEmpty();
    }
    
    public void setChildren(List<GeneralTree<T>> children) {
        if (children != null)
        this.children = children;
    }
    
    public List<GeneralTree<T>> getChildren() {
        return this.children;
    }
    
    public void addChild(GeneralTree<T> child) {
        getChildren().add(child);
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public boolean isLeaf() {
        return !hasChildren();
    }
    
    public boolean isEmpty() {
        return data==null && !this.hasChildren();
    }
    
    public void removeChild(GeneralTree<T> child) {
        if (this.hasChildren()) {
        children.remove(child);
    }
   
    }

    public static void imprimirEntreNivelesInt(GeneralTree<Integer> arbol){
        GeneralTree<Integer> aux;
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(arbol);
        cola.enqueue(null);
        while (!cola.isEmpty()){
            aux = cola.dequeue();
            if (aux != null){
                System.out.print(aux.getData()+" ");
                List<GeneralTree<Integer>> children = aux.getChildren();// recorremos los hijos del nodo actual aux.
                for (GeneralTree<Integer> child : children){
                    cola.enqueue(child);
                }
            }
            else{
                if (!cola.isEmpty()) {
                    System.out.println("");
                    cola.enqueue(null);
                }    
            }
        }
    }
    public static void imprimirEntreNivelesC(GeneralTree<Character> arbol){
        GeneralTree<Character> aux;
        Queue<GeneralTree<Character>> cola = new Queue<>();
        cola.enqueue(arbol);
        cola.enqueue(null);
        while (!cola.isEmpty()){
            aux = cola.dequeue();
            if (aux != null){
                System.out.print(aux.getData()+" ");
                for (GeneralTree<Character> child : aux.getChildren()){
                    cola.enqueue(child);
                }
            }
            else{
                if (!cola.isEmpty()) {
                    System.out.println("");
                    cola.enqueue(null);
                }    
            }
        }
    }
    
    
    public boolean esAncestro (T a, T b)
    {
        return ( (this.isEmpty() || this == null || this.isLeaf()) ? false : helperAncestro(a,b));
    }
        
    private boolean helperAncestro (T a, T b)
    {
        GeneralTree<T> arbol = BuscarNodoN(a);
        return arbol == null ? false : ValidarCamino(arbol, b);
    }
    
    private GeneralTree<T> BuscarNodoN(T a)
    {
        GeneralTree<T> arbolReturn = null;
        if (this.getData().equals(a)) arbolReturn = this;
        else {
            // solo hacemos los llamados recursivos si no encontramos el nodo
            for (GeneralTree<T> child : this.getChildren())
                if (arbolReturn == null) arbolReturn = child.BuscarNodoN(a);
        }
        return arbolReturn;
    }
    
    private boolean ValidarCamino (GeneralTree<T> arbol, T b)
    {
        boolean ok = false;
        if (arbol.getData().equals(b)) ok= true;
        else
        {
            // si no encontramos el dato, seguimso con la recursion.
            for (GeneralTree<T> child : arbol.getChildren())
                if (ok == false) ok = ValidarCamino(child,b);
        }
        return ok;
    }
    
    
}
