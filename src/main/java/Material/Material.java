package Material;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Material {
    //name of the material
    private String name;
    //amount of the material
    private int amount;

    Material(String name) {
        this.name = name;
    }

    public void addAmount(int i) {
        this.amount += i;
    }
}
