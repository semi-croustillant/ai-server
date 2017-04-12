package com.gameServer.ModelBO;/**
 * Created by Guillaume on 12/04/2017.
 */

import org.apache.log4j.Logger;

/**
 * {Insert class description here}
 */
public class GameBO {

    private static final Logger log = Logger.getLogger(GameBO.class);


    /**
     * Creates a new instance of GameBO
     */
    private int[][] grid;
    private int score;
    private int score_vs;
    private int win;
    private MoveBO last_move;
    private int weight;

    public GameBO() {
    }

    public GameBO(int[][] grid, int score, int score_vs, int win, MoveBO last_move, int weight) {
        this.grid = grid;
        this.score = score;
        this.score_vs = score_vs;
        this.win = win;
        this.last_move = last_move;
        this.weight = weight;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
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

    public int getWin() {
        return win;
    }

    public MoveBO getLast_move() {
        return last_move;
    }

    public void setLast_move(MoveBO last_move) {
        this.last_move = last_move;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public void setScore_vs(int score_vs) {
        this.score_vs = score_vs;
    }
}
