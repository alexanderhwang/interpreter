
public class Choice implements RegEx {
	private RegEx alt1;
	private RegEx alt2;
	
	public Choice(RegEx alt1, RegEx alt2)
	{
		this.alt1 = alt1;
		this.alt2 = alt2;
	}

	@Override
	public boolean matches(String s) {
		return alt1.matches(s) || alt2.matches(s);
	}

}
