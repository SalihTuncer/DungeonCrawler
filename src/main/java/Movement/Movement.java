package Movement;

import Character.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Movement {

    Movement() {

    }

    public abstract void move(Player traveler, String destination);
}
