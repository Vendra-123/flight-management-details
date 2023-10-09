package SpringBootProject.FlightManagementDetails.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import SpringBootProject.FlightManagementDetails.Model.FlightDetails;


@Service
public interface FlightDetailsService {
	

	    FlightDetails updateDetailsUsingId(FlightDetails flightObj,int id);
		void deleteFlightDetailsById(int id);
		FlightDetails getDetailsById(int id);
		List<FlightDetails> getAllFlightDetails();
		void deleteFlightDetails();
		FlightDetails createFlightDetails(FlightDetails flightObj);
		 		
		
		List<FlightDetails> checkIfFlightIsNonDomestic(Boolean booleanObj) ;
		List<FlightDetails> checkIfFlightIsDomestic(Boolean booleanObj) ;
        List<FlightDetails> searchByFlightName(String flightName);
		
		List<FlightDetails> sortByTicketCost(String direction, String fieldName);
		List<FlightDetails> sortByFlightRating(String direction, String fieldName);
		List<FlightDetails> searchByDestinationAndSource(String destinaion, String source);}
		
		
	
		
		