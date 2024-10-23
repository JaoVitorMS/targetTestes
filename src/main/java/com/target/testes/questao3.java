package src.main.java.com.target.testes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class questao3 {
    
    private static final String FILENAME = "src/main/resources/dados.xml";
    
    public static void main(String[] args) {
        Map<String, Double> listMap = new HashMap<>();
        listMap = readXML();
        
        System.out.println("Menor faturamento ocorrido em um dia do mês: " + menorFaturamento(listMap));
        System.out.println("Maior faturamento ocorrido em um dia do mês: " + maiorFaturamento(listMap));
        System.out.println("Numero de dias que o faturamento diário foi superior a media mensal: " + diasSuperior(listMap));

    }

    public static Double menorFaturamento(Map<String, Double> listMap){
        Double menor = Double.MAX_VALUE;
        for (Double value : listMap.values()) {
            if(value < menor && value != 0){
                menor = value;
            }
        }
        return menor;
    }

    public static Double maiorFaturamento(Map<String, Double> listMap){
        Double maior = Double.MIN_VALUE;
        for (Double value : listMap.values()) {
            if(value > maior && value != 0){
                maior = value;
            }
        }
        return maior;
    }

    public static int diasSuperior(Map<String, Double> listMap){
        Double media = 0.0;
        for (Double value : listMap.values()) {
            media += value;
        }
        media = media / listMap.size();
        int dias = 0;
        for (Double value : listMap.values()) {
            if(value > media){
                dias++;
            }
        }
        return dias;
    }

    public static Map<String, Double> readXML(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Map<String, Double> listMap = new HashMap<>();
        try{
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));



            // System.out.println("Root element: " + doc.getDocumentElement().getNodeName());


            NodeList nodeList = doc.getElementsByTagName("row");

            for(int temp = 0; temp < nodeList.getLength(); temp++){
                
                Node node = nodeList.item(temp);

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    
                    String dia = element.getElementsByTagName("dia")
                    .item(0)
                    .getTextContent();

                    String valorString = element.getElementsByTagName("valor")
                    .item(0)
                    .getTextContent();

                    Double valor = Double.parseDouble(valorString);

                    listMap.put(dia, valor);

                    // System.out.println("Dia: " + dia);
                    // System.out.println("Valor: " + valor);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {e.printStackTrace();}
        return listMap;
    }
    
}

