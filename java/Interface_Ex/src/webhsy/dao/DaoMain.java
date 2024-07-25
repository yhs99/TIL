package webhsy.dao;

public class DaoMain {
	
	private static Dao_DataAccessObject dao = new MysqlDao();
	
	public static void doWork(Dao_DataAccessObject dao) {
		dao.select();
	}
	
	public static void main(String[] args) {
		doWork(dao);
	}
}
