import java.awt.List;
import java.util.ArrayList;

public class Vertice {

	public Vertice() {
	}

	char nome;
	ArrayList<Aresta> listaAresta;
	char[] listaVizinhos;

	public char getNome() {
		return nome;
	}

	public char[] getVizinhos() {
		return listaVizinhos;
	}

	public void setNome(char vertice) {
		nome = vertice;
	}

	public void setVizinho(char v) {
		listaVizinhos[listaVizinhos.length] = v;
	}
	
	public void setArestas(Aresta a) {
		listaAresta.add(a);
	}
}
