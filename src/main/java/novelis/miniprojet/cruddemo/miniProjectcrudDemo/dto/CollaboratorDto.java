package novelis.miniprojet.cruddemo.miniProjectcrudDemo.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import novelis.miniprojet.cruddemo.miniProjectcrudDemo.entity.Collaborator;

@JsonPropertyOrder(value = {"id","firstName","lastName","civility","DateOfBirth","email","phoneNumber"})
public class CollaboratorDto {

	private int id;

	@NotNull(message = "please enter your first name")
	@Pattern(regexp = "([A-Za-z 'àäâéèêëôöùûüçÀÂÉÈÔÙÛÇ-]){2,30}", message = "the first name should has betwen 2 and 30 character")
	private String firstName;

	@NotNull(message = "please enter your last name")
	@Pattern(regexp = "([A-Za-z 'àäâéèêëôöùûüçÀÂÉÈÔÙÛÇ-]){2,30}", message = "the last name should has betwen 2 and 30 character")
	private String lastName;

	@NotNull(message = "please enter your email address")
	@Email(message = "the email is not valid")
	private String email;

	@NotNull()
	@Pattern(
		    regexp = "(^0[0-9]{8}$|^00[0-9]{11,13}$)", 
		    message = "Enter a valid phone number."
		    )
	private String phoneNumber;

	@DateTimeFormat(iso=ISO.DATE)
	@NotNull(message = "please enter your birth date")
	private Date birthDate;

	@NotNull(message = "please enter your civility")
	@Pattern(regexp = "(M.|Mme)", message = "the civility is not valide")
	private String civility;

	public CollaboratorDto(int id, String firstName, String lastName, String civility, Date birthDate, String email, String phoneNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.civility = civility;
	}

	// define getter/setter

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public Date getBirthDate() {
		return birthDate;
	}

	public void setDateOfBirth(Date BirthDate) {
		this.birthDate = BirthDate;
	}

	public String getCivility() {
		return civility;
	}

	public void setCivility(String civility) {
		this.civility = civility;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Collaborateur [ id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", civility=" + civility + ", birthDate=" + birthDate + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + "]";
	}

	public Collaborator convertToCollaborator() {

		return new Collaborator(id, firstName, lastName, civility, birthDate, email, phoneNumber);
	}
	
	public static CollaboratorDto build(Collaborator collaborator) {
        return new CollaboratorDto(collaborator.getId(), collaborator.getFirstName(), collaborator.getLastName(),
        		collaborator.getCivility(), collaborator.getBirthDate(),
        		collaborator.getEmail(), collaborator.getPhoneNumber());
    }
}
