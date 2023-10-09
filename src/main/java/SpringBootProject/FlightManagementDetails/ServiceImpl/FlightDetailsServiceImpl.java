 package SpringBootProject.FlightManagementDetails.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import SpringBootProject.FlightManagementDetails.Model.FlightDetails;
import SpringBootProject.FlightManagementDetails.Repository.FlightDetailsRepository;
import SpringBootProject.FlightManagementDetails.Service.FlightDetailsService;
@Service
public class FlightDetailsServiceImpl implements FlightDetailsService {

	
	private FlightDetailsRepository flightDetailsRepository;
	
    @Autowired
	public FlightDetailsServiceImpl(FlightDetailsRepository flightDetailsRepository) {
		this.flightDetailsRepository=flightDetailsRepository;
	}
	@Override
	public FlightDetails createFlightDetails(FlightDetails flightObj) {
		return flightDetailsRepository.save(flightObj);
	}

	@Override
	public  FlightDetails  updateDetailsUsingId( FlightDetails flightObj,int id) {
		Optional<FlightDetails> flightDetailsFromDb = flightDetailsRepository.findById(id); 
if(flightDetailsFromDb.isPresent()) {
	FlightDetails existingFlightDetails=flightDetailsFromDb.get();
	existingFlightDetails.setDestination(flightObj.getDestination());
	existingFlightDetails.setSource(flightObj.getSource());
	existingFlightDetails.setTicketCost(flightObj.getTicketCost());
	existingFlightDetails.setFlightRating(flightObj.getFlightRating());
	flightDetailsRepository.save(existingFlightDetails);
	return existingFlightDetails;
	}
else {
	return null;
}
}

	
	@Override
	public List<FlightDetails> getAllFlightDetails() {
		return flightDetailsRepository.findAll();
	}
	
	
	
	@Override
	public FlightDetails getDetailsById(int id) {
			Optional<FlightDetails> flightObj = flightDetailsRepository.findById(id);  //null , or it can 5tg person rec
			if(flightObj.isPresent()) {
				return flightObj.get();
			}
			else {
				return null;
			}
	}
	@Override
	public void deleteFlightDetailsById(int id) {
		Optional<FlightDetails> flightObj = flightDetailsRepository.findById(id);  //null , or it can 5tg person rec
		if(flightObj.isPresent()) {
			flightDetailsRepository.deleteById(id);
		}
	}
	@Override
	public void deleteFlightDetails() {
		flightDetailsRepository.deleteAll();
	}
	
	
	
	

	@Override
	public List<FlightDetails> searchByFlightName(String flightName) {
		return flightDetailsRepository.findByFlightNameContainingIgnoreCase(flightName);

	}
	
	private Sort.Direction getSortDirection(String direction){
		if (direction.equalsIgnoreCase("asc")) {
			return Sort.Direction.ASC;
		}else if(direction.equalsIgnoreCase("desc")) {
			return Sort.Direction.DESC;
			}
		return Sort.Direction.ASC;
	}
	
public List<FlightDetails> sortByTicketCost(String direction, String fieldName) {
		
		List<FlightDetails> flightObj=new ArrayList<FlightDetails>();
		flightObj=flightDetailsRepository.findAll(Sort.by(getSortDirection(direction),fieldName));
		return flightObj;
		
	}
    @Override
public List<FlightDetails> sortByFlightRating(String direction, String fieldName) {
    	List<FlightDetails> flightObj=new ArrayList<FlightDetails>();
		flightObj=flightDetailsRepository.findAll(Sort.by(getSortDirection(direction),fieldName));
		return flightObj;
		}
	
@Override
	public List<FlightDetails> searchByDestinationAndSource(String destination, String source) {
	return flightDetailsRepository.findByDestinationAndSource(destination,source);
	
	}
@Override
public List<FlightDetails> checkIfFlightIsNonDomestic(Boolean booleanObj) {
	List<FlightDetails> flightObj= flightDetailsRepository.findByIsDomestic(false);
	return flightObj;
}
@Override
public List<FlightDetails> checkIfFlightIsDomestic(Boolean booleanObj) {
	List<FlightDetails> flightObj= flightDetailsRepository.findByIsDomestic(true);
	return flightObj;
}

	
}



		

	
	
	

	