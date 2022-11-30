package com.rockpaperscisors.rps.service;

import com.rockpaperscisors.rps.entity.Player;
import com.rockpaperscisors.rps.entity.Score;
import com.rockpaperscisors.rps.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository repo;

    public List<Player> getPlayers(){
        return repo.findAll();
    }

    public Optional<Player> getPlayerById(int id){
        return repo.findById(id);
    }

    public Player postPlayer(Player p){
        return repo.save(p);
    }

    public Player putPlayer(Player p){
        Player newPlayer = repo.findById(p.getId()).orElse(null);
        if(newPlayer != null){
            newPlayer.setFirstname(p.getFirstname());
            newPlayer.setLastname(p.getLastname());
            repo.save(newPlayer);
        }
        return newPlayer;
    }

    public String deletePlayer(int id){
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return "Player deleted : " + id;
        }
        return "Player not found in this id : " + id;
    }

    public Score playerGames(int id){
        Player p = repo.findById(id).orElse(null);
        assert p != null;
        return p.getScore();
    }
}
