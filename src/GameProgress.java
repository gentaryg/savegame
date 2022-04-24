import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public void saveGames(File gameProgress, GameProgress progress) {
        try (FileOutputStream saveProgressWriter = new FileOutputStream(gameProgress)){
            byte[] bytes = progress.toString().getBytes();
            saveProgressWriter.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}