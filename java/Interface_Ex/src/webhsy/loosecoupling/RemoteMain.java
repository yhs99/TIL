package webhsy.loosecoupling;

public class RemoteMain {

	public static void main(String[] args) {
		Tv tv = new Tv("SAMSUNG");
		Washer ws = new Washer("LG");
		MultiRemoteController remote = new MultiRemoteController();
		remote.initDevice(tv);
		remote.initDevice(ws);
	}

}
