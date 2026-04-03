package com.mikesoft.learn.rock.entity;

import com.mikesoft.learn.rock.dto.enums.Sex;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "musicians", schema = "rock")
public class Musician {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
  private String name;

  @Column(name = "family", nullable = false, length = Integer.MAX_VALUE)
  private String family;

  @Column(name = "born", nullable = false)
  private LocalDate born;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "country", nullable = false)
  private DictCountry country;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "voices")
  private DictVoices voices;

  @Column(name = "sex", nullable = false, length = Integer.MAX_VALUE)
  @Enumerated(EnumType.STRING)
  private Sex sex;

}