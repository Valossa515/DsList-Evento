package com.felipe.DsList.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.DsList.DTOs.GameDTO;
import com.felipe.DsList.DTOs.GameMinDTO;
import com.felipe.DsList.Entities.Game;
import com.felipe.DsList.Services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	@Autowired
	private GameService gameService;	

	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id) {
		GameDTO result = gameService.findById(id);
		return result;
	}

	@GetMapping
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	
	@PostMapping
	public ResponseEntity<GameDTO> insert(@RequestBody GameDTO objDto, @RequestParam(name = "listId") Long listId) {
		System.out.println("Recebendo requisição para criar jogo com listId: " + listId);
        Game obj = gameService.fromDTO(objDto);
        Game game = gameService.insert(obj, listId);
        GameDTO gameDTO = gameService.toDTO(game);
        return ResponseEntity.ok().body(gameDTO);
        
        
    }

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody GameDTO gameDTO, @PathVariable Long id) {
	    gameService.update(id, gameDTO);
	    return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}") //delete
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        gameService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
