/*
Student Name: Daniel Stewart    
Student Number: 041029499
Course & Section #: 23S_CST8288_021
Declaration:
This is my own original work and is free from Plagiarism.
*/
package businesslayer;

import dataaccesslayer.PeerTutorDAO;
import dataaccesslayer.PeerTutorDAOImpl;
import java.util.List;
import transferobject.PeerTutor;


/**
 * 
 * The PeerTutorBusinessLogic class contains the business logic for the peer tutor application.
 * 
 * @see PeerTutorDAO
 * @see PeerTutorDAOImpl
 * @see PeerTutor
 * @see List
 * 
 * @author Daniel Stewart
 * @version 1.0
 */
public class PeerTutorBusinessLogic {

    private PeerTutorDAO peerTutorDAO = null;
    private String courseCode;
    
    /**
     * Creates a new PeerTutorBusinessLogic object. It instantiates the PeerTutorDAO
     * implementation, which will be used for interacting with the data access layer to perform
     * data operations related to peer tutors and courses.
     */
    public PeerTutorBusinessLogic() {
        // TODO:  Add your code here.  Need to instantiate a DAO object here.
        peerTutorDAO = new PeerTutorDAOImpl();
    }
    
    /**
     * Checks if a peer tutor is registered based on the provided PeerTutor object.
     *
     * @param peerTutor the PeerTutor object representing the peer tutor to be checked.
     * @return true if the peer tutor is registered; false otherwise.
     */
    public boolean isPeerTutorRegistered(PeerTutor peerTutor) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.isPeerTutorRegistered(peerTutor);
    }
    
    /**
     * Checks if a given course code is valid and exists in the system.
     *
     * @param courseCode the course code to be checked.
     * @return true if the course is valid; false otherwise.
     */
    public boolean isCourseValid(String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.isCourseValid(courseCode);
    }
    
    
    /**
     * Checks if a peer tutor has taken a specific course based on their details and the course code.
     *
     * @param peerTutor the PeerTutor object representing the peer tutor to be checked.
     * @param courseCode the course code to be checked.
     * @return true if the peer tutor has taken the course; false otherwise.
     */ 
    public boolean hasPeerTutorTakenCourse(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.hasPeerTutorTakenCourse(peerTutor, courseCode);
    }
    
    /**
     * Retrieves the letter grade obtained by a peer tutor for a specific course.
     *
     * @param peerTutor the PeerTutor object representing the peer tutor.
     * @param courseCode the course code for which the letter grade is requested.
     * @return the letter grade obtained by the peer tutor for the course, or null if no grade is found.
     */
    public String getPeerTutorLetterGradeForCourse(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.getPeerTutorLetterGradeForCourse(peerTutor, courseCode);
    }
    
    /**
     * Checks if a peer tutor is already assigned to a specific course based on their details
     * and the course code.
     *
     * @param peerTutor the PeerTutor object representing the peer tutor to be checked.
     * @param courseCode the course code to be checked.
     * @return true if the peer tutor is already assigned to the course; false otherwise.
     */
    public boolean isCourseAlreadyAssignedToPeerTutor(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.isCourseAlreadyAssignedToPeerTutor(peerTutor, courseCode);
    }
    
    /**
     * Assigns a specific course to a peer tutor.
     *
     * @param peerTutor the PeerTutor object representing the peer tutor to whom the course is assigned.
     * @param courseCode the course code to be assigned.
     */
    public void assignCourseToPeerTutor(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        peerTutorDAO.assignCourseToPeerTutor(peerTutor, courseCode);
    }
    
    /**
     * Retrieves a list of all peer tutors assigned to a specific course based on the course code.
     *
     * @param courseCode the course code for which the list of peer tutors is requested.
     * @return a List containing all PeerTutor objects assigned to the course.
     */
    public List<PeerTutor> getAllPeerTutorsForCourse(String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.getAllPeerTutorsForCourse(courseCode);
    }
    
}
