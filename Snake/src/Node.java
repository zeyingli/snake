/**
 *
 * @author GR10: Zeying, Tiancheng, Cheng, Jingyi
 */
public class Node {
    
    private final int x;
    private final int y;
    
    public Node (int x, int y)
    {
        this.x = ((int) (x/10)) * 10;
        this.y = ((int) (y/10)) * 10;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    @Override
    public boolean equals(Object n)
    {
        Node t;
        if (n instanceof Node)
        {
            t = (Node) n;
            if (t.getX() == this.getX() && t.getY() == this.getY())
            {
                return true;
            }
        }
        return false; 
    }
    
    @Override
    public String toString()
    {
        return String.valueOf(x) + ' ' + String.valueOf(y);
    }
}
