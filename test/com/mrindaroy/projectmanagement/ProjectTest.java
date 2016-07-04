package com.mrindaroy.projectmanagement;

import org.junit.Before;
import org.junit.Test;

import static java.lang.Double.MIN_VALUE;
import static org.junit.Assert.assertEquals;

public class ProjectTest {

  private Project project;
  private ProjectTask firstTask;
  private ProjectMember firstMember;
  private ProjectTask secondTask;
  private ProjectMember secondMember;

  @Before
  public void setUp() throws Exception {
    project = new Project();
    firstTask = new ProjectTask();
    firstMember = new ProjectMember();
    secondTask = new ProjectTask();
    secondMember = new ProjectMember();

    firstTask.setId("firstTaskID");
    firstMember.setId("firstMemberID");
    project.addTask(firstTask);
    project.addMember(firstMember);
    project.addMemberToTask(firstMember.getId(), firstTask.getId());

    secondTask.setId("secondTaskID");
    secondMember.setId("secondMemberID");
    project.addTask(secondTask);
    project.addMember(secondMember);
    project.addMemberToTask(secondMember.getId(), secondTask.getId());
  }

  @Test
  public void getHoursRemainingWithMultipleMembersAndTasks() throws Exception {
    double hoursSpentOnTask1 = 12.34;
    double hoursEstimatedForTask1 = 37.5;
    firstTask.setHoursEstimated(hoursEstimatedForTask1);

    double hoursSpentOnTask2 = 12.34;
    double hoursEstimatedForTask2 = 37.5;
    secondTask.setHoursEstimated(hoursEstimatedForTask2);

    project.registerHours(firstMember.getId(), firstTask.getId(), hoursSpentOnTask1);
    project.registerHours(secondMember.getId(), secondTask.getId(), hoursSpentOnTask2);

    double hoursRemainingForTask1 = hoursEstimatedForTask1 - hoursSpentOnTask1;
    double hoursRemainingForTask2 = hoursEstimatedForTask2 - hoursSpentOnTask2;
    double hoursRemainingForProject = hoursRemainingForTask1 + hoursRemainingForTask2;
    assertEquals(hoursRemainingForTask1, firstTask.getHoursRemaining(), MIN_VALUE);
    assertEquals(hoursRemainingForTask2, secondTask.getHoursRemaining(), MIN_VALUE);
    assertEquals(hoursRemainingForProject, project.getHoursRemaining(), MIN_VALUE);
  }

  @Test
  public void getRegisteredHoursWithMultipleMembersAndTasks() throws Exception {
    double hoursSpentOnTask1 = 12.34;
    double hoursSpentOnTask2 = 10.34;
    project.registerHours(firstMember.getId(), firstTask.getId(), hoursSpentOnTask1);
    project.registerHours(secondMember.getId(), secondTask.getId(), hoursSpentOnTask2);

    assertEquals(hoursSpentOnTask1, firstTask.getHoursRegistered(), MIN_VALUE);
    assertEquals(hoursSpentOnTask2, secondTask.getHoursRegistered(), MIN_VALUE);
    assertEquals(hoursSpentOnTask1 + hoursSpentOnTask2, project.getHoursRegistered(), MIN_VALUE);
  }

  @Test
  public void getSpendingWithMultipleMembersAndTasks() throws Exception {
    double hoursSpentOnTask1 = 12.34;
    double hourlyRateForMember1 = 100.0;
    project.registerHours(firstMember.getId(), firstTask.getId(), hoursSpentOnTask1);
    firstMember.setHourlyRate(hourlyRateForMember1);

    double hoursSpentOnTask2 = 10.34;
    double hourlyRateForMember2 = 200.0;
    project.registerHours(secondMember.getId(), secondTask.getId(), hoursSpentOnTask2);
    secondMember.setHourlyRate(hourlyRateForMember2);

    double spendingTask1 = hoursSpentOnTask1 * hourlyRateForMember1;
    double spendingTask2 = hoursSpentOnTask2 * hourlyRateForMember2;
    double totalSpendingForProject = spendingTask1 + spendingTask2;
    assertEquals(spendingTask1, project.getTask(firstTask.getId()).getSpending(), MIN_VALUE);
    assertEquals(spendingTask2, project.getTask(secondTask.getId()).getSpending(), MIN_VALUE);
    assertEquals(totalSpendingForProject, project.getSpending(), MIN_VALUE);
  }
}
