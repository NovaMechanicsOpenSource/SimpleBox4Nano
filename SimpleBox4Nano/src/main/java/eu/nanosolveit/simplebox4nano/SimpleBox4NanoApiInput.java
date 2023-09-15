package eu.nanosolveit.simplebox4nano;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="Simple box 4 nano input")
public class SimpleBox4NanoApiInput {
	@Getter @Setter
	@ApiModelProperty(value="Scenarios's name")
	String scenario;
	
	@Getter @Setter
	@ApiModelProperty(value="Nanomaterial's name")
	String nanomaterial;
	
	@Getter @Setter
	@ApiModelProperty(value="The molecular weight of the nanomaterial substance")
	Double Molweight;

	@Getter @Setter
	@ApiModelProperty(value="Radius ENP")
	Double RadS;

	@Getter @Setter
	@ApiModelProperty(value="Density ENP")
	Double RhoS;
	
	@Getter @Setter
	@ApiModelProperty(value="Hamaker constant heteroagglomerate (ENP, water, SiO2)")
	Double AHamakerSP_w;

	@Getter @Setter
	@ApiModelProperty(value="Attachment efficiency of water")
	Double freshWater;

	@Getter @Setter
	@ApiModelProperty(value="Attachment Efficiency of ENPs and lake water NCs (<450 nm)")
	Double AtefSA_w0;

	@Getter @Setter
	@ApiModelProperty(value="Attachment Efficiency of ENPs and lake water SPM (>450 nm)")
	Double AtefSP_w0;

	@Getter @Setter
	@ApiModelProperty(value="Attachment Efficiency of ENPs and fresh water NCs (<450 nm)")
	Double AtefSA_w1;

	@Getter @Setter
	@ApiModelProperty(value="Attachment Efficiency of ENPs and fresh water SPM (>450 nm)")
	Double AtefSP_w1;

	@Getter @Setter
	@ApiModelProperty(value="Attachment Efficiency of ENPs and natural soil NCs (<450 nm)")
	Double AtefSA_s1;

	@Getter @Setter
	@ApiModelProperty(value="Attachment Efficiency of ENPs and natural soil grains")
	Double AtefSP_s1;

	@Getter @Setter
	@ApiModelProperty(value="Attachment Efficiency of ENPs and agricultural soil NCs (<450 nm)")
	Double AtefSA_s2;

	@Getter @Setter
	@ApiModelProperty(value="Attachment Efficiency of ENPs and agricultural soil grains")
	Double AtefSP_s2;

	@Getter @Setter
	@ApiModelProperty(value="Attachment Efficiency of ENPs and other soil NCs (<450 nm)")
	Double AtefSA_s3;

	@Getter @Setter
	@ApiModelProperty(value="Attachment Efficiency of ENPs and other soil grains")
	Double AtefSP_s3;

	@Getter @Setter
	@ApiModelProperty(value="Attachment Efficiency of ENPs and lake sediment NCs (<450 nm)")
	Double AtefSA_sd0;

	@Getter @Setter
	@ApiModelProperty(value="Attachment Efficiency of ENPs and lake sediment grains")
	Double AtefSP_sd0;

	@Getter @Setter
	@ApiModelProperty(value="Attachment Efficiency of ENPs and fresh sediment NCs (<450 nm)")
	Double AtefSA_sd1;

	@Getter @Setter
	@ApiModelProperty(value="Attachment Efficiency of ENPs and fresh sediment grains")
	Double AtefSP_sd1;

	@Getter @Setter
	@ApiModelProperty(value="Attachment Efficiency of ENPs and marine sediment NCs (<450 nm)")
	Double AtefSA_sd2;

