package com.mycompany.proyectopoo;

import java.util.Scanner;
import juego.Pregunta;
import academico.TerminoAcademico;
import java.util.ArrayList;
import java.util.Collections;

public class ProyectoPOO {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); //Se inicializa scanner para pedirle datos al usuario
        String mensaje = "";//Se inicializa la variable para mostrarle mensajes al usuario
        System.out.println("Hello World!");
        TerminoAcademico terminoAcademico = null; // se inicializa un termino academico nulo para ser usado como termino academico por defecto y no crear varios termino
        TerminoAcademico terminoAcademico1 = new TerminoAcademico(2023, 1);
        TerminoAcademico terminoAcademico2 = new TerminoAcademico(2023, 2);
        TerminoAcademico terminoAcademico3 = new TerminoAcademico(2022, 2);
        TerminoAcademico terminoAcademico4 = new TerminoAcademico(2023, 3);
        System.out.println(terminoAcademico1);
        System.out.println(terminoAcademico2);
        System.out.println(terminoAcademico3);
        ArrayList<TerminoAcademico> terminosAcademicos = new ArrayList();
        terminosAcademicos.add(terminoAcademico4);
        terminosAcademicos.add(terminoAcademico1);
        terminosAcademicos.add(terminoAcademico3);
        terminosAcademicos.add(terminoAcademico2);
        System.out.println(terminosAcademicos);
        Collections.sort(terminosAcademicos);
        System.out.println(terminosAcademicos);
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
                                    /*1.- Ingresar término
                                      2.- Editar término
                                      3.- Configurar término para el juego
                                    */
                                    System.out.print("Ingrese su opción: ");
                                    opcion = sc.nextLine();//pregunta la opcion al usuario
                                    System.out.println("");
                                    
                                    switch(opcion){
                                        case "1":
                                            // 1.- Ingresar término
                                            System.out.println("Opcion numero " + opcion + " Ingresar Termino");
                                            
                                            System.out.print("Ingrese el año del termino: ");
                                            int año = sc.nextInt();
                                            
                                            System.out.print("Ingrese el numero del termino: ");
                                            int termino = sc.nextInt();
                                            
                                            sc.nextLine();// se hace para evitar conflicto con el siguiente sc.next
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
                                            int indice = 0;
                                            Collections.sort(terminosAcademicos);//se ordenan los terminos academicos de menor a mayor
                                            for(TerminoAcademico t: terminosAcademicos){
                                                System.out.println(indice+1 + ". " + t);
                                                indice++;
                                            }
                                            
                                            System.out.print("Ingrese el INDICE del termino para editar: ");
                                            int op = sc.nextInt();
                                            terminoAcademico = null;// se pone como null para preguntar mas adelante si el usuario puso un numero valido de termino
                                            sc.nextLine();
                                            if(op-1<indice && op-1>=0){
                                                terminoAcademico = terminosAcademicos.get(op-1);
                                            }
                                            if (terminoAcademico == null){
                                                System.out.println("Indice incorrecto");
                                            }else{
                                                System.out.print("Ingrese el AÑO del termino: ");
                                                año = sc.nextInt();
                                                System.out.print("Ingrese el NUMERO del termino: ");
                                                termino = sc.nextInt();
                                                sc.nextLine();
                                                if(terminosAcademicos.contains(new TerminoAcademico(año, termino))){
                                                    mensaje = "ERROR ya hay un termino con esos datos";
                                                }
                                                else{
                                                    terminoAcademico.setAño(año);
                                                    terminoAcademico.setTermino(termino);
                                                    mensaje = "Termino Academico Editado con éxito";
                                                }
                                                System.out.println("\n"+mensaje);
                                            }
                                            System.out.println(terminoAcademico);
                                            System.out.print("Presione ENTER para continuar\n");
                                            
                                            
                                            sc.nextLine();
                                            break;
                                        case "3":
                                            // 3.- Configurar término para el juego
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
                                do{
                                    Menu.mostrarmenuAdministrarPreguntas();//muestra el menu
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
                                System.out.println("Opcion numero " + opcion);
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
                    System.out.println("Opcion numero " + opcion);
                    Pregunta pregunta = new Pregunta("¿Pregunta?", "Aaasda Adasdasd", "Basdasd", "Casdasdasd", "Dasdasdasdasd asdasdasdas asas asdasdasdasd asdasdasda", 1);
                    Menu.mostrarPregunta(pregunta);
                    break;
                case "3":
                    // Reporte
                    System.out.println("Opcion numero " + opcion);
                    break;
                case "4":
                    // Salir
                    System.out.println("Opcion numero " + opcion);
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion numero " + opcion);
                    System.out.println("Ingrese SOLO los numeros de las opciones\n");
                    break;
            }
        }
        while(!salir);
        sc.close();

    }
}
