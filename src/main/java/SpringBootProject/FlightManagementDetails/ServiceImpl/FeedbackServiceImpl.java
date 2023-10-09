package SpringBootProject.FlightManagementDetails.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBootProject.FlightManagementDetails.Model.Feedback;
import SpringBootProject.FlightManagementDetails.Model.FlightDetails;
import SpringBootProject.FlightManagementDetails.Model.User;
import SpringBootProject.FlightManagementDetails.Repository.FeedbackRepository;
import SpringBootProject.FlightManagementDetails.Repository.FlightDetailsRepository;
import SpringBootProject.FlightManagementDetails.Repository.UserRepository;
import SpringBootProject.FlightManagementDetails.Service.FeedbackService;


@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired	
	private FeedbackRepository feedbackRepository;
	
	@Autowired
	private FlightDetailsRepository flightDetailsRepository;
	
	@Autowired
	private UserRepository UserRepository;

	//good flight/3/1
	@Override
	public Feedback addFeedback(Feedback feedback, Integer id, Long userId) throws Exception {
		
			
			Optional<FlightDetails> flightObj = flightDetailsRepository.findById(id);
			if (flightObj.isEmpty()) {
				throw new Exception("Flight is not present with Id: "+id);
			}
			Optional<User> user = UserRepository.findById(userId);//.orElseThrow(()-> new UserException("User not found!"));
			if (user.isEmpty()) {
				throw new Exception("User is not present with Id: "+ userId);
			}
			feedback.setFlightDetails(flightObj.get());
			feedback.setUser(user.get());
			Feedback savedFeedback = feedbackRepository.save(feedback);

			return savedFeedback;
			}


	@Override
	public void deleteFeedback(Integer feedbackId) {
		feedbackRepository.deleteById(feedbackId);
		
	}

	@Override
	public Feedback viewFeedback(Integer id) throws Exception {
		Optional<Feedback> fedOptional = feedbackRepository.findById(id);
		if (fedOptional.isPresent()) {
			return fedOptional.get();
		}
		throw new Exception("No feedback found!");
	
	}

	@Override
	public List<Feedback> viewFeedbackAll() throws Exception {
		Optional<List<Feedback>> fedOptional = Optional.of(feedbackRepository.findAll());
			if (fedOptional.isPresent()) {
			return fedOptional.get();
		}
		throw new Exception("No feedbacks found!");
	
	}

}