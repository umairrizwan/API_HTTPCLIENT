package data;

public class Users {
	

	String name;
	String email;
    String gender;
    String status;
    String id;
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Users()
    {
    	
    }
    
    public Users( String name, String email, String gender, String status)
    {
    	
    	this.name=name;
    	this.email=email;
    	this.gender=gender;
    	this.status=status;
    	
    }
    
  


	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}