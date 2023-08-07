/*
Student Name: Daniel Stewart    
Student Number: 041029499
Course & Section #: 23S_CST8288_021
Declaration:
This is my own original work and is free from Plagiarism.
*/
package viewlayer;

import businesslayer.PeerTutorBusinessLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobject.PeerTutor;

/**
 * Servlet implementation class PeerTutorServlet.
 * This servlet handles the requests for registering a peer tutor for a course and displays the list of peer tutors for a specific course.
 *
 * @author Daniel Stewart   
 * @version 1.0
 */
public class PeerTutorServlet extends HttpServlet {
    private PeerTutor tutor =new PeerTutor();
    private String courseCode = null;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>PeerTutorServlet</title>");            
            out.println("</head>");
            out.println("<body BGCOLOR=\"#FDF5E6\">");
            out.println("<h1>Servlet PeerTutorServlet at " + request.getContextPath() + "</h1>");
          
            tutor.setFirstName(request.getParameter("firstName"));
            tutor.setLastName(request.getParameter("lastName"));
            courseCode = request.getParameter("course");
            
            PeerTutorBusinessLogic logic = new PeerTutorBusinessLogic();
            List<PeerTutor> peerTutors = logic.getAllPeerTutorsForCourse(courseCode);
            
            if (!logic.isPeerTutorRegistered(tutor)){
                out.println("<ul>"
                                + "<li>FirstName: " + tutor.getFirstName() + "</li>" 
                                + "<li>LastName: " + tutor.getLastName() + "</li>"
                                +
                            "</ul>");
                out.println("<B>Error: The person is not registered as a peer tutor<B>");
            }
            else if(!logic.isCourseValid(courseCode)){
                out.println("<ul>"
                                + "<li>courseCode: " + courseCode + "</li>" 
                                +
                            "</ul>");
                out.println("<B>Error: The course is not valid.<B>");
            }
            else if (!logic.hasPeerTutorTakenCourse(tutor, courseCode)){
                out.println("<ul>"
                                + "<li>FirstName: " + tutor.getFirstName() + "</li>" 
                                + "<li>LastName: " + tutor.getLastName() + "</li>"
                                + "<li>courseCode: " + courseCode + "</li>"
                                +   
                            "</ul>");
                out.println("<B>Error: The peer tutor has not taken the course<B>");
            }
            else {
                if(!logic.getPeerTutorLetterGradeForCourse(tutor, courseCode).contains("A")){
                    out.println("<ul>"
                                + "<li>FirstName: " + tutor.getFirstName() + "</li>" 
                                + "<li>LastName: " + tutor.getLastName() + "</li>"
                                + "<li>courseCode: " + courseCode + "</li>"
                                +   
                            "</ul>");
                    out.println("<B>Error: The letter grade obtained by the peer tutor for the course is not sufficient<B>");
                }
                else if(logic.isCourseAlreadyAssignedToPeerTutor(tutor, courseCode)){
                    out.println("<ul>"
                                + "<li>FirstName: " + tutor.getFirstName() + "</li>" 
                                + "<li>LastName: " + tutor.getLastName() + "</li>"
                                + "<li>courseCode: " + courseCode + "</li>"
                                +   
                            "</ul>");
                    out.println("<B>Error: The peer tutor is already assigned to the course<B>");
                }
                else{
                    logic.assignCourseToPeerTutor(tutor, courseCode);
                    peerTutors = logic.getAllPeerTutorsForCourse(courseCode);
                    out.println("<B>Table of Peer Tutors for CST8101<B>");
                    out.println("<table border=\"1\">");
                    out.println("<tr>");
                        out.println("<td>Tutor ID</td>");
                        out.println("<td>First Name</td>");
                        out.println("<td>Last Name</td>");
                     out.println("</tr>");
            
                    for(PeerTutor tutor : peerTutors){
                        out.printf("<tr><td>%d</td><td>%s</td><td>%s</td></tr>",
                    tutor.getPeerTutorID(), tutor.getFirstName(), tutor.getLastName());
                    }
                    out.println("</table>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }          
           
            
        } 
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
