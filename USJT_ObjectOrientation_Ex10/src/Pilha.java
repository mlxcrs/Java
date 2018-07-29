/* ex10
A)IMPLEMENTAR PILHA USANDO LISTAS ENCADEADAS COM ALOCAÇÃO DINAMICA E TESTAR
B)IMPLEMENTAR FILA
C)IMPLEMENTAR UM DEQUE
D)IMPLEMENTAR UMA AGENDA COM NOME E TELEFONE USANDO LISTAS ENCADEADAS ONDE OS ELEMENTOS SE MANTEM EM ORDEM NA LISTA COM OS SEGUINTES METODOS:
INCLUIR
LISTAR NOMES E TELEFONES
BUSCAR O FONE A PARTIR DO NOME
ALTERAR O FONE A PARTIR DO NOME
EXCLUIR UM ELEMENTO A PARTIR DO NOME
DESTRUIR A LISTA TODA */
public class /*EX10A*/Pilha{

	public static class Nodo{
	   char data;
	   Nodo link;
   	}
	Nodo l;
	Pilha(){
		l=null;
	}
	void inclui(char elem){
        Nodo aux = new Nodo();
        aux.data = elem;
        aux.link = l;
        l = aux;
	}
	char exclui(){
		if(l==null){
			return '*';
		}
		else{
			char aux = l.data;
			l = l.link;
		    return aux;
		}
	}
	public static void main(String[] args){
		Pilha lista = new Pilha();
		lista.inclui('a');
		lista.inclui('b');
		lista.inclui('c');
		System.out.println(lista.exclui());
		System.out.println(lista.exclui());
		System.out.println(lista.exclui());
		System.out.println(lista.exclui());
	}
}