

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //나무의 수
		long m = sc.nextLong(); //필요한 나무의 수
		long[] trees = new long[n];
		sc.nextLine();
		for(int i=0;i<n;i++) {
			trees[i] = sc.nextLong();
		}
		Arrays.sort(trees);
		long left = 0;
		long right = trees[trees.length-1];
		
		while(left <= right) {
			long mid = (left + right) / 2;
			long pocket = 0;
			for(long tree : trees) {
				if(tree > mid) pocket += tree - mid;
			}
			if(pocket >= m) {
				left = mid +1;
			}
			if(pocket < m) {
				right = mid -1;
			}
		}
		System.out.println(right);
	}

}
