package vo;

public class RM {
	public enum Type
	{
		redundance,
		insufficient,
		notfound,
		unknownerror
	}
	Type t;
	public Type getT() {
		return t;
	}
	public void setT(Type t) {
		this.t = t;
	}
}
