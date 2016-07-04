package com.mrindaroy.projectmanagement;

import org.junit.Test;

import static java.lang.Double.MIN_VALUE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ProjectTaskTest {
  @Test
  public void registerHours() throws Exception {
    ProjectTask task = new ProjectTask();
    task.setHoursEstimated(37.5);

    double hoursSpent = 12.34;
    task.registerHours(new ProjectMember(), hoursSpent);

    assertEquals(hoursSpent, task.getTotalHoursRegistered(), MIN_VALUE);
    assertEquals(task.getHoursEstimated() - task.getTotalHoursRegistered(), task.getHoursRemaining(), MIN_VALUE);
  }

  @Test
  public void getSpending() throws Exception {
    ProjectTask task = new ProjectTask();
    task.setHoursEstimated(37.5);

    ProjectMember member = new ProjectMember();
    double hourlyRate = 100;
    member.setHourlyRate(hourlyRate);
    double hoursSpent = 12.34;
    task.registerHours(member, hoursSpent);

    assertEquals(hoursSpent * hourlyRate, task.getSpending(), MIN_VALUE);
  }

  @Test
  public void addMember() throws Exception {
    ProjectTask task = new ProjectTask();
    ProjectMember member = new ProjectMember();
    task.addMember(member);

    assertSame(member, task.getMember(member.getId()));
  }
}
