package main;
import java.util.*;


public class Study4 {
	static int worm =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int etc = sc.nextInt();
		List<List<Integer>> network = new ArrayList<>();
		for(int i=0;i<=etc;i++) network.add(new ArrayList<>());
		sc.nextLine();
		int pair = sc.nextInt();
		sc.nextLine();
		
		for(int count=1;count<=pair;count++) {
			int a = sc.nextInt();
			int b= sc.nextInt();
			network.get(a).add(b);
			network.get(b).add(a);
			sc.nextLine();
		}
		
		boolean[] vistied = new boolean[etc+1];
		dfs(network,vistied);
		System.out.println(--worm);

	}
	static void dfs(List<List<Integer>> network, boolean[] vistied) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		while(!stack.isEmpty()) {
			int currentComputer = stack.pop();
			if(!vistied[currentComputer]) {
				vistied[currentComputer] = true;
				worm++;
				for(int com : network.get(currentComputer)) {
					if(!vistied[com]) {
						stack.push(com);
					}
					
					
				}
			}
		}
	}
}
