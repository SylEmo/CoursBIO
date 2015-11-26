package test;
import java.util.*;

import org.jgrapht.*;
import org.jgrapht.generate.*;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.*;


public final class CompleteGraphDemo
{
    

    static Graph<Object, DefaultEdge> completeGraph;

    //Number of vertices
    static int size = 10;

    

    public static void main(String [] args)
    {
        //Create the graph object; it is null at this point
        completeGraph = new SimpleGraph<Object, DefaultEdge>(DefaultEdge.class);

        //Create the CompleteGraphGenerator object
        CompleteGraphGenerator<Object, DefaultEdge> completeGenerator =
            new CompleteGraphGenerator<Object, DefaultEdge>(size);

        //Create the VertexFactory so the generator can create vertices
        VertexFactory<Object> vFactory =
            new ClassBasedVertexFactory<Object>(Object.class);

        //Use the CompleteGraphGenerator object to make completeGraph a
        //complete graph with [size] number of vertices
        completeGenerator.generateGraph(completeGraph, vFactory, null);

        //Now, replace all the vertices with sequential numbers so we can ID
        //them
        Set<Object> vertices = new HashSet<Object>();
        vertices.addAll(completeGraph.vertexSet());
        Integer counter = 0;
        for (Object vertex : vertices) {
            replaceVertex(vertex, (Object) counter++);
        }

        //Print out the graph to be sure it's really complete
        Iterator<Object> iter =
            new DepthFirstIterator<Object, DefaultEdge>(completeGraph);
        Object vertex;
        while (iter.hasNext()) {
            vertex = iter.next();
            System.out.println(
                "Vertex " + vertex.toString() + " is connected to: "
                + completeGraph.edgesOf(vertex).toString());
        }
    }

    public static boolean replaceVertex(Object oldVertex, Object newVertex)
    {
        if ((oldVertex == null) || (newVertex == null)) {
            return false;
        }
        Set<DefaultEdge> relatedEdges = completeGraph.edgesOf(oldVertex);
        completeGraph.addVertex(newVertex);

        Object sourceVertex;
        Object targetVertex;
        for (DefaultEdge e : relatedEdges) {
            sourceVertex = completeGraph.getEdgeSource(e);
            targetVertex = completeGraph.getEdgeTarget(e);
            if (sourceVertex.equals(oldVertex)
                && targetVertex.equals(oldVertex))
            {
                completeGraph.addEdge(newVertex, newVertex);
            } else {
                if (sourceVertex.equals(oldVertex)) {
                    completeGraph.addEdge(newVertex, targetVertex);
                } else {
                    completeGraph.addEdge(sourceVertex, newVertex);
                }
            }
        }
        completeGraph.removeVertex(oldVertex);
        return true;
    }
}
