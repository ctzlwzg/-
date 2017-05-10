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
	//������������Դ�������ֺ���
	public void push(String name,String gender){
		try {
			lock.lock();
			while(!isEmpty){//���գ���������������ȡ,�����ִ��������������
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
	//������������Դȡ�����ֺ���
	public void pop(){
		lock.lock();
		try {
			while(isEmpty){//�գ��͵ȴ���������������
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
