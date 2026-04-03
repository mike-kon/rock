package com.mikesoft.learn.rock.repositories;

import com.mikesoft.learn.rock.entity.GroupDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<GroupDb, UUID> {

  GroupDb findByName(String groupName);
}
