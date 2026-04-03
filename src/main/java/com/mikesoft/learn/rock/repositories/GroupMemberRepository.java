package com.mikesoft.learn.rock.repositories;

import com.mikesoft.learn.rock.entity.GroupDb;
import com.mikesoft.learn.rock.entity.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMember, UUID> {

  List<GroupMember> findByGroupDb(GroupDb group);
}
