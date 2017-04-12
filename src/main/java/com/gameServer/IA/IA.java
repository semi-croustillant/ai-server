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

    /**
     * Creates a new instance of MinMax
     */
    public IA() {
    }

    public IA(GameTO pState){
       setGame(pState.toBO());
    }


    public MoveBO play(){
        ArrayList<MoveBO> moveList = ServiceIA.generateMoves(game);
        ArrayList<GameBO> gameList = ServiceIA.generateGames(game,moveList);
        return ServiceIA.max(gameList, ConstanteRef.INITIAL_DEPTH);
    }

    public GameBO getGame() {
        return game;
    }

    public void setGame(GameBO state) {
        this.game = state;
    }
}
