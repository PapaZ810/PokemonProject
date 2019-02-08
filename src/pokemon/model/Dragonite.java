package pokemon.model;

public class Dragonite extends Pokemon implements Dragon
{
	public Dragonite(int number, String name)
	{
		super(number, name);
	}
	public void fly()
	{
		
	}
	public int dragonClaw()
	{
		return 345;
	}
}
