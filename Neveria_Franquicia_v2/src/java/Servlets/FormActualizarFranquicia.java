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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AA2020
 */
@WebServlet(name = "FormActualizarFranquicia", urlPatterns = {"/FormActualizarFranquicia"})
public class FormActualizarFranquicia extends HttpServlet {

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
            
            Conexion oCon = new Conexion();
            Franquicia oFra = new Franquicia(oCon.getConectar());
            String pId = request.getParameter("id");
            oFra.SetID(pId);
            
            out.println("<!DOCTYPE html>");
                out.println("<html>");
                    out.println("<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"./Images/5008neveria.ico\">");
                    out.println("<head>");
                        out.println("<title>Actualizar | La Nevería</title>");
                    out.println("</head>");
                    out.println("<body><form method='post' action='ActualizarFranquicia'>");
                    out.println("<body background=\"https://s3-eu-west-1.amazonaws.com/static.lingoda.com/default/0001/12/628ae86177d7ac7f882accb972bf66c18125105f.jpeg\">");
                        //imagen
                        out.println("<img src=\"http://www.laneveria.com.sv/wp-content/uploads/2017/05/Franquicias_3.png\" width=\"1375\" height=\"500\">");
                        out.println("<center>");
                        out.println("<font face=\"Comic Sans MS,arial,verdana\" font size=5px font color=\"white\">");
                        out.println("<h1>Actualice la información del interesado</h1>");
                        out.println("</font>");
                        out.println("<hr>");
                        out.println("<br>");
                        out.println("<font face=\"Comic Sans MS,arial,verdana\" font size=5px>");
                            out.println("<b>ID:</b> <input class=\"form-control form-control-sm\" type='text' id='id' name='id' readonly "
                                    + "value='" + oFra.GetID()+ "'></p>");
                            out.println("<b>Nombre:</b> <input class=\"form-control form-control-sm\" type='text' id='nombre' name='nombre' placeholder='Escribe tus nombres'></p>");
                            out.println("<b>Apellido:</b> <input class=\"form-control form-control-sm\" type='text' id='apellido' name='apellido' placeholder='Escribe tus apellidos'></p>");
                            out.println("<b>País:</b> <input class=\"form-control form-control-sm\" type='text' id='pais' name='pais' placeholder='Tres caracteres únicamente'></p>");
                            out.println("<b>Dirección:</b> <textarea input class=\"form-control form-control-sm\" type='text' id='direccion' name='direccion' placeholder='Escribe la dirección exacta'></textarea></p>");
                            out.println("<b>Teléfono:</b> <input class=\"form-control form-control-sm\" type='text' id='telefono' name='telefono' placeholder='Número de teléfono sin guión'></p>");
                            out.println("<b>Celular:</b> <input class=\"form-control form-control-sm\" type='text' id='celular' name='celular' placeholder='Número de celular sin guión'></p>");
                            out.println("<b>E-Mail:</b> <input class=\"form-control form-control-sm\" type='text' id='mail' name='mail' placeholder='Escribe tu email'></p>");
                            out.println("<input type='Submit'  class=\"btn btn-outline-primary mx-3\" value='ACTUALIZAR INFORMACIÓN'></p>");
                        out.println("</form></body>");
                        out.println("</font>");
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
