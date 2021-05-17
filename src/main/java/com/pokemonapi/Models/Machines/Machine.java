package com.pokemonapi.Models.Machines;

import com.pokemonapi.Models.games.VersionGroup;
import com.pokemonapi.Models.items.Item;
import com.pokemonapi.Models.moves.Move;
import com.pokemonapi.Models.resources.APIResourceList;
import com.pokemonapi.Models.utils.APIResource;
import com.pokemonapi.Utils.Information;

public class Machine extends APIResource {
	// The identifier for this resource.
	private int id;

	// The TM or HM item that corresponds to this machine.
	private Item item;

	// The move that is taught by this machine.
	private Move move;

	// The version group that this machine applies to.
	private VersionGroup version_group;

	public int getId() {
		return id;
	}

	public Machine setId(int id) {
		this.id = id;
		return this;
	}

	public Item getItem() {
		if (!item.getIsFetched()) {
			item = item.get();
		}
		return item;
	}

	public Machine setItem(Item item) {
		this.item = item;
		return this;
	}

	public Move getMove() {
		if (!move.getIsFetched()) {
			move = move.get();
		}
		return move;
	}

	public Machine setMove(Move move) {
		this.move = move;
		return this;
	}

	public VersionGroup getVersionGroup() {
		if (!version_group.getIsFetched()) {
			version_group = version_group.get();
		}
		return version_group;
	}

	public Machine setVersionGroup(VersionGroup version_group) {
		this.version_group = version_group;
		return this;
	}

	private static Machine get(String url) {
		Machine obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url), Machine.class);
		obj.setIsFetched(true);
		return obj;
	}

	public Machine get() {
		return Machine.get(this.getUrl());
	}

	public static APIResourceList getList(int limit, int offset) {
		return APIResourceList.getList("machine", limit, offset);
	}

	public static Machine getById(int id) {
		return get("https://pokeapi.co/api/v2/machine/" + id);
	}
}
