package juego;

public class Pregunta {
    private String pregunta;
    private Respuesta[] posiblesRespuestas;
    
    // Recibe un string como pregunta un varias respuestas
    public Pregunta(String pregunta, Respuesta[] respuestas){
        this.pregunta = pregunta;
        this.posiblesRespuestas = respuestas;
        
    }
    // Devuelve la respuesta correcta de la pregunta
    public Respuesta obtenerRespuestaCorrecta(){
        Respuesta r = null;
        //inicializa la variable i en 0 para ser usada como indice
        int i=0;
        while (r == null && i < 4){
            // Seleccionna 1 respues en la posicion i
            Respuesta respuesta = posiblesRespuestas[i];
            // Pregunta si es respuesta a la pregunta es correcta
            if (respuesta.isCorrecto()){
                // si es correcta entonces r sera igual a esa respuesta
                r = respuesta;
            }
            i++;
        }
        //Retorna r
        return r;
    }

}
