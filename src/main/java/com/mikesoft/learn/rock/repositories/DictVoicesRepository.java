package com.mikesoft.learn.rock.repositories;

import com.mikesoft.learn.rock.entity.DictVoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictVoicesRepository extends JpaRepository<DictVoices, String> {
}
