package DGP.CJLU.Utils.File;

import java.io.*;

public class FileHelper {
    public static StringBuilder readFileToStringBuilder(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            Reader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String data;
            while ((data = br.readLine()) != null)
                sb.append(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }
}
