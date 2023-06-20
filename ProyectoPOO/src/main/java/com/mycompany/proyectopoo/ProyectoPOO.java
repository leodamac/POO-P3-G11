package com.mycompany.proyectopoo;
import java.util.Scanner;

public class ProyectoPOO {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello World!");
                       
        String opcion;
        boolean salir = false;
        do{
            //Sistema para preguntarle la opcion al usuario en el menú principal
            Menu.menuPrincipal();//muestra el menu principal
            System.out.print("Ingrese su opción: ");
            opcion = sc.nextLine();//pregunta la opcion al usuario
            System.out.println("");
            switch(opcion){
                // Opcion 1 Configuraciones
                case "1":
                    System.out.println("Opcion numero " + opcion);
                    do{
                        Menu.menuConfiguraciones();// muestra el menu de configuraciones
                        System.out.print("Ingrese su opción: ");
                        opcion = sc.nextLine();//pregunta la opcion al usuario
                        System.out.println("");
                        switch(opcion){
                            case "1":
                                System.out.println("Opcion numero " + opcion);
                            // Opcion 1.1 Administrar Terminos Academicos
                                do{
                                    Menu.menuAdministrarTerminosAcademicos();//muestra el menu
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
                            case "2":
                                System.out.println("Opcion numero " + opcion);
                            // Opcion 1.2 Administrar materias y paralelos
                                do{
                                    Menu.menuAdministrarMateriasParalelos();//muestra el menu
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
                                do{
                                    Menu.menuAdministrarPreguntas();//muestra el menu
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
        }
        while(!salir);
        sc.close();
    }
}
