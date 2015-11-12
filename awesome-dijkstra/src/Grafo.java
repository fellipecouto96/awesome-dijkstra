import java.util.ArrayList;
import java.util.List;

public class Grafo {
	private int numVertices = 0;
	private int numArestas = 0;
	private List<Vertice> vertices = new ArrayList<Vertice>();
	private List<Aresta> arestas = new ArrayList<Aresta>();

	public Vertice getVertice(Integer id) {
		for (Vertice v : vertices) {
			if (v.getId().equals(id)) {
				return v;
			}
		}
		return null;
	}

	public int numVertices() {
		return numVertices;
	}

	public int numArestas() {
		return numArestas;
	}

	public List<Vertice> vertices() {
		return vertices;
	}

	public List<Aresta> arestas() {
		return arestas;
	}

	public Vertice aVertice() {
		return null;
	}

	public int degree(Vertice v) {
		return v.getGrau();
	}

	// Retorna lista de adjacencia do Vertice
	public List<Vertice> adjacentVertices(Vertice v) {
		return v.getAdjacents();
	}

	// Retorna lista de incidencia do Vertice
	public List<Aresta> incidentArestas(Vertice v) {
		return v.getArestas();
	}

	// Retorna ponta das arestas
	public List<Vertice> endVertices(Aresta e) {
		List<Vertice> vs = new ArrayList<Vertice>();
		vs.add(e.getV1());
		vs.add(e.getV2());
		return vs;
	}

	public static Vertice oposto(Vertice v, Aresta e) throws VerticeException {
		// retorna o ponto final da aresta e diferente de v.
		for (Aresta edge : v.getArestas()) {
			if (edge.equals(e)) {
				if (v.equals(edge.getV1())) {
					return edge.getV2();
				} else {
					return edge.getV1();
				}
			}
		}
		throw new VerticeException(VerticeException.ID_NO_EXIST, null);
	}

	public boolean areAdjacent(Vertice v, Vertice w) {
		// retorna true se v e w sao adjacentes
		for (Vertice vertex : v.getAdjacents()) {
			if (vertex.equals(w)) {
				return true;
			}
		}
		return false;
	}

	// Insere uma nova aresta ao grafo
	public Aresta insertAresta(Vertice v, Vertice w, Integer weigth) {
		Aresta e = v.insertAresta(w, weigth);
		w.insertAresta(v, e, weigth);
		v.addAdjacents(w);
		w.addAdjacents(v);
		arestas.add(e);
		numArestas++;
		return e;
	}

	// Insere um novo vertice ao grafo
	public Vertice insertVertice(Integer id, char name) throws VerticeException {
		for (Vertice vertex : vertices) {
			if (vertex.getId().equals(id)) {
				throw new VerticeException(VerticeException.ID_DUPLICATED, id);
			}
		}
		Vertice v = new Vertice(id, name);
		vertices.add(v);
		numVertices++;
		return v;
	}

	// Remove um vertice do grafo
	public void removeVertice(Vertice v) {
		// remove o vertice v e todas as suas arestas incidentes
		vertices.remove(v);
		numVertices--;
		v.removeAllArestas();
	}

	// Remove uma aresta do grafo
	public void removeAresta(Aresta e) {
		// remove a aresta e
		e.setV1(null);
		e.setV2(null);
		arestas.remove(e);
	}
}
