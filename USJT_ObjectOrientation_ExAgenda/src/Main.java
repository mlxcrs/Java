import java.util.Scanner;

public class Main {
	private static Scanner in;
	public static void main(String[] args){
		in = new Scanner(System.in);
		Agenda_Node agenda = new Agenda_Node();
		int op = 9;
		System.out.println("Bem vindo a Agenda!");
		System.out.println("Digite o numero de acordo com o que voce deseja fazer.");
		System.out.println("0 para encerrar o programa.");
		System.out.println("1 para inserir um novo contato.");
		System.out.println("2 para mostrar todos os itens.");
		System.out.println("3 para alterar algum contato.");
		System.out.println("4 para apagar algum item.");
		System.out.println("5 para buscar algum numero pelo nome.");
		while(op!=0){
			System.out.printf(":");
			try{
				op = in.nextInt();			
				switch (op){
					case 1:
						agenda.Incluir();
						break;
					case 2:
						agenda.Mostrar();
						break;
					case 3:
						agenda.Alterar();
						break;
					case 4:
						agenda.Excluir();
						break;
					case 5:
						agenda.Buscar();
						break;
					case 0:
						System.out.println("A agenda foi encerrada.");
						break;
				}
			}
			catch(Exception e){
				System.out.println("Erro!");
				op = 0;
			}
		}
	}
}