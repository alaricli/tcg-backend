package com.competition.competition.entity.card;

import com.competition.competition.enums.EnergyCardType;
import com.competition.competition.enums.EnergyType;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class EnergyCard extends Card {

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "energy_card_subtypes", joinColumns = @JoinColumn(name = "energy_card_id"))
  @Enumerated(EnumType.STRING)
  @Column(name = "subtypes")
  private List<EnergyCardType> energyCardTypes;

  @Enumerated(EnumType.STRING)
  private EnergyType energyType;

  public EnergyType getEnergyType() {
    return energyType;
  }

  public void setEnergyType(EnergyType energyType) {
    this.energyType = energyType;
  }

  public List<EnergyCardType> getEnergyCardTypes() {
    return energyCardTypes;
  }

  public void setEnergyCardTypes(List<EnergyCardType> energyCardTypes) {
    this.energyCardTypes = energyCardTypes;
  }
}