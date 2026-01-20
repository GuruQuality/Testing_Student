package edu.innotech;

import lombok.SneakyThrows;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Service {

    CloseableHttpClient httpClient;

    public Service() {
        this.httpClient = HttpClients.createDefault();
    }

    /**
     * Получение рейтинга
     */
    @SneakyThrows
    public int educ(int sum) throws IOException {
        HttpGet request = new HttpGet("http://localhost:5352/educ?sum=" + sum);
        CloseableHttpResponse httpResponse = httpClient.execute(request);
        HttpEntity entity = httpResponse.getEntity();
        if (entity == null) {
            throw new IOException("Response is null");
        }
        return Integer.parseInt(EntityUtils.toString(entity));
    }

    /**
     * Проверка оценки
     * @param grade оценка
     * @return true - допустимая оценка, false - не допустимая
     * @throws IOException
     */
    @SneakyThrows
    public boolean checkGrade(int grade) throws IOException {
        HttpGet request = new HttpGet("http://localhost:5352/checkGrade?grade=" + grade);
        CloseableHttpResponse httpResponse = httpClient.execute(request);
        HttpEntity entity = httpResponse.getEntity();
        return Boolean.parseBoolean(EntityUtils.toString(entity));
    }
}
