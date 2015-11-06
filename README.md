# awesome-dijkstra
Algoritmos que calcula o caminho de custo mínimo entre vértices de um grafo.  :runner:

### Algoritmo de Dijkstra

O algoritmo Dijkstra soluciona o problema do caminho mais curto em um grafo dirigido ou não dirigido. O algoritmo recebe como entrada um grafo valorado e gera como saída um conjunto S de menores caminhos a partir de um vértice inicial.
Em Redes de Computadores, a Camada de Rede (3ª camada do modelo OSI) utiliza do algoritmo do menor caminho de Dijkstra para realizar o roteamento de pacotes. Através disso, você deverá implementar o algoritmo de Dijkstra para um topologia de rede qualquer (grafo valorado), onde os roteadores distribuídos dessa rede são representados pelos vértices do grafo. A distância dos roteadores são representados pelas arestas valoradas dos grafos.
Um grafo é representado por uma matriz, onde as linhas e colunas representam os vértices do grafo e as arestas valoradas são representadas pelos valores da matriz.

### Solução

O programa desenvolvido gera como saída o conjunto S do algoritmo de Dijkstra a partir de um grafo estipulado pelo usuário. Portanto, o programa lê a matriz de dados de um arquivo .csv onde as colunas da matriz serão separadas por ';' e gera como saída um arquivo .txt com o conjunto S.

#### Apoio

O link http://www.inf.ufsc.br/grafos/temas/custo-minimo/dijkstra.html explica de forma detalhada o algoritmo de Dijkstra.
