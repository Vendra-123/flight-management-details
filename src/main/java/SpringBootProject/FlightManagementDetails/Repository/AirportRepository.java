package SpringBootProject.FlightManagementDetails.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBootProject.FlightManagementDetails.Model.Airport;



@Repository
public interface AirportRepository extends JpaRepository<Airport,Integer>{ 
	List<Airport> findByAirportNameContainingIgnoreCase(String airportName);

	
}