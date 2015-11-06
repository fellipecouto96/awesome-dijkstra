import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;

public class Principal extends JFrame {

	public static void main(String[] args) throws IOException {
		//Escrendo e lendo Console
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  
		System.out.print("Digite o diretorio do arquivo: ");
		String str = in.readLine(); 
		
		//Manipulando os dados do Arquivo
		Grafo g = new Grafo(lerArquivoCVS(str));
		System.out.println(g.getVertices());
	}

	// Lê o arquivo do tipo .CVS e monta um vetor de String com os valores
	// recebidos do arquivo
	public static String[] lerArquivoCVS(String arquivo) {
		BufferedReader buffer = null;
		String linha = "";
		String csvDivisor = ";";
		String[] adjacencia = null;

		try {
			buffer = new BufferedReader(new FileReader(arquivo));

			while ((linha = buffer.readLine()) != null) {
				adjacencia = linha.split(csvDivisor);
			}

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

}
