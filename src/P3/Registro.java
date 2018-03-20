package P3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Registro.
 */
@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getSession(false)!=null) {
		
		String url="/WEB-INF/sesion.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);
		request.getSession(false).setMaxInactiveInterval(5);
		}
		else {
	    String url="/WEB-INF/caduca.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
	    String nombre= (String)request.getParameter("username");
	    String apellido= (String)request.getParameter("surname");
	    String email= (String)request.getParameter("email");
	    UsuariosDTO user=new UsuariosDTO(nombre, apellido, email);
	    sesion.setAttribute("nusuario", user);
	    request.setAttribute("nusuario", user);
	    doGet(request, response);
	    
	}

}
