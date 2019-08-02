package Lock.ProductorAndConsumer;

public class TestProductorAndConsumer {

	public static void main(String[] args) {
		Clerk clerk = new Clerk();

		Productor pro = new Productor(clerk);
		Consumer cus = new Consumer(clerk);

		// 如果不用等待唤醒机制会产生 丢失数据
		new Thread(pro, "生产者 A").start();
		new Thread(pro, "生产者 B").start();

		new Thread(cus, "消费者 C").start();
		new Thread(cus, "消费者 D").start();
	}

}

//店员
class Clerk {
	private int product = 0;

	// 进货
	public synchronized void get() {// 循环次数：0
		//如果用if  会造成虚假唤醒
		while(product >= 1) {// 为了避免虚假唤醒问题，应该总是使用在循环中
			System.out.println("产品已满！");

			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//以下代码如果放进else 有可能 无线程唤醒
		System.out.println(Thread.currentThread().getName() + " : " + ++product);
		this.notifyAll();
	}

	// 卖货
	public synchronized void sale() {// product = 0; 循环次数：0
		//如果用if  会造成虚假唤醒
		while (product <= 0) {
			System.out.println("缺货！");

			try {
				this.wait();// 在这里等待，获得锁之后，在这个地方往下执行。
			} catch (InterruptedException e) {
			}
		}
		//以下代码如果放进else 有可能 无线程唤醒
		System.out.println(Thread.currentThread().getName() + " : " + --product);
		this.notifyAll();

	}
}

//生产者
class Productor implements Runnable {
	private Clerk clerk;

	public Productor(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			// 模拟产生延迟 有问题
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.get();
		}
	}
}

//消费者
class Consumer implements Runnable {
	private Clerk clerk;

	public Consumer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			clerk.sale();
		}
	}
}
