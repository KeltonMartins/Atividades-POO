import java.util.ArrayList;
import java.util.List;

public class Pig {
    private List<Item> items;
    private double value;
    private int volume;
    private int volumeMax;
    private boolean broken;

    public Pig(int volumeMax) {
        this.items = new ArrayList<>();
        this.value = 0;
        this.volume = 0;
        this.volumeMax = volumeMax;
        this.broken = false;
    }

    public boolean addCoin(Coin moeda) {
        if (broken) {
            System.out.println("You pig has been break");
            return false;
        }
        if (moeda.getVolume() + volume <= volumeMax) {
            value += moeda.value;
            volume += moeda.getVolume();
            return true;
        }
        System.out.println("fail: full pig");
        return false;
    }

    public boolean addItem(Item item) {
        if (broken) {
            System.out.println("You pig has been break");
            return false;
        }
        if (item.getVolume() + volume <= volumeMax) {
            items.add(item);
            volume += item.getVolume();
            return true;
        }
        System.out.println("fail: full pig");
        return false;
    }

    public boolean breakPig() {
        if (!broken) {
            broken = true;
            return true;
        }
        return false;
    }

    public double getCoins() {
        if (!broken) {
            System.out.println("You must break the pig first");
            return 0.0;
        }
        return value;
    }

    public String getItens() {
        if (!broken) {
            System.out.println("You must break the pig first");
            return "";
        }
        return String.join(", ", items.stream().map(Item::toString).toArray(String[]::new));
    }

    public int getVolume() {
        return volume;
    }

    public int getVolumeMax() {
        return volumeMax;
    }

    public boolean isBroken() {
        return broken;
    }

    public String toString() {
        return "I:(" + (broken ? getItens() : String.join(", ", items.stream().map(Item::toString).toArray(String[]::new)))
                + ") M:" + String.format("%.1f", value) + " V:" + volume + "/" + volumeMax + " EQ:" + broken;
    }
}