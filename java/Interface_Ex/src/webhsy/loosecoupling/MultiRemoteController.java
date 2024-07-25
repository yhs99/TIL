package webhsy.loosecoupling;

public class MultiRemoteController implements Remotable{
	
	@Override
	public void initDevice(ElectronicDevice device) {
		device.powerOn();
	}

}
