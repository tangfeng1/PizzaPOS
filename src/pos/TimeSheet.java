/**
 * TimeSheet tracks the clock ins/outs of all users in the system by storing
 * PunchCard objects in an ArrayList
 * 
 */

package pos;

import java.util.ArrayList;
import java.util.Date;

public class TimeSheet {

	private ArrayList<PunchCard> punchCards;

	/**
	 * Public constructor. A TimeSheet starts with:
	 * 
	 * @param punchCards
	 *            a list of all punchcards that are currently active
	 */
	public TimeSheet(ArrayList<PunchCard> punchCards) {
		this.punchCards = punchCards;
	}

	public TimeSheet() {

	}

	/**
	 * Creates a PunchCard using a user and a clockIn, and then stores this
	 * PunchCard in punchCards
	 * 
	 * @param user
	 * @param clockIn
	 */
	public void clockIn(User user, Date clockIn) {
		punchCards.add(new PunchCard(user, clockIn));
	}

	/**
	 * Takes a PunchCard, finds it in punchCards and sets its clockOut time
	 * 
	 * @param toClockOut
	 */
	public void clockOut(PunchCard toClockOut, Date date) {
		punchCards.remove(toClockOut);
		toClockOut.setClockOut(date);
	}

	/**
	 * Takes a PunchCard, finds it in punchCards, and returns a pointer to it
	 * 
	 * @param toFind
	 * @return a pointer to a PunchCard in punchCards
	 */
	public int findPunchCard(PunchCard toFind) {
		return punchCards.indexOf(toFind);
	}

	/**
	 * @param timeSheet
	 *            Write the contents of TimeSheet to the database
	 * 
	 * @post A TimeSheet object has been written to the database
	 */
	public void toDB(TimeSheet timeSheet) {
	}

	/**
	 * 
	 * @return a PunchCard object that has been loaded from the database
	 * 
	 * @post A TimeSheet object has been created from the database
	 */
	public TimeSheet fromDB() {
		return null;
	}
}
