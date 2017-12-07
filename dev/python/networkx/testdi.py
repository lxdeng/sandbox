#! /usr/bin/python

# -*- coding: utf-8 -*-
"""
Created on Sat Nov 11 15:29:04 2017

@author: rhoenigman
"""

import networkx as nx

#create a directed graph
G = nx.DiGraph()

#adding an edge also adds the node
G.add_edge('Spider', 'A', weight=1.0)

print "nodes:", G.nodes()
print "edges:", G.edges()
