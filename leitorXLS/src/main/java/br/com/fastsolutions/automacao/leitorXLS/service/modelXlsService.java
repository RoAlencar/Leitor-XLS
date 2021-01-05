package br.com.fastsolutions.automacao.leitorXLS.service;


import br.com.fastsolutions.automacao.leitorXLS.model.modelXLS;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class modelXlsService {

    String line = "";
    private HSSFWorkbook workbook;

    public void salvaCsv() throws IOException {
        long startTime = System.nanoTime();
        String filePath = "C:\\Users\\rodrigo.xavier\\Desktop\\Conv_26507128000130_21102020.xls";
        try {
            // Abrindo o arquivo e recuperando a planilha
            FileInputStream file = new FileInputStream(new File(filePath));
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.rowIterator();
            int totalLocal = 0;
            int totalEstadual = 0;
            int totalNacional =0;
            while (rowIterator.hasNext()) {
                Row row = (Row) rowIterator.next();
                // Descantando a primeira linha com o header
                if (row.getRowNum() == 0) {
                    continue;
                }

                Iterator<Cell> cellIterator = row.cellIterator();
                modelXLS Total = new modelXLS();
                // products.add(SMS);
                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    // Se o arquivo está na coluna 8 ---- O numero da primeira coluna sempre é 0
                    if (cell.getColumnIndex() == 8) {
                        //Transforma a celula em uma String e verifica se começa com "0"
                        if (cell.getStringCellValue().startsWith("0")) {
                            Total.setLocal(cell.getStringCellValue());
                            totalLocal ++;

                            //Transforma a celula em uma String e verifica se começa com "1"
                        } else if (cell.getStringCellValue().startsWith("1")) {
                            Total.setEstadual(cell.getStringCellValue());
                            totalEstadual ++;

                        } else {
                            Total.setNacional(cell.getStringCellValue());
                            totalNacional ++;
                        }
                    }
                }
            }
            System.out.println(("\nNumero de CEPS: \nLocal: " + totalLocal + "\nEstadual: " + totalEstadual + "\nNacional: " + totalNacional));
            int soma = totalLocal + totalEstadual + totalNacional;
            System.out.println("Total de CEPS: " + soma);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1_000_000_000;

        System.out.println("\nProcesso XLS encerrado");
        System.out.println(
                "Tempo total em segundos: " + totalTime + "s.\nTempo total em minutos: " + (totalTime / 60));
    }
}