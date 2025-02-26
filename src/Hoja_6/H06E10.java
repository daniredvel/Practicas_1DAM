package Hoja_6;

import java.util.Scanner;
public class H06E10 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
            double num;
            num = Math.random()*101+1;// num=2*(int)(Math.random()*50+1)
            if(Math.round(num)%2 != 0){
                System.out.println(Math.round(num)+1);
            } else {
                System.out.println(Math.round(num));
            }
        in.close();
    }
}
