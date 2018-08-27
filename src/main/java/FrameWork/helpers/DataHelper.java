package FrameWork.helpers;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataHelper {

    public static List<HashMap<String, String>> data() {
        List<HashMap<String, String>> mydata = null;
        try {
            File fs = new File("C:\\Users\\Shashavalil\\Documents\\Framework\\Core_Frameworks\\cucumber-jvm-template-master\\cucumber-jvm-template-master\\src\\test\\resources\\Tests.testData\\TestData-seleniumframework.xlsx"/*"classpath:TestData-seleniumframework.xlsx"*/);
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet("SignInSignOut");
            Row HeaderRow = sheet.getRow(0);

            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row currentRow = sheet.getRow(i);
                HashMap<String, String> currentHash = new HashMap<String, String>();
                for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
                    Cell currentCell = currentRow.getCell(j);

                    switch (currentCell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(currentCell.getStringCellValue() + "\t");
                            currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
                            break;
                    }

                }
                mydata.add(currentHash);
            }

			/*fs.();*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mydata;

    }

    public static void set_get_property(List<HashMap<String, String>> datamap) throws Exception {
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            String fileData = "C:\\Users\\Shashavalil\\Documents\\Framework\\Core_Frameworks\\cucumber-jvm-template-master\\cucumber-jvm-template-master\\src\\test\\resources\\properties\\";
            output = new FileOutputStream(fileData + "projectConfig.properties");
            for (Map<String, String> hm : datamap) {

                Set<String> keys = hm.keySet();
                for (String k : keys) {
                    String key = (String) k;
                    prop.setProperty(key, hm.get(key));
                    System.out.println(key + ": " + hm.get(key));
                }
                // save properties to project root folder
                prop.store(output, null);
            }

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static Properties getPropConfigValues(String propFileName) throws IOException {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(propFileName);
            // load a properties file
            prop.load(input);

            // get the property value and print it out
                /*System.out.println(prop.getProperty("URL"));
				System.out.println(prop.getProperty("password"));*/
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }

    public static HashMap<String, String> getDataTestCase(String testDataFilePath, String TestCaseName) throws Exception {
        FileInputStream fis = new FileInputStream(new File(testDataFilePath));
        XSSFWorkbook workbook = new XSSFWorkbook(fis); // XSSFWorkbook for .xlsx file
        XSSFSheet sheet = workbook.getSheet("UserDetails"); // open sheet with name
        Iterator<Row> rowIterator = sheet.iterator();
        // Traversing over each row of XLSX file
        ArrayList<ArrayList<String>> rowDataAll = new ArrayList<ArrayList<String>>();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            if (row.getRowNum() == 0) // get the  title row
            {
                ArrayList<String> rowHeadings = new ArrayList<String>();
                Iterator cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    String colvaluerow0 = cell.getStringCellValue();
                    rowHeadings.add(colvaluerow0);
                }
                rowDataAll.add(rowHeadings);
            }

            if (row.getRowNum() != 0) // skip title row
            {
                ArrayList<String> rowData = new ArrayList<String>();
                Iterator cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    String colvaluerow = cell.getStringCellValue();
                    rowData.add(colvaluerow);
                }
                rowDataAll.add(rowData);
            }

        }
        // System.out.println("rowHeadings of excel sheet : "+rowHeadings);
		/*System.out.println("All rowData of excel sheet : "+rowDataAll);*/
        return getTestData(TestCaseName, rowDataAll);

    }

    private static HashMap<String, String> getTestData(String testcaseName, ArrayList<ArrayList<String>> rowDataAll) {
        ArrayList<ArrayList<String>> rowDataTest = new ArrayList<ArrayList<String>>();
        ArrayList<String> firstRow = new ArrayList<String>();
        for (int i = 0; i < rowDataAll.size(); i++) {
            if (i == 0) {
                firstRow = rowDataAll.get(i);
            }
            if (rowDataAll.get(i).get(0).equals(testcaseName)) {
                rowDataTest.add(firstRow);
                rowDataTest.add(rowDataAll.get(i));
                break;
            }
        }
        HashMap<String, String> testMapData = mapData(rowDataTest);
/*
		System.out.println("TestData for testcase : "+testcaseName+" is : "+testMapData);
*/
        return testMapData;
    }

    public static HashMap<String, String> mapData(ArrayList<ArrayList<String>> mapDataAlistAl) {
        HashMap<String, String> testMapData = new HashMap<String, String>();
        for (int i = 0; i < mapDataAlistAl.get(1).size(); i++) {
            testMapData.put(mapDataAlistAl.get(0).get(i), mapDataAlistAl.get(1).get(i));
        }
        return testMapData;
    }
}
