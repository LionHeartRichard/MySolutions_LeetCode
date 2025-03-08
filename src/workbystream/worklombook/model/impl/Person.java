package workbystream.worklombook.model.impl;

import lombok.experimental.Delegate;
import workbystream.worklombook.model.ContactInformationSupport;
import workbystream.worklombook.model.HasContactInformation;

// А теперь самое интересное: посмотрите, как легко составить контактную информацию в обоих классах моделей:
public class Person implements HasContactInformation {
	// Whichever other Person-specific attributes

	@Delegate(types = {HasContactInformation.class})
	private final ContactInformationSupport contactInfo = new ContactInformationSupport();

	// Person itself will implement all contact information by delegation
}
