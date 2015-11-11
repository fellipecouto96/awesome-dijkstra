import java.util.ArrayList;
import java.util.List;

public class Vertice implements Comparable<Vertice> {

	private List<Vertice> adjacentes = new ArrayList<Vertice>();

	private List<Aresta> arestas = new ArrayList<Aresta>();

	private Integer id;

	private char nome;

	private int dist = Integer.MAX_VALUE;

	private Vertice anterior;

	private String status = GrafoUtil.UNVISITED;

	public Vertice(Integer id, char nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getGrau() {
		return this.adjacentes.size();
	}

	public List<Vertice> getAdjacents() {
		return adjacentes;
	}

	public void setAdjacents(List<Vertice> adjacentes) {
		this.adjacentes = adjacentes;
	}

	public void addAdjacents(Vertice adjacentes) {
		this.adjacentes.add(adjacentes);
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aresta insertAresta(Vertice w, Integer o) {
		Aresta e = new Aresta();
		e.setV1(this);
		e.setV2(w);
		e.setPeso(o);
		this.arestas.add(e);
		return e;
	}

	public Aresta insertAresta(Vertice w, Aresta e, Integer weigth) {
		e.setV1(w);
		e.setV2(this);
		e.setPeso(weigth);
		this.arestas.add(e);
		return e;
	}

	public void removeAllArestas() {
		this.arestas = new ArrayList<Aresta>();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vertice) {
			if (this.id.equals(((Vertice) obj).getId())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "(Vertice ID:" + id + "-" + nome + ", grau:" + getGrau() + ")";
	}

	public int compareTo(Vertice other) {
		return Double.compare(dist, other.getDist());
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDist() {
		return dist;
	}

	public void setDist(int dist) {
		this.dist = dist;
	}

	public Vertice getAnterior() {
		return anterior;
	}

	public void setAnterior(Vertice anterior) {
		this.anterior = anterior;
	}

	public char getName() {
		return nome;
	}

	public void setName(char nome) {
		this.nome = nome;
	}
}
