import java.util.ArrayList;

public class Grafo {

	// Construtor que monta o grafo
	public Grafo(String[] matriz) {
		montaMatriz(matriz);
		montaVertices();
		montaArestas();
	}

	// Construtor vazio
	public Grafo() {

	}

	String nome;
	ArrayList<Aresta> listaAresta;
	ArrayList<Vertice> listaVertice;
	int[][] matrizAdjac;

	// Retorna o nome do meu grafo
	public String getNome() {
		return nome;
	}

	// Retorna minha lista de vertices
	public ArrayList<Vertice> getVertices() {
		return listaVertice;
	}

	// Retorna minha lista de arestas
	public ArrayList<Aresta> getArestas() {
		return listaAresta;
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
		for (int l = 0; l < Math.sqrt(matrizAdjac.length); l++) {
			v = new Vertice();
			v.setNome(nome);
			nome++;
			// Percorrendo as colunas da Matriz de adjacencia
			for (int c = 0; l < Math.sqrt(matrizAdjac.length); c++) {
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

	// Monta a lista de arestas com a matriz de adjacencia.
	private void montaArestas() {
		Aresta a;
		for (int l = 0; l < Math.sqrt(matrizAdjac.length); l++) {
			for (int c = 0; c < Math.sqrt(matrizAdjac.length); c++) {
				a = new Aresta();
				a.setNome(matrizAdjac[l][c]);
				listaAresta.add(a);
			}
		}
	}
}
