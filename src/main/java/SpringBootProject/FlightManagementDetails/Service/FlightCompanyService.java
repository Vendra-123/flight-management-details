package SpringBootProject.FlightManagementDetails.Service;



import java.util.List;

import org.springframework.stereotype.Service;

import SpringBootProject.FlightManagementDetails.Model.FlightCompany;


@Service
public interface FlightCompanyService {

	    FlightCompany updateDetailsUsingId(FlightCompany companyObj,int companyId);
		void deleteCompanyDetailsById(int companyId);
		FlightCompany getDetailsById(int companyId);
		List<FlightCompany> getAllCompanyDetails();
		void deleteCompanyDetails();
		FlightCompany createCompanyDetails(FlightCompany companyObj);
		List<FlightCompany> searchByCompanyName(String companyName);
}