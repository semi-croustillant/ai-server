package com.gameServer.IA;/**
 * Created by Guillaume on 11/04/2017.
 */

import com.gameServer.ModelTO.Move;
import com.gameServer.ModelTO.State;

/**
 * {Insert class description here}
 */
public class IA {

    private int depth;
    private State state;

    /**
     * Creates a new instance of MinMax
     */
    public IA() {
    }

    public IA(State pState, int pDepth){
       setState(pState);
       setDepth(pDepth);
    }


    public Move play(){

        return new Move();
    }

    private void next_move(){

    }

    private int getScore(){
        return 0;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
