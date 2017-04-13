package com.gameServer.ModelTO;/**
 * Created by Guillaume on 11/04/2017.
 */

import com.gameServer.ModelBO.GameBO;
import com.gameServer.ModelBO.MoveBO;

/**
 * {Insert class description here}
 */
public class GameTO {

    private int[][] board;
    private int score;
    private int score_vs;
    private int player;
    private int round;
    /**
     * Creates a new instance of State
     */
    public GameTO() {
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore_vs() {
        return score_vs;
    }

    public void setScore_vs(int score_vs) {
        this.score_vs = score_vs;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public GameBO toBO(){

        return new GameBO(board,getScore(),getScore_vs(),0,new MoveBO(),0);
    }
}
