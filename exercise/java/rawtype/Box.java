package rawtype;

public class Box<T extends String> {
	private T t;
	
	public void set(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
	
	public <V> boolean testGenericMethod1(V v) {
		System.out.println(v);
		return true;
	}
}
