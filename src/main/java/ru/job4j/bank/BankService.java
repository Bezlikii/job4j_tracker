package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс содержит основную бизнес-логику банковского сервиса.
 * @author Mikhail Kryukov
 * @version 1.0
 */

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему.
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());

    }

    /**
     * Методж уддаляет пользователя из системы.
     * @param passport пасспорт, который используется как уникальный идентификатор пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод создает счет пользователю.
     * @param passport паспорт
     * @param account счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта.
     * @param passport паспорт
     * @return Если нашел — возвращает пользователя, если нет — возвращает null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет пользователя по реквизитам.
     * @param passport паспорт
     * @param requisite реквизиты
     * @return Если поиск по паспорту не вернул null, то вернется счет пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод перечисляет деньги с одного счета на другой по реквизитам пользователя
     * @param sourcePassport паспорт, с которого переводят
     * @param sourceRequisite реквизиты, с которого переводят
     * @param destinationPassport паспорт, на который переводят
     * @param destinationRequisite реквизиты, на который переводят
     * @param amount сумма, которая переводится на счет
     * @return вернет true, если транзакция прошла успешно. Если счет не найден или не хватает денег то вернет false.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account requisiteAccountSource = findByRequisite(sourcePassport, sourceRequisite);
        Account requisiteAccountDestination = findByRequisite(destinationPassport, destinationRequisite);

        if ((requisiteAccountSource != null) && (requisiteAccountDestination != null) && (requisiteAccountSource.getBalance() >= amount)) {
            requisiteAccountSource.setBalance(requisiteAccountSource.getBalance() - amount);
            requisiteAccountDestination.setBalance((requisiteAccountDestination.getBalance()) + amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод получает список всех счетов пользователя.
     * @param user пользователь
     * @return возвращает спсиок счетов
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}