/**
 *
 * @author Fred
 */
public class ArvoreSimples {
    
    Node root;
    
    
    
    public String getCodigo(Character c){   // VAREDURA ESQUERA RAIZ DIREITA 
        String codigo = "";
        
        
        
        return codigo;
    }
    
    public Node getNodo(String c){          // PROCURA E RETORNA REFERENCIA DO NODO
        
        
    }
    
    public void acidona(String valor){      // ADICIONA NOVO NODO 
        root = new Node(valor);
    }
    
    public void adiciona(Node pai, String valor) {
        Node aux = new Node(valor);
        if(pai.left==null){
            pai.left = aux;
        }
        else if(pai.right==null){
            pai.right = aux;
        }
    }
}

class Node {
    String value;
    Node left;
    Node right;
 
    Node(String value) {
        this.value = value;
        right = null;
        left = null;
    }
}
