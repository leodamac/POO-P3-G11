package com.mycompany.proyectopoo;

import java.time.*;
import java.util.Scanner;
import juego.Pregunta;
import juego.Reporte;
import juego.QuienQuiereSerMillonario;
import academico.TerminoAcademico;
import academico.Materia;
import academico.Paralelo;
import java.util.ArrayList;
import personas.Estudiante;
import java.util.Collections;

public class ProyectoPOO {
    private final int YEAR = LocalDate.now().getYear();
    ArrayList<ArrayList<Pregunta>> preguntasJuego;
    private String mensaje = ""; //Se inicializa la variable para mostrarle mensajes al usuario
    TerminoAcademico terminoAcademico;
    ArrayList<TerminoAcademico> terminosAcademicos;
    ArrayList<Reporte> reportes;
    boolean salir;
    String opcion;
    
    public void iniciar() {
        Scanner sc = new Scanner(System.in); //Se inicializa scanner para pedirle datos al usuario
        terminoAcademico = null; // se inicializa un termino academico nulo para ser usado como termino academico por defecto y no crear varios termino

        terminosAcademicos = new ArrayList();
        Menu.cargarTerminosAcademicos(terminosAcademicos);
        
        System.out.println("*Bienvenidos a sistema de apoyo docente*");
        System.out.println("*Seleccione el termino academico para iniciar el Sistema*");
        terminoAcademico = (TerminoAcademico) Menu.seleccionarObjeto(terminosAcademicos, sc);
        Menu.cargarDatosIniciales(terminoAcademico);
        reportes = new ArrayList();
        ////////////////////////////////////////////////////////
        salir = false;
        
        do{
            //Sistema para preguntarle la opcion al usuario en el menú principal
            Menu.mostrarMenuPrincipal();//muestra el menu principal
            System.out.print("Ingrese su opción: ");
            opcion = sc.nextLine();//pregunta la opcion al usuario
            System.out.println("");
            switch(opcion){
                // Opcion 1 Configuraciones
                case "1":
                    configuraciones(sc);
                    break;
                case "2":
                    // Nuevo juego
                    nuevoJuego(sc);
                    break; 
                case "3":
                    // Reporte
                    /*Opción 3: Reporte
                    En esta opción se podrá visualizar los juegos realizados ordenados por fecha.
                    Se solicitará el término académico, código de materia y paralelo
                    La información a mostrar será
                    Fecha del juego Participante Nivel máximo alcanzado Tiempo Premio*/
                    reporte(sc);
                    break;
                case "4":
                    // Salir
                    salir();
                    break;
                default:
                    mensajeError();
                    break;
            }
            //System.out.print("Presione ENTER para continuar\n");
            //sc.nextLine();
        }
        while(!salir);
        sc.close();

    }
    
    private void configuraciones(Scanner sc){
        do{
            Menu.mostrarMenuConfiguraciones();// muestra el menu de configuraciones
            System.out.print("Ingrese su opción: ");
            opcion = sc.nextLine();//pregunta la opcion al usuario
            System.out.println("");
            switch(opcion){
                case "1":
                    // Opcion 1.1 Administrar Terminos Academicos
                    administrarTerminosAcademicos(sc);
                    break;
                case "2":
                // Opcion 1.2 Administrar materias y paralelos
                    administrarMateriasParalelos(sc);
                    break;
                case "3":
                    // Opcion 1.3 Administrar preguntas - Menu de administrar preguntas
                    administrarPreguntas(sc);
                    break;
                case "4":
                    salir();
                    break;
                default:
                    mensajeError();
                    break;
            }
          }
        while(!salir);
        salir = false; 
    }
    
    public void administrarTerminosAcademicos(Scanner sc){
        // Opcion 1.1 Administrar Terminos Academicos
        do{
            System.out.println("Terminos Académicos Registrados:");
            for(TerminoAcademico t: terminosAcademicos){
               System.out.println(t);
            }
            Menu.mostrarMenuAdministrarTerminosAcademicos();//muestra el menu
            //1.- Ingresar término
            //2.- Editar término
            //3.- Configurar término para el juego

            System.out.print("Ingrese su opción: ");
            opcion = sc.nextLine();//pregunta la opcion al usuario
            //System.out.println("");

            switch(opcion){
                case "1":
                    // 1.- Ingresar término
                    ingresarTermino(sc);
                    break;
                case "2":
                    editarTermino(sc);
                    break;
                case "3":
                    // 3.- Configurar término para el juego
                    terminoAcademico = Menu.seleccionarTerminoAcademico(terminosAcademicos, sc);
                    System.out.println("Opcion numero " + opcion);
                    break;
                case "4":
                    salir();
                    break;
                default:
                    mensajeError();
                    break;
            }

        }while(!salir);
        salir = false;
    }
    
    private void ingresarTermino(Scanner sc){
        // 1.- Ingresar término
        //System.out.println("Opcion numero " + opcion + " Ingresar Termino");
        System.out.print("Ingrese el año del termino: ");

        int año = Menu.pideNumero(sc);

        if(año >= YEAR){
            System.out.print("Ingrese el numero del termino: ");
            int termino = Menu.pideNumero(sc);

            TerminoAcademico tA = new TerminoAcademico(año, termino);
            if(!terminosAcademicos.contains(tA)){// Pregunta si el termino academico ya tiene ese termino añadido
                terminosAcademicos.add(tA);
                mensaje = "¡Termino añadido con exito!";
            }else{
                mensaje = "Ese termnino ya ha sido ingresado";
            }
        }else{
            mensaje = "El año tiene que ser MAYOR al año actual";
        }
        System.out.println(mensaje);
        System.out.print("Presione ENTER para continuar\n");
        sc.nextLine();
    }
    
    private void editarTermino(Scanner sc){
        // 2.- Editar término
        terminoAcademico = Menu.seleccionarTerminoAcademico(terminosAcademicos, sc);//Selecciona un termino academico de la lista de terminos academicos                             
        System.out.print("Ingrese el AÑO del termino: ");
        int año = Menu.pideNumero(sc);

        if(año >= YEAR){
            System.out.print("Ingrese el NUMERO del termino: ");
            int termino = Menu.pideNumero(sc);

            if(terminosAcademicos.contains(new TerminoAcademico(año, termino))){
                mensaje = "ERROR ya hay un termino con esos datos";
            }
            else{
                terminoAcademico.setAño(año);
                terminoAcademico.setTermino(termino);
                mensaje = "Termino Academico Editado con éxito";
            }


            System.out.println(terminoAcademico);}
        else{
            mensaje = "El año tiene que ser MAYOR al año actual";
        }
        System.out.println("\n"+mensaje);
        System.out.print("Presione ENTER para continuar\n");
        sc.nextLine();
    }
    
    private void administrarMateriasParalelos(Scanner sc){
        do{
            System.out.println("Materias y paralelos registrados:");
            for(TerminoAcademico t: terminosAcademicos){
                if (t.equals(terminoAcademico)){
                    int indice = 0;
                    for(Object o: t.getMaterias()){ //Listado de materias 
                        System.out.println(indice+1 + ". " + o);
                        indice++;
                        }
                } //INICIA el programa con el termino selecionado en paso 1.1.3 configurar para el juego.
            }

            Menu.mostrarmenuAdministrarMateriasParalelos();//muestra el menu
            System.out.print("Ingrese su opción: ");
            opcion = sc.nextLine();//pregunta la opcion al usuario
            System.out.println("");
            switch(opcion){
                case "1": //Ingresar materia
                    ingresarMateria(sc);                                      
                    break;
                case "2": //Editar Materias
                    editarMateria(sc);
                    break; 
                case "3": //Crear paralelo
                    crearParalelo(sc);
                    break;
                case "4": //Eliminar paralelo
                    eliminarParalelo(sc);
                    break;
                case "5":
                    salir();
                    break;
                default:
                    mensajeError();
                    break;
            }
        }while(!salir);
        salir = false;
    }
    
    private void ingresarMateria(Scanner sc){
        System.out.println("Opcion numero " + opcion);
        System.out.println("Ingrese el codigo de la materia en MAYUSCULA:");
        String cod = sc.nextLine();
        System.out.println("Ingrese el nombre:");
        String mat = sc.nextLine();
        System.out.println("Ingrese la cantidad de niveles:");
        int levels = Menu.pideNumero(sc);
        Materia materia = new Materia(cod,mat,levels); //se crea la materia
        terminoAcademico.addMateria(materia); // se asigna al termino del paso 1.1.3 configurar para el juego
    }
    
    private void editarMateria(Scanner sc){
        System.out.println("Seleccione la materia a editar del listado: ");
        Materia m = (Materia)(Menu.seleccionarObjeto(terminoAcademico.getMaterias(), sc));                                            
        System.out.println("Actualizar nombre de materia a: ");
        String name = sc.nextLine(); 
        System.out.println("Actualizar niveles a: ");
        int newlevel = Menu.pideNumero(sc);
        m.setNombre(name);
        m.setNivel(newlevel);
    }
    
    private void crearParalelo(Scanner sc){
        System.out.println("Seleccione la materia:");
        Materia mselec = (Materia)(Menu.seleccionarObjeto(terminoAcademico.getMaterias(), sc));
        System.out.println("Ingrese el paralelo:");
        int course = Menu.pideNumero(sc);
        System.out.println("Ingrese la direccion del archivo de estudiantes: ");
        String url = sc.nextLine();
        Paralelo p = new Paralelo(mselec, course, url);
        mselec.addParalelo(p); 
        p.addEstudiante(new Estudiante("Estudiante1", "202013456"));
        p.addEstudiante(new Estudiante("Estudiante2", "201513454"));
    }
    
