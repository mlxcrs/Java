import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Semantico {
	private static String sintaxe;
	private static Stack n = new Stack();
	private static Stack s = new Stack();
	private static int t = 1;
	private static int pos = 0;
	private static int nvl = 0;
	private static BufferedReader ins = new BufferedReader(new InputStreamReader(System.in));
	void desempilha() {
		System.out.println("LDA "+n.pop());
		switch (s.pop().toString()) {
			case "/":
				System.out.printf("DIV "+n.pop()+"\n");
				break;
			case "+":  
				System.out.printf("ADA "+n.pop()+"\n");
				break;
			case "-":  
				System.out.printf("SUB "+n.pop()+"\n");
				break;
			case "*":  
				System.out.printf("MUL "+n.pop()+"\n");
				break;
		}
		System.out.println("STA T"+t);
		n.push("T"+t);
		t++;
	}
	Semantico(){
		e1();
	}
	void e1() {
		if(sintaxe.charAt(pos)=='(') {
			pos++;
			nvl++;
			e1();
		}
		else if(sintaxe.charAt(pos)>='0' || sintaxe.charAt(pos) <='9') {
			n.push(sintaxe.charAt(pos));
			pos++;
			e2();
		}
		else {
			System.out.println("Erro");
		}
	}
	void e2() {
		if(sintaxe.charAt(pos)==')') {
			pos++;
			nvl--;
			if(n.isEmpty() || s.isEmpty()) {
				System.out.println("Erro");
			}
			else {
				desempilha();
				e2();
			}
		}
		else if(sintaxe.charAt(pos)=='+' || sintaxe.charAt(pos)=='-') {
			s.push(sintaxe.charAt(pos));
			pos++;
			e1();
		}
		else if(sintaxe.charAt(pos)=='*' || sintaxe.charAt(pos)=='/') {
			s.push(sintaxe.charAt(pos));
			pos++;
			e3();
		}
		else if(sintaxe.charAt(pos)==' ') {
			e5();
		}
		else {
			System.out.println("Erro");
		}
	}
	void e3() {
		if(sintaxe.charAt(pos)=='(') {
			pos++;
			nvl++;
			e1();
		}
		else if(sintaxe.charAt(pos)>='0' || sintaxe.charAt(pos) <='9') {
			n.push(sintaxe.charAt(pos));
			pos++;
			e4();
		}
		else {
			System.out.println("Erro");
		}
	}
	void e4() {
		if(sintaxe.charAt(pos)==')') {
			pos++;
			nvl--;
			if(n.isEmpty() || s.isEmpty()) {
				System.out.println("Erro");
			}
			else {
				desempilha();
			}
		}
		else if(sintaxe.charAt(pos)=='*' || sintaxe.charAt(pos)=='/') {
			s.push(sintaxe.charAt(pos));
			pos++;
			e3();
		}
		else if(sintaxe.charAt(pos)=='+' || sintaxe.charAt(pos)=='-') {
			desempilha();
			s.push(sintaxe.charAt(pos));
			pos++;
			e1();
		}
		else if(sintaxe.charAt(pos)==' ') {
			e5();
		}
		else {
			System.out.println("Erro");
		}
	}
	void e5() {
		if(n.isEmpty() && s.isEmpty()) {
			System.out.println("Erro");
		}
		else if(n.size()==1 && s.isEmpty() && nvl==0) {
			System.out.println("Sucesso");
		}
		else {
			desempilha();
			if(sintaxe.charAt(pos)==' ') {
				e5();
			}
			else {
				e1();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		System.out.print("Entrada: ");
		sintaxe = ins.readLine()+" ";
		System.out.println("Saida: ");
		Semantico teste = new Semantico();
	}
}