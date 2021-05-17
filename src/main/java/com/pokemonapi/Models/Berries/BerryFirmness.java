/* Berries can be soft or hard. Check out Bulbapedia for greater detail. */

package com.pokemonapi.Models.Berries;

import java.util.ArrayList;
import com.pokemonapi.Models.pokemon.Name;
import com.pokemonapi.Models.resources.NamedAPIResourceList;
import com.pokemonapi.Models.utils.NamedAPIResource;
import com.pokemonapi.Utils.Information;

public class BerryFirmness extends NamedAPIResource {
	// The identifier for this resource.
	private int id;

	// A list of the berries with this firmness.
	private ArrayList<Berry> berries;

	// The name of this resource listed in different languages.
	private ArrayList<Name> names;

	public int getId() {
		return id;
	}

	public BerryFirmness setId(int id) {
		this.id = id;
		return this;
	}

	public ArrayList<Berry> getBerries() {
		return berries;
	}

	public BerryFirmness setBerries(ArrayList<Berry> berries) {
		this.berries = berries;
		return this;
	}

	public ArrayList<Name> getNames() {
		return names;
	}

	public BerryFirmness setNames(ArrayList<Name> names) {
		this.names = names;
		return this;
	}

	private static BerryFirmness get(String url) {
		BerryFirmness obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url), BerryFirmness.class);
		obj.setIsFetched(true);
		return obj;
	}

	public BerryFirmness get() {
		return BerryFirmness.get(this.getUrl());
	}

	public static NamedAPIResourceList getList(int limit, int offset) {
		return NamedAPIResourceList.getList("berry-firmness", limit, offset);
	}

	public static BerryFirmness getById(int id) {
		return get("https://pokeapi.co/api/v2/berry-firmness/" + id);
	}

	public static BerryFirmness getByName(String name) {
		return get("https://pokeapi.co/api/v2/berry-firmness/" + name);
	}
}