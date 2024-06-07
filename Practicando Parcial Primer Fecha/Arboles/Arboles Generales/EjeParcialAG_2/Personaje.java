/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjeParcialAG_2;

/**
 *
 * @author Usuario
 */
public class Personaje {
    private String nombre;
    private String tipo; //Dragon, Princesa, Animal, etc.
    
    public Personaje(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo(){
        return this.tipo;
    }

    public boolean esDragon(){
        return this.getTipo().equals("Dragon");
    }
    public boolean esPrincesa(){
        return this.getTipo().equals("Princesa");
    }
    
}
