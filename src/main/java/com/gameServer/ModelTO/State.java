package com.gameServer.ModelTO;/**
 * Created by Guillaume on 11/04/2017.
 */
import java.io.Serializable;
import java.util.ArrayList;

/**
 * {Insert class description here}
 */
public class State implements Serializable {
    private static final long serialVersionUID = 1L;

    private int[][] board;
    private int score;
    private int score_vs;
    private int player;

    /**
     * Creates a new instance of State
     */
    public State() {
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
}
