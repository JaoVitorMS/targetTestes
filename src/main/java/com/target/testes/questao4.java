package src.main.java.com.target.testes;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class questao4 {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();

        map.put("SP", 67836.43);
        map.put("RJ", 36678.66);
        map.put("MG", 29229.88);
        map.put("ES", 27165.48);
        map.put("Outros", 19849.53);
     
        percentualEstado(map);
    }

    public static void percentualEstado(Map<String, Double> map) {
        double total = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        for (Double value : map.values()) {
            total += value;
        }

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            double valores = (entry.getValue() / total) * 100;
            String percentual = df.format(valores);
            System.out.println(entry.getKey() + " = " + percentual + "%");
        }
        System.out.println("--------------------");
        System.out.println("Total = " + total);
        System.out.println("--------------------");

    }
}
