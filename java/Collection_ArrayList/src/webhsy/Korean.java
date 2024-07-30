package webhsy;

public class Korean {
	private String regNo;
	private String name;
	
	public Korean(String regNo, String name) {
		this.regNo = regNo;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Korean [regNo=" + regNo + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		String identify = this.name + this.regNo;
		return identify.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Korean) {
			Korean a = (Korean) obj;
			return (a.getName().equals(this.name) && 
					a.getRegNo().equals(this.regNo));
		}
		return false;
	}

	public String getRegNo() {
		return regNo;
	}
}
