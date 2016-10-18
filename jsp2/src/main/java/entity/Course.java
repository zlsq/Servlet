package entity;

import java.io.Serializable;

public class Course implements Serializable {

	//courseId是对象的属性
	private Integer courseId;
	private String name;
	private Integer days;
	
	//get方法所直接对应的属性是bean属性，
	//当前方法会让我们以为此类中有id属性，
	//则id就是bean属性。
	//去掉get并将剩下的单词首字母小写，得到
	//的单词就是bean属性。
	public Integer getId() {
		return courseId;
	}
	public void setId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	
}










