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
@Table(name = "dict_country", schema = "rock")
public class DictCountry {
  @Id
  @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
  private String name;

  @Column(name = "full_name", nullable = false, length = Integer.MAX_VALUE)
  private String fullName;

  @Column(name = "abr", nullable = false, length = Integer.MAX_VALUE)
  private String abr;

}