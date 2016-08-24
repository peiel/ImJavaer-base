package com.elong.enumerated;

import static com.elong.enumerated.Octcome.*;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public enum RoShamBo2 implements Competitor<RoShamBo2> {
    PAPER(DRAW, LOSE, WIN),
    SCISSORS(WIN, DRAW, LOSE),
    ROCK(LOSE, WIN, DRAW);
    private Octcome vPAPER, vSCISSORS, vROCK;

    RoShamBo2(Octcome paper, Octcome scissors, Octcome rock) {
        this.vPAPER = paper;
        this.vSCISSORS = scissors;
        this.vROCK = rock;
    }

    public Octcome compete(RoShamBo2 competitor) {
        switch (competitor) {
            default:
            case PAPER:
                return vPAPER;
            case SCISSORS:
                return vSCISSORS;
            case ROCK:
                return vROCK;
        }
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class, 20);
    }
}



