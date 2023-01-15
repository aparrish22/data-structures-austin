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
    
    def __init__(self,vertices = [],edges = []) -> None:
        self.edges = self._cast_list(edges, dict)
        self.vertices = self._cast_list(vertices, dict)
    
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
    
    def __init__(self,vertices = [], edges = []):
        self.graph = Graph(vertices,edges)
        
    def create_graph(self):
        for n in self.graph.vertices:
            self.matrix = np.zeros( (n,n), dtype=np.int64)
            self._populate_graph(self.matrix)
            
    def _populate_graph(self, m):
        try:
            for row in m:
                for col in row:
                    pass
                
        except Exception as err:
            print(f"Unexpected {err=}, {type(err)=}")
            err.add_note("Try adding vertices to the graph. ")
            raise
            
            
    def print_graph(self):
        pass
        
            
            
class Main:
    
    if __name__=="__main__":
        cities_list = ["Glasgow","Bowling Green","Nashville","Lexington"]
        cities = list()
        for city in cities_list:
            cities.append(City(city))
            
        for city in cities:
            print(city.name)
            
        vertices = list()
        for city in cities:
            vertices.append(Vertex(city))
            
        matrix = Matrix()
            
        for vertex in vertices:
            matrix.graph.insert_vertex(vertex)