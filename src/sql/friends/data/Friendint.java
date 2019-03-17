package sql.friends.data;

public interface Friendint {

	/**
	 * @see int id, String name, String city, int age
	 * @param Friend friend
	 */
	void AddFriend();

	/**
	 * @see int id
	 * @param Friend friend
	 */
	Friend ReadFriend();

	/**
	 * @see nothing
	 * @param Friend friend
	 */
	Friend ReadAll();

	/**
	 * @see exciting id, new name, new city, new age
	 * @param Friend friend
	 */
	void UpdateName();

	/**
	 * @see exciting id
	 * @param id
	 */
	void DeleteFriend();

	/**
	 * @see exciting id
	 * @param nothing
	 */
	void DeleteAll();

	void UpdateCity();

	void UpdateAge();

	void DeleteTable();

}
