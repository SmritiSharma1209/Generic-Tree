package Generic_Trees;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Iterative_PreOrder_and_PostOrder {

	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		int arr[]= {10 ,20, -50, -1, 60, -1, -1, 30, -70, -1, 80, -1, 90, -1, -1, 40, -100, -1, -1, -1};
		Node root=input(arr);
		PreandPostIterative(root);


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

	
	private static class Pair{

		
		Node node;
		int state;
		
		public Pair(Node node, int state) {
			this.node=node;
			this.state=state;
		}
		
	}


    public static void PreandPostIterative(Node root) {
    	
    	Stack<Pair> st= new Stack<>();
    	st.push(new Pair(root,-1));
    	
//    	String Pre="";
//    	String Post="";
    	
    	ArrayList<Integer> Pre= new ArrayList<>();
    	ArrayList<Integer>Post=new ArrayList<>();
    	
    	while(st.size()>0) {
    		
    		Pair top= st.peek();      //top pr konsa element hai
    		
    		if(top.state==-1) {   
    			                                                 //agar state -1 hai toh woh preorder mai hai toh usse preOrder mai push kar do aur state badha do.
    			//Pre+=top.node.data+" ";
    			Pre.add(top.node.data);
    			top.state++;
    			
    		}else if(top.state==top.node.children.size() ) {      //agar uski state uske number of children ke varabar ho gayi toh pop kar do
    			
    			//Post+=top.node.data+" ";
    			Post.add(top.node.data);
    			
    			st.pop();
    			
    		}else {                                        //aab agar state -1 nahi hai aur node kechildren ke barabar nai hai toh uske children ko push karke state badha do.
    			
    			Pair cp=new Pair(top.node.children.get(top.state),-1);
    			st.push(cp);
    			
    			top.state++;
    			
    		}
    		
    	}
    	System.out.println(Pre +" ");
    	System.out.println(Post + " ");
    	
    	
    }

}
