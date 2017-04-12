package com.gameServer.ModelBO;/**
 * Created by Guillaume on 12/04/2017.
 */

import com.gameServer.ModelTO.MoveTO;
import org.apache.log4j.Logger;

/**
 * {Insert class description here}
 */
public class MoveBO {

    private static final Logger log = Logger.getLogger(MoveBO.class);

    private int x;
    private int y;
    private int player;
    /**
     * Creates a new instance of MoveBO
     */
    public MoveBO() {
        setX(-1);
        setY(-1);
        setPlayer(-1);
    }

    public MoveBO(int pX, int pY, int pPlayer){
        setX(pX);
        setY(pY);
        setPlayer(pPlayer);
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

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public MoveTO toTO(){
        return new MoveTO(getX(),getY());
    }
}
