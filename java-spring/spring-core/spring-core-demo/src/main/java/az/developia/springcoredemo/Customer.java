package az.developia.springcoredemo;

import org.springframework.stereotype.Component;

@Component(value ="musteri")
public class Customer {
private Integer id;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public Customer() {
	System.out.println("Spring Customerden obyekt aldi");
}


public void setName(String name) {
	this.name = name;
}
public String getSurName() {
	return surName;
}
@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", surName=" + surName + "]";
}
public void setSurName(String surName) {
	this.surName = surName;
}

private String name;
private String surName;
}
