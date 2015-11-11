
public class VerticeException extends Exception {

	private static final long serialVersionUID = 1L;

	public static String ID_DUPLICATED = "ID_DUPLICATED";

	public static String ID_NO_EXIST = "ID_NO_EXIST";

	public VerticeException(String ex, Object valor) {
		if (ID_DUPLICATED.equals(ex)) {
			System.out.println("Error: ID Vertice " + valor + " duplicado.");
		} else if (ID_NO_EXIST.equals(ex)) {
			System.out.println("Error: ID não existe para Vertice.");
		} else {
			System.out.println("Error: Vertice.");
		}
	}
}
