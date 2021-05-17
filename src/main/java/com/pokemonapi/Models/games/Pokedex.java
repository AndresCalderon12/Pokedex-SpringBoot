package com.pokemonapi.Models.games;

import java.util.ArrayList;

import com.pokemonapi.Models.locations.Region;
import com.pokemonapi.Models.pokemon.Name;
import com.pokemonapi.Models.resources.NamedAPIResourceList;
import com.pokemonapi.Models.utils.Description;
import com.pokemonapi.Models.utils.NamedAPIResource;
import com.pokemonapi.Utils.Information;

public class Pokedex extends NamedAPIResource {
	// The identifier for this resource.
	private int id;

	// Whether or not this Pokédex originated in the main series of the video games.
	private boolean is_main_series;

	// The description of this resource listed in different languages.
	private ArrayList<Description> descriptions;

	// The name of this resource listed in different languages.
	private ArrayList<Name> names;

	// A list of Pokémon catalogued in this Pokédex and their indexes.
	private ArrayList<PokemonEntry> pokemon_entries;

	// The region this Pokédex catalogues Pokémon for.
	private Region region;

	// A list of version groups this Pokédex is relevant to.
	private ArrayList<VersionGroup> version_groups;

	public int getId() {
		return id;
	}

	public Pokedex setId(int id) {
		this.id = id;
		return this;
	}

	public boolean getIsMainSeries() {
		return is_main_series;
	}

	public Pokedex setIsMainSeries(boolean is_main_series) {
		this.is_main_series = is_main_series;
		return this;
	}

	public ArrayList<Description> getDescriptions() {
		return descriptions;
	}

	public Pokedex setDescriptions(ArrayList<Description> descriptions) {
		this.descriptions = descriptions;
		return this;
	}

	public ArrayList<Name> getNames() {
		return names;
	}

	public Pokedex setNames(ArrayList<Name> names) {
		this.names = names;
		return this;
	}

	public ArrayList<PokemonEntry> getPokemonEntries() {
		return pokemon_entries;
	}

	public Pokedex setPokemonEntries(ArrayList<PokemonEntry> pokemon_entries) {
		this.pokemon_entries = pokemon_entries;
		return this;
	}

	public Region getRegion() {
		if (!region.getIsFetched()) {
			region = region.get();
		}
		return region;
	}

	public Pokedex setRegion(Region region) {
		this.region = region;
		return this;
	}

	public ArrayList<VersionGroup> getVersionGroups() {
		return version_groups;
	}

	public Pokedex setVersionGroups(ArrayList<VersionGroup> version_groups) {
		this.version_groups = version_groups;
		return this;
	}

	private static Pokedex get(String url) {
		Pokedex obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url), Pokedex.class);
		obj.setIsFetched(true);
		return obj;
	}

	public Pokedex get() {
		return Pokedex.get(this.getUrl());
	}

	public static NamedAPIResourceList getList(int limit, int offset) {
		return NamedAPIResourceList.getList("pokedex", limit, offset);
	}

	public static Pokedex getById(int id) {
		return get("https://pokeapi.co/api/v2/pokedex/" + id);
	}

	public static Pokedex getByName(String name) {
		return get("https://pokeapi.co/api/v2/pokedex/" + name);
	}
}
