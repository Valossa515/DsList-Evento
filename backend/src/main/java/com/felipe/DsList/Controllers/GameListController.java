package com.felipe.DsList.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.DsList.DTOs.GameListDTO;
import com.felipe.DsList.DTOs.GameMinDTO;
import com.felipe.DsList.DTOs.ReplacementDTO;
import com.felipe.DsList.Services.GameListService;
import com.felipe.DsList.Services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games") // <- Nome do parâmetro alterado para "id"
    public List<GameMinDTO> findGames(@PathVariable Long listId) { // <- Parâmetro com o nome "listId"
        List<GameMinDTO> result = gameService.findByGameList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement") // <- Nome do parâmetro alterado para "id"
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) { // <- Parâmetro com o nome "listId"
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
