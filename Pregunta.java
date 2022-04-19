/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trivial;

import java.util.ArrayList;

/**
 * La clase encargada de generar el enunciado y las preguntas
 * @author Samuel
 */
public class Pregunta {
    private String enunciado;
    //Opciones la creo directamente siendo un arraylist porque me parece mas sencillo y util
    private ArrayList<String> opciones;
    //Correcta lo convierto en un string porque despues sera mas facil de comparar la respuesta
    private String correcta;

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public ArrayList<String> getOpciones() {
        return opciones;
    }
    //Creo un arraylist para que posteriormente hacer un set opciones meter cada opcion en una posicion del arraylist
    public void setOpciones(String opciones1, String opciones2, String opciones3, String opciones4) {
        ArrayList <String> opciones = new ArrayList<>();
        opciones.add(opciones1);
        opciones.add(opciones2);
        opciones.add(opciones3);
        opciones.add(opciones4);
        this.opciones = opciones;
        
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }
    
    
    /**
     * Simplemente coge los atributos anteriores y los imprime, en caso de opciones imprime las posiciones del arraylist
     * @return 
     */
    public String imprimePregunta() {
        return "Enunciado: " + this.enunciado + "\nA: " + this.opciones.get(0)+ 
                "\nB: " + this.opciones.get(1)+
                "\nC: "+ this.opciones.get(2)+
                "\nD: "+ this.opciones.get(3);
    }
    
    
    
    
}
