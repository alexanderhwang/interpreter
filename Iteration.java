
public class Iteration implements RegEx{
	private RegEx base;
	
	public Iteration(RegEx base)
	{
		this.base = base;
	}

	@Override
	public boolean matches(String s) {
		String baseString = base.toString();
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) != baseString.charAt(i % baseString.length()))
			{
				return false;
			}
		}
		return true;
	}

}
