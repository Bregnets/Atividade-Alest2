
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Fred
 */
public class Huffman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
    BufferedReader br = null;
    br = new BufferedReader(new InputStreamReader(System.in));   
    
    String mensagem;   
    Codificador cod;
    Decodificador decod;
    
    

    System.out.println("HUFFMAN");
    System.out.println("Digite a sua mensagem:");
    mensagem = br.readLine();
    cod = new Codificador(mensagem);
    cod.executa();
    ////////////////////////////////////////
        
              DECODIFICADOR
    ///////////////////////////////////////
    
    }
    
}
