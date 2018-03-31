package edu.bsuir.bets;

import edu.bsuir.bets.exception.NotEnoughMoneyException;

public class Person {
    private String name;
    private Integer money;

    public Person(String name, Integer money) throws IllegalArgumentException {
        this.name = name;
        if (money < 0) throw new IllegalArgumentException("Попытка установить отрицательное количество денег");
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return money;
    }

    public Integer addMoney(Integer plus) throws IllegalArgumentException {
        if (plus < 0) throw new IllegalArgumentException("Попытка добавить отрицательное количество денег");
        return this.money += plus;
    }

    public Integer takeMoney(Integer minus) throws NotEnoughMoneyException {
        if (this.money >= minus) {
            return this.money -= minus;
        } else {
            throw new NotEnoughMoneyException(name + " не хватает денег чтобы вычесть " + minus);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return money != null ? money.equals(person.money) : person.money == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (money != null ? money.hashCode() : 0);
        return result;
    }
}
