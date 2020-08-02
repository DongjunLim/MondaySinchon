package Algorithm.MondaySinchon.BOJ7682;

//조건 1. 가득 차서 게임이 끝날땐 x가 5개 o가 4개
//조건 2. x가 승리했을땐 o의 갯수는 x-1
//조건 3. o가 승리했을땐 x의 갯수는 o와 동일


import java.io.*;

public class Main {

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;

    static int xCount, oCount;
    static char array[];
    static char map[][];



    static String s;

    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            s = bufferedReader.readLine();

            if (s == "end") {
                bufferedWriter.flush();
                break;
            }

            int rowXBingo = 0;
            int rowOBingo = 0;
            int colXBingo = 0;
            int colOBingo = 0;
            int crossX = 0;
            int crossO = 0;
            int crossXBingo = 0;
            int crossOBingo = 0;




            array = s.toCharArray();
            int idx = 0;

            map = new char[3][3];

            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){

                    map[i][j] = array[idx++];
                    if (map[i][j] == 'X'){
                        xCount++;
                    }
                    else if (map[i][j] == 'O'){
                        oCount++;
                    }
                }
            }

            if (xCount == 5 && oCount != 4){
                System.out.println("invalid");
                continue;
            }

            for (int i = 0; i < 3; i++){
                int rowX = 0;
                int rowO = 0;
                int colX = 0;
                int colO = 0;

                for (int j = 0; j < 3; j++){

                    if (map[i][j] == 'X'){
                        rowX++;
                    }
                    else if (map[i][j] == 'O'){
                        rowO++;
                    }

                    if (map[j][i] == 'O'){
                        colO++;
                    }
                    else if (map[j][i] == 'X'){
                        colX++;
                    }

                    if (rowX == 3){
                        rowXBingo++;
                    }
                    else if (rowO == 3){
                        rowOBingo++;
                    }
                    else if (colX == 3){
                        colXBingo++;
                    }
                    else if (colO == 3){
                        colOBingo++;
                    }
                }
            }

            for (int i = 0; i < 3; i++){
                if (map[i][i] == 'X'){
                    crossX++;
                }
                else if (map[i][i] == 'O'){
                    crossO++;
                }

                if (crossO == 3){
                    crossOBingo++;
                }
                if (crossX == 3){
                    crossXBingo++;
                }
            }

            crossX = 0;
            crossO = 0;

            int temp = 0;

            for (int i = 2; i >= 0; i--){

                if (map[i][temp] == 'X'){
                    crossX++;
                }
                else if (map[i][temp] == 'O'){
                    crossO++;
                }

                temp++;

                if (crossO == 3){
                    crossOBingo++;
                }
                if (crossX == 3){
                    crossXBingo++;
                }
            }

            if (rowXBingo > 1 || colXBingo > 1 || rowOBingo > 1 || colOBingo > 1){
                bufferedWriter.write("invalid");
                continue;
            }

            else if (xCount == oCount){
                if (rowXBingo > 0 || colXBingo > 0 || crossXBingo > 0){
                    bufferedWriter.write("invalid");
                    continue;
                }
            }

            if (xCount + oCount == 9){
                bufferedWriter.write("valid");
                continue;
            }

            if (rowXBingo + colXBingo + crossXBingo + rowOBingo + colOBingo + crossOBingo == 0){
                bufferedWriter.write("invalid");
                continue;
            }

            bufferedWriter.write("valid");

        }
        bufferedWriter.flush();
    }
}
