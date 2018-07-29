public class Fila {
    public static class Nodo{
        char data;
        Nodo link;
    }
    Nodo l;
    Fila(){
        l=null;
    }
    void inclui(char elem){
        Nodo aux = new Nodo();
        aux.data = elem;
        aux.link = l;
        l = aux;
    }
    char exclui(){
    	Nodo aux = l;
    	char a='*';
    	if(aux==null){
    		return a;
    	}
    	if(aux.link==null){
    		a=aux.data;
    		l=null;
    		return a;
    	}
    	while(aux.link!=null){
    		if(aux.link.link==null){
    			a=aux.link.data;
    			aux.link=null;
    		}
    		else{
    			aux=aux.link;
    		}
    	}
    	return a;
    }
    public static void main(String[] args){
    	Fila bus = new Fila();
    	bus.inclui('A');
    	bus.inclui('B');
    	bus.inclui('C');
    	bus.inclui('D');
    	System.out.println(bus.exclui());
    	System.out.println(bus.exclui());
    	System.out.println(bus.exclui());
    	System.out.println(bus.exclui());
    	System.out.println(bus.exclui());
    }
}