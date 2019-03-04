package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

public enum GoodType {

    WATER(0, "Water", 0, 0, Tech.MID, 30, 3, 4, RadicalEvent.DROUGHT, Resources.LOW, Resources.DSRT),
    FURS(1, "Furs", 0, 0, Tech.PRE, 250, 10, 10, RadicalEvent.COLD, Resources.RCHF, Resources.LLN),
    FOOD(2, "Food", 1, 0, Tech.AGR, 100, 5, 5, RadicalEvent.CROPFAIL, 	Resources.RF, Resources.PS),
    ORE(3, "Ore", 2, 2, Tech.REN, 350, 20, 10, RadicalEvent.WAR, Resources.MINRCH, Resources.MINPR),
    GAMES(4, "Games", 3, 1, Tech.POS, 250, -10, 5, RadicalEvent.BOREDOM, Resources.ART, null),
    FIREARMS(5, "Firearms", 3, 1, Tech.IND, 1250, -75, 100, RadicalEvent.WAR, Resources.WAR, null),
    MEDICINE(6, "Medicine", 4, 1, Tech.POS, 650, -20, 10, RadicalEvent.PLAGUE, Resources.LOH, null),
    MACHINES(7, "Machines", 4, 3, Tech.IND, 900, -30, 5, RadicalEvent.LACKOFWORKERS, null, null),
    NARCOTICS(8, "Narcotics", 5, 0, Tech.IND, 3500, -125, 150, RadicalEvent.BOREDOM, Resources.WSHRM, null),
    ROBOTS(9, "Robots", 6, 4, Tech.HIT, 5000, -150, 100, RadicalEvent.LACKOFWORKERS, null, null);

    private final int id;
    private final String name;
    private final int mtlp;
    private final int mtlu;
    private final Tech ttp;
    private final int basePrice;
    private final int ipl;
    private final int var;
    private final RadicalEvent ie;
    private final Resources cr;
    private final Resources er;

    GoodType(int goodId, String goodName, int minProduce, int minUse, Tech level, int base,
             int increase, int variance,
             RadicalEvent event, Resources condition, Resources expensive) {
        id = goodId;
        name = goodName;
        mtlp = minProduce;
        mtlu = minUse;
        ttp = level;
        basePrice = base;
        ipl = increase;
        var = variance;
        ie = event;
        cr = condition;
        er = expensive;
    }
}