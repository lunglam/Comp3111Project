package comp3111.qsproject;

import com.csvreader.CsvReader;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;

/**
 * This file is a container of collected QS data
 */

public class QSList {
    public static ObservableList<QSItem> list = FXCollections.observableArrayList();
    public static ObservableList<String> university = FXCollections.observableArrayList();
    public static ObservableList<String> type = FXCollections.observableArrayList();
    public static ObservableList<String> region = FXCollections.observableArrayList();
    public static ObservableList<String> country = FXCollections.observableArrayList();

    public static void initialize() {
        /*
            Your Code Here.
            1. Load the csv into list.
            2. Collect the set of university, type, region and country.
         */

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
