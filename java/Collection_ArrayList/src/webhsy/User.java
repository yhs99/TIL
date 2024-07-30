package webhsy;

public class User implements Comparable<User>{
	private String userId;
	private int age;
	
	public User(String userId, int age) {
		this.userId = userId;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", age=" + age + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(User o) {
		return (o.age > this.age) ? 1 : (o.age == this.age) ? 0 : -1;
	}
}
