package produceConsuner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class ShareResource {
	private String name;
	private String meat;
	private boolean isEmpty=true;
	private final Lock lock=new ReentrantLock();
	private final Condition cond=lock.newCondition();
	//生产者向共享资源传入名字和馅
	public void push(String name,String gender){
		try {
			lock.lock();
			while(!isEmpty){//不空，等着消费者来获取,否则就执行下面生产代码
				cond.await();
			}
			this.name=name;
			Thread.sleep(10);
			this.meat=gender;
			isEmpty=false;
			cond.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	//消费者向共享资源取出名字和馅
	public void pop(){
		lock.lock();
		try {
			while(isEmpty){//空，就等待生产者来生产。
				cond.await();
			}
			Thread.sleep(10);
			System.out.println(name+"-"+meat);
			isEmpty=true;
			cond.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
