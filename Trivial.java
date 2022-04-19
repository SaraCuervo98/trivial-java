/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trivial;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * En esta clase se llevara a cabo toda la ejecución del codigo y la grabacion y lectura de archivos
 * @author Samuel
 */
public class Trivial {
static Scanner sc = new Scanner(System.in);
static Jugador jugador;
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int opcion = -1;
        
        while (opcion != 0 && opcion != 1) {
            System.out.println("Elige una de las siguientes opciones:"
                    + "\n1-Cargar preguntas y jugar"
                    + "\n0-Ver ultima partida");
            opcion = sc.nextInt();
            
            sc.nextLine();
            switch (opcion) {
                
                case 0:
                    System.out.println("Has elegido ver la ultima partida");
                    try {
            //Inicializamos el fileInput y creamos otro objectInto para que sea mas facil la lectura del archivo binario
            FileInputStream fis = new FileInputStream("datos.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            //leemos los puntos el nombre y la fecha, en ese orden el cual es en el que se grabo
            int punt = ois.readInt();
            String leer = (String)ois.readObject();
            Date d = (Date)ois.readObject();
                        
                        
            ois.close();
            System.out.println(leer);
            System.out.println("Puntuacion: "+punt);
            System.out.println(d);
        } catch (IOException ex) {
                        System.err.println("Error al leer el fichero binario");

        }       catch (ClassNotFoundException ex) {
                    Logger.getLogger(Trivial.class.getName()).log(Level.SEVERE, null, ex);
                }
                    break;

                case 1:
                    System.out.println("Has elegido cargar preguntas y jugar");
                    System.out.println("Primero introduce tu nombre");
                    String nombre1 = sc.nextLine();
                    //Inicializamos el nombre para introducirlo y que posteriormente lo nombre
                    jugador = new Jugador(nombre1);
                    System.out.println("Bienvenido " +jugador.getNombre());
                    //Iniciamos el arraylist de tipo pregunta que utilizaremos mas adelante
                    ArrayList <Pregunta> preguntas = new ArrayList <>();
                    System.out.println("Escribe el archivo de las preguntas: ");
                    String ruta = sc.nextLine();
                    //inicializamos e introducimos el fichero y comprobamos si este existe
                    Fichero fichero = new Fichero(ruta);
                    
                    while (!fichero.getFile().exists()) {
                        System.out.println("El fichero no existe");
                        System.out.println("Introducelo otra vez");
                        ruta = sc.nextLine();
                        fichero = new Fichero(ruta);
                   
                    }
                    //Utilizamos el arraylist creado anteriormente para cargar las preguntas en el y podeer leer los enunciados y respuestas
                    preguntas = fichero.cargarPregunta();
                    
                    for (int i = 0; i < 5; i++) {
                        //eligmos la pregunta correcta, es decir la primera
                        preguntas.get(i).setCorrecta(preguntas.get(i).getOpciones().get(0));
                        //imprimimos las preguntas
                        System.out.println(preguntas.get(i).imprimePregunta());
                        String opc = sc.nextLine();
                        
                        opc = opc.toUpperCase();
                        switch (opc) {
                            //imprimimos las opciones guardadas en el arraylist
                            case "A": opc = preguntas.get(i).getOpciones().get(0);
                            break;
                            case "B": opc = preguntas.get(i).getOpciones().get(1);
                            break;
                            case "C": opc = preguntas.get(i).getOpciones().get(2);
                            break;
                            case "D": opc = preguntas.get(i).getOpciones().get(3);
                            break;
                            
                        }
                        if (opc.equals(preguntas.get(i).getCorrecta())) {
                            System.out.println("Has acertado!");
                            jugador.sumarPunto();
                        } else {
                            System.out.println("No has acertado ");
                            System.out.println("La respuesta correcta es: " + preguntas.get(i).getCorrecta());
                        }
                        
                    }
                    System.out.println("Has obtenido un total de: " +jugador.getPuntos()+" puntos");
                    System.out.println("Te gustaria guardar tu partida?");
                    System.out.println("Introduce s para guardar y n para no");
                    String partida = "";
                    while (!"s".equals(partida) && !"n".equals(partida) ){
                        partida = sc.nextLine();
                    if (partida.equals("s")) {
                        try {
                            //Iniciamos el fileOutput y el ObjectOutput para grabar el archivo binario con los puntos, el nombre y la fecha
            FileOutputStream fos = new FileOutputStream("datos.dat");
                try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                    oos.writeInt(jugador.getPuntos());
                    oos.writeObject(jugador.getNombre());
                    Date d = new Date();
                    oos.writeObject(d);
                    oos.close();
                }
        } catch (IOException ex) {
                        System.err.println("Error al escribir archivo binario");
        }
                    }else if(partida.equals("n")) {
                        System.out.println("No has guardado la partida, hasta la proxima");
                    }else {
                        System.out.println("No has introducido un valor valido vuelve a intentarlo");
                        
                    }
                    }
                    
                   
                    
                    
                    break;

                default:
                    System.out.println("No has elegido una opcion valida, vuelve a introducirlo");
                    break;
            }
        }
    }
    
}
