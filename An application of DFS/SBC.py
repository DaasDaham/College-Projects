#!/usr/bin/env python3

import re
import itertools

ROLLNUM_REGEX = "201[0-9]{4}"

class Graph(object):
    name = "Saad Ahmad"
    email = "saad18409@iiitd.ac.in"
    roll_num = "2018409"

    def __init__ (self, vertices, edges, allPaths=[]):
        """
        Initializes object for the class Graph

        Args:
            vertices: List of integers specifying vertices in graph
            edges: List of 2-tuples specifying edges in graph
        """

        self.vertices = vertices
        
        ordered_edges = list(map(lambda x: (min(x), max(x)), edges))
        
        self.edges    = ordered_edges
 
        self.allPaths = allPaths   
        self.validate()

    def dictionary(self, vertix, edge):
        self.vertix = vertix
        self.edge = edge
        dic = {}
        for i in self.vertix:
            for j in self.edge:
                if j[0] == i:
                    dic.setdefault(i,[]).append(j[1])
                elif j[1] == i:
                    dic.setdefault(i,[]).append(j[0])
                else:
                    continue 
        return dic


    def validate(self):
        """
        Validates if Graph if valid or not

        Raises:
            Exception if:
                - Name is empty or not a string
                - Email is empty or not a string
                - Roll Number is not in correct format
                - vertices contains duplicates
                - edges contain duplicates
                - any endpoint of an edge is not in vertices
        """

        if (not isinstance(self.name, str)) or self.name == "":
            raise Exception("Name can't be empty")

        if (not isinstance(self.email, str)) or self.email == "":
            raise Exception("Email can't be empty")

        if (not isinstance(self.roll_num, str)) or (not re.match(ROLLNUM_REGEX, self.roll_num)):
            raise Exception("Invalid roll number, roll number must be a string of form 201XXXX. Provided roll number: {}".format(self.roll_num))

        if not all([isinstance(node, int) for node in self.vertices]):
            raise Exception("All vertices should be integers")

        elif len(self.vertices) != len(set(self.vertices)):
            duplicate_vertices = set([node for node in self.vertices if self.vertices.count(node) > 1])

            raise Exception("Vertices contain duplicates.\nVertices: {}\nDuplicate vertices: {}".format(vertices, duplicate_vertices))

        edge_vertices = list(set(itertools.chain(*self.edges)))

        if not all([node in self.vertices for node in edge_vertices]):
            raise Exception("All endpoints of edges must belong in vertices")

        if len(self.edges) != len(set(self.edges)):
            duplicate_edges = set([edge for edge in self.edges if self.edges.count(edge) > 1])

            raise Exception("Edges contain duplicates.\nEdges: {}\nDuplicate vertices: {}".format(edges, duplicate_edges))

    def all_paths(self, dic, node, destination, vis=[]):
        """
        Args:
            node: Node to find path from
            destination: Node to reach
            dist: Allowed distance of path
            path: path already traversed
        Returns:
            List of path, where each path is list ending on destination
            Returns None if there no paths
        """
        vis = vis + [node]
        for i in dic[node]:
            if i == destination:
                vis = vis + [destination]
                self.allPaths = self.allPaths + [vis]
                return self.allPaths
            elif i not in vis:
                self.all_paths(dic, i, destination, vis)
            elif len(list(set(dic[node])-set(vis))) == 0:
                continue
        vis.pop()
        return self.allPaths

    def min_dist(self, vert, edg, start_node, end_node):
        '''
        Finds minimum distance between start_node and end_node

        Args:
            start_node: Vertex to find distance from
            end_node: Vertex to find distance to

        Returns:
            An integer denoting minimum distance between start_node
            and end_node
        '''
        self.start_node = start_node
        self.end_node = end_node
        start = self.start_node
        end = self.end_node
        dic = self.dictionary(vert, edg)
        t = self.all_paths(dic=dic, node=start, destination=end)
        minimum = len(t[0])
        for i in t:
            if len(i) < minimum:
                minimum = len(i)
        return minimum

    def all_shortest_paths(self, v, e, start_node, end_node):
        """
        Finds all shortest paths between start_node and end_node

        Args:
            start_node: Starting node for paths
            end_node: Destination node for paths

        Returns:
            A list of path, where each path is a list of integers.
        """
        self.start_node = start_node
        self.end_node = end_node
        start = self.start_node
        end = self.end_node
        dic = self.dictionary(v, e)
        dist = self.min_dist(v, e, start, end)
        lst = self.all_paths(dic, start, end)
        shortestpaths = []
        for i in lst:
            if len(i) == dist:
                shortestpaths += [i]
        return shortestpaths

    def betweenness_centrality(self, node):
        """
        Find betweenness centrality of the given node

        Args:
            node: Node to find betweenness centrality of.

        Returns:
            Single floating point number, denoting betweenness centrality
            of the given node
        """
        self.node = node
        vertex = self.node
        tempvertices = list(self.vertices)
        tempvertices.remove(vertex)
        temp2edge = []
        for i in tempvertices:
            for j in tempvertices:
                if i != j and i < j:
                    temp2edge.append((i,j))
        centralityScore = 0
        for i in temp2edge:
            count_y = 0  
            count_x = 0
            s = self.all_shortest_paths(self.vertices, self.edges, i[0], i[1])  
            for j in s:
                if vertex in j:
                    count_y += 1
                count_x += 1
                self.allPaths = []
            centralityScore += (count_y/count_x)

        return centralityScore    

    def top_k_betweenness_centrality(self,k):
        """
        Find top k nodes based on highest equal betweenness centrality.

        
        Returns:
            List a integer, denoting top k nodes based on betweenness
            centrality.
        """
        self.k = k
        N = len(self.vertices)
        divValue = ((N-1)*(N-2))/2
        finallist = []
        for i in self.vertices:
            value = self.betweenness_centrality(i)
            finallist += [[i,value/divValue]]
        finallist.sort(key=lambda x: x[1], reverse=True)
        temp=[]
        for i in range(k):
            temp+= [finallist[i]]
        return temp

        


if __name__ == "__main__":
    vertices = [1, 2, 3, 4, 5, 6]
    edges = [(1,2), (1,5), (2,3), (2,5), (3,4), (3,6), (4,5), (4,6)]
    graph = Graph(vertices, edges)
    sbcOrder = graph.top_k_betweenness_centrality(4)
    print('Decreasing order of SBC '+ str(sbcOrder))
