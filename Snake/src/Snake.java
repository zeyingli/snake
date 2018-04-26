
/**
 *
 * @author GR10: Zeying, Tiancheng, Cheng, Jingyi
 */

import java.util.Iterator;
import java.util.LinkedList;

public class Snake {

    private LinkedList<Node> OuCheng = new LinkedList();

    public Node move(Direction coordinations) {
        // Update Snake body based on direction
        // Return previous tail before moving

        Node n;
        switch (coordinations) {
            case UP:
                n = new Node(this.getHead().getX(), this.getHead().getY() - Settings.DEFAULT_NODE_SIZE);
                break;
            case DOWN:
                n = new Node(this.getHead().getX(), this.getHead().getY() + Settings.DEFAULT_NODE_SIZE);
                break;
            case RIGHT:
                n = new Node(this.getHead().getX() + Settings.DEFAULT_NODE_SIZE, this.getHead().getY());
                break;
            default:
                n = new Node(this.getHead().getX() - Settings.DEFAULT_NODE_SIZE, this.getHead().getY());
                break;
        }

        Node r = this.OuCheng.getLast();
        this.OuCheng.addFirst(n);
        this.OuCheng.removeLast();

        System.out.println(this.OuCheng.getFirst());
        System.out.println(this.OuCheng.getLast());

        return r;
    }

  
   

    // Determine if snake has node
    public boolean hasNode(Node node) {
        Iterator<Node> iter = OuCheng.iterator();
        Node n = new Node(0, 0);

        while (iter.hasNext()) {
            n = iter.next();
            if (n.getX() == node.getX() && n.getY() == node.getY()) {
                return true;
            }
        }
        return false;
    }
      // Get Head Node
     public Node getHead() {
        return OuCheng.getFirst();
    }

    // Add Tail Node
    public Node addTail(Node area) {
        this.OuCheng.addLast(area);
        return area;
    }

    // Return body
    public LinkedList<Node> getBody() {
        return OuCheng;
    }
}
