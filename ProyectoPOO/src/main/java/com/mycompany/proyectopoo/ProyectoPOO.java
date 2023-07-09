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
        ArrayList<Pregunta> preguntasJuego = null;
        int i;
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        ArrayList estudiantes = null;
        
        // La primera pregunta añadida es la correcta
        preguntas.add(new Pregunta("¿Pregunta 1?", "1","2",  "3", "4", 1));
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
        

        Scanner sc = new Scanner(System.in); //Se inicializa scanner para pedirle datos al usuario
        String mensaje = "";//Se inicializa la variable para mostrarle mensajes al usuario
        TerminoAcademico terminoAcademico = null; // se inicializa un termino academico nulo para ser usado como termino academico por defecto y no crear varios termino
        Materia materia = null;
        
        
        TerminoAcademico terminoAcademico1 = new TerminoAcademico(2023, 1);
        ArrayList<TerminoAcademico> terminosAcademicos = new ArrayList();
        System.out.println(terminoAcademico1);
        materia = new Materia("CCPG1043", "Programación Orientada a Objetos");
        Paralelo paralelo = new Paralelo(materia, 3, "url");
        Estudiante[] listaDeEstudiantes = {new Estudiante("Estudiante 1", "0001"), new Estudiante("Estudiante 2", "0002")};
        paralelo.addEstudiantes(listaDeEstudiantes);//Agrega los estudiantes al paralelo
        
        materia.addParalelo(paralelo);//Agrega el paralelo a la materia
        materia.addPreguntas(preguntas);//Agrega las preguntas a la materia
        terminoAcademico1.addMateria(materia);//Agrega la materia al termino Academico
        terminosAcademicos.add(terminoAcademico1);//Agrega el termino Academico a la lista de terminos academicos

        System.out.println("Hello World!");
        for(TerminoAcademico t: terminosAcademicos){
            System.out.println(t.getMaterias());
        }
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
                                            Materia m = (Materia)(Menu.seleccionarObjeto(terminoAcademico.getMaterias(), sc));
                                            preguntasJuego = m.getPreguntas();
                                            paralelo = (Paralelo)(Menu.seleccionarObjeto(m.getParalelos(), sc));
                                            
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
                                    switch(opcion){
                                        case "1":
                                            i = 1;
                                            for (Pregunta p: preguntas){
                                                System.out.print("Presione ENTER para ver la pregunta nº" + i);
                                                sc.nextLine();
                                                System.out.println(p);
                                                
                                                i++;
                                            }
                                            break;
                                        case "2":
                                            System.out.println("Ingrese el enunciado de la pregunta: ");
                                            String enunciado = sc.nextLine();
                                            String[] respuestas = new String[4];
                                            for(i=0; i<4;i++){
                                                if(i==0){
                                                    System.out.println("Ingrese la RESPUESTA CORRECTA: ");
                                                }
                                                else{
                                                    System.out.println("Ingrese la RESPUESTA INCORRECTA: ");}
                                                respuestas[i] = sc.nextLine();
                                            }
                                            System.out.println("Ingrese el NIVEL de la pregunta: ");
                                            int nivel = Menu.pideNumero(sc);
                                            preguntas.add(new Pregunta(enunciado, respuestas, nivel));
                                            System.out.println("¡PREGUNTA AÑADIDA CON EXITO!");
                                            sc.nextLine();
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
                    
                    if (preguntasJuego == null){
                        System.out.println("No ha elegido la Materia ni el término Académico");
                    } else{
                        Menu.seleccionarObjeto(paralelo.getEstudiantes(), sc);
                        QuienQuiereSerMillonario juego = new QuienQuiereSerMillonario(preguntasJuego);
                        juego.iniciarJuego();
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

