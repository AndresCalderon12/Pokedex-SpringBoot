package com.pokemonapi.Models.games;

import java.util.ArrayList;

import com.pokemonapi.Models.pokemon.Name;
import com.pokemonapi.Models.resources.NamedAPIResourceList;
import com.pokemonapi.Models.utils.NamedAPIResource;
import com.pokemonapi.Utils.Information;

public class Version extends NamedAPIResource {
	// The identifier for this resource.
	private int id;

	// The name of this resource listed in different languages.
	private ArrayList<Name> names;

	// The version group this version belongs to.
	private VersionGroup version_group;

	public int getId() {
		return id;
	}

	public Version setId(int id) {
		this.id = id;
		return this;
	}

	public ArrayList<Name> getNames() {
		return names;
	}

	public Version setNames(ArrayList<Name> names) {
		this.names = names;
		return this;
	}

	public VersionGroup getVersionGroup() {
		if (!version_group.getIsFetched()) {
			version_group = version_group.get();
		}
		return version_group;
	}

	public Version setVersionGroup(VersionGroup version_group) {
		this.version_group = version_group;
		return this;
	}

	private static Version get(String url) {
		Version obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url), Version.class);
		obj.setIsFetched(true);
		return obj;
	}

	public Version get() {
		return Version.get(this.getUrl());
	}

	public static NamedAPIResourceList getList(int limit, int offset) {
		return NamedAPIResourceList.getList("version", limit, offset);
	}

	public static Version getById(int id) {
		return get("https://pokeapi.co/api/v2/version/" + id);
	}

	public static Version getByName(String name) {
		return get("https://pokeapi.co/api/v2/version/" + name);
	}
}
