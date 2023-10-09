package SpringBootProject.FlightManagementDetails.Repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import SpringBootProject.FlightManagementDetails.Model.FlightDetails;

@Repository
public interface FlightDetailsRepository  extends JpaRepository<FlightDetails,Integer> {

	List<FlightDetails> findByIsDomestic(Boolean booleanObj);
	
	
	
	List<FlightDetails> findByFlightNameContainingIgnoreCase(String flightName);
	List<FlightDetails> findByDestinationAndSource(String destination, String source);}

	