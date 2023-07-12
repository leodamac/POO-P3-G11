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

    public QuienQuiereSerMillonario (ArrayList<ArrayList<Pregunta>> preguntas, Estudiante estudiante) {
        this.preguntas = preguntas;
        this.indicePreguntas = 0;
        this.ganancias = 0;
        this.estudiante = estudiante;
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

            Pregunta preguntaActual = (Pregunta)(preguntasNivel.get(n));
            System.out.println("Pregunta #" + (indicePreguntas + 1) + ": ");

            String[] respuestas = preguntaActual.getRespuestas();
            Menu.mostrarPregunta(preguntaActual);
            String usuarioString = "";
            boolean salir = false;
            do{
                System.out.print("Elige la opción correcta (1-" + preguntaActual.getRespuestas().length + "): ");
                usuarioString = scanner.nextLine();
                switch (usuarioString){
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                        salir = true;
                        break;
                    default:
                        System.out.println("Elige solamente numeros entre 1-4");
                }
            }
            while(!salir);
            int usuario = Integer.parseInt(usuarioString);
            System.out.println(preguntaActual.getRespuestas()[usuario-1] +" "+(preguntaActual.getRespuestaCorrecta()));
            System.out.println(respuestas[usuario-1].equals(preguntaActual.getRespuestaCorrecta()));
            if (respuestas[usuario-1].equals(preguntaActual.getRespuestaCorrecta())) {
                ganancias += preguntaActual.getNivel() *100;
                System.out.println("¡Respuesta correcta! Has ganado $" + preguntaActual.getNivel() *100);
                System.out.println("Ganancias totales: $" + ganancias);
                System.out.println();
                indicePreguntas++;
            } else {
                System.out.println("Respuesta incorrecta. ¡Fin del juego!");
                break;
            }
        }

        System.out.println("¡Has terminado el juego!");
        System.out.println("Ganancias totales: $" + ganancias);
        System.out.println("¡Gracias por jugar!");
    }

}