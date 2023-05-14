package com.gabrieldev.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrieldev.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game,Long > {

}
