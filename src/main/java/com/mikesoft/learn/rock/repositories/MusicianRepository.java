package com.mikesoft.learn.rock.repositories;

import com.mikesoft.learn.rock.entity.Musician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, UUID> {
}
