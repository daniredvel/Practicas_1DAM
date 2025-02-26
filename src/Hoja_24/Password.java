package Hoja_24;

import java.util.Arrays;

public class Password {
    private String pass;
    private char [] crear_pass;

    public Password(){
        char[] crear_pass = new char[12];
        char [][] data = new char [][]{{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'},
                {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'},
                {32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,58,59,60,61,62,63,64,65,67,91,92,93,94,95,96,123,124,125,126},
                {'0','1','2','3','4','5','6','7','8','9'}};
        int n1 = (int) (Math.random() * 26);
        int n2 = (int) (Math.random() * 34);
        int n3 = (int) (Math.random() * 10);

        crear_pass[0]=data [0][n1];
        crear_pass[1]=data [1][n1];
        crear_pass[2]=data [2][n2];
        crear_pass[3]=data [3][n3];
        for (int i = 4; i < 12; i++) {
            int n5 = (int) (Math.random() * 26);
            int n6 = (int) (Math.random() * 34);
            int n7 = (int) (Math.random() * 10);
            int n4 = (int) (Math.random() * 4);
            if (n4==0||n4==1) crear_pass[i]=data[n4][n5];
            if (n4==2) crear_pass[i]=data[n4][n6];
            if (n4==3) crear_pass[i]=data[n4][n7];
        }
        char aux;

        for (int j = 0; j < 40; j++) {
            int n1random = (int) (Math.random() * 12);
            int n2ra = (int) (Math.random() * 12);
            aux = crear_pass[n1random];
            crear_pass[n1random]= crear_pass[n2ra];
            crear_pass[n2ra]=aux;
        }
        pass=Arrays.toString(crear_pass);
    }
    public Password(String name){
        char[] crear_pass = new char[name.length()];
        for (int i = 0; i < name.length(); i++){
            crear_pass[i]=name.charAt(i);
        }
            char aux;

            for (int j = 0; j < 40; j++) {
                int n1 = (int) (Math.random() * name.length());
                int n2 = (int) (Math.random() * name.length());
                aux = crear_pass[n1];
                crear_pass[n1]= crear_pass[n2];
                crear_pass[n2]=aux;
        }
            pass=Arrays.toString(crear_pass);
    }
    public Password(int n){
        int num = Math.max(n, 12);
        char[] crear_pass = new char[num];
        char [][] data = new char [][]{{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'},
                {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'},
                {32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,58,59,60,61,62,63,64,65,67,91,92,93,94,95,96,123,124,125,126},
                {'0','1','2','3','4','5','6','7','8','9'}};
        int n1 = (int) (Math.random() * 26);
        int n2 = (int) (Math.random() * 34);
        int n3 = (int) (Math.random() * 10);

        crear_pass[0]=data [0][n1];
        crear_pass[1]=data [1][n1];
        crear_pass[2]=data [2][n2];
        crear_pass[3]=data [3][n3];
        for (int i = 4; i < (num); i++) {
            int n5 = (int) (Math.random() * 26);
            int n6 = (int) (Math.random() * 34);
            int n7 = (int) (Math.random() * 10);
            int n4 = (int) (Math.random() * 4);
            if (n4==0||n4==1) crear_pass[i]=data[n4][n5];
            if (n4==2) crear_pass[i]=data[n4][n6];
            if (n4==3) crear_pass[i]=data[n4][n7];
        }
        char aux;

        for (int j = 0; j < 40; j++) {
            int n1random = (int) (Math.random() * num);
            int n2random = (int) (Math.random() * num);
            aux = crear_pass[n1random];
            crear_pass[n1random]= crear_pass[n2random];
            crear_pass[n2random]=aux;
        }
        pass=Arrays.toString(crear_pass);
    }

    public String getPass() {
        return pass;
    }
    public boolean esFuerte(){
        boolean fuerte=false;
         fuerte = this.pass.matches("\\w\\d\\p{S}");
         fuerte = this.pass.length() >= 12;
         return fuerte;
    }

    public void setPass(String pass) {
        this.pass= new Password(pass).getPass();
    }
    public void setPass() {
        this.pass= new Password().getPass();
    }
    public void setPass(int n) {
        this.pass= new Password(n).getPass();
    }
}
