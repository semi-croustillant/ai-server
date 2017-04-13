package com.gameServer.Controller.impl; /**
 * Created by Guillaume on 03/01/2017.
 */

import com.gameServer.Contantes.ConstanteRef;
import com.gameServer.Controller.BoardController;
import com.gameServer.IA.IA;
import com.gameServer.ModelBO.GameBO;
import com.gameServer.ModelBO.MoveBO;
import com.gameServer.ModelTO.GameTO;
import com.gameServer.ModelTO.MoveTO;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur Game
 */
@RestController
public class BoardControllerImpl implements BoardController {

    private static final Logger LOGGER = Logger.getLogger(BoardControllerImpl.class);

    @Override
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(
            value = "/board/",
            method = RequestMethod.PUT,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public MoveTO sendResponse(@RequestBody GameTO gameInit) {
        LOGGER.info("It's my turn");
        new ConstanteRef(gameInit.getPlayer());
        IA ia = new IA(gameInit);
        MoveBO nextMove = ia.play();
        LOGGER.info("x "+ nextMove.getY());
        return new MoveTO(nextMove.getX(),nextMove.getY());
    }
}
