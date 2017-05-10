package produceConsuner;

public class DemoText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建生产者和消费者共同的资源对象
		ShareResource sr=new ShareResource();
		//启动生产者对象
		new Thread(new Produce(sr)).start();
		//启动消费者对象
		new Thread(new Consuner(sr)).start();
	}

}
