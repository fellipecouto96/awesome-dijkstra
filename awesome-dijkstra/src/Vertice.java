import java.util.ArrayList;

public class Vertice {

	public Vertice() {
	}

	String nome;
	ArrayList<Aresta> listaAresta;
	ArrayList<Vertice> listaVizinhos;

	public String getNome() {
		return nome;
	}

	public ArrayList<Vertice> getVizinhos() {
		return listaVizinhos;
	}
}
