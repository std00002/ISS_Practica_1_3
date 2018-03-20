package P3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sesion3
 */
@WebServlet("/Sesion3")
public class Sesion3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sesion3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<UsuariosDTO> usuarios = new ArrayList<UsuariosDTO>();
		UsuariosDTO user1= new UsuariosDTO("Diego","Ortega","doc_95@hotmail.com");
		UsuariosDTO user2= new UsuariosDTO("Antonio","Trujillo","atd@hotmail.com");
		UsuariosDTO user3= new UsuariosDTO("Salvador","Trujillo","std@hotmail.com");
		usuarios.add(user1);
		usuarios.add(user2);
		usuarios.add(user3);
		request.setAttribute("usuarios", usuarios);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String usuario=request.getParameter("usuario");
		String passwd=request.getParameter("clave");
		String url="";
		UsuariosDTO db= new UsuariosDTO();
		if(db.checkAdmin(usuario,passwd)) {
			doGet(request, response);
			url="/WEB-INF/admin.jsp";
			
		}else url="/WEB-INF/registro.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);

		
		
	}

}