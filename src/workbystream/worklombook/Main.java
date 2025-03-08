package workbystream.worklombook;

import java.util.ArrayList;
import java.util.List;

import workbystream.worklombook.model.HasContactInformation;
import workbystream.worklombook.model.impl.Customer;
import workbystream.worklombook.model.impl.Person;

public class Main {
	public static void main(String[] args) {
		List<HasContactInformation> users = new ArrayList<>();
		HasContactInformation person = new Person();
		
		users.add(person);
		HasContactInformation customer = new Customer();
		
		users.add(customer);
	}
}
