import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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

	public static void executaBuscaProfundidade(Vertice vertice) throws VerticeException {

		for (Aresta aresta : vertice.getArestas()) {
			if (aresta.getStatus().equals(UNVISITED)) {
				Vertice w = Grafo.opposite(vertice, aresta);
				if (w.getStatus().equals(UNVISITED)) {
					aresta.setStatus(VISITED);
					w.setStatus(VISITED);
					if (go) {
						System.out.println();
						go = false;
					}
					System.out.print("-> IDA E:" + aresta.getPeso() + " V:" + w.getId() + "-" + w.getName() + " ");
					back = true;
					executaBuscaProfundidade(w);
					if (back) {
						System.out.println();
						back = false;
					}
					System.out.print(
							"-> VOLTA E:" + aresta.getPeso() + " V:" + vertice.getId() + "-" + vertice.getName() + " ");
					go = true;
				}
			}
		}
	}

	public static void buscaLargura(Vertice vertice) throws VerticeException {
		System.out.println("\n\nBUSCA POR LARGURA DO GRAFO");
		Queue<Vertice> queue = new LinkedList<Vertice>();
		queue.add(vertice);
		System.out.print("INICIO = V:" + vertice.getId() + "-" + vertice.getName());
		while (!queue.isEmpty()) {
			Vertice v = queue.remove();
			System.out.print("\nFIM = V:" + v.getId() + "-" + v.getName());
			for (Aresta e : v.getArestas()) {
				if (e.getStatus().equals(UNVISITED)) {
					Vertice w = Grafo.oposto(v, e);
					if (w.getStatus().equals(UNVISITED)) {
						e.setStatus(VISITED);
						w.setStatus(VISITED);
						queue.add(w);
						System.out.print(" -> GO = E:" + e.getPeso() + " V:" + w.getId() + "-" + w.getName());
					}
				}
			}
		}
		System.out.println();
	}

	public static void resetStatus(Grafo grafo) {
		for (int i = 0; i < grafo.arestas().size(); i++) {
			grafo.arestas().get(i).setStatus(UNVISITED);
		}
		for (int i = 0; i < grafo.vertices().size(); i++) {
			grafo.vertices().get(i).setStatus(UNVISITED);
		}
	}

	public static void dijkstra(Vertice init) throws VerticeException {
		System.out.println("\n\nDIJKSTRA PARA GRAFO");

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

	public static List<Vertice> getMenorCaminho(Vertice target) {
		List<Vertice> path = new ArrayList<Vertice>();
		for (Vertice vertice = target; vertice != null; vertice = vertice.getAnterior()) {
			path.add(vertice);
		}
		Collections.reverse(path);
		return path;
	}

	public static void imprimeMenorCaminho(Grafo grafo) {
		System.out.println("IMPRIME MENOR CAMINHO");
		for (Vertice v : grafo.vertices()) {
			System.out.println("Distancia até " + v.getName() + ": " + v.getDist());
			List<Vertice> path = getMenorCaminho(v);
			System.out.println("Caminho: " + path);
		}
	}
}
