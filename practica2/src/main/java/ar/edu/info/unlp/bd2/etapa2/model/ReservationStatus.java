package ar.edu.info.unlp.bd2.etapa2.model;

import java.util.EnumSet;

public enum ReservationStatus {
	CONFIRMED, CANCELED, FINISHED, CONFIRMATION_PENDING;

	public static EnumSet<ReservationStatus> getDisabledReservationStatus() {
		return EnumSet.of(CANCELED, FINISHED);
	}
}
