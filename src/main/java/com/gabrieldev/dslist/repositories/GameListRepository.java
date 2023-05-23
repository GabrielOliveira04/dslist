package com.gabrieldev.dslist.repositories;

import com.gabrieldev.dslist.entities.Game;
import com.gabrieldev.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList,Long > {

}
