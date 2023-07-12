package com.mycompany.proyectopoo;

import academico.Materia;
import academico.Paralelo;
import academico.TerminoAcademico;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import juego.Pregunta;
import personas.Estudiante;


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
        System.out.println(Menu.agregarMarco('-', pregunta));
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
        while(!salir && !objetos.isEmpty()){           
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
           System.out.println("(NOTA: ingrese solo numeros)");
           System.out.print("Ingrese el NUMERO: ");
           numero = sc.nextLine();
        }while(!isNumero(numero));
        
        return convierteTxtAEntero(numero);
    }
    
        public static void cargarDatosIniciales(TerminoAcademico terminoAcademico){
        Materia materia = new Materia("CCPG1043", "Programación Orientada a Objetos", 15);
        materia.addParalelo(new Paralelo(materia, 3, "url"));
        cargarEstudiantes(materia.getParalelos().get(0));
        cargarPreguntas(materia);
        
        terminoAcademico.addMateria(materia);        
    }
    
    public static void cargarEstudiantes(Paralelo paralelo){
        ArrayList estudiantes = new ArrayList();
        String estudiantesTexto = """
                                  202110136\tACELDO TORRES MARIA GRAZIA\tmaactorr@espol.edu.ec
                                  202108643\tAGUILAR TINOCO JEAN CARLOS\tjcaguila@espol.edu.ec
                                  202111928\tAMORETTI SANCHEZ JUAN CARLOS\tjamorett@espol.edu.ec
                                  202105946\tANDRADE VELASCO ANGELLO BERNIE\tangbeand@espol.edu.ec
                                  202211355\tARAUJO ORTEGA DIEGO ENZO JAVIER\tdienarau@espol.edu.ec
                                  202104816\tAZU PERLAZA NICOLE FERNANDA\tnfazu@espol.edu.ec
                                  202110219\tBALDEON BAQUE IVAN GONZALO\tivagbald@espol.edu.ec
                                  202113056\tBARBERAN GALLARDO MELISSA ESTEFANIA\tmelesbar@espol.edu.ec
                                  202109328\tBASILIO ACEBO DANIELA MILENA\tdmbasili@espol.edu.ec
                                  202210712\tBORBOR GUTIERREZ VICTOR DANIEL\tvicbguti@espol.edu.ec
                                  202006086\tCABRERA VIVANCO ALVARO DAVID\talvdcabr@espol.edu.ec
                                  202113049\tCORDERO CALLES RONALD ELIAS\trcordero@espol.edu.ec
                                  202010278\tESPINOZA PINELA ANGELO ALEXANDER\tangepine@espol.edu.ec
                                  202108288\tGONZABAY ESPIN DOUGLAS VICENTE\tdvgonzab@espol.edu.ec
                                  202100772\tGUAMAN QUIJIJE RONALD STEVEN\trsguaman@espol.edu.ec
                                  202208302\tHERRERA LEON ANTHONY ARTURO\tanthleon@espol.edu.ec
                                  202202552\tLINO INDACOCHEA STEVEN MOISES\tstemlino@espol.edu.ec
                                  202212965\tLORENZO LOPEZ ERICK GABRIEL\terillope@espol.edu.ec
                                  201405946\tMACIAS ARTURO LEONARDO DAVID\tleodamac@espol.edu.ec
                                  202001244\tMAZA PUNINE ISSAC ALEXANDER\tissamaza@espol.edu.ec
                                  202208880\tMEJIA PARRA KEVIN SANTIAGO\tkesameji@espol.edu.ec
                                  202211306\tNAVARRETE CASTILLO ANTHONY JOSUE\tannacast@espol.edu.ec
                                  202207726\tPOVEDA QUIMIZ MICHAEL CRESCENCIO\tmcpoveda@espol.edu.ec
                                  202207924\tRIVAS ABAD BRAULIO DE JESUS\tbrarabad@espol.edu.ec
                                  202111589\tRIVAS PINCAY EMMANUEL GERARDO\tegrivas@espol.edu.ec
                                  202203428\tROMERO ALMEIDA EMILIO JOSE\temjorome@espol.edu.ec
                                  202111910\tSANTANDER LOPEZ EDU ISRAEL\teduisant@espol.edu.ec
                                  201417520\tSUAREZ MENDIETA GARY STEVEN\tgssuarez@espol.edu.ec
                                  202205324\tSUAREZ VALDIVIESO JOSE JULIO\tjojusuar@espol.edu.ec
                                  202107645\tVARGAS ISA GENESIS DAYANNA\tgdvargas@espol.edu.ec
                                  202109229\tVILLAMAGUA ESCUDERO JUAN MATEO\tjuamvill@espol.edu.ec
                                  202106050\tZAMORA CEDE\u00d1O JORDY STEVEN\tjszamora@espol.edu.ec
                                  202208260\tZARUMA GAME JOSHUA ANDRES\tjazaruma@espol.edu.ec""";
        for(String estudiante: estudiantesTexto.split("\n")){
            String[] datos = estudiante.split("\t");
            estudiantes.add(new Estudiante(datos[1], datos[0], datos[2]));
        }
        
        paralelo.addEstudiantes(estudiantes);
            
    }
    
    public static void cargarPreguntas(Materia materia){
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        // La primera pregunta añadida es la correcta
        preguntas.add(new Pregunta("¿Pregnta 1?", "1","2",  "3", "4", 1));
        preguntas.add(new Pregunta("¿Pregunta 2?", "1", "2", "3", "4", 2));
        preguntas.add(new Pregunta("¿Pregunta 3?","1", "2", "3", "4", 3));
        preguntas.add(new Pregunta("¿Pregunta 4?","1", "2", "3", "4", 4));
        preguntas.add(new Pregunta("¿Pregunta 5?","1", "2", "3", "4", 5));
        preguntas.add(new Pregunta("¿Pregunta 6?","1", "2", "3", "4", 6));
        preguntas.add(new Pregunta("¿Pregunta 7?","1", "2", "3", "4", 7));
        preguntas.add(new Pregunta("¿Pregunta 8?","1", "2", "3", "4", 8));
        preguntas.add(new Pregunta("¿Pregunta 9?","1", "2", "3", "4", 9));
        preguntas.add(new Pregunta("¿Pregunta 10?","1", "2", "3", "4", 10));
        preguntas.add(new Pregunta("¿Pregunta 11?","1", "2", "3", "4", 11));
        preguntas.add(new Pregunta("¿Pregunta 12?","1", "2", "3", "4", 12));
        preguntas.add(new Pregunta("¿Pregunta 13?","1", "2", "3", "4", 13));
        preguntas.add(new Pregunta("¿Pregunta 14?","1", "2", "3", "4", 14));
        preguntas.add(new Pregunta("¿Pregunta 15?","1", "2", "3", "4", 15));
        
        materia.addPreguntas(preguntas);
    }
    
    public static void visualizarPreguntas(ArrayList<ArrayList<Pregunta>>preguntas, Scanner sc){
        int i = 0;
        int indice = 0;
        boolean hayPreguntas = false;
        // EL while se ejecutara mientras el indice sea menor a la cantidad de niveles de las preguntas
        while(indice<preguntas.size()){
            for (Pregunta p: preguntas.get(indice)){
                i++;
                System.out.print("Presione ENTER para ver la pregunta nº" + i);
                hayPreguntas = true;
                sc.nextLine();
                // Muestra la pregunta
                System.out.println(p);
            }
            indice++;
        }
        if(!hayPreguntas){
            System.out.println("NO HAY PREGUNTAS");
        }
    }
    
    public static void agregarPregunta(Materia materia, ArrayList<ArrayList<Pregunta>>preguntas, Scanner sc){
        System.out.println("Ingrese el enunciado de la pregunta: ");
        String enunciado = sc.nextLine();
        String[] respuestas = new String[4];
        for(int i=0; i<4;i++){
            // Pide ingresar la respuesta correcta
            if(i==0){
                System.out.println("Ingrese la RESPUESTA CORRECTA: ");
            }
            // Pide ingresar las respuestas que no son correctas
            else{
                System.out.println("Ingrese la RESPUESTA INCORRECTA: ");}
            respuestas[i] = sc.nextLine();
        }
        System.out.println("Ingrese el NIVEL de la pregunta: ");
        int nivel = Menu.pideNumero(sc);
        // Añade la nueva pregunta en la lista de preguntas segun el nivel
        preguntas.get(nivel-1).add(new Pregunta(enunciado, respuestas, nivel));
        System.out.println("¡PREGUNTA AÑADIDA CON EXITO!");
        materia.setTodosLosNivelesTienenPreguntas(true);
        sc.nextLine();
    }
    //Selecciona los indices de la pregunta segun el nivel y el indice en el array del nivel
    //ejemplo La pregunta esta en el array de las preguntas nivel 1 y el indice es 2 por lo que seria 2,1
    public static int[] seleccionarIndicesPregunta(ArrayList<ArrayList<Pregunta>> preguntas, Scanner sc){
        int[] respuesta = {-1,-1};
        Iterator iterador = preguntas.iterator();//niveles de las preguntas
        ArrayList<Pregunta> preguntasNivel = null;
        int nivel = 0;
        int hayPreguntas = 0;
        while (iterador.hasNext()){
            preguntasNivel = (ArrayList<Pregunta>)iterador.next();//Preguntas de cada nivel
            //Si la lista de preguntas no está vacío entonces muestra la pregunta y un formato

            int i = 0;
            nivel++;
            System.out.println("Nivel " + nivel);
            for(Pregunta pregunta: preguntasNivel){
                i++;
                hayPreguntas++;
                System.out.println(i + ") " + pregunta.getEnunciado());
            }
            System.out.println(crearLineaSimbolo('+',50));

        }
        if(hayPreguntas>0){
            System.out.println("Seleccione el nivel de la pregunta");
            int nivelSeleccion = pideNumero(sc);
            System.out.println("Seleccione el indice de la pregunta");
            int indicePreguntaSeleccion = pideNumero(sc);
            respuesta[0] = (nivelSeleccion - 1);
            respuesta[1] = (indicePreguntaSeleccion - 1);
        }else{
            System.out.println("No hay preguntas");
        }
        
        return respuesta;
    }
    //Selecciona los indices de las preguntas para despues eliminar
    public static void eliminarPregunta(Materia materia, ArrayList<ArrayList<Pregunta>> preguntas, Scanner sc){
        int[] indices = seleccionarIndicesPregunta(preguntas, sc);//selecciona los indices de la preguntas
        if(indices[0]>-1){
            Iterator<ArrayList<Pregunta>>iterador = preguntas.iterator();//crea el iterador
            int n = 0;
            boolean salir = false;
            while (iterador.hasNext() && !salir){
                ArrayList<Pregunta> preguntasNivel = (ArrayList<Pregunta>)iterador.next();//es la lista de cada nivel
                if (indices[0] == n){//si coincide el nivel de incies[0] con n entonces entra en el if
                    Iterator it = preguntasNivel.iterator();// iterador de las preguntas en cada nivel
                    int i = 0;
                    while (it.hasNext() && !salir){
                        it.next();
                        //si el indice[1] coincide con el i entonces va a remover esa pregunta
                        if (indices[1] == i){
                            it.remove();
                            materia.setTodosLosNivelesTienenPreguntas(false);
                            salir = true;
                        }
                        i++;
                    }
                }
                n++; 
            }
        }
    }
}