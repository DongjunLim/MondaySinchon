package Algorithm.MondaySinchon.BOJ4195;

//Disjoint-Set
//MST 크루스칼의 배경이되는 자료구조
//근데 이해가 잘 안된다....
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;



public class Main {

    static HashMap<String, Integer> hashMap;

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    static StringTokenizer stringTokenizer;

    static int T, F, idx, size;
    static int set[];
    static String friend1, friend2;

    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++){
            F = Integer.parseInt(bufferedReader.readLine());
            set = new int[(2 * F) + 1];

            Arrays.fill(set, -1);
            hashMap = new HashMap<>();
            idx = 1;

            for (int j = 0; j < F; j++){

                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                friend1 = stringTokenizer.nextToken();
                friend2 = stringTokenizer.nextToken();

                int idx1, idx2;

                if (!hashMap.containsKey(friend1)){
                    hashMap.put(friend1, idx);
                    idx1 = idx++;
                }
                else {
                    idx1 = hashMap.get(friend1);
                }

                if (!hashMap.containsKey(friend2)){
                    hashMap.put(friend2, idx);
                    idx2 = idx++;
                }
                else {
                    idx2 = hashMap.get(friend2);
                }

                size = -merge(idx1, idx2);

                bufferedWriter.write(size + "\n");

            }

        }
        bufferedWriter.flush();


    }

    public static int merge(int idx1, int idx2){

        idx1 = find(idx1);
        idx2 = find(idx2);

        if (idx1 != idx2){

            if (set[idx1] > set[idx2]){
                set[idx2] += set[idx1];
                set[idx1] = idx2;
            }
            else {
                set[idx1] += set[idx2];
                set[idx2] = idx1;
            }
        }
        return set[idx1] < 0 ? set[idx1] : set[idx2];
    }

    public static int find(int idx){

        if (set[idx] < 0){
            return idx;
        }
        else {
            return set[idx] = find(set[idx]);
        }
    }
}
