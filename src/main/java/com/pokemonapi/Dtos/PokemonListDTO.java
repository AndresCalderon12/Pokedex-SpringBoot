package com.pokemonapi.Dtos;

import java.util.ArrayList;

public class PokemonListDTO {
	private String name;
	private String photo;
	private ArrayList<String> types;
	private Integer weight;
	private ArrayList<String> abilities;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PokemonListDTO [name=" + name + ", photo=" + photo + ", types=" + types + ", weight=" + weight
				+ ", abilities=" + abilities + "]";
	}

}
