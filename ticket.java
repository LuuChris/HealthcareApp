
public class ticket {
	
	protected int ticketID;
	private String dateCreated;
	private String description;
	public int userKey;
	
	public ticket(int ticketID, String dateOpened, String description, int userKey) {
		this.ticketID = ticketID;
		this.dateCreated = dateOpened;
		this.description = description;
		this.userKey = userKey;
	}
	
	public void ResolveTicket() {
		
	}
	
//------------------------------------------------------------------------------------
	
	public int getTicketID() {
		return ticketID;
	}
	
	public String getDateCreated() {
		return dateCreated;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getUserKey() {
		return userKey;
	}
	
//----------------------------------------------------------------------------------------
	
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setUserKey(int userKey) {
		this.userKey = userKey;
	}

}
