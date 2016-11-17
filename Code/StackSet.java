public class StackSet{
	Node top;
	Node topDupe;
	int n;
	int dupes;

	class Node {
		String value;
		Node next;


		public Node (Node next, String value){
			this.next = next;
			this.value = value;
		}
	}

	//RUNTIME: should be O(1) since no array operation or iterations is performed
	public StackSet(){
		top = null;
		topDupe = null;
		n = 0;
		dupes = 0;
	}
	
	//RUNTIME: the runtime of pop should be O(1) since no arrays operations or iterations is done
	public String pop(){
		String temp = new String();
		temp = top.value;
		top = top.next;
		n--;
		return temp;
	}

	//RUNTIME: the runtime of push should be O(n) since there is a search iteration for dupes
	public void push(String s){
		Node temp = new Node(top, null);
		while (temp != null){
		temp = temp.next;
			if (temp.value.equals(s)){
				Node currentDupe = new Node(topDupe, s);
				topDupe = currentDupe;
				dupes++;
				return;
			}
		}
		Node current = new Node (top, s);
		top = current;
		n++;
	}

	//RUNTIME: runtime of peek should be O(1) since no arrays operations or iterations is performed
	public String peek(){
		return top.value;
	}
} 
