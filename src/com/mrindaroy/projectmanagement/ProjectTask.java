package com.mrindaroy.projectmanagement;

import java.util.HashMap;

class ProjectTask {
  private final HashMap<ProjectMember, Double> hoursRegistered = new HashMap<>();
  private String id;
  private double hoursEstimated;

  String getId() {
    return id;
  }

  void setId(String id) {
    this.id = id;
  }

  void registerHours(ProjectMember projectMember, double hoursSpent) {
    hoursRegistered.put(projectMember, hoursRegistered.get(projectMember) + hoursSpent);
  }

  void setHoursEstimated(double hoursEstimated) {
    this.hoursEstimated = hoursEstimated;
  }

  double getHoursRemaining() {
    return hoursEstimated - getHoursRegistered();
  }

  double getHoursRegistered() {
    return hoursRegistered.values().stream().mapToDouble(Double::doubleValue).sum();
  }

  double getSpending() {
    return hoursRegistered.keySet().stream().mapToDouble(member -> member.getHourlyRate() * hoursRegistered.get(member)).sum();
  }

  void addMember(ProjectMember member) {
    hoursRegistered.put(member, 0.0);
  }
}
