import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.JOptionPane;

public class GrafoUtil {
	public static String VISITED = "VISITED";

	public static String UNVISITED = "UNVISITED";

	public static String RETURN = "RETURN";

	public static String CROSS = "CROSS";

	public static List<String> stack = new ArrayList<String>();

	private static boolean go = true;

	private static boolean back = true;

	public static void buscaProfundidade(Vertice vertice) throws VerticeException {
		vertice.setStatus(VISITED);
		executaBuscaProfundidade(vertice);
	}

	// Executa busca por profundidade apartir de um vertice passado por
	// parametro
	public static void executaBuscaProfundidade(Vertice vertice) throws VerticeException {

		for (Aresta aresta : vertice.getArestas()) {
			if (aresta.getStatus().equals(UNVISITED)) {
				Vertice w = Grafo.oposto(vertice, aresta);
				if (w.getStatus().equals(UNVISITED)) {
					aresta.setStatus(VISITED);
					w.setStatus(VISITED);
					if (go) {
						System.out.println();
						go = false;
					}
					back = true;
					executaBuscaProfundidade(w);
					if (back) {
						System.out.println();
						back = false;
					}
					go = true;
				}
			}
		}
	}

	// Executa busca por largura apartir de um vertice passado por parametro
	public static void buscaLargura(Vertice vertice) throws VerticeException {
		Queue<Vertice> queue = new LinkedList<Vertice>();
		queue.add(vertice);
		while (!queue.isEmpty()) {
			Vertice v = queue.remove();
			for (Aresta e : v.getArestas()) {
				if (e.getStatus().equals(UNVISITED)) {
					Vertice w = Grafo.oposto(v, e);
					if (w.getStatus().equals(UNVISITED)) {
						e.setStatus(VISITED);
						w.setStatus(VISITED);
						queue.add(w);
					}
				}
			}
		}
	}

	// Reseta o status de visitas de um grafo
	public static void resetStatus(Grafo grafo) {
		for (int i = 0; i < grafo.arestas().size(); i++) {
			grafo.arestas().get(i).setStatus(UNVISITED);
		}
		for (int i = 0; i < grafo.vertices().size(); i++) {
			grafo.vertices().get(i).setStatus(UNVISITED);
		}
	}

	// Executa o algoritimo de menor encaminhamento Dijkstra
	public static void dijkstra(Vertice init) throws VerticeException {
		init.setDist(0);
		PriorityQueue<Vertice> queue = new PriorityQueue<Vertice>();
		queue.add(init);

		while (!queue.isEmpty()) {
			Vertice u = queue.poll();

			for (Aresta e : u.getArestas()) {
				Vertice v = Grafo.oposto(u, e);
				int peso = e.getPeso();
				int distanciaEntre = u.getDist() + peso;
				if (distanciaEntre < v.getDist()) {
					queue.remove(v);
					v.setDist(distanciaEntre);
					v.setAnterior(u);
					queue.add(v);
				}
			}
		}
	}

	// Pega o menor caminho de um vertice
	public static List<Vertice> getMenorCaminho(Vertice target) {
		List<Vertice> path = new ArrayList<Vertice>();
		for (Vertice vertice = target; vertice != null; vertice = vertice.getAnterior()) {
			path.add(vertice);
		}
		Collections.reverse(path);
		return path;
	}

	// Imprime o menor caminho de um vertice em um arquivo .TXT
	public static void imprimeMenorCaminho(Grafo grafo) throws IOException {
		FileWriter arq = new FileWriter("Dijkstra.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		Vertice vertice;
		// Imprime Cabeçalho
		gravarArq.printf("+--    MENOR CAMINHO - Algoritmo de Dijkstra   --+%n");
		for (Vertice v : grafo.vertices()) {
			gravarArq.printf("%nDistancia até " + v.getName() + ": " + v.getDist());
			List<Vertice> path = getMenorCaminho(v);
			gravarArq.printf(" | Caminho: ");
			for (int x = 0; x < path.size(); x++) {
				vertice = path.get(x);
				gravarArq.print(vertice.getName());
				if (x < path.size() - 1) {
					gravarArq.printf(" -> ");
				}
			}
		}
		// Rodape
		gravarArq.printf("%n%n+------------------------------------------------+%n");
		// Fecha arquivo
		arq.close();
		JOptionPane.showMessageDialog(null,
				"Para conferir o resultado\nVerificar o arquivo Dijkstra.txt no diretorio raiz do projeto.\n\nAlgoritmo de Dijkstra executado com sucesso!");
	}
}
