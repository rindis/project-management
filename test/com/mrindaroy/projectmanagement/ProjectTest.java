package com.mrindaroy.projectmanagement;

import org.junit.Before;
import org.junit.Test;

import static java.lang.Double.MIN_VALUE;
import static org.junit.Assert.assertEquals;

public class ProjectTest {

  private Project project;
  private ProjectTask task;
  private ProjectMember member;

  @Before
  public void setUp() throws Exception {
    project = new Project();
    task = new ProjectTask();
    member = new ProjectMember();

    task.setId("taskID");
    member.setId("memberID");
    project.addTask(task);
    project.addMember(member);
    project.addMemberToTask(member.getId(), task.getId());
  }

  @Test
  public void getRegisteredHours() throws Exception {
    double hoursSpent = 12.34;
    project.registerHours(member.getId(), task.getId(), hoursSpent);

    assertEquals(hoursSpent, task.getHoursRegistered(), MIN_VALUE);
    assertEquals(hoursSpent, project.getHoursRegistered(), MIN_VALUE);
  }

  @Test
  public void getHoursRemaining() throws Exception {
    double hoursSpent = 12.34;
    double hoursEstimated = 37.5;
    task.setHoursEstimated(hoursEstimated);

    project.registerHours(member.getId(), task.getId(), hoursSpent);

    double hoursRemaining = hoursEstimated - hoursSpent;
    assertEquals(hoursRemaining, task.getHoursRemaining(), MIN_VALUE);
    assertEquals(hoursRemaining, project.getHoursRemaining(), MIN_VALUE);
  }

  @Test
  public void getRegisteredHoursWithMultipleMembersAndTasks() throws Exception {
    ProjectMember memberTwo = new ProjectMember();
    ProjectTask taskTwo = new ProjectTask();
    project.addTask(taskTwo);
    project.addMember(memberTwo);
    project.addMemberToTask(memberTwo.getId(), taskTwo.getId());

    double hoursSpentOnTask1 = 12.34;
    project.registerHours(member.getId(), task.getId(), hoursSpentOnTask1);
    double hoursSpentOnTask2 = 10.34;
    project.registerHours(memberTwo.getId(), taskTwo.getId(), hoursSpentOnTask2);

    assertEquals(hoursSpentOnTask1, task.getHoursRegistered(), MIN_VALUE);
    assertEquals(hoursSpentOnTask2, taskTwo.getHoursRegistered(), MIN_VALUE);
    assertEquals(hoursSpentOnTask1 + hoursSpentOnTask2, project.getHoursRegistered(), MIN_VALUE);
  }

  @Test
  public void getSpending() throws Exception {
    double hoursSpent = 12.34;
    project.registerHours(member.getId(), task.getId(), hoursSpent);
    double hourlyRate = 100.0;
    member.setHourlyRate(hourlyRate);

    assertEquals(hoursSpent * hourlyRate, project.getSpending(), MIN_VALUE);
  }

  @Test
  public void getSpendingWithMultipleMembersAndTasks() throws Exception {
    ProjectMember memberTwo = new ProjectMember();
    ProjectTask taskTwo = new ProjectTask();
    project.addTask(taskTwo);
    project.addMember(memberTwo);
    project.addMemberToTask(memberTwo.getId(), taskTwo.getId());

    double hoursSpentOnTask1 = 12.34;
    project.registerHours(member.getId(), task.getId(), hoursSpentOnTask1);
    double hourlyRate1 = 100.0;
    member.setHourlyRate(hourlyRate1);

    double hoursSpentOnTask2 = 10.34;
    project.registerHours(memberTwo.getId(), taskTwo.getId(), hoursSpentOnTask2);
    double hourlyRate2 = 200.0;
    memberTwo.setHourlyRate(hourlyRate2);

    double spendingTask1 = hoursSpentOnTask1 * hourlyRate1;
    double spendingTask2 = hoursSpentOnTask2 * hourlyRate2;
    double totalSpending = spendingTask1 + spendingTask2;
    assertEquals(spendingTask1, project.getTask(task.getId()).getSpending(), MIN_VALUE);
    assertEquals(spendingTask2, project.getTask(taskTwo.getId()).getSpending(), MIN_VALUE);
    assertEquals(totalSpending, project.getSpending(), MIN_VALUE);
  }
}
