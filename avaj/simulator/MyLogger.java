package avaj.simulator;

import java.io.*;

public class MyLogger {
    private static final String   fileName = "simulation.txt";
    BufferedWriter  bw = null;
    FileWriter      fw = null;

    public MyLogger() {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void     writeTo(String line) {
        try {
            fw = new FileWriter(fileName, true);
            bw = new BufferedWriter(fw);
            bw.write(line);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void     closeLogger() {
        try {
            if (bw != null) {
                bw.close();
            }
            if (fw != null) {
                fw.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
