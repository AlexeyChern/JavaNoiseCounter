package Classes;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Excelparser {
    public static List<String> names = new ArrayList<>();
    public static List parse(String fileName) {
        //инициализируем потоки
        List<Double> result = new ArrayList<>();
        InputStream inputStream = null;
        XSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {

                Cell cell = cells.next();
                int cellType = cell.getCellType();
                //перебираем возможные типы ячеек
                switch (cellType) {
                    case Cell.CELL_TYPE_STRING:
                        names.add(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        result.add(cell.getNumericCellValue());
                        break;

                    case Cell.CELL_TYPE_FORMULA:
                        //result += "[" + cell.getNumericCellValue() + "]";
                        break;
                    default:
                        //result += "|";
                        break;
                }


            }


        }
        int k = result.size();
        List<List<Double>> materials = new ArrayList<>();

        materials.add(new ArrayList<>());
        materials.get(0).add(result.get(0));
        for (int i = 1; i < k; i++) {

            if (i % 8 > 0) {

                materials.get(i/8).add(result.get(i));
            } else {
                materials.add(new ArrayList<>());
                //System.out.println(now);
                //System.out.println(now);

                materials.get(i/8).add(result.get(i));
            }
            //System.out.println(materials);
        }

        //System.out.println(materials);
        return materials;
    }

}
