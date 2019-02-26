package pokemon.model;

public class Dragonite extends Pokemon implements Dragon
{
	public Dragonite()
	{
		super(149, "Dragonite");
	}
	
	public Dragonite(String name)
	{
		super(149, name);
	}
	
	public Dragonite(int number, String name)
	{
		super(number, name);
	}
	
	public int dragonClaw()
	{
		return 123456789;
	}
	
	public void fly()
	{
		
	}
}
