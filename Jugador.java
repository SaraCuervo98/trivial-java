/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trivial;

import java.io.Serializable;

/**
 * La clase jugador como su nombre indica sera la encargada de grabar el nombre que se introduzca
 * @author Samuel
 */
public class Jugador implements Serializable{
    //Atributos
    private String nombre;
    private int puntos;
    
    //Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    //Constructores
    /**
     * Con este constructor inicializamos los puntos a cero y lo utilizaremos para grabar el nombre
     * @param nombre 
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }
    /**
     * Este metodo sumara puntos al jugador cuando acierte
     * @return sumar un punto al anterior
     */
    public int sumarPunto() {
        return this.puntos++;
    }
    
    
}
