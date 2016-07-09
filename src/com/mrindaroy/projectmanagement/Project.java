package com.mrindaroy.projectmanagement;

import java.util.HashMap;

class Project {
  private final HashMap<String, ProjectMember> members = new HashMap<>();
  private final HashMap<String, ProjectTask> tasks = new HashMap<>();
  private String id;

  void addMember(ProjectMember member) {
    members.put(member.getId(), member);
  }

  void addTask(ProjectTask task) {
    tasks.put(task.getId(), task);
  }

  ProjectTask getTask(String taskId) {
    return tasks.get(taskId);
  }

  void registerHours(String memberId, String taskId, double hoursSpent) {
    tasks.get(taskId).registerHours(members.get(memberId), hoursSpent);
  }

  double getHoursRegistered() {
    return tasks.values().stream().mapToDouble(ProjectTask::getHoursRegistered).sum();
  }

  double getHoursRemaining() {
    return tasks.values().stream().mapToDouble(ProjectTask::getHoursRemaining).sum();
  }

  void addMemberToTask(String memberId, String taskId) {
    tasks.get(taskId).addMember(members.get(memberId));
  }

  double getSpending() {
    return tasks.values().stream().mapToDouble(ProjectTask::getSpending).sum();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
