package Hoja_31.hoja31.ej1.version2Clases;

import hoja31.ej1.Clases.Movimiento;

import java.io.*;

public class MovimientosV2 {
private long nMovimientos;
    public MovimientosV2(){
        this.nMovimientos=0;
    }
    public boolean añadirMovimiento(String nombre, double cantidad, File archivo){
        Movimiento m=new Movimiento(nombre, cantidad, nMovimientos++);

        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(archivo));
            //EscribirObjeto file = new EscribirObjeto(new FileOutputStream(archivo));
            //El true evita que el contenido del fichero se pierda

            file.writeObject(m);
            System.out.println(m);
            file.close();
            return true;
        } catch (IOException fnfe){
            System.out.println(fnfe.getMessage());
            return false;
        }

    }
    public String listarMovimientoNumero(long n, File archivo){
        String res="";

        Movimiento m;
        try {
            ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(archivo));
            try {
                while (true) {
                    m = (Movimiento) lectura.readObject();
                    if (m.getId()==n){
                        res = "hoja31.ej1.Clases.Movimiento nº: " + n + ", nombre: " + m.getNombre() + ", cantidad: " + m.getCantidad();
                    } else res = "hoja31.ej1.Clases.Movimiento no encontrado";
                }
            } catch (EOFException eofe){
                lectura.close();
                return res;
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
            return "io"+ioe.getCause()+" ||| "+ioe.getMessage();
        } catch (ClassNotFoundException cnfe){
            return"class";
        }
    }
    public String listarMovimientoNombre(String nombre, File archivo){
        String res="";

        Movimiento m;
        try {
            ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(archivo));
            try {
                while (true) {
                    m = (Movimiento) lectura.readObject();
                    if (m.getNombre().equalsIgnoreCase(nombre)){
                        res = "hoja31.ej1.Clases.Movimiento nº: " + m.getId() + ", nombre: " + m.getNombre() + ", cantidad: " + m.getCantidad();
                    } else res = "hoja31.ej1.Clases.Movimiento no encontrado";
                }
            } catch (EOFException eofe){
                return res;
            }
        }  catch (IOException ioe){
            //return "io"+ioe.getCause()+" "+ioe.getMessage();
            ioe.printStackTrace();
            return "io"+ioe.getCause()+" "+ioe.getMessage();
        } catch (ClassNotFoundException cnfe){
            return"class";
        }
        /*catch (IOException | ClassNotFoundException ioe){
            return "";
            */
        }
    }


