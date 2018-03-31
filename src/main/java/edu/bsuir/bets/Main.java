package edu.bsuir.bets;

public class Main {
    public static void main(String[] args) {
        try {
            Person person1 = new Person("Вася Пупкин", 3000);
            Person person2 = new Person("Джон Доy", 4000);
            Person person3 = new Person("Мэри Сью", 5000);
            Match match = new Match(5);
            Participant part1 = new Participant("Зенит", 60);
            Participant part2 = new Participant("Спартак", 40);
            match.addParticipant(part1);
            match.addParticipant(part2);
            System.out.println(match.getRate(0));
            System.out.println(match.getRate(1));
            match.addBet(person1, 1000, 0);
            match.addBet(person2, 3000, 1);
            match.addBet(person3, 5000, 0);
            match.setWinner(1);
            System.out.println(person1);
            System.out.println(person2);
            System.out.println(person3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
