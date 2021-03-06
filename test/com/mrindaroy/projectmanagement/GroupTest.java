package com.mrindaroy.projectmanagement;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class GroupTest {
  @Test
  public void canAddAndGetProject() throws Exception {
    Group group = new Group();
    Project project = TestSetup.generateProject();
    group.addProject(project);

    assertSame(project, group.getProject(project.getId()));
  }
}
