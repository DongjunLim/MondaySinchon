package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1759_암호만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1[] = br.readLine().split(" ");
		int L = Integer.parseInt(input1[0]);
		String alpha[] = br.readLine().split(" ");

		Arrays.sort(alpha);
		go(L, alpha, "", 0);
	}

	public static void go(int L, String alpha[], String s, int idx) {
		if(s.length() == L) {
			if(isAsc(s)) {
				System.out.println(s);
			}
			return;
		}
		if(alpha.length <= idx) return;

		go(L, alpha, s + alpha[idx], idx + 1);
		go(L, alpha, s, idx + 1);
	}

	public static boolean isAsc(String s) {
		int moCnt = 0;
		int jaCnt = 0;
		for(char x : s.toCharArray()){
			if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') moCnt += 1;
			else jaCnt += 1;
		}
		return jaCnt >= 2 && moCnt >= 1;
	}
}
