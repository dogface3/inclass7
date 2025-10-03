package model;

public enum aikidoRank {
    L1(1,"White Belt"),
    L2(2,"Yellow Belt"),
    L3(3,"kolme"),
    L4(4,"nelja"),
    L5(5,"viisi");


    private final int value;
    private final String display;

    aikidoRank(int value, String display) {
        this.value = value;
        this.display = display;
    }

    public int getValue(){
        return value;
    }

    public String getDisplay(){
        return display;
    }


    public static aikidoRank fromValue(Integer value){
        if (value == null) return null;
        for (aikidoRank rank : values()) {
            if (rank.value == value) return rank;
        }
        return null;
    }
}
