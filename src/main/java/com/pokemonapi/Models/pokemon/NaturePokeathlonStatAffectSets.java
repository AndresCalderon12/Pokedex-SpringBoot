package com.pokemonapi.Models.pokemon;

import java.util.ArrayList;

public class NaturePokeathlonStatAffectSets {
	// A list of natures and how they change the referenced Pokéathlon stat.
	private ArrayList<NaturePokeathlonStatAffect> increase;

	// A list of natures and how they change the referenced Pokéathlon stat.
	private ArrayList<NaturePokeathlonStatAffect> decrease;

	public ArrayList<NaturePokeathlonStatAffect> getIncrease() {
		return increase;
	}

	public NaturePokeathlonStatAffectSets setIncrease(ArrayList<NaturePokeathlonStatAffect> increase) {
		this.increase = increase;
		return this;
	}

	public ArrayList<NaturePokeathlonStatAffect> getDecrease() {
		return decrease;
	}

	public NaturePokeathlonStatAffectSets setDecrease(ArrayList<NaturePokeathlonStatAffect> decrease) {
		this.decrease = decrease;
		return this;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}
