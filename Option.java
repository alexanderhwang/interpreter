
public class Option implements RegEx {
	private RegEx base;
	
	public Option(RegEx base)
	{
		this.base = base;
	}

	@Override
	public boolean matches(String s) {
		return base.matches(s) || s.isEmpty();
	}

}
