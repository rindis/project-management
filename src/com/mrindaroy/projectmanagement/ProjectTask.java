package com.mrindaroy.projectmanagement;

import java.util.HashMap;

class ProjectTask {
  private final HashMap<ProjectMember, Double> registeredMemberHours = new HashMap<>();
  private String id;
  private double hoursEstimated;

  String getId() {
    return id;
  }

  void setId(String id) {
    this.id = id;
  }

  void registerHours(ProjectMember projectMember, double hoursSpent) {
    registeredMemberHours.put(projectMember, registeredMemberHours.get(projectMember) + hoursSpent);
  }

  void setHoursEstimated(double hoursEstimated) {
    this.hoursEstimated = hoursEstimated;
  }

  double getHoursRemaining() {
    return hoursEstimated - getHoursRegistered();
  }

  double getHoursRegistered() {
    return registeredMemberHours.values().stream().mapToDouble(Double::doubleValue).sum();
  }

  double getSpending() {
    return registeredMemberHours.keySet().stream().mapToDouble(member -> member.getHourlyRate() * registeredMemberHours.get(member)).sum();
  }

  void addMember(ProjectMember member) {
    registeredMemberHours.put(member, 0.0);
  }
}