    private void eliminarParalelo(Scanner sc){
        System.out.println("Seleccione la materia:");
        Materia selecmat = (Materia)(Menu.seleccionarObjeto(terminoAcademico.getMaterias(), sc));
        System.out.println("Ingrese paralelo a eliminar");                                         
        Menu.eliminarParalelo(selecmat.getParalelos(), sc);
    }
    
    private void administrarPreguntas(Scanner sc){
        System.out.println("Seleccione la materia:");
        Materia mselec = (Materia)(Menu.seleccionarObjeto(terminoAcademico.getMaterias(), sc));
        preguntasJuego = mselec.getPreguntas();
        // Opcion 1.3 Administrar preguntas - Menu de administrar preguntas
        //**************************
        //* 1. Visualizar preguntas *
        //* 2. Agregar pregunta     *
        //* 3. Eliminar pregunta    *
        //* 4. Salir                *
        //***************************
        do{
            Menu.mostrarmenuAdministrarPreguntas();//muestra el menu
            System.out.print("Ingrese su opción: ");
            opcion = sc.nextLine();//pregunta la opcion al usuario
            System.out.println("");
            switch(opcion){
                case "1":
                    Menu.visualizarPreguntas(preguntasJuego, sc);
                    break;
                case "2":
                    Menu.agregarPregunta(mselec, preguntasJuego, sc);
                    break;
                case "3":
                    Menu.eliminarPregunta(mselec, preguntasJuego, sc);
                    break;
                case "4":
                    salir();
                    break;
                default:
                    mensajeError();
                    break;
            }
        }while(!salir);
        salir = false;
    }
    
    private void nuevoJuego(Scanner sc){
        if (terminoAcademico == null){
            System.out.println("No ha elegido la Materia ni el término Académico");
        } else{
            LocalDate fecha = LocalDate.now();
            mensaje="";
            System.out.println("Selecciones la MATERIA:");
            Materia m = (Materia)(Menu.seleccionarObjeto(terminoAcademico.getMaterias(), sc));      
            if (m != null){
                preguntasJuego = m.getPreguntas();
                System.out.println("Selecciones el PARALELO:");
                Paralelo paralelo = (Paralelo)(Menu.seleccionarObjeto(m.getParalelos(), sc));
            if (paralelo != null){
                System.out.println("Selecciones compañero de apoyo:");
                Estudiante apoyo = (Estudiante)Menu.seleccionarObjeto(paralelo.getEstudiantes(), sc);
                if(!paralelo.getEstudiantes().isEmpty()){
                    if(m.getTodosLosNivelesTienenPreguntas()){

                        QuienQuiereSerMillonario juego = new QuienQuiereSerMillonario(preguntasJuego, (Estudiante)Menu.seleccionarObjeto(paralelo.getEstudiantes(), sc));
                        juego.iniciarJuego(sc);
                        //public Reporte(String fecha , Estudiante participante, int level, int tiempo, int preguntasContestadas, boolean[] comodines, int premio)
                        String premio = "No hay premio ñaño";
                        if(juego.getNivelMax()==m.getNivel()+1){
                            System.out.println("Ingrese el premio: ");
                            premio = sc.nextLine();                                        
                        }

                        Reporte reporte = new Reporte(fecha.toString(),juego.getEstudiante(),juego.getNivelMax(),60,juego.getNivelMax()-1, juego.getComodines(),premio,terminoAcademico ,m.getCodigo(), paralelo);
                        reportes.add(reporte);                                                                                            
                    }else{
                        mensaje = "No hay suficiente PREGUNTAS registradas en esa materia";
                    }
                }else{
                    mensaje = "No hay ESTUDIANTES registrados en ese paralelo";
                }
            }else{
                mensaje = "No hay PARALELOS registrados en esa materia";
            }
            }
            else{mensaje = "No hay materia";} 
        System.out.println(mensaje);
        }
    }
    
    private void reporte(Scanner sc){
        TerminoAcademico termino1 = Menu.seleccionarTerminoAcademico(terminosAcademicos, sc);
        Materia m = (Materia)(Menu.seleccionarObjeto(termino1.getMaterias(), sc));
        String mcod = m.getCodigo();
        Paralelo paralelo = (Paralelo)(Menu.seleccionarObjeto(m.getParalelos(), sc));
        Collections.sort(reportes);
        for(Reporte r: reportes){
            if (r.getParalelo().equals(paralelo) && r.getMateria().equals(m.getCodigo()) && termino1.equals(r.getTerminoAcademico()) ){      
                System.out.println(r);
            }
        }
    }
    
    private void salir(){
        System.out.println("Ha salido :)");
        salir = true;
    }
    
    private void mensajeError(){
        System.out.println("Opcion numero " + opcion);
        System.out.println("Ingrese SOLO los numeros de las opciones\n");
    }
}