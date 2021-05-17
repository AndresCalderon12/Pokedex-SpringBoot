package com.pokemonapi.Models.items;

import java.util.ArrayList;

import com.pokemonapi.Models.evolution.EvolutionChain;
import com.pokemonapi.Models.pokemon.Name;
import com.pokemonapi.Models.resources.NamedAPIResourceList;
import com.pokemonapi.Models.utils.GenerationGameIndex;
import com.pokemonapi.Models.utils.MachineVersionDetail;
import com.pokemonapi.Models.utils.NamedAPIResource;
import com.pokemonapi.Models.utils.VerboseEffect;
import com.pokemonapi.Models.utils.VersionGroupFlavorText;
import com.pokemonapi.Utils.Information;

public class Item extends NamedAPIResource {
	// The identifier for this resource.
	private int id;

	// The price of this item in stores.
	private int cost;

	// The power of the move Fling when used with this item.
	private int fling_power;

	// The effect of the move Fling when used with this item.
	private ItemFlingEffect fling_effect;

	// A list of attributes this item has.
	private ArrayList<ItemAttribute> attributes;

	// The category of items this item falls into.
	private ItemCategory category;

	// The effect of this ability listed in different languages.
	private ArrayList<VerboseEffect> effect_entries;

	// The flavor text of this ability listed in different languages.
	private ArrayList<VersionGroupFlavorText> flavor_text_entries;

	// A list of game indices relevent to this item by generation.
	private ArrayList<GenerationGameIndex> game_indices;

	// The name of this item listed in different languages.
	private ArrayList<Name> names;

	// A set of sprites used to depict this item in the game.
	private ItemSprites sprites;

	// A list of Pokémon that might be found in the wild holding this item.
	private ArrayList<ItemHolderPokemon> held_by_pokemon;

	// An evolution chain this item requires to produce a bay during mating.
	private EvolutionChain baby_trigger_for;

	// A list of the machines related to this item.
	private ArrayList<MachineVersionDetail> machines;

	public int getId() {
		return id;
	}

	public Item setId(int id) {
		this.id = id;
		return this;
	}

	public int getCost() {
		return cost;
	}

	public Item setCost(int cost) {
		this.cost = cost;
		return this;
	}

	public int getFlingPower() {
		return fling_power;
	}

	public Item setFlingPower(int fling_power) {
		this.fling_power = fling_power;
		return this;
	}

	public ItemFlingEffect getFlingEffect() {
		if (!fling_effect.getIsFetched()) {
			fling_effect = fling_effect.get();
		}
		return fling_effect;
	}

	public Item setFlingEffect(ItemFlingEffect fling_effect) {
		this.fling_effect = fling_effect;
		return this;
	}

	public ArrayList<ItemAttribute> getAttributes() {
		return attributes;
	}

	public Item setAttributes(ArrayList<ItemAttribute> attributes) {
		this.attributes = attributes;
		return this;
	}

	public ItemCategory getCategory() {
		if (!category.getIsFetched()) {
			category = category.get();
		}
		return category;
	}

	public Item setCategory(ItemCategory category) {
		this.category = category;
		return this;
	}

	public ArrayList<VerboseEffect> getEffectEntries() {
		return effect_entries;
	}

	public Item setEffectEntries(ArrayList<VerboseEffect> effect_entries) {
		this.effect_entries = effect_entries;
		return this;
	}

	public ArrayList<VersionGroupFlavorText> getFlavorTextEntries() {
		return flavor_text_entries;
	}

	public Item setFlavorTextEntries(ArrayList<VersionGroupFlavorText> flavor_text_entries) {
		this.flavor_text_entries = flavor_text_entries;
		return this;
	}

	public ArrayList<GenerationGameIndex> getGameIndices() {
		return game_indices;
	}

	public Item setGameIndices(ArrayList<GenerationGameIndex> game_indices) {
		this.game_indices = game_indices;
		return this;
	}

	public ArrayList<Name> getNames() {
		return names;
	}

	public Item setNames(ArrayList<Name> names) {
		this.names = names;
		return this;
	}

	public ItemSprites getSprites() {
		return sprites;
	}

	public Item setSprites(ItemSprites sprites) {
		this.sprites = sprites;
		return this;
	}

	public ArrayList<ItemHolderPokemon> getHeldByPokemon() {
		return held_by_pokemon;
	}

	public Item setHeldByPokemon(ArrayList<ItemHolderPokemon> held_by_pokemon) {
		this.held_by_pokemon = held_by_pokemon;
		return this;
	}

	public EvolutionChain getBabyTriggerFor() {
		if (!baby_trigger_for.getIsFetched()) {
			baby_trigger_for = baby_trigger_for.get();
		}
		return baby_trigger_for;
	}

	public Item setBabyTriggerFor(EvolutionChain baby_trigger_for) {
		this.baby_trigger_for = baby_trigger_for;
		return this;
	}

	public ArrayList<MachineVersionDetail> getMachines() {
		return machines;
	}

	public Item setMachines(ArrayList<MachineVersionDetail> machines) {
		this.machines = machines;
		return this;
	}

	private static Item get(String url) {
		Item obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url), Item.class);
		obj.setIsFetched(true);
		return obj;
	}

	public Item get() {
		return Item.get(this.getUrl());
	}

	public static NamedAPIResourceList getList(int limit, int offset) {
		return NamedAPIResourceList.getList("item", limit, offset);
	}

	public static Item getById(int id) {
		return get("https://pokeapi.co/api/v2/item/" + id);
	}

	public static Item getByName(String name) {
		return get("https://pokeapi.co/api/v2/item/" + name);
	}
}
