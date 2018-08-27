package FuncoesGerais;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextArea;

import Connectors.*;

public class Logger {
	
	private List<String> RowString = new LinkedList<String>();
	private MySQL banco;
	private Thread logger;
	private boolean status = true;
	private JTextArea log;
	
	public void setLog(JTextArea log) {
		this.log = log;
	}
	private void printNoDB(String arg) {
		log.setText( log.getText()+"\n"+ "|"+new Date().toString()+"|	|"+arg);
		System.out.println("|"+new Date().toString()+"|	|"+arg);
	}
	public void println(String arg){
		log.setText( log.getText()+"\n"+ "|"+new Date().toString()+"|	|"+arg);
		RowString.add("|"+new Date().toString()+"|	|"+arg);
		System.out.println("|"+new Date().toString()+"|	|"+arg);
	}
	public Logger(){
		logger = new Thread(t1);
	}
	public void start() {
		logger.start();
	}
	public void stop() {
		this.status = false;
	}
	private Runnable t1 = new Runnable() {
		public void run() {
			banco = new MySQL("localhost", "3306", "logs", "root", "************");
			try {
				banco.openConnection();
				if(banco.checkConnection()) {
					printNoDB("Conexão com o banco aberta");
					
					String texto = null;

					while(texto!=null || status) {
						try {
							System.out.printf("");
							if(!RowString.isEmpty()) {
								texto = RowString.remove(0);
							}
							else {
								texto = null;
							}
							if(texto!=null) {
								texto = texto.replace("\\", "/").replace("'", "");
								banco.updateSQL("insert into logs.logforbrunarobots (dia,hora,texto) values(curdate(),curtime(),'"+texto+"');");
							}
						}
						catch (Exception e) {
							e.printStackTrace();
							printNoDB("ERRO ao inserir no banco insert into logs.logforbrunarobots (dia,hora,texto) values(curdate(),curtime(),'"+texto+"'); "+e);
						}
					}
					try {
						banco.closeConnection();
						printNoDB("Conexão OFF....................");
					}
					catch (Exception e) {
						printNoDB("ERRO na conexao com o banco "+e);
						System.exit(2);
					}
				}
			}
			catch (Exception e) {
				String stackTrace = "";
				for(int i=0;i<e.getStackTrace().length;i++) {
					stackTrace = stackTrace + e.getStackTrace()[i] + "\n";
				}
				printNoDB("ERRO na conexao com o banco " + stackTrace);
			}
		}
	};
}