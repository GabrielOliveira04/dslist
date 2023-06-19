package com.gabrieldev.dslist.services;

import com.gabrieldev.dslist.dto.GameDTO;
import com.gabrieldev.dslist.dto.GameListDTO;
import com.gabrieldev.dslist.dto.GameMinDTO;
import com.gabrieldev.dslist.entities.Game;
import com.gabrieldev.dslist.entities.GameList;
import com.gabrieldev.dslist.projections.GameMinProjection;
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

	@Autowired
	private GameRepository gameRepository;



	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();

	}
	@Transactional
	public void move (Long listId, int sourceIndex, int destinationIndex){

		List<GameMinProjection> list = gameRepository.searchByList(listId);

		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);

		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

		for (int i = min; i <= max; i++){
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(),i);
		}

	}

}
