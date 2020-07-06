package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_3459_승자예측하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			long N = Long.parseLong(br.readLine());
			long sub = 1;
			long turn = 1;
			boolean flag = false;
			
			while(turn < N) {
				if(!flag) sub *= 4;
				turn += sub;
				flag = !flag;
			}
			
			System.out.print("#" + t + " ");
			System.out.println(flag ? "Alice" : "Bob");
		}
	}
}
