package org.example.repository;

import org.example.entity.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p ORDER BY p.totalScore DESC")
    Page<Player> findTopBatsmen(Pageable pageable);

    Player findByName(String playerName);


}
