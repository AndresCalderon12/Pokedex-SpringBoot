package com.pokemonapi.Models.pokemon;

import java.util.ArrayList;

public class MoveStatAffectSets {
	// A list of moves and how they change the referenced stat.
	private ArrayList<MoveStatAffect> increase;

	// A list of moves and how they change the referenced stat.
	private ArrayList<MoveStatAffect> decrease;

	public ArrayList<MoveStatAffect> getIncrease() {
		return increase;
	}

	public MoveStatAffectSets setIncrease(ArrayList<MoveStatAffect> increase) {
		this.increase = increase;
		return this;
	}

	public ArrayList<MoveStatAffect> getDecrease() {
		return decrease;
	}

	public MoveStatAffectSets setDecrease(ArrayList<MoveStatAffect> decrease) {
		this.decrease = decrease;
		return this;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}
