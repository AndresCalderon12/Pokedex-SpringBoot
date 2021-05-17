package com.pokemonapi.Models.pokemon;

import java.util.ArrayList;

import com.pokemonapi.Models.resources.NamedAPIResourceList;
import com.pokemonapi.Models.utils.NamedAPIResource;
import com.pokemonapi.Utils.Information;

public class PokeathlonStat extends NamedAPIResource {
	// The identifier for this resource.
	private int id;

	// The name of this resource listed in different languages.
	private ArrayList<Name> names;

	// A detail of natures which affect this Pokéathlon stat positively or
	// negatively.
	private NaturePokeathlonStatAffectSets affecting_natures;

	public int getId() {
		return id;
	}

	public PokeathlonStat setId(int id) {
		this.id = id;
		return this;
	}

	public ArrayList<Name> getNames() {
		return names;
	}

	public PokeathlonStat setNames(ArrayList<Name> names) {
		this.names = names;
		return this;
	}

	public NaturePokeathlonStatAffectSets getAffectingNatures() {
		return affecting_natures;
	}

	public PokeathlonStat setAffectingNatures(NaturePokeathlonStatAffectSets affecting_natures) {
		this.affecting_natures = affecting_natures;
		return this;
	}

	private static PokeathlonStat get(String url) {
		PokeathlonStat obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url), PokeathlonStat.class);
		obj.setIsFetched(true);
		return obj;
	}

	public PokeathlonStat get() {
		return PokeathlonStat.get(this.getUrl());
	}

	public static NamedAPIResourceList getList(int limit, int offset) {
		return NamedAPIResourceList.getList("pokeathlon-stat", limit, offset);
	}

	public static PokeathlonStat getById(int id) {
		return get("https://pokeapi.co/api/v2/pokeathlon-stat/" + id);
	}

	public static PokeathlonStat getByName(String name) {
		return get("https://pokeapi.co/api/v2/pokeathlon-stat/" + name);
	}
}