	@Getter @Setter
	@ApiModelProperty(value="Attachment Efficiency of ENPs and marine sediment grains")
	Double AtefSP_sd2;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of ENPs (S) in lake water")
	Double kdis_w0S_w0D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of ENPs (S) in fresh water")
	Double kdis_w1S_w1D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and NCs (A) in lake water")
	Double kdis_w0A_w0D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and SPM (P) in lake water")
	Double kdis_w0P_w0D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and NCs (A) in fresh water")
	Double kdis_w1A_w1D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and SPM (P) in fresh water")
	Double kdis_w1P_w1D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of ENPs (S) in sea water")
	Double kdis_w2S_w2D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and NCs (A) in sea water")
	Double kdis_w2A_w2D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and SPM (P) in sea water")
	Double kdis_w2P_w2D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of ENPs (S) in natural soil pore water")
	Double kdis_s1S_s1D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of ENPs (S) in other soil pore water")
	Double kdis_s2S_s2D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of ENPs (S) in other soil pore water")
	Double kdis_s3S_s3D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and NCs (A) in natural soil pore water")
	Double kdis_s1A_s1D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and FP (P) in natural soil")
	Double kdis_s1P_s1D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and NCs (A) in agricultural soil pore water")
	Double kdis_s2A_s2D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and FP (P) in agricultural soil")
	Double kdis_s2P_s2D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and NCs (A) in other soil pore water")
	Double kdis_s3A_s3D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and FP (P) in other soil")
	Double kdis_s3P_s3D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of ENPs (S) in lake sediment")
	Double kdis_sd0S_sd0D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of ENPs (S) in fresh sediment")
	Double kdis_sd1S_sd1D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and NCs (A) in lake sediment")
	Double kdis_sd0A_sd0D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and FP (P) in lake sediment")
	Double kdis_sd0P_sd0D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and NCs (A) in fresh sediment")
	Double kdis_sd1A_sd1D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and FP (P) in fresh sediment")
	Double kdis_sd1P_sd1D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of ENPs (S) in marine sediment")
	Double kdis_sd2S_sd2D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of ENPs (S) in deep sea water")
	Double kdis_w3S_w3D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and NCs (A) in marine sediment")
	Double kdis_sd2A_sd2D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and FP (P) in marine sediment")
	Double kdis_sd2P_sd2D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and NCs (A) in deep sea water")
	Double kdis_w3A_w3D;

	@Getter @Setter
	@ApiModelProperty(value="Dissolution rate of heteroagglomerates of ENPs and SPM (P) in deep sea water")
	Double kdis_w3P_w3D;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of ENPs (S) in air")
	Double kdeg_aS;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and NCs (A) in lake water")
	Double kdeg_aA;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and SPM (P) in lake water")
	Double kdeg_aP;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of ENPs (S) in lake water")
	Double kdeg_w0S;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of ENPs (S) in fresh water")
	Double kdeg_w1S;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and NCs (A) in lake water")
	Double kdeg_w0A;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and SPM (P) in lake water")
	Double kdeg_w0P;
	
	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and NCs (A) in fresh water")
	Double kdeg_w1A;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and SPM (P) in fresh water")
	Double kdeg_w1P;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of ENPs (S) in sea water")
	Double kdeg_w2S;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and NCs (A) in sea water")
	Double kdeg_w2A;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and SPM (P) in sea water")
	Double kdeg_w2P;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of ENPs (S) in natural soil pore water")
	Double kdeg_s1S;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of ENPs (S) in agricultural soil pore water")
	Double kdeg_s2S;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of ENPs (S) in other soil pore water")
	Double kdeg_s3S;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and NCs (A) in natural soil pore water")
	Double kdeg_s1A;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and FP (P) in natural soil")
	Double kdeg_s1P;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and NCs (A) in agricultural soil pore water")
	Double kdeg_s2A;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and FP (P) in agricultural soil")
	Double kdeg_s2P;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and NCs (A) in other soil pore water")
	Double kdeg_s3A;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and FP (P) in other soil")
	Double kdeg_s3P;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of ENPs (S) in lake sediment")
	Double kdeg_sd0S;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of ENPs (S) in fresh sediment")
	Double kdeg_sd1S;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and NCs (A) in lake sediment")
	Double kdeg_sd0A;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and FP (P) in lake sediment")
	Double kdeg_sd0P;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and NCs (A) in fresh sediment")
	Double kdeg_sd1A;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and FP (P) in fresh sediment")
	Double kdeg_sd1P;
	
	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of ENPs (S) in marine sediment")
	Double kdeg_sd2S;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of ENPs (S) in deep sea water")
	Double kdeg_w3S;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and NCs (A) in marine sediment")
	Double kdeg_sd2A;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and FP (P) in marine sediment")
	Double kdeg_sd2P;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and NCs (A) in deep sea water")
	Double kdeg_w3A;

