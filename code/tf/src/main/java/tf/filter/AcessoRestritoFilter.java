package tf.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

import com.sun.tools.javac.util.Context;

/**
 * Garante que as p�ginas restritas v�o passar primeiro pela autentica��o
 * 
 * @author chester
 * 
 */
public class AcessoRestritoFilter implements javax.servlet.Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// Se houver usu�rio autenticado na sess�o (ou se for a pr�pria p�gina
		// de login
		// ou seu back-end), beleza, sen�o exige autentica��o
		HttpServletRequest req = (HttpServletRequest) request;
		if (req.getServletPath().equals("/Autenticacao.action")
				|| req.getServletPath().equals("/comum/login.jsp")
				|| req.getServletPath().equals("/comum/popula.jsp")
				|| req.getServletPath().startsWith("/stylesheets")
				|| req.getServletPath().startsWith("/img")
				|| (req.getSession().getAttribute("usuario") != null)) {
			chain.doFilter(request, response);
		} else {
			req.getRequestDispatcher("/comum/login.jsp").forward(request, response);
		}

	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

}
