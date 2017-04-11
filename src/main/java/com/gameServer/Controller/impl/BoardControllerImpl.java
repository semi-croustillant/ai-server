package com.gameServer.Controller.impl; /**
 * Created by Guillaume on 03/01/2017.
 */

import com.gameServer.Controller.BoardController;
import com.gameServer.ModelTO.State;
import com.gameServer.ModelTO.Move;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controleur Game
 */
@RestController
public class BoardControllerImpl implements BoardController {

    private static final Logger LOGGER = Logger.getLogger(BoardControllerImpl.class);

    @Override
    @RequestMapping(
            value = "/board",
            method = RequestMethod.PUT,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Move sendResponse(@RequestBody State board) {
        LOGGER.debug("It's my turn");
        int x = 0;
        int y = 0;

        return new Move(x,y);
    }
}
