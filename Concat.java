
public class Concat implements RegEx {
	private RegEx first;
	private RegEx second;
	
	public Concat(RegEx first, RegEx second)
	{
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean matches(String s) {
		for (int i = 0; i < s.length(); i++)
		{
			if (first.matches(s.substring(0, i)) && second.matches(s.substring(i, s.length() - 1)))
			{
				return true;
			}
		}
		return false;
	}

}
