package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static int countUser = 0;
    private static List<User> users = new ArrayList<>();
    static{
        users.add(new User(++countUser, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++countUser, "Eve", LocalDate.now().minusYears(22)));
        users.add(new User(++countUser, "Jack", LocalDate.now().minusYears(25)));
    }
    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
        // return users.get(id);
    }

    public void deleteById(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

    public User save(User user){
        user.setId(++countUser);
        users.add(user);
        return user;
    }

}
