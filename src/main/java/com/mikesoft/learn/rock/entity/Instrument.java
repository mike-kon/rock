package com.mikesoft.learn.rock.entity;

import com.mikesoft.learn.rock.dto.enums.InstrumentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dict_instruments", schema = "rock")
public class Instrument {
  @Id
  @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
  private String name;

  @Column(name = "type", nullable = false, length = Integer.MAX_VALUE)
  @Enumerated(EnumType.STRING)
  private InstrumentType type;

  @Column(name = "is_hand", nullable = false)
  private Boolean isHand;

}