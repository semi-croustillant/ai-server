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
    private int scoreVs;
    private int win;
    private MoveBO lastMove;
    private int weight;

    public GameBO() {
    }

    public GameBO(int[][] grid, int score, int scoreVs, int win, MoveBO lastMove, int weight) {
        this.grid = grid;
        this.score = score;
        this.scoreVs = scoreVs;
        this.win = win;
        this.lastMove = lastMove;
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

    public int getScoreVs() {
        return scoreVs;
    }

    public void setScoreVs(int scoreVs) {
        this.scoreVs = scoreVs;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public MoveBO getLastMove() {
        return lastMove;
    }

    public void setLastMove(MoveBO lastMove) {
        this.lastMove = lastMove;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
