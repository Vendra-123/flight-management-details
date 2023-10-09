package SpringBootProject.FlightManagementDetails.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import SpringBootProject.FlightManagementDetails.Model.Feedback;




@Service
public interface FeedbackService {


public Feedback addFeedback(Feedback feedBack,Integer id, Long userId) throws Exception;
	

	public void deleteFeedback(Integer feedbackId) throws Exception;

	public Feedback viewFeedback(Integer id) throws Exception;

	public List<Feedback> viewFeedbackAll() throws Exception ;
	
}