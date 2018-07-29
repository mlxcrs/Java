import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class BancoDeDados {
	private Connection con = null;
	private Statement sta = null;
	private ResultSet res = null;
	
	public void conectar(){
		String servidor = "jdbc:mysql://localhost:3306/";
		String schema = "agenda";
		String usuario = "root";
		String driver = "com.mysql.jdbc.Driver";
		String senha = "******";
		try{
			Class.forName(driver);
			this.con = DriverManager.getConnection(servidor+schema,usuario,senha);
			this.sta = this.con.createStatement();
		}
		catch(Exception e){
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	public boolean estaConectado(){
		if (this.con != null){
			return true;
		}
		else{
			return false;
		}
	}
	public void listarContato(){
		try{
			String cmd = "SELECT * FROM contato ORDER BY nome";
			this.res = this.sta.executeQuery(cmd);
			while(this.res.next()){
				System.out.println("ID: "+ this.res.getString("id") + " - Nome: " + 
									this.res.getString("nome") + " - telefone: " + 
									this.res.getString("telefone"));
				System.out.println();
			}
		}
		catch(Exception e){
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	public void inserirContato(String nome, String fone){
		try{
			String cmd = "INSERT INTO contato (nome,telefone) values ('"+nome+"','"+fone+"');";
			this.sta.executeUpdate(cmd);
		}
		catch(Exception e){
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	public void editarContato(String id, String nome, String fone){
		try{
			String cmd = "UPDATE contato SET nome = '"+nome+"',telefone='"+fone+"' WHERE id = "+id+";";
			this.sta.executeUpdate(cmd);
		}
		catch(Exception e){
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	public void apagarContato(String id){
		try{
			String cmd = "DELETE FROM contato WHERE id = "+id+";";
			this.sta.executeUpdate(cmd);
		}
		catch(Exception e){
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	public void desconectar(){
		try{
			this.con.close();
		}
		catch(Exception e){
			System.out.println("Erro: "+ e.getMessage());
		}
	}
}