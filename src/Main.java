import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {
        GameProgress gameProgress1 = new GameProgress(100, 2, 10, 12.4);
        GameProgress gameProgress2 = new GameProgress(89, 4, 24, 123);
        GameProgress gameProgress3 = new GameProgress(10, 1, 30, 1234);
        File savegames = new File("/Users/a.shalygin/Games/savegames");
        try {


            File progress1 = new File(savegames, "saveProgress1.txt");
            progress1.createNewFile();
            File progress2 = new File(savegames, "saveProgress2.txt");
            progress2.createNewFile();
            File progress3 = new File(savegames, "saveProgress3.txt");
            progress3.createNewFile();
            gameProgress1.saveGames(progress1, gameProgress1);
            gameProgress2.saveGames(progress2, gameProgress2);
            gameProgress3.saveGames(progress3, gameProgress3);


            File zipSave = new File(savegames, "zip_save.zip");
            ZipOutputStream zSave = new ZipOutputStream(new FileOutputStream(zipSave));
            for (File saves : savegames.listFiles()) {
                if (saves.getName().contains(".txt")) {
                    FileInputStream saveProgressRead = new FileInputStream(saves);
                    zSave.putNextEntry(new ZipEntry(saves.getName()));
                    byte[] buffer = new byte[saveProgressRead.available()];
                    saveProgressRead.read(buffer);
                    zSave.write(buffer);
                    saveProgressRead.close();
                    zSave.closeEntry();
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for (File item :savegames.listFiles()) {
            if (item.getName().contains(".txt")) {
                item.delete();
            }
        }
    }




}
