package pl.destino.recipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Destino
 */
@Controller
public class IndexController {

    @RequestMapping({"","/","index"})
    public String getIndex() {
        return "index";
    }

    
}
