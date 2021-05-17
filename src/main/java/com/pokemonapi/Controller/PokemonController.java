package com.pokemonapi.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokemonapi.Services.IPokemonService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("pokemon")
public class PokemonController {
	private final IPokemonService iPokemonService;

	public PokemonController(IPokemonService iPokemonService) {
		this.iPokemonService = iPokemonService;
	}

	@GetMapping("/list")
	public String PokemonList(@RequestParam int initial, @RequestParam int last) {
		return iPokemonService.GetPokemonList(initial, last);
	}

	@GetMapping("/pokemonbyname")
	public String Pokemon(@RequestParam String name) {
		return iPokemonService.GetPokemonByName(name);
	}
}
