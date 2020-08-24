/**
 *  @��������
 *  ��¥�� �ð��� �ּҴ����� �� ������ ��ȯ�ؼ� Ǯ�����ϴ�.
 * 
 */
public class T2 {
    public static final int YEAR = 365 * 24 * 60, MONTH = 30 * 24 * 60, DAY = 24 * 60, HOUR = 60;
    public static void main(String[] args){
        String currentTime = "2020-08-0112:00:00";

        String input = "2020-08-0111:50:00";
        System.out.println(solve(input, currentTime));

        input = "2020.08.0111:00:00";
        System.out.println(solve(input, currentTime));

        input = "2019-08-1014:00:00";
        System.out.println(solve(input, currentTime));

        input = "2019-08-0111:00:00";
        System.out.println(solve(input, currentTime));

        input = "2020-07-3012:00:00";
        System.out.println(solve(input, currentTime));
    }

    private static String solve(String input, String current) {
        String[] date = input.substring(0, 10).split("-");
        String[] time = input.substring(10).split(":");

        if(input.length() != 18 || date.length != 3 || time.length != 3)
            return "error";

        String[] currentDate = current.substring(0, 10).split("-");
        String[] currentTime = current.substring(10).split(":");


        int target = 0;
        int c = 0;

        c += (Integer.parseInt(currentDate[0]) * YEAR);
        c += (Integer.parseInt(currentDate[1]) * MONTH);
        c += (Integer.parseInt(currentDate[2]) * DAY);

        c += (Integer.parseInt(currentTime[0]) * HOUR);
        c += (Integer.parseInt(currentTime[1]));

        target += (Integer.parseInt(date[0]) * YEAR);
        target += (Integer.parseInt(date[1]) * MONTH);
        target += (Integer.parseInt(date[2]) * DAY);
        target += (Integer.parseInt(time[0]) * HOUR);
        target += (Integer.parseInt(time[1]));

        int answer = c - target;

        if(answer <= 1)
            return "��� ��";

        if(answer < HOUR)
            return (Integer.toString(answer) + "����");

        if(answer < DAY) {
            int ret = answer / HOUR;
            if(answer % HOUR == 0){
                ret++;
                if(ret == 24)
                    return "1����";
            }
            return (Integer.toString(ret) + "�ð���");
        }
        if(answer < MONTH) {
            int ret = answer / DAY;
            if(answer % DAY == 0){
                ret++;
                if(ret == 30)
                    return "1����";
            }
            return (Integer.toString(ret) + "����");
        }
        if(answer < YEAR) {
            int ret = answer / MONTH;
            if(answer % MONTH == 0){
                ret++;
                if(ret == 12)
                    return "1����";
            }
            return (Integer.toString(answer / MONTH) + "������");
        }

        return date[0].substring(2) + "��" + Integer.parseInt(date[1]) + "��" + Integer.parseInt(date[2]) + "��";
    }
}

