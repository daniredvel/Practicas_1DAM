package Hoja_1;

public class H01E03 {
    public static void main(String[] args) {
     char letra = 'Ñ';
     int ltrAnt = letra - 1;
     int ltrPost = letra + 1;
     //Restar y sumar al codigo Unicode de la variable letra para obtener el simbolo anterior y posterior
     char Anterior = (char) ltrAnt;
     char Posterior= (char) ltrPost; 
     //Convertir a letras los codigos unicodes con un casting
     System.out.println("El simbolo anterior es " + Anterior + " y el posterior es " + Posterior);
    }
}
