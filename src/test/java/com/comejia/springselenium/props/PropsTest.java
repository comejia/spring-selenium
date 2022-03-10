package com.comejia.springselenium.props;

import com.comejia.springselenium.SpringBaseTestNG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class PropsTest extends SpringBaseTestNG {

    @Autowired
    private ResourceLoader loader;

    @Test
    public void propsTest() throws IOException {

        Properties properties = PropertiesLoaderUtils.loadProperties(loader.getResource("my.properties"));
        System.out.println(properties);
    }
}
