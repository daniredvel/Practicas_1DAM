package Examenes.E_Tema8b.src;

import java.io.*;
public class UtilPuntos {
    public static Punto distancia(Punto p, File fichero){
        double dis = Double.MAX_VALUE, dis2;
        Punto res=null;

          try {
              ObjectInputStream in = new ObjectInputStream(new FileInputStream(fichero));
              Punto p2;
              try{
                  while (true){
                      p2=(Punto) (in.readObject());
                      dis2=Math.sqrt(Math.pow(p.getX()-p2.getX(),2)+Math.pow(p.getY()-p2.getY(),2));
                      if (dis>dis2){
                          dis=dis2;
                          res = p2;
                      }
                  }
              } catch (EOFException eofe){}
          } catch (IOException | ClassNotFoundException fnfe){
              fnfe.printStackTrace();
              System.out.println("Error al leer el fichero");
          }
          return res;
    }
}
