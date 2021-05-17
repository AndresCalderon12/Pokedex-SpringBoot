package com.pokemonapi.Models.items;

import java.util.ArrayList;

import com.pokemonapi.Models.pokemon.Pokemon;

public class ItemHolderPokemon {
	// The Pokémon that holds this item.
	private Pokemon pokemon;

	// The details for the version that this item is held in by the Pokémon.
	private ArrayList<ItemHolderPokemonVersionDetail> version_details;

	public Pokemon getPokemon() {
		if (!pokemon.getIsFetched()) {
			pokemon = pokemon.get();
		}
		return pokemon;
	}

	public ItemHolderPokemon setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
		return this;
	}

	public ArrayList<ItemHolderPokemonVersionDetail> getVersionDetails() {
		return version_details;
	}

	public ItemHolderPokemon setVersionDetails(ArrayList<ItemHolderPokemonVersionDetail> version_details) {
		this.version_details = version_details;
		return this;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}
