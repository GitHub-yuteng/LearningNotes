package Test;

import java.util.Scanner;

//����һ������ķ���ʱ�䣬ͨ�������������������ֱ���������ʱ��͵���ʱ��(���ÿ��ǿ�������)��
//��������������7:30,������14:20, ������730��1420, ͨ��������Ҫ���������Ϊ:���������ʱ��Ϊ6Сʱ50����"��

public class FlightTime {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();

		int minuteCount = end - start - (getFront(end) - getFront(start)) * 40;

		int hour = minuteCount / 60;
		int minute = minuteCount % 60;
		System.out.println("�������ʱ��Ϊ" + hour + "Сʱ" + minute + "����");
	}

	private static int getFront(int x) {

		String string = String.valueOf(x);

		return Integer.parseInt(string.substring(0, string.length() - 2));
	}

}
