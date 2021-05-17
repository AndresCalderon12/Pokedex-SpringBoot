package com.pokemonapi.Models.pokemon;

import com.pokemonapi.Models.games.VersionGroup;
import com.pokemonapi.Models.moves.MoveLearnMethod;

public class PokemonMoveVersion {
	// The method by which the move is learned.
	private MoveLearnMethod move_learn_method;

	// The version group in which the move is learned.
	private VersionGroup version_group;

	// The minimum level to learn the move.
	private int level_learned_at;

	public MoveLearnMethod getMoveLearnMethod() {
		if (!move_learn_method.getIsFetched()) {
			move_learn_method = move_learn_method.get();
		}
		return move_learn_method;
	}

	public PokemonMoveVersion setMoveLearnMethod(MoveLearnMethod move_learn_method) {
		this.move_learn_method = move_learn_method;
		return this;
	}

	public VersionGroup getVersionGroup() {
		if (!version_group.getIsFetched()) {
			version_group = version_group.get();
		}
		return version_group;
	}

	public PokemonMoveVersion setVersionGroup(VersionGroup version_group) {
		this.version_group = version_group;
		return this;
	}

	public int getLevelLearnedAt() {
		return level_learned_at;
	}

	public PokemonMoveVersion setLevelLearnedAt(int level_learned_at) {
		this.level_learned_at = level_learned_at;
		return this;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}
