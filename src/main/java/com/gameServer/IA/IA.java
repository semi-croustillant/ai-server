package com.gameServer.IA;/**
 * Created by Guillaume on 11/04/2017.
 */

import com.gameServer.Contantes.ConstanteRef;
import com.gameServer.ModelBO.GameBO;
import com.gameServer.ModelBO.MoveBO;
import com.gameServer.ModelTO.GameTO;

import java.util.ArrayList;

/**
 * {Insert class description here}
 */
public class IA {

    private GameBO game;

    private int player;

    /**
     * Creates a new instance of MinMax
     */
    public IA() {
    }

    public IA(GameTO pState){
       setGame(pState.toBO());
       setPlayer(pState.getPlayer());
    }


    public MoveBO play(){
        ArrayList<MoveBO> moveList = ServiceIA.generateMoves(game, ConstanteRef.getIdPlayer() );
        ArrayList<GameBO> gameList = ServiceIA.generateGames(game, moveList);
        for(GameBO gameChild : gameList){
            if(gameChild.getWin() != ConstanteRef.EMPTY_CASE){
                int weight = ServiceIA.evaluate(gameChild);
                gameChild.setWeight(weight);

            }else{

                int weight = ServiceIA.min(gameChild, ConstanteRef.INITIAL_DEPTH +1);
                gameChild.setWeight(weight);
            }
        }
        GameBO bestGame = ServiceIA.bestGame(gameList);

        return bestGame.getLastMove();

    }

    public GameBO getGame() {
        return game;
    }

    public void setGame(GameBO state) {
        this.game = state;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }
}
