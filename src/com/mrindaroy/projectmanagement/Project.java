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

  public void registerHours(String memberId, String taskId, double hoursSpent) {
    tasks.get(taskId).registerHours(members.get(memberId), hoursSpent);
  }

  public double getTotalHoursRegistered() {
    return tasks.values().stream().mapToDouble(ProjectTask::getTotalHoursRegistered).sum();
  }

  public double getHoursEstimate() {
    return tasks.values().stream().mapToDouble(ProjectTask::getHoursEstimated).sum();
  }

  public double getHoursRemaining() {
    return tasks.values().stream().mapToDouble(ProjectTask::getHoursRemaining).sum();
  }

  public void addMemberToTask(String memberId, String taskId) {
    tasks.get(taskId).addMember(members.get(memberId));
  }

  public double getSpending() {
    return tasks.values().stream().mapToDouble(ProjectTask::getSpending).sum();
  }
}