	@Getter @Setter
	@ApiModelProperty(value="Degradation rate constant of heteroagglomerates of ENPs and SPM (P) in deep sea water")
	Double kdeg_w3P;

	//Emission rates
	@Getter @Setter
	@ApiModelProperty(value="Regional emission rates to air")
	Double E_aRS;

	@Getter @Setter
	@ApiModelProperty(value="Regional emission rates to lake water")
	Double E_w0RS;
	
	@Getter @Setter
	@ApiModelProperty(value="Regional emission rates to fresh water")
	Double E_w1RS;

	@Getter @Setter
	@ApiModelProperty(value="Regional emission rates to sea water")
	Double E_w2RS;

	@Getter @Setter
	@ApiModelProperty(value="Regional emission rates to natural soil")
	Double E_s1RS;

	@Getter @Setter
	@ApiModelProperty(value="Regional emission rates to agricultural soil")
	Double E_s2RS;

	@Getter @Setter
	@ApiModelProperty(value="Regional emission rates to other soil")
	Double E_s3RS;
	
	@Getter @Setter
	@ApiModelProperty(value="Continental emission rates to air")
	Double E_aCS;

	@Getter @Setter
	@ApiModelProperty(value="Continental emission rates to lake water")
	Double E_w0CS;
	
	@Getter @Setter
	@ApiModelProperty(value="Continental emission rates to fresh water")
	Double E_w1CS;

	@Getter @Setter
	@ApiModelProperty(value="Continental emission rates to sea water")
	Double E_w2CS;

	@Getter @Setter
	@ApiModelProperty(value="Continental emission rates to natural soil")
	Double E_s1CS;

	@Getter @Setter
	@ApiModelProperty(value="Continental emission rates to agricultural soil")
	Double E_s2CS;

	@Getter @Setter
	@ApiModelProperty(value="Continental emission rates to other soil")
	Double E_s3CS;
	
	@Getter @Setter
	@ApiModelProperty(value="Arctic emission rates to air")
	Double E_aAS;

	@Getter @Setter
	@ApiModelProperty(value="Arctic emission rates to water")
	Double E_w2AS;
	
	@Getter @Setter
	@ApiModelProperty(value="Arctic emission rates to soil")
	Double E_sAS;

	@Getter @Setter
	@ApiModelProperty(value="Tropical emission rates to air")
	Double E_aTS;

	@Getter @Setter
	@ApiModelProperty(value="Tropical emission rates to water")
	Double E_w2TS;
	
	@Getter @Setter
	@ApiModelProperty(value="Tropical emission rates to soil")
	Double E_sTS;
	
	@Getter @Setter
	@ApiModelProperty(value="Moderate emission rates to air")
	Double E_aMS;

	@Getter @Setter
	@ApiModelProperty(value="Moderate emission rates to water")
	Double E_w2MS;
	
	@Getter @Setter
	@ApiModelProperty(value="Moderate emission rates to soil")
	Double E_sMS;

	//Advanced 
	//Regional
	@Getter @Setter
	@ApiModelProperty(value="Regional area land")
	Double AREAland_R;

	@Getter @Setter
	@ApiModelProperty(value="Regional area sea")
	Double AREAsea_R;

	@Getter @Setter
	@ApiModelProperty(value="Regional fraction lake water")
	Double FRAClake_R;

	@Getter @Setter
	@ApiModelProperty(value="Regional fraction fresh water")
	Double FRACfresh_R;

