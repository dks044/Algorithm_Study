import java.util.*;
import java.io.*;



public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		br.close();
		int[] arr = new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i] = i+1;
		}
		int answer = 0;
		int left = 0;
		int right = 0;
		int sum = 0;
		while(right != n) {
			if(sum < n) {
				sum += arr[right++];
			}
			if(sum > n) {
				sum -= arr[left++];
			}
			if(sum == n) {
				sum -= arr[left++];
				answer++;
			}
		}
		System.out.println(answer);
	}

}
