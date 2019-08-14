package Spring.IOC;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Yu
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {

    private String name;
    private String emissions;
}
