package com.mrindaroy.projectmanagement;

import java.util.UUID;

import static java.lang.Math.*;

public class TestSetup {
  private static ProjectMember generateProjectMember() {
    ProjectMember member = new ProjectMember();
    member.setHourlyRate(random() * 1000);
    member.setId(String.valueOf(UUID.randomUUID()));

    return member;
  }

  private static ProjectTask generateProjectTask(){
    ProjectTask task = new ProjectTask();
    task.setHoursEstimated(random() * 1000);
    task.setId(String.valueOf(UUID.randomUUID()));

    return task;
  }

  public static Project generateProject() {
    Project project = new Project();
    project.setId(String.valueOf(UUID.randomUUID()));

    ProjectMember member = generateProjectMember();
    ProjectTask task = generateProjectTask();
    project.addTask(task);
    project.addMember(member);
    project.addMemberToTask(member.getId(), task.getId());

    member = generateProjectMember();
    task = generateProjectTask();
    project.addTask(task);
    project.addMember(member);
    project.addMemberToTask(member.getId(), task.getId());

    return project;
  }
}
