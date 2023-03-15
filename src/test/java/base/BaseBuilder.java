package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.PropertiesReader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;


    public class BaseBuilder {
        PropertiesReader pro = new PropertiesReader();
        RequestSpecBuilder builder;
        RequestSpecification reqspec;
        Response response;
        PrintStream log;

        public RequestSpecification placeSpecBuilder() throws FileNotFoundException {
            builder = new RequestSpecBuilder();

            //Read environment variable key from command line and search in config.properties to find the match and set it
            String env = System.getProperty("ENG_WEB_BaseURI");

            if(env == null) {
                System.out.println("setting default environment to ==> "+pro.getPropValue("ENG_WEB_BaseURI"));
                env = pro.getPropValue("ENG_WEB_BaseURI");
            }

            System.out.println("Building Headers....");
//		builder.addQueryParam("key", "qaclick123");
            builder.setContentType("application/json");
//		builder.setContentType("multipart/form-data");
            log = new PrintStream(new FileOutputStream("log.txt"));
            builder.addFilter(RequestLoggingFilter.logRequestTo(log));
            builder.addFilter(ResponseLoggingFilter.logResponseTo(log));
            reqspec =  builder.build();
            return reqspec;
        }
    }

