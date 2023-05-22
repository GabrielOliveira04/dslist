package com.gabrieldev.dslist.controllers;

import com.gabrieldev.dslist.dto.GameDTO;
import com.gabrieldev.dslist.dto.GameMinDTO;
import com.gabrieldev.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

	@Autowired
	private GameService gameService;
	
	@GetMapping(value = "/{id}")

	public GameDTO findByid(@PathVariable Long id){
		GameDTO result = gameService.findByid(id);
		return result;
	}
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
		
	
	
}

}
