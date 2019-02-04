package pokemon.controller;

import java.util.ArrayList;
import pokemon.view.PokedexFrame;
import pokemon.model.Pokemon;

public class PokedexController
{
	private PokedexFrame appFrame;
	private Pokemon poke;
	
	public PokedexController()
	{
		poke = new Pokemon();
		appFrame = new PokedexFrame(this);
		
	}
	
	public void start()
	{
		
	}
}
