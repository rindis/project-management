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
}
