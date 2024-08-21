package com.ajaxjsp.vo;

public class JobsVO {
	private String job_id;
	private String job_title;
	private int min_salary;
	private int max_salary;
	
	public JobsVO(String job_id, String job_title, int min_salary, int max_salary) {
		super();
		this.job_id = job_id;
		this.job_title = job_title;
		this.min_salary = min_salary;
		this.max_salary = max_salary;
	}
	public String getJob_id() {
		return job_id;
	}
	public String getJob_title() {
		return job_title;
	}
	public int getMin_salary() {
		return min_salary;
	}
	public int getMax_salary() {
		return max_salary;
	}
	
	
}
