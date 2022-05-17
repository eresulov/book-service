package az.developia.compshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Computer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Boş qoymaq olmaz!")
	@Size(min = 1, message = "Minimum 1 simvol yazılmalıdır!")
	@Size(max = 30, message = "Maksimum 30 simvol yazılmalıdır!")

	private String brand;

	@NotEmpty(message = "Boş qoymaq olmaz!")
	@Size(min = 1, message = "Minimum 1 simvol yazılmalıdır!")
	@Size(max = 30, message = "Maksimum 30 simvol yazılmalıdır!")
	private String model;

	private String imagePath;
	private String description;
	private String cpu;
	private Double price;
	private Boolean isNew;
	private Integer memory;
	private Integer driveMemory;

	@ManyToOne
	@JoinColumn(name = "username")
	private UserModel user;

}
