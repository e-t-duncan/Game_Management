package com.sparta.etd.apiproject.webController;


import com.sparta.etd.apiproject.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/games")
public class GameWebController {


    private final GameService service;

    public GameWebController(GameService service){
        this.service = service;
    }

    @GetMapping
    public String getAllGames(Model model){
        model.addAttribute("games", service.getAllGames());
        return "games/index";
    }


}
