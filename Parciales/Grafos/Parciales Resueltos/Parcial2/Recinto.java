/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesgrafos.Parcial2;

/**
 *
 * @author Usuario
 */
public class Recinto {
    private String nombre;
    private int tiempo;
    
    public Recinto(String nombre, int tiempo)
    {
        this.nombre = nombre;
        this.tiempo = tiempo;
    }
    
    public int getTiempo()
    {
        return this.tiempo;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
}
