import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Transdutor {
	static String[] variaveis = new String[50];
	static int var;
	static String[] preservadas = new String[9];
	static char[] sinais = new char[8];
	static String sintaxe;
	static String palavra;
	static int indice = 0;
	
	static void e1(){
		int inipos = indice;
		while( sintaxe.charAt(indice)>='A' && sintaxe.charAt(indice)<='Z'||
				sintaxe.charAt(indice)>='a' && sintaxe.charAt(indice)<='z'||
				sintaxe.charAt(indice)>='0' && sintaxe.charAt(indice)<='9'){
			indice++;
		}
		boolean reservada = false;
		boolean variavel = false;
		palavra = sintaxe.substring(inipos,indice);
		for(int i=0;i<preservadas.length;i++){
			if(preservadas[i].equals(palavra)){
				reservada = true;
				System.out.print("P("+i+")");
				break;
			}
		}
		if(!reservada){
			int i;
			for(i=0;i<variaveis.length;i++){
				if(variaveis[i].equals(palavra)){
					variavel = true;
					System.out.print("V("+i+")");
					break;
				}
			}
			if(!variavel){
				variaveis[var]=palavra;
				System.out.print("V("+var+")");
				var++;
			}
		}
		palavra=null;
		reservada=false;
		variavel=false;
	}
	static void e2(){
		int Numero=0;
		while(sintaxe.charAt(indice)>='0' && sintaxe.charAt(indice)<='9') {
			String s = sintaxe.charAt(indice)+"";
			Numero = Numero*10+Integer.parseInt(s);
			indice++;
		}
		System.out.print("N("+Numero+")");
	}
	static void e3(){
		System.out.print(sintaxe.charAt(indice));
		indice++;
		if(sintaxe.charAt(indice)=='=') {
			e4();
		}
	}
	static void e4(){
		System.out.print(sintaxe.charAt(indice));
		indice++;
	}
	static void e5(){
		while(sintaxe.charAt(indice)!=':' && sintaxe.charAt(indice)!=' ') {
			indice++;
		}
	}
	static void e6(){
		System.out.print(sintaxe.charAt(indice));
		indice++;
	}
	public static void main(String[] args) throws IOException{
		var=0;
		preservadas[0]="if";
		preservadas[1]="let";
		preservadas[2]="then";
		preservadas[3]="print";
		preservadas[4]="of";
		preservadas[5]="else";
		preservadas[6]="goto";
		preservadas[7]="read";
		preservadas[8]="end";
		sinais[0]='>';
		sinais[1]='<';
		sinais[2]='=';
		sinais[3]='!';
		sinais[4]='(';
		sinais[5]=')';
		sinais[6]='%';
		sinais[7]=':';
		for(int i=0;i<variaveis.length;i++) {
			variaveis[i]="";
		}
		BufferedReader ins = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Entrada: ");
		sintaxe = ins.readLine()+" ";
		System.out.print("Saida: ");
		while(indice<sintaxe.length()){
			if(sintaxe.charAt(indice)>='A' && sintaxe.charAt(indice)<='Z'|| 
					sintaxe.charAt(indice)>='a' && sintaxe.charAt(indice)<='z'){
				e1();
			}
			else if(sintaxe.charAt(indice)>='0' && sintaxe.charAt(indice)<='9'){
				e2();
			}
			else if(sintaxe.charAt(indice)==':') {
				e3();
			}
			else if(sintaxe.charAt(indice)=='%') {
				e5();
			}
			else{
				e6();
			}
		}
		int a=0;
		System.out.printf("\nTabela de Variaveis\n");
		while(!variaveis[a].equals("")){
			System.out.println(a+ " - "+ variaveis[a]);
			a++;
		}
		a=0;
		System.out.printf("\nTabela de Palavras\n");
		while(a<9){
			System.out.println(a+ " - "+ preservadas[a]);
			a++;
		}
	}
}
