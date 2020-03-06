package novelis.miniprojet.cruddemo.miniProjectcrudDemo.pagination;

import java.util.Date;
import novelis.miniprojet.cruddemo.miniProjectcrudDemo.entity.Collaborator;

public class CollaboratorDetailsResponse extends SuccessResponse{
	
	private int id;
	private String first_name;
	private String last_name;
	private String civility;
	private Date birth_date;
	private String email;
	private String phone_number;
	
	public CollaboratorDetailsResponse(int id, String first_name, String lastName, String civility, Date date, String email, String phone_number) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = lastName;
		this.civility = civility;
		this.birth_date = date;
		this.email = email;
		this.phone_number = phone_number;
		
	}

	public CollaboratorDetailsResponse(Collaborator collaborator, String message) {
        this(collaborator.getId(), collaborator.getFirstName(), collaborator.getLastName(), collaborator.getCivility(), collaborator.getBirthDate(), collaborator.getEmail(), collaborator.getPhoneNumber());
        addFullMessage(message);
    }

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	
    public CollaboratorDetailsResponse(Collaborator collaborator) {
        this(collaborator, null);
    }
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String lastName) {
		this.last_name = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return birth_date;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.birth_date = dateOfBirth;
	}

	public String getCivility() {
		return civility;
	}

	public void setCivility(String civility) {
		this.civility = civility;
	}
	
	
	

}
