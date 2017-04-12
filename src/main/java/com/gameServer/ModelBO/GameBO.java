package com.gameServer.ModelBO;/**
 * Created by Guillaume on 12/04/2017.
 */

import com.gameServer.Contantes.ConstanteRef;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * {Insert class description here}
 */
public class GameBO implements Cloneable {

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

    public GameBO clone() {
        GameBO clone = null;
        try {
            clone = (GameBO) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        /*GameBO newGame = new GameBO();
        newGame.setGrid(grid);
        newGame.setScore(score);
        newGame.setScore_vs(score_vs);
        newGame.setWin(win);
        newGame.setLast_move(last_move);
        newGame.setWeight(weight);*/
        return clone;
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

    public void update(MoveBO move) {
        final int x = move.getX();
        final int y = move.getY();
        // on pose notre pierre
        grid[x][y] = move.getPlayer();
        //update de la game pour des tenails
        for (int dx = -1; dx < 1; dx++) {
            for (int dy = -1; dy < 1; dy++) {
                //on vérifie que le point est dans la grille
                if (x + dx < 2 || x + dx >= grid.length || y + dy < 0 || y + dy >= grid.length) {
                    //si la case adjacente appartient au joueur adverse
                    if (grid[x + dx][y + dy] != ConstanteRef.EMPTY_CASE &&
                            grid[x + dx][y + dy] != move.getPlayer()) {
                    /*On continue dans la meme direction
                    Si c'est encore un ennemi*/
                        if (grid[x + 2 * dx][y + 2 * dy] != ConstanteRef.EMPTY_CASE &&
                                grid[x + 2 * dx][y + 2 * dy] != move.getPlayer()) {

                            if (grid[x + 3 * dx][y + 3 * dy] == move.getPlayer()) {
                                //on met a jour les deux premières cases
                                grid[move.getX() + dx][move.getY() + dy] = ConstanteRef.EMPTY_CASE;
                                grid[move.getX() + 2 * dx][move.getY() + 2 * dy] = ConstanteRef.EMPTY_CASE;
                                if (move.getPlayer() == ConstanteRef.getIdPlayer()) {
                                    score++;
                                } else {
                                    scoreVs++;
                                }
                                if (score == ConstanteRef.VICTORY) {
                                    win = ConstanteRef.getIdPlayer();
                                    break;
                                } else if (scoreVs == ConstanteRef.VICTORY) {
                                    win = ConstanteRef.getIdOpponent();
                                    break;
                                }

                            }
                        }
                    }
                }
            }

        }
        ArrayList<int[]> axes = new ArrayList<>();
        int[] a = {1, 0};
        int[] b = {1, 1};
        int[] c = {0, 1};
        int[] d = {-1, 1};
        axes.add(a);
        axes.add(b);
        axes.add(c);
        axes.add(d);

        for (int[] axe : axes) {
            int nombrePointAvant = 1;
            int nombrePointApres = 0;

            for (int i = 1; i < 5; i++) {
                //point dx positif
                //if(!point grille
                //   || (!point moi){
                //    break;
                // nbrePtsApres++}
                //
            }
            for (int i = -1; i < -5; i--) {
                //pointdx negatif
                //
                //if(!point grille
                //   || (!point moi){
                //    break;
                // nbrePtsAvant++}
                //
            }
            if (nombrePointApres+nombrePointAvant >= 5){
                win = move.getPlayer();
            }
        }
    }
}
