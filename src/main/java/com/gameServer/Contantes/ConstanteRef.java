package com.gameServer.Contantes;/**
 * Created by Guillaume on 12/04/2017.
 */

import org.apache.log4j.Logger;

/**
 * {Insert class description here}
 */
public class ConstanteRef {

    public static final int INITIAL_DEPTH = 1;
    public static final int MAX_DEPTH = 3;
    public static final int EMPTY_CASE = 0;
    public static final int WEIGHT_MIN = -99999;
    public static final int WEIGHT_MAX = 99999;
    private static final Logger log = Logger.getLogger(ConstanteRef.class);
    public static final int VICTORY = 5;
    private static int idPlayer;
    private static int idOpponent;

    public ConstanteRef(int pIdPlayer) {
        setIdPlayer(pIdPlayer);
        int PLAYER_ONE = 1;
        int PLAYER_TWO = 2;
        setIdOpponent(pIdPlayer== PLAYER_ONE ? PLAYER_TWO : PLAYER_ONE);
    }

    public static int getIdPlayer() {
        return idPlayer;
    }

    public static void setIdPlayer(int idPlayer) {
        ConstanteRef.idPlayer = idPlayer;
    }

    public static int getIdOpponent() {
        return idOpponent;
    }

    public static void setIdOpponent(int idOpponent) {
        ConstanteRef.idOpponent = idOpponent;
    }
}

