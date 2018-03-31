package edu.bsuir.bets;

import edu.bsuir.bets.exception.NotEnoughMoneyException;
import edu.bsuir.bets.exception.WrongTotalWinChanceException;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private List<Bet> bets = new ArrayList<>();
    private List<Participant> participants = new ArrayList<>();
    private Integer margin;

    public Match() {
        this.margin = 5;
    }

    public Match(Integer margin) throws IllegalArgumentException {
        this.setMargin(margin);
    }

    public Integer getMargin() {
        return margin;
    }

    public void setMargin(Integer margin) throws IllegalArgumentException {
        if (margin > 1 || margin < 50) {
            this.margin = margin;
        } else {
            throw new IllegalArgumentException("Маржа отрицательная или превышает 50%");
        }
    }

    public List<Bet> getBets() {
        return bets;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void addParticipant(Participant participant) throws WrongTotalWinChanceException {
        if (getSumOfWinChances() + participant.getWinChance() <= 100) {
            participants.add(participant);
        } else {
            throw new WrongTotalWinChanceException("Общий шанс победы превышает 100%");
        }
    }

    public void addBet(Person person, Integer money, Integer participantNum)
            throws IllegalArgumentException, WrongTotalWinChanceException, NotEnoughMoneyException {
        if (getSumOfWinChances() == 100) {
            Participant target = participants.get(participantNum);
            bets.add(Bet.makeBet(person, target, money));
        } else {
            throw new WrongTotalWinChanceException("Попытка сделать ставку при некорректном списке участников");
        }
    }

    public void setWinner(Integer num) {
        if(getSumOfWinChances() == 100) {
            Participant winner = participants.get(num);
            Integer loss = bets.stream().mapToInt(e -> giveMoneyToWinner(e, winner)).sum();
            System.out.println("Букмекер получил " + (getAllMoney() - loss));
        }
    }

    private Integer giveMoneyToWinner(Bet bet, Participant winner) {
        Integer prize = 0;
        if(bet.getParticipant().equals(winner)) {
            prize = (int) (bet.getMoney() * getRate(winner));
            bet.getPerson().addMoney(prize);
            System.out.println(bet.getPerson().getName() + " получил " + prize);
        }
        return prize;
    }

    public Double getRate(Integer num) {
        return getRate(participants.get(num));
    }

    private Double getRate(Participant participant) {
        return 100.0 / (participant.getWinChance() + margin);
    }

    public Integer getAllMoney() {
        return bets.stream()
                .mapToInt(Bet::getMoney)
                .sum();
    }

    private Integer getSumOfWinChances() {
        return participants.stream()
                .mapToInt(Participant::getWinChance)
                .sum();
    }
}
