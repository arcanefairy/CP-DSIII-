
 package codigopostal;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CodigoPostal {
    
    public static void main(String[] args) throws IOException {
        File csv = new File("C:/Users/DII/Downloads/codigos_postales_hmo");
        String linea;
        
        try (FileReader fr = new FileReader(csv);
            BufferedReader br = new BufferedReader(fr)) {
            Map<String, Integer> count = new HashMap<>();
            
            while ((linea = br.readLine()) != null) {
                String[] split = linea.split(",");  
                if (count.containsKey(split[0])) {
                    count.put(split[0], count.get(split[0]) + 1);
                } //termina la condicion if
                else {
                    count.put(split[0], 1);
                } //termina la condicion else
            } //termina el ciclo for
            
            for (Map.Entry<String, Integer> entry : count.entrySet()) {
                if (entry.getValue() > 1) {
                    System.out.println(entry.getKey());
                } //termina la condicion if
            } //termina el ciclo for
        } //termina try
        catch (Exception e) {
            System.out.println(e);
        } //termina catch
    } //termina el método principal
} //termina la clase principal

