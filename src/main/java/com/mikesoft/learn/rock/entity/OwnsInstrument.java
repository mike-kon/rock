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
@Table(name = "owns_instrument", schema = "rock")
public class OwnsInstrument {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "man", nullable = false)
  private Musician man;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "instrument", nullable = false)
  private Instrument instrument;

}