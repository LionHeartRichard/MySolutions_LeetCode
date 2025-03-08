package workbystream;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class User {
	private Long id;
	private String name;
	private String email;
}
