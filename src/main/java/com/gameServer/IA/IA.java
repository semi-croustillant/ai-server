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
        ArrayList<MoveBO> moveList = ServiceIA.generateMoves(game, player );
        ArrayList<GameBO> gameList = ServiceIA.generateGames(game,moveList);
        return ServiceIA.max(gameList, ConstanteRef.INITIAL_DEPTH, player);
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
