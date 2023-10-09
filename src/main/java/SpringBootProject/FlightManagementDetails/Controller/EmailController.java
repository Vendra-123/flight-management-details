
package SpringBootProject.FlightManagementDetails.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringBootProject.FlightManagementDetails.Service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/emailSent")
	public ResponseEntity<String> checkEmail(){
		
	emailService.sendEmail("j78301970@gmail.com", "Check", "Checking Email");
	return new ResponseEntity<>("Message Send",HttpStatus.CREATED);
	
	}
	
}