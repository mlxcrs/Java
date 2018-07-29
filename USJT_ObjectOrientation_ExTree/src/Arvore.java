/* a) Implementar uma agenda usando arvores binarias ordenadas (conforme o material didatico) e testar,
   b) Implementar o algoritmo de exclusao de elementos da agenda a partir do elemento,
      - void exclui (string nome),
      - Node exlcuiAux (Node raiz, string nome),
   c) Implementar o algoritmo de identificacao da altura da arvore,
      - int altura()
      - int alturaAux (Node raiz)   
      desafio ( nao precisa entregar ):
      - contar elemento,
      - mostrar so nos folhas,
      - contar nos folhas,
*/
class Arvore {
	class Node {
		String nome;
		String fone;
		Node linke,linkd;
	}
	Node raiz;
	Arvore ( ) {
		raiz = null;
	}
	void IncListaFone (String nm, String fn){
		raiz = IncAux(raiz, nm, fn);
	}
	Node IncAux (Node raiz, String nm, String fn){
		if(raiz == null){
			Node aux = new Node();
			aux.nome = nm; aux.fone = fn;
			aux.linke = null; aux.linkd = null;
			return aux;
		}
		else{
			if(raiz.nome.compareTo(nm)>0){
				raiz.linke = IncAux(raiz.linke, nm, fn);
				return raiz;
			}
			else if(raiz.nome.compareTo(nm)<0){
				raiz.linkd = IncAux(raiz.linkd, nm, fn);
				return raiz;
			}
			else{
				System.out.println("Nome ja existe!");
				return raiz;
			}
		}
	}
	void preOrdem(){
		System.out.print("PreOrdem: [");
		preOrdemAux(raiz);
		System.out.println(" ]");
	}
	void preOrdemAux(Node raiz){
		if(raiz !=null){
			System.out.print(" "+raiz.nome);
			preOrdemAux(raiz.linke);
			preOrdemAux(raiz.linkd);
		}
	}
	void emOrdem(){
		System.out.print("EmOrdem: [");
		emOrdemAux(raiz);
		System.out.println(" ]");
	}
	void emOrdemAux(Node raiz){
		if(raiz !=null){
			emOrdemAux(raiz.linke);
			System.out.print(" "+raiz.nome);
			emOrdemAux(raiz.linkd);
		}
	}
	void posOrdem(){
		System.out.print("PosOrdem: [");
		posOrdemAux(raiz);
		System.out.println(" ]");
	}
	void posOrdemAux(Node raiz){
		if(raiz !=null){
			posOrdemAux(raiz.linke);
			posOrdemAux(raiz.linkd);
			System.out.print(" "+raiz.nome);
		}
	}
	Node buscar(String nm, Node raiz){
		if(raiz.nome.equals(nm)){
			return raiz;
		}
		else{
			if(raiz.nome.compareTo(nm)>0){
				raiz.linke = buscar(nm,raiz.linke);
				return raiz.linke;
			}
			else if(raiz.nome.compareTo(nm)<0){
				raiz.linkd = buscar(nm,raiz.linkd);
				return raiz.linkd;
			}
			else{
				return null;
			}
		}
	}
	Node busAnt(String nm, Node raiz){
		if(raiz.linkd!=null){
			if(raiz.linkd.nome.equals(nm)){
				return raiz;
			}
			else{
				if(raiz.nome.compareTo(nm)>0){
					raiz.linke = busAnt(nm,raiz.linke);
					return raiz.linke;
				}
				else{
					raiz.linkd = busAnt(nm,raiz.linkd);
					return raiz.linkd;
				}
			}
		}
		else if(raiz.linke!=null){
			if(raiz.linke.nome.equals(nm)){
				return raiz;
			}
			else{
				if(raiz.nome.compareTo(nm)>0){
					raiz.linke = busAnt(nm,raiz.linke);
					return raiz.linke;
				}
				else{
					raiz.linkd = busAnt(nm,raiz.linkd);
					return raiz.linkd;
				}
			}
		}
		return raiz;
	}
	void excluir(String nm){
		Node aux2 = buscar(nm,raiz);
		if(aux2==raiz){
			if(raiz.linke==null && raiz.linkd==null){
				raiz=null;
			}
		}
		if(raiz!=null){
			if(aux2!=null){
				if(aux2.linke!=null){
					Node aux = aux2.linke;
					if(aux.linkd!=null){
						while(aux.linkd.linkd!=null){
							aux = aux.linkd;
						}
						aux2.nome = aux.linkd.nome;
						aux2.fone = aux.linkd.fone;
						aux.linkd = aux.linkd.linke;
					}
					else{
						aux2.nome = aux2.linke.nome;
						aux2.fone = aux2.linke.fone;
						aux2.linke = aux2.linke.linke;
					}
				}
				else if(aux2.linkd!=null){
					Node aux = aux2.linkd;
					if(aux.linke!=null){
						while(aux.linke.linke!=null){
							aux = aux.linke;
						}
						aux2.nome = aux.linke.nome;
						aux2.fone = aux.linke.fone;
						aux.linke = aux.linke.linkd;
					}
					else{
						aux2.nome = aux2.linkd.nome;
						aux2.fone = aux2.linkd.fone;
						aux2.linkd = aux2.linkd.linkd;
					}
				}
				else{
					Node aux = busAnt(nm,raiz);
					if(aux.linkd!=null){
						if(aux.linkd.nome.equals(nm)){
							aux.linkd = null;
						}
					}
					else{
						aux.linke=null;
					}
				}
			}
			else{
				System.out.println("O nome nao foi encontrado!");
			}
		}
	}
	int altura(){
		return alturaAux(raiz);
	}
	int alturaAux(Node raiz) {
		int u, v;
		if (raiz == null){
			return 0;
		}
		u = alturaAux(raiz.linke);
		v = alturaAux(raiz.linkd);
		if (u > v){
			return u+1;
		}
		else{
			return v+1;
		}
	}
		void contar(){
		System.out.println("A arvore contem "+contarAux(raiz)+"itens.");
	}
	int contarAux(Node raiz){
		if(raiz==null){
			return 0;
		}
		else{
			return 1 + contarAux(raiz.linke) + contarAux(raiz.linkd);
		}
	}
	void mostrarNosFolha(){
		System.out.print("Nos Folhas:[");
		mostrarNosFolhaAux(raiz);
		System.out.println("]");
	}
	void mostrarNosFolhaAux(Node aux){
		if(aux!=null){
			mostrarNosFolhaAux(aux.linke);
			if(aux.linke==null && aux.linkd==null){
				System.out.print(" "+aux.nome+" ");
			}
			mostrarNosFolhaAux(aux.linkd);
		}
	}
	void contarNosFolha(){
		System.out.println("A arvore tem "+contarNosFolhaAux(raiz)+" nos folha.");
	}
	int contarNosFolhaAux(Node aux){
		if(aux==null){
			return 0;
		}
		else if(aux.linke==null && aux.linkd==null){
			return 1;
		}
		else{
			return contarNosFolhaAux(aux.linke) + contarNosFolhaAux(aux.linkd);
		}
	}
	public static void main(String[] args) {
		Arvore a1 = new Arvore( );
		a1.IncListaFone("Lidia","011 9999999");
		a1.IncListaFone("Marcio","011 8888888");
		a1.IncListaFone("Marcelo","011 7777777");
		System.out.println("-------------------------------------");
		a1.emOrdem();
		a1.contarNosFolha();
		a1.mostrarNosFolha();
		a1.contar();
		System.out.println("A altura da arvore eh: "+a1.altura());
		System.out.println("-------------------------------------");
		a1.excluir("Marcio");
		a1.emOrdem();
		a1.contarNosFolha();
		a1.mostrarNosFolha();
		a1.contar();
		System.out.println("A altura da arvore eh: "+a1.altura());
		System.out.println("-------------------------------------");
		a1.excluir("Lidia");
		a1.emOrdem();
		a1.contarNosFolha();
		a1.mostrarNosFolha();
		a1.contar();
		System.out.println("A altura da arvore eh: "+a1.altura());
		System.out.println("-------------------------------------");
		a1.excluir("Marcelo");
		a1.emOrdem();
		a1.contarNosFolha();
		a1.mostrarNosFolha();
		a1.contar();
		System.out.println("A altura da arvore eh: "+a1.altura());
	}
}
