package com.mikesoft.learn.rock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "groups", schema = "rock")
public class GroupDb {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
  private String name;

  @Column(name = "country", nullable = false, length = Integer.MAX_VALUE)
  private String country;

  @Column(name = "created_year", nullable = false)
  private Integer createdYear;

  @Column(name = "dropped_year")
  private Integer droppedYear;

  @Column(name = "styles")
  private List<String> styles;

}