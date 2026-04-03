package com.mikesoft.learn.rock.data;

import com.mikesoft.learn.rock.base.DbContainerBase;
import com.mikesoft.learn.rock.entity.DictCountry;
import com.mikesoft.learn.rock.repositories.DictCountryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

class CheckCountryTest extends DbContainerBase {

  @Autowired
  DictCountryRepository dictCountryRepository;

  @Test
  void checkCountLoadTest() {
    List<DictCountry> countries = dictCountryRepository.findAll();
    Assertions.assertEquals(4, countries.size());
    DictCountry russia = countries.stream()
        .filter(x -> "RUS".equals(x.getAbr()))
        .findFirst()
        .orElseThrow(AssertionError::new);
    Assertions.assertEquals("Russia", russia.getName());
  }
}
