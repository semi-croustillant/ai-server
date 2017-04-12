package com.gameServer.Controller;

import com.gameServer.ModelTO.GameTO;
import com.gameServer.ModelTO.MoveTO;

/**
 * {Insert class description here}
 */
public interface BoardController {

    MoveTO sendResponse(GameTO board);

}
