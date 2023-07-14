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

public class ProyectoPOO {
    public static void main(String[] args) {
        int YEAR = LocalDate.now().getYear();
        ArrayList<ArrayList<Pregunta>> preguntasJuego = null;
        Scanner sc = new Scanner(System.in); //Se inicializa scanner para pedirle datos al usuario
        String mensaje = "";//Se inicializa la variable para mostrarle mensajes al usuario
        TerminoAcademico terminoAcademico = new TerminoAcademico(2023, 1); // se inicializa un termino academico nulo para ser usado como termino academico por defecto y no crear varios termino
        Menu.cargarDatosIniciales(terminoAcademico);
        
        ArrayList<TerminoAcademico> terminosAcademicos = new ArrayList();
        terminosAcademicos.add(terminoAcademico);//Agrega el termino Academico a la lista de terminos academicos
        ArrayList<Reporte> reportes = new ArrayList();

        ////////////////////////////////////////////////////////
        

        String opcion;
        boolean salir = false;
        do{
            //Sistema para preguntarle la opcion al usuario en el menú principal
            Menu.mostrarMenuPrincipal();//muestra el menu principal
            System.out.print("Ingrese su opción: ");
            opcion = sc.nextLine();//pregunta la opcion al usuario
            System.out.println("");
            switch(opcion){
                // Opcion 1 Configuraciones
                case "1":
                    System.out.println("Opcion numero " + opcion);
                    do{
                        Menu.mostrarMenuConfiguraciones();// muestra el menu de configuraciones
                        System.out.print("Ingrese su opción: ");
                        opcion = sc.nextLine();//pregunta la opcion al usuario
                        System.out.println("");
                        switch(opcion){
                            case "1": 
                                
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
                                            break;
                                        case "2":
                                            // 2.- Editar término
                                            terminoAcademico = Menu.seleccionarTerminoAcademico(terminosAcademicos, sc);//Selecciona un termino academico de la lista de terminos academicos                             
                                            System.out.print("Ingrese el AÑO del termino: ");
                                            año = Menu.pideNumero(sc);

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
                                            break;
                                        case "3":
                                            // 3.- Configurar término para el juego
                                            terminoAcademico = Menu.seleccionarTerminoAcademico(terminosAcademicos, sc);
                                            System.out.println("Opcion numero " + opcion);
                                            break;
                                        case "4":
                                            System.out.println("Opcion numero " + opcion);
                                            salir = true;
                                            break;
                                        default:
                                            System.out.println("Opcion numero " + opcion);
                                            System.out.println("Ingrese SOLO los numeros de las opciones\n");
                                            break;
                                    }
                                        
                                }while(!salir);
                                salir = false;
                                break;
                            case "2":
                                
                            // Opcion 1.2 Administrar materias y paralelos
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
                                            System.out.println("Opcion numero " + opcion);
                                            System.out.println("Ingrese el codigo de la materia en MAYUSCULA:");
                                            String cod = sc.nextLine();
                                            System.out.println("Ingrese el nombre:");
                                            String mat = sc.nextLine();
                                            System.out.println("Ingrese la cantidad de niveles:");
                                            int levels = Menu.pideNumero(sc);
                                            Materia materia = new Materia(cod,mat,levels); //se crea la materia
                                            terminoAcademico.addMateria(materia); // se asigna al termino del paso 1.1.3 configurar para el juego                                          
                                            
                                            break;
                                        case "2": //Editar Materias
                                            System.out.println("Seleccione la materia a editar del listado: ");
                                            Materia m = (Materia)(Menu.seleccionarObjeto(terminoAcademico.getMaterias(), sc));                                            
                                            System.out.println("Actualizar nombre de materia a: ");
                                            String name = sc.nextLine(); 
                                            System.out.println("Actualizar niveles a: ");
                                            int newlevel = Menu.pideNumero(sc);
                                            m.setNombre(name);
                                            m.setNivel(newlevel);
                                            break; 
                                            
                                        case "3":
                                            System.out.println("Seleccione la materia:");
                                            Materia mselec = (Materia)(Menu.seleccionarObjeto(terminoAcademico.getMaterias(), sc));
                                            System.out.println("Ingrese el paralelo:");
                                            int course = Menu.pideNumero(sc);
                                            Paralelo p = new Paralelo(mselec, course, "url");
                                            mselec.addParalelo(p); 
                                            
                                            break;
                                            
                                        case "4":
                                            System.out.println("Opcion numero " + opcion);
                                            break;
                                        case "5":
                                            System.out.println("Opcion numero " + opcion);
                                            salir = true;
                                            break;
                                        default:
                                            System.out.println("Opcion numero " + opcion);
                                            System.out.println("Ingrese SOLO los numeros de las opciones\n");
                                            break;
                                    }
                                }while(!salir);
                                salir = false;
                                break;
                            case "3":
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
                                            System.out.println("Opcion numero " + opcion);
                                            salir = true;
                                            break;
                                        default:
                                            System.out.println("Opcion numero " + opcion);
                                            System.out.println("Ingrese SOLO los numeros de las opciones\n");
                                            break;
                                    }
                                }while(!salir);
                                salir = false;
                                break;
                            case "4":
                                System.out.println("Ha salido");
                                salir = true;
                                break;
                            default:
                                System.out.println("Opcion numero " + opcion);
                                System.out.println("Ingrese SOLO los numeros de las opciones\n");
                                break;
                        }
                      }
                    while(!salir);
                    salir = false;
                    break;
                case "2":
                    // Nuevo juego
                        
                    if (terminoAcademico == null){
                        System.out.println("No ha elegido la Materia ni el término Académico");
                    } else{
                        LocalDate fecha = LocalDate.now();
                        
                        Materia m = (Materia)(Menu.seleccionarObjeto(terminoAcademico.getMaterias(), sc));
                        preguntasJuego = m.getPreguntas();
                        Paralelo paralelo = (Paralelo)(Menu.seleccionarObjeto(m.getParalelos(), sc));
                        if (paralelo != null){
                            if(!paralelo.getEstudiantes().isEmpty()){
                                if(m.getTodosLosNivelesTienenPreguntas()){
                                    QuienQuiereSerMillonario juego = new QuienQuiereSerMillonario(preguntasJuego, (Estudiante)Menu.seleccionarObjeto(paralelo.getEstudiantes(), sc));
                                    juego.iniciarJuego(sc);
                                    //public Reporte(String fecha , Estudiante participante, int level, int tiempo, int preguntasContestadas, boolean[] comodines, int premio)
                                    Reporte reporte = new Reporte(fecha.toString(),juego.getEstudiante(),juego.getNivelMax(),60,juego.getNivelMax(), juego.getComodines(),juego.getGanancias());
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
                    System.out.println(mensaje);
                    }
                    break; 
                case "3":
                    for(Reporte r: reportes){
                        System.out.println(r);
                    }
                    
                    
                    // Reporte
                    /*Opción 3: Reporte
                    En esta opción se podrá visualizar los juegos realizados ordenados por fecha.
                    Se solicitará el término académico, código de materia y paralelo
                    La información a mostrar será
                    Fecha del juego Participante Nivel máximo alcanzado Tiempo Premio*/
                    System.out.println("Opcion numero " + opcion);
                    break;
                case "4":
                    // Salir
                    System.out.println("Ha salido :)");
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion numero " + opcion);
                    System.out.println("Ingrese SOLO los numeros de las opciones\n");
                    break;
            }
            //System.out.print("Presione ENTER para continuar\n");
            //sc.nextLine();
        }
        while(!salir);
        sc.close();

    }
}

