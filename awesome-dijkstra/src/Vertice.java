import java.util.ArrayList;

public class Vertice {

	ArrayList<Aresta> listaAresta;

	ArrayList<Object> listaVizinhos;
	char nome;
	int qntVizinhos;
	public Vertice() {
		listaAresta = new ArrayList<>();
		listaVizinhos = new ArrayList<>();
	}

	public char getNome() {
		return nome;
	}

	public ArrayList<Object> getVizinhos() {
		return listaVizinhos;
	}

	public void setArestas(Aresta a) {
		listaAresta.add(a);
	}

	public void setNome(char vertice) {
		nome = vertice;
	}
	
	public void setVizinho(char v) {
		listaVizinhos.add(v);
	}
}
