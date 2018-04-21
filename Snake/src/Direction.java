/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chengou
 */
public enum Direction {
    UP(0),
    RIGHT(1),
    DOWN(2),
    LEFT(3);

    private final int direction;

    public int controlDirection() {
        return direction;
    }

    Direction(int direction) {
        this.direction = direction;
    }

}
