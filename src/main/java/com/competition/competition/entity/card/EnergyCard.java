package com.competition.competition.entity.card;

import com.competition.competition.enums.EnergyCardType;
import com.competition.competition.enums.EnergyType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class EnergyCard extends Card {

  @Enumerated(EnumType.STRING)
  private EnergyCardType energyCardType;

  @Enumerated(EnumType.STRING)
  private EnergyType energyType;

  public EnergyCardType getEnergyCardType() {
    return energyCardType;
  }

  public void setEnergyCardType(EnergyCardType energyCardType) {
    this.energyCardType = energyCardType;
  }

  public EnergyType getEnergyType() {
    return energyType;
  }

  public void setEnergyType(EnergyType energyType) {
    this.energyType = energyType;
  }
}