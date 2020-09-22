package edu.eci.cvds.servlet;

import java.io.IOException;
import java.io.Writer;

import java.net.MalformedURLException;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.eci.cvds.servlet.model.Todo;

@WebServlet(
		urlPatterns = "/jjServlet"
)
public class jojoServlet extends HttpServlet{
    static final long serialVersionUID = 35L;

    @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
		Writer responseWriter = resp.getWriter();
		try {
		   Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
		   String tempid = optId.isPresent() && !optId.get().isEmpty() ? optId.get() : "";
		   int id = Integer.parseInt(tempid);
		   
    	   Todo todo = Service.getTodo(id);
    	   if(todo != null) {
			   resp.setStatus(HttpServletResponse.SC_OK);
    		   ArrayList<Todo> todoList = new ArrayList<>();
    		   todoList.add(todo);
    		   responseWriter.write(Service.todosToHTMLTable(todoList));
			}else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				responseWriter.write("id Incorrecto");
			}
			
    		}catch (MalformedURLException m){
				resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				responseWriter.write("error interno en el servidor");
			}catch(NumberFormatException n){
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				responseWriter.write("formato id no valido");
			}catch (Exception e){
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				responseWriter.write("requerimiento inválido");
			}
	}
	
	 @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Writer responseWriter = resp.getWriter();
		try {
		   Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
		   String tempid = optId.isPresent() && !optId.get().isEmpty() ? optId.get() : "";
		   int id = Integer.parseInt(tempid);
		   
    	   Todo todo = Service.getTodo(id);
    	   if(todo != null) {
			   resp.setStatus(HttpServletResponse.SC_OK);
    		   ArrayList<Todo> todoList = new ArrayList<>();
    		   todoList.add(todo);
    		   responseWriter.write(Service.todosToHTMLTable(todoList));
			}else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				responseWriter.write("id Incorrecto");
			}
			
    		}catch (MalformedURLException m){
				resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				responseWriter.write("error interno en el servidor");
			}catch(NumberFormatException n){
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				responseWriter.write("formato id no valido");
			}catch (Exception e){
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				responseWriter.write("requerimiento inválido");
			}
	}
}





