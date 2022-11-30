package com.rockpaperscisors.rps.repository;

import com.rockpaperscisors.rps.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
