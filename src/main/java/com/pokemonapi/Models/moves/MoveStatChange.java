package com.pokemonapi.Models.moves;

import com.pokemonapi.Models.pokemon.Stat;

public class MoveStatChange {
	// The amount of change.
	private int change;

	// The stat being affected.
	private Stat stat;

	public int getChange() {
		return change;
	}

	public MoveStatChange setChange(int change) {
		this.change = change;
		return this;
	}

	public Stat getStat() {
		if (!stat.getIsFetched()) {
			stat = stat.get();
		}
		return stat;
	}

	public MoveStatChange setStat(Stat stat) {
		this.stat = stat;
		return this;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}
