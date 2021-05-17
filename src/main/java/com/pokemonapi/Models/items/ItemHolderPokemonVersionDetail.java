package com.pokemonapi.Models.items;

import com.pokemonapi.Models.games.Version;

public class ItemHolderPokemonVersionDetail {
	// How often this Pokémon holds this item in this version.
	private int rarity;

	// The version that this item is held in by the Pokémon.
	private Version version;

	public int getRarity() {
		return rarity;
	}

	public ItemHolderPokemonVersionDetail setRarity(int rarity) {
		this.rarity = rarity;
		return this;
	}

	public Version getVersion() {
		if (!version.getIsFetched()) {
			version = version.get();
		}
		return version;
	}

	public ItemHolderPokemonVersionDetail setVersion(Version version) {
		this.version = version;
		return this;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}
