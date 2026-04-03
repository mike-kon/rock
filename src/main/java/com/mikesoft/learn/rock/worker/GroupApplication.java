package com.mikesoft.learn.rock.worker;

import com.mikesoft.learn.rock.entity.GroupDb;
import com.mikesoft.learn.rock.entity.GroupMember;
import com.mikesoft.learn.rock.entity.Instrument;
import com.mikesoft.learn.rock.entity.Musician;
import com.mikesoft.learn.rock.exeptions.GroupNotBorn;
import com.mikesoft.learn.rock.exeptions.GroupNotFound;
import com.mikesoft.learn.rock.repositories.GroupMemberRepository;
import com.mikesoft.learn.rock.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class GroupApplication {

  private final GroupRepository groupRepository;
  private final GroupMemberRepository groupMemberRepository;

  public RockGroupSnap load(String groupName, int year) {
    GroupDb group = groupRepository.findByName(groupName);
    if (group == null) {
      throw new GroupNotFound(groupName);
    }

    if (group.getCreatedYear() > year) {
      throw new GroupNotBorn(groupName, year);
    }

    RockGroupSnap.RockGroupSnapBuilder builder = RockGroupSnap.builder();
    builder.group(group);

    List<GroupMember> rawMembers = groupMemberRepository.findByGroupDb(group);
    List<GroupMember> members = rawMembers.stream()
        .filter(x -> x.getJoinedYear() <= year
                && (x.getSeparatedYear() == null || x.getSeparatedYear() > year))
        .toList();

    List<Musician> musicians = members.stream()
        .map(GroupMember::getMember)
        .toList();
    builder.musicians(musicians);

    List<Instrument> instruments = members.stream()
        .map(GroupMember::getMainInstruments)
        .filter(Objects::nonNull)
        .toList();
    builder.instruments(instruments);

    return builder.build();
  }
}
