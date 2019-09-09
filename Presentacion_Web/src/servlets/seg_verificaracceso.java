package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entidades.seguridad.SEG_UsuarioEL;
import com.logica.seguridad.SEG_UsuarioBL;

@WebServlet("/seg_verificaracceso")
public class seg_verificaracceso extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public seg_verificaracceso() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		PrintWriter out = response.getWriter();
		try {
			String _Usuario = request.getParameter("txtUsuario");
			String _Passw = request.getParameter("txtPassword");
			SEG_UsuarioEL u = SEG_UsuarioBL.Instancia().VerificarAcceso(
														_Usuario, _Passw);
			if(u!=null){
				response.sendRedirect("frmPrincipal.jsp");
			}else{
				out.print("Usuario o Password no Valido");
			}
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}
}
