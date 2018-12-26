package souza.bruno.deckofmanytools.model;

import android.support.annotation.NonNull;

public class Die {
    private String sides;
    private int quantity;
    private int modifier;

    public Die() {
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public String getSides() {
        return sides;
    }

    public void setSides(String sides) {
        this.sides = sides;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @NonNull
    @Override
    public String toString() {
        return "Die{" +
                "sides='" + sides + '\'' +
                ", quantity=" + quantity +
                ", modifier=" + modifier +
                '}';
    }

    public String changeDieIcon(){
        if (this.sides == "d4"){
            return "http://icons.iconarchive.com/icons/iconcubic/dnd-dice/128/d4-icon.png";
        } else if (this.sides == "d6") {
            return "http://icons.iconarchive.com/icons/iconcubic/dnd-dice/128/d6-icon.png";
        }else if (this.sides == "d8"){
            return "http://icons.iconarchive.com/icons/iconcubic/dnd-dice/128/d8-icon.png";
        }else if (this.sides == "d10"){
            return "http://icons.iconarchive.com/icons/iconcubic/dnd-dice/128/d10-icon.png";
        }else if (this.sides == "d100"){
            return "http://www.numericana.com/answer/penta60.gif";
        }else if (this.sides == "d12"){
            return "http://icons.iconarchive.com/icons/iconcubic/dnd-dice/128/d12-icon.png";
        }else if(this.sides == "d20"){
            return "http://icons.iconarchive.com/icons/iconcubic/dnd-dice/128/d20-icon.png";
        }else{
            return null;
        }

//        switch (sides){
//            case "d4": return "http://icons.iconarchive.com/icons/iconcubic/dnd-dice/128/d4-icon.png"; break;
//            case "d6": return "http://icons.iconarchive.com/icons/iconcubic/dnd-dice/128/d6-icon.png"; break;
//            case "d8": return "http://icons.iconarchive.com/icons/iconcubic/dnd-dice/128/d8-icon.png"; break;
//            case "d10": return "http://icons.iconarchive.com/icons/iconcubic/dnd-dice/128/d10-icon.png"; break;
//            case "d100": return "http://www.numericana.com/answer/penta60.gif"; break;
//            case "d12": return "http://icons.iconarchive.com/icons/iconcubic/dnd-dice/128/d12-icon.png"; break;
//            case "d20": return "http://icons.iconarchive.com/icons/iconcubic/dnd-dice/128/d20-icon.png"; break;
//            default: return null;
//        }
    }
}
