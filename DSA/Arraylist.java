import java.util.*;
public class Arraylist {
public static void arrList() { // ArrayList
	ArrayList<Integer> arr=new ArrayList<>();
	arr.add(11);
	arr.add(22);
	arr.add(33);
	System.out.println(arr);
	arr.set(2,44); // for modifying at index
	
	System.out.println(arr);
	
	arr.contains(11); //true
	System.out.println(arr.contains(11));
}
public static void linkedlist() {
	
	LinkedList<Integer> linklist=new LinkedList<>();
	linklist.add(10);
	linklist.add(20);
	linklist.add(30);
	linklist.add(40);
	linklist.add(50);
	System.out.println(linklist);
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		arrList();
		linkedlist();

	}

}
