/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.eje5Prac1;
public class Dato {
    private int minimo; 
    private int maximo; 
    private double promedio;
       
    public Dato() {
    
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
    public String toString (){
        String st = "Maximo: "+this.getMaximo()+" Minimo: "+this.getMinimo()+" Promedio: "+this.getPromedio();
        return st;
    }
    
    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }
     
}
