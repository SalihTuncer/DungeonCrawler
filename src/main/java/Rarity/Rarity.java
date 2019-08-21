package Rarity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Rarity {
    //name of the rarity
    private String name;

    Rarity(String name) {
        this.name = name;
    }
}
