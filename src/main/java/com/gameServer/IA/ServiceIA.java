package com.gameServer.IA;/**
 * Created by Guillaume on 12/04/2017.
 */

import com.gameServer.Contantes.ConstanteRef;
import com.gameServer.ModelBO.GameBO;
import com.gameServer.ModelBO.MoveBO;
import org.apache.log4j.Logger;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * {Insert class description here}
 */
public class ServiceIA {

    private static final Logger LOGGER = Logger.getLogger(ServiceIA.class);

    /**
     * Creates a new instance of ServiceIA
     */
    public ServiceIA() {
    }

    public static ArrayList<MoveBO> generateMoves(GameBO game, int player) {

        ArrayList<MoveBO> moveList = new ArrayList<>();
        int[][] grid = game.getGrid();
        int size = grid.length;

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (grid[x][y] == ConstanteRef.EMPTY_CASE) {
                    MoveBO possibleMove = new MoveBO(x, y, player);
                    moveList.add(possibleMove);
                }
            }
        }
        return moveList;
    }

    public static ArrayList<GameBO> generateGames(GameBO game, ArrayList<MoveBO> moveList) {
        ArrayList<GameBO> gameList = new ArrayList<>();
        for (MoveBO move : moveList) {
            //LOGGER.info("Nouvelle partie");
            GameBO child = ServiceIA.updateGame(game, move);
            gameList.add(child);
        }
        return gameList;
    }

    public static int max(GameBO gameInit, int actualDepth) {
        ArrayList<MoveBO> moveList = ServiceIA.generateMoves(gameInit, ConstanteRef.getIdPlayer());
        ArrayList<GameBO> gameList = ServiceIA.generateGames(gameInit, moveList);
        for (GameBO game : gameList) {
            if (game.getWin() != ConstanteRef.EMPTY_CASE) {
                if (game.getWin() == ConstanteRef.getIdPlayer()) {
                    game.setWeight(ConstanteRef.WEIGHT_MAX);
                } else {
                    game.setWeight(ConstanteRef.WEIGHT_MIN);
                }
            } else if (actualDepth >= ConstanteRef.MAX_DEPTH) {
                int weight = ServiceIA.evaluate(game, ConstanteRef.getIdOpponent());
                game.setWeight(weight);
            } else {
                int weight = ServiceIA.min(game, actualDepth + 1);
                game.setWeight(weight);
            }
        }
        GameBO bestGame = ServiceIA.worstGame(gameList);
        //LOGGER.info(bestGame.getWeight());
        return bestGame.getWeight();
    }

    public static int min(GameBO gameInit, int actualDepth) {
        ArrayList<MoveBO> moveList = ServiceIA.generateMoves(gameInit, ConstanteRef.getIdOpponent());
        ArrayList<GameBO> gameList = ServiceIA.generateGames(gameInit, moveList);
        for (GameBO game : gameList) {
            if (game.getWin() != ConstanteRef.EMPTY_CASE) {
                if (game.getWin() == ConstanteRef.getIdPlayer()) {
                    game.setWeight(ConstanteRef.WEIGHT_MAX);
                } else {
                    game.setWeight(ConstanteRef.WEIGHT_MIN);
                }
            } else if (actualDepth >= ConstanteRef.MAX_DEPTH) {
                int weight = ServiceIA.evaluate(game, ConstanteRef.getIdPlayer());
                game.setWeight(weight);
            } else {
                int weight = ServiceIA.max(game, actualDepth + 1);
                game.setWeight(weight);
            }
        }

        GameBO worthGame = ServiceIA.bestGame(gameList);
        //LOGGER.info(worthGame.getWeight());
        return worthGame.getWeight();
    }


    public static int evaluate(GameBO game, int nextPlayer) {
        int nmbreSerie3 = 0;
        int nmbreTenailsMaxByMove = 0;
        int nmbreTenails = 0;

        //nextPlayer == me

        //check noombre tenail
        for (int x = 0; x < game.getGrid().length; x++) {
            for (int y = 0; y < game.getGrid().length; y++) {

                int nmbreTenailsByMove = 0;
                for (int dx = -1; dx < 1; dx++) {
                    for (int dy = -1; dy < 1; dy++) {

                        //On vérifie que tous les points concernés sont dans la grille
                        if (neighborInGrid(game.getGrid(), x + 3 * dx, y + 3 * dy)) {
                            //si la case adjacente appartient au joueur adverse
                            if (game.getGrid()[x + dx][y + dy] != ConstanteRef.EMPTY_CASE &&
                                    game.getGrid()[x + dx][y + dy] != nextPlayer) {
                                    /*On continue dans la meme direction
                                    Si c'est encore un ennemi*/
                                if (game.getGrid()[x + 2 * dx][y + 2 * dy] != ConstanteRef.EMPTY_CASE &&
                                        game.getGrid()[x + 2 * dx][y + 2 * dy] != nextPlayer) {

                                    if (game.getGrid()[x + 3 * dx][y + 3 * dy] == nextPlayer) {
                                        nmbreTenails = nmbreTenails + 1;
                                        nmbreTenailsByMove++;
                                    }
                                }
                            }
                        }
                    }
                }
                if (nextPlayer == ConstanteRef.getIdOpponent()) {
                    if (nmbreTenailsByMove + game.getScoreVs() >= 5) {
                        return ConstanteRef.WEIGHT_MIN;
                    }
                } else {
                    if (nmbreTenailsByMove + game.getScore() >= 5) {
                        return ConstanteRef.WEIGHT_MAX;
                    }
                }

            }
        }
        if (nextPlayer == ConstanteRef.getIdPlayer()) {
            return nmbreTenails + game.getScore();
        } else {
            return nmbreTenails + game.getScoreVs();
        }

    }

    public static GameBO bestGame(ArrayList<GameBO> gameList) {
        int maxWeight = ConstanteRef.WEIGHT_MIN;
        GameBO bestGame = new GameBO();
        for (GameBO game : gameList) {
            if (game.getWeight() >= maxWeight) {
                bestGame = game;
            }
        }
        return bestGame;
    }

    public static GameBO worstGame(ArrayList<GameBO> gameList) {
        int minWeight = ConstanteRef.WEIGHT_MAX;
        GameBO worthGame = new GameBO();
        for (GameBO game : gameList) {
            if (game.getWeight() <= minWeight) {
                worthGame = game;
            }
        }
        return worthGame;
    }

    public static GameBO updateGame(final GameBO game, final MoveBO move) {
        int[][] grid = deepCopyIntMatrix(game.getGrid());

//        for(int y =0;y<grid.length;y++) {
//            LOGGER.info(grid[0][y]);
//
//        }
        //LOGGER.info("x "+move.getX()+" y " + move.getY());
        //MoveBO lastMove = game.getLastMove();
        int score = game.getScore();
        int scoreVs = game.getScoreVs();
        int win = game.getWin();
        int weigth = game.getWeight();

        final int x = move.getX();
        final int y = move.getY();
        // on pose notre pierre
        grid[x][y] = move.getPlayer();
        //update de la game pour des tenails
        for (int dx = -1; dx < 1; dx++) {
            for (int dy = -1; dy < 1; dy++) {
                //On vérifie que tous les points concernés sont dans la grille
                if (neighborInGrid(grid, x + 3 * dx, y + 3 * dy)) {
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

        ArrayList<int[]> axes = ConstanteRef.AXES;
        //boucle de recherche d'allié et actualisation de la partie
        for (int[] axe : axes) {
            int dx = axe[0];
            int dy = axe[1];
            int stoneBefore = 1;
            int stoneAfter = 0;

            for (int i = 1; i < 5; i++) {
                //pour tous les points avec un dx positif
                if (neighborInGrid(grid, x + i * dx, y + i * dy)) {
                    if ((grid[x + i * dx][y + i * dy] == move.getPlayer())) {
                        stoneAfter++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }

            }
            for (int i = -1; i > -5; i--) {
                //pour tous les points avec un dx négatif
//                LOGGER.info("iteration : "+i);
//                LOGGER.info("point d'origine :x="+ (x)+", y="+(y));
//                LOGGER.info(" point etudie  : x="+ (x+i*dx)+", y="+(y+i*dy));
//                LOGGER.info(" point dans grille " + neighborInGrid(grid, x + i * dx, y + i * dy));
                if (neighborInGrid(grid, x + i * dx, y + i * dy)) {
//                    LOGGER.info(" voisin : "+grid[x + i * dx][y + i * dy]);
                    if ((grid[x + i * dx][y + i * dy] == move.getPlayer())) {
//                        LOGGER.info("Allié trouve");
                        stoneAfter++;
                    } else {
//                        LOGGER.info("Allié non trouvé");
                        break;
                    }
                } else {
//                    LOGGER.info("En dehors de la grille");
                    break;
                }
            }
            if (stoneAfter + stoneBefore >= 5) {
                win = move.getPlayer();
            }
        }
        return new GameBO(grid, score, scoreVs, win, move, weigth);
    }

    private static boolean neighborInGrid(int[][] grid, int neighborX, int neighborY) {
        return neighborX >= 0 && neighborX < grid.length && neighborY >= 0 && neighborY < grid.length;
    }

    public static int[][] deepCopyIntMatrix(int[][] input) {
        if (input == null)
            return null;
        int[][] result = new int[input.length][];
        for (int r = 0; r < input.length; r++) {
            result[r] = input[r].clone();
        }
        return result;
    }
}
