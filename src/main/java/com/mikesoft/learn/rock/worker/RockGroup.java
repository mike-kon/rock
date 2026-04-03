package com.mikesoft.learn.rock.worker;

import java.util.List;

public interface RockGroup {
  String getGroupName();
  String getCountry();
  String getCountType();
  String getSexType();
  List<String> getMusiciansStr();
  List<String> getInstrumentsStr();
  int getCreatedYear();
  int getDroppedYear();
}
