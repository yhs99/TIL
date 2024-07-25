package webhsy.loosecoupling.ex;

public class ParseMain {
	
	public static void main(String[] args) {
		ParseService ps = new ParseService();
		ps.processParse("data.json");
		ps.processParse("data.xml");
		ps.processParse("data.yaml");
		ps.processParse("data.dat");
	}
}
