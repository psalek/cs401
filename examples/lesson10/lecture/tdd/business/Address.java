package lesson10.lecture.tdd.business;

public class Address {
	   
	   public Address(String street, String city, String state, String zip){
	        this.street = street;
	        this.city = city;
	        this.state = state;
	        this.zip = zip;
	    }
 
	    private String street;	 
	    private String city;
	    private String state;
	    private String zip;
	    /**
	     * @return Returns the city.
	     */
	    public String getCity() {
	        return city;
	    }
	    /**
	     * @param city The city to set.
	     */
	    public void setCity(String city) {
	        this.city = city;
	    }

	    /**
	     * @return Returns the state.
	     */
	    public String getState() {
	        return state;
	    }
	    /**
	     * @param state The state to set.
	     */
	    public void setState(String state) {
	        this.state = state;
	    }
	    /**
	     * @return Returns the street1.
	     */
	    public String getStreet() {
	        return street;
	    }

	    /**
	     * @param street2 The street2 to set.
	     */
	    public void setStreet(String street) {
	        this.street = street;
	    }
	    /**
	     * @return Returns the zip.
	     */
	    public String getZip() {
	        return zip;
	    }
	    /**
	     * @param zip The zip to set.
	     */
	    public void setZip(String zip) {
	        this.zip = zip;
	    }
	    
	    public String toString() {
	        String n = System.getProperty("line.separator");
	        StringBuffer sb = new StringBuffer();
	        sb.append("Street: "+street+n);
	        sb.append("City: "+city+n);
	        sb.append("State: "+state+n);
	        sb.append("Zip: "+zip+n);
	        return sb.toString();
	    }
	}
