package src.main.java.com.target.testes;

import java.util.Scanner;

public class questao5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite uma string para inverter: ");
        String str = sc.nextLine();

        inverterString(str);

        sc.close();
    }

    public static void inverterString(String str) {
        char[] strArray = str.toCharArray();
        char[] strInvertida = new char[strArray.length];

        for (int i = 0; i < strArray.length; i++) {
            strInvertida[i] = strArray[strArray.length - 1 - i];
        }

        System.out.println("String invertida: " + new String(strInvertida));
    }
}
