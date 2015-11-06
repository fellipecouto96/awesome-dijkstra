import java.awt.List;
import java.util.ArrayList;

public class Vertice {

	public Vertice() {
		listaAresta = new ArrayList<>();
		listaVizinhos = new ArrayList<>();
	}

	char nome;
	ArrayList<Aresta> listaAresta;
	int qntVizinhos;
	ArrayList<Object> listaVizinhos;

	public char getNome() {
		return nome;
	}

	public ArrayList<Object> getVizinhos() {
		return listaVizinhos;
	}

	public void setNome(char vertice) {
		nome = vertice;
	}

	public void setVizinho(char v) {
		listaVizinhos.add(v);
	}
	
	public void setArestas(Aresta a) {
		listaAresta.add(a);
	}
}
