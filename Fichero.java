/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trivial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La clase encargada de cargar el fichero con las preguntas y transformarlo en un arrylist
 * @author Samuel
 */
public class Fichero {
    private String path;
    private File file;

    public File getFile() {
        return file;
    }
    
    
    
    /**
     * Creamos este constructor en el que directamente iniciamos un file, en el cual al escribir el path este file se crea con el path que hemos escrito
     * @param path 
     */
    public Fichero(String path) {
        this.path = path;
        this.file = new File(path);
    }
    
    /**
     * La clase cargar pregunta hace lo que indica su nombre, inicialmente lee el fichero y graba este en un arraylist para utilizarlo despues
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public ArrayList<Pregunta> cargarPregunta () throws FileNotFoundException, IOException {

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        //arraylist para almacenar objeto clase pregunta
        ArrayList <Pregunta> preguntas2 = new ArrayList <>();
        String linea = br.readLine();
        //leemos la primera pregunta para el enunciado
        Pregunta pregunIM;
        while (linea != null) {
           pregunIM = new Pregunta();
           //grabamos el enunciado
           pregunIM.setEnunciado(linea);
            //creamos 4 variables para introducir en cada una las opciones
                String linea1 = br.readLine();
                
                
                
               String linea2 = br.readLine();
                
               String linea3 = br.readLine();
                
               String linea4 = br.readLine();
               
                pregunIM.setOpciones(linea1, linea2, linea3, linea4);
                //Crear objeto de la clase pregunta y lo aÃ±ado al arrayList
                //
                preguntas2.add(pregunIM);
                linea = br.readLine();
            }
        return preguntas2;
        
        
}
    
    
    
    
    
}
