/**
 * @문제접근
 * union-find를 해시맵으로 구현해 풀었습니다.
 * 같은 집합이 아니면 집합을 합치고 집합의 크기를 더합니다.
 * 그리고 해당 집합의 크기를 출력합니다.
 */

package ps.boj;

import java.io.*;
import java.util.*;

public class BOJ_4195_친구_네트워크 {
    public static int F;
    public static HashMap<String, String> disjointSet;
    public static HashMap<String, Integer> setSizeMap;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            F = Integer.parseInt(br.readLine());

            String[][] relationships = new String[F][2];

            for(int i = 0; i < F; i ++)
                relationships[i] = br.readLine().split(" ");

            solve(relationships);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(String[][] relationships) throws IOException {
        disjointSet = new HashMap<>();
        setSizeMap = new HashMap<>();

        for(String[] relationship: relationships){
            String left = relationship[0], right = relationship[1];

            makeSet(left, right);

            String leftParent = findSet(left);
            String rightParent = findSet(right);

            unionSet(leftParent, rightParent);

            bw.write(Integer.toString(setSizeMap.get(leftParent)) + '\n');
        }
    }

    public static void makeSet(String left, String right){
        if(!disjointSet.containsKey(left)){
            disjointSet.put(left, left);
            setSizeMap.put(left, 1);
        }

        if(!disjointSet.containsKey(right)){
            disjointSet.put(right, right);
            setSizeMap.put(right, 1);
        }
    }

    public static String findSet(String node){
        if(disjointSet.get(node).equals(node))
            return node;

        disjointSet.put(node, findSet(disjointSet.get(node)));

        return disjointSet.get(node);
    }

    public static void unionSet(String parent1, String parent2){
        if(parent1.equals(parent2))
            return;

        disjointSet.put(parent2, parent1);
        int newSetSize = setSizeMap.get(parent1) + setSizeMap.get(parent2);
        setSizeMap.put(parent1, newSetSize);
    }
}
