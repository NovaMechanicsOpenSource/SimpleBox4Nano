package eu.nanosolveit.restapis;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("apis")
public class RestApplication extends Application{
	
	public RestApplication() {
		init();
	}
	
	private void init() {
	      
  	  BeanConfig beanConfig = new BeanConfig();
      beanConfig.setVersion("1.0.0");
      beanConfig.setSchemes(new String[]{"https"});
      beanConfig.setBasePath("/apis"); // 
      beanConfig.setResourcePackage(RESTApis.class.getPackage().getName());
      //beanConfig.setHost("zetapotential.cloud.nanosolveit.eu");
      //beanConfig.setHost("exposurepbpk.cloud.nanosolveit.eu");
      //beanConfig.setHost("lungexposure.cloud.nanosolveit.eu");
      //beanConfig.setHost("aerosol.cloud.nanosolveit.eu");
      //beanConfig.setHost("facetcytotoxicity.cloud.nanosolveit.eu");
      //beanConfig.setHost("dermal.cloud.nanosolveit.eu");
      beanConfig.setHost("nanoxtract.cloud.nanosolveit.eu");
      //beanConfig.setHost("ecotox.cloud.nanosolveit.eu");
      //beanConfig.setHost("cellviability.cloud.nanosolveit.eu");
      //beanConfig.setHost("mszeta.cloud.nanosolveit.eu");
      //beanConfig.setHost("hamaker.cloud.nanosolveit.eu");
      //beanConfig.setHost("sb4n.cloud.nanosolveit.eu");
      
      
      //beanConfig.setTitle("Zeta Potential Prediction RESTful API"); 
      //beanConfig.setDescription("NanoSolveIT RESTful APIs for Nanoinformatics Model for Zeta Potential Prediction\n"); 
      //beanConfig.setTitle("Exposure PBPK model RESTful API"); 
      //beanConfig.setDescription("NanoSolveIT RESTful APIs for NanoSolveIT IATA: PBPK models having an input of exposure timeseries which the user can produce using a variety of methods\n");
      //beanConfig.setTitle("Lung Exposure RESTful API"); 
      //beanConfig.setDescription("NanoSolveIT RESTful APIs for Lung Exposure Dose Calculator\n");
      //beanConfig.setTitle("Assessment of Human Exposure RESTful API"); 
      //beanConfig.setDescription("NanoSolveIT RESTful APIs for Tool for Assessment of Human Exposure to Nanomaterials");
      //beanConfig.setTitle("Facet Cytotoxicity RESTful API"); 
      //beanConfig.setDescription("NanoSolveIT RESTful APIs for Facet Cytotoxicity: Predicts metal oxide toxicity utilizing facet-based electronic, image, and periodic table properties as descriptors");
      //beanConfig.setTitle("Dermal & Perioral Models RESTful API"); 
      //beanConfig.setDescription("NanoSolveIT RESTful APIs for Dermal & Perioral Models");
      beanConfig.setTitle("NanoXtract Model RESTful API"); 
      beanConfig.setDescription("NanoSolveIT RESTful APIs for NanoXtract Model");
      //beanConfig.setTitle("Ecotox Models RESTful API"); 
      //beanConfig.setDescription("NanoSolveIT RESTful APIs for Ecotox Models");
      //beanConfig.setTitle("Cytotoxicity (Cell Viability) Prediction RESTful API"); 
      //beanConfig.setDescription("NanoSolveIT RESTful APIs for Cytotoxicity (Cell Viability) Prediction for Metal Oxide NPs");
      //beanConfig.setTitle("MS³bD Zeta Potential RESTful API"); 
      //beanConfig.setDescription("NanoSolveIT RESTful APIs for MS³bD Zeta Potential Predictive Μodel");
      //beanConfig.setTitle("Hamaker Constant Calculations RESTful API"); 
      //beanConfig.setDescription("NanoSolveIT RESTful APIs for Hamaker Constant Calculations");
      //beanConfig.setTitle(""); 
      //beanConfig.setDescription("");
      //beanConfig.setTitle(""); 
      //beanConfig.setDescription("");
      
      
      beanConfig.setScan(true);
  }

}
