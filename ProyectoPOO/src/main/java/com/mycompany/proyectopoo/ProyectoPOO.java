package com.mycompany.proyectopoo;

import java.util.Scanner;
import juego.Pregunta;
import juego.QuienQuiereSerMillonario;
import academico.TerminoAcademico;
import academico.Materia;
import academico.Paralelo;
import java.util.ArrayList;
import java.util.Collections;
import personas.Estudiante;
public class ProyectoPOO {

    public static void main(String[] args) {
        int i;// Se inicializa para ser usado como indice ejemplo 1. Asdfsdf, 2. Basdasd, donde i representaria 1 y 2
        Scanner sc = new Scanner(System.in); //Se inicializa scanner para pedirle datos al usuario
        String mensaje = "";//Se inicializa la variable para mostrarle mensajes al usuario
        TerminoAcademico terminoAcademico = null; // se inicializa un termino academico nulo para ser usado como termino academico por defecto y no crear varios termino
        Paralelo paralelo = null;//El paralelo que va a ser usado
        
        TerminoAcademico terminoAcademico1 = new TerminoAcademico(2023, 1);
        Menu.cargarDatosIniciales(terminoAcademico1);
        ArrayList<TerminoAcademico> terminosAcademicos = new ArrayList();
  
        terminosAcademicos.add(terminoAcademico1);//Agrega el termino Academico a la lista de terminos academicos

        System.out.println("Hello World!");

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
                                System.out.println("Opcion numero " + opcion);
                            // Opcion 1.1 Administrar Terminos Academicos
                                do{
                                    Menu.mostrarMenuAdministrarTerminosAcademicos();//muestra el menu
                                    //1.- Ingresar término
                                    //2.- Editar término
                                    //3.- Configurar término para el juego
                                    
                                    System.out.print("Ingrese su opción: ");
                                    opcion = sc.nextLine();//pregunta la opcion al usuario
                                    System.out.println("");
                                    
                                    switch(opcion){
                                        case "1":
                                            // 1.- Ingresar término
                                            System.out.println("Opcion numero " + opcion + " Ingresar Termino");
                                            
                                            System.out.print("Ingrese el año del termino: ");
                                            int año = Menu.pideNumero(sc);
                                            
                                            System.out.print("Ingrese el numero del termino: ");
                                            int termino = Menu.pideNumero(sc);
                                            
                                            terminoAcademico = new TerminoAcademico(año, termino);
                                            if(!terminosAcademicos.contains(terminoAcademico)){// Pregunta si el termino academico ya tiene ese termino añadido
                                                terminosAcademicos.add(terminoAcademico);
                                                mensaje = "¡Termino añadido con exito!";
                                            }else{
                                                mensaje = "Ese termnino ya ha sido ingresado";
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
                                            System.out.print("Ingrese el NUMERO del termino: ");
                                            termino = Menu.pideNumero(sc);

                                            if(terminosAcademicos.contains(new TerminoAcademico(año, termino))){
                                                mensaje = "ERROR ya hay un termino con esos datos";
                                            }
                                            else{
                                                terminoAcademico.setAño(año);
                                                terminoAcademico.setTermino(termino);
                                                mensaje = "Termino Academico Editado con éxito";
                                            }
                                            System.out.println("\n"+mensaje);
                                            
                                            System.out.println(terminoAcademico);
                                            System.out.print("Presione ENTER para continuar\n");
                                            
                                            
                                            sc.nextLine();
                                            break;
                                        case "3":
                                            // 3.- Configurar término para el juego
                                            terminoAcademico = Menu.seleccionarTerminoAcademico(terminosAcademicos, sc);
                                            Materia materia = (Materia)(Menu.seleccionarObjeto(terminoAcademico.getMaterias(), sc));
                                            paralelo = (Paralelo)(Menu.seleccionarObjeto(materia.getParalelos(), sc));
                                            
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
                                System.out.println("Opcion numero " + opcion);
                            // Opcion 1.2 Administrar materias y paralelos
                                do{
                                    Menu.mostrarmenuAdministrarMateriasParalelos();//muestra el menu
                                    System.out.print("Ingrese su opción: ");
                                    opcion = sc.nextLine();//pregunta la opcion al usuario
                                    System.out.println("");
                                    switch(opcion){
                                        case "1":
                                            System.out.println("Opcion numero " + opcion);
                                            break;
                                        case "2":
                                            System.out.println("Opcion numero " + opcion);
                                            break;
                                        case "3":
                                            System.out.println("Opcion numero " + opcion);
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
                                System.out.println("Opcion numero " + opcion);
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
                                    System.out.print("Escriba el digito del Termino Academico ");
                                    //pregunta el termino academico al usuario
                                    
                                    switch(opcion){
                                        case "1":
                                            terminoAcademico = Menu.seleccionarTerminoAcademico(terminosAcademicos, sc);
                                            System.out.print("Escriba el digito de la Materia ");
                                            //El usuario selecciona la materia para visualizar, editar o eliminar las preguntas
                                            // Muestra las preguntas de la materia selccionada
                                            Menu.visualizarPreguntas(((Materia)(Menu.seleccionarObjeto(terminoAcademico.getMaterias(), sc))).getPreguntas(), sc);
                                            break;
                                        case "2":
                                            terminoAcademico = Menu.seleccionarTerminoAcademico(terminosAcademicos, sc);
                                            System.out.print("Escriba el digito de la Materia ");
                                            //El usuario selecciona la materia para visualizar, editar o eliminar las preguntas
                                            // Agrega la pregunta ingresada por el usuario
                                            Menu.agregarPregunta(((Materia)(Menu.seleccionarObjeto(terminoAcademico.getMaterias(), sc))).getPreguntas(), sc);
                                            break;
                                        case "3":
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
                    
                    if (paralelo == null){
                        System.out.println("No ha elegido la Materia ni el término Académico");
                    } else{
                        Estudiante estudiante = (Estudiante) (Menu.seleccionarObjeto(paralelo.getEstudiantes(), sc));
                        QuienQuiereSerMillonario juego = new QuienQuiereSerMillonario(paralelo.getMateria().getPreguntas(), estudiante);
                        juego.iniciarJuego(sc);
                    }
                    break;
                case "3":
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

