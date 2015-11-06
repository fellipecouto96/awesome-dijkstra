import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

	/**
	 * @param args
	 *
	 */
	public static void main(String[] args) {

	}

	public static String[] lerArquivoCVS(String arquivo) {
		BufferedReader buffer = null;
		String linha = "";
		String csvDivisor = ";";
		String[] adjacencia = null;

		try {
			buffer = new BufferedReader(new FileReader(arquivo));

			while ((linha = buffer.readLine()) != null) {
				adjacencia =linha.split(csvDivisor);
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
