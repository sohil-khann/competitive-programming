

public class practiceDSA {
	Node head;
class Node{
	int data;
	Node next;
	Node(int d){
		this.data=d;
		this.next=null;
		
	}
}
boolean isempty() {
	head.next=null;
	return true;
}
void addval(int d)
{
    Node newnode=new Node(d);
    if(head==null)
    {
        head=newnode;
        return;
    }
    newnode.next=head;
    head=newnode;
    
}
void print() {
	if(isempty()) {
		return;
	}

	while(head!=null) {
		
		
		
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
practiceDSA d =new practiceDSA();
d.addval(1);
d.addval(2);
d.print();
	}

}
