package juego;

import com.mycompany.proyectopoo.Menu;
import java.util.ArrayList;
import java.util.Scanner;
import personas.Estudiante;
import java.util.Random;


public class QuienQuiereSerMillonario  {
    private ArrayList<ArrayList<Pregunta>> preguntas;
    private int indicePreguntas;
    private int ganancias;
    private Estudiante estudiante;
    private Comodin comodinCincuenta;
    private Comodin comodinCompañero;
    private Comodin comodinPublico;
    

    public QuienQuiereSerMillonario (ArrayList<ArrayList<Pregunta>> preguntas, Estudiante estudiante) {
        this.preguntas = preguntas;
        this.indicePreguntas = 0;
        this.ganancias = 0;
        this.estudiante = estudiante;
        comodinCincuenta = new Comodin("50/50");
        comodinCompañero = new Comodin("Compañero");
        comodinPublico = new Comodin("Publico");
    }

    public void iniciarJuego(Scanner scanner) {
        System.out.println("¡Bienvenido a ¿Quién quiere ser millonario?!");
        System.out.println("Responderás una serie de preguntas.");
        System.out.println("Listo para empezar...");
        System.out.println();


        while (indicePreguntas < preguntas.size()) {
            ArrayList preguntasNivel = preguntas.get(indicePreguntas);
            Random rand = new Random();

            // Obtiene un numero aleatorio 0 - size(Preguntas.nivel)
            int n = rand.nextInt(preguntasNivel.size());

            Pregunta preguntaActual = new Pregunta((Pregunta)(preguntasNivel.get(n)));
            System.out.println("Pregunta #" + (indicePreguntas + 1) + " : ");

            String[] respuestas = preguntaActual.getRespuestas();          
            
            if(!comodinCincuenta.isUsado() || !comodinCompañero.isUsado() || !comodinPublico.isUsado()){ //si no ha usado algun comodin, pregunta si quiere usar alguno para cada pregunta
                Menu.mostrarPregunta(preguntaActual);
                System.out.println("Desea comodines S si Sí: ");
                if (scanner.nextLine().toUpperCase().equals("S")){
                    System.out.println(Menu.crearMenu("50/50\nCompañero\nAyuda del público"));
                    boolean salir = false;
                    do{
                        System.out.print("Ingrese su opción: ");
                        String opcion = scanner.nextLine();//pregunta la opcion al usuario
                        System.out.println("");
                        switch(opcion){
                            case "1": //se selecciona las respuesta que se van a eliminar en el 50/50
                                if(!comodinCincuenta.isUsado()){
                                    comodinCincuenta.usar();
                                    comodinCincuenta.setPregunta(preguntaActual);
                                    Random random = new Random();
                                    boolean fin = false;
                                    ArrayList<Integer> incorrectas = new ArrayList();
                                    while(!fin){
                                        int j = random.nextInt(4 );
                                        if(!respuestas[j].equals(preguntaActual.getRespuestaCorrecta()) && !incorrectas.contains(j)){
                                            incorrectas.add(j);
                                        }
                                        if(incorrectas.size()==2){
                                            fin = true;
                                        }
                                    }
                                    for(int indice: incorrectas){
                                        respuestas[indice] = " ";
                                    }
                                    salir = true;
                                }else{
                                    System.out.println("Ya ha seleccionado ESE comodín\n");
                                }
                                break;
                            case "2": //selecciona el compoñero de apoyo 
                                if(!comodinCompañero.isUsado()){
                                    comodinCompañero.usar();
                                    comodinCompañero.setPregunta(preguntaActual);
                                    salir = true;
                                }else{
                                    System.out.println("Ya ha seleccionado ESE comodín\n");
                                }
                                break;
                            case "3": //pregunta al curso publico
                                if(!comodinPublico.isUsado()){
                                    comodinPublico.usar();
                                    comodinPublico.setPregunta(preguntaActual);
                                    salir = true;
                                }else{
                                    System.out.println("Ya ha seleccionado ESE comodín\n");
                                }
                                break;
                            case "4":
                                System.out.println("NO ha seleccionado ningún comodín\n");
                                salir = true;
                                break;
                            default:
                                System.out.println("Ingrese solo numeros de las opciones\n");
                                break;
                        }
                    }while(!salir);
                }
            }
            String usuarioString = "";
            boolean salir = false;
            Menu.mostrarPregunta(preguntaActual);
            int usuario =0;

            do{
                System.out.print("Elige la opción correcta A,B,C,D: ");
                usuarioString = scanner.nextLine();
                switch (usuarioString){
                    case "A":
                        usuario = 1;
                        salir = true;
                        break;
                    case "B":
                        usuario = 2;
                        salir = true;
                        break;
                    case "C":
                        usuario = 3;
                        salir = true;
                        break;
                    case "D":
                        usuario = 4;
                        salir = true;
                        break;
                    default:
                        System.out.println("Elige solamente letras entre A-D");
                }
            }
            while(!salir);

            
            if (respuestas[usuario-1].equals(preguntaActual.getRespuestaCorrecta())) {
                ganancias += preguntaActual.getNivel() *100;
                System.out.println("¡Respuesta correcta! Has ganado $" + preguntaActual.getNivel() *100);
                System.out.println("Ganancias totales: $" + ganancias);
                System.out.println();
                if (indicePreguntas < preguntas.size()){
                    indicePreguntas++;
                }
            } else {
                System.out.println("Respuesta incorrecta. ¡Fin del juego!");
                break;
            }
        }

        System.out.println("¡Has terminado el juego!");
        System.out.println("¡Gracias por jugar!");
    }
    public int getNivelMax(){
        return indicePreguntas+1;
    }
    
    public int getGanancias(){
        return ganancias;
    }

    public Comodin[] getComodines(){
        Comodin[] comodines = {comodinCincuenta,  comodinCompañero, comodinPublico};
        return comodines;
    }
    public Estudiante getEstudiante(){
        return estudiante;
    }

}
