package utilities;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

public class FakerUtility {

	
	
	
	
	Faker faker = new Faker();

	public String createRandomFirstName() {
		return faker.name().firstName();
	}

	public String createRandomLastName() {
		return faker.name().lastName();
	}

	public String generateAddress() {
		return faker.address().fullAddress();
	}

	public String generateEmail() {
		return faker.internet().emailAddress();
	}

	public String generateUsername() {
		return faker.name().username();
	}

	public String generatePassword() {
		return faker.internet().password();
	}
	
	public String generatePhoneNumber() {
	    return faker.phoneNumber().phoneNumber();
	}
	
	
	public String generateNumericData(int count) {
	    return faker.number().digits(count);
	}
}
//return faker.number().digits(count);