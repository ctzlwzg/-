package produceConsuner;

public class DemoText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���������ߺ������߹�ͬ����Դ����
		ShareResource sr=new ShareResource();
		//���������߶���
		new Thread(new Produce(sr)).start();
		//���������߶���
		new Thread(new Consuner(sr)).start();
	}

}
