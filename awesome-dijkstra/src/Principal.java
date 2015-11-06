import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

	public static void main(String[] args) throws IOException {

		String nome = null;
		while (nome == null || nome.equals("")) {
			nome = JOptionPane
					.showInputDialog("Coloque o arquivo .CSV com a matriz de adjacencia no diretorio raiz do projeto. \nPara informa o nome do arquivo, voce deve seguir o exemplo abaixo:\nEX: Grafo Trabalho Dijkstra.csv\n\n\nQual o nome do arquivo?");
			if (nome == null || nome.equals("")) {
				JOptionPane.showMessageDialog(null,
						"Voce nao respondeu a pergunta.");
			}
		}
		try {
			Grafo g = new Grafo(lerArquivoCVS(nome));
			JOptionPane.showMessageDialog(null,
					"Para conferir o resultado favor verificar o arquivo .txt no diretorio raiz do projeto.\n\nAlgoritmo de Dijkstra executado com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Arquivo invalido!");
		}
	}
}
