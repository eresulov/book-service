package az.developia.compshop.model;

import java.util.List;

import lombok.Data;

@Data
public class DataWrapper {
	private List<ErrorResponse> validations;

}
