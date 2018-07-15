import static org.junit.Assert.assertEquals;

public class user {

	public static void main(String[] args)
	{
		Queue<String> q = new ArrayQueue<String>(6);
		
		q.add("a");
		q.add("b");
		q.add("c");
		q.add("d");
		q.add("e");
		q.add("f");
		
		q.add("g");
		q.add("h");
		
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		
//		String[] a = {"e","f","a","b","c","d"};
//		String[] b = new String[10];
//		
//		System.arraycopy(a, 2, b, 0, 4);
//		System.arraycopy(a, 0, b, 4, 2);
//		
//		for(int i = 0; i < b.length; i++)
//		{
//			System.out.print(b[i] + " ");
//		}
//		
	}

}
