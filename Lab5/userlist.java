

public class userlist {

	public static void main(String[] args) 
	{
		Set<Integer> s1 = new ListSet<Integer>();
		Set<Integer> s2 = new ListSet<Integer>();
		Set<Integer> s3 = new ListSet<Integer>();

		Integer[] nums1 = {1,2,3,4,5};
		Integer[] nums2 = {10,2,3,15};

		for (int i = 0; i < nums1.length; i++)
			s1.add(nums1[i]);

		for (int i = 0; i < nums2.length; i++)
			s2.add(nums2[i]);

		s3 = s1.intersection(s2);
		
		System.out.println("s3.getSize()" + s3.getSize());
		

	}

}
