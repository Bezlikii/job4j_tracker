package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenAddDuplicatePassport() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizenDuplicate = new Citizen("2f44a", "Andrei Petrov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        boolean addedDuplicate = office.add(citizenDuplicate);
        assertThat(addedDuplicate).isFalse();
        assertThat(office.get(citizenDuplicate.getPassport())).isEqualTo(citizen);
    }
}