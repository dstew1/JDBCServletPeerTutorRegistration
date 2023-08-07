/*
Student Name: Daniel Stewart    
Student Number: 041029499
Course & Section #: 23S_CST8288_021
Declaration:
This is my own original work and is free from Plagiarism.
*/
package dataaccesslayer;

import java.util.List;
import transferobject.PeerTutor;

/**
 * The PeerTutorDAO interface provides methods for accessing and managing peer tutor-related data
 * in the system. 
 * 
 * @author Daniel Stewart
 * @version 1.0
 */
public interface PeerTutorDAO {
    boolean isPeerTutorRegistered(PeerTutor peerTutor);
    boolean isCourseValid(String courseCode);
    boolean hasPeerTutorTakenCourse(PeerTutor peerTutor, String courseCode);
    String getPeerTutorLetterGradeForCourse(PeerTutor peerTutor, String courseCode);
    boolean isCourseAlreadyAssignedToPeerTutor(PeerTutor peerTutor, String courseCode);
    void assignCourseToPeerTutor(PeerTutor peerTutor, String courseCOde);
    List<PeerTutor> getAllPeerTutorsForCourse(String courseCode);
}

