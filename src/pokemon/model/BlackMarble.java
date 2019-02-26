package pokemon.model;

public class BlackMarble extends Pokemon implements Steel
{
	public BlackMarble()
	{
		super(808, "BlackMarble");
	}
	
	public BlackMarble(String name)
	{
		super(808, name);
	}
	
	public BlackMarble(int number, String name)
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
