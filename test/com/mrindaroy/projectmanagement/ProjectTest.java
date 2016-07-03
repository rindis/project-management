package com.mrindaroy.projectmanagement;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class ProjectTest {
  @Test
  public void addProjectMember() throws Exception {
    Project project = new Project();
    ProjectMember member = new ProjectMember();
    member.setId("ID");

    project.addMember(member);

    assertSame(member, project.getMember(member.getId()));
  }

  @Test
  public void addProjectTask() throws Exception {
    Project project = new Project();
    ProjectTask task = new ProjectTask();
    task.setId("ID");

    project.addTask(task);

    assertSame(task, project.getTask(task.getId()));
  }
}
