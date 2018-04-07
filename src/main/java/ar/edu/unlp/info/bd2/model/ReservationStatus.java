package ar.edu.unlp.info.bd2.model;

import java.util.EnumSet;

public enum ReservationStatus {
	PENDING, CONFIRMED, CANCELED, FINISHED;

	public static EnumSet<ReservationStatus> getDisabledReservationStatus() {
		return EnumSet.of(CANCELED, FINISHED);
	}
}
