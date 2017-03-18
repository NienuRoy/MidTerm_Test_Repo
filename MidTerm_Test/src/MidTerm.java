import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MidTerm {

	public static <E> void reverse(ArrayList<E> list){

		int len=list.size()-1; 		//len = 3-1 = 2
		for(int i=0; i<len; i++) {	//i=0,i=1 (i=2 is not removed)
			list.add(i, list.remove(len));
		}
		System.out.println(list);
	}

	public static String generateStrings(String s1, String s2){
		String newString = "";
		for(int i=0;i<s1.length();i++){
			for(int j=0;j<s2.length();j++){
				newString=s1.substring(i, i+1)+s2.substring(j, j+1) +" ";
				System.out.print(newString);
			}
		}
		return newString;
	}

	public static int singleNumber(int[] nums){
		Set<Integer> set = new HashSet<Integer>();
		for(int result: nums){
			if(!set.add(result)){
				set.remove(result);
			}
		}
		Iterator<Integer> iterator = set.iterator();
		return iterator.next();
	}

	public static int[] twoSum(int[] nums, int target){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int[] result = new int[2];
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i])){ //i=1, nums[i]=7
				int num = map.get(nums[i]); //num=0
				result[0] = num; //0
				result[1] = i; //1
			}
			else{
				map.put(target-nums[i], i); //(9-2,0)=(7,0)
			}
		}
		System.out.println("The indices of the two numbers that add up to target are:  " +Arrays.toString(result));
		return result;
	}

	public static List<Integer> getRow(int rowIndex){

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);

		if(rowIndex==0){
			System.out.println("The rowIndex passed is 0 or null");
			return list;
		}

		ArrayList<Integer> resultArray = new ArrayList<Integer>();

		for(int i=1;i<=rowIndex;i++){
			for(int j=0;j<=i;j++){
				if(j==0){	//First element is always 0
					resultArray.add(1);
				}
				else if(j<i){
					resultArray.add(list.get(j-1)+list.get(j)); //Get values from original array and add
				}
				else if(j==i){ //Last element is always 0
					resultArray.add(1);
				}
			}
			list = resultArray;
			resultArray = new ArrayList<Integer>();
		}
		System.out.printf("The pascal's triangle row in %drd position is : " ,rowIndex);
		System.out.print(list);
		return list;
	}

	public static void main(String[] args) {
		//Checking Integers
		ArrayList<Integer> rev = new ArrayList<Integer>();
		rev.add(1);
		rev.add(2);
		rev.add(3);
		reverse(rev);
		
		//Checking Strings
		ArrayList<String> revString = new ArrayList<String>();
		revString.add("Say");
		revString.add("Hello");
		reverse(revString);
		System.out.println();

		String s1 = "ABCD";
		String s2 = "EFGH";
		generateStrings(s1, s2);
		System.out.println();

		System.out.println();
		int[] nums = {2,2,5,4,5,6,4};
		System.out.println("The element that appears just once is: " +singleNumber(nums));
		System.out.println();

		int[] nums1 = {2,7,11,15};
		twoSum(nums1, 9);
		System.out.println();

		getRow(3);
		System.out.println();
		getRow(4);

	}

}
