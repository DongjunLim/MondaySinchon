/**
 *  @��������
 *  .�� �����ڷ� �Ͽ� ���ڿ��� �ڸ���,
 *  �ڸ� ���ڿ� �迭�� �ּұ��� - 1 ��ŭ ��ȸ�ϸ�
 *  ���ڿ��� �������� Ȯ���ϴ� ������� Ǯ�����ϴ�.
 *  
 *  @����
 *  O(���ڿ��� �ּұ��� * n)
 */
public class T1 {
    public static void main(String[] args){
        int n = 3;
        String[] input = {"��⵵.������.���뱸.������", "��⵵.������.���뱸.�Ｚ��", "��⵵.������.���뱸.������30"};
        System.out.println(solve(n, input));

        n = 4;
        input = new String[] {"����Ư����.���ı�.��η�", "��⵵.������.�д籸.������", "����Ư����.���ı�.��η�3", "����Ư����.���ı�"};
        System.out.println(solve(n, input));

        n = 2;
        input = new String[] {"��⵵.�Ȼ��.��ϱ�.����1��", "��⵵.�Ȼ��.��ϱ�.����1��20"};
        System.out.println(solve(n, input));

        n = 2;
        input = new String[] {"��⵵.�Ⱦ��.���ȱ�", "��⵵.�Ⱦ��.���ȱ�.��õ��"};
        System.out.println(solve(n, input));
    }

    private static String solve(int n, String[] input) {
        String[][] s = new String[input.length][];
        String answer = "";
        int minIdx = Integer.MAX_VALUE;

        for(int i = 0; i < input.length; i++){
            s[i] = input[i].split("\\.");
            minIdx = Math.min(minIdx, s[i].length);
        }

        String cString;

        for(int i = 0; i < minIdx - 1; i++){
            cString = s[0][i];
            for(int j = 1; j < s.length; j++){
                if(!cString.equals(s[j][i])){
                    return answer.equals("") ? "����" : answer.substring(0, answer.length() - 1);
                }
            }
            answer += (cString + ".");
        }
        return answer.equals("") ? "����" : answer.substring(0, answer.length() - 1);
    }
}
