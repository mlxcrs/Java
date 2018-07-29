public class Agenda {
	public static class Nodo{
		String nome;
		String fone;
		Nodo link;
	}
	Nodo l;
	Agenda(){
		l=null;
	}

	void incluir(String n, String f){
        Nodo aux = new Nodo();
        aux.nome = n;
        aux.fone = f;
        aux.link = l;
        l = aux;
        //ordena
        Nodo aux1=l;
		Nodo aux2=new Nodo();
		while(aux1.link!=null){
			if(aux1.nome.compareTo(aux1.link.nome)<0){
				aux2.nome=aux1.nome;
				aux2.fone=aux1.fone;
				aux1.nome=aux1.link.nome;
				aux1.fone=aux1.link.fone;
				aux1.link.nome=aux2.nome;
				aux1.link.fone=aux2.fone;
				aux1=aux1.link;
			}
			else{
				aux1=aux1.link;
			}
		}
	}
	void listar(){
		Nodo aux = l;
		System.out.println("Todos os telefones da Agenda.");
		while(aux!=null){
			System.out.println("Nome: "+aux.nome);
			System.out.println("Fone: "+aux.fone);
			aux=aux.link;
		}
	}
	void buscar(String n){
		Nodo aux = l;
		while(aux!=null){
			if(n.equals(aux.nome)){
				System.out.println("O Nome foi encontrado e corresponde a esse telefone: "+ aux.fone);
				break;
			}
			aux=aux.link;
		}
		if(aux==null){
			System.out.println("O nome nao foi encontrado");
		}
	}
	void alterar(String n,String f){
		Nodo aux = l;
		while(aux!=null){
			if(n.equals(aux.nome)){
				System.out.println("O Nome foi encontrado e telefone foi substituido por: "+ f);
				aux.fone=f;
				break;
			}
			aux=aux.link;
		}
		if(aux==null){
			System.out.println("O nome nao foi encontrado");
		}
	}
	void excluir(String n){
		/* A void excluir ainda não está funcionando.
		Nodo aux = l;
		while(l!=null){
			if(n.equals(l.nome)){
				System.out.println("O Nome foi encontrado e deletado.");
				l=l.link;
				break;
			}
			l=l.link;
		}
		if(aux==null){
			System.out.println("O nome nao foi encontrado.");
		}
		l=aux;*/
	}
	void destruir(){
		l=null;
	}
	public static void main(String[] args){
		Agenda usjt = new Agenda();
		usjt.incluir("Mateus","123456789");
		usjt.incluir("Lucas","456789012");
		usjt.incluir("Marco","789123456");
		usjt.incluir("Tatiane","987654321");
		usjt.alterar("Lucas","123456789");
		usjt.buscar("Tatiane");
		usjt.excluir("Marco");
		usjt.listar();
		usjt.destruir();
	}
}