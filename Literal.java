
public class Literal implements RegEx {
	private String s;
	
	public Literal(String s)
	{
		this.s = s;
	}
	
	public String toString()
	{
		return s;
	}

	@Override
	public boolean matches(String s) {
		return s.equals(this.s);
	}

}
