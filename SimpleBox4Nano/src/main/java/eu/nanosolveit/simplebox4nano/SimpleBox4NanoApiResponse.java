package eu.nanosolveit.simplebox4nano;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="SimpleBox4Nano API Response Data Structure")
public class SimpleBox4NanoApiResponse {
	@Getter @Setter
	@ApiModelProperty(value="The masses ")
	Map<String, Map<String, Map<String, Double> > > masses;

	@Getter @Setter
	@ApiModelProperty(value="Concentrations")
	Map<String, Map<String, Map<String, Double> > > concentrations;

	@Getter @Setter
	@ApiModelProperty(value="Fugacities")
	Map<String, Map<String, Map<String, Double> > > fugacities;

	@Getter @Setter
	@ApiModelProperty(value="Inflow rates")
	Map<String, Map<String, Double> > inflow;

	@Getter @Setter
	@ApiModelProperty(value="Outflow rates")
	Map<String, Map<String, Double> > outflow;

	@Getter @Setter
	@ApiModelProperty(value="Removal mass flows")
	Map<String, Map<String, Double> > removal;

	@Getter @Setter
	@ApiModelProperty(value="Formation")
	Map<String, Map<String, Double> > formation;

	@Getter @Setter
	@ApiModelProperty(value="Degradation")
	Map<String, Map<String, Double> > degradation;

	@Getter @Setter
	@ApiModelProperty(value="Emissions")
	Map<String, Map<String, Double> > emission;
	
	@Getter @Setter
	@ApiModelProperty(value="Transport")
	Map<String, Map<String, Map<String, Double> > > transport;

	@Getter @Setter
	@ApiModelProperty(value="Total masses")
	Map<String, Double> totalD;

	@Getter @Setter
	@ApiModelProperty(value="Total S")
	Map<String, Double> totalS;

	@Getter @Setter
	@ApiModelProperty(value="Total A")
	Map<String, Double> totalA;

	@Getter @Setter
	@ApiModelProperty(value="Total P")
	Map<String, Double> totalP;
}
