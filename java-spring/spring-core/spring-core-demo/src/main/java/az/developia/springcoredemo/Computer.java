package az.developia.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
	private Integer id;
	private String name;
	@Autowired
	private Ram ram;
	private String Model;
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Computer [id=" + id + ", name=" + name + ", ram=" + ram + ", Model=" + Model + "]";
	}
	public Ram getRam() {
		return ram;
	}
	public void setRam(Ram ram) {
		this.ram = ram;
	}
	
}
