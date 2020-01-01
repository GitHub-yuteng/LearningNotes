package Review_Java.Java8;

import lombok.*;

import java.util.function.Supplier;

/**
 * @author Yu
 */
public class Lambda {
    public static void main(String[] args) {

        User user = new User(1,"a",true);

        Supplier<String> sup2 = user::getName;
        System.out.println(sup2.get());
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
}
