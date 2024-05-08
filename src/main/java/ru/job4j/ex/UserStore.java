package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                result = user;
                break;
            }
        }
        if (result == null) {
            throw new UserNotFoundException("Пользователь не найден.");
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean result = false;
        if (user.isValid() && user.getUsername().length() >= 3) {
            result = true;
        }
        if (!result) {
            throw new UserInvalidException("Пользователь не валидный.");
        }
        return result;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };

        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println(e.getMessage());
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}