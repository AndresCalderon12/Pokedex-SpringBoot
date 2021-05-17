package com.pokemonapi.Models.pokemon;

public class NaturePokeathlonStatAffect {
	// The maximum amount of change to the referenced Pokéathlon stat.
	private int max_change;

	// The nature causing the change.
	private Nature nature;

	public int getMaxChange() {
		return max_change;
	}

	public NaturePokeathlonStatAffect setMaxChange(int max_change) {
		this.max_change = max_change;
		return this;
	}

	public Nature getNature() {
		if (!nature.getIsFetched()) {
			nature = nature.get();
		}
		return nature;
	}

	public NaturePokeathlonStatAffect setNature(Nature nature) {
		this.nature = nature;
		return this;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}
