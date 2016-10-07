public class Stack{
	class Node {
		String value;
		Node next;
		Node top;

		public Node (Node next, String value){
			this.next = next;
			this.value = value;
		}
	}

	top = null;

	public String pop(){
		String temp = new String();
		temp = top.value;
		top = top.next;
		return temp;
	}

	public void push(String s){
		Node current = new Node (top, s);
		top = current;
	}

	public void peek(){
		return top;
	}
} 
