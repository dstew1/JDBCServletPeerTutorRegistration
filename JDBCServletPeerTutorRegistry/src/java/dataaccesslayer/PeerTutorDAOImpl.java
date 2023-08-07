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

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * An implementation of the PeerTutorDAO interface providing database operations
 * for managing peer tutor-related data in the system.
 *
 * The methods in this class handle SQL queries and transactions for managing peer tutors, courses,
 * and their associations.
 *
 * @author Daniel Stewart
 * @version 1.0
 */
public class PeerTutorDAOImpl implements PeerTutorDAO {
    
    
    /**
     * Checks if a peer tutor is registered in the system based on their first name and last name.
     *
     * @param peerTutor the PeerTutor object representing the peer tutor to check.
     * @return true if the peer tutor is registered, false otherwise.
     */
    @Override
    public boolean isPeerTutorRegistered(PeerTutor peerTutor) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.    
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            
        try {   DataSource ds = new DataSource();
                con = ds.createConnection();
                pstmt = con.prepareStatement(
                            "SELECT COUNT(*) FROM PeerTutor WHERE FirstName = ? AND LastName = ?"); 
                pstmt.setString(1, peerTutor.getFirstName());
                pstmt.setString(2, peerTutor.getLastName());
                rs = pstmt.executeQuery();
                if(rs.next() && rs.getInt(1) > 0){
                    return true;
                }
                else {
                    return false;
                }
        }   
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        finally{
		try{ if(rs != null){ rs.close(); } }
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(pstmt != null){ pstmt.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(con != null){ con.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
	}
          
    }
    
    
    /**
     * Checks if a course with the given course code is valid and exists in the system.
     *
     * @param courseCode the course code to check.
     * @return true if the course is valid and exists, false otherwise.
     */
    @Override
    public boolean isCourseValid(String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {   DataSource ds = new DataSource();
                con = ds.createConnection();
                pstmt = con.prepareStatement(
                    "SELECT COUNT(*) FROM Course WHERE CourseCode = ?"
                    );
                pstmt.setString(1, courseCode);
                rs = pstmt.executeQuery(); 
                if(rs.next() && rs.getInt(1) > 0){
                    return true;
                }
                else{
                    return false;
                }      
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        finally{
		try{ if(rs != null){ rs.close(); } }
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(pstmt != null){ pstmt.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(con != null){ con.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
	}
            
    }
        
        
    /**
     * Checks if a peer tutor has taken a specific course based on their first name, last name,
     * and the course code.
     *
     * @param peerTutor the PeerTutor object representing the peer tutor to check.
     * @param courseCode the course code to check.
     * @return true if the peer tutor has taken the course, false otherwise.
     */
    @Override
    public boolean hasPeerTutorTakenCourse(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {   DataSource ds = new DataSource();
                con = ds.createConnection();
                pstmt = con.prepareStatement(
                    "SELECT COUNT(*) FROM Grade " +
                    "INNER JOIN Student ON Grade.Student_StudentID = Student.StudentID " +
                    "WHERE Student.FirstName = ? AND Student.LastName = ? AND Grade.Course_CourseCode = ?"
                    );
                pstmt.setString(1, peerTutor.getFirstName());
                pstmt.setString(2, peerTutor.getLastName());
                pstmt.setString(3, courseCode);
                rs = pstmt.executeQuery();
                if(rs.next() && rs.getInt(1) > 0){
                    return true;
                }
                else{
                    return false;
                }  
        }    
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        finally{
		try{ if(rs != null){ rs.close(); } }
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(pstmt != null){ pstmt.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(con != null){ con.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
	}

    }

    
    
    /**
     * Retrieves the letter grade of a peer tutor for a specific course based on their first name,
     * last name, and the course code.
     *
     * @param peerTutor the PeerTutor object representing the peer tutor.
     * @param courseCode the course code to check.
     * @return the letter grade obtained by the peer tutor for the course, or null if no grade is found.
     */
    @Override
    public String getPeerTutorLetterGradeForCourse(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {   DataSource ds = new DataSource();
                con = ds.createConnection();
                pstmt = con.prepareStatement(
                    "SELECT GradeCode FROM Grade " +
                    "INNER JOIN Student ON Grade.Student_StudentID = Student.StudentID " +
                    "WHERE Student.FirstName = ? AND Student.LastName = ? AND Grade.Course_CourseCode = ?"
                );
            
                pstmt.setString(1, peerTutor.getFirstName());
                pstmt.setString(2, peerTutor.getLastName());
                pstmt.setString(3, courseCode);
                rs = pstmt.executeQuery();
                    if (rs.next()) {
                        return rs.getString("GradeCode");
                    } else {
                        return null; // Return null if no grade is found for the specified PeerTutor and course.
                    }
        }        
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally{
		try{ if(rs != null){ rs.close(); } }
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(pstmt != null){ pstmt.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(con != null){ con.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
	}
           
    }
    
    
    /**
     * Checks if a course is already assigned to a peer tutor based on their first name, last name,
     * and the course code.
     *
     * @param peerTutor the PeerTutor object representing the peer tutor.
     * @param courseCode the course code to check.
     * @return true if the course is already assigned to the peer tutor, false otherwise.
     */
    @Override
    public boolean isCourseAlreadyAssignedToPeerTutor(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {   DataSource ds = new DataSource();
                con = ds.createConnection();
                pstmt = con.prepareStatement(
                    "SELECT COUNT(*) FROM PeerTutorCourse " +
                    "INNER JOIN PeerTutor ON PeerTutorCourse.PeerTutor_PeerTutorID = PeerTutor.PeerTutorID " +
                    "WHERE PeerTutor.FirstName = ? AND PeerTutor.LastName = ? AND PeerTutorCourse.Course_CourseCode = ?"
                );
            
                pstmt.setString(1, peerTutor.getFirstName());
                pstmt.setString(2, peerTutor.getLastName());
                pstmt.setString(3, courseCode);
                rs = pstmt.executeQuery(); 
                if(rs.next() && rs.getInt(1) > 0){
                    return true;
                }
                else{
                    return false;
                }
     
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally{
		try{ if(rs != null){ rs.close(); } }
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(pstmt != null){ pstmt.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(con != null){ con.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
	}
    }


    /**
     * Assigns a course to a peer tutor based on their first name, last name, and the course code.
     *
     * @param peerTutor the PeerTutor object representing the peer tutor.
     * @param courseCode the course code to assign to the peer tutor.
     */
    @Override
    public void assignCourseToPeerTutor(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int peerTutorID;
        
        try {   DataSource ds = new DataSource();
                con = ds.createConnection();
                pstmt = con.prepareStatement(
                    "SELECT PeerTutorID FROM PeerTutor WHERE FirstName = ? AND LastName = ?"
                );
                
                pstmt.setString(1, peerTutor.getFirstName());
                pstmt.setString(2, peerTutor.getLastName());
                rs = pstmt.executeQuery();
                
                if (rs.next()){
                    peerTutorID = rs.getInt("PeerTutorID");
                }
                else{
                    throw new IllegalArgumentException("Peer Tutor not found");
                }
                
                pstmt = con.prepareStatement("INSERT INTO PeerTutorCourse (PeerTutor_PeerTutorID, Course_CourseCode) VALUES (?, ?)");
                pstmt.setInt(1, peerTutorID);
                pstmt.setString(2, courseCode);
                pstmt.executeUpdate();
            } 
        catch (SQLException e) {
                e.printStackTrace();
            // Handle the exception appropriately, e.g., throw a custom exception or log the error.
        }
        finally{
		try{ if(pstmt != null){ pstmt.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(con != null){ con.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
	}
            
    }

    /**
     * Retrieves a list of all peer tutors associated with a specific course based on the course code.
     *
     * @param courseCode the course code to retrieve associated peer tutors.
     * @return peerTutors a List containing PeerTutor objects representing all peer tutors for the course.
     */
    @Override
    public List<PeerTutor> getAllPeerTutorsForCourse(String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.
        List<PeerTutor> peerTutors = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {   DataSource ds = new DataSource();
                con = ds.createConnection();
                pstmt = con.prepareStatement(
                    "SELECT PeerTutorID, LastName, FirstName FROM PeerTutor pt " +
                    "INNER JOIN PeerTutorCourse ptc ON pt.PeerTutorID = ptc.PeerTutor_PeerTutorID " +
                    "WHERE ptc.Course_CourseCode = ?"
                );
           
                pstmt.setString(1, courseCode);
                rs = pstmt.executeQuery();
                    while (rs.next()) {
                        PeerTutor peerTutor = new PeerTutor();
                        peerTutor.setPeerTutorID(rs.getInt("PeerTutorID"));
                        peerTutor.setFirstName(rs.getString("FirstName"));
                        peerTutor.setLastName(rs.getString("LastName"));
                        peerTutors.add(peerTutor);
                    }
                
        }
        catch (SQLException e) {
                    e.printStackTrace();
                    // Handle the exception appropriately, e.g., throw a custom exception or log the error.
        }
        finally{
		try{ if(rs != null){ rs.close(); } }
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(pstmt != null){ pstmt.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
		try{ if(con != null){ con.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
	}
        return peerTutors;
          
    }
    
}
