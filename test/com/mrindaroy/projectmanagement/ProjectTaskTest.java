package com.mrindaroy.projectmanagement;

import org.junit.Test;

import static java.lang.Double.MIN_VALUE;
import static org.junit.Assert.assertEquals;

public class ProjectTaskTest {
  @Test
  public void registerHours() throws Exception {
    ProjectTask task = new ProjectTask();
    task.setHoursEstimate(37.5);

    double hoursSpent = 12.34;
    task.registerHours(new ProjectMember(), hoursSpent);

    assertEquals(hoursSpent, task.totalHoursRegistered(), MIN_VALUE);
    assertEquals(task.getHoursEstimate() - task.totalHoursRegistered(), task.hoursRemaining(), MIN_VALUE);
  }
}
