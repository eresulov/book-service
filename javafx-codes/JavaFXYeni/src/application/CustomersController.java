package application;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import az.developia.model.Customer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class CustomersController implements Initializable{
@FXML
	private TextField customerName;

@FXML
private TextField customerSurname;

@FXML
private TextField customerPhone;

@FXML
private TextField customerAddress;
private int idCounter=1;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	@FXML
	private void saveCustomer(ActionEvent event) {
		String name=customerName.getText();
		String surname=customerSurname.getText();
		String phone=customerPhone.getText();
		String address=customerAddress.getText();
	Customer customer=new Customer();
	customer.setId(idCounter++);
	customer.setName(name);
	customer.setSurName(surname);
	customer.setPhone(phone);
	customer.setAddress(address);
	System.out.println(customer);
		
	}
}
