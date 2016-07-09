package com.mrindaroy.projectmanagement;

import java.util.HashMap;

public class Group {
  private HashMap<String, Project> projects = new HashMap<>();
  public void addProject(Project project) {
    projects.put(project.getId(), project);
  }

  public Project getProject(String id) {
    return projects.get(id);
  }
}
