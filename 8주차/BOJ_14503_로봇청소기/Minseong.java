package Algorithm.MondaySinchon.BOJ14503;

//같은 코드를 이름변경만 했는데도 답이 다르게 나옴 ????????
//혹시 burreader나 sttoke를 잘못썻나???

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Robot {
    int x;
    int y;
    int d;
    Robot(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class Main {
    public static final int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static int n,m,r,c,d;
    public static int[][] inputAry;
    public static boolean[][] visited;
    public static int answer = 0;
    public static Robot robot;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        inputAry = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                inputAry[i][j] = sc.nextInt();
            }
        }
        robot = new Robot(r,c,d);
        visited[r][c] = true;
        ++answer;

        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        Queue<Robot> q = new LinkedList<Robot>();
        q.add(robot);

        while(!q.isEmpty()) {
            Robot r = q.remove();
            int x = r.x;
            int y = r.y;
            int d = r.d;

            int next_direction = d;
            boolean flag = false;
            for(int i = 0; i < 4; i++) {

                next_direction = turnLeft(next_direction);
                int nx = x + dx[next_direction];
                int ny = y + dy[next_direction];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(inputAry[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Robot(nx,ny,next_direction));
                        ++answer;
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag) {
                next_direction = turnBack(d);
                int nx = x + dx[next_direction];
                int ny = y + dy[next_direction];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(inputAry[nx][ny] == 0) {
                        q.add(new Robot(nx,ny,d));
                    }
                }
            }
        }
    }

    public static int turnLeft(int d) {
        if(d == 0) {
            return 3;
        } else if(d == 1) {
            return 0;
        } else if(d == 2) {
            return 1;
        } else {
            return 2;
        }
    }
    public static int turnBack(int d) {
        if(d == 0) {
            return 2;
        } else if(d == 1) {
            return 3;
        } else if(d == 2) {
            return 0;
        } else {
            return 1;
        }
    }
}