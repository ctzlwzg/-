package produceConsuner;

public class Produce implements Runnable{
	private ShareResource sr=null;
	public Produce(ShareResource sr) {
		this.sr = sr;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			//���������ͷ��ż���������
			if(i%2==0){
				sr.push("����", "����");
			}else{
				sr.push("��ͷ", "û����");
			}
		}
	}
}
