package Generic_Trees;

import java.util.Scanner;
import java.util.Stack;

public class Are_trees_similar {

	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Node root=input(arr);
	}
	
	public static Node input(int arr[]) {
		Node root=null;
		Stack <Node> st= new Stack<>();
		
		
		for(int i=0;i<arr.length;++i) {
			if(arr[i]==-1) {
				st.pop();
			}else {
				
				Node temp=new Node();
				temp.data=arr[i];

				if(st.size()>0) {
				   st.peek().children.add(temp);
				}else {
					root=temp;
				}
				st.push(temp);
			}
		}
		
		return root;
	}



	  public static boolean areSimilar(Node n1, Node n2) {
	    if(n1.children.size()!=n2.children.size()) {
	    	return false;
	    }
	    
	    for(int i=0;i<n1.children.size();++i) {
	    	Node c1= n1.children.get(i);
	    	Node c2= n2.children.get(i);
	    	
	    	if(areSimilar(c1,c2)==false) {
	    		return false;
	    	}
	    }
	    return true;
	  }
}
