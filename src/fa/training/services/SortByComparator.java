package fa.training.services;

import java.util.Comparator;

import fa.training.entities.Passenger;


public class SortByComparator implements Comparator<Passenger> {
	
	@Override
	public int compare(Passenger o1, Passenger o2) {

		if (o1.getFlightDate().equals(o2.getFlightDate())) {				
			return o1.getPassengerID().compareTo(o2.getPassengerID());
		}		
		return o2.getFlightDate().compareTo(o1.getFlightDate());
		
	}
	
//	@Override
//	public int compare(Candidate o1, Candidate o2) {
//		// Sap xep tang dan theo name
//		// Sap xep giam dan theo type
//		// sap xep tang dan theo ngay sinh
//
//		if (o1.getFullName().equals(o2.getFullName())) {
//			if (o1.getCandidate_type() == o2.getCandidate_type()) {
//				o1.getBirthDay().compareTo(o2.getBirthDay());
//			} else if (o1.getCandidate_type() > o2.getCandidate_type()) {
//				return -1;
//			} else {
//				return 1;
//			}
//		}
//		return o1.getFullName().compareTo(o2.getFullName());
//	}
}
