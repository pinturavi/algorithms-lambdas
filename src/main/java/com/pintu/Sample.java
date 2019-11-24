package com.pintu;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

interface Util {
    default int getNoOfCores(){return getCoresCommon();}
    private int getCoresCommon(){return 5;}
    private static int getCoresCommon2(){return getCoresCommon2();}
    static int getNoOfCores2() {return getCoresCommon2();}
}

class Resource implements AutoCloseable{

    public Resource(){
        System.out.println("creating Resource...");
    }
    public void op1(){
        System.out.println("op1");
    }

    /*public void finalize(){
        System.out.println("finalize method called");
    }*/

    @Override
    public void close(){
        System.out.println("resource is closed");
    }
}
public class Sample implements Util {
    public static void main(String[] args) throws URISyntaxException, IOException {
        List<Integer> numbers =  List.of(5, 7, 8,9, 4, 6, 34, 23, 12);
       // numbers.stream().dropWhile(e -> e < 34).forEach(System.out::println);
       /* IntStream.iterate(1, e -> e + 1)
                //.limit(5)
                //.skip(4)
                .takeWhile(e -> e < 5)
                .forEach(System.out::println);*/

       /*IntStream.iterate(1, e -> e  < 5, e -> e + 2)
               .forEach(System.out::println);*/
        final var first = numbers.stream().filter(e -> e > 34)
                .findFirst();
        first.ifPresent(System.out::println);
        first.ifPresentOrElse(System.out::println, () -> new RuntimeException(""));


        final var path = Path.of("/home/ubuntu/Desktop/maven/jatwelve/src/main/resources/sample.txt");
        System.out.println(Files.readString(path));
        System.out.println(Files.writeString(path, "hi i am a mental", StandardOpenOption.APPEND ));
    }



    public static void user(Resource resource){
        try(resource) {
            resource.op1();

        }
    }
}
