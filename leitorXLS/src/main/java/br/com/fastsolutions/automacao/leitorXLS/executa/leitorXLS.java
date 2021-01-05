package br.com.fastsolutions.automacao.leitorXLS.executa;

import br.com.fastsolutions.automacao.leitorXLS.service.modelXlsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class leitorXLS implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(leitorXLS.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        new modelXlsService().salvaCsv();
    }
}
