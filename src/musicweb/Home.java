package musicweb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.FormDataParam;


@Path("/")
public class Home {

	private static final String SERVER_UPLOAD_LOCATION_FOLDER = "C://Robos/";
	
	
	@Path("/dummy")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String dummy()
	{
		return "Dummy";
	}
	
	
	@Path("login")
	@POST
	  @Produces(MediaType.TEXT_PLAIN)
	  public String login() {
		
		return "Fail";
		
	  }
	
	@Path("register")
	@POST
	
	public String register()
	{
		return "Fail";
	}
	
	
	
	/*
	@Path("/retrieveAccInfo")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User retrieveAccInfo()
	{
		
		
		return new User;
	}
	
	*/
	
	
	
	
	//
	
	@POST
	@Path("subscription")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	
	public String updateSubscription(@FormParam("uname") String uname,
		      @FormParam("aname") String aname,
		      @FormParam("start") String start,
		      @FormParam("end") String end
		      ,@Context HttpServletResponse servletResponse
		      )
	{
		System.out.println("Came here");
		
		
		/*
		try {
			Date s = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(start);
			Date e = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(end);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		*/
		System.out.println(uname);
		System.out.println(aname);
		System.out.println(start);
		System.out.println(end);
		
		return "Fail";
	}
	
	
	
	
	@PUT
	@Path("subscription")
	@Produces(MediaType.TEXT_PLAIN)
	
	
	public String addSubscription(@QueryParam("uname") String uname,
		      @QueryParam("aname") String aname,
		      @QueryParam("start") String start,
		      @QueryParam("end") String end
		      ,@Context HttpServletResponse servletResponse
		      )
	{
		System.out.println("Came here");
		
		
		/*
		try {
			Date s = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(start);
			Date e = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(end);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		*/
		System.out.println(uname);
		System.out.println(aname);
		System.out.println(start);
		System.out.println(end);
		
		return "Fail";
	}
	
	
	
	
	
	
	@DELETE
	@Path("subscription")
	@Produces(MediaType.TEXT_PLAIN)
	
	public String removeSubscription(@QueryParam("uname") String uname,
		      @QueryParam("aname") String aname)
	{
		return "Fail";
		
	}
	
	
	/*
	@Path("subscription")
	@GET
	//how to return multiple JSON?
	public User[] subscriptions()
	{
		return User[]
	}
	
	@Path("publication/subscribers")
	@GET
	//how to return multiple JSON?
	public User[] subscriptions()
	{
		return User[];
	}
	
	
	@Path("publication")
	@GET
	//how to return multiple JSON?
	public Track[] publication()
	{
		return Track[];
	}
	
	
	@Path("publication/new")
	@POST
	
	public String addPublication()
	{
		return "Fail";
	}
	
	@Path("publication/remove")
	@GET
	
	public String removePublication()
	{
		return "Fail";
	}
	
	
	
	
	*/
	
	
	
	
	
	
	
	//////////////////////////////////
	
	
	
	
	
	
    @POST
	@Path("publish")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(
	            @FormDataParam("file") InputStream fileInputStream,
	            @FormDataParam("filename") String filename
	            //@FormDataParam("file") FormDataContentDisposition contentDispositionHeader
			//FormDataMultiPart form
	            ) {
	 
	        
	        
	        
	        String filePath = SERVER_UPLOAD_LOCATION_FOLDER + filename;
	        System.out.println("Came here");
	        if(fileInputStream==null)
	        {
	        	System.out.println("Null!!??");
	        }
	        // save the file to the server
	        saveFile(fileInputStream, filePath);
	        //add publication to DB
	        String output = "File saved to server location : " + filePath;
	 
	        return Response.status(200).entity(output).build();
 
	    }
	 
	    // save uploaded file to a defined location on the server
	    private void saveFile(InputStream uploadedInputStream,
	            String serverLocation) {
	 
	        try {
	            OutputStream outpuStream = new FileOutputStream(new File(serverLocation));
	            int read = 0;
	            byte[] bytes = new byte[1024];
	 
	            outpuStream = new FileOutputStream(new File(serverLocation));
	            while ((read = uploadedInputStream.read(bytes)) != -1) {
	                outpuStream.write(bytes, 0, read);
	            }
	            outpuStream.flush();
	            outpuStream.close();
	        } catch (IOException e) {
	 
	            e.printStackTrace();
	        }
	 
	    }
	 
	
	
	
	
	
	
	
	
	
	
	
	
}
