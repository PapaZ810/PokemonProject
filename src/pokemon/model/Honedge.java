package pokemon.model;

public class Honedge extends Pokemon
{
	public Honedge()
	{
		super(679, "Honedge");
	}
	
	public Honedge(String name)
	{
		super(679, name);
	}
	
	public Honedge(int number, String name)
	{
		super(number, name);
	}
	
	public int magnetBomb()
	{
		return 123;
	}
	
	public int bulletPunch()
	{
		return 12345;
	}
}
