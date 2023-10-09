package SpringBootProject.FlightManagementDetails.Repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBootProject.FlightManagementDetails.Model.FlightCompany;



@Repository
public interface FlightCompanyRepository extends JpaRepository<FlightCompany,Integer>{
	
	List<FlightCompany> findByCompanyNameContainingIgnoreCase(String companyName);

}
