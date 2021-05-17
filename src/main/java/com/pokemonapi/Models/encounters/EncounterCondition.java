package com.pokemonapi.Models.encounters;

import java.util.ArrayList;

import com.pokemonapi.Models.pokemon.Name;
import com.pokemonapi.Models.resources.NamedAPIResourceList;
import com.pokemonapi.Models.utils.NamedAPIResource;
import com.pokemonapi.Utils.Information;

public class EncounterCondition extends NamedAPIResource {
	// The identifier for this resource.
	private int id;

	// The name of this resource listed in different languages.
	private ArrayList<Name> names;

	// A list of possible values for this encounter condition.
	private ArrayList<EncounterConditionValue> values;

	public int getId() {
		return id;
	}

	public EncounterCondition setId(int id) {
		this.id = id;
		return this;
	}

	public ArrayList<Name> getNames() {
		return names;
	}

	public EncounterCondition setNames(ArrayList<Name> names) {
		this.names = names;
		return this;
	}

	public ArrayList<EncounterConditionValue> getValues() {
		return values;
	}

	public EncounterCondition setValues(ArrayList<EncounterConditionValue> values) {
		this.values = values;
		return this;
	}

	private static EncounterCondition get(String url) {
		EncounterCondition obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url),
				EncounterCondition.class);
		obj.setIsFetched(true);
		return obj;
	}

	public EncounterCondition get() {
		return EncounterCondition.get(this.getUrl());
	}

	public static NamedAPIResourceList getList(int limit, int offset) {
		return NamedAPIResourceList.getList("encounter-condition", limit, offset);
	}

	public static EncounterCondition getById(int id) {
		return get("https://pokeapi.co/api/v2/encounter-condition/" + id);
	}

	public static EncounterCondition getByName(String name) {
		return get("https://pokeapi.co/api/v2/encounter-condition/" + name);
	}
}
