package webhsy.tightcoupling;

public class Remote {

	private Tv tv;
	
	public Remote() {
		this.tv = new Tv("SAMSUNG");
	}

	public void turnOnTv() {
		tv.powerOn();
	}
	
}
