package com.mikesoft.learn.rock.worker;

import com.mikesoft.learn.rock.dto.enums.Sex;
import com.mikesoft.learn.rock.entity.GroupDb;
import com.mikesoft.learn.rock.entity.Instrument;
import com.mikesoft.learn.rock.entity.Musician;
import com.mikesoft.learn.rock.exeptions.WrongSex;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Builder(toBuilder = true)
public class RockGroupSnap implements RockGroup {

  private final int year;
  private final GroupDb group;
  private final List<Musician> musicians;
  private final List<Instrument> instruments;

  @Override
  public String getGroupName() {
    return group.getName();
  }

  @Override
  public String getCountry() {
    return group.getCountry();
  }

  @Override
  public String getCountType() {
    return switch(musicians.size()) {
      case 0 -> "empty";
      case 1 -> "solo";
      case 2 -> "duet";
      case 3 -> "trio";
      case 4 -> "quartet";
      case 5 -> "quintet";
      case 6 -> "sixtet";
      case 7 -> "septet";
      case 8 -> "octet";
      default -> "orchestra";
    };
  }

  @Override
  public String getSexType() {
    List<Sex> sexes = musicians.stream()
        .map(Musician::getSex)
        .distinct()
        .toList();
    return switch (sexes.size()) {
      case 0 -> "empty";
      case 1 -> sexes.get(0).toString();
      case 2 -> "mixed";
      default -> throw new WrongSex();
    };
  }

  @Override
  public List<String> getMusiciansStr() {
    return musicians.stream()
        .map(m -> "%s %s (%s)".formatted(m.getName(), m.getFamily(), m.getBorn()))
        .toList();
  }

  @Override
  public List<String> getInstrumentsStr() {
    return instruments.stream()
        .map(Instrument::getName)
        .toList();
  }

  @Override
  public int getCreatedYear() {
    return group.getCreatedYear();
  }

  @Override
  public int getDroppedYear() {
    return group.getDroppedYear();
  }

}
