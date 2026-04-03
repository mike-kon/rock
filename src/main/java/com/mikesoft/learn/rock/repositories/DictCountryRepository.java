package com.mikesoft.learn.rock.repositories;

import com.mikesoft.learn.rock.entity.DictCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictCountryRepository extends JpaRepository<DictCountry, String> {
}
