package com.mikesoft.learn.rock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "group_members", schema = "rock")
public class GroupMember {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "group", nullable = false)
  private GroupDb groupDb;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "member", nullable = false)
  private Musician member;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "main_instruments")
  private Instrument mainInstruments;

  @Column(name = "joined_year", nullable = false)
  private Integer joinedYear;

  @Column(name = "separated_year")
  private Integer separatedYear;

}