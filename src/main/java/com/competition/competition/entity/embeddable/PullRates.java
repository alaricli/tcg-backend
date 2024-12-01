package com.competition.competition.entity.embeddable;

import jakarta.persistence.Embeddable;

@Embeddable
public class PullRates {
    private float firstToThird;
    private float fourth;
    private float fifth;

    public float getFirstToThird() {
        return firstToThird;
    }

    public void setFirstToThird(float firstToThird) {
        this.firstToThird = firstToThird;
    }

    public float getFourth() {
        return fourth;
    }

    public void setFourth(float fourth) {
        this.fourth = fourth;
    }

    public float getFifth() {
        return fifth;
    }

    public void setFifth(float fifth) {
        this.fifth = fifth;
    }
}
