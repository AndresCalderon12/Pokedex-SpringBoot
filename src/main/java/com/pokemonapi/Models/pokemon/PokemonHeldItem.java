package com.pokemonapi.Models.pokemon;

import java.util.ArrayList;

import com.pokemonapi.Models.items.Item;

public class PokemonHeldItem {
	// The item the referenced Pokémon holds.
	private Item item;

	// The details of the different versions in which the item is held.
	private ArrayList<PokemonHeldItemVersion> version_details;

	public Item getItem() {
		if (!item.getIsFetched()) {
			item = item.get();
		}
		return item;
	}

	public PokemonHeldItem setItem(Item item) {
		this.item = item;
		return this;
	}

	public ArrayList<PokemonHeldItemVersion> getVersionDetails() {
		return version_details;
	}

	public PokemonHeldItem setVersionDetails(ArrayList<PokemonHeldItemVersion> version_details) {
		this.version_details = version_details;
		return this;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}
