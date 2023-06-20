package com.mycompany.proyectopoo;


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
    public static String menuPrincipal(){
        String menu;
        String opciones = "Configuraciones\nNuevo juego\nReporte";
        menu = crearMenu(opciones);
        System.out.println(menu);
        return menu;
    }
    
    //1. Configuraciones - Menu de configuraciones
    public static String menuConfiguraciones(){
        String menu;
        String opciones = "Administrar términos académicos\nAdministrar materias y paralelos\nAdministrar preguntas\n";;
        menu = crearMenu(opciones);
        System.out.println(menu);
        return menu;
    }
    
    // 1.1 Administrar términos académicos - Menu de administrar términos académicos
    public static String menuAdministrarTerminosAcademicos(){
        String menu;
        String opciones = "Ingresar término\nEditar término\nConfigurar término para el juego";
        menu = crearMenu(opciones);
        System.out.println(menu);
        return menu;
    }
    
    // 1.2 Administrar materias y paralelos - Menu de Administrar materias y paralelos
    public static String menuAdministrarMateriasParalelos(){
        String menu;
        String opciones = "Ingresar materia\nEditar materia\nAgregar paralelo\nEliminar paralelo";
        menu = crearMenu(opciones);
        System.out.println(menu);
        return menu;
    }
    
    //1.3 Administrar preguntas - Menu de administrar preguntas
    public static String menuAdministrarPreguntas(){
        String menu;
        String opciones = "Visualizar preguntas\nAgregar pregunta\nEliminar pregunta";
        menu = crearMenu(opciones);
        System.out.println(menu);
        return menu;
    }
}
