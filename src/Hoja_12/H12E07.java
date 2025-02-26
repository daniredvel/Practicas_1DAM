package Hoja_12;

import java.util.Scanner;

public class H12E07 {
    public static void main(String[] args) {
Scanner in = new Scanner(System.in);
int i=1,num,mayor,menor,total,media;
System.out.println("Escribe numeros, escribe un 0 para marcar el final");
        System.out.println("Escribe un número:");
        num= in.nextInt();
        mayor=num;
        menor=num;
        total=num;
        media =num;
       while (num!=0){
        System.out.println("Escribe un número:");
        num= in.nextInt();
        if(num>mayor){
            num=mayor;
        }
        if(num<menor){
            num=menor;
        }
        i++;
        media=total/i;
        total+=num;

        };


        System.out.println("El número menor es: "+menor+" el número mayor es: "+mayor+" la media es: "+media);
in.close();
    }
}