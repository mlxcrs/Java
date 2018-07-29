package gerais;

public class Fila {
    Node l;
    Fila(){
        l=null;
    }
    void inclui(String elem){
    	Node aux = new Node();
        aux.data = elem;
        aux.link = l;
        l = aux;
    }
	String exclui(){
		if(l==null){
			return "*";
		}
		else{
			String aux = l.data;
			l = l.link;
		    return aux;
		}
	}
}