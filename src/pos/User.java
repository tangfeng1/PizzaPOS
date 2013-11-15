/**
 * A User is anyone with access to the POS system (e.g. Cook, Manager, Driver,
 * etc.). This class defines the basic fields and functionalities of a User, and
 * is extended to perform specific functions regarding access control.
 * 
 * A User has a name, user id, and password. 
 * 
 */

package pos;

public class User {

	private String name, id, passwd;

	/**
	 * Public constructor. A User has a:
	 * 
	 * @param name
	 *            the name of the user
	 * @param id
	 *            their user id
	 * @param passwd
	 *            their password
	 */
	public User(String name, String id, String passwd) {
		this.name = name;
		this.id = id;
		this.passwd = passwd;
	}

	/**
	 * 
	 * @return the name of the user
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return the id number of the user
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @return the password of the user
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * @param user
	 *            Write the contents of a user to the database
	 */
	public void toDB(User user) {
	}

	/**
	 * 
	 * @return a User object that has been loaded from the database
	 */
	public User fromDB() {
		return null;
	}
}
