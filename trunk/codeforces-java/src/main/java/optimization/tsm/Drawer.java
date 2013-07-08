package optimization.tsm;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import com.google.common.collect.Maps;
import com.mxgraph.util.mxCellRenderer;
import com.mxgraph.util.mxUtils;
import com.mxgraph.util.mxXmlUtils;
import com.mxgraph.view.mxGraph;

public class Drawer {

    public void visualize(List<Point> input, Result result) {
        mxGraph graph = new mxGraph();

        graph.getModel().beginUpdate();
        Object defaultParent = graph.getDefaultParent();

        Map<String, Object> nodes = Maps.newHashMap();

        for (Point p : input) {
            String id = id(p);
            Object v = graph.insertVertex(defaultParent, id, id, p.getX(), p.getY(), 10, 10);
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
