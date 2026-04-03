package com.mikesoft.learn.rock.exeptions;

public class GroupNotFound extends RuntimeException {

  private final String groupName;

  public GroupNotFound(String message) {
    super(message + " not found");
    groupName = message;
  }

  @Override
  public String getMessage() {
    return "There no information about group " + groupName;
  }
}
