
public class ticket {
	
	protected int ticketID;
	private String dateOpened;
	private String description;
	private String availability;
	public int userKey;
	
	public ticket(int ticketID, String dateOpened, String description, String availability, int userKey) {
		this.ticketID = ticketID;
		this.dateOpened = dateOpened;
		this.description = description;
		this.availability = availability;
		this.userKey = userKey;
	}
	
	public void ResolveTicket() {
		
	}
	
//------------------------------------------------------------------------------------
	
	public int getTicketID() {
		return ticketID;
	}
	
	public String getDateOpened() {
		return dateOpened;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getAvailability() {
		return availability;
	}
	
	public int getUserKey() {
		return userKey;
	}
	
//----------------------------------------------------------------------------------------
	
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	
	public void setDateOpened(String dateOpened) {
		this.dateOpened = dateOpened;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	public void setUserKey(int userKey) {
		this.userKey = userKey;
	}

}
