package eu.nanosolveit.restapis;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Future;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
//import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
//import org.jboss.resteasy.plugins.providers.multipart.InputPart;
//import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.nanosolveit.simplebox4nano.SimpleBox4NanoApiInput;
import eu.nanosolveit.simplebox4nano.SimpleBox4NanoApiResponse;
import eu.nanosolveit.simplebox4nano.SimpleBox4NanoModel;
import eu.nanosolveit.simplebox4nano.output;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import xyz.euclia.jaqpotj.Jaqpot;
import xyz.euclia.jaqpotj.JaqpotFactory;
import xyz.euclia.jaqpotj.models.Auth;
import xyz.euclia.jaqpotj.models.Prediction;

@Path("/")
@Api(value = "NanoSolveIT REST APIs")
public class RESTApis{
	@POST
	@Path(value = "/restapi")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Returns the various matrixes produced by SB4N", notes = "", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful result production"),
            @ApiResponse(code = 400, message = "Invalid input"),
            //@ApiResponse(code = 415, message = "The content type is unsupported"),
            @ApiResponse(code = 500, message = "An unexpected error has occurred") 
            }) 
	public Response simpleBoxRestAPI( SimpleBox4NanoApiInput userInput) throws Exception
	{		
		if( userInput == null)
			return Response.status(400).type("text/plain").entity("Invalid input\n").build();

		try
		{

			SimpleBox4NanoModel sb4n_input = new SimpleBox4NanoModel( userInput );
			SimpleBox4NanoApiResponse sb4n_out = new SimpleBox4NanoApiResponse();

			sb4n_out.setMasses( sb4n_input.getMasses() );
			sb4n_out.setConcentrations( sb4n_input.getConcentrations() );
			sb4n_out.setFugacities( sb4n_input.getFugacities() );
			sb4n_out.setTransport( sb4n_input.getTransport() );

			sb4n_out.setInflow( sb4n_input.getInflow() );
			sb4n_out.setOutflow( sb4n_input.getOutflow() );
			sb4n_out.setRemoval( sb4n_input.getRemoval() );
			sb4n_out.setFormation( sb4n_input.getFormation() );
			sb4n_out.setDegradation( sb4n_input.getDegradation() );
			sb4n_out.setEmission( sb4n_input.getEmission() );

			sb4n_out.setTotalD( sb4n_input.getTotalD() );
			sb4n_out.setTotalS( sb4n_input.getTotalS() );
			sb4n_out.setTotalA( sb4n_input.getTotalA() );
			sb4n_out.setTotalP( sb4n_input.getTotalP() );

			return Response.ok(sb4n_out).type(MediaType.APPLICATION_JSON).build();
		}
		catch(Exception e)
		{
			return Response.status(500).type("text/plain").entity("An unexpected error has occurred\n").build();
		}
	}
}
