package workbystream.worklombook.model.impl;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;
import workbystream.worklombook.model.ContactInformationSupport;
import workbystream.worklombook.model.HasContactInformation;

@NoArgsConstructor
@Builder(toBuilder = true)
public class Customer implements HasContactInformation {

	@Delegate
	private final ContactInformationSupport contactInfo = new ContactInformationSupport();
}
