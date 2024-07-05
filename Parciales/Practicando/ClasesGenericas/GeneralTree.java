/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.ClasesGenericas;

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
        cola.encolar(arbol);
        cola.encolar(null);
        while (!cola.isEmpty()){
            aux = cola.desencolar();
            if (aux != null){
                System.out.print(aux.getData()+" ");
                List<GeneralTree<Integer>> children = aux.getChildren();// recorremos los hijos del nodo actual aux.
                for (GeneralTree<Integer> child : children){
                    cola.encolar(child);
                }
            }
            else{
                if (!cola.isEmpty()) {
                    System.out.println("");
                    cola.encolar(null);
                }    
            }
        }
    }
    public static void imprimirEntreNivelesC(GeneralTree<Character> arbol){
        GeneralTree<Character> aux;
        Queue<GeneralTree<Character>> cola = new Queue<>();
        cola.encolar(arbol);
        cola.encolar(null);
        while (!cola.isEmpty()){
            aux = cola.desencolar();
            if (aux != null){
                System.out.print(aux.getData()+" ");
                List<GeneralTree<Character>> children = aux.getChildren();// recorremos los hijos del nodo actual aux.
                for (GeneralTree<Character> child : children){
                    cola.encolar(child);
                }
            }
            else{
                if (!cola.isEmpty()) {
                    System.out.println("");
                    cola.encolar(null);
                }    
            }
        }
    }
    
    
    
    
    
}
