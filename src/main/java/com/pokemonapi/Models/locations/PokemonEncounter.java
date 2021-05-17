package com.pokemonapi.Models.locations;

import java.util.ArrayList;

import com.pokemonapi.Models.pokemon.Pokemon;
import com.pokemonapi.Models.utils.VersionEncounterDetail;

public class PokemonEncounter {
	// The Pokémon being encountered.
	private Pokemon pokemon;

	// A list of versions and encounters with Pokémon that might happen in the
	// referenced location area.
	private ArrayList<VersionEncounterDetail> version_details;

	public Pokemon getPokemon() {
		if (!pokemon.getIsFetched()) {
			pokemon = pokemon.get();
		}
		return pokemon;
	}

	public PokemonEncounter setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
		return this;
	}

	public ArrayList<VersionEncounterDetail> getVersionDetails() {
		return version_details;
	}

	public PokemonEncounter setVersionDetails(ArrayList<VersionEncounterDetail> version_details) {
		this.version_details = version_details;
		return this;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}
