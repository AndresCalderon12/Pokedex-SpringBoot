package com.pokemonapi.Models.pokemon;

import java.util.ArrayList;

import com.pokemonapi.Models.moves.Move;

public class PokemonMove {
	// The move the Pokémon can learn.
	private Move move;

	// The details of the version in which the Pokémon can learn the move.
	private ArrayList<PokemonMoveVersion> version_group_details;

	public Move getMove() {
		if (!move.getIsFetched()) {
			move = move.get();
		}
		return move;
	}

	public PokemonMove setMove(Move move) {
		this.move = move;
		return this;
	}

	public ArrayList<PokemonMoveVersion> getVersionGroupDetails() {
		return version_group_details;
	}

	public PokemonMove setVersionGroupDetails(ArrayList<PokemonMoveVersion> version_group_details) {
		this.version_group_details = version_group_details;
		return this;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}
