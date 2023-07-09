package com.mycompany.proyectopoo;

import academico.TerminoAcademico;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import juego.Pregunta;


public class Menu {
    
    public static String crearMenu(String[] opciones){
        String menu = "";
        int indice = 1;
        for(String opcion: opciones){
            menu += indice + ". " + opcion + "\n";
            indice++;
        }
        menu += indice + ". Salir";
        return menu;
    }
    
    public static String crearMenu(String opciones){
        String menu = crearMenu(opciones.split("\n"));
        return menu;
    }
    
    //menu del inicio del programa
    private static String menuPrincipal(){
        String menu;
        String opciones = "Configuraciones\nNuevo juego\nReporte";
        menu = crearMenu(opciones);
        return menu;
    }
    
    //1. Configuraciones - Menu de configuraciones
    private static String menuConfiguraciones(){
        String menu;
        String opciones = "Administrar términos académicos\nAdministrar materias y paralelos\nAdministrar preguntas\n";;
        menu = crearMenu(opciones);
        return menu;
    }
    
    // 1.1 Administrar términos académicos - Menu de administrar términos académicos
    private static String menuAdministrarTerminosAcademicos(){
        String menu;
        String opciones = "Ingresar término\nEditar término\nConfigurar término para el juego";
        menu = crearMenu(opciones);
        return menu;
    }
    
    // 1.2 Administrar materias y paralelos - Menu de Administrar materias y paralelos
    private static String menuAdministrarMateriasParalelos(){
        String menu;
        String opciones = "Ingresar materia\nEditar materia\nAgregar paralelo\nEliminar paralelo";
        menu = crearMenu(opciones);
        return menu;
    }
    
    //1.3 Administrar preguntas - Menu de administrar preguntas
    private static String menuAdministrarPreguntas(){
        String menu;
        String opciones = "Visualizar preguntas\nAgregar pregunta\nEliminar pregunta";
        menu = crearMenu(opciones);
        return menu;
    }
   
    // crea una linea de un simbolo y una cantidad ejemplo simbolo = *, cantidad= 3, se creara *** o sea se repite n veces el simbolo
    public static String crearLineaSimbolo(char simbolo, int cantidad){
        String linea = "";
        for (int i =0; i<cantidad; i++){
            linea += simbolo;
        }
        return linea;
    }
    
    // agrega un marco con un simbolo elegido a un array de cadenas de caracteres
    public static String agregarMarco(char simbolo, String[] cadenasDeCaracteres){
        int mayor=0;
        String paraAgregarMarco = "";
        
        // encuentra cual es la cadena de caracteres de mayor tamaño
        for(String cadena: cadenasDeCaracteres){
            if (cadena.length()>mayor){
                mayor = cadena.length();
            }
        }
        
        //agrega una linea de igual tamaño de la mayor cadena de caracteres + 3
        paraAgregarMarco += crearLineaSimbolo(simbolo, mayor+3) + "\n";
        
        //A cada cadena de caracteres le agrega espacios hasta que llegue al tamaño de la mayor cadena de caracteres y al final le agrega el simbolo
        for (String cadena: cadenasDeCaracteres){
            paraAgregarMarco += simbolo + " " + cadena + crearLineaSimbolo(' ', mayor-cadena.length()) + " " + simbolo + "\n";
        }
        
        //agrega una linea de igual tamaño de la mayor cadena de caracteres + 3
        paraAgregarMarco += crearLineaSimbolo(simbolo, mayor+4);

        return paraAgregarMarco;
    }
    // agrega un marco con un simbolo por defecto "*" a un array de cadenas de caracteres
    public static String agregarMarco(String[] cadenasDeCaracteres){
        return agregarMarco('*', cadenasDeCaracteres);
    }
    
    // agrega un marco con un simbolo elegido a una cadena de caracteres
    public static String agregarMarco(char simbolo, String cadenasDeCaracteres){
        return agregarMarco(simbolo, cadenasDeCaracteres.split("\n"));
    }
    
    // agrega un marco con un simbolo por defecto "*" a una cadena de caracteres
    public static String agregarMarco(String cadenasDeCaracteres){
        return agregarMarco('*', cadenasDeCaracteres.split("\n"));
    }
    
