package Code;

public class ProgramKiller {
    private static ProgramKiller instance;
    private boolean running = true;

    public static ProgramKiller getInstance() {
        if (instance == null) {
            instance = new ProgramKiller();
        }

        return instance;
    }

    public void closeProgram() {
        running = false;
    }

    public boolean getRunning() {
        return running;
    }
}
