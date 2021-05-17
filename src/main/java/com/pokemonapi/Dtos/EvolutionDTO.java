package com.pokemonapi.Dtos;

public class EvolutionDTO {
	private String name;
	private String photo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "EvolutionDTO [name=" + name + ", photo=" + photo + "]";
	}
	
	
}
