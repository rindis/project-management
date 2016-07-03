package com.mrindaroy.projectmanagement;

import org.junit.Test;

import static java.lang.Double.MIN_VALUE;
import static org.junit.Assert.assertEquals;
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

  @Test
  public void registerHours() throws Exception {
    Project project = new Project();
    ProjectTask task = new ProjectTask();
    task.setId("taskID");
    project.addTask(task);
    ProjectMember member = new ProjectMember();
    member.setId("memberID");
    project.addMember(member);

    double hoursSpent = 12.34;
    project.registerHours(member, task, hoursSpent);

    assertEquals(hoursSpent, project.getTotalHoursRegistered(), MIN_VALUE);
    assertEquals(project.getHoursEstimate() - project.getTotalHoursRegistered(), project.getHoursRemaining(), MIN_VALUE);
  }
}
