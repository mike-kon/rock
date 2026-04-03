package com.mikesoft.learn.rock.repositories;

import com.mikesoft.learn.rock.entity.OwnsInstrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OwnsInstrumentRepository extends JpaRepository<OwnsInstrument, UUID> {
}
