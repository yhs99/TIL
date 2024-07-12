package webhsy;

public class TvData {
	private boolean isOn;
	private int volume;
	
	// 메서드
	public void on() {
		isOn = true;
		System.out.println("티비 on");
	}
	
	public void off() {
		isOn = false;
		System.out.println("티비 off");
	}

	public void volumeUp() {
		volume++;
		System.out.println("TV 볼륨 증가 : " + volume);
	}
	
	public void volumeDown() {
		volume--;
		System.out.println("TV 볼륨 감소 : " + volume);
	}
}
