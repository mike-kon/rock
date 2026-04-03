package com.mikesoft.learn.rock.exeptions;

public class WrongSex extends RuntimeException {
  public WrongSex() {
    super("There are no more than two sexes in the world");
  }
}
