package com.teambuilding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class RocketMQApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(RocketMQApplication.class,args);
        System.out.println( "Hello World!" );
    }
}
