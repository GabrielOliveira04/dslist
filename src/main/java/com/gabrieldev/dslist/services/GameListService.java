package com.gabrieldev.dslist.services;

import com.gabrieldev.dslist.dto.GameDTO;
import com.gabrieldev.dslist.dto.GameListDTO;
import com.gabrieldev.dslist.dto.GameMinDTO;
import com.gabrieldev.dslist.entities.Game;
import com.gabrieldev.dslist.entities.GameList;
import com.gabrieldev.dslist.repositories.GameListRepository;
import com.gabrieldev.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GameListService {


	@Autowired
	private GameListRepository gameListRepository;



	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();

	}





}