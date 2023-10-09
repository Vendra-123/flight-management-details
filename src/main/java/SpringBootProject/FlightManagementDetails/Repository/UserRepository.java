package SpringBootProject.FlightManagementDetails.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import SpringBootProject.FlightManagementDetails.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {

	
		@Query(value = "SELECT * FROM USER u WHERE u.user_email = ?1",nativeQuery = true  )
		public Optional<User> findByUserEmail(String email);
		
		
		@Query(value = "SELECT * FROM USER u WHERE u.user_email = ?1 AND u.user_password = ?2 ",nativeQuery = true  )
		public Optional<User> findByUserEmailAndPassword(String email, String password);

}