    // agrega un marco con un simbolo por defecto "*" a una Pregunta
    public static String agregarMarco(char simbolo, Pregunta pregunta){
        int mayor=0;
        String paraAgregarMarco = "";
        String[] cadenasDeCaracteres = pregunta.toString().split("\n");
        // encuentra cual es la cadena de caracteres de mayor tamaño
        for(String cadena: cadenasDeCaracteres){
            if (cadena.length()>mayor){
                mayor = cadena.length();
            }
        }
        
        //agrega una linea de igual tamaño de la mayor cadena de caracteres + 3
        paraAgregarMarco += crearLineaSimbolo(simbolo, mayor+3) + "\n";
        
        //A cada cadena de caracteres le agrega espacios hasta que llegue al tamaño de la mayor cadena de caracteres y al final le agrega el simbolo
        int i = 0;
        for (String cadena: cadenasDeCaracteres){
            paraAgregarMarco += simbolo + " " + cadena + crearLineaSimbolo(' ', mayor-cadena.length()) + " " + simbolo + "\n";
            if (i ==0){
                paraAgregarMarco += crearLineaSimbolo(simbolo, mayor+3) + "\n";
            }
            i++;
        }
        
        //agrega una linea de igual tamaño de la mayor cadena de caracteres + 3
        paraAgregarMarco += crearLineaSimbolo(simbolo, mayor+4);

        return paraAgregarMarco;
    }
    
    public static void mostrarMenuPrincipal(){
        System.out.println(agregarMarco(menuPrincipal()));
    }
    
    public static void mostrarMenuConfiguraciones(){
        System.out.println(agregarMarco(menuConfiguraciones()));
    }

    
    // Muestra el menu 1.1 Administrar términos académicos - Menu de administrar términos académicos
    public static void mostrarMenuAdministrarTerminosAcademicos(){
        System.out.println(agregarMarco(menuAdministrarTerminosAcademicos()));

    }
    
    // Muestra el menu 1.2 Administrar materias y paralelos - Menu de Administrar materias y paralelos
    public static void mostrarmenuAdministrarMateriasParalelos(){
        System.out.println(agregarMarco(menuAdministrarMateriasParalelos()));
    }
    
    // Muestra el menu 1.3 Administrar preguntas - Menu de administrar preguntas
    public static void mostrarmenuAdministrarPreguntas(){
       System.out.println(agregarMarco( menuAdministrarPreguntas()));
    }
    
    //Le añade un marco a la pregunta con sus 4 respuestas.
    public static void mostrarPregunta(Pregunta pregunta){
        System.out.println(Menu.agregarMarco('*', pregunta));
    }
    
    public static TerminoAcademico seleccionarTerminoAcademico(ArrayList<TerminoAcademico> terminosAcademicos, Scanner sc){
        Collections.sort(terminosAcademicos);//se ordenan los terminos academicos de menor a mayor
        TerminoAcademico terminoAcademico = (TerminoAcademico)seleccionarObjeto(terminosAcademicos, sc);
        return terminoAcademico;
    }
    
    public static Object seleccionarObjeto(ArrayList objetos, Scanner sc){
        int indice = 0;
        for(Object o: objetos){
            System.out.println(indice+1 + ". " + o);
            indice++;
        }
        boolean salir = false;
        Object objeto = null;
        while(!salir){           
            int op = pideNumero(sc);//pide el numero del usuario
            // se pone como null para preguntar mas adelante si el usuario puso un numero valido de objeto

            if(op-1<indice && op-1>=0){
                objeto = objetos.get(op-1);
                salir = true;
            }
            if (objeto == null){
                System.out.println("Indice incorrecto");
            }
        }      
        return objeto;
    }
    //verifica que una cadena de texto sea un numero entero
    public static boolean isNumero(String cadena){
        if (cadena == null)
            return false;
        return cadena.matches("-?\\d+");
    }
    
    //convierte una cadena de texto en entero
    public static int convierteTxtAEntero(String texto){
        return Integer.parseInt(texto);
    }
    
    //pide un numero en str y lo convierte en int
    public static int pideNumero(Scanner sc){
        String numero;
        do{
           System.out.println("NOTA ingrese solo numeros");
           System.out.print("Ingrese el NUMERO: ");
           numero = sc.nextLine();
        }while(!isNumero(numero));
        
        return convierteTxtAEntero(numero);
    }
}