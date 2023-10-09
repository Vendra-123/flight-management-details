package SpringBootProject.FlightManagementDetails.Model;


import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="flight_details")
@DynamicUpdate
public class FlightDetails {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="row_no")
		private Integer id;
		
		@Column(name="domestic_flight")
		private Boolean isDomestic;
		
		@Column(name="flight_code" , length=6)
		private String flightCode;
		//@Column(name="IsNonDomestic")
		//private String isNonDomestic;
		
@Column(name="flight_name", length=20)
		private String flightName;
		
		@Column(name="Destination",nullable = false)
		private String destination;
		
		@Column(name="Source", nullable = false )
		private String source;
		
		
		
		
		@Column(name="ticket_cost")
		private Integer ticketCost;
		
		@Column(name="flight_rating")
		private Integer flightRating;
		
		//Economy,Basic_Economy,Premium_Economy,Business,First
		
		@Column(name="cancellation_cost")
		private Integer cancellationCost;
		@Column(name="Capacity")
		private Integer capacity;


		public Integer getCapacity() {
			return capacity;
		}

		public void setCapacity(Integer capacity) {
			this.capacity = capacity;
		}

	

		public Integer getId() {
			return id;
		}

		public void Id(Integer id) {
			this.id = id;
		}

		public Boolean getIsDomestic() {
			return isDomestic;
		}

		public void setIsDomestic(Boolean isDomestic) {
			this.isDomestic = isDomestic;
		}

		public String getFlightCode() {
			return flightCode;
		}

		public void setFlightCode(String flightCode) {
			this.flightCode = flightCode;
		}

		public String getFlightName() {
			return flightName;
		}

		public void setFlightName(String flightName) {
			this.flightName = flightName;
		}

		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public Integer getTicketCost() {
			return ticketCost;
		}

		public void setTicketCost(Integer ticketCost) {
			this.ticketCost = ticketCost;
		}

		public Integer getFlightRating() {
			return flightRating;
		}

		public void setFlightRating(Integer flightRating) {
			this.flightRating = flightRating;
		}

		public Integer getCancellationCost() {
			return cancellationCost;
		}

		public void setCancellationCost(Integer cancellationCost) {
			this.cancellationCost = cancellationCost;
		}

		@Override
		public String toString() {
			return "FlightDetails [id=" +id + ", isDomestic=" + isDomestic + ", flightCode=" + flightCode
					+ ", flightName=" + flightName + ", destination=" + destination + ", source=" + source
					+ ", ticketCost=" + ticketCost + ", flightRating=" + flightRating + ", cancellationCost="
					+ cancellationCost + ", capacity=" + capacity + "]";
		}

		
		


}
		