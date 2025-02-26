package Hoja_17;

import java.util.Scanner;
import java.util.Arrays;

public class H17E07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nif, nif_may, nif_num;
        boolean valido;
        int num=0,resto;
        String [] nif_final = new String[3];
        String [] letras = new String[23];
        letras[0]="T";
        letras[1]="R";
        letras[2]="W";
        letras[3]="A";
        letras[4]="G";
        letras[5]="M";
        letras[6]="Y";
        letras[7]="F";
        letras[8]="P";
        letras[9]="D";
        letras[10]="X";
        letras[11]="B";
        letras[12]="N";
        letras[13]="J";
        letras[14]="Z";
        letras[15]="S";
        letras[16]="Q";
        letras[17]="V";
        letras[18]="H";
        letras[19]="L";
        letras[20]="C";
        letras[21]="K";
        letras[22]="E";

        System.out.println("Escriba el nif:");
        nif=in.nextLine();
        nif_may=nif.toUpperCase();

        if ((nif_may.charAt(0)>'0'&&nif.charAt(0)<='9')||nif_may.charAt(0)=='X'||nif_may.charAt(0)=='Y'||nif_may.charAt(0)=='Z') valido=true;
        else valido=false;

        if (nif_may.length()==9)valido=true;
        else valido=false;

        int [] numero = new int[8];
        if (nif_may.charAt(0)=='X')numero[0]='0';
        else if (nif_may.charAt(0)=='Y')numero[0]='1';
        else if (nif_may.charAt(0)=='Z')numero[0]='2';

        for (int i = 1; i < nif.length(); i++) {
            numero[i]=nif.charAt(i);
        }

        //System.out.println("numero"+Arrays.toString(numero));


        for (int inicio = 0 ; inicio < 8; inicio++) {
            int n=0;
                 n = (int) ((numero[inicio] - '0') * Math.pow(10,(7 - inicio)));
            //System.out.println(n);
            num += n;
        }

        resto=num%23;

        //System.out.println("num:"+num);
        System.out.println("resto:"+resto);


        int a =num - ((num/(10*10*10*10*10*10*10))*(10*10*10*10*10*10*10));
        //System.out.println(a);

        int b=num/(10*10*10*10*10*10*10);
        if (b==0) nif_final[0]="X";
        else if (b==1) nif_final[0]="Y";
        else if (b==2) nif_final[0]="Z";

        nif_final[1]=String.valueOf(a);

        nif_final[2]=letras[resto];

        /*
        for (int i = 0; i < 3; i++) {
            System.out.print(nif_final[i]);
        }
         */

        if (nif_final[2].charAt(0)>='A'&&nif_final[2].charAt(0)>='Z')valido=true;
        else valido=false;

        System.out.print("El nif: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(nif_final[i]);
        }
        System.out.print(" es valido");

        in.close();
    }
}