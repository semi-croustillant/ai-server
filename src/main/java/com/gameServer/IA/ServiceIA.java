package com.gameServer.IA;/**
 * Created by Guillaume on 12/04/2017.
 */

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

    public static ArrayList<MoveBO> generateMoves(GameBO game) {
        return null;
    }

    public static ArrayList<GameBO> generateGames(GameBO game, ArrayList<MoveBO> moveList) {
        return null;
    }

    public static MoveBO max(ArrayList<GameBO> gameList, int initialDepth) {
        return null;
    }
}
