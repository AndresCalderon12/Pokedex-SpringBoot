package com.pokemonapi.Models.pokemon;

import java.util.ArrayList;

import com.pokemonapi.Models.resources.NamedAPIResourceList;
import com.pokemonapi.Models.utils.NamedAPIResource;
import com.pokemonapi.Utils.Information;

public class PokemonColor extends NamedAPIResource {
	// The identifier for this resource.
	private int id;

	// The name of this resource listed in different languages.
	private ArrayList<Name> names;

	// A list of the Pokémon species that have this color.
	private ArrayList<PokemonSpecies> pokemon_species;

	public int getId() {
		return id;
	}

	public PokemonColor setId(int id) {
		this.id = id;
		return this;
	}

	public ArrayList<Name> getNames() {
		return names;
	}

	public PokemonColor setNames(ArrayList<Name> names) {
		this.names = names;
		return this;
	}

	public ArrayList<PokemonSpecies> getPokemonSpecies() {
		return pokemon_species;
	}

	public PokemonColor setPokemonSpecies(ArrayList<PokemonSpecies> pokemon_species) {
		this.pokemon_species = pokemon_species;
		return this;
	}

	private static PokemonColor get(String url) {
		PokemonColor obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url), PokemonColor.class);
		obj.setIsFetched(true);
		return obj;
	}

	public PokemonColor get() {
		return PokemonColor.get(this.getUrl());
	}

	public static NamedAPIResourceList getList(int limit, int offset) {
		return NamedAPIResourceList.getList("pokemon-color", limit, offset);
	}

	public static PokemonColor getById(int id) {
		return get("https://pokeapi.co/api/v2/pokemon-color/" + id);
	}

	public static PokemonColor getByName(String name) {
		return get("https://pokeapi.co/api/v2/pokemon-color/" + name);
	}
}
