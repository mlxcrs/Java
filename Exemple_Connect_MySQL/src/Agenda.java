
public class Agenda {
	public static void main(String[] args){
		BancoDeDados dados = new BancoDeDados();
		dados.conectar();
		if(dados.estaConectado()){
			//dados.listarContato();
			//dados.inserirContato("Lucas", "123456789");
			//dados.editarContato("2", "Mateus Lucas", "11 981251715");
			//dados.apagarContato("1");
			dados.listarContato();
			dados.desconectar();
		}
		else{
			System.out.println("Não foi possivel conectar ao banco de dados.");
		}
	}
}