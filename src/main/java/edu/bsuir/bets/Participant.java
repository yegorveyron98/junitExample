package edu.bsuir.bets;

public class Participant {
    private String name;
    private Integer winPercent;

    public Participant(String name, Integer winPercent) {
        this.name = name;
        this.winPercent = winPercent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWinChance() {
        return winPercent;
    }

    public void setWinChance(Integer winChance) throws IllegalArgumentException {
        if (winChance < 0 || winChance > 100) throw new IllegalArgumentException("Попытка ввести нулевой шанс на победу");
        this.winPercent = winChance;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", winChance=" + winPercent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participant that = (Participant) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return winPercent != null ? winPercent.equals(that.winPercent) : that.winPercent == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (winPercent != null ? winPercent.hashCode() : 0);
        return result;
    }
}
