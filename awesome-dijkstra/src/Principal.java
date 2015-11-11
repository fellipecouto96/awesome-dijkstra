import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

	// Le o arquivo do tipo .CVS e monta um vetor de String com os valores
	// recebidos do arquivo
	public static String[] lerArquivoCVS(String arquivo) {
		BufferedReader buffer = null;
		String linha = "";
		String csvDivisor = ";";
		String[] adjacencia = null;

		try {
			buffer = new BufferedReader(new FileReader(arquivo));
			String linhaAux = "";
			while ((linha = buffer.readLine()) != null) {
				linhaAux = linhaAux + linha + ";";
			}
			adjacencia = linhaAux.split(csvDivisor);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (buffer != null) {
				try {
					buffer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return adjacencia;
	}

	// Monta minha matriz de adjacencia
	private static int[][] montaMatriz(String[] matriz, int qntVertice) {
		int[][] matrizAdjac = new int[qntVertice][qntVertice];
		int aux = 0;

		for (int x = 0; x < qntVertice; x++) {
			for (int y = 0; y < qntVertice; y++) {
				matrizAdjac[x][y] = Integer.parseInt(matriz[aux]);
				aux++;
			}
		}
		return matrizAdjac;
	}

	private static Grafo criarGrafo(String[] adjacencia) throws VerticeException {
		Grafo g = new Grafo();
		Vertice v;
		ArrayList<Vertice> listaVertice = new ArrayList<>();
		int numeroVertices = (int) Math.sqrt(adjacencia.length);
		char nomeVertice = 'A';
		int[][] matriz = montaMatriz(adjacencia, numeroVertices);

		for (int x = 0; x < numeroVertices; x++) {
			v = g.insertVertice(x, nomeVertice);
			listaVertice.add(x, v);
			nomeVertice++;
		}

		for (int l = 0; l < numeroVertices; l++) {
			for (int c = 0; c < numeroVertices; c++) {
				if (matriz[l][c] != 0) {
					g.insertAresta(listaVertice.get(l), listaVertice.get(c), matriz[l][c]);
				}
			}
		}

		return g;
	}

	private static String[] menuPrincipal() {
		String[] listaAdjacencia = null;
		String nome = null;

		while (nome == null || nome.equals("")) {
			nome = JOptionPane.showInputDialog(
					"Coloque o arquivo .CSV com a matriz de adjacencia no diretorio raiz do projeto. \nPara informa o nome do arquivo, voce deve seguir o exemplo abaixo:\nEX: Grafo Trabalho Dijkstra.csv\n\n\nQual o nome do arquivo?");
			if (nome == null || nome.equals("")) {
				JOptionPane.showMessageDialog(null, "Voce nao respondeu a pergunta.");
			}
			listaAdjacencia = lerArquivoCVS(nome);
		}
		try {
			JOptionPane.showMessageDialog(null,
					"Para conferir o resultado favor verificar o arquivo .txt no diretorio raiz do projeto.\n\nAlgoritmo de Dijkstra executado com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Arquivo invalido!");
		}
		return listaAdjacencia;
	}

	public static void main(String[] args) throws IOException, VerticeException {
		Grafo g = criarGrafo(menuPrincipal());

		Vertice v = g.getVertice(0);
		
		GrafoUtil.dijkstra(v);
	}
}
