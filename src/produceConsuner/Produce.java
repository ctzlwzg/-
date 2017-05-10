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
			//奇数输出馒头，偶数输出包子
			if(i%2==0){
				sr.push("包子", "肉馅");
			}else{
				sr.push("馒头", "没有馅");
			}
		}
	}
}
