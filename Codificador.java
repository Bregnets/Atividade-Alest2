
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toMap;


 

public class Codificador {
    
    private String msg;     // msg original
    private String codigo;  // msg codificada
    private String junto;   // STRING AUXILIAR ARVORE EX: AEOBCE
    private String Dicionariofinal; // MSG DICIONARIO FORMATO A:11111
     
    private HashMap<Character, Integer> freq;       // HASH MAP FREQUECIA EX: A - 10
    private HashMap<Character, Integer> freqOrd;    // HASH MAP COM A FREQUENCIA ORDENADA MAIOR PRO MENOR
    private HashMap<Character, String> dicionario;  // HASH MAP DICIONARIO EX: A - 11111        
    private BST arvore;

    public Codificador(String msg) {
        this.msg = msg;
    
    }
    
    public void contaFreq(){                // CONTA A FREQUENCIA DOS CARACTERES NA MENSAGEM
        for(int i=0; i<msg.length();i++){           
                if(freq.containsKey(msg.charAt(i))){
                    freq.put(msg.charAt(i), freq.get(msg.charAt(i))+1);
                }else{
                    freq.put(msg.charAt(i), 1);
                }
            }    
    }
    
    public void orderaHash(){               // ORDENA OS CARACTERES COM MAIOR FREQUENCIA DENTRO DO HASHSET
        freqOrd = freq
        .entrySet()
        .stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .collect(
            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                LinkedHashMap::new));
    }
    
    public void juntaString(){                   // CONCATENA AS KEYS NO HASHSET  EX: A - B - C - D // ABCD
       List<String> keys = new ArrayList(freqOrd.keySet());
       String aux = keys.get(0);
       for(int i=1;i<keys.size();i++){
           aux = aux.concat(keys.get(i));
       }
       System.out.println(aux);
       junto = aux;
    }
   
    public void criaArvore(String j){           // CRIA A ARVORE
        arvore.insert(junto);
        while(junto.length()>1){
            String aux = junto;
            String aux1a = junto.substring(0, (junto.length()/2));
            String aux1b = junto.substring((junto.length()/2));
            arvore.insert(arvore.,aux1a);
            arvore.insert(aux,aux1b);
            criaArvore(aux1a);
            criaArvore(aux1b);
        }  
    }
    
    public void getCodigos(){           // PEGA OS CODIGOS E SALVA NO DICIONARIO UTILIZANDO UM METODO IMPLEMENTADO NA ARVORE
        List<Character> keys = new ArrayList(freqOrd.keySet());
        for(int i=0; i<freqOrd.size();i++){
           dicionario.put(keys.get(i), arvore.getCodigo(keys.get(i)));
        }
    }
    
    public void setaCodigo(){          // CRIA A MSG CODIFICADA 
        codigo = "";
        for(int i=0; i<msg.length();i++){
            if(dicionario.containsKey(msg.charAt(i))){
                codigo = codigo + dicionario.get(msg.charAt(i));
            }
            
        }
    }
    
    public void escreveCodigo(){        // ESCREVE NO ARQUIVO TEXTO A MSG CODIFICADA
        try {
            File newTextFile = new File("C:/binario.txt");

            FileWriter fw = new FileWriter(newTextFile);
            fw.write(codigo);
            fw.close();

        } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }
    }
    public void escreveDicionario(){        // ESCREVE DICIONARIO NO ARQUIVO TEXTO
        try {

            File newTextFile = new File("C:/tabela.txt");

            FileWriter fw = new FileWriter(newTextFile);
            fw.write(Dicionariofinal);
            fw.close();

        } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }
    }
}