	@Getter @Setter
	@ApiModelProperty(value="Regional fraction natural water")
	Double FRACnatsoil_R;

	@Getter @Setter
	@ApiModelProperty(value="Regional fraction agricultural water")
	Double FRACagsoil_R;

	@Getter @Setter
	@ApiModelProperty(value="Regional fraction urban/industrial soil")
	Double FRACothersoil_R;

	@Getter @Setter
	@ApiModelProperty(value="Regional average precipitation")
	Double RAINrate_R;

	@Getter @Setter
	@ApiModelProperty(value="Regional temperature")
	Double TEMP_R;

	@Getter @Setter
	@ApiModelProperty(value="Regional wind speed")
	Double WINDspeed_R;

	@Getter @Setter
	@ApiModelProperty(value="Regional depth lake water")
	Double DEPTHlake_R;

	@Getter @Setter
	@ApiModelProperty(value="Regional depth fresh water")
	Double DEPTHfreshwater_R;

	@Getter @Setter
	@ApiModelProperty(value="Regional fraction run off")
	Double FRACrun_R;

	@Getter @Setter
	@ApiModelProperty(value="Regional infiltration run off")
	Double FRACinf_R;

	@Getter @Setter
	@ApiModelProperty(value="Regional soil erosion")
	Double EROSION_R;

	@Getter @Setter
	@ApiModelProperty(value="Regional concentration suspended matter in lake water")
	Double SUSP_w0R;

	@Getter @Setter
	@ApiModelProperty(value="Regional concentration suspended matter in fresh water")
	Double SUSP_w1R;

	@Getter @Setter
	@ApiModelProperty(value="Regional concentration suspended matter in sea water")
	Double SUSP_w2R;
	
	//Continental
	@Getter @Setter
	@ApiModelProperty(value="Total continental area land")
	Double TOTAREALand_C; 

	@Getter @Setter
	@ApiModelProperty(value="Total continental area sea")
	Double TOTAREAsea_C;  

	@Getter @Setter
	@ApiModelProperty(value="Continental fraction lake water")
	Double FRAClake_C;

	@Getter @Setter
	@ApiModelProperty(value="Continental fraction fresh water")
	Double FRACfresh_C;

	@Getter @Setter
	@ApiModelProperty(value="Continental fraction natural water")
	Double FRACnatsoil_C;

	@Getter @Setter
	@ApiModelProperty(value="Continental fraction agricultural water")
	Double FRACagsoil_C;

	@Getter @Setter
	@ApiModelProperty(value="Continental fraction urban/industrial soil")
	Double FRACothersoil_C;

	@Getter @Setter
	@ApiModelProperty(value="Continental average precipitation")
	Double RAINrate_C;

	@Getter @Setter
	@ApiModelProperty(value="Continental temperature")
	Double TEMP_C;

	@Getter @Setter
	@ApiModelProperty(value="Continental wind speed")
	Double WINDspeed_C;

	@Getter @Setter
	@ApiModelProperty(value="Continental depth lake water")
	Double DEPTHlake_C;

	@Getter @Setter
	@ApiModelProperty(value="Continental depth fresh water")
	Double DEPTHfreshwater_C;

	@Getter @Setter
	@ApiModelProperty(value="Continental fraction run off")
	Double FRACrun_C;

	@Getter @Setter
	@ApiModelProperty(value="Continental infiltration run off")
	Double FRACinf_C;

	@Getter @Setter
	@ApiModelProperty(value="Continental soil erosion")
	Double EROSION_C;

	@Getter @Setter
	@ApiModelProperty(value="Continental concentration suspended matter in lake water")
	Double SUSP_w0C;

	@Getter @Setter
	@ApiModelProperty(value="Continental concentration suspended matter in fresh water")
	Double SUSP_w1C;

	@Getter @Setter
	@ApiModelProperty(value="Continental concentration suspended matter in sea water")
	Double SUSP_w2C;
}
