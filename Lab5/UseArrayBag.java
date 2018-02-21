import java.util.Iterator;

public class UseArrayBag {

	
	public static void main(String[] args) 
	{
		Bag<String> sam = new ArrayBag<String>();
		sam.add("Apple");
		sam.add("Banana");
		sam.add("Cherry");
		sam.add("Donut");
		sam.add("Eggs");
		
		Iterator<String> itr = sam.iterator();
		String contents = new String();
        while (itr.hasNext()) 
        {
            contents += itr.next() + " ";
        }
        System.out.println(contents);
	}

}
