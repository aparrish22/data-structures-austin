import numpy as np

class Node:
    
    edges = []
    
    def __init__(self, element):
        self.has_edge = False
        self.element = element
        
    def insert_edge(self, node, weight):
        self.edges.append({node : weight})
        self.has_edge = True
            
        
class Matrix:
    
    def __init__(self):
        self.matrix = np.zeros( (3,3), dtype=np.int64) # placeholder for now