package helpers;

public class TicketHelper {

    private String departDate;
    private String departStation;
    private String arriveStation;
    private String seatType;
    private String ticketAmount;

    //Set Methods
    public void setDepartDate(String departDate) { this.departDate = departDate; }
    public void setDepartStation(String departStation) { this.departStation = departStation; }
    public void setArriveStation(String arriveStation) { this.arriveStation = arriveStation; }
    public void setSeatType(String seatType) { this.seatType = seatType; }
    public void setTicketAmount(String ticketAmount) { this.ticketAmount = ticketAmount; }

    //Get Methods
    public String getDepartDate() { return departDate; }
    public String getDepartStation() { return departStation; }
    public String getArriveStation() { return arriveStation; }
    public String getSeatType() { return seatType; }
    public String getTicketAmount() { return ticketAmount; }



}
