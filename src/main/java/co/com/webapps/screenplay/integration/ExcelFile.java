package co.com.webapps.screenplay.integration;

import co.com.webapps.screenplay.exceptions.NotFoundFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExcelFile {


    private static final Logger LOGGER = LogManager.getLogger(ExcelFile.class);
    public static final String SHEET = "Sheet1";
    private static final String FILE_SEPARATOR;
    private static final String PATH_RESOURCES;

    static {
        FILE_SEPARATOR = File.separator;
        PATH_RESOURCES = String.format("src%stest%sresources%s", FILE_SEPARATOR, FILE_SEPARATOR, FILE_SEPARATOR);
    }

    public static ExcelFile newInstance() {
        return new ExcelFile();
    }

    public List<Map<String, Object>> getDataList(String excelFilePath, String sheetName) {
        int fila = 1;
        Sheet sheet;
        List<Map<String, Object>> listData = new ArrayList<>();
        try {
            sheet = getSheetByName(PATH_RESOURCES + excelFilePath, sheetName);
            sheet.getSheetName();
            listData = readSheet(sheet, fila);
        } catch (IOException e) {
            LOGGER.info(e.getMessage(), e);
        }

        return listData;

    }

    private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException {
        return getWorkBook(excelFilePath).getSheet(sheetName);
    }

    private Workbook getWorkBook(String excelFilePath) throws IOException {
        return WorkbookFactory.create(new File(excelFilePath));
    }

    private Row getRow(Sheet sheet, int rowNumber) {
        return sheet.getRow(rowNumber);
    }

    private int getHeaderRowNumber(Sheet sheet) {
        Row row;
        int numberRow = -1;
        int totalRow = sheet.getLastRowNum();
        for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
            row = getRow(sheet, currentRow);
            if (row != null) {
                int totalColumn = row.getLastCellNum();
                for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                    numberRow = row.getRowNum();
                }
            }
        }
        return numberRow;
    }


    private LinkedHashMap<String, Object> getCellValue(Sheet sheet, Row row, int currentColumn) {
        LinkedHashMap<String, Object> columnMapdata = new LinkedHashMap<>();
        Cell cell;
        if (row != null) {
            cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if (cell != null) {
                DataFormatter formatter = new DataFormatter();
                Object cellValue = formatter.formatCellValue(cell);
                columnMapdata.put(
                        sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex()).getStringCellValue(),
                        cellValue);
            }
        }

        return columnMapdata;
    }

    private List<Map<String, Object>> readSheet(Sheet sheet, int setCurrentRow) {
        Row row;
        int totalRow = sheet.getPhysicalNumberOfRows();
        List<Map<String, Object>> excelRows = new ArrayList<>();
        LinkedHashMap<String, Object> columnMapdata = new LinkedHashMap<>();
        int headerRowNumber = getHeaderRowNumber(sheet);
        if (headerRowNumber != -1) {
            for (int currentRow = setCurrentRow; currentRow < totalRow; currentRow++) {
                row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
                for (Cell cell : row) {

                    columnMapdata.putAll(getCellValue(sheet, row, cell.getColumnIndex()));
                }
                excelRows.add(columnMapdata);
                columnMapdata = new LinkedHashMap<>();
            }
        }

        return excelRows;
    }

    public void writeExcelMap(String path, List<Map<String, Object>> elements) {
        FileOutputStream file = null;
        try (FileOutputStream filename = new FileOutputStream(new File(path))) {
            file = filename;
            XSSFWorkbook workbook = writeMap(elements);
            workbook.write(file);
        } catch (IOException e) {
            throw new NotFoundFileException("No se encontró el archivo", e);
        } finally {
            closeExcelBook(file);
        }
    }

    private XSSFWorkbook writeMap(List<Map<String, Object>> elements) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(SHEET);
        int rowNum = 1;
        int columnNum =0;
        Row row = sheet.createRow(rowNum);

        Map<String,Object> elementHeader =elements.get(0);
        for(Map.Entry<String,Object> entry :elementHeader.entrySet()){
            Cell cell = row.createCell(columnNum++);
            cell.setCellValue(entry.getKey().toString());
        }

        for (Map<String,Object> element : elements) {
            columnNum =0;
            row = sheet.createRow(rowNum++);
            for(Map.Entry<String,Object> entry :element.entrySet()){
                Cell cell = row.createCell(columnNum++);
                String value = entry.getValue() == null ?" ":entry.getValue().toString();
                cell.setCellValue(value);
            }
        }
        return workbook;
    }


    private void closeExcelBook(FileOutputStream file) {
        if (file != null) {
            try {
                file.close();
            } catch (IOException e1) {
                LOGGER.error(e1);
            }
        }
    }

    private void closeExcelBook(FileInputStream file) {
        if (file != null) {
            try {
                file.close();
            } catch (IOException e1) {
                LOGGER.error(e1);
            }
        }
    }
}
