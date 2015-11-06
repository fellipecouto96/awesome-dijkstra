public class Dijkstra implements Comparable<Dijkstra> {

	private Integer distance;
	private Character id;

	public Dijkstra(Character id, Integer distance) {
		super();
		this.id = id;
		this.distance = distance;
	}

	@Override
	public int compareTo(Dijkstra o) {
		return this.distance < o.distance ? -1
				: this.distance == o.distance ? 0 : 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dijkstra other = (Dijkstra) obj;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getDistance() {
		return distance;
	}

	public Character getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public void setId(Character id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Dijkstra [id=" + id + ", distance=" + distance + "]";
	}

}
