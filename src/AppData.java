import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class AppData {
    private String [] header;
    private int[][] data;

    public void init(String[] header) {
        this.header = header;
        Random random = new Random();
        data = new int[header.length][header.length];

        for (int row = 0; row < header.length; row++) {
            for (int col = 0; col < header.length; col++) {
                data[row][col] = random.nextInt(1000);
            }
        }
    }


    @Override
    public String toString() {
        String result = "";

        for (String word : header) {
            result += word + ";";
        }
        result += "\n";

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                result += data[row][col] + ";";
            }
            result += "\n";

        }
        return result;
    }

    public AppData newData(){
        AppData appData=new AppData();
        String [] header=new String[]{"title 1", "title 2", "title 3"};
        appData.init(header);
        return appData;
    }

    public void save(String path){

        try(FileOutputStream fileOutputStreamHW=new FileOutputStream(path)){

            byte[] dataBytes=newData().toString().getBytes(StandardCharsets.UTF_8);
            fileOutputStreamHW.write(dataBytes);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void loading(String path){
        try(FileInputStream fileInputStreamHW=new FileInputStream(path)){
            byte[] csvData=new byte[fileInputStreamHW.available()];//метод авэйлабел здесь выступает как размер массива
            fileInputStreamHW.read(csvData);//метод рид с перегрузкой, принимает на вход байтовый массив буфер
            String table=new String(csvData);//один из вариантов создания строки это из массива байт через конструктор класса стринг
            System.out.println(table);

        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
}
