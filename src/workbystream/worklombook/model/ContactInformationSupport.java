package workbystream.worklombook.model;

import lombok.Data;

//Теперь адаптер как вспомогательный класс:
@Data
public class ContactInformationSupport implements HasContactInformation {
	private String firstName;
	private String lastName;
	private String phoneNr;

	@Override
	public String getFullName() {
		return getFirstName() + " " + getLastName();
	}
}
