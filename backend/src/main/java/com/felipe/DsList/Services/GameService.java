package com.felipe.DsList.Services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.felipe.DsList.DTOs.GameDTO;
import com.felipe.DsList.DTOs.GameMinDTO;
import com.felipe.DsList.Entities.Belonging;
import com.felipe.DsList.Entities.BelongingPK;
import com.felipe.DsList.Entities.Game;
import com.felipe.DsList.Entities.GameList;
import com.felipe.DsList.Projections.GameMinProjection;
import com.felipe.DsList.Repositories.BelongingRepository;
import com.felipe.DsList.Repositories.GameRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GameService {
	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private BelongingRepository belongingRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(@PathVariable Long listId) {
		Game result = gameRepository.findById(listId).get();
		return new GameDTO(result);
	}

	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(GameMinDTO::new).toList();
	}

	@Transactional(readOnly = true)
	public List<GameMinDTO> findByGameList(Long listId) {
		List<GameMinProjection> games = gameRepository.searchByList(listId);
		return games.stream().map(GameMinDTO::new).toList();
	}

	@Transactional
    public Game insert(Game obj, Long listId) {
        obj.setId(null);
        Game savedGame = gameRepository.save(obj);

        Belonging belonging = new Belonging();
        BelongingPK belongingPK = new BelongingPK();
        belongingPK.setGame(savedGame);

        GameList gameList = new GameList();
        gameList.setId(listId);
        belongingPK.setList(gameList);
        belonging.setId(belongingPK);

        belongingRepository.save(belonging);

        return savedGame;
    }

	
	public GameDTO update(Long id, GameDTO objDTO) {
	    Game game = gameRepository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("Game not found with id: " + id));
	    BeanUtils.copyProperties(objDTO, game, "id"); // Copiar as propriedades do DTO para o objeto game
	    Game updatedGame = gameRepository.save(game);
	    return new GameDTO(updatedGame);
	}

	public Game fromDTO(GameDTO gameDTO) {
		return new Game(gameDTO.getId(), gameDTO.getTitle(), gameDTO.getYear(), gameDTO.getGenre(),
				gameDTO.getPlatforms(), gameDTO.getScore(), gameDTO.getImgUrl(), gameDTO.getShortDescription(),
				gameDTO.getLongDescription());
	}
	
	public void delete(Long id) {
		gameRepository.deleteById(id);
	}

    public GameDTO toDTO(Game game) {
        return new GameDTO(game.getId(), game.getTitle(), game.getYear(), game.getGenre(), game.getPlatforms(),
                game.getScore(), game.getImgUrl(), game.getShortDescription(), game.getLongDescription());
    }

}
