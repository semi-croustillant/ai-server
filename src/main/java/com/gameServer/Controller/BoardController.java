package com.gameServer.Controller;

import com.gameServer.ModelTO.State;
import com.gameServer.ModelTO.Move;

/**
 * {Insert class description here}
 */
public interface BoardController {

    Move sendResponse(State board);

}
