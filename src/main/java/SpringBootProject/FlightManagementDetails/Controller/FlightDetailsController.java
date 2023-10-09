package SpringBootProject.FlightManagementDetails.Controller;






import java.util.List;
import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SpringBootProject.FlightManagementDetails.Model.FlightDetails;
import SpringBootProject.FlightManagementDetails.Service.FlightDetailsService;
@CrossOrigin
@RestController

@RequestMapping("/FlightBooking.Com")
public class FlightDetailsController {
	
	@Autowired
	private FlightDetailsService  flightDetailsService;
	
	public FlightDetailsController(FlightDetailsService flightDetailsService ) {
		this.flightDetailsService=flightDetailsService;
	}
	
	
	
	@PostMapping("/toCreateFd")
	public FlightDetails createFlightDetails(@RequestBody FlightDetails flightObj ){
		return flightDetailsService.createFlightDetails(flightObj);
	}
	
	@PutMapping("/toUpdateFdId/{id}")
	public ResponseEntity<FlightDetails> updateFlightDetailsById(@PathVariable ("id")int id ,@RequestBody FlightDetails flightObj){
	try{
		return new ResponseEntity<FlightDetails>(flightDetailsService.updateDetailsUsingId(flightObj,id) , HttpStatus.OK);
	}catch(Exception exc) {
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
	}
	
	@GetMapping("/toReadFd")
	public List<FlightDetails> fetchAllFlightDetails(){
		return flightDetailsService.getAllFlightDetails();
	}
	
	@GetMapping("/toReadFdId/{id}")
	public ResponseEntity<FlightDetails> fetchFlightDetailsById(@PathVariable("id") int id){
		try{
			
			return new ResponseEntity<FlightDetails> (flightDetailsService.getDetailsById(id),HttpStatus.OK);
		}catch(Exception exc) {
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
		}
	
	
	@DeleteMapping("/deleteFdId/{id}")
	public void deleteFlightDetailsById(@PathVariable int id) {
		flightDetailsService.deleteFlightDetailsById(id);
	}
	
	@DeleteMapping("/deleteFd")
	public void deleteFlightDetails() {
		flightDetailsService.deleteFlightDetails();
	}
	
	@GetMapping("/isDomestic")
	public ResponseEntity<FlightDetails> fetchAllDomesticFlights(){
		
		try {
			return new ResponseEntity( flightDetailsService.checkIfFlightIsDomestic(true),HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		
	@GetMapping("/isNonDomestic")
	public ResponseEntity<FlightDetails> fetchAllNonDomesticFlights(){
			
	try {
				return new ResponseEntity( flightDetailsService.checkIfFlightIsNonDomestic(false),HttpStatus.OK);
			}
	catch(Exception exc) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}}
	
	@GetMapping("/getAllFlightDetails/{flightName}")
	
	public ResponseEntity<List<FlightDetails>> fetchDetailsByFlightName(@PathVariable String flightName){
		try {
			List<FlightDetails> flightObj=flightDetailsService.searchByFlightName(flightName);
					
			if(flightObj.isEmpty()) {
				
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<>(flightObj,HttpStatus.OK);
			}}
		catch(Exception exc) {
			
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);	
		}}
	@GetMapping("/FlightDetails/{destination}/{source}")
	public ResponseEntity<List<FlightDetails>> fetchDetailsByDestinationAndSource(@PathVariable String destination,@PathVariable String source ){
		try {
			List<FlightDetails> flightObj=flightDetailsService.searchByDestinationAndSource(destination,source);
					
			if(flightObj.isEmpty()) {
				
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<>(flightObj,HttpStatus.OK);
			}}
		catch(Exception exc) {
			
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		}
    @GetMapping("/sortByTicketCost/{direction}")
		
		public ResponseEntity<List<FlightDetails>> fetchDetailsByTicketCost(@PathVariable("direction") String direction,@RequestParam(required=true)String fieldName  ){
			try {
				List<FlightDetails> flightObj=new ArrayList<FlightDetails>();
				flightObj=flightDetailsService.sortByTicketCost(direction,fieldName);
						
				if(flightObj.isEmpty()) {
					
					return new ResponseEntity<List<FlightDetails>>(HttpStatus.NO_CONTENT);
				}
				else {
					return new ResponseEntity<List<FlightDetails>>(flightObj,HttpStatus.OK);
				}
				}
			catch(Exception exc) {
				
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);	
			}
			}
    @GetMapping("/sortByFlightRating/{direction}")
	
	public ResponseEntity<List<FlightDetails>> fetchDetailsByFlightRating(@PathVariable("direction") String direction,@RequestParam(required=true)String fieldName  ){
		try {
			List<FlightDetails> flightObj=new ArrayList<FlightDetails>();
			
			flightObj=flightDetailsService.sortByFlightRating(direction,fieldName);
					
			if(flightObj.isEmpty()) {
				
				return new ResponseEntity<List<FlightDetails>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<FlightDetails>>(flightObj,HttpStatus.OK);
			}
			}
		catch(Exception exc) {
			
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
}}