package com.kintohub.httpexample;

import java.io.IOException;
import java.net.InetSocketAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * Basic KintoHub Friendly Sample Response
 * 
 * @author DisTurBinG
 */
public final class JettyServer
{
	private static final String _responseJson = "{ \"data\":\"Hello World\", \"output\":\"%s\" }";
	
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(new InetSocketAddress("0.0.0.0", 80));
        ServletContextHandler context = new ServletContextHandler();
        context.addServlet(SampleHandler.class, "/sample/*");
        server.setHandler(context);
        server.start();
        server.join();
    }
    
    public static class SampleHandler extends HttpServlet {
    	/**
    	 * @api {GET} /sample/{message} Example Java HTTP Response using Jetty Servlets
    	 * 
    	 * @apiName Sample
    	 * 
    	 * @apiParam (Url) {String} Message that you want to be echoed
    	 */
    	@Override
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException
		{
			response.setContentType("application/json");
			response.getWriter().print(String.format(_responseJson, request.getPathInfo().substring(1)));
		
		}
    }
}
    