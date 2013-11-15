package pos;

import java.util.ArrayList;

public class CustomerRecords {
	private ArrayList<Customer> custRecs;
	
	public CustomerRecords() {
		custRecs = new ArrayList<Customer>();
	}

	/**
	 * @return the custRecs
	 */
	public ArrayList<Customer> getCustRecs() {
		return custRecs;
	}

	/**
	 * @param custRecs the custRecs to set
	 */
	public void setCustRecs(ArrayList<Customer> custRecs) {
		this.custRecs = custRecs;
	}
	
	public void addCust(Customer cust) {
		custRecs.add(cust);
	}
	
	public void removeCust(Customer cust) {
		custRecs.remove(cust);
	}

}
