package com.pokemonapi.Models.encounters;

import java.util.ArrayList;

import com.pokemonapi.Models.pokemon.Name;
import com.pokemonapi.Models.resources.NamedAPIResourceList;
import com.pokemonapi.Models.utils.NamedAPIResource;
import com.pokemonapi.Utils.Information;

public class EncounterConditionValue extends NamedAPIResource {
	// The identifier for this resource.
	private int id;

	// The condition this encounter condition value pertains to.
	private EncounterCondition condition;

	// The name of this resource listed in different languages.
	private ArrayList<Name> names;

	public int getId() {
		return id;
	}

	public EncounterConditionValue setId(int id) {
		this.id = id;
		return this;
	}

	public EncounterCondition getCondition() {
		if (!condition.getIsFetched()) {
			condition = condition.get();
		}
		return condition;
	}

	public EncounterConditionValue setCondition(EncounterCondition condition) {
		this.condition = condition;
		return this;
	}

	public ArrayList<Name> getNames() {
		return names;
	}

	public EncounterConditionValue setNames(ArrayList<Name> names) {
		this.names = names;
		return this;
	}

	private static EncounterConditionValue get(String url) {
		EncounterConditionValue obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url),
				EncounterConditionValue.class);
		obj.setIsFetched(true);
		return obj;
	}

	public EncounterConditionValue get() {
		return EncounterConditionValue.get(this.getUrl());
	}

	public static NamedAPIResourceList getList(int limit, int offset) {
		return NamedAPIResourceList.getList("encounter-condition-value", limit, offset);
	}

	public static EncounterConditionValue getById(int id) {
		return get("https://pokeapi.co/api/v2/encounter-condition-value/" + id);
	}

	public static EncounterConditionValue getByName(String name) {
		return get("https://pokeapi.co/api/v2/encounter-condition-value/" + name);
	}
}
