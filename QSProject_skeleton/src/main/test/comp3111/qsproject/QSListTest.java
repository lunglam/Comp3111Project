package comp3111.qsproject;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class QSListTest {

    @Test
    void initialize(){

         ObservableList<QSItem> list = FXCollections.observableArrayList();

        try (CSVReader reader = new CSVReader(new FileReader("QSProject_skeleton/src/main/resources/dataset/qs.csv"))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine contains an array of values from each row
                QSItem u = new QSItem(nextLine);
                list.add(u);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}