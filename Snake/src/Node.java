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
    
}
