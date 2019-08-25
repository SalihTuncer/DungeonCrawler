package Flask;

import Character.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Flask {
    //actual name of the flask
    private String name;

    private int amount = 100;

    Flask(String name) {
        this.name = name;
    }

    public void addFlask() {
        this.amount++;
    }

    public void removeFlask() {
        this.amount--;
    }

    public abstract boolean useFlask(Player player);

    public abstract void noFlaskText();

    public void flaskAmountText(Flask flask) {
        if (flask.getAmount() > 1)
            System.out.println("You have " + flask.getAmount() + " " + flask.getName().
                    substring(0, flask.getName().length() - 5) + " flasks left.\n");
        else if (flask.getAmount() == 1)
            System.out.println("You have " + flask.getAmount() + " " + flask.getName().
                    substring(0, flask.getName().length() - 5) + " flask left.\n");
        else
            flask.noFlaskText();
    }

}
