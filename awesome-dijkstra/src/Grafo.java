import java.util.ArrayList;

public class Grafo {

	ArrayList<Aresta> listaAresta;

	ArrayList<Vertice> listaVertice;

	int[][] matrizAdjac;
	String nome;
	// Construtor vazio
	public Grafo() {

	}
	// Construtor que monta o grafo
	public Grafo(String[] matriz) {
		listaAresta = new ArrayList<>();
		listaVertice = new ArrayList<>();
		montaMatriz(matriz);
		montaVertices();
		montaArestas();
	}

	// Retorna minha lista de arestas
	public ArrayList<Aresta> getArestas() {
		return listaAresta;
	}

	// Retorna o nome do meu grafo
	public String getNome() {
		return nome;
	}

	// Retorna minha lista de vertices
	public ArrayList<Vertice> getVertices() {
		return listaVertice;
	}

	// Monta a lista de arestas com a matriz de adjacencia.
	private void montaArestas() {
		Aresta a;
		for (int l = 0; l < matrizAdjac.length; l++) {
			for (int c = 0; c < matrizAdjac.length; c++) {
				a = new Aresta();
				a.setNome(matrizAdjac[l][c]);
				listaAresta.add(a);
			}
		}
	}

	// Monta minha matriz de adjacencia
	private void montaMatriz(String[] matriz) {
		int qntVertice = (int) Math.sqrt(matriz.length);
		int aux = 0;

		matrizAdjac = new int[qntVertice][qntVertice];
		for (int x = 0; x < qntVertice; x++) {
			for (int y = 0; y < qntVertice; y++) {
				matrizAdjac[x][y] = Integer.parseInt(matriz[aux]);
				aux++;
			}
		}
	}

	// Monta a lista de vertices com a primeira linha da matriz
	private void montaVertices() {
		Vertice v;
		Aresta a;
		char nome = 'A';

		// Percorrendo as linhas da matriz de adjacencia
		for (int l = 0; l < matrizAdjac.length; l++) {
			v = new Vertice();
			v.setNome(nome);
			nome++;
			// Percorrendo as colunas da Matriz de adjacencia
			for (int c = 0; c < matrizAdjac.length; c++) {
				if (matrizAdjac[l][c] != 0) {

					// Inserindo a aresta na lista de arestas
					a = new Aresta();
					a.setNome(matrizAdjac[l][c]);
					v.setArestas(a);

					// Inserindo o vizinho na lista de vizinhos
					char nomeVizinho = 'A';
					nomeVizinho = (char) (nomeVizinho + c);
					v.setVizinho(nomeVizinho);
				}
			}
			listaVertice.add(v);
		}
	}
}
