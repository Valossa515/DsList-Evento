package com.felipe.DsList.DTOs;

import com.felipe.DsList.entities.GameList;

public class GameListDTO {
	private Long id;
	private String name;
	
	public GameListDTO(GameList entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
