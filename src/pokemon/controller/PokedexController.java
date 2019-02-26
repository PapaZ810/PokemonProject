package pokemon.controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import pokemon.view.PokedexFrame;
import pokemon.model.*;

public class PokedexController
{
	private PokedexFrame appFrame;
	private ArrayList<Pokemon> pokemonList;
	
	public PokedexController()
	{
		appFrame = new PokedexFrame(this);
		pokemonList = new ArrayList<Pokemon>();
	}
	
	public void buildList()
	{
		pokemonList.add(new Arcanine());
		pokemonList.add(new Articuno());
		pokemonList.add(new Dragonite());
		pokemonList.add(new Lampent());
		pokemonList.add(new Honedge());
	}
	
	public void updatePokemon(int index, String [] data)
	{
		if(data.length == 5)
		{
			Pokemon current = pokemonList.get(index);
			current.setAttackPoints(Integer.parseInt(data[0]));
			current.setEnhancementModifier(Double.parseDouble(data[1]));
			current.setHealthPoints(Integer.parseInt(data[2]));
			current.setName(data[3]);
			current.setCanEvolve(Boolean.parseBoolean(data[4]));
		}
	}
	
	public String[] buildPokedexText()
	{
		buildList();
		
		String [] names = new String [pokemonList.size()];
		
		for(int index = 0; index < pokemonList.size(); index++)
		{
			names[index] = pokemonList.get(index).getName();
		}
		return names;
	}
	
	public void savePokedex()
	{
		
	}
	
	public void start()
	{
		
	}
	
	public ArrayList<Pokemon> getPokemonList() 
	{
		return pokemonList;
	}
	
	public PokedexFrame getFrame()
	{
		return appFrame;
	}
	
	public boolean isInt(String maybeInt)
	{
		boolean isValid = false;
		
		try
		{
			Integer.parseInt(maybeInt);
			isValid = true;
		}
		catch (NumberFormatException error)
		{
			JOptionPane.showMessageDialog(null, "You need to type in a whole number!");
		}
		return isValid;
	}
	
	public boolean isDouble(String mightBeDouble)
	{
		boolean isValid = false;
		
		try
		{
			Double.parseDouble(mightBeDouble);
			isValid = true;
		}
		catch (NumberFormatException error)
		{
			JOptionPane.showMessageDialog(null,	"You need to type in a rational number");
		}
		return isValid;
	}
}
