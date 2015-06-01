package concurrent;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Meal {
	private final int orderNum;

	public Meal(int orderNum) {
		this.orderNum = orderNum;
	}

	public String toString() {
		return "Meal " + orderNum;
	}
}

//上菜后(厨师)清理
class BusyBoy implements Runnable {
	
	private Restaurant restaurant;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public Lock getLock() {
		return lock;
	}

	public Condition getCondition() {
		return condition;
	}

	public BusyBoy(Restaurant r) {
		restaurant = r;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				try {
					lock.lock();
					while(restaurant.meal == null) {
						condition.await();
					}
				}finally {
					lock.unlock();
				}
				//已经上菜
				System.out.println("正在清理" + restaurant.meal);
				
			}
		}catch(InterruptedException e) {
			System.out.println("Busybody被中断");
		}
	}
	
}

class WaitPerson implements Runnable {
	private Restaurant restaurant;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public Lock getLock() {
		return lock;
	}

	public Condition getCondition() {
		return condition;
	}

	public WaitPerson(Restaurant r) {
		restaurant = r;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				try {
					lock.lock();
					while (restaurant.meal == null)
						condition.await();
				}finally {
					lock.unlock();
				}
				System.out.println("Waitperson got " + restaurant.meal);
				try {
					restaurant.chef.getLock().lock();
					restaurant.meal = null;
					restaurant.chef.getCondition().signalAll();
				}finally {
					restaurant.chef.getLock().unlock();
				}
			}
		} catch (InterruptedException e) {
			System.out.println("WaitPerson interrupted");
		}
	}
}

class Chef implements Runnable {
	private Restaurant restaurant;
	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public Lock getLock() {
		return lock;
	}

	public Condition getCondition() {
		return condition;
	}

	public Chef(Restaurant r) {
		restaurant = r;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				try {
					lock.lock();
					while (restaurant.meal != null)
						condition.await();
				}finally {
					lock.unlock();
				}
				if (++count == 10) {
					System.out.println("Out of food, closing");
					restaurant.exec.shutdownNow();
				}
				System.out.print("Order up! ");
				try {
					restaurant.waitPerson.getLock().lock();
					restaurant.meal = new Meal(count);
					restaurant.waitPerson.getCondition().signalAll();
				}finally {
					restaurant.waitPerson.getLock().unlock();
				}
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			return;
			//System.out.println("Chef interrupted");
		}
	}
}

public class Restaurant {
	Meal meal;
	ExecutorService exec = Executors.newCachedThreadPool();
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);

	public Restaurant() {
		exec.execute(chef);
		exec.execute(waitPerson);
	}

	public static void main(String[] args) {
		new Restaurant();
	}
} /*
 * Output: Order up! Waitperson got Meal 1 Order up! Waitperson got Meal 2 Order
 * up! Waitperson got Meal 3 Order up! Waitperson got Meal 4 Order up!
 * Waitperson got Meal 5 Order up! Waitperson got Meal 6 Order up! Waitperson
 * got Meal 7 Order up! Waitperson got Meal 8 Order up! Waitperson got Meal 9
 * Out of food, closing WaitPerson interrupted Order up! Chef interrupted
 */// :~
