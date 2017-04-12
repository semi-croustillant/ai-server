package com.gameServer.IA;/**
 * Created by Guillaume on 12/04/2017.
 */

import com.gameServer.Contantes.ConstanteRef;
import com.gameServer.ModelBO.GameBO;
import com.gameServer.ModelBO.MoveBO;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * {Insert class description here}
 */
public class ServiceIA {

    private static final Logger log = Logger.getLogger(ServiceIA.class);

    /**
     * Creates a new instance of ServiceIA
     */
    public ServiceIA() {
    }

    public static ArrayList<MoveBO> generateMoves(GameBO game, int player) {

        ArrayList<MoveBO> moveList = new ArrayList<>();
        int[][] grid = game.getGrid();
        int size = grid.length;

        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                if(grid[x][y] == ConstanteRef.EMPTY_CASE){
                    MoveBO possibleMove = new MoveBO(x,y,player);
                    moveList.add(possibleMove);
                }
            }
        }
        return moveList;
    }

    public static ArrayList<GameBO> generateGames(GameBO game, ArrayList<MoveBO> moveList) {
        return null;
    }

    public static int max(GameBO gameInit, int initialDepth) {
        ArrayList<MoveBO> moveList = ServiceIA.generateMoves(gameInit, ConstanteRef.getIdPlayer() );
        ArrayList<GameBO> gameList = ServiceIA.generateGames(gameInit,moveList);
        for(GameBO game : gameList){

        }
        return 0;
    }

    public static int min(GameBO gameInit, int initialDepth) {
        ArrayList<MoveBO> moveList = ServiceIA.generateMoves(gameInit, ConstanteRef.getIdOpponent() );
        ArrayList<GameBO> gameList = ServiceIA.generateGames(gameInit,moveList);
        for(GameBO game : gameList){

        }
        return 0;
    }

    public static int evaluate(GameBO game) {
        for(int x=-1; x<1; x++){
            for(int y=-1; y<1; y++){
                //point immédiat sur l'axe utilisé: (x,y)
                //check sur x,y
                //check sur 2x, 2y
                //etc
            }
        }
        return 0;
    }

    public static MoveBO bestMove(GameBO gameInit, int depth) {
        ArrayList<MoveBO> moveList = ServiceIA.generateMoves(gameInit, ConstanteRef.getIdPlayer() );
        ArrayList<GameBO> gameList = ServiceIA.generateGames(gameInit, moveList);
        for(GameBO game : gameList){
            if(game.getWin() != ConstanteRef.EMPTY_CASE){
                int weight = ServiceIA.evaluate(game);
                game.setWeight(weight);

            }else{

                int weight = ServiceIA.min(game, depth);
                game.setWeight(weight);
            }
        }
        GameBO bestGame = ServiceIA.bestGame(gameList);

        return bestGame.getLastMove();
    }

    private static GameBO bestGame(ArrayList<GameBO> gameList) {
        return null;
    }
}
