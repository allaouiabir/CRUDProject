package application;

public class contacts {
	private int id;
	private String fullName;
	private long   NumberPhone ;
	private String Email;
	private String SocialMedia ;
	private String Adress;
	private String Relationship;
	private String dates;
	private String Notes;
	
	public contacts(int id,String fullName,long NumberPhone ,String Email,String SocialMedia,
			String Adress,String Relationship,String dates,String Notes) {
		this.id=id;
		this.fullName=fullName;
		this.NumberPhone=NumberPhone;
		this.Email=Email;
		this.SocialMedia=SocialMedia;
		this.Adress=Adress;
		this.Relationship=Relationship;		
		this.dates=dates;				
		this.Notes=Notes;						
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public contacts() {
		super();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public long getNumberPhone() {
		return NumberPhone;
	}

	public void setNumberPhone(long numberPhone) {
		NumberPhone = numberPhone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSocialMedia() {
		return SocialMedia;
	}

	public void setSocialMedia(String socialMedia) {
		SocialMedia = socialMedia;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public String getRelationship() {
		return Relationship;
	}

	public void setRelationship(String relationship) {
		Relationship = relationship;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}
	
	
	
	
}
