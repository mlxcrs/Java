package FuncoesGerais;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Arquivo {
	
	//Lib Arquivos
	//Copiar Arquivos
	public static boolean copiaArquivo(File origem, File destino, boolean deleta) {
			if (deleta){
				if (destino.delete()){
					System.out.println("Arquivo "+destino+" foi deletado.");
				}
			}
			try {
				InputStream in = new FileInputStream(origem);
				OutputStream out = new FileOutputStream(destino);
			    byte[] buf = new byte[1024];
			    int len;
			    while ((len = in.read(buf)) > 0) {
			    	out.write(buf, 0, len);
			    }
			    in.close();
			    out.close();
			    return true;
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
				return false;
			} catch (IOException e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
	//Download Arquivos
	//Verifica se caminho de URL existe
	/*public boolean existe(String stringUrl, String pathLocal) {
			//String url = stringUrl;
			//String path = pathLocal;
			criaPasta(pathLocal);

			URL url = null;
			try {
				url = new URL(stringUrl);
			} catch (Exception e) {
				System.out.println("Erro do URL");
			}
			String nomeArquivoLocal = url.getPath();
			nomeArquivoLocal = nomeArquivoLocal.replaceAll("/", "");
			if(new File(pathLocal+nomeArquivoLocal).exists()) {
				return true;
			}
			return false;
		}

	//Grava Arquivo URL
			public boolean gravaArquivoDeURL(String stringUrl, String pathLocal, boolean uName, String Name) {
			try {
				//String url = stringUrl;
				//String path = pathLocal;
				System.out.println("Downloading "+url+" at "+path);
				URL url = new URL(this.url);
				String nomeArquivoLocal = url.getPath();
				nomeArquivoLocal = nomeArquivoLocal.replaceAll("/", "");
				java.io.InputStream is = url.openStream();
				FileOutputStream fos;
				if(uName){
					fos = new FileOutputStream(this.path+Name);
				}else{
					fos = new FileOutputStream(this.path+nomeArquivoLocal);
				}
				int umByte = 0;
				while ((umByte = is.read()) != -1){
					fos.write(umByte);
				}
				is.close();
				fos.close();
				return true;
			} 
			catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} */


	//Criar Pasta
	public static boolean criaPasta(String arg) {
			File pasta = new File(arg);
	        if(pasta.isDirectory()) {
	        	System.out.println("A pasta "+arg+" ja existe");
	        	return true;
	        }
	        else {
	        	if(pasta.mkdir()) {
	        		System.out.println("A pasta "+arg+" foi criada");
	        		return true;
	        	}
	        }
			return false;
		}
	
	//Retorna string c/ conteudo de arquivo
	public static String getText(File caminho) {
		try {
			FileReader arq = new FileReader(caminho);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			String conteudo = "";
			while (linha != null) {
				conteudo = conteudo + linha;
				linha = lerArq.readLine();
			}
			arq.close();
			return conteudo;
		}
		catch (IOException e){
			System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
		return null;
		}
	}

//Retorna string c/ conteudo de arquivo - com quebra de linha
	public static String getBreakText(File caminho) {
		try {
			FileReader arq = new FileReader(caminho);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			String conteudo = "";
			while (linha != null) {
				conteudo = conteudo +" \n"+linha;
				linha = lerArq.readLine();
			}
			arq.close();
			return conteudo;
		}
		catch (IOException e){
			System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
		return null;
		}
	}

//Escreve linha em arquivo
	@SuppressWarnings("resource")
	public static void writeLine(File n,String text) throws IOException{
		new PrintWriter(new FileWriter(n)).println(text);
	}
}
