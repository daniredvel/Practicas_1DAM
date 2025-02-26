package Hoja_15;

import java.util.Scanner;

public class H15E03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] meses = new int[12];
        int num;
        for (int i=0;i<12;i++){
            if(i==0||i==2||i==4||i==6||i==8||i==9||i==11){
                meses[i]=31;
            }else{
                meses[i]=30;
            }
            if (i==1){
                meses[i]=28;
            }
        }
        do {
            System.out.println("Escriba el mes");
            num=in.nextInt();
        }while (num>12||num<=0);
        System.out.println("El mes "+(num)+" tiene "+meses[(num-1)]+" dias");
        in.close();
    }
}
