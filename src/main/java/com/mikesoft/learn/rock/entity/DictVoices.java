package com.mikesoft.learn.rock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dict_voices", schema = "rock")
public class DictVoices {
  @Id
  @Column(name = "voices_type", nullable = false, length = Integer.MAX_VALUE)
  private String voicesType;

  @Column(name = "info", length = Integer.MAX_VALUE)
  private String info;
}
