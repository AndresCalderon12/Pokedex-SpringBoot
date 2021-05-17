package com.pokemonapi.Dtos;

import java.util.ArrayList;

public class PokemonDTO {
	private String photo;
	private ArrayList<String> types;
	private Integer weight;
	private ArrayList<String> abilities;
	private ArrayList<String> evolutions;
	private String Description;

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public ArrayList<String> getTypes() {
		return types;
	}

	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public ArrayList<String> getAbilities() {
		return abilities;
	}

	public void setAbilities(ArrayList<String> abilities) {
		this.abilities = abilities;
	}

	public ArrayList<String> getEvolutions() {
		return evolutions;
	}

	public void setEvolutions(ArrayList<String> evolutions) {
		this.evolutions = evolutions;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "PokemonDTO [photo=" + photo + ", types=" + types + ", weight=" + weight + ", abilities=" + abilities
				+ ", evolutions=" + evolutions + ", Description=" + Description + "]";
	}

}
