package workbystream;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class OperationByStream {

	public void printMatchOperation(List<User> users, User newUser) {
		String email = newUser.getEmail();
		boolean isValid = users.stream().anyMatch(u -> u.getEmail().equals(email));
		System.out.println("anyMatch__: " + isValid);
		boolean isValidOne = users.stream().allMatch(u -> u.getEmail().equals(email));
		System.out.println("____allMatch____: " + isValidOne);
		boolean isValidTwo = users.stream().noneMatch(u -> u.getEmail().equals(email));
		System.out.println("------noneMatch-----: " + isValidTwo);
	}

	@Test
	public void case1_NotNullList_EqualsEmail() {
		List<User> users = new ArrayList<User>();
		User u = User.builder().id(0L).name("Name").email("e0").build();
		User u1 = User.builder().id(1L).name("Name1").email("e1").build();
		User u2 = User.builder().id(2L).name("Name2").email("e2").build();
		User u3 = User.builder().id(3L).name("Name3").email("e3").build();
		users.addAll(List.of(u, u1, u2, u3));
		User newUser = User.builder().id(1L).name("New-Name").email("e1").build();

		printMatchOperation(users, newUser);
	}

	@Test
	public void case2_NullList() {
		System.out.println("-".repeat(100));
		List<User> users = new ArrayList<User>();
//		User u = User.builder().id(0L).name("Name").email("e0").build();
//		User u1 = User.builder().id(1L).name("Name1").email("e1").build();
//		User u2 = User.builder().id(2L).name("Name2").email("e2").build();
//		User u3 = User.builder().id(3L).name("Name3").email("e3").build();
//		users.addAll(List.of(u, u1, u2, u3));
		User newUser = User.builder().id(1L).name("New-Name").email("e1").build();

		printMatchOperation(users, newUser);
	}
}
