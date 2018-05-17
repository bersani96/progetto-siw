

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Solo per testare la struttura del database.
 */
@WebServlet("/")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("progetto-siw-test-unit");
		EntityManager em = emf.createEntityManager();
		
		em.close();
		emf.close();
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/struttura.jsp");
		dispatcher.forward(request, response);
	}

}
