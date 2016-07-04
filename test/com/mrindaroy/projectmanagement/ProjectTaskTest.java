package com.mrindaroy.projectmanagement;

import org.junit.Before;
import org.junit.Test;

import static java.lang.Double.MIN_VALUE;
import static org.junit.Assert.assertEquals;

public class ProjectTaskTest {

  private ProjectTask task;
  private ProjectMember member;

  @Before
  public void setUp() throws Exception {
    task = new ProjectTask();
    member = new ProjectMember();
    task.addMember(member);
  }

  @Test
  public void getRegisteredHours() throws Exception {
    double hoursSpent = 12.34;
    task.registerHours(member, hoursSpent);

    assertEquals(hoursSpent, task.getHoursRegistered(), MIN_VALUE);
  }

  @Test
  public void getHoursRemaining() throws Exception {
    double hoursSpent = 12.34;
    double hoursEstimated = 37.5;
    task.setHoursEstimated(hoursEstimated);

    task.registerHours(member, hoursSpent);

    double hoursRemaining = hoursEstimated - hoursSpent;
    assertEquals(hoursRemaining, task.getHoursRemaining(), MIN_VALUE);
  }

  @Test
  public void getSpending() throws Exception {
    double hoursSpent = 12.34;
    task.registerHours(member, hoursSpent);
    double hourlyRate = 100.0;
    member.setHourlyRate(hourlyRate);

    double spending = hoursSpent * hourlyRate;
    assertEquals(spending, task.getSpending(), MIN_VALUE);
  }
}
