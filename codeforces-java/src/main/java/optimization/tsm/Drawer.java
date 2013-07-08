package optimization.tsm;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import com.google.common.collect.Maps;
import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxCellRenderer;
import com.mxgraph.util.mxUtils;
import com.mxgraph.util.mxXmlUtils;
import com.mxgraph.view.mxGraph;

public class Drawer {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final String VERTEX_STYLE = "defaultVertex;strokeColor=black;fillColor=white;rounded=true";
    
    public void visualize(List<Point> input, Result result) {
        mxGraph graph = new mxGraph();

        double maxX = -1;
        double maxY = -1;

        for (Point p : input) {
            if (maxX < p.getX()) {
                maxX = p.getX();
            }
            if (maxY < p.getY()) {
                maxY = p.getY();
            }
        }

        graph.getModel().beginUpdate();
        Object defaultParent = graph.getDefaultParent();

        Map<String, mxCell> nodes = Maps.newHashMap();

        for (Point p : input) {
            String id = id(p);
            mxCell v = (mxCell) graph.insertVertex(defaultParent, id, id, p.getX() * WIDTH / maxX, p.getY() * HEIGHT / maxY, 20,
                    20, VERTEX_STYLE);
            nodes.put(id, v);
        }

        List<Point> path = result.getPath();
        Iterator<Point> iterator = path.iterator();
        Point prev = iterator.next();
        Point first = prev;

        while (iterator.hasNext()) {
            Point next = iterator.next();
            graph.insertEdge(defaultParent, null, null, nodes.get(id(prev)), nodes.get(id(next)));
            prev = next;
        }

        graph.insertEdge(defaultParent, null, null, nodes.get(id(prev)), nodes.get(id(first)));

        nodes.get(id(first)).setStyle("defaultVertex;strokeColor=black;fillColor=red;rounded=true");
        graph.getModel().endUpdate();

        exportSvg(graph, ".\\graph.svg");

    }

    private void exportSvg(mxGraph graph, String filename) {
        try {
            Document document = mxCellRenderer.createSvgDocument(graph, null, 1, null, null);
            mxUtils.writeFile(mxXmlUtils.getXml(document), filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String id(Point p) {
        return String.valueOf(p.getNumber());
    }
}
