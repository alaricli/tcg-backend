package com.competition.competition.dto.cardrequest;

import com.competition.competition.enums.EnergyCardType;
import com.competition.competition.enums.EnergyType;

import java.util.List;

public class EnergyCardRequest extends CardRequest {
    private List<EnergyCardType> energyCardTypes;
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

    public void setEnergyCardType(List<EnergyCardType> energyCardType) {
        this.energyCardTypes = energyCardType;
    }
}
