/*
Student Name: Daniel Stewart    
Student Number: 041029499
Course & Section #: 23S_CST8288_021
Declaration:
This is my own original work and is free from Plagiarism.
*/

package transferobject;

/**
 * Represents a Peer Tutor with the following attributes: peerTutorID, lastName, and firstName.
 * This class provides getters and setters for accessing and modifying the attributes.
 * 
 * @author Daniel Stewart   
 * @version 1.0
 */
public class PeerTutor {

    // Here are the fields for a peer tutor.
    private int peerTutorID;
    private String lastName;
    private String firstName;

    /**
     * Gets the ID of the Peer Tutor.
     *
     * @return peerTutorID the ID of the Peer Tutor.
     */
    public int getPeerTutorID() {
        return peerTutorID;
    }

    /**
     * Sets the ID of the Peer Tutor.
     *
     * @param peerTutorID the ID to set for the Peer Tutor.
     */
    public void setPeerTutorID(int peerTutorID) {
        this.peerTutorID = peerTutorID;
    }

    /**
     * Gets the last name of the Peer Tutor.
     *
     * @return lastName the last name of the Peer Tutor.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the Peer Tutor.
     *
     * @param lastName the last name to set for the Peer Tutor.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the first name of the Peer Tutor.
     *
     * @return firstName the first name of the Peer Tutor.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the Peer Tutor.
     *
     * @param firstName the first name to set for the Peer Tutor.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    

}
