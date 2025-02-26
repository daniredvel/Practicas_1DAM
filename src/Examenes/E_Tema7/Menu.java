package Examenes.E_Tema7;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Menu {
    String opcion;
    private TreeSet <Wifi> redes;
    public Menu(){
        redes= new TreeSet<Wifi>(new ComparadorWifi() {
        });
    }
    public void escribir(){


        boolean salir=false;
        Scanner in = new Scanner(System.in);
        do {
        System.out.print("""
                1. Añadir Wifi
                2. Mostrar Wifis
                3. Listar por canal
                4. Eliminar Wifi
                5. Cambiar de canal a una Wifi
                6. Añadir un usuario a una wifi
                7. Abandonar el programa
                """);

            this.opcion=in.nextLine();
            if (opcion.equals("1")){
                Wifi w= Wifi.crearWifi();
                if (Menu.buscarRed("Canal",w.getCanal(), redes)[0]==null||Menu.buscarRed("Canal",w.getCanal(), redes)[1]==null){
                    if(redes.add(w)){
                        System.out.println("Wifi añadido");
                    } else System.out.println("Wifi no añadido");
                } else System.out.println("Ya existen dos wifis en ese canal");

            }

            else if (opcion.equals("2")){
                for (Wifi w:redes) {
                    System.out.println(w.toString()+"\n");
                }
            }

            else if (opcion.equals("3")){
                System.out.println("Indica el canal");
                String canalLeido=in.nextLine();
                Wifi w1 = Menu.buscarRed("Canal", canalLeido, redes)[0];
                Wifi w2 = Menu.buscarRed("Canal", canalLeido, redes)[1];
                if (w1!=null) System.out.println(w1.toString());
                if (w2!=null) System.out.println(w2.toString());
                if (w1==null&&w2==null) System.out.println("No existen redes en este canal");
            }

            else if (opcion.equals("4")){
                if (redes.remove(Wifi.crearWifi())){
                    System.out.println("Wifi eliminado");
                } else System.out.println("Wifi no existente");
            }

            else if (opcion.equals("5")){
                System.out.println("Indica el SSID de la red donde quieras añadir al usuario");
                String SSID_buscado=in.nextLine();
                String nuevoCanal;
                Wifi w = Menu.buscarRed("SSID",SSID_buscado, redes)[0];
                if (w!=null){
                    System.out.println("Indica el nuevo canal");
                    nuevoCanal=in.nextLine();
                    if (Menu.buscarRed("Canal",nuevoCanal, redes)[0]==null&&Menu.buscarRed("Canal",nuevoCanal, redes)[1]==null){
                        w.setCanal(nuevoCanal);
                    } else System.out.println("Ya existen dos Wifis en ese canal");
                } else System.out.println("Wifi inexistente");
            }

            else if (opcion.equals("6")){
                System.out.println("Indica el SSID de la red donde quieras añadir al usuario");
                String SSID_buscado=in.nextLine();
                String user;
                if (Menu.buscarRed("SSID",SSID_buscado, redes)[0]!=null){
                    System.out.println("Nombre del usuario");
                    user=in.nextLine();
                    if(Menu.buscarRed("SSID", SSID_buscado, redes)[0].añadirUsuario(user)) System.out.println("Usuario añadido");
                    else System.out.println("Usuario no añadido");
                } else System.out.println("Red no encontrada");
            }

            else if (opcion.equals("7")){
                System.out.println("Hasta pronto");
                salir=true;
            }
             else System.out.println("Opción no valida");
        } while (!salir);
    }
    public static Wifi[] buscarRed(String valorBuscado, String valor, TreeSet<Wifi> lista){
        Wifi[] wifiEncontrado=new Wifi[2];
        if (valorBuscado.equals("SSID")){
            for (Wifi w: lista) {
                if (w.getSSID().equals(valor)) wifiEncontrado[0]=w;
            }
        } else if (valorBuscado.equals("Canal")){
            int cont=0;
            for (Wifi w: lista) {
                if (w.getCanal().equals(valor)){
                    wifiEncontrado[cont]=w;
                    cont++;
                    if (!(wifiEncontrado[0]==null || wifiEncontrado[1] == null)){
                        if (wifiEncontrado[0].getSSID().equals(wifiEncontrado[1].getSSID())) wifiEncontrado[1]=null;
                    }
                }
            }

        }

        return wifiEncontrado;
    }
}
