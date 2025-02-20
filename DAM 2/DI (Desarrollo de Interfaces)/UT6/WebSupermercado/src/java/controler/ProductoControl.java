/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.ProductoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Producto;

/**
 *
 * @author Alfonso
 */
public class ProductoControl extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LibroControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LibroControl at " + request.getContextPath() + "</h1>");
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

        try {
            // Validación de parámetros recibidos
            String codigoStr = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            String cantidadStr = request.getParameter("cantidad_inventario");
            String precioStr = request.getParameter("precio");
            String categoriaStr = request.getParameter("categoria");
            String proveedor = request.getParameter("proveedor");
            String accion = request.getParameter("accion").toLowerCase();

  
            int codigo = codigoStr != null && !codigoStr.isEmpty() ? Integer.parseInt(codigoStr) : 0;
            int cantidad = cantidadStr != null && !cantidadStr.isEmpty() ? Integer.parseInt(cantidadStr) : 0;
            float precio = precioStr != null && !precioStr.isEmpty() ? Float.parseFloat(precioStr) : 0.0f;
            int categoria = categoriaStr != null && !categoriaStr.isEmpty() ? Integer.parseInt(categoriaStr) : 0;

            Producto p = new Producto();
            p.setCodigo(codigo);
            p.setNombre(nombre);
            p.setDescripcion(descripcion);
            p.setCantidad_inventario(cantidad);
            p.setPrecio(precio);
            p.setCodigo_categoria(categoria);
            p.setId_poveedor(proveedor);

            // Acciones basadas en la solicitud
            switch (accion) {
                case "registrar":
                    if (ProductoDao.registrar(p)) {
                        request.setAttribute("mensaje", "Producto registrado con éxito.");
                    } else {
                        request.setAttribute("mensaje", "Error al registrar el producto.");
                    }
                    break;

                case "actualizar":
                    if (ProductoDao.actualizar(p)) {
                        request.setAttribute("mensaje", "Producto actualizado con éxito.");
                    } else {
                        request.setAttribute("mensaje", "Error al actualizar el producto.");
                    }
                    break;

                case "eliminar":
                    if (ProductoDao.eliminar(p)) {
                        request.setAttribute("mensaje", "Producto eliminado con éxito.");
                    } else {
                        request.setAttribute("mensaje", "Error al eliminar el producto.");
                    }
                    break;

                default:
                    request.setAttribute("mensaje", "Acción desconocida.");
                    break;
            }
        } catch (NumberFormatException e) {
            request.setAttribute("mensaje", "Error: Datos numéricos inválidos.");
        } catch (SQLException ex) {
            Logger.getLogger(ProductoControl.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("mensaje", "Error al interactuar con la base de datos.");
        }

        // Redirigir de vuelta al formulario con el mensaje
        request.getRequestDispatcher("registroProducto.jsp").forward(request, response);
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
