package Review_Java.Java8;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author Yu
 */
public class Lambda {
    public static void main(String[] args) {

        User user = new User(1, "a", true, 100);

        Supplier<String> sup2 = user::getName;
        System.out.println(sup2.get());

        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int nextInt = random.nextInt(100);
            list.add(nextInt);
        }

        list.forEach(item -> System.out.print(item + " "));
        System.out.println();
        List<Integer> collect = list.stream().filter(item -> item > 20).map(item -> item * 2).collect(Collectors.toList());
        System.out.println(collect);

        System.out.println(collect.stream().reduce(10000, (pre, item) -> item + pre));

        System.out.println("=================");

        List<User> userList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            User u = new User();
            u.setScore(random.nextInt(50) + 50);
            userList.add(u);
        }

        userList.stream().forEach(System.out::println);


        System.out.println(userList.stream().filter(item -> item.getScore() > 60)
                .map(item -> item.getScore()).reduce(0, (pre, item) -> pre + item));

        List<User> users = userList.stream().filter(item -> item.getScore() > 60)
                .map(item -> {
                    item.setScore(item.getScore() * 2);
                    return item;
                }).collect(Collectors.toList());

        System.out.println(users);

        System.out.println("========FlatMap========");
        List<String> teamIndia = Arrays.asList("Virat", "Dhoni", "Jadeja");
        List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
        List<String> teamEngland = Arrays.asList("Alex", "Bell", "Broad");
        List<String> teamNewZeland = Arrays.asList("Kane", "Nathan", "Vettori");
        List<String> teamSouthAfrica = Arrays.asList("AB", "Amla", "Faf");
        List<String> teamWestIndies = Arrays.asList("Sammy", "Gayle", "Narine");
        List<String> teamSriLanka = Arrays.asList("Mahela", "Sanga", "Dilshan");
        List<String> teamPakistan = Arrays.asList("Misbah", "Afridi", "Shehzad");

        List<List<String>> playersInWorldCup2016 = new ArrayList<>();
        playersInWorldCup2016.add(teamIndia);
        playersInWorldCup2016.add(teamAustralia);
        playersInWorldCup2016.add(teamEngland);
        playersInWorldCup2016.add(teamNewZeland);
        playersInWorldCup2016.add(teamSouthAfrica);
        playersInWorldCup2016.add(teamWestIndies);
        playersInWorldCup2016.add(teamSriLanka);
        playersInWorldCup2016.add(teamPakistan);

        // Let's print all players before Java 8
        List<String> listOfAllPlayers = new ArrayList<>();

        for(List<String> team : playersInWorldCup2016){
            for(String name : team){
                listOfAllPlayers.add(name);
            }
        }

        System.out.println("Players playing in world cup 2016");
        System.out.println(listOfAllPlayers);

        // Now let's do this in Java 8 using FlatMap  将多个List 转变为 一个List
        List<String> flatMapList = playersInWorldCup2016.stream()
                .flatMap(pList -> pList.stream())
                .collect(Collectors.toList());

        System.out.println("List of all Players using Java 8");
        System.out.println(flatMapList);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class User {
    private int id;
    private String name;
    private boolean flag;
    private Integer score;
}
