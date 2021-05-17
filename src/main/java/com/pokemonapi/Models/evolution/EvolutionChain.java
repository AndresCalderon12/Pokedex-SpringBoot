package com.pokemonapi.Models.evolution;

import com.pokemonapi.Models.items.Item;
import com.pokemonapi.Models.resources.APIResourceList;
import com.pokemonapi.Models.utils.APIResource;
import com.pokemonapi.Utils.Information;

public class EvolutionChain extends APIResource {
	// The identifier for this resource.
	private int id;

	// The item that a Pokémon would be holding when mating that would trigger the
	// egg hatching a baby Pokémon rather than a basic Pokémon.
	private Item baby_trigger_item;

	// The base chain link object. Each link contains evolution details for a
	// Pokémon in the chain. Each link references the next Pokémon in the natural
	// evolution order.
	private ChainLink chain;

	public int getId() {
		return id;
	}

	public EvolutionChain setId(int id) {
		this.id = id;
		return this;
	}

	public Item getBabyTriggerItem() {
		if (!baby_trigger_item.getIsFetched()) {
			baby_trigger_item = baby_trigger_item.get();
		}
		return baby_trigger_item;
	}

	public EvolutionChain setBabyTriggerItem(Item baby_trigger_item) {
		this.baby_trigger_item = baby_trigger_item;
		return this;
	}

	public ChainLink getChain() {
		return chain;
	}

	public EvolutionChain setChain(ChainLink chain) {
		this.chain = chain;
		return this;
	}

	private static EvolutionChain get(String url) {
		EvolutionChain obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url), EvolutionChain.class);
		obj.setIsFetched(true);
		return obj;
	}

	public EvolutionChain get() {
		return EvolutionChain.get(this.getUrl());
	}

	public static APIResourceList getList(int limit, int offset) {
		return APIResourceList.getList("evolution-chain", limit, offset);
	}

	public static EvolutionChain getById(int id) {
		return get("https://pokeapi.co/api/v2/evolution-chain/" + id);
	}
}
