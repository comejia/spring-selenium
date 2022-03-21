package com.comejia.springselenium.resource;

import com.comejia.springselenium.SpringBaseTestNG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceTest extends SpringBaseTestNG {

    @Value("file:/home/comejia/projects/spring-selenium-bdd/src/test/resources/data/testdata.csv")
    private Resource fileResource;

    @Value("classpath:data/testdata.csv")
    private Resource classpathResource;

    @Value("https://www.google.com")
    private Resource httpResource;

    @Value("https://www.w3.org/TR/PNG/iso_8859-1.txt")
    private Resource downloadResource;

    @Value("${screenshot.path}")
    private Path path;

    @Value("s3://my-bucket/s3-demo") // example to get file from AWS S3
    private Resource s3Resource;

    @Value("classpath:data/dynamictestdata.csv")
    private Resource dynamicResource;

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void classResourceTest() throws IOException {
        Files.readAllLines(classpathResource.getFile().toPath())
                .forEach(System.out::println);
    }

    @Test
    public void fileResourceTest() throws IOException {
        Files.readAllLines(fileResource.getFile().toPath())
                .forEach(System.out::println);
    }

    @Test
    public void httpResourceTest() throws IOException {
        System.out.println(new String(httpResource.getInputStream().readAllBytes()));
    }

    @Test
    public void downloadResourceTest() throws IOException {
        FileCopyUtils.copy(downloadResource.getInputStream(), Files.newOutputStream(path.resolve("download.txt")));
    }

    @Test(dataProvider = "getData")
    public void dynamicResourceTest(String url, String outFile) throws IOException {
        FileCopyUtils.copy(
                resourceLoader.getResource(url).getInputStream(),
                Files.newOutputStream(path.resolve(outFile))
        );
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return Files.readAllLines(dynamicResource.getFile().toPath())
                .stream()
                .map(s -> s.split(","))
                .toArray(Object[][]::new);
    }

}
