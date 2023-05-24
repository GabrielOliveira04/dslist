package com.gabrieldev.dslist.services;

import java.util.List;

import com.gabrieldev.dslist.dto.GameDTO;

import com.gabrieldev.dslist.projections.GameMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gabrieldev.dslist.dto.GameMinDTO;
import com.gabrieldev.dslist.entities.Game;
import com.gabrieldev.dslist.repositories.GameRepository;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GameService {


	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public GameDTO findById(long id) {
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);
	}

	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();

	}


	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();


	}
}