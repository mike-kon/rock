package com.mikesoft.learn.rock.repositories;

import com.mikesoft.learn.rock.entity.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictInstrumentRepository extends JpaRepository<Instrument, String> {
}
