package main;
import java.util.*;
import java.io.*;

class Network {
	int number;
	List<Integer> worms;
	Network(int number,List<Integer> worms){
		this.number = number;
		this.worms = worms;
	}
}

public class Study1 {
	static int count = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int computerAmount = Integer.valueOf(br.readLine());
		boolean[] visited = new boolean[computerAmount+1];
		int n = Integer.valueOf(br.readLine());
		List<Network> networks = new ArrayList<>();
		for(int i=0;i<=computerAmount;i++) {
			networks.add(new Network(i,new ArrayList<Integer>()));
		}
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int mainComputer = Integer.parseInt(st.nextToken());
            int subComputer = Integer.parseInt(st.nextToken());
            networks.get(mainComputer).worms.add(subComputer);
            networks.get(subComputer).worms.add(mainComputer); // 양방향 연결
        }
        br.close();
        dfs(networks,visited);
        System.out.println(count-1);
	}
	static void dfs(List<Network> networks,boolean[] visited) {
		Stack<Network> stack = new Stack<>();
		stack.push(networks.get(1));
		while(!stack.isEmpty()) {
			Network currentNetwork = stack.pop();
			if(!visited[currentNetwork.number]) {
				visited[currentNetwork.number] = true;
				count++;
				for(int computer : currentNetwork.worms) {
					if(!visited[computer]) {
						stack.push(networks.get(computer));
					}
				}
			}
		}
	}

}
