/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica3.eje3;

import clases_genericas.*;
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

    public static void imprimirEntreNiveles(GeneralTree<Integer> arbol){
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
    //==================================================================
    public int altura (){
        if ( (this.data == null) || (this.isEmpty())) return -1;
        else return helperAux(); 
    }
    
    private int helperAux(){
        if (this.isLeaf()) return 0; 
        else{
            int nivel, max=0;
            List<GeneralTree<T>> children = this.getChildren();
            for (GeneralTree<T> child : children){
                nivel = child.helperAux() + 1;
                max = Math.max(nivel, max);
            }
         return max;
        }
    }
    //==================================================================
    public int nivel(T dato){
        if ( (this.data == null) || (this.isEmpty())) return -1;
        else return helpNivel(dato);
    }
    
    private int helpNivel (T dato){
        GeneralTree<T> aux;
        Queue<GeneralTree<T>> cola = new Queue<>();
        int nivelActual =0;
        boolean encontre=false;
        
        cola.encolar(this);
        cola.encolar(null);
        
        while  ( (!cola.isEmpty()) && (!encontre)){
            aux = cola.desencolar();
            if (aux != null){          
                if (aux.getData().equals(dato))
                    encontre=true;
                else{
                    List<GeneralTree<T>> children = aux.getChildren();
                    for (GeneralTree<T> child : children){
                        cola.encolar(child);
                    }   
                }   
            }else{
                if (!cola.isEmpty()){
                    nivelActual++;
                    cola.encolar(null);
                }
            }
        }
        return encontre == true ? nivelActual : -1;
    }
    //==================================================================
    public int ancho (){
        if  ( (this.data == null) || (this.isEmpty()) ) return -1;
        else return helpAncho();
    }
    
    private int helpAncho (){
        int max=0;
        int cantNodos=0;
        GeneralTree<T> aux;
        Queue<GeneralTree<T>> cola = new Queue<>();
        cola.encolar(this);
        cola.encolar(null);
        
        while (!cola.isEmpty()){
            aux = cola.desencolar();
            if (aux != null){
                cantNodos++;
                List<GeneralTree<T>> children = aux.getChildren();
                for(GeneralTree<T> child : children){
                    cola.encolar(child);
                }
            }else{
                max = Math.max(cantNodos, max);
                if (!cola.isEmpty()){
                    cantNodos=0;
                    cola.encolar(null);
                }  
            }
        }
        return max;
    }
    
}

