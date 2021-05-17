package com.pokemonapi.Models.pokemon;

import com.pokemonapi.Models.games.Version;

public class PokemonHeldItemVersion {
	// The version in which the item is held.
	private Version version;

	// How often the item is held.
	private int rarity;

	public Version getVersion() {
		if (!version.getIsFetched()) {
			version = version.get();
		}
		return version;
	}

	public PokemonHeldItemVersion setVersion(Version version) {
		this.version = version;
		return this;
	}

	public int getRarity() {
		return rarity;
	}

	public PokemonHeldItemVersion setRarity(int rarity) {
		this.rarity = rarity;
		return this;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}
