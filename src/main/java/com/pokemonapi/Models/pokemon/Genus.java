package com.pokemonapi.Models.pokemon;

import com.pokemonapi.Models.utils.Language;

public class Genus {
	// The localized genus for the referenced Pokémon species
	private String genus;

	// The language this genus is in.
	private Language language;

	public String getGenus() {
		return genus;
	}

	public Genus setGenus(String genus) {
		this.genus = genus;
		return this;
	}

	public Language getLanguage() {
		if (!language.getIsFetched()) {
			language = language.get();
		}
		return language;
	}

	public Genus setLanguage(Language language) {
		this.language = language;
		return this;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}
