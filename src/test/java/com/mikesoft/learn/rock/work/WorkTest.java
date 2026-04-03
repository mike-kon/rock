package com.mikesoft.learn.rock.work;

import com.mikesoft.learn.rock.base.DbContainerBase;
import com.mikesoft.learn.rock.worker.GroupApplication;
import com.mikesoft.learn.rock.worker.RockGroupSnap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

@Sql(scripts = "classpath:./db/init.sql")
class WorkTest extends DbContainerBase {

  @Autowired
  GroupApplication groupApplication;

  @Test
  void loadTest() {
    String groupName = "Utro";
    RockGroupSnap group = groupApplication.load(groupName, 2025);
    Assertions.assertNotNull(group);
    Assertions.assertEquals(groupName, group.getGroupName());
    Assertions.assertEquals(3, group.getMusicians().size());
    Assertions.assertEquals(2, group.getInstruments().size());
  }
}
