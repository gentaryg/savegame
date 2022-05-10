import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private int health;
    private int weapons;
    private int lvl;
    private double distance;
    private File savegames = new File("/Users/a.shalygin/Games/savegames");

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


    public void saveGame(String fileOutputStream, GameProgress gameProgress) {
        try (FileOutputStream saveGame = new FileOutputStream(fileOutputStream);
             ObjectOutputStream save = new ObjectOutputStream(saveGame)) {
            save.writeObject(gameProgress);
            System.out.println("Done!");
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    public void zipGame(String path) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path))) {
            for (File file : savegames.listFiles()) {
                if (file.getName().endsWith(".zip")) continue;
                try (FileInputStream fis = new FileInputStream(file)) {
                    ZipEntry entry = new ZipEntry(file.getName());
                    zout.putNextEntry(entry);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zout.write(buffer);
                    zout.closeEntry();
                    System.out.println("done fis");
                } catch (IOException e) {
                    System.out.println("error fis");
                }
            }
            System.out.println("done zip");
        } catch (IOException e) {
            System.out.println("error zip");
        }
    }
    public void del() {
        for (File list : savegames.listFiles()) {
            String name = list.getName();
            String type = name.substring(name.lastIndexOf('.'));
            if (type.equals(".txt")) {
                list.delete();
            }
        }
    }
}