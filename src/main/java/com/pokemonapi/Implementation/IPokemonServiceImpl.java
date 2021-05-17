package com.pokemonapi.Implementation;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemonapi.Dtos.PokemonDTO;
import com.pokemonapi.Dtos.PokemonListDTO;
import com.pokemonapi.Models.evolution.EvolutionChain;
import com.pokemonapi.Models.pokemon.Pokemon;
import com.pokemonapi.Models.pokemon.PokemonSpecies;
import com.pokemonapi.Models.resources.NamedAPIResourceList;
import com.pokemonapi.Services.IPokemonService;
import com.pokemonapi.Utils.Client;

@Service
@PropertySource(value = { "file:${app.home}/application.properties" }, ignoreResourceNotFound = true)
public class IPokemonServiceImpl implements IPokemonService {

	private ArrayList<String> abilities(Pokemon pokemon) {
		ArrayList<String> abilities = new ArrayList<String>();
		for (int i = 0; i < pokemon.getAbilities().size(); i++) {
			abilities.add(pokemon.getAbilities().get(i).getAbility().getName());

		}
		return abilities;
	}

	private ArrayList<String> types(Pokemon pokemon) {
		ArrayList<String> types = new ArrayList<String>();
		for (int i = 0; i < pokemon.getTypes().size(); i++) {
			types.add(pokemon.getTypes().get(i).getType().getName());

		}
		return types;
	}

	@Override
	public String GetPokemonList(int initial, int last) {

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		Pokemon pokemon = new Pokemon();
		NamedAPIResourceList pokemons = Client.getPokemonList(initial, last);
		ArrayList<PokemonListDTO> pokemonList = new ArrayList<PokemonListDTO>();
		for (int i = 0; i < pokemons.getResults().size(); i++) {
			PokemonListDTO pokemonListdto = new PokemonListDTO();

			pokemon = Client.getPokemonByName(pokemons.getResults().get(i).getName());

			pokemonListdto.setPhoto(pokemon.getSprites().getFrontDefault());
			pokemonListdto.setWeight(pokemon.getWeight());
			pokemonListdto.setTypes(types(pokemon));
			pokemonListdto.setAbilities(abilities(pokemon));
			pokemonListdto.setName(pokemons.getResults().get(i).getName());
			pokemonList.add(pokemonListdto);
		}

		try {
			jsonString = mapper.writeValueAsString(pokemonList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;

	}

	@Override
	public String GetPokemonByName(String name) {
		ObjectMapper mapper = new ObjectMapper();
		PokemonDTO pokemonDto = new PokemonDTO();
		ArrayList<String> evolutions = new ArrayList<String>();
		Pokemon pokemon = Client.getPokemonByName(name);
		PokemonSpecies species = Client.getPokemonSpeciesById(pokemon.getId());
		EvolutionChain evolution = Client.getEvolutionChainById(species.getEvolutionChain().getId());
		for (int i = 0; i < evolution.getChain().getEvolvesTo().size(); i++) {
			evolutions.add(evolution.getChain().getEvolvesTo().get(i).getSpecies().getEvolvesFromSpecies().getName());
			evolutions.add(evolution.getChain().getEvolvesTo().get(i).getSpecies().getName());
			if (!evolution.getChain().getEvolvesTo().get(i).getEvolvesTo().isEmpty()) {
				evolutions.add(evolution.getChain().getEvolvesTo().get(i).getEvolvesTo().get(i).getSpecies().getName());
			}

		}

		for (int i = 0; i < species.getFlavorTextEntries().size(); i++) {
			if (species.getFlavorTextEntries().get(i).getLanguage().getName().equals("en")) {
				pokemonDto.setDescription(species.getFlavorTextEntries().get(i).getFlavorText());

			}
		}
		pokemonDto.setWeight(pokemon.getWeight());
		pokemonDto.setPhoto(pokemon.getSprites().getFrontDefault());
		pokemonDto.setAbilities(abilities(pokemon));
		pokemonDto.setTypes(types(pokemon));
		pokemonDto.setEvolutions(evolutions);
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(pokemonDto);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
	}

}
