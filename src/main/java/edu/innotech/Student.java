package edu.innotech;

import lombok.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
public class Student {
    @Setter
    private Service service;

    @Getter
    @Setter
    private String name;
    private List<Integer> grades = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }


    @SneakyThrows
    public void addGrade(int grade) throws IOException {
        if (!service.checkGrade(grade)) {
            throw new IllegalArgumentException(grade + " is wrong grade");
        }
        grades.add(grade);
    }

    @SneakyThrows
    public int raiting() throws IOException {
        return service.educ(grades.stream().mapToInt(x -> x).sum());
    }
}
