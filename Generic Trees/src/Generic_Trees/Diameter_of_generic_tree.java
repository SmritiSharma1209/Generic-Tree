package Generic_Trees;

import java.util.Scanner;
import java.util.Stack;

public class Diameter_of_generic_tree {

	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		int arr[]= {10 ,20, -50, -1, 60, -1, -1, 30, -70, -1, 80, -1, 90, -1, -1, 40, -100, -1, -1, -1};
		Node root=input(arr);
		CalculateDiaReturnHeight(root);
		System.out.println(Dia);

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

	
	
	static int Dia=0;
	public static int CalculateDiaReturnHeight(Node root) {
		
		int dch=-1;    //equivalent to height
		int sdch=-1;
		
		
		
		for(Node child : root.children) {
			int ch=CalculateDiaReturnHeight(child);
			if(ch>dch) {
				sdch=dch;
				dch=ch;
				
			}else if(ch>sdch) {
				sdch=ch;
			}
			
			int cand= dch+sdch+2;
			if(cand>Dia) {
				Dia=cand;
			}
			
		}
		
		dch=dch+1;
		return dch;
		
	}

}
