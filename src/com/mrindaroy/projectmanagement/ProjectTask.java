package com.mrindaroy.projectmanagement;

import java.util.HashMap;

public class ProjectTask {
  private final HashMap<ProjectMember, Double> hoursRegistered = new HashMap<>();
  private String id;
  private double hoursEstimate;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void registerHours(ProjectMember projectMember, double hoursSpent) {
    if (hoursRegistered.containsKey(projectMember)) {
      hoursRegistered.put(projectMember, hoursRegistered.get(projectMember) + hoursSpent);
    } else {
      hoursRegistered.put(projectMember, hoursSpent);
    }
  }

  public double getHoursEstimate() {
    return hoursEstimate;
  }

  public void setHoursEstimate(double hoursEstimate) {
    this.hoursEstimate = hoursEstimate;
  }

  public double getHoursRemaining() {
    return hoursEstimate - totalHoursRegistered();
  }

  public double totalHoursRegistered() {
    double totalHours = 0;
    for (Double memberHours : hoursRegistered.values()) {
      totalHours += memberHours;
    }

    return totalHours;
  }
}
