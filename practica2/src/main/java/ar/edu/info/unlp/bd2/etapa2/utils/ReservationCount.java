package ar.edu.info.unlp.bd2.etapa2.utils;

import ar.edu.info.unlp.bd2.etapa2.model.ReservationStatus;

public class ReservationCount {

  private ReservationStatus status;
  private Long count;

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public ReservationStatus getStatus() {
    return status;
  }

  public void setStatus(ReservationStatus status) {
    this.status = status;
  }
}
