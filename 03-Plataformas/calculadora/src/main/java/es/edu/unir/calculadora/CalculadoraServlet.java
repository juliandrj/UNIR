package es.edu.unir.calculadora;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.sourceforge.jeval.Evaluator;

/**
 * Servlet implementation class CalculadoraServlet
 */
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger log = Logger.getLogger(getClass());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculadoraServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("utf8");
			if (request.getParameter("expresion") == null) {
				throw new Exception("nada para calcular");
			}
			Evaluator evaluator = new Evaluator();
			String valor = evaluator.evaluate(request.getParameter("expresion"));
			out.print("{\"status\":\"ok\",\"resultado\":\"" + valor + "\"}");
			log.info("evaluado: " + request.getParameter("expresion") + " = " + valor);
		} catch (Exception ex) {
			log.error("No se logro hacer el calculo: " + request.getParameter("expresion"), ex);
			out.print("{\"status\":\"fail\",\"mensaje\":\"" + ex.getMessage() + "\"}");
		}
		out.flush();
	}

}
