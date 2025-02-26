package Proyecto_espacios.Util;

import DB.GestorConexion;
import Models.Reserva;

import java.io.EOFException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class UtilMain {
    private static final Scanner teclado = new Scanner(System.in);
    public static String anadirSala(){
        String [] datos = anadir();
        return Util_salas.anadirSalas(datos[0],datos[1]);
    }
    public static String anadirDepartamento(){
        String [] datos = anadir();
        return Util_departamentos.anadirDepartamentos(datos[0],datos[1]);
    }
    public static String [] anadir(){
        String [] datos = new String [2];
        System.out.println("Indica el código:");
        String codigo = teclado.nextLine();
        boolean valido=false;
        do {
            if (codigo.length()==3){
                valido=true;
            } else{
                System.out.println("El código debe de ser de 3 Caracteres");
                System.out.println("Indica el código:");
                codigo = teclado.nextLine();
            }
        }while (!valido);
        System.out.println("Indica el nombre:");
        String nombre = teclado.nextLine();
        datos[0]=codigo;
        datos[1]=nombre;
        return datos;
    }
    public static String eliminar(){
        System.out.println("Indica el código:");
        String codigo = teclado.nextLine();

        if (codigo.length()==3){
            return codigo;
        } else {
            System.out.println("El código debe de ser de 3 Caracteres");
            return null;
        }
    }
    public static String eliminarSala(){
        return Util_salas.eliminarSalas(UtilMain.eliminar());
    }
    public static String eliminarDepartamento(){
        return Util_departamentos.eliminarDepartamentos(UtilMain.eliminar());
    }
    public static String anadirReserva(String departamento){
        String codigo, sala, sMes, sDia, sMinuto, sHora, error = "", sHoraFin, sMinutoFin;
        LocalDateTime fechainicio, fechafin;
        int iMes, iDia, iMinuto, iHora;
        long lMinutoFin, lHoraFin;

        System.out.println("Indica la sala");
        sala = teclado.nextLine();

        //Validar la existencia de la sala
        if (existeSala(sala)){

            //Recoger los datos de la reserva
            try {
                System.out.println("Indica el código de la reserva:");
                codigo = teclado.nextLine();

                boolean salir;
                do {
                    System.out.println("Indica el mes de la reserva");
                    sMes = teclado.nextLine();
                    error = "mes";
                    iMes = Integer.parseInt(sMes);

                    if (!(iMes > 0 && iMes <= 12)){
                        System.out.println("Mes no válido");
                        salir=false;
                    } else salir = true;

                } while (!salir);

                switch (iMes) {
                    case 1, 3, 5, 7, 8, 10, 12 -> {
                        do {
                            System.out.println("Indica el día de la reserva");
                            sDia = teclado.nextLine();
                            error = "dia";
                            iDia = Integer.parseInt(sDia);

                            if (!(iDia > 0 && iDia <= 31)) {
                                System.out.println("Día no válido");
                                salir = false;
                            } else salir = true;

                        } while (!salir);
                    }
                    case 4, 6, 9, 11 -> {
                        do {
                            System.out.println("Indica el día de la reserva");
                            sDia = teclado.nextLine();
                            error = "dia";
                            iDia = Integer.parseInt(sDia);

                            if (!(iDia > 0 && iDia <= 30)) {
                                System.out.println("Día no válido");
                                salir = false;
                            } else salir = true;

                        } while (!salir);
                    }
                    case 2 -> {
                        do {
                            System.out.println("Indica el día de la reserva");
                            sDia = teclado.nextLine();
                            error = "dia";
                            iDia = Integer.parseInt(sDia);

                            if (!(iDia > 0 && iDia <= 28)) {
                                System.out.println("Día no válido");
                                salir = false;
                            } else salir = true;

                        } while (!salir);
                    }
                }

                //Recoger la hora de la reserva
                //Validación de la hora minima indicada en la clase Reserva
                boolean controlHora = false;

                do {
                    System.out.println("Indica la hora de la reserva");
                    sHora = teclado.nextLine();
                    error = "hora";
                    iHora = Integer.parseInt(sHora);

                    if (iHora > Reserva.getHORA_MIN())
                        controlHora = true;
                    else System.out.println("La reserva no debe ser anterior a las " + Reserva.getHORA_MIN() + " horas");

                } while (!controlHora);

                //Lectura de los minutos
                System.out.println("Indica los minutos de la reserva");
                sMinuto = teclado.nextLine();
                error = "minutos";
                iMinuto = Integer.parseInt(sMinuto);
                LocalDateTime actual = LocalDateTime.now();

                //Creación de la fecha de inicio de la reserva a partir de los datos introducidos y el año actual
                fechainicio = LocalDateTime.of(actual.getYear(), iMes, iDia = 1, iHora, iMinuto);

                //Recoger los datos de la fecha final de la reserva
                //Validación de la fecha de la reserva, no debe ser mayor de la indicada en la clase Reserva
                controlHora = false;
                do {
                    System.out.println("Indica la hora de final");
                    sHoraFin = teclado.nextLine();
                    lHoraFin = Long.parseLong(sHoraFin);
                    System.out.println("Indica los minutos");
                    sMinutoFin = teclado.nextLine();
                    lMinutoFin = Long.parseLong(sMinutoFin);

                    int sumaHoras = Math.abs(fechainicio.getHour()-(int)(lHoraFin));
                    int sumaMinutos = Math.abs(fechainicio.getMinute()-(int)(lMinutoFin));

                    fechafin = fechainicio. plusHours(sumaHoras).plusMinutes(sumaMinutos);

                    if (fechafin.getHour() < Reserva.getHORA_MAX())
                        controlHora = true;
                    else System.out.println("La reserva no debe sobrepasar las " + Reserva.getHORA_MAX() + " horas");

                } while (!controlHora);

            } catch (NumberFormatException nfe){
                //Validación de que el usuario ha introducido números
                if (error.equals("mes")||error.equals("dia")) return "Error al leer el " + error;
                else if (error.equals("minutos")) return "Error al leer los " + error;
                else return "Error al leer la " + error;
            }
            try {
                //AnadirReserva lanza EOFException en caso de que haya habido un fallo al introducir los datos de la nueva reserva en la base de datos
                return Util_reservas.anadirReserva(codigo, departamento, sala, fechainicio, fechafin);
            } catch (EOFException eofe){
                return "Error al añadir la reserva";
            }
        } else return "Sala no existente";



    }
    public static boolean existeDep(String departamento){
        Connection con = GestorConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        try {
            String sql = "SELECT CODIGO " +
                    "FROM DEPARTAMENTOS " +
                    "WHERE NOMBRE = ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1,departamento);
            rs = ps.executeQuery();

            return rs.next();

        }catch (SQLException | NullPointerException sqle){
            return false;
        }
    }
    public static boolean existeSala (String sala){
        Connection con = GestorConexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        try {
            String sql = "SELECT CODIGO " +
                    "FROM SALAS " +
                    "WHERE NOMBRE = ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1,sala);
            rs = ps.executeQuery();

            return rs.next();

        }catch (SQLException | NullPointerException sqle){
            return false;
        }
    }
    public static String eliminarReserva (){
        String codigo;
        System.out.println("Indica la clave de la reserva a eliminar:");
        codigo = teclado.nextLine();
        return Util_reservas.eliminarReserva(codigo);
    }
}