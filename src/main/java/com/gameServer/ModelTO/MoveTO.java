package com.gameServer.ModelTO;

/**
 * Created by Guillaume on 03/01/2017.
 */

import com.gameServer.ModelBO.MoveBO;

/**
 * {Insert class description here}
 */
public class MoveTO {

    private int x;
    private int y;

    public MoveTO(){
    }

    /**
     * Constructor
     *
     */
    public MoveTO(int pX, int pY){
        setX(pX);
        setY(pY);
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
