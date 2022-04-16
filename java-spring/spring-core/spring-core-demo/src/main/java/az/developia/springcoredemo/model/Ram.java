package az.developia.springcoredemo.model;

import org.springframework.stereotype.Component;

public class Ram {
	private Integer id;
	private String name;
	private String model;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public Ram() {
		System.out.println("Spring Ram dan obyekt aldi");
	}
	@Override
	public String toString() {
		return "Ram [id=" + id + ", name=" + name + ", model=" + model + ", size=" + size + "]";
	}
	public Ram(Integer id, String name, String model, Integer size) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.size = size;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	private Integer size;

}
