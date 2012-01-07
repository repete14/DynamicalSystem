package mk.test;

import mk.dynamic.network.Node;
import static org.junit.Assert.*;

/**
 *
 * @author mkirschner
 */
public class NodeTest {
    @org.junit.Test public void nodeConstructor() {
        Node n1 = new Node();
        n1.setState(23.0);
        
        Node n2 = new Node();
        n2.setState(49.0);
        
        assertTrue(n1.getState() == 23.0);
    }
}
