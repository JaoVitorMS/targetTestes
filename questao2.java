import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class questao2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num;
        System.out.println("Digite o valor do número desejado: ");
        num = sc.nextInt();

        List<Integer> lista = new ArrayList<Integer>();

        lista = fibonacci();

        // System.out.println(lista);

        if (lista.contains(num)){
            System.out.println("O número " + num + " pertence a sequência de Fibonacci.");
        } else {
            System.out.println("O número " + num + " não pertence a sequência de Fibonacci.");
        }

        sc.close();
    }

    public static List<Integer> fibonacci(){
        List<Integer> fibos = new ArrayList<Integer>();
        int start = 0;
        int present = 1;
        int next = 0;

        fibos.add(start);
        fibos.add(present);

        while (next < 1000){
            next = start + present;
            fibos.add(next);
            start = present;
            present = next;
        }

        return fibos;
    }
}