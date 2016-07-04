package com.mrindaroy.projectmanagement;

import java.util.HashMap;

public class ProjectTask {
  private final HashMap<ProjectMember, Double> hoursRegistered = new HashMap<>();
  private HashMap<String, ProjectMember> members = new HashMap<>();
  private String id;
  private double hoursEstimated;

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

  public double getHoursEstimated() {
    return hoursEstimated;
  }

  public void setHoursEstimated(double hoursEstimated) {
    this.hoursEstimated = hoursEstimated;
  }

  public double getHoursRemaining() {
    return hoursEstimated - getTotalHoursRegistered();
  }

  public double getTotalHoursRegistered() {
    return hoursRegistered.values().stream().mapToDouble(Double::doubleValue).sum();
  }

  public double getSpending() {
    return hoursRegistered.keySet().stream().mapToDouble(member -> member.getHourlyRate() * hoursRegistered.get(member)).sum();
  }

  public void addMember(ProjectMember member) {
    members.put(member.getId(), member);
  }

  public ProjectMember getMember(String memberId) {
    return members.get(memberId);
  }
}
