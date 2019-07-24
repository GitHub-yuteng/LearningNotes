package Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestSum {

	public static void main(String[] args) {

		int i = 0;
		AlternateDemo ad = new AlternateDemo();

		new Thread(new Runnable() {
			@Override
			public void run() {

				for (int i = 1; i <= 25; i++) {
					ad.loopA(i);
				}

			}
		}, "A").start();

		new Thread(new Runnable() {
			@Override
			public void run() {

				for (int i = 1; i <= 25; i++) {
					ad.loopB(i);
				}
			}
		}, "B").start();

		new Thread(new Runnable() {
			@Override
			public void run() {

				for (int i = 1; i <= 25; i++) {
					ad.loopC(i);

					System.out.println("-----------------------------------");
				}

			}
		}, "C").start();

		new Thread(new Runnable() {
			@Override
			public void run() {

				for (int i = 1; i <= 25; i++) {
					ad.loopC(i);

					System.out.println("-----------------------------------");
				}

			}
		}, "D").start();
	}
}

class AlternateDemo {

	private int number = 1; // ��ǰ����ִ���̵߳ı��

	private Lock lock = new ReentrantLock();

	private Condition condition1 = lock.newCondition();
	private Condition condition2 = lock.newCondition();
	private Condition condition3 = lock.newCondition();
	private Condition condition4 = lock.newCondition();

	/**
	 * @param totalLoop : ѭ���ڼ���
	 */
	public void loopA(int totalLoop) {
		lock.lock();

		try {
			// 1. �ж�
			if (number != 1) {
				condition1.await();
			}

			// 2. ��ӡ
			for (int i = 1; i <= 1; i++) {

			}

			// 3. ����
			number = 2;
			condition2.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void loopB(int totalLoop) {
		lock.lock();

		try {
			// 1. �ж�
			if (number != 2) {
				condition2.await();
			}

			// 2. ��ӡ
			for (int i = 1; i <= 1; i++) {

			}

			// 3. ����
			number = 3;
			condition3.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void loopC(int totalLoop) {
		lock.lock();

		try {
			// 1. �ж�
			if (number != 3) {
				condition3.await();
			}

			// 2. ��ӡ
			for (int i = 1; i <= 1; i++) {

			}

			// 3. ����
			number = 4;
			condition1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void loop(int totalLoop) {
		lock.lock();

		try {
			// 1. �ж�
			if (number != 4) {
				condition4.await();
			}

			// 2. ��ӡ
			for (int i = 1; i <= 1; i++) {

			}

			// 3. ����
			number = 1;
			condition1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}