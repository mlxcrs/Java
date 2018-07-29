import java.io.*;
public class Agenda_Node{
	Nodo l;
	Agenda_Node(){
		l = null;
	}
	void Incluir(){
		Nodo aux = new Nodo();
		BufferedReader inb = new BufferedReader( new InputStreamReader (System.in) );
		System.out.printf("Insira o nome do contato: ");
		try{
			aux.Nome = inb.readLine();
		}
		catch(Exception e){
			System.out.println("Houve algum problema com o nome.");
		}
		System.out.printf("\nInsira o telefone do contato: ");
		try{
			aux.Fone = inb.readLine();
		}
		catch(Exception e){
			System.out.println("Houve algum problema com o telefone.");
		}
		if(l==null){
			aux.link0 = aux;
			aux.link1 = aux;
			l = aux;
		}
		else{
			aux.link1 = l;
			aux.link0 = l.link0;
			l.link0.link1 = aux;
			l.link0 = aux;
		}
	}
	Nodo Pesquisar(String a){
		if(l!=null){
			Nodo aux = l.link1;
			while(aux!=l){
				if(aux.Nome.equals(a)){
					return aux;
				}
				aux = aux.link1;
			}
			if(aux==l){
				if(aux.Nome.compareTo(a)==0){
					return aux;
				}
			}
		}
		return null;
	}
	void Excluir(){
		BufferedReader inb = new BufferedReader(new InputStreamReader (System.in));
		String t = "*";
		if(l==null){
			System.out.println("A agenda esta vazia!");
		}
		else{
			System.out.print("Insira o nome do contato que deseja apagar: ");
			try{
				t = inb.readLine();
			}
			catch(Exception e){
				System.out.println("Houve algum problema com o nome.");
			}
			Nodo aux; 
			aux = Pesquisar(t);
			if(aux==null){
				System.out.println("O nome nao foi encontrado.");
			}
			else{
				aux.link0.link1 = aux.link1;
				aux.link1.link0 = aux.link0;
				aux.link1 = null;
				aux.link0 = null;
				System.out.println("O contato foi apagado.");
			}
		}
	}
	void Mostrar(){
		if(l!=null){
			Nodo aux = l;
			System.out.printf("|%10S|%10S|\n","Nome","Telefone");
			while(aux.link1!=l){
				aux = aux.link1;
				System.out.printf("|%10S|%10S|\n",aux.Nome,aux.Fone);
			}
			if(aux.link1==l){
				aux = aux.link1;
				System.out.printf("|%10S|%10S|\n",aux.Nome,aux.Fone);
			}
		}
	}
	void Buscar(){
		BufferedReader inb = new BufferedReader (new InputStreamReader (System.in));
		System.out.println("Por qual nome voce deseja procurar?");
		String t = "*";
		try{
			t = inb.readLine();
		}
		catch(Exception e){
			System.out.println("Houve algum problema com o nome.");
		}
		Nodo aux;
		aux = Pesquisar(t);
		if(aux==null){
			System.out.println("O nome nao foi encontrado.");
		}
		else{
			System.out.println("o telefone de "+t+" eh:");
			System.out.println(aux.Fone);
		}
	}
	void Alterar(){
		BufferedReader inb = new BufferedReader (new InputStreamReader (System.in));
		System.out.println("Qual nome voce deseja alterar?");
		String t = "*";
		try{
			t = inb.readLine();
		}
		catch(Exception e){
			System.out.println("Houve algum problema com o nome.");
		}
		Nodo aux;
		aux = Pesquisar(t);
		System.out.printf("Digite o novo nome:");
		try{
			aux.Nome = inb.readLine();
		}
		catch(Exception e){
			System.out.println("Houve algum erro com o nome.");
		}
		System.out.printf("Digite o novo telefone:");
		try{
			aux.Fone = inb.readLine();
		}
		catch(Exception e){
			System.out.println("Houve um erro com o novo telefone.");
		}
	}
}
