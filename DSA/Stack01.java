import java.util.Scanner;


public class Stack01{
	int max ;
	int top;
	int[] a;

	public Stack01(int size) {
		// TODO Auto-generated constructor stub
		max=size;
		top=-1;
		a=new int[max];
		
	}

	void push(int ele) {
		if(top==max-1) {
			System.out.println("stack is overflow");
			return;
			
		}
		top++;
		a[top]=ele;
			}
	void pop(int ele) {
		if(top==-1) {
		System.out.println("stack is underflow");
		return;
		
	}
	
	ele =a[top];
	top--;
	System.out.println("stack ele. "+ele+" is popped");
		
	}
	void print() {
		for(int i=top;i>=0;i--) {
			System.out.println(a[i]+" ");

			
		}
	}
   void peek(int ele){
	if(top==-1) {
		System.out.println("stack is empty");
		
		return;
	}
	ele=a[top];
	System.out.println("peek ele is "+ele);
	
}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		Stack01 s=new Stack01(5);
		int n=0;
		while(n<5) {
			int n1=sc.nextInt();
			
			s.push(n1);
			n++;

			
		}
//	    s.push(0);
//		s.push(1);
//        s.push(2);
		s.print();
      
		
	     
		
	}

}
