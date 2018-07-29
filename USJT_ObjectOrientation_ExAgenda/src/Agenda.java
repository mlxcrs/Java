import java.io.*;
import java.util.*;
import java.util.Scanner;
/*
Exercício 06

Implemte uma classe que funcione como uma agenda de até 30 nomes e fones.
A classe deve ter 2 vetores com 30 elementos (ambos do tipo string).No 1º serão
armazenados os nomes e no 2º os telefones. Criar os seguintes métodos para manutenção da agenda:

a- Inclusão: inclui um determinado elemento no final da agenda;
b- Exclusão: exclui um determinado elemento da agenda;
c- Listagem: mostra os elementos da agenda na tela;
d- Busca: procura pelo nome um elemento na agenda e mostra o fone;
e- Altera fone: recebe o nome e o novo fone e altera o existente.

Para comparar conteúdos de string, usar if (s1.equals (s2)) 
Não pode fazer s1 == s2
*/
public class Agenda {
	private int tamanho, primeiro, ultimo;
	private String nome[], fone[];
	Agenda(){
		tamanho = 30;
		nome = new String[30];
		fone = new String[30];
		primeiro = 0;
		ultimo = 0;
	}
	int proximo(int n) {
		if(n == tamanho-1){
			return 0;
		}
		else{
			return n+1;
		}
	}
	boolean cheia(){
		if (proximo(ultimo) == primeiro){
			return true;
		}
		else{
			return false;
		}
	}
	void inserir(String n, String f){
		if(cheia()){
			System.out.println("Overflow!");
			System.exit(1);
		}
		else{
			nome[ultimo]=n;
			fone[ultimo]=f;
			ultimo = proximo(ultimo);
		}
	}
	void altera(String n,String f, int p){
		nome[p]=n;
		fone[p]=f;
	}
	boolean vazia(){
		if (ultimo == primeiro){
			return true;
		}
		else{
			return false;
		}
	}
	void apaga(String apam, String apaf){
		String auxn, auxf;
		if(vazia()){
			System.out.println("Underflow!");
			System.exit(1);
		}
		else{
			auxn = nome[primeiro];
			auxf = fone[primeiro];
			primeiro = proximo(primeiro);
		}
	}
	void mostratudo(){
		if(vazia()){
			System.out.println("Underflow!");
			System.exit(1);
		}
		else{
			int i = primeiro, j = ultimo;
			for (i = primeiro;i<j;i++){
				System.out.println("Contato " + i + " eh:\n" + nome[i] + "\n" + fone[i] + "\n\n");
			}
		}
	}
	int procura(String nome2){
		int i = primeiro, j = ultimo;
		for (i = primeiro;i<j;i++){
			if (nome[i].equals (nome2)){
				break;
			}
		}
		return i;
	}
	public static void main(String[] args){
		BufferedReader ins;
		ins = new BufferedReader( new InputStreamReader (System.in) );
		Scanner entrada = new Scanner(System.in);
		Agenda agenda;
		agenda = new Agenda();
		int num = 0, pos=0, w=10000;
		String nomea="", fonea="", boole="";
		while(w==10000){
			System.out.println("\nDigite um numero de acordo com o que vc quer fazer;" + 
				"\nsendo 1 para inserir;" + 
				"\nsendo 2 para apagar o primeiro contato da agenda;" + 
				"\nsendo 3 para Listar todos os elementos da agenda;" + 
				"\nsendo 4 para procurar algum item na agenda" + 
				"\nsendo 5 para alterar o contato" + 
				"\nsendo 0 para encerrar o programa.");
			num = entrada.nextInt();
			System.out.println("\n");
			switch (num){
				case 1:
					System.out.println("\nInsira o nome do contato.\n");
					try {
						nomea = ins.readLine();
					}
					catch (Exception e) {
						System.out.println("Ocorreu um erro durante a leitura !");
					}
					System.out.println("\nInsira o telefone do contato.\n");
					try {
						fonea = ins.readLine();
					}
					catch (Exception e) {
						System.out.println("Ocorreu um erro durante a leitura !");
					}
					agenda.inserir(nomea,fonea);
					break;
				case 2:
					agenda.apaga(nomea,fonea);
					break;
				case 3:
					agenda.mostratudo();
					break;
				case 4:
					System.out.println("\nInsira o nome do contato a ser procurado.\n");
					try {
						nomea = ins.readLine();
					}
					catch (Exception e) {
						System.out.println("Ocorreu um erro durante a leitura !");
					}
					pos = agenda.procura(nomea);
					System.out.println("O Contato esta na posicao " + pos + " da agenda.\n");
					System.out.println("Se o deseja alterar digite sim, se nao digite nao.\n");
					try {
						boole = ins.readLine();
					}
					catch (Exception e) {
						System.out.println("Ocorreu um erro durante a leitura !");
					}
					if(boole.equals ("sim")){
						System.out.println("\nInsira o nome do contato.\n");
						try {
							nomea = ins.readLine();
						}
						catch (Exception e) {
							System.out.println("Ocorreu um erro durante a leitura !");
						}
						System.out.println("\nInsira o telefone do contato.\n");
						try {
							fonea = ins.readLine();
						}
						catch (Exception e) {
							System.out.println("Ocorreu um erro durante a leitura !");
						}
						agenda.altera(nomea,fonea,pos);   
					}
					break;
				case 5:
					System.out.println("\nInsira o nome do novo contato.\n");
					try {
						nomea = ins.readLine();
					}
					catch (Exception e) {
						System.out.println("Ocorreu um erro durante a leitura !");
					}
					System.out.println("\nInsira o telefone do novo contato.\n");
					try {
						fonea = ins.readLine();
					}
					catch (Exception e) {
						System.out.println("Ocorreu um erro durante a leitura !");
					}
					System.out.println("Qual posicao da agenda sera alterado?");
					pos = entrada.nextInt();
					agenda.altera(nomea,fonea,pos);
					break;
				case 0:
					w=999;
					break;
			}
		}
	}
}
