package com.competition.competition.dto.cardrequest;

import com.competition.competition.enums.EnergyCardType;
import com.competition.competition.enums.EnergyType;

public class EnergyCardRequest extends CardRequest {
    private EnergyCardType energyCardType;
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
