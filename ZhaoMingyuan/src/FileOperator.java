import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 编程只服JAVA on 2017.07.06.
 */
public class FileOperator {
    public static void main(String[] args) throws IOException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String dateString = formatter.format(date);
        System.out.println(dateString);
        File file = new File("D:" + File.separator +  dateString + ".java");
        System.out.println(file.getAbsolutePath());
        if (!file.exists())
            file.createNewFile();
    }
}
