package com.mikesoft.learn.rock.exeptions;

public class GroupNotBorn extends RuntimeException {

  private final String groupName;
  private final int year;

  public GroupNotBorn(String groupName, int year) {
    super(groupName + " not found in " + year);
    this.groupName = groupName;
    this.year = year;
  }

  @Override
  public String getMessage() {
    return "Group " + groupName + " in " + year + " year didn't exist yet";
  }
}
