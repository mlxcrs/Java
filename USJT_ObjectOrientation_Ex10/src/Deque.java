public class Deque {
	public static class Nodo{
		char data;
		Nodo link;
	}
	Nodo l;
	Deque(){
		l=null;
	}
	void inclui(char elem,int loc){
		if(loc==1){
			Nodo aux = new Nodo();
	        aux.data = elem;
	        aux.link = l;
	        l = aux;
		}
		if(loc==2){
			Nodo aux=l;
			if(aux==null){
				aux = new Nodo();
				aux.data=elem;
				aux.link=null;
			}
			else{
				while(aux.link!=null){
					aux=aux.link;
				}
				aux.link=new Nodo();
				aux.link.data=elem;
				aux.link.link=null;
			}
		}
	}
	char exclui(int loc){
		if(loc==1){
			if(l==null){
				return '*';
			}
			else{
				char aux = l.data;
				l = l.link;
			    return aux;
			}
		}
		if(loc==2){
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
		return'*';
	}
	public static void main(String[] args){
		/*Numero 1 para inserir ou retirar da esquerda
		e numero 2 para inserir ou retirar da direita*/
		Deque jogo = new Deque();
		jogo.inclui('A',1);
		jogo.inclui('B',1);
		jogo.inclui('C',2);
		jogo.inclui('D',2);
		System.out.println(jogo.exclui(2));
		System.out.println(jogo.exclui(1));
		System.out.println(jogo.exclui(2));
		System.out.println(jogo.exclui(1));
		System.out.println(jogo.exclui(2));
	}
}
