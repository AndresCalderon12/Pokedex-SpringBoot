package com.pokemonapi.Services;

public interface IPokemonService {
	String GetPokemonList(int initial, int last);
	String GetPokemonByName(String name);
}
