import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

import javax.swing.*;

import org.jgraph.*;
import org.jgraph.graph.*;
import org.jgrapht.*;
import org.jgrapht.ext.*;
import org.jgrapht.graph.*;
import org.jgrapht.graph.DefaultEdge;

/**
 * @author Sylvain EMONET & Baptiste TRULLA
 *
 */
public class SuffixTree extends JApplet {

	private static final long serialVersionUID = 3256444702936019250L;
    private static final Color DEFAULT_BG_COLOR = Color.decode("#FAFBFF");
    private static final int WIDHT = 800;
    private static final int HEIGHT = 800;
    private static final Dimension DEFAULT_SIZE = new Dimension(WIDHT, HEIGHT);

    private String sequence;

    //
    private JGraphModelAdapter<String, DefaultEdge> jgAdapter;

    

    /**
     * An alternative starting point for this demo, to also allow running this
     * applet as an application.
     *
     * @param args ignored.
     */
    public SuffixTree(String sequence)
    {
        this.sequence = sequence;
    }
    
    public void showMeThings() {
    	SuffixTree applet = new SuffixTree(sequence);
        applet.init();

        JFrame frame = new JFrame();
        frame.getContentPane().add(applet);
        frame.setTitle("Arbre de suffixe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * {@inheritDoc}
     */
    public void init()
    {
        // create a JGraphT graph
        ListenableGraph<String, DefaultEdge> g =
            new ListenableDirectedMultigraph<String, DefaultEdge>(
                DefaultEdge.class);

        // create a visualization using JGraph, via an adapter
        jgAdapter = new JGraphModelAdapter<String, DefaultEdge>(g);

        JGraph jgraph = new JGraph(jgAdapter);

        adjustDisplaySettings(jgraph);
        getContentPane().add(jgraph);
        resize(DEFAULT_SIZE);

        String rootNode = "_";
        g.addVertex(rootNode);
        positionVertexAt(rootNode, 360, 0);
        int profondeur = 1, largeur = 1;
        
        g.addVertex(sequence);
        g.addEdge(rootNode, sequence);
        positionVertexAt(sequence, 360, 100);
        profondeur++;
        
        String currentSubSequence = "";
        ArrayList<String> subSequencesAdded = new ArrayList<String>();
        int indexListSubSeq = 0, j = 0, matchedChar = 0;
        for (int i = 1; i < sequence.length(); i++) {
			currentSubSequence = sequence.substring(i);
			indexListSubSeq = 0;
			j = 0;
			matchedChar = 0;
			while(indexListSubSeq < subSequencesAdded.size()) {
				while(currentSubSequence.charAt(j) == 
						subSequencesAdded.get(indexListSubSeq).charAt(j) &&
						j < currentSubSequence.length()) {
					j++;
					matchedChar++;
				}
				if(matchedChar > 0) {
					
				}
			}
		}

        
        positionVertexAt(sequence, 200, 100);

        // that's all there is to it!...
    }

    private void adjustDisplaySettings(JGraph jg)
    {
        jg.setPreferredSize(DEFAULT_SIZE);

        Color c = DEFAULT_BG_COLOR;
        String colorStr = null;

        try {
            colorStr = getParameter("bgcolor");
        } catch (Exception e) {
        }

        if (colorStr != null) {
            c = Color.decode(colorStr);
        }

        jg.setBackground(c);
    }

    @SuppressWarnings("unchecked") 
    private void positionVertexAt(Object vertex, int x, int y)
    {
        DefaultGraphCell cell = jgAdapter.getVertexCell(vertex);
        AttributeMap attr = cell.getAttributes();
        Rectangle2D bounds = GraphConstants.getBounds(attr);

        Rectangle2D newBounds =
            new Rectangle2D.Double(
                x,
                y,
                bounds.getWidth(),
                bounds.getHeight());

        GraphConstants.setBounds(attr, newBounds);

        // TODO: Clean up generics once JGraph goes generic
        AttributeMap cellAttr = new AttributeMap();
        cellAttr.put(cell, attr);
        jgAdapter.edit(cellAttr, null, null, null);
    }

    

    /**
     * a listenable directed multigraph that allows loops and parallel edges.
     */
    private static class ListenableDirectedMultigraph<V, E>
        extends DefaultListenableGraph<V, E>
        implements DirectedGraph<V, E>
    {
        private static final long serialVersionUID = 1L;

        ListenableDirectedMultigraph(Class<E> edgeClass)
        {
            super(new DirectedMultigraph<V, E>(edgeClass));
        }
    }

}
