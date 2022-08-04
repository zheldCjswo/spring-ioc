package com.example.springioc;

import com.example.springioc.component.Base64Encoder;
import com.example.springioc.component.Encoder;
import com.example.springioc.component.Encoder2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class SpringIocApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIocApplication.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();

        //Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);

        Encoder encoder = context.getBean(Encoder.class);
        String url = "http://www.naver.com";

        String result = encoder.encode(url);
        System.out.println("result = " + result);
        
        Encoder2 encoder2 = (Encoder2) context.getBean("encoder2");
        String result2 = encoder2.encode(url);
        System.out.println("result2 = " + result2);
    }
}

@Configuration
class AppConfig {

    @Bean("encoder2")
    public Encoder2 encode(Base64Encoder base64Encoder){
        return new Encoder2(base64Encoder);
    }
}