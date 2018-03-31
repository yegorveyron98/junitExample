package edu.bsuir.bets;

import edu.bsuir.bets.exception.NotEnoughMoneyException;

public class Bet {
    private Person person;
    private Participant participant;
    private Integer money;

    public Bet(Person person, Participant participant, Integer money) {
        this.person = person;
        this.participant = participant;
        this.money = money;
    }

    public static Bet makeBet(Person person, Participant participant, Integer money) throws NotEnoughMoneyException {
        person.takeMoney(money);
        return new Bet(person, participant, money);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "person=" + person +
                ", participant=" + participant +
                ", money=" + money +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bet bet = (Bet) o;

        if (person != null ? !person.equals(bet.person) : bet.person != null) return false;
        if (participant != null ? !participant.equals(bet.participant) : bet.participant != null) return false;
        return money != null ? money.equals(bet.money) : bet.money == null;
    }

    @Override
    public int hashCode() {
        int result = person != null ? person.hashCode() : 0;
        result = 31 * result + (participant != null ? participant.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        return result;
    }
}
