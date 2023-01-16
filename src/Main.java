import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class Main {
    private final static String WeatherURL="http://dataservice.accuweather.com/forecasts/v1/daily/5day/294021";
    private final static String API_KEY="?apikey=G3BtbBJNC9VGeArXaUd5BeY6neqSd1tJ";
    public static void main(String[] args) {
        try {
            //Сформировали юрэл для запроса к серверу
            URL weatherUrl=new URL(WeatherURL+API_KEY);
            // к серверу постучались
            HttpURLConnection urlConnection=(HttpURLConnection) weatherUrl.openConnection();
            //гет-респонс-код отправляет запрос к серверу который по сути является гет запросом
            if(urlConnection.getResponseCode()==200){
                try(BufferedReader reader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))){
                    StringBuilder responseContent=new StringBuilder();
                    String line="";
                    while ((line=reader.readLine())!=null){ //считываем данные от сервера до конца,
                        // тут нет еоф, так как это стинг будет нал
                        responseContent.append(line);
                    }
                    System.out.println(responseContent);

                }catch (IOException ex){
                    System.out.println(ex.getMessage());
                }

            }else{
                System.out.println("не подключили");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());

        }


    }
}