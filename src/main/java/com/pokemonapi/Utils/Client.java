package com.pokemonapi.Utils;

import com.pokemonapi.Models.evolution.EvolutionChain;
import com.pokemonapi.Models.games.Generation;
import com.pokemonapi.Models.pokemon.Ability;
import com.pokemonapi.Models.pokemon.Pokemon;
import com.pokemonapi.Models.pokemon.PokemonSpecies;
import com.pokemonapi.Models.resources.APIResourceList;
import com.pokemonapi.Models.resources.NamedAPIResourceList;
import com.pokemonapi.Models.utils.Language;

public class Client {
	// if true, save api response to local database for speed and api call limit
	// help
	public static boolean CACHE = true;

	public static APIResourceList getAPIResourceListByEndpoint(String endpoint) {
		return APIResourceList.getByEndpoint(endpoint);
	}

	public static NamedAPIResourceList getNamedAPIResourceListByEndpoint(String endpoint) {
		return NamedAPIResourceList.getByEndpoint(endpoint);
	}

	public static Pokemon getPokemonById(int id) {
		return Pokemon.getById(id);
	}

	public static Pokemon getPokemonByName(String name) {
		return Pokemon.getByName(name);
	}

	public static NamedAPIResourceList getPokemonList(int limit, int offset) {
		return NamedAPIResourceList.getList("pokemon", limit, offset);
	}

	public static Language getLanguageById(int id) {
		return Language.getById(id);
	}

	public static Language getLanguageByName(String name) {
		return Language.getByName(name);
	}

	public static NamedAPIResourceList getLanguageList(int limit, int offset) {
		return NamedAPIResourceList.getList("language", limit, offset);
	}

	public static Ability getAbilityById(int id) {
		return Ability.getById(id);
	}

	public static Ability getAbilityByName(String name) {
		return Ability.getByName(name);
	}

	public static Generation getGenerationByName(String name) {
		return Generation.getByName(name);
	}

	public static EvolutionChain getEvolutionChainById(int id) {
		return EvolutionChain.getById(id);
	}

	public static PokemonSpecies getPokemonSpeciesById(int id) {
		return PokemonSpecies.getById(id);
	}
}
