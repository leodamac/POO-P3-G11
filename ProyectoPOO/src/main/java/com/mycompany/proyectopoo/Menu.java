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
        cargarPreguntasPOO(materia);
        
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
    
    public static void cargarPreguntasPOO(Materia materia){
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        String cuestionario= """
        Pregunta: ¿Cuál es el lenguaje de programación más utilizado para el desarrollo de aplicaciones de Android?
        Respuestas:
        A) Java
        B) C++
        C) Python
        D) JavaScript
        
        Pregunta: ¿Cuál es la palabra clave en Java para declarar una variable constante?
        Respuestas:
        A) final
        B) const
        C) static
        D) constant
        
        Pregunta: ¿Qué tipo de dato se utiliza para representar un valor verdadero o falso en Java?
        Respuestas:
        A) Boolean
        B) String
        C) Integer
        D) Float
        
        Pregunta: ¿Qué es un objeto en Java?
        Respuestas:
        A) Una instancia de una clase que tiene estado y comportamiento.
        B) Un bloque de código que se ejecuta cuando se llama a un método.
        C) Una variable que almacena un valor numérico.
        D) Un tipo de dato primitivo en Java.
        
        Pregunta: ¿Cuál es el método principal que se ejecuta al iniciar un programa en Java?
        Respuestas:
        A) main()
        B) start()
        C) run()
        D) execute()
        
        separacion
        Pregunta: ¿Qué es la herencia en Java?
        Respuestas:
        A) La capacidad de una clase para heredar de una clase base.
        B) La capacidad de una clase para heredar múltiples interfaces.
        C) La capacidad de una clase para tener múltiples constructores.
        D) La capacidad de una clase para cambiar su estado interno.
        
        Pregunta: ¿Qué es un constructor en Java?
        Respuestas:
        A) Un método que se utiliza para inicializar objetos y establecer sus valores iniciales.
        B) Un método que se ejecuta cuando se llama a un objeto.
        C) Un tipo de dato utilizado para almacenar texto en Java.
        D) Un bloque de código que se ejecuta cuando se produce una excepción.
        
        Pregunta: ¿Cuál es la diferencia entre una clase y un objeto en Java?
        Respuestas:
        A) Una clase define la estructura y el comportamiento, mientras que un objeto es una instancia específica de esa clase.
        B) Una clase es una instancia de un objeto.
        C) Una clase es un tipo de dato primitivo en Java.
        D) Una clase es una variable que almacena un valor numérico.
        
        Pregunta: ¿Qué es el polimorfismo en Java?
        Respuestas:
        A) La capacidad de una clase para tener varios métodos con el mismo nombre pero diferentes implementaciones.
        B) La capacidad de una clase para heredar de múltiples superclases.
        C) La capacidad de una clase para cambiar su estado interno.
        D) La capacidad de una clase para tener varios constructores.
        
        Pregunta: ¿Qué es el encapsulamiento en Java?
        Respuestas:
        A) Un principio de programación que combina datos y funciones relacionadas en una única entidad llamada clase, y oculta los detalles internos.
        B) La capacidad de una clase para tener múltiples atributos.
        C) Una instancia de una clase que tiene estado y comportamiento.
        D) La capacidad de una clase para implementar múltiples interfaces.
                             
        separacion
        Pregunta: ¿Cuál de las siguientes opciones es la forma correcta de declarar una variable constante en Java?
        Respuestas:
        A) final int num = 5;
        B) int const num = 5;
        C) static int num = 5;
        D) const int num = 5;
        
        Pregunta: ¿Cuál es la forma correcta de imprimir "Hola, mundo!" en la consola en Java?
        Respuestas:
        A) System.out.println("Hola, mundo!");
        B) print("Hola, mundo!");
        C) console.log("Hola, mundo!");
        D) display("Hola, mundo!");
        
        Pregunta: ¿Cuál de las siguientes opciones es un tipo de dato numérico entero en Java?
        Respuestas:
        A) Integer
        B) String
        C) Float
        D) Boolean
        
        Pregunta: ¿Qué es un bucle for en Java?
        Respuestas:
        A) Un bucle que se repite un número específico de veces.
        B) Un bucle que se ejecuta al menos una vez antes de verificar una condición.
        C) Un bucle que se repite mientras se cumpla una condición específica.
        D) Un bucle que se repite hasta que se cumpla una condición específica.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre los operadores en Java es verdadera?
        Respuestas:
        A) Java tiene operadores aritméticos, de asignación, de comparación, lógicos y otros.
        B) Java no tiene operadores aritméticos.
        C) Java solo tiene un operador de comparación: ==
        D) Los operadores en Java solo se pueden utilizar en bucles.
        
        separacion
        Pregunta: ¿Cuál es la forma correcta de declarar y asignar un arreglo de enteros en Java?
        Respuestas:
        A) int[] numbers = {1, 2, 3};
        B) int[] numbers = new int[3] {1, 2, 3};
        C) int[] numbers = new int[] {1, 2, 3};
        D) int[] numbers = [1, 2, 3];
        
        Pregunta: ¿Cuál de las siguientes opciones es un tipo de dato primitivo en Java?
        Respuestas:
        A) int
        B) Integer
        C) String
        D) Boolean
        
        Pregunta: ¿Qué es un método en Java?
        Respuestas:
        A) Un bloque de código que se ejecuta cuando se llama a un objeto.
        B) Una variable que almacena un valor numérico.
        C) Una instancia de una clase que tiene estado y comportamiento.
        D) Un bloque de código que se ejecuta cuando se produce una excepción.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre los constructores en Java es verdadera?
        Respuestas:
        A) Un constructor es un método que se ejecuta cuando se llama a un objeto.
        B) Un constructor se utiliza para inicializar objetos y establecer sus valores iniciales.
        C) Una clase puede tener múltiples constructores con diferentes parámetros.
        D) Todas las anteriores.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre las excepciones en Java es verdadera?
        Respuestas:
        A) Las excepciones son eventos inesperados o errores que ocurren durante la ejecución de un programa.
        B) Java proporciona un manejo de excepciones para capturar y manejar estos errores.
        C) Las excepciones se pueden clasificar en excepciones comprobadas y excepciones no comprobadas.
        D) Todas las anteriores.
        
        separacion
        Pregunta: ¿Qué es un interface en Java?
        Respuestas:
        A) Una especificación de métodos que una clase debe implementar.
        B) Una instancia de una clase que tiene estado y comportamiento.
        C) Un bloque de código que se ejecuta cuando se llama a un objeto.
        D) Una variable que almacena un valor numérico.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre los interfaces en Java es verdadera?
        Respuestas:
        A) Un interface puede implementar múltiples interfaces.
        B) Un interface puede heredar de una clase.
        C) Un interface puede tener variables de instancia.
        D) Un interface puede tener métodos con implementación.
        
        Pregunta: ¿Cuál de las siguientes opciones describe correctamente el polimorfismo en Java?
        Respuestas:
        A) La capacidad de una clase para tener varios métodos con el mismo nombre pero diferentes implementaciones.
        B) La capacidad de una clase para tener múltiples constructores.
        C) La capacidad de una clase para heredar de múltiples superclases.
        D) La capacidad de una clase para cambiar su estado interno.
        
        Pregunta: ¿Qué es el encapsulamiento en Java?
        Respuestas:
        A) Un principio de programación que combina datos y funciones relacionadas en una única entidad llamada clase, y oculta los detalles internos.
        B) La capacidad de una clase para tener múltiples atributos.
        C) Una instancia de una clase que tiene estado y comportamiento.
        D) La capacidad de una clase para implementar múltiples interfaces.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre los arreglos en Java es verdadera?
        Respuestas:
        A) Un arreglo puede almacenar diferentes tipos de datos en Java.
        B) Los arreglos en Java tienen un tamaño fijo y no se pueden cambiar una vez creados.
        C) Los arreglos en Java siempre comienzan con el índice 0.
        D) Los arreglos en Java solo pueden contener un elemento.
        
        separacion
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre las clases abstractas en Java es verdadera?
        Respuestas:
        A) Una clase abstracta puede tener métodos con implementación.
        B) Una clase abstracta no puede ser heredada por otras clases.
        C) Una clase abstracta puede ser instanciada y utilizada directamente.
        D) Una clase abstracta no puede tener ningún método.
        
        Pregunta: ¿Cuál de las siguientes opciones es la forma correcta de implementar una interfaz en una clase en Java?
        Respuestas:
        A) class MyClass implements MyInterface {}
        B) class MyClass extends MyInterface {}
        C) class MyClass extends MyInterface implements {}
        D) interface MyClass implements MyInterface {}
        
        Pregunta: ¿Qué es la sobrecarga de métodos en Java?
        Respuestas:
        A) La capacidad de una clase para tener varios métodos con el mismo nombre pero diferentes parámetros.
        B) La capacidad de una clase para heredar de múltiples superclases.
        C) La capacidad de una clase para tener varios constructores.
        D) La capacidad de una clase para cambiar su estado interno.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre las clases internas en Java es verdadera?
        Respuestas:
        A) Una clase interna puede acceder a los miembros privados de la clase externa.
        B) Una clase interna puede ser instanciada y utilizada directamente.
        C) Una clase interna no puede tener métodos.
        D) Una clase interna no puede tener atributos.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre los modificadores de acceso en Java es verdadera?
        Respuestas:
        A) Los modificadores de acceso en Java son public, private y protected.
        B) Los modificadores de acceso en Java son private, static y final.
        C) Los modificadores de acceso en Java son public, protected y default.
        D) Los modificadores de acceso en Java son private, public y abstract.
        
        separacion
        Pregunta: ¿Qué es la herencia múltiple en Java?
        Respuestas:
        A) La capacidad de una clase para heredar de múltiples superclases.
        B) La capacidad de una clase para tener múltiples constructores.
        C) La capacidad de una clase para cambiar su estado interno.
        D) La capacidad de una clase para tener varios métodos con el mismo nombre pero diferentes parámetros.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre los paquetes en Java es verdadera?
        Respuestas:
        A) Los paquetes en Java se utilizan para encapsular clases y proporcionar una estructura organizada.
        B) Los paquetes en Java son un tipo de dato primitivo.
        C) Los paquetes en Java son una forma de implementar interfaces.
        D) Los paquetes en Java solo pueden contener archivos de código fuente, no recursos.
        
        Pregunta: ¿Cuál es la diferencia entre el operador "==" y el método equals() en Java?
        Respuestas:
        A) El operador "==" compara el contenido de dos objetos, mientras que equals() compara las referencias de los objetos.
        B) El operador "==" compara las referencias de dos objetos, mientras que equals() compara el contenido de los objetos.
        C) El operador "==" se utiliza para asignar valores a variables, mientras que equals() se utiliza para comparar objetos.
        D) El operador "==" y el método equals() son sinónimos y se pueden utilizar indistintamente.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre la recursividad en Java es verdadera?
        Respuestas:
        A) La recursividad es cuando un método se llama a sí mismo directa o indirectamente.
        B) La recursividad es la capacidad de una clase para tener varios constructores.
        C) La recursividad es la capacidad de una clase para cambiar su estado interno.
        D) La recursividad es la capacidad de una clase para tener varios métodos con el mismo nombre pero diferentes parámetros.
        
        Pregunta: ¿Qué es la sobrescritura de métodos en Java?
        Respuestas:
        A) La capacidad de una clase para tener varios métodos con el mismo nombre pero diferentes implementaciones.
        B) La capacidad de una clase para tener varios constructores.
        C) La capacidad de una clase para heredar de múltiples superclases.
        D) La capacidad de una clase para cambiar su estado interno.                         
                             
        separacion
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre los bloques estáticos en Java es verdadera?
        Respuestas:
        A) Los bloques estáticos se ejecutan una vez cuando la clase se carga en memoria.
        B) Los bloques estáticos se utilizan para inicializar variables de instancia.
        C) Los bloques estáticos se ejecutan cada vez que se crea una instancia de una clase.
        D) Los bloques estáticos solo se pueden utilizar en interfaces.
        
        Pregunta: ¿Qué es la serialización en Java?
        Respuestas:
        A) La capacidad de convertir un objeto en una secuencia de bytes para su almacenamiento o transmisión.
        B) La capacidad de una clase para tener varios constructores.
        C) La capacidad de una clase para heredar de múltiples superclases.
        D) La capacidad de una clase para cambiar su estado interno.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre las colecciones en Java es verdadera?
        Respuestas:
        A) Las colecciones en Java son estructuras de datos que pueden contener objetos y otros tipos de datos.
        B) Las colecciones solo pueden almacenar un tipo de objeto a la vez.
        C) Las colecciones son una forma de representar datos primitivos en Java.
        D) Las colecciones en Java son equivalentes a los arreglos.
        
        Pregunta: ¿Qué es el autoboxing y el unboxing en Java?
        Respuestas:
        A) El autoboxing es la conversión automática de tipos primitivos a objetos, y el unboxing es la conversión automática de objetos a tipos primitivos.
        B) El autoboxing y el unboxing son términos equivalentes y se utilizan indistintamente en Java.
        C) El autoboxing es la conversión automática de objetos a tipos primitivos, y el unboxing es la conversión automática de tipos primitivos a objetos.
        D) El autoboxing y el unboxing se refieren a operaciones relacionadas con el manejo de excepciones en Java.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre las anotaciones en Java es verdadera?
        Respuestas:
        A) Las anotaciones en Java se utilizan para especificar metadatos sobre clases, métodos u otros elementos del código.
        B) Las anotaciones en Java son comentarios que se utilizan para documentar el código.
        C) Las anotaciones en Java son declaraciones condicionales que afectan el flujo de ejecución del programa.
        D) Las anotaciones en Java se utilizan para encapsular bloques de código y reutilizarlos en diferentes partes del programa.
        
        separacion
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre las interfaces funcionales en Java 8 y posteriores es verdadera?
        Respuestas:
        A) Las interfaces funcionales son interfaces que pueden tener un único método abstracto.
        B) Las interfaces funcionales son interfaces que no pueden tener métodos.
        C) Las interfaces funcionales son interfaces que solo pueden ser implementadas por clases abstractas.
        D) Las interfaces funcionales son interfaces que pueden tener múltiples métodos abstractos.
        
        Pregunta: ¿Qué es la programación orientada a aspectos (AOP) en Java?
        Respuestas:
        A) La programación orientada a aspectos es un enfoque para resolver problemas complejos en Java utilizando múltiples aspectos de la programación.
        B) La programación orientada a aspectos es un enfoque para dividir un programa en objetos y definir cómo interactúan entre sí.
        C) La programación orientada a aspectos es un enfoque para separar el código de la interfaz de usuario del código de lógica de negocio en una aplicación.
        D) La programación orientada a aspectos es un enfoque para definir y aplicar políticas de seguridad en una aplicación.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre la concurrencia en Java es verdadera?
        Respuestas:
        A) La concurrencia en Java se refiere a la ejecución simultánea de múltiples hilos de ejecución en un programa.
        B) La concurrencia en Java se refiere al manejo de excepciones durante la ejecución de un programa.
        C) La concurrencia en Java se refiere a la capacidad de una clase para heredar de múltiples superclases.
        D) La concurrencia en Java se refiere a la capacidad de una clase para tener múltiples constructores.
        
        Pregunta: ¿Qué es un bloque try-catch en Java?
        Respuestas:
        A) Un bloque de código utilizado para capturar y manejar excepciones en Java.
        B) Un bloque de código que se ejecuta cuando se llama a un objeto.
        C) Un bloque de código que se utiliza para inicializar objetos y establecer sus valores iniciales.
        D) Un bloque de código utilizado para declarar variables locales en Java.
        
        Pregunta: ¿Qué es la programación genérica en Java?
        Respuestas:
        A) La programación genérica es un enfoque para definir y utilizar clases y métodos que pueden trabajar con diferentes tipos de datos de manera segura.
        B) La programación genérica es un enfoque para resolver problemas complejos utilizando funciones puras, sin efectos secundarios.
        C) La programación genérica es un enfoque para definir y aplicar políticas de seguridad en una aplicación.
        D) La programación genérica es un enfoque para encapsular bloques de código y reutilizarlos en diferentes partes del programa utilizando funciones.
                             
        separacion
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre las expresiones lambda en Java es verdadera?
        Respuestas:
        A) Las expresiones lambda en Java se utilizan para declarar variables locales.
        B) Las expresiones lambda en Java se utilizan para encapsular bloques de código y reutilizarlos en diferentes partes del programa.
        C) Las expresiones lambda en Java se utilizan para especificar metadatos sobre clases, métodos u otros elementos del código.
        D) Las expresiones lambda en Java se utilizan para definir métodos anónimos de manera concisa.
        
        Pregunta: ¿Qué es la programación funcional en Java?
        Respuestas:
        A) La programación funcional en Java es un enfoque para resolver problemas complejos utilizando funciones puras, sin efectos secundarios.
        B) La programación funcional en Java es un enfoque para dividir un programa en objetos y definir cómo interactúan entre sí.
        C) La programación funcional en Java es un enfoque para definir y utilizar clases y métodos que pueden trabajar con diferentes tipos de datos de manera segura.
        D) La programación funcional en Java es un enfoque para encapsular bloques de código y reutilizarlos en diferentes partes del programa utilizando funciones.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre el manejo de hilos (multithreading) en Java es verdadera?
        Respuestas:
        A) El manejo de hilos en Java se refiere a la ejecución simultánea de múltiples hilos de ejecución en un programa.
        B) El manejo de hilos en Java se refiere al manejo de excepciones durante la ejecución de un programa.
        C) El manejo de hilos en Java se refiere a la capacidad de una clase para heredar de múltiples superclases.
        D) El manejo de hilos en Java se refiere a la capacidad de una clase para tener múltiples constructores.
        
        separacion
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre las expresiones regulares en Java es verdadera?
        Respuestas:
        A) Las expresiones regulares en Java son patrones utilizados para buscar y manipular texto.
        B) Las expresiones regulares en Java son operadores utilizados para realizar cálculos matemáticos.
        C) Las expresiones regulares en Java son estructuras de datos utilizadas para almacenar colecciones de elementos.
        D) Las expresiones regulares en Java son una forma de definir la estructura de una clase.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre la programación orientada a objetos en Java es verdadera?
        Respuestas:
        A) La programación orientada a objetos en Java se basa en el concepto de clases y objetos.
        B) La programación orientada a objetos en Java se basa en el uso de punteros para acceder a los objetos.
        C) La programación orientada a objetos en Java se basa en el uso exclusivo de funciones puras.
        D) La programación orientada a objetos en Java se basa en el uso de macros para generar código.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre las excepciones verificadas y no verificadas en Java es verdadera?
        Respuestas:
        A) Las excepciones verificadas en Java son aquellas que deben ser declaradas o capturadas en tiempo de compilación.
        B) Las excepciones no verificadas en Java son aquellas que pueden ser declaradas o capturadas en tiempo de compilación.
        C) Las excepciones verificadas en Java son aquellas que no requieren declaración o captura en tiempo de compilación.
        D) Las excepciones no verificadas en Java son aquellas que no se pueden declarar o capturar en tiempo de compilación.
        
        separacion
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre la herencia en Java es verdadera?
        Respuestas:
        A) La herencia en Java permite que una clase herede los campos y métodos de otra clase.
        B) La herencia en Java solo se puede lograr mediante la implementación de interfaces.
        C) La herencia en Java permite que una clase tenga múltiples clases base.
        D) La herencia en Java es una característica exclusiva de la programación orientada a objetos.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre los métodos abstractos en Java es verdadera?
        Respuestas:
        A) Un método abstracto es un método que no tiene implementación y debe ser implementado por una clase concreta.
        B) Un método abstracto es un método que ya tiene una implementación y no se puede modificar.
        C) Un método abstracto es un método que no se puede heredar ni utilizar en otras clases.
        D) Un método abstracto es un método que solo puede ser llamado desde una clase abstracta.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre los modificadores de acceso en Java es verdadera?
        Respuestas:
        A) Los modificadores de acceso en Java son public, private, protected y default.
        B) Los modificadores de acceso en Java son public, private y protected.
        C) Los modificadores de acceso en Java son static, final y abstract.
        D) Los modificadores de acceso en Java son protected, static y final.
        
        separacion
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre los paquetes en Java es verdadera?
        Respuestas:
        A) Los paquetes en Java se utilizan para organizar clases y evitar conflictos de nombres.
        B) Los paquetes en Java se utilizan para definir variables locales.
        C) Los paquetes en Java se utilizan para encapsular bloques de código y reutilizarlos en diferentes partes del programa.
        D) Los paquetes en Java se utilizan para especificar metadatos sobre clases, métodos u otros elementos del código.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre el polimorfismo en Java es verdadera?
        Respuestas:
        A) El polimorfismo en Java permite que una variable de un tipo base pueda referenciar a objetos de diferentes subtipos.
        B) El polimorfismo en Java solo se puede lograr mediante la implementación de interfaces.
        C) El polimorfismo en Java permite que una clase tenga múltiples constructores.
        D) El polimorfismo en Java es una característica exclusiva de la programación orientada a objetos.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre los métodos estáticos en Java es verdadera?
        Respuestas:
        A) Un método estático se puede llamar directamente desde la clase, sin crear una instancia de la clase.
        B) Un método estático se puede llamar solo desde una instancia de la clase.
        C) Un método estático no puede acceder a variables de instancia de la clase.
        D) Un método estático solo se puede declarar en una interfaz.
        
        separacion
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre las interfaces en Java es verdadera?
        Respuestas:
        A) Una interfaz en Java define un contrato que una clase debe cumplir al implementarla.
        B) Una interfaz en Java puede tener variables de instancia.
        C) Una interfaz en Java puede tener métodos con implementación.
        D) Una interfaz en Java se utiliza para crear objetos.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre las clases finales en Java es verdadera?
        Respuestas:
        A) Una clase final en Java no puede ser heredada por otras clases.
        B) Una clase final en Java no puede contener métodos abstractos.
        C) Una clase final en Java no puede implementar interfaces.
        D) Una clase final en Java no puede tener variables de instancia.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre las clases internas en Java es verdadera?
        Respuestas:
        A) Una clase interna en Java puede acceder a los miembros privados de la clase externa.
        B) Una clase interna en Java no puede acceder a los miembros privados de la clase externa.
        C) Una clase interna en Java puede ser instanciada y utilizada directamente.
        D) Una clase interna en Java no puede tener atributos.
        
        separacion
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre la programación concurrente en Java es verdadera?
        Respuestas:
        A) La programación concurrente en Java se refiere a la ejecución simultánea de múltiples hilos de ejecución en un programa.
        B) La programación concurrente en Java se refiere al manejo de excepciones durante la ejecución de un programa.
        C) La programación concurrente en Java se refiere a la capacidad de una clase para heredar de múltiples superclases.
        D) La programación concurrente en Java se refiere a la capacidad de una clase para tener múltiples constructores.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre las anotaciones en Java es verdadera?
        Respuestas:
        A) Las anotaciones en Java se utilizan para especificar metadatos sobre clases, métodos u otros elementos del código.
        B) Las anotaciones en Java son comentarios que se utilizan para documentar el código.
        C) Las anotaciones en Java son declaraciones condicionales que afectan el flujo de ejecución del programa.
        D) Las anotaciones en Java se utilizan para encapsular bloques de código y reutilizarlos en diferentes partes del programa.
        
        Pregunta: ¿Cuál de las siguientes afirmaciones sobre las clases anónimas en Java es verdadera?
         Respuestas:
         A) Una clase anónima en Java es una clase que no tiene nombre y se utiliza para implementar una interfaz o extender una clase abstracta de forma directa.
         B) Una clase anónima en Java es una clase que solo puede tener un constructor y no puede tener ningún método adicional.
         C) Una clase anónima en Java es una clase que solo puede ser instanciada y utilizada directamente, pero no puede ser heredada por otras clases.
         D) Una clase anónima en Java es una clase que no puede acceder a los miembros privados de la clase externa. 
        """;
        int nivel = 0;
        for (String linea : cuestionario.split("separacion")){
            nivel ++;
            for (String l : linea.split("Pregunta:")){
                if (l.split("Respuestas:").length>1){
                    String pregunta = (l.split("Respuestas:")[0].strip());
                    ArrayList<String> respuestas = new ArrayList<>();
                    for (String l1 :  (l.split("Respuestas:")[1]).split("\n")){
                        if (l1.split("\\)").length>1){
                            respuestas.add(l1.split("\\) ")[1]);
                            }                  
                    }
                    Pregunta pregunta1 = new Pregunta(pregunta, respuestas.get(0), respuestas.get(1), respuestas.get(2),respuestas.get(3),nivel);
                    preguntas.add(pregunta1);
                }           
            }       
        }
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
        if (nivel > materia.getNivel() || nivel<0){
            System.out.println("Nvel no registrado ");
            }
        else{
            preguntas.get(nivel-1).add(new Pregunta(enunciado, respuestas, nivel));
        System.out.println("¡PREGUNTA AÑADIDA CON EXITO!");
        materia.setTodosLosNivelesTienenPreguntas(true);
        }
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
    public static void eliminarParalelo(ArrayList<Paralelo>paralelos, Scanner sc){
        Iterator <Paralelo> it = paralelos.iterator();
        Paralelo peliminar = (Paralelo)seleccionarObjeto(paralelos , sc);
        boolean salir = false;
        while (it.hasNext() && !salir){
            Paralelo p1 = it.next();
            if (p1.equals(peliminar)){
                it.remove();
                salir = true;
            }
        }
    }
}