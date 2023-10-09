package SpringBootProject.FlightManagementDetails.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBootProject.FlightManagementDetails.Model.Feedback;



@Repository

public interface FeedbackRepository extends JpaRepository<Feedback,Integer>{

	
	
}