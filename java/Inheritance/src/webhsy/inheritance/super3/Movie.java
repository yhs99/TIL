package webhsy.inheritance.super3;

public class Movie extends Product{
	private String director;
	private String rate;
	
	public Movie(String name, int price, String director, String rate) {
		super(name, price);
		this.director = director;
		this.rate = rate;
	}
	public void setDirector(String director) {
		this.director = director;
	};


	@Override
	public void productInfo() {
		super.productInfo();
		System.out.printf("감독 : %s, 등급 : %s \n", director, rate);
	}
}
