package com.pokemonapi.Models.moves;

public class ContestComboSets {
	// A detail of moves this move can be used before or after, granting additional
	// appeal points in contests.
	private ContestComboDetail normal;

	// A detail of moves this move can be used before or after, granting additional
	// appeal points in super contests.
	@com.fasterxml.jackson.annotation.JsonProperty("super")
	private ContestComboDetail super_val;

	public ContestComboDetail getNormal() {
		return normal;
	}

	public ContestComboSets setNormal(ContestComboDetail normal) {
		this.normal = normal;
		return this;
	}

	public ContestComboDetail getSuper() {
		return super_val;
	}

	public ContestComboSets setSuper(ContestComboDetail super_val) {
		this.super_val = super_val;
		return this;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}
