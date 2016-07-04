package com.mrindaroy.projectmanagement;

class ProjectMember {
  private double hourlyRate;
  private String id;

  double getHourlyRate() {
    return hourlyRate;
  }

  void setHourlyRate(double hourlyRate) {
    this.hourlyRate = hourlyRate;
  }

  String getId() {
    return id;
  }

  void setId(String id) {
    this.id = id;
  }
}
