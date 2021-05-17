package com.pokemonapi.Models.locations;

import java.util.ArrayList;

import com.pokemonapi.Models.encounters.EncounterMethod;

public class EncounterMethodRate {
	// The method in which Pokémon may be encountered in an area..
	private EncounterMethod encounter_method;

	// The chance of the encounter to occur on a version of the game.
	private ArrayList<EncounterVersionDetails> version_details;

	public EncounterMethod getEncounterMethod() {
		if (!encounter_method.getIsFetched()) {
			encounter_method = encounter_method.get();
		}
		return encounter_method;
	}

	public EncounterMethodRate setEncounterMethod(EncounterMethod encounter_method) {
		this.encounter_method = encounter_method;
		return this;
	}

	public ArrayList<EncounterVersionDetails> getVersionDetails() {
		return version_details;
	}

	public EncounterMethodRate setVersionDetails(ArrayList<EncounterVersionDetails> version_details) {
		this.version_details = version_details;
		return this;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}
