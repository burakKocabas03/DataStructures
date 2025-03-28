import networkx as nx
import matplotlib.pyplot as plt
# Düğümler ve Kenarlar
nodes = ["Olivia", "Celine", "Winston", "Chloe", "John", "Jack"]
edges = [("Olivia", "Celine", 8), ("Olivia", "Jack", 4), ("Olivia", "John", 7),
         ("Jack", "Celine", 5), ("Jack", "John", 9), ("Jack", "Chloe", 5),
         ("Jack", "Winston", 7), ("John", "Chloe", 7), ("Chloe", "Winston", 11),
         ("Winston", "Celine", 6)]

# Graf oluştur
G = nx.Graph()
G.add_nodes_from(nodes)
G.add_weighted_edges_from(edges)


def dijkstra_path(graph):
    distances = {}
    for person1 in graph.nodes:
        for person2 in graph.nodes:
            if person1 != person2:
                distance = nx.dijkstra_path_length(graph, source=person1, target=person2)
                distances[(person1, person2)] = distance
    return distances


def dfs_traversal(graph, start_node):
    return list(nx.dfs_edges(graph, source=start_node))


def bfs_traversal(graph, start_node):
    return list(nx.bfs_edges(graph, source=start_node))

def draw_graph(graph):
    pos = nx.spring_layout(graph)  # Düğümleri yerleştirme algoritması
    nx.draw(graph, pos, with_labels=True, font_weight='bold', node_size=700, node_color='lightblue', font_size=8)
    labels = nx.get_edge_attributes(graph, 'weight')
    nx.draw_networkx_edge_labels(graph, pos, edge_labels=labels)

    plt.show()


# Uzaklıkları hesapla ve yazdır
distances = dijkstra_path(G)
print("Uzaklıklar:")
for key, value in distances.items():
    print(f"{key}: {value}")

# DFS ve BFS dolaşma yollarını hesapla ve yazdır
start_node = "Olivia"
dfs_path = dfs_traversal(G, start_node)
bfs_path = bfs_traversal(G, start_node)

print(f"\nDFS Dolaşma Yolu ({start_node} başlangıçlı): {dfs_path}")
print(f"BFS Dolaşma Yolu ({start_node} başlangıçlı): {bfs_path}")
draw_graph(G)

