package com.mrindaroy.projectmanagement;

import java.util.HashMap;

public class Project {
  private final HashMap<String, ProjectMember> members = new HashMap<>();
  private final HashMap<String, ProjectTask> tasks = new HashMap<>();

  public void addMember(ProjectMember member) {
    members.put(member.getId(), member);
  }

  public ProjectMember getMember(String memberId) {
    return members.get(memberId);
  }

  public void addTask(ProjectTask task) {
    tasks.put(task.getId(), task);
  }

  public ProjectTask getTask(String taskId) {
    return tasks.get(taskId);
  }

  public void registerHours(ProjectMember member, ProjectTask task, double hoursSpent) {
    task.registerHours(member, hoursSpent);
  }

  public double totalHoursRegistered() {
    final Double[] totalHoursRegistered = {0.0};
    tasks.values().forEach(projectTask -> totalHoursRegistered[0] = totalHoursRegistered[0] + projectTask.totalHoursRegistered());

    return totalHoursRegistered[0];
  }

  public double getHoursEstimate() {
    final Double[] totalHoursEstimate = {0.0};
    tasks.values().forEach(projectTask -> totalHoursEstimate[0] = totalHoursEstimate[0] + projectTask.getHoursEstimate());

    return totalHoursEstimate[0];
  }

  public double hoursRemaining() {
    final Double[] totalRemainingHours = {0.0};
    tasks.values().forEach(projectTask -> totalRemainingHours[0] = totalRemainingHours[0] + projectTask.getHoursRemaining());

    return totalRemainingHours[0];
  }
}
