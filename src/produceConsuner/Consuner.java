package produceConsuner;

public class Consuner implements Runnable {
	private ShareResource sr=null;
	public Consuner(ShareResource sr) {
		this.sr = sr;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			sr.pop();
		}
	}
}
