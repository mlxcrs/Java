import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Automato {
	static Scanner ins = new Scanner(System.in);
	static int p=0;
	static String[] f = new String[100];
	static String[] alpha = new String[100];
	static int cAlpha=0;
	static String[] stage = new String[100];
	static int cStage=0;
	static String iStage;
	static int piStage;
	static String[] fStage = new String[100];
	static int cfStage=0;
	static int[] pfStage;
	static String[][] tabela;
	public static boolean entre(int exem,int[] vet){
		int len = vet.length;
		for(int i=0;i<len;i++){
			if(exem==vet[i]){
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args){
		System.out.printf("\nInsira os caracteres pertencentes ao seu alfabeto!\nPara concluir a insercao do alfabeto digite '!'\n");
		alpha[cAlpha] = ins.next();
		cAlpha++;
		while(alpha[cAlpha-1].compareTo("!")!=0){
			alpha[cAlpha] = ins.next();
			cAlpha++;
		}
		System.out.printf("\nInsira todos os estados de forma numerica. Exemplo:\nEstado e1 digite 1, estado e2 digite 2.\nPara concluir a insercao do alfabeto digite '!'\n");
		stage[cStage] = ins.next();
		cStage++;
		while(stage[cStage-1].compareTo("!")!=0){
			stage[cStage] = ins.next();
			cStage++;
		}
		System.out.printf("\nInsira qual dos estados eh o inicial\n");
		iStage = ins.next();
		for(int i=0;i<cStage-1;i++){
			if(iStage.equals(stage[i])){
				piStage = i;
			}
		}
		System.out.printf("\nInsira quais dos estados sao os estados finais.\nPara concluir digite '!'\n");
		fStage[cfStage] = ins.next();
		cfStage++;
		while(fStage[cfStage-1].compareTo("!")!=0){
			fStage[cfStage] = ins.next();
			cfStage++;
		}
		pfStage = new int[cfStage-1];
		for(int i=0;i<cfStage-1;i++){
			for(int j=0;j<cStage-1;j++){
				if(fStage[i].equals(stage[j])){
					pfStage[i]=j;
				}
			}
		}
		tabela = new String[cStage-1][cAlpha-1];
		for(int i=0;i<cStage-1;i++){
			for(int j=0;j<cAlpha-1;j++){
				System.out.println("Se o estado "+stage[i]+" receber "+alpha[j]+" irá para qual estado?");
				tabela[i][j] = ins.next();
			}
		}
		constroi();
	}
	public static void constroi(){
		try{
			String nome;
			System.out.println("Informe o nome do arquivo onde será escrito o automato!");
			nome = ins.next();
			FileWriter arq = new FileWriter(nome+".txt");
			PrintWriter gravarArq = new PrintWriter(arq);
			
			gravarArq.printf(
				"import java.util.*;%n"+
				"public class "+nome+" {%n"+
				"	static Scanner ins = new Scanner(System.in);%n"+
				"	static int p=0;%n"+
				"	static String f;%n"+
				"	static void aceita(){%n"+
				"		System.out.printf("+(char)34+"Aceita "+(char)92+"n"+(char)34+");%n"+
				"		System.exit(0);%n"+
				"	}%n"+
				"	static void rejeita(){%n"+
				"		System.out.printf("+(char)34+"Rejeita "+(char)92+"n"+(char)34+");%n"+
				"		System.exit(0);%n"+
				"	}%n"+
				"	public static void main(String[] args){%n"+
				"		p=0;%n"+
				"		System.out.println("+(char)34+"Palavra?"+(char)34+");%n"+
				"		f = ins.next()+"+(char)34+"!"+(char)34+";%n"+
				"		e"+iStage+"();%n"+
				"	}%n"
			);
			for(int i=0;i<cStage-1;i++){
				if(i==0){
					gravarArq.printf(
						"	static void e"+iStage+"(){%n"+
						"		if(f.substring(p,p+1).equals("+(char)34+alpha[0]+(char)34+")){%n"+
						"			p++;%n"+
						"			e"+tabela[piStage][0]+"();%n"+
						"		}%n"
					);
					for(int j=1;j<cAlpha-1;j++){
						gravarArq.printf(
							"		else if(f.substring(p,p+1).equals("+(char)34+alpha[j]+(char)34+")){%n"+
							"			p++;%n"+
							"			e"+tabela[piStage][j]+"();%n"+
							"		}%n"
						);
					}
					gravarArq.printf(
						"		else{%n"+
						"			rejeita();%n"+
						"		}%n"+
						"	}%n"
					);
				}
				else if(entre(i,pfStage)){
					gravarArq.printf(
							"	static void e"+stage[i]+"(){%n"+
							"		if(f.substring(p,p+1).equals("+(char)34+alpha[0]+(char)34+")){%n"+
							"			p++;%n"+
							"			e"+tabela[i][0]+"();%n"+
							"		}%n"
						);
						for(int j=1;j<cAlpha-1;j++){
							gravarArq.printf(
								"		else if(f.substring(p,p+1).equals("+(char)34+alpha[j]+(char)34+")){%n"+
								"			p++;%n"+
								"			e"+tabela[i][j]+"();%n"+
								"		}%n"
							);
						}
						gravarArq.printf(
							"		else if(f.substring(p,p+1).equals("+(char)34+"!"+(char)34+")){%n"+
							"			aceita();%n"+
							"		}%n"+
							"		else{%n"+
							"			rejeita();%n"+
							"		}%n"+
							"	}%n"+
							"}"
						);
				}
				else{
					gravarArq.printf(
						"	static void e"+stage[i]+"(){%n"+
						"		if(f.substring(p,p+1).equals("+(char)34+alpha[0]+(char)34+")){%n"+
						"			p++;%n"+
						"			e"+tabela[i][0]+"();%n"+
						"		}%n"
					);
					for(int j=1;j<cAlpha-1;j++){
						gravarArq.printf(
							"		else if(f.substring(p,p+1).equals("+(char)34+alpha[j]+(char)34+")){%n"+
							"			p++;%n"+
							"			e"+tabela[i][j]+"();%n"+
							"		}%n"
						);
					}
					gravarArq.printf(
						"		else{%n"+
						"			rejeita();%n"+
						"		}%n"+
						"	}%n"
					);
				}
			}
			arq.close();
		}
		catch(Exception e){
			System.out.println("Erro: "+ e);
		}
	}
}