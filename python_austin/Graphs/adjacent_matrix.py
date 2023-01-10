import numpy as np

class Vertex:
    
    edges = []
    
    def __init__(self, element):
        self.has_edge = False
        self.element = element
        
class City:
    
    def __init__(self, name) -> None:
        self.name = name
    
class Graph:
    
    edges = []
    vertices = []    
    
    def __init__(self) -> None:
        self.edges = self._cast_list(self.edges, dict)
        self.vertices = self._cast_list(self.vertices, dict)
    
    def _cast_list(self, my_list, data_type):
        return list(map(data_type, my_list))
    
    def insert_edge(self, v1: Vertex, v2: Vertex, weight: int):
        if v1 in self.vertices and v2 in self.vertices:
            self.edges.append(
                {"Start" : v1, "Destination" : v2, "Weight" : "{weight}"}
            )
        
    def insert_vertex(self, vertex):
        self.vertices.append({"Name" : vertex})
        
        
class Matrix:
    matrix = []
    
    def __init__(self):
        self.graph = Graph()
        
    def create_graph(self):
        for n in self.graph.vertices:
            self.matrix = np.zeros( (n,n), dtype=np.int64)
            
    def populate_graph(self):
        try:
            pass #TODO
        except Exception as err:
            print(f"Unexpected {err=}, {type(err)=}")
            err.add_note("Try adding vertices to the graph. ")
            raise
            
            
    def print_graph(self):
        
        
            
            
class Main:
    
    if __name__=="__main__":
        print("test")