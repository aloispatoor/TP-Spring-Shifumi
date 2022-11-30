package com.rockpaperscisors.rps.repository;

import com.rockpaperscisors.rps.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository  extends JpaRepository<Score, Integer> {

}
