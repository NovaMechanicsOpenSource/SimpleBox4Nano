package eu.nanosolveit.simplebox4nano;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.zkoss.zk.ui.Sessions;

import eu.nanosolveit.simplebox4nano.Engine.Engine;
import eu.nanosolveit.simplebox4nano.Engine.InputEngine;
import eu.nanosolveit.simplebox4nano.Engine.RegionalEngine;

public class SimpleBox4NanoModel {

	InputEngine input = null;
	RegionalEngine environment = null;
	Engine engine = null;	

	Map<String, Map<String, String> > nanoData = new HashMap<String, Map<String, String> >(); 
	Map<String, Scenario> scenariosData = new HashMap<String, Scenario >();

	String nanoName = null;
	String sceneName = null;
	
	output out = null;

	public SimpleBox4NanoModel( SimpleBox4NanoApiInput userInput ) throws Exception {

		sceneName = userInput.getScenario();
		nanoName = userInput.getNanomaterial();

		loadScenarios();

		//Replace with user values or from the API
		scenariosData.get( sceneName ).putSolidInfo("REGIONAL", "E.aRS",  String.valueOf( userInput.getE_aRS() ) );
		scenariosData.get( sceneName ).putSolidInfo("REGIONAL", "E.w0RS", String.valueOf( userInput.getE_w0RS() ) );
		scenariosData.get( sceneName ).putSolidInfo("REGIONAL", "E.w1RS", String.valueOf( userInput.getE_w1RS() ) );
		scenariosData.get( sceneName ).putSolidInfo("REGIONAL", "E.w2RS", String.valueOf( userInput.getE_w2RS() ) );
		scenariosData.get( sceneName ).putSolidInfo("REGIONAL", "E.s1RS", String.valueOf( userInput.getE_s1RS() ) );
		scenariosData.get( sceneName ).putSolidInfo("REGIONAL", "E.s2RS", String.valueOf( userInput.getE_s2RS() ) );
		scenariosData.get( sceneName ).putSolidInfo("REGIONAL", "E.s3RS", String.valueOf( userInput.getE_s3RS() ) );

		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "AREAland.R", String.valueOf( userInput.getAREAland_R() )  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "AREAsea.R",  String.valueOf( userInput.getAREAsea_R() ) ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "FRAClake.R", String.valueOf( userInput.getFRAClake_R() ) ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "FRACfresh.R",  String.valueOf( userInput.getFRACfresh_R() ) ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "FRACnatsoil.R", String.valueOf( userInput.getFRACnatsoil_R() ) );
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "FRACagsoil.R",  String.valueOf( userInput.getFRACagsoil_R() )) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "FRACothersoil.R", String.valueOf( userInput.getFRACothersoil_R() ) ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "RAINrate.R",  String.valueOf( userInput.getRAINrate_R() ) ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "TEMP.R",  String.valueOf( userInput.getTEMP_R() ) ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "WINDspeed.R", String.valueOf( userInput.getWINDspeed_R() ) ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "DEPTHlake.R",  String.valueOf( userInput.getDEPTHlake_R() ) ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "DEPTHfreshwater.R", String.valueOf( userInput.getDEPTHfreshwater_R() ) ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "FRACrun.R",   String.valueOf( userInput.getFRACrun_R() ) ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "FRACinf.R",   String.valueOf( userInput.getFRACinf_R() ) ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "EROSION.R",   String.valueOf( userInput.getEROSION_R() ) ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "SUSP.w0R",  String.valueOf( userInput.getSUSP_w0R() ) ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "SUSP.w1R",   String.valueOf( userInput.getSUSP_w1R() ) ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "SUSP.w2R",   String.valueOf( userInput.getSUSP_w2R() ) ) ;

		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "TOTAREAland.C",  String.valueOf( userInput.getTOTAREALand_C() ) );
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "TOTAREAsea.C",  String.valueOf( userInput.getTOTAREAsea_C() ) );
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "FRAClake.C",   String.valueOf( userInput.getFRAClake_C() ) );
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "FRACfresh.C",   String.valueOf( userInput.getFRACfresh_C() ) );
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "FRACnatsoil.C",   String.valueOf( userInput.getFRACnatsoil_C() ) );
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "FRACagsoil.C",   String.valueOf( userInput.getFRACagsoil_C() ) );
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "FRACothersoil.C",  String.valueOf( userInput.getFRACothersoil_C() ) );
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "RAINrate.C",   String.valueOf( userInput.getRAINrate_C() ) );
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "TEMP.C",   String.valueOf( userInput.getTEMP_C() ) );
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "WINDspeed.C",  String.valueOf( userInput.getWINDspeed_C() ) );
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "DEPTHlake.C",  String.valueOf( userInput.getDEPTHlake_C() ) );
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "DEPTHfreshwater.C", String.valueOf( userInput.getDEPTHfreshwater_C() ) ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "FRACrun.C", String.valueOf( userInput.getFRACrun_C() ) );
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "FRACinf.C", String.valueOf( userInput.getFRACinf_C() ) );
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "EROSION.C", String.valueOf( userInput.getEROSION_C() ) );
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "SUSP.w0C", String.valueOf( userInput.getSUSP_w0C() ) );
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "SUSP.w1C", String.valueOf( userInput.getSUSP_w1C() ) );
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "SUSP.w2C", String.valueOf( userInput.getSUSP_w2C() ) );

		//load all available nanomaterials
		//The nanomaterials (as the scenarios) must be re-loaded for the values that are not set by the user (in case of API call). 
		loadNanomaterials();


		//Replace with user values or from the API
		//		for( String entry:nano.get(nanoName).keySet() ) 
		//			nanoData.get(nanoName).put(entry, nano.get(nanoName).get(entry) );

		input = new InputEngine( scenariosData.get( sceneName ), nanoData.get( nanoName ) );
		environment = new RegionalEngine( input );
		engine = new Engine( input, environment, nanoData.get( nanoName ), scenariosData.get( sceneName )	);
		engine.build();		
		
		out = new output();
		out.setAPIInfo(input, environment, engine, getNanoData(), sceneName, nanoName);
	}
	
	public Map<String, Map<String, Map<String, Double> > > getMasses() { return out.masses; }
	public Map<String, Map<String, Map<String, Double> > > getConcentrations() { return out.concentrations; }
	public Map<String, Map<String, Map<String, Double> > > getFugacities() { return out.fugacities; }
	public Map<String, Map<String, Map<String, Double> > > getTransport() { return out.transport; }

	public Map<String, Map<String, Double> > getInflow() { return out.inflow; }
	public Map<String, Map<String, Double> > getOutflow() { return out.outflow; }
	public Map<String, Map<String, Double> > getRemoval() { return out.removal; }
	public Map<String, Map<String, Double> > getFormation() { return out.formation; }
	public Map<String, Map<String, Double> > getDegradation() { return out.degradation; }
	public Map<String, Map<String, Double> > getEmission() { return out.emission; }

	public Map<String, Double> getTotalD() { return out.totalD; }
	public Map<String, Double> getTotalS() { return out.totalS; }
	public Map<String, Double> getTotalA() { return out.totalA; }
	public Map<String, Double> getTotalP() { return out.totalP; }
	
	public SimpleBox4NanoModel( Map<String, Map<String, String> > nano, Map<String, Scenario> scenarios, 
			String scenario, String nanomaterial ) throws Exception
	{	
		sceneName = scenario;
		nanoName = nanomaterial;

		//Load all scenarios
		//The scenarios must be re-loaded for the values that are not set by the user (in case of API call). 
		loadScenarios();

		//Replace with user values or from the API
		scenariosData.get( sceneName ).putSolidInfo("REGIONAL", "E.aRS",  scenarios.get( sceneName ).getSolidInfo( "REGIONAL").get("E.aRS") );
		scenariosData.get( sceneName ).putSolidInfo("REGIONAL", "E.w0RS", scenarios.get( sceneName ).getSolidInfo( "REGIONAL").get("E.w0RS"));
		scenariosData.get( sceneName ).putSolidInfo("REGIONAL", "E.w1RS", scenarios.get( sceneName ).getSolidInfo( "REGIONAL").get("E.w1RS"));
		scenariosData.get( sceneName ).putSolidInfo("REGIONAL", "E.w2RS", scenarios.get( sceneName ).getSolidInfo( "REGIONAL").get("E.w2RS"));
		scenariosData.get( sceneName ).putSolidInfo("REGIONAL", "E.s1RS", scenarios.get( sceneName ).getSolidInfo( "REGIONAL").get("E.s1RS"));
		scenariosData.get( sceneName ).putSolidInfo("REGIONAL", "E.s2RS", scenarios.get( sceneName ).getSolidInfo( "REGIONAL").get("E.s2RS"));
		scenariosData.get( sceneName ).putSolidInfo("REGIONAL", "E.s3RS", scenarios.get( sceneName ).getSolidInfo( "REGIONAL").get("E.s3RS"));

		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "AREAland.R",  scenarios.get( sceneName ).getLandscapeInfo( "REGIONAL").get("AREAland.R")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "AREAsea.R",  scenarios.get( sceneName ).getLandscapeInfo( "REGIONAL").get("AREAsea.R")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "FRAClake.R",   scenarios.get( sceneName ).getLandscapeInfo( "REGIONAL").get("FRAClake.R")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "FRACfresh.R",   scenarios.get( sceneName ).getLandscapeInfo( "REGIONAL").get("FRACfresh.R")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "FRACnatsoil.R",   scenarios.get( sceneName ).getLandscapeInfo( "REGIONAL").get("FRACnatsoil.R")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "FRACagsoil.R",   scenarios.get( sceneName ).getLandscapeInfo( "REGIONAL").get("FRACagsoil.R")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "FRACothersoil.R",  scenarios.get( sceneName ).getLandscapeInfo( "REGIONAL").get("FRACothersoil.R")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "RAINrate.R",   scenarios.get( sceneName ).getLandscapeInfo( "REGIONAL").get("RAINrate.R")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "TEMP.R",   scenarios.get( sceneName ).getLandscapeInfo( "REGIONAL").get("TEMP.R")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "WINDspeed.R",  scenarios.get( sceneName ).getLandscapeInfo( "REGIONAL").get("WINDspeed.R")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "DEPTHlake.R",   scenarios.get( sceneName ).getLandscapeInfo( "REGIONAL").get("DEPTHlake.R")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "DEPTHfreshwater.R",   scenarios.get( sceneName ).getLandscapeInfo( "REGIONAL").get("DEPTHfreshwater.R")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "FRACrun.R",   scenarios.get( sceneName ).getLandscapeInfo( "REGIONAL").get("FRACrun.R")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "FRACinf.R",   scenarios.get( sceneName ).getLandscapeInfo( "REGIONAL").get("FRACinf.R")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "EROSION.R",   scenarios.get( sceneName ).getLandscapeInfo( "REGIONAL").get("EROSION.R")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "SUSP.w0R",  scenarios.get( sceneName ).getLandscapeInfo( "REGIONAL").get("SUSP.w0R")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "SUSP.w1R",   scenarios.get( sceneName ).getLandscapeInfo( "REGIONAL").get("SUSP.w1R")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("REGIONAL", "SUSP.w2R",   scenarios.get( sceneName ).getLandscapeInfo( "REGIONAL").get("SUSP.w2R")  ) ;

		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "TOTAREAland.C",  scenarios.get( sceneName ).getLandscapeInfo( "CONTINENTAL").get("TOTAREAland.C")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "TOTAREAsea.C",  scenarios.get( sceneName ).getLandscapeInfo( "CONTINENTAL").get("TOTAREAsea.C")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "FRAClake.C",   scenarios.get( sceneName ).getLandscapeInfo( "CONTINENTAL").get("FRAClake.C")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "FRACfresh.C",   scenarios.get( sceneName ).getLandscapeInfo( "CONTINENTAL").get("FRACfresh.C")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "FRACnatsoil.C",   scenarios.get( sceneName ).getLandscapeInfo( "CONTINENTAL").get("FRACnatsoil.C")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "FRACagsoil.C",   scenarios.get( sceneName ).getLandscapeInfo( "CONTINENTAL").get("FRACagsoil.C")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "FRACothersoil.C",  scenarios.get( sceneName ).getLandscapeInfo( "CONTINENTAL").get("FRACothersoil.C")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "RAINrate.C",   scenarios.get( sceneName ).getLandscapeInfo( "CONTINENTAL").get("RAINrate.C")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "TEMP.C",   scenarios.get( sceneName ).getLandscapeInfo( "CONTINENTAL").get("TEMP.C")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "WINDspeed.C",  scenarios.get( sceneName ).getLandscapeInfo( "CONTINENTAL").get("WINDspeed.C")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "DEPTHlake.C",   scenarios.get( sceneName ).getLandscapeInfo( "CONTINENTAL").get("DEPTHlake.C")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "DEPTHfreshwater.C",   scenarios.get( sceneName ).getLandscapeInfo( "CONTINENTAL").get("DEPTHfreshwater.C")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "FRACrun.C",   scenarios.get( sceneName ).getLandscapeInfo( "CONTINENTAL").get("FRACrun.C")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "FRACinf.C",   scenarios.get( sceneName ).getLandscapeInfo( "CONTINENTAL").get("FRACinf.C")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "EROSION.C",   scenarios.get( sceneName ).getLandscapeInfo( "CONTINENTAL").get("EROSION.C")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "SUSP.w0C",  scenarios.get( sceneName ).getLandscapeInfo( "CONTINENTAL").get("SUSP.w0C")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "SUSP.w1C",   scenarios.get( sceneName ).getLandscapeInfo( "CONTINENTAL").get("SUSP.w1C")  ) ;
		scenariosData.get( sceneName ).putLandscapeInfo("CONTINENTAL", "SUSP.w2C",   scenarios.get( sceneName ).getLandscapeInfo( "CONTINENTAL").get("SUSP.w2C")  ) ;

		//load all available nanomaterials
		//The nanomaterials (as the scenarios) must be re-loaded for the values that are not set by the user (in case of API call). 
		loadNanomaterials();

		//Replace with user values or from the API
		for( String entry:nano.get(nanoName).keySet() ) 
			nanoData.get(nanoName).put(entry, nano.get(nanoName).get(entry) );

		input = new InputEngine( scenariosData.get( scenario ), nanoData.get( nanoName ) );
		environment = new RegionalEngine( input );
		engine = new Engine( input, environment, nanoData.get( nanoName ), scenariosData.get( sceneName )	);
		engine.build();		
	}	

	public InputEngine getInput() { return input; } 
	public RegionalEngine getEnvironment() { return environment; } 
	public Engine getEngine() { return engine; } 
	public Map<String, String> getNanoData() { return nanoData.get(nanoName); } 
	public String getNanoName() { return nanoName; } 
	public String getSceneName() { return sceneName; } 

	public void loadScenarios(){
		try {
//			ServletContext c = (ServletContext) Sessions.getCurrent().getWebApp().getNativeContext();
			
//			String path = "C:/Users/nikol/git/SimpleBox4Nano/SimpleBox4Nano/src/main/webapp/resources/templates/scenarios.xlsx"; // SimpleBox4NanoModel.class.getClassLoader().getResourceAsStream("../webapp/resources/templates/scenarios.xlsx"
//			FileInputStream fis=new FileInputStream(new File(path));  
			
			InputStream myWFS = Thread.currentThread().getContextClassLoader().getResourceAsStream("excel_files/scenarios.xlsx");
			
			XSSFWorkbook wb = new XSSFWorkbook( myWFS );			
			XSSFSheet sheet = wb.getSheetAt(0);

			//Get all scenarios names from 3rd row, 8th col to the end
			ArrayList<String> names = new ArrayList<String >();
			for ( int i = 8; i < sheet.getRow( 2 ).getLastCellNum(); i++) {
				Cell cell = sheet.getRow( 2 ).getCell( i );
				String str = cell.getStringCellValue();
				names.add( str );
			}

			//Create all structures in every scenario before storing the actual values
			int iScenario = 8; // This must points to the first entry of the first scenario 
			for ( String str:names ) {		

				// Create the scenario
				scenariosData.put(str, new Scenario( str ) );

				Map< String, String > regSolidInfo = new HashMap<String, String>();
				for ( int i = 7; i < 14; i++) 
					regSolidInfo.put( sheet.getRow( i ).getCell( 6 ).getStringCellValue(), String.valueOf( sheet.getRow( i ).getCell( iScenario ).getNumericCellValue() ) );
				scenariosData.get( str ).insertSolidInfo("REGIONAL", regSolidInfo );

				Map< String, String > contSolidInfo = new HashMap<String, String>();
				for ( int i = 15; i < 22; i++) 
					contSolidInfo.put( sheet.getRow( i ).getCell( 6 ).getStringCellValue(), String.valueOf( sheet.getRow( i ).getCell( iScenario ).getNumericCellValue() ) );
				scenariosData.get( str ).insertSolidInfo("CONTINENTAL", contSolidInfo);

				Map< String, String > modSolidInfo = new HashMap<String, String>();
				for ( int i = 23; i < 26; i++) 
					modSolidInfo.put( sheet.getRow( i ).getCell( 6 ).getStringCellValue(), String.valueOf( sheet.getRow( i ).getCell( iScenario ).getNumericCellValue() ) );
				scenariosData.get( str ).insertSolidInfo("MODERATE", modSolidInfo);

				Map< String, String > artSolidInfo = new HashMap<String, String>();
				for ( int i = 27; i < 30; i++) 
					artSolidInfo.put( sheet.getRow( i ).getCell( 6 ).getStringCellValue(), String.valueOf( sheet.getRow( i ).getCell( iScenario ).getNumericCellValue() ) );
				scenariosData.get( str ).insertSolidInfo("ARCTIC", artSolidInfo);

				Map< String, String > tropSolidInfo = new HashMap<String, String>();
				for ( int i = 31; i < 34; i++) 
					tropSolidInfo.put( sheet.getRow( i ).getCell( 6 ).getStringCellValue(), String.valueOf( sheet.getRow( i ).getCell( iScenario ).getNumericCellValue() ) );			
				scenariosData.get( str ).insertSolidInfo("TROPICAL", tropSolidInfo);

				Map< String, String > regDissInfo = new HashMap<String, String>();
				for ( int i = 37; i < 44; i++) 
					regDissInfo.put( sheet.getRow( i ).getCell( 6 ).getStringCellValue(), String.valueOf( sheet.getRow( i ).getCell( iScenario ).getNumericCellValue() ) );			
				scenariosData.get( str ).insertDissGasInfo("REGIONAL", regDissInfo);

				Map< String, String > contDissInfo = new HashMap<String, String>();
				for ( int i = 45; i < 52; i++) 
					contDissInfo.put( sheet.getRow( i ).getCell( 6 ).getStringCellValue(), String.valueOf( sheet.getRow( i ).getCell( iScenario ).getNumericCellValue() ) );
				scenariosData.get( str ).insertDissGasInfo("CONTINENTAL", contDissInfo);

				Map< String, String > modDissInfo = new HashMap<String, String>();
				for ( int i = 53; i < 56; i++)
					modDissInfo.put( sheet.getRow( i ).getCell( 6 ).getStringCellValue(), String.valueOf( sheet.getRow( i ).getCell( iScenario ).getNumericCellValue() ) );
				scenariosData.get( str ).insertDissGasInfo("MODERATE", modDissInfo);

				Map< String, String > artDissInfo = new HashMap<String, String>();
				for ( int i = 57; i < 60; i++) 
					artDissInfo.put( sheet.getRow( i ).getCell( 6 ).getStringCellValue(), String.valueOf( sheet.getRow( i ).getCell( iScenario ).getNumericCellValue() ) );
				scenariosData.get( str ).insertDissGasInfo("ARCTIC", artDissInfo);

				Map< String, String > tropDissInfo = new HashMap<String, String>();
				for ( int i = 61; i < 64; i++) 
					tropDissInfo.put( sheet.getRow( i ).getCell( 6 ).getStringCellValue(), String.valueOf( sheet.getRow( i ).getCell( iScenario ).getNumericCellValue() ) );
				scenariosData.get( str ).insertDissGasInfo("TROPICAL", tropDissInfo);

				Map< String, String > regLandInfo = new HashMap<String, String>();
				for ( int i = 68; i < 94; i++) 
					regLandInfo.put( sheet.getRow( i ).getCell( 6 ).getStringCellValue(), String.valueOf( sheet.getRow( i ).getCell( iScenario ).getNumericCellValue() ) );
				scenariosData.get( str ).insertLandscapeInfo("REGIONAL", regLandInfo);

				Map< String, String > contLandInfo = new HashMap<String, String>();
				for ( int i = 96; i < 124; i++) 
					contLandInfo.put( sheet.getRow( i ).getCell( 6 ).getStringCellValue(), String.valueOf( sheet.getRow( i ).getCell( iScenario ).getNumericCellValue() ) );
				scenariosData.get( str ).insertLandscapeInfo("CONTINENTAL", contLandInfo);

				Map< String, String > enviInfo = new HashMap<String, String>();
				for ( int i = 126; i < 143; i++) 
					enviInfo.put( sheet.getRow( i ).getCell( 6 ).getStringCellValue() , String.valueOf( sheet.getRow( i ).getCell( iScenario ).getNumericCellValue() ) );
				scenariosData.get( str ).insertEnviInfo( enviInfo );

				iScenario++;
			}

			wb.close();
		} catch(Exception ioe) {
			ioe.printStackTrace();
		}
	}

	public void loadNanomaterials(){
		try {	

	//		ServletContext c = (ServletContext) Sessions.getCurrent().getWebApp().getNativeContext();

			//String path = "C:/Users/nikol/git/SimpleBox4Nano/SimpleBox4Nano/src/main/webapp/resources/templates/nanomaterials.xlsx"; // SimpleBox4NanoModel.class.getClassLoader().getResourceAsStream("../webapp/resources/templates/scenarios.xlsx"
			//FileInputStream fis=new FileInputStream(new File(path));  
			
			InputStream myWFS = Thread.currentThread().getContextClassLoader().getResourceAsStream("excel_files/nanomaterials.xlsx");
			
			XSSFWorkbook wb = new XSSFWorkbook( myWFS );
				
			
	//		XSSFWorkbook wb = new XSSFWorkbook( this.getClass().getResourceAsStream("/resources/templates/nanomaterials.xlsx") );
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();   

			ArrayList<String> labels = new ArrayList<String>();
			boolean labelsMade = false;

			while (itr.hasNext())                 
			{  
				Row row = itr.next();  
				Iterator< Cell > cellIterator = row.cellIterator();   //iterating over each column  

				int i = 0;
				Map<String, String>	inputNanoData = new HashMap<String, String>();

				while (cellIterator.hasNext())   
				{  
					Cell cell = cellIterator.next();  
					switch ( cell.getCellType() )               
					{  
					case STRING:
					{
						//						System.out.print( cell.getStringCellValue() + "\t\t\t");
						if ( !labelsMade ) 
							labels.add( cell.getStringCellValue() );
						else
							inputNanoData.put( labels.get( i ), cell.getStringCellValue() );
						i++;
						break;
					}
					case NUMERIC:
					{
						//						System.out.print( cell.getNumericCellValue() + "\t\t\t");  
						double val = cell.getNumericCellValue();
						inputNanoData.put( labels.get( i ), String.valueOf( val ) );
						i++;
						break;
					}
					default:  
					{
						//						System.out.print( cell.getNumericCellValue() + "\t\t\t");  
						double val = cell.getNumericCellValue();
						inputNanoData.put( labels.get( i ), String.valueOf( val ) );
						i++;
						break;
					}
					}  					
				}  

				labelsMade = true;				
				nanoData.put( inputNanoData.get("Name"), (Map<String, String>) inputNanoData );
			}  

			wb.close();
		} catch(Exception ioe) {
			ioe.printStackTrace();
		}
	}
}


