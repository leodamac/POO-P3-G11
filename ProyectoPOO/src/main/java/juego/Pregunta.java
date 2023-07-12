package juego;

import java.util.Random;

public class Pregunta {
    private String enunciado;
    private String respuestaCorrecta;
    private String respuesta1;
    private String respuesta2;
    private String respuesta3;
    private String respuesta4;
    private String[] respuestas;
    private int nivel;
    
    public Pregunta(String enunciado, String respuesta1, String respuesta2, String respuesta3, String respuesta4, int nivel) {
        this.enunciado = enunciado;
        this.respuesta1 = respuesta1;
        setRespuestaCorrecta(this.respuesta1);
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.respuesta4 = respuesta4;
        this.respuestas = revolverRespuestas();
        this.nivel = nivel;
    }
    
    public Pregunta(String enunciado, String[] respuestas, int nivel) {
        this(enunciado, respuestas[0], respuestas[1], respuestas[2], respuestas[3], nivel);
    }
    
    public Pregunta(Pregunta pregunta){
        this.enunciado = pregunta.getEnunciado();
        this.respuesta1 = pregunta.getRespuesta1();
        this.respuesta2 = pregunta.getRespuesta2();
        this.respuesta3 = pregunta.getRespuesta3();
        this.respuesta4 = pregunta.getRespuesta4();
        this.respuestaCorrecta = pregunta.getRespuestaCorrecta();
        this.nivel = pregunta.getNivel();
        this.respuestas = pregunta.getRespuestas().clone();
        
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public String getRespuesta4() {
        return respuesta4;
    }

    public int getNivel() {
        return nivel;
    }
    
    public String[] getRespuestas(){
        return respuestas;
    }
    
    //Cambia de lugar las respuestas para que sea aleatoria su posicion
    public String[] revolverRespuestas(){
        String[] resp = {respuesta1, respuesta2, respuesta3, respuesta4};
        ordenarAleatoriamente(resp);
        return resp;
    }
    
    //Ordena aleatoriamente un Array
    public void ordenarAleatoriamente(String[] array) {
        Random random = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public void setRespuesta4(String respuesta4) {
        this.respuesta4 = respuesta4;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }


    
    @Override
    public String toString(){
        String datos= this.enunciado + "\n 1. " + respuestas[0] + "\n 2. "+ respuestas[1] + "\n 3. " + respuestas[2] + "\n 4. " + respuestas[3] + "\n";
        return datos;
    }
    
}
