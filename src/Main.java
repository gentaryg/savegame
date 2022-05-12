public class Main {

    public static void main(String[] args) {
        GameProgress gameProgress1 = new GameProgress(100, 2, 10, 12.4);
        GameProgress gameProgress2 = new GameProgress(89, 4, 24, 123);
        GameProgress gameProgress3 = new GameProgress(10, 1, 30, 1234);

        gameProgress1.saveGame("/Users/a.shalygin/Games/savegames/save1.txt", gameProgress1);
        gameProgress2.saveGame("/Users/a.shalygin/Games/savegames/save2.txt", gameProgress2);
        gameProgress3.saveGame("/Users/a.shalygin/Games/savegames/save3.txt", gameProgress3);

        gameProgress1.zipGame("/Users/a.shalygin/Games/savegames/save.zip");

        gameProgress1.del();
    }
}
