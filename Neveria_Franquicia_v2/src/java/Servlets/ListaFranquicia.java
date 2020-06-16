/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.*;
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
@WebServlet(name = "ListaFranquicia", urlPatterns = {"/ListaFranquicia"})
public class ListaFranquicia extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Franquicia oFra;
    private Conexion oCon;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //<table border=1><tr>
        
        this.oCon = new Conexion();
        this.oFra = new Franquicia(this.oCon.getConectar());
        
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
                out.println("<html>");
                    out.println("<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"./Images/5008neveria.ico\">");
                    out.println("<head>");
                        out.println("<title>Franquicias | La Nevería</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<body background=\"https://s3-eu-west-1.amazonaws.com/static.lingoda.com/default/0001/12/628ae86177d7ac7f882accb972bf66c18125105f.jpeg\">");
                        //imagen
                        out.println("<img src=\"http://www.laneveria.com.sv/wp-content/uploads/2017/05/Franquicias_3.png\" width=\"1375\" height=\"500\">");
                        out.println("<center>");
                        out.println("<font face=\"Comic Sans MS,arial,verdana\" font size=5px font color=\"white\">");
                            out.println("<h1>Adquiere una franquicia</h1><br>");
                        out.println("</font>");
                            //encabezado de invitación
                        out.println("<h3>");
                        out.println("<font face=\"Bahnschrift\" font size=5px>");
                        out.println("<b>");
                                out.println("<p>Con más de 35 años de historia y</p>"
                                        + "<p>experiencia en la fabricación y</p>"
                                        + "<p>comercialización de helados, paletas y</p>"
                                        + "<p>pasteles en El Salvador y Guatemala.</p>"
                                        + "<br>"
                                        + "<p>La Nevería es una empresa líder en el</p>"
                                        + "<p>mercado contando con la preferencia de</p>"
                                        + "<p>nuestros clientes.</p>"
                                        + "<br>"
                                        + "<p>La Nevería te da la oportunidad de emprender</p>"
                                        + "tu propio negocio a través de nuestro programa de</p>"
                                        + "franquicias, brindándote todo nuestro apoyo para</p>"
                                        + "que puedas tener una fuente de ingreso extra.</p>");
                        out.println("</b>");
                        out.println("</font>");
                        out.println("</h3>");
                        //botón
                        out.println("<br>");
                        out.println("<hr>");
                        out.println("<br>");
                        out.println("<font face=\"Bahnschrift\" font size=5px font color=\"red\">");
                        out.println("<a href= 'NuevoFranquicia' role=\"button\" aria-pressed=\"true\">Agregar nuevo</a><br><br>");
                        out.println("</font>");
                        //tabla a mostrar
                        out.println("<font face=\"Comic Sans MS,arial,verdana\" font size=5px>");
                        out.println("<table border=3\"><tr>"
                                + "<tbody background=\"https://archive-media-0.nyafuu.org/wg/image/1531/69/1531695475640.jpg\">" 
                            + "<td><b>ID</td><td><b>Nombre</td><td><b>Apellido</td>"
                            + "<td><b>País</td><td><b>Dirección</td><td><b>Teléfono</td><td><b>Celular</td><td><b>E-Mail</td><td><b>Borrar</td><td><b>Editar</td></tr>");
                        out.println("<div> <form method='post' action='BuscarId'>");
                            out.println("<div>");
                                out.println("<input type='text' placeholder='Buscar por ID' id='id' name='id'></p>");
                            out.println("</div>");
                        out.println("</div>");
                        out.println("<input type='Submit' value='BUSCAR'></p></form></div>");

                        try {
                            ResultSet rs = this.oFra.consultar();
                            while (rs.next()) {
                                out.println("<tr><td>" + rs.getString(1) + "</td>"
                                    + "<td>" + rs.getString(2).trim() + "</td>"
                                    + "<td>" + rs.getString(3).trim() + "</td>"
                                    + "<td>" + rs.getString(4).trim() + "</td>"
                                    + "<td>" + rs.getString(5).trim() + "</td>"
                                    + "<td>" + rs.getInt(6) + "</td>"
                                    + "<td>" + rs.getInt(7) + "</td>"
                                    + "<td>" + rs.getString(8).trim() + "</td>"
                                    + "<td><a href='BorrarFranquicia?id=" + rs.getString(1).trim() + "'><i>Borrar</i></td>"
                                    + "<td><a href='FormActualizarFranquicia?id=" + rs.getString(1).trim() + "'><i>Editar</i></td></tr>");
                               out.println("<center>");
                            }
                        } catch (Exception e) { }
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
