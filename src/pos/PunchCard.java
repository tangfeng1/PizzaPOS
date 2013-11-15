/**
 * A PunchCard is a record of a User's clock in/out times.
 * 
 * Invariants:
 * A PunchCard must have a User
 * 	@invariant user != null
 * A PunchCard must have a clock-in time
 * 	@invariant clockIn != null
 * clockOut must always be after clockIn
 * 	@invariant clockIn.before(clockOut) == true
 * 
 */

package pos;

import java.util.Date;

public class PunchCard {

	private User user;
	private Date clockIn;
	private Date clockOut;

	/**
	 * Public constructor. A PunchCard starts with:
	 * 
	 * @param user
	 *            a User
	 * @param clockIn
	 *            a clock-in time
	 * 
	 *            These attributes cannot be changed.
	 */
	public PunchCard(User user, Date clockIn) {
		this.user = user;
		this.clockIn = clockIn;
		this.clockOut = null;
	}

	/**
	 * 
	 * @return this User
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 
	 * @return the time/date of this user's clock-in
	 */
	public Date getClockIn() {
		return clockIn;
	}

	/**
	 * 
	 * @return the time/date of this user's clock-out
	 */
	public Date getClockOut() {
		return clockOut;
	}

	/**
	 * 
	 * @param date
	 *            change the time/date of this user's clock-out
	 */
	public void setClockOut(Date date) {
		this.clockOut = date;
	}
}
