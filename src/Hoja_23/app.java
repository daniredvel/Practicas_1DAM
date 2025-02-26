package Hoja_23;

import java.util.Objects;
import java.util.Scanner;

public class app {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Equipos equipos=new Equipos();
            byte valor;
            boolean salida=false;
            int marcador = equipos.getMarcador();
            do {
                System.out.print("""
                    1) Añadir equipo
                    2) Añadir Jugador
                    3) Listado de equipos
                    4) Escribir jugadores
                    5) Salir
                    Escriba una opción
                    """);
                valor=in.nextByte();
                in.nextLine();

                if (valor==1){
                    boolean nombreEquipoValido = false;
                    String nombre_aux;
                   do {
                            System.out.println("Escribe el nombre del equipo");
                            nombre_aux = in.nextLine();

                            if (equipos.existe(nombre_aux)){
                                nombreEquipoValido=true;
                            } else System.out.println("""
                                Nombre no valido.
                                Escriba otro.
                                """);

                        } while (!nombreEquipoValido);
                    System.out.println("Escribe el nombre del presidente");
                    String nombrePresidente_Aux = in.nextLine();
                    System.out.println("Escribe el nombre de la localidad");
                    String nombreLocalidad_Aux = in.nextLine();
                    equipos.añadirEquipo(nombre_aux, nombrePresidente_Aux, nombreLocalidad_Aux);

                }else if (valor==2){
                    boolean nombreJugadorValido = false;
                    boolean nombreEquipoValido = false;

                    String nombreJugador_aux;
                    do {
                        //No comprueba si hay un nombre repetido
                    System.out.println("Escribe el nombre del jugador");
                    nombreJugador_aux = in.nextLine();

                    if (!equipos.jugadorExiste(nombreJugador_aux)){
                        nombreJugadorValido=true;
                    } else {
                        System.out.println("""
                                Nombre no valido.
                                Escriba otro.
                                """);
                    }

                } while (!nombreJugadorValido);
                    String nombre_aux;
                    do {
                        System.out.println("Escribe el nombre del equipo");
                        nombre_aux = in.nextLine();

                        if (!equipos.existe(nombre_aux)){
                            nombreEquipoValido=true;
                        } else System.out.println("""
                                Nombre no valido.
                                Escriba otro.
                                """);

                    } while (!nombreEquipoValido);

                    Jugador j = new Jugador(nombreJugador_aux);
                    int aux = equipos.buscarEquipo(nombre_aux);
                    equipos.getEquipos_comp()[aux].añadirJugador(j);

                } else if (valor==3) {
                    equipos.list();
                } else if (valor==4) {
                    equipos.escribir();
                } else if (valor == 5) {
                    salida=true;
                }
            }while (!salida);
            in.close();
        }
    }