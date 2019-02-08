package pokemon.model;

public class Honedge extends Pokemon implements Steel
{
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
		return 234;
	}
}
