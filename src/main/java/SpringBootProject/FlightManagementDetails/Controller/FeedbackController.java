package SpringBootProject.FlightManagementDetails.Controller;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import SpringBootProject.FlightManagementDetails.Model.Feedback;
import SpringBootProject.FlightManagementDetails.Service.FeedbackService;

@RestController
@CrossOrigin(origins = "")
@RequestMapping("/FlightBooking.Com")
public class FeedbackController {


	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/add/{id}/{userId}")
	public ResponseEntity<Feedback> addFeedback(@Valid @RequestBody Feedback feedback1,
												@PathVariable("id") int id,@PathVariable("userId")Long userId) throws Exception{
		
		Feedback feedback = feedbackService.addFeedback(feedback1, id, userId);
		
		return new ResponseEntity<Feedback>(feedback,HttpStatus.ACCEPTED);
		
	}

	@GetMapping("/feedback/{id}")
	public ResponseEntity<Feedback> viewFeedback(@PathVariable("id") Integer ID) throws Exception {
		
		Feedback feedback = feedbackService.viewFeedback(ID);
		
		return new ResponseEntity<Feedback>(feedback,HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/feedback/all")
	public ResponseEntity<List<Feedback>> viewFeedbackAll() throws Exception  {
		
		List<Feedback> feedback =  feedbackService.viewFeedbackAll();
		
		return new ResponseEntity<List<Feedback>>(feedback,HttpStatus.ACCEPTED);
		
	}
	@DeleteMapping("feedback/delete/{id}")
	public void deleteFeedback(@PathVariable("id") Integer feedbackId) throws Exception{
		
		 feedbackService.deleteFeedback(feedbackId);
		
		
		
	}
}