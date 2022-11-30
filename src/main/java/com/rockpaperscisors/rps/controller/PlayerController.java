package com.rockpaperscisors.rps.controller;

import com.rockpaperscisors.rps.entity.Player;
import com.rockpaperscisors.rps.entity.Score;
import com.rockpaperscisors.rps.service.GameService;
import com.rockpaperscisors.rps.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PlayerController {

    @Autowired
    private PlayerService pServ;
    @Autowired
    private GameService gServ;

    @GetMapping("/player/")
    public List<Player> getAll(){
        return pServ.getPlayers();
    }

    @GetMapping("/player/{id}")
    public Optional<Player> getPlayerById(@PathVariable int id){
        return pServ.getPlayerById(id);
    }

    @GetMapping("/player/games/{id}")
    public Score getAllPlayerGames(@PathVariable int id){
        return pServ.playerGames(id);
    }

    @PostMapping("/player/")
    public Player addPlayer(@RequestBody Player p){
        return pServ.postPlayer(p);
    }

    @PostMapping("/player/{id}/")
    public Score game(@RequestParam String action, @PathVariable int id){
        Player p = new Player();
        Score s = gServ.play(action);
        p.setId(id);
        p.setScore(s);
        return gServ.postScore(s);
    }

    @PutMapping("/player/{id}")
    public Player updatePlayer(@PathVariable int id, @RequestBody Player p){
        p.setId(id);
        return pServ.putPlayer(p);
    }

    @DeleteMapping("/player/{id}")
    public String removePlayer(@PathVariable int id){
        return pServ.deletePlayer(id);
    }

}
