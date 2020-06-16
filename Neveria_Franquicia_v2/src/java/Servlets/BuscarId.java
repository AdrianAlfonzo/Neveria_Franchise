/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.Conexion;
import Clases.Franquicia;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AA2020
 */
@WebServlet(name = "BuscarId", urlPatterns = {"/BuscarId"})
public class BuscarId extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Franquicia oFran;
    private Conexion oCon;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            this.oCon = new Conexion();
            this.oFran = new Franquicia(this.oCon.getConectar());
            String pId = request.getParameter("id");
            try {
                ResultSet rs = oFran.BuscarUser(Integer.parseInt(pId));

                while (rs.next()) {
                    out.println("<!DOCTYPE html>");
                        out.println("<html>");
                            out.println("<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"./Images/5008neveria.ico\">");
                            out.println("<head>");
                                out.println("<title>Buscar por ID | La Nevería</title>");
                            out.println("</head>");
                            out.println("<body>");
                            out.println("<body background=\"https://s3-eu-west-1.amazonaws.com/static.lingoda.com/default/0001/12/628ae86177d7ac7f882accb972bf66c18125105f.jpeg\">");
                            //imagen
                            out.println("<img src=\"http://www.laneveria.com.sv/wp-content/uploads/2017/05/Franquicias_3.png\" width=\"1375\" height=\"500\">");
                            out.println("<center>");
                                out.println("<font face=\"Comic Sans MS,arial,verdana\" font size=5px font color=\"white\">");
                                    out.println("<h1>Listado de interesados</h1>");
                                out.println("</font>");
                                out.println("<hr>");
                                out.println("<br>");
                                out.println("<font face=\"Comic Sans MS,arial,verdana\" font size=5px>");
                                    out.println("<table border=3><tr>" 
                                    + "<tbody background=\"https://archive-media-0.nyafuu.org/wg/image/1531/69/1531695475640.jpg\">" 
                                                + "<td><b>ID</td><td><b>Nombre</td><td><b>Apellido</td>"
                                                + "<td><b>País</td><td><b>Dirección</td><td><b>Teléfono</td>"
                                                + "<td><b>Celular</td><td><b>E-Mail</td><td><b>Borrar</td><td><b>Editar</td></tr>");
                                                out.println("<tr><td>" + rs.getString(1) + "</td>"
                                                + "<td>" + rs.getString(2).trim() + "</td>"
                                                + "<td>" + rs.getString(3).trim() + "</td>"
                                                + "<td>" + rs.getString(4).trim() + "</td>"
                                                + "<td>" + rs.getString(5).trim() + "</td>"
                                                + "<td>" + rs.getInt(6) + "</td>"
                                                + "<td>" + rs.getInt(7) + "</td>"
                                                + "<td>" + rs.getString(8).trim() + "</td>"
                                                + "<td><a href='BorrarFranquicia?id=" + rs.getString(1).trim() + "'>Borrar</td>"
                                                + "<td><a href='FormActualizarFranquicia?id=" + rs.getString(1).trim() + "'>Editar</td>");
                                                out.println("<font face=\"Bahnschrift\" font size=5px font color=\"red\">");
                                                    out.println("<a href= 'ListaFranquicia' role=\"button\">Ver lista completa</a><br><br>");
                                                out.println("<font>");
                                            }
                                            } catch (Exception ee) { }
                                    out.println("</table>");
                                out.println("</font>");
                            out.println("</body>");
                        out.println("</html>");
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
