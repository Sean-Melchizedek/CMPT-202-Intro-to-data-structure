
public class UserArraySet {

	public static void main(String[] args) 
	{
		Set a = new ArraySet();
		Set b = new ArraySet();
		Set c = new ArraySet();
		
		Object[] a1 = {1,2,3,4,5};
		Object[] b1 = {4,5,6,7,8};
		Object[] c1 = {1,2,3,4,5};
		Object[] d1 = {1,2,3,4,5};
		
		a.addAll(a1);
		b.addAll(b1);
		System.out.println(b.getSize());
		c = a.union(b);
		System.out.println(a.getSize());
		System.out.println(b.getSize());
		System.out.println(c.getSize());
	}

}
