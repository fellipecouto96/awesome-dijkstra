import java.util.ArrayList;

public class Grafo {

	public Grafo() {
	}

	String nome;
	ArrayList<Aresta> listaAresta;
	ArrayList<Vertice> listaVertice;
	int[][] matrizAdjac;

	public String getNome() {
		return nome;
	}

	public ArrayList<Vertice> getVertices() {
		return listaVertice;
	}

	public ArrayList<Aresta> getArestas() {
		return listaAresta;
	}

	public void montaMatriz(String[] matriz) {
		int qntVertice = (int) Math.sqrt(matriz.length);
		int aux = 0;

		matrizAdjac = new int[qntVertice][qntVertice];
		for (int x = 1; x <= qntVertice; x++) {
			for (int y = 1; y <= qntVertice; y++) {
				matrizAdjac[x][y] = Integer.parseInt(matriz[aux]);
				aux ++;
			}
		}
	}
}
