package util;

import Main.ProjectManagement;
import ObjetDraw.ObjectCar;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by cuongnb on 11/8/16.
 */
public class ReadExcelFile {
    private static final String FILE_PATH = "/home/cuongnb/Desktop/jayes/tree/bayes/data/Data.xlsx";

//    public static void main(String args[]) {
//
//        List studentList = getStudentsListFromExcel();
//
//        System.out.println(studentList);
//    }

    public static ArrayList<ObjectCar> getStudentsListFromExcel() {
        ArrayList<ObjectCar> objectCars = new ArrayList<ObjectCar>();
        FileInputStream fis = null;
        ObjectCar objectCar;
        try {
            fis = new FileInputStream(FILE_PATH);

            // Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = new XSSFWorkbook(fis);

            int numberOfSheets = workbook.getNumberOfSheets();

            //looping over each workbook sheet
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                Iterator rowIterator = sheet.iterator();

                //iterating over each row
                while (rowIterator.hasNext()) {

                    Row row = (Row) rowIterator.next();
                    Iterator cellIterator = row.cellIterator();

                    //Iterating over each cell (column wise)  in a particular row.
                    ArrayList<String> tmp = new ArrayList<String>();
                    while (cellIterator.hasNext()) {


                        Cell cell = (Cell) cellIterator.next();

                        if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
                            tmp.add(cell.getStringCellValue());
                            //The Cell Containing numeric value will contain marks
                            System.out.println("okay");
                        } else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                            tmp.add(cell.getNumericCellValue() + "");
                            System.out.println("number");
                        }

                    }
                    //end iterating a row, add all the elements of a row in list
                    if (tmp.size() > 0) {
                        objectCar = new ObjectCar(tmp.get(0).toString().trim(), 5, 4, 3);
                        objectCars.add(objectCar);
                        if (!tmp.get(4).toString().equals("0.0")) {
                            String[] filed = tmp.get(4).split(";");
                            for (String s : filed) {
                                ProjectManagement.parent_child.add(s);
                            }
                        }
                        tmp = new ArrayList<String>();
                    }

                }
            }

            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectCars;
    }


}

