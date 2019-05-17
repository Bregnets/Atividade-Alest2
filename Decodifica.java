
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class Decodifica{
    HashMap<String,Character> hash;
    public Decodifica(){
        hash = new HashMap<String,Character>();
    }

    public void criaHash(String arq)throws FileNotFoundException{
        Scanner file= new Scanner(new File(arq));
        while(file.hasNextLine()){
            String line = file.nextLine();
            String[] campos = line.split(":");
            Character cha = campos[0].charAt(0);
            String num = campos[1];
            hash.put(num, cha);

       }
       
       file.close();
    }

    public void criaArquivo(String arq)throws IOException{
        FileWriter fileWriter = new FileWriter("/home/pedro/Documents/result.txt");
        
        String padrao = "";
        Scanner file= new Scanner(new File(arq));
        
        while(file.hasNextLine()){
            String line = file.nextLine();
            
            for (int i=0; i<line.length();i++){
                padrao+=line.charAt(i);
                
            if (hash.containsKey(padrao)){
                System.out.println(padrao);
                fileWriter.write(hash.get(padrao));
                padrao = "";
            }
            
                
       }}
       file.close();
       fileWriter.close();
    }


    public static void main(String[] args) throws FileNotFoundException, IOException{
        Decodifica dec = new Decodifica();
        dec.criaHash("/home/pedro/Documents/tabela.txt");
        dec.criaArquivo("/home/pedro/Documents/binario.txt");
        

    }

    



       
    }

 