package SpringBootProject.FlightManagementDetails.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringBootProject.FlightManagementDetails.Model.Airport;
import SpringBootProject.FlightManagementDetails.Service.AirportService;



@CrossOrigin
@RestController
@RequestMapping("/FlightBooking.Com")
public class AirportController {
	
	
	@Autowired
	private AirportService  airportService;
	
	public AirportController(AirportService airportService ) {
		this.airportService=airportService;
	}

	@PostMapping("/toCreateAirportDetails")
	public Airport createaAirport(@RequestBody Airport airportObj ){
		return airportService.createAirportDetails(airportObj);
	}
   
	@PutMapping("/updateByAirportId/{airportId}")
	public ResponseEntity<Airport> updateAirportById(@PathVariable ("airportId")int airportId ,@RequestBody Airport airportObj){
	try{
		return new ResponseEntity<Airport>(airportService.updateDetailsUsingId(airportObj,airportId) , HttpStatus.OK);
	}catch(Exception exc) {
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
	}

	@GetMapping("/toReadAirportDetails")
	public List<Airport> fetchAllAirportDetails(){
		return airportService.getAllAirportDetails();
	}
	@GetMapping("/readByAirportId/{airportId}")
	public ResponseEntity<Airport> fetchAirportById(@PathVariable("airportId") int airportId){
		try{
			
			return new ResponseEntity<Airport> (airportService.getDetailsById(airportId),HttpStatus.OK);
		}catch(Exception exc) {
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
		}
	@DeleteMapping("/deleteByAirportId/{airportId}")
	public void deleteDetailsByAirportId(@PathVariable int airportId) {
		airportService.deleteAirportDetailsById(airportId);
	}
@GetMapping("/getDetailsByAirportName/{airportName}")
	
	public ResponseEntity<List<Airport>> fetchDetailsByAirportName(@PathVariable String airportName){
		try {
			List<Airport> airportObj=airportService.searchByAirportName(airportName);
					
			if(airportObj.isEmpty()) {
				
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<>(airportObj,HttpStatus.OK);
			}}
		catch(Exception exc) {
			
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);	
		}}}