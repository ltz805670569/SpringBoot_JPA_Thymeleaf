package cn.itxdl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RunBoot
{
    public static void main( String[] args )
    {
        ApplicationContext ac = SpringApplication.run(RunBoot.class,args);

    }
}
