#! /usr/bin/python
import networkx
G=networkx.Graph()
G.add_node(1)
G.add_node(2)

G.add_edges_from( ((2,2), (2,1), (1,1)) )

print "number of edges", G.size()
print "number of nodes", G.number_of_nodes()
print G.nodes()
print G.edges()

test
