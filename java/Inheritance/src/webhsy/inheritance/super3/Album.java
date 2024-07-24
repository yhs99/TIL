package webhsy.inheritance.super3;

public class Album extends Product{
	private String artist;
	
	public Album(String name, int price, String artist) {
		super(name, price);
		this.artist = artist;
	}
	
	@Override
	public void productInfo() {
		super.productInfo();
		System.out.printf("아티스트 : %s \n", artist);
	}
}
