import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {

	// Converte o vertice digitado em indice numerico
	private static int converteCharinIndex(char[] valor) {
		char aux = 'A';
		int index = 0;
		while (valor[0] != aux) {
			aux++;
			index++;
		}
		return index;
	}

	// Le o arquivo do tipo .CVS e monta um vetor de String com os valores
	// recebidos do arquivo
	private static String[] lerArquivoCVS(String arquivo) {
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
			JOptionPane.showMessageDialog(null, "Arquivo invalido! Tente novamente.");
			menuPrincipal();
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

	// Cria grafo com base na matriz lida no arquivo .CSV
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

	// Menu principal
	private static String[] menuPrincipal() {
		String[] listaAdjacencia = null;
		String nome = null;

		while (nome == null || nome.equals("")) {
			nome = JOptionPane.showInputDialog(
					"                    INFORMAÇÕES IMPORTANTES!\nPara o funcionamento do sistema, seu arquivo .CSV\ncontendo a matriz deve estar no diretorio raiz do projeto.\n\nDigite o nome do seu arquivo .CSV.");
			if (nome == null) {
				System.exit(0);
			} else if (nome.equals("")) {
				JOptionPane.showMessageDialog(null, "Voce não respondeu a pergunta!");

			}
		}
		try {
			listaAdjacencia = lerArquivoCVS(nome);
		} catch (Exception e) {
			System.out.println("Erro ao ler arquivo: " + e);
		}
		return listaAdjacencia;
	}

	public static void main(String[] args) throws IOException, VerticeException {
		// Criação dos parametros utilizados
		char[] verticeIncial;
		String valorAux = null;
		int index;
		Vertice v = null;
		Grafo g = criarGrafo(menuPrincipal());

		// Menu secundario para escolha de vertice inicial
		while (valorAux == null || valorAux.equals("")) {
			valorAux = JOptionPane.showInputDialog(
					"       INFORMAÇÕES IMPORTANTES!\n  Para o funcionamento do sistema\nVocê deve digitar apenas uma letra.\n\nVertice inicial:");
			valorAux.toUpperCase();
			verticeIncial = valorAux.toCharArray();
			index = converteCharinIndex(verticeIncial);
			if (verticeIncial == null) {
				System.exit(0);
			} else if (verticeIncial.equals("")) {
				JOptionPane.showMessageDialog(null, "Voce não respondeu a pergunta!");
			}

			// Validação do vertice (Vertice existente ou inexistente).
			if (index < g.numVertices()) {
				v = g.getVertice(index);
			} else {
				JOptionPane.showMessageDialog(null, "Vertice inexistente na matriz!");
				menuPrincipal();
			}

			// Execução do algoritimo de Dijkstra
			GrafoUtil.buscaProfundidade(v);
			GrafoUtil.resetStatus(g);
			GrafoUtil.buscaLargura(v);
			GrafoUtil.resetStatus(g);
			GrafoUtil.dijkstra(v);
			GrafoUtil.imprimeMenorCaminho(g);
		}
	}
}
