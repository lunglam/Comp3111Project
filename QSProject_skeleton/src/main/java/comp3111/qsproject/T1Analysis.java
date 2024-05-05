package comp3111.qsproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.util.*;

public class T1Analysis {
    public ObservableList<QSItem> tableList = FXCollections.observableArrayList();


    public ObservableList<QSItem> tableListRankA = FXCollections.observableArrayList();
    public double standardDeviation;

    /**
     * Represents an analysis of QSItem data for a specific year.
     * The analysis includes calculating statistics such as mean and standard deviation
     * for the scores, as well as categorizing universities based on their grades.
     *
     * @param year The year for which the analysis is performed.
     */
    T1Analysis (String year) {
        /*
            Your Code Here.
            Collect the QSItem with corresponding years into tableList.
            Use static properties in QSList here.
            Hint: QSList.list is a static property.
         */
        ArrayList<Double> data = new ArrayList<>();

        for (QSItem qsItem : QSList.list) {
            if(qsItem.getYear().equals(year)){
                tableList.add(qsItem);
                try {
                    data.add(Double.parseDouble(qsItem.getScore()));
                } catch (NumberFormatException e) {

                }
            }
        }

        double sum = 0;
        for (double value : data) {
            sum += value;
        }
        double mean = sum / data.size();

        double squaredDifferencesSum = 0;
        for (double value : data) {
            double diff = value - mean;
            squaredDifferencesSum += diff * diff;
        }

        double variance = squaredDifferencesSum / (data.size() - 1);
        standardDeviation = Math.sqrt(variance);

        System.out.println("Standard Deviation: " + standardDeviation);

        for (QSItem qsItem : tableList) {
            try {
                qsItem.setGrade(mean,standardDeviation);
            } catch (NumberFormatException e) {

            }

        }

        for (QSItem qsItem : QSList.list) {
            if(qsItem.getYear().equals(year)){
                if(qsItem.getGrade().equals("A+")){
                    tableListRankA.add(qsItem);
                }
                if(qsItem.getGrade().equals("A")){
                    tableListRankA.add(qsItem);
                }
                if(qsItem.getGrade().equals("A-")){
                    tableListRankA.add(qsItem);
                }
            }
        }

    }

    ObservableList<QSItem> getTableList() {
        return tableList;
    }

    /**
     * Retrieves PieChart data based on the specified search criteria.
     * The PieChart displays the sum of scores for universities grouped by the chosen category.
     *
     * @param searchName The category for which to retrieve data ("country", "region", or "size").
     * @return An ObservableList of PieChart.Data representing the summed scores for each category.
     */

    ObservableList<PieChart.Data> getPieChartData(String searchName) {
        ObservableList<PieChart.Data> pieChartData= FXCollections.observableArrayList();
        /*
            Your Code Here.
            Return the Pie Chart Data.
            Pie Chart shows the SUM of the score.
            For example, when the user chooses "size", which means the searchName will be "size"
            And Return an ObservableList with PieChart.Data
            [
                key: "L", value: the Sum score of the Large size universities,
                key: "M", value: the Sum score of the Middle size universities,
                key: "S", value: the Sum score of the Small size universities,
            ]
         */
        // Create a map to store scores
        Map<String, Double> scoresMap = new HashMap<>();
        double score = 0.0;

        switch (searchName) {
            case "country":
                // Count scores
                for(int i=0; i<tableList.size();i++){
                    if(tableList.get(i).getCountry()!=null&&tableList.get(i).getScore()!=null){
                        String country = tableList.get(i).getCountry();
                        try {
                            score = Double.parseDouble(tableList.get(i).getScore());
                            scoresMap.put(country, scoresMap.getOrDefault(country, 0.0) + score);
                        } catch (NumberFormatException e) {

                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    PieChart.Data slice = new PieChart.Data(entry.getKey(), entry.getValue());
                    String labelText = slice.getName() + ": " + (int) Math.round(slice.getPieValue());
                    slice.setName(labelText);
                    pieChartData.add(slice);
                }
                break;
            case "region":
                // Count scores
                for(int i=0; i<tableList.size();i++){
                    if(tableList.get(i).getRegion()!=null&&tableList.get(i).getScore()!=null){
                        String region = tableList.get(i).getRegion();
                        try {
                            score = Double.parseDouble(tableList.get(i).getScore());
                            scoresMap.put(region, scoresMap.getOrDefault(region, 0.0) + score);
                        } catch (NumberFormatException e) {
                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    PieChart.Data slice = new PieChart.Data(entry.getKey(), (int) Math.round(entry.getValue()));
                    String labelText = slice.getName() + ": " + (int) Math.round(slice.getPieValue());
                    slice.setName(labelText);
                    pieChartData.add(slice);
                }
                break;
            case "size":
                // Count scores
                for(int i=0; i<tableList.size();i++){
                    if(tableList.get(i).getSize()!=null&&tableList.get(i).getScore()!=null){
                        String size = tableList.get(i).getSize();
                        try {
                            score = Double.parseDouble(tableList.get(i).getScore());
                            scoresMap.put(size, scoresMap.getOrDefault(size, 0.0) + score);
                        } catch (NumberFormatException e) {
                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    PieChart.Data slice = new PieChart.Data(entry.getKey(), entry.getValue());
                    String labelText = slice.getName() + ": " + (int) Math.round(slice.getPieValue());
                    slice.setName(labelText);
                    pieChartData.add(slice);
                }
                break;
            case "type":
                // Count scores
                for(int i=0; i<tableList.size();i++){
                    if(tableList.get(i).getType()!=null&&tableList.get(i).getScore()!=null){
                        String type = tableList.get(i).getType();
                        try {
                            score = Double.parseDouble(tableList.get(i).getScore());
                            scoresMap.put(type, scoresMap.getOrDefault(type, 0.0) + score);
                        } catch (NumberFormatException e) {
                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    PieChart.Data slice = new PieChart.Data(entry.getKey(), (int) Math.round(entry.getValue()));
                    String labelText = slice.getName() + ": " + (int) Math.round(slice.getPieValue());
                    slice.setName(labelText);
                    pieChartData.add(slice);
                }
                break;
            case "researchOutput":
                // Count scores
                for(int i=0; i<tableList.size();i++){
                    if(tableList.get(i).getResearchOutput()!=null&&tableList.get(i).getScore()!=null){
                        String ro = tableList.get(i).getResearchOutput();
                        try {
                            score = Double.parseDouble(tableList.get(i).getScore());
                            scoresMap.put(ro, scoresMap.getOrDefault(ro, 0.0) + score);
                        } catch (NumberFormatException e) {
                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    PieChart.Data slice = new PieChart.Data(entry.getKey(), (int) Math.round(entry.getValue()));
                    String labelText = slice.getName() + ": " + (int) Math.round(slice.getPieValue());
                    slice.setName(labelText);
                    pieChartData.add(slice);
                }
                break;
        }

        return pieChartData;
    }

    ObservableList<PieChart.Data> getPieChartDataRankA(String searchName) {
        ObservableList<PieChart.Data> pieChartData= FXCollections.observableArrayList();
        /*
            Your Code Here.
            Return the Pie Chart Data.
            Pie Chart shows the SUM of the score.
            For example, when the user chooses "size", which means the searchName will be "size"
            And Return an ObservableList with PieChart.Data
            [
                key: "L", value: the Sum score of the Large size universities,
                key: "M", value: the Sum score of the Middle size universities,
                key: "S", value: the Sum score of the Small size universities,
            ]
         */
        // Create a map to store scores
        Map<String, Double> scoresMap = new HashMap<>();
        double score = 0.0;

        switch (searchName) {
            case "country":
                // Count scores
                for(int i=0; i<tableListRankA.size();i++){
                    if(tableListRankA.get(i).getCountry()!=null&&tableListRankA.get(i).getScore()!=null){
                        String country = tableListRankA.get(i).getCountry();
                        try {
                            score = Double.parseDouble(tableListRankA.get(i).getScore());
                            scoresMap.put(country, scoresMap.getOrDefault(country, 0.0) + score);
                        } catch (NumberFormatException e) {

                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    PieChart.Data slice = new PieChart.Data(entry.getKey(), entry.getValue());
                    String labelText = slice.getName() + ": " + (int) Math.round(slice.getPieValue());
                    slice.setName(labelText);
                    pieChartData.add(slice);
                }
                break;
            case "region":
                // Count scores
                for(int i=0; i<tableListRankA.size();i++){
                    if(tableListRankA.get(i).getRegion()!=null&&tableListRankA.get(i).getScore()!=null){
                        String region = tableListRankA.get(i).getRegion();
                        try {
                            score = Double.parseDouble(tableListRankA.get(i).getScore());
                            scoresMap.put(region, scoresMap.getOrDefault(region, 0.0) + score);
                        } catch (NumberFormatException e) {
                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    PieChart.Data slice = new PieChart.Data(entry.getKey(), (int) Math.round(entry.getValue()));
                    String labelText = slice.getName() + ": " + (int) Math.round(slice.getPieValue());
                    slice.setName(labelText);
                    pieChartData.add(slice);
                }
                break;
            case "size":
                // Count scores
                for(int i=0; i<tableListRankA.size();i++){
                    if(tableListRankA.get(i).getSize()!=null&&tableListRankA.get(i).getScore()!=null){
                        String size = tableListRankA.get(i).getSize();
                        try {
                            score = Double.parseDouble(tableListRankA.get(i).getScore());
                            scoresMap.put(size, scoresMap.getOrDefault(size, 0.0) + score);
                        } catch (NumberFormatException e) {
                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    PieChart.Data slice = new PieChart.Data(entry.getKey(), entry.getValue());
                    String labelText = slice.getName() + ": " + (int) Math.round(slice.getPieValue());
                    slice.setName(labelText);
                    pieChartData.add(slice);
                }
                break;
            case "type":
                // Count scores
                for(int i=0; i<tableListRankA.size();i++){
                    if(tableListRankA.get(i).getType()!=null&&tableListRankA.get(i).getScore()!=null){
                        String type = tableListRankA.get(i).getType();
                        try {
                            score = Double.parseDouble(tableListRankA.get(i).getScore());
                            scoresMap.put(type, scoresMap.getOrDefault(type, 0.0) + score);
                        } catch (NumberFormatException e) {
                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    PieChart.Data slice = new PieChart.Data(entry.getKey(), (int) Math.round(entry.getValue()));
                    String labelText = slice.getName() + ": " + (int) Math.round(slice.getPieValue());
                    slice.setName(labelText);
                    pieChartData.add(slice);
                }
                break;
            case "researchOutput":
                // Count scores
                for(int i=0; i<tableListRankA.size();i++){
                    if(tableListRankA.get(i).getResearchOutput()!=null&&tableListRankA.get(i).getScore()!=null){
                        String ro = tableListRankA.get(i).getResearchOutput();
                        try {
                            score = Double.parseDouble(tableListRankA.get(i).getScore());
                            scoresMap.put(ro, scoresMap.getOrDefault(ro, 0.0) + score);
                        } catch (NumberFormatException e) {
                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    PieChart.Data slice = new PieChart.Data(entry.getKey(), (int) Math.round(entry.getValue()));
                    String labelText = slice.getName() + ": " + (int) Math.round(slice.getPieValue());
                    slice.setName(labelText);
                    pieChartData.add(slice);
                }
                break;
        }

        return pieChartData;
    }


    /**
     * Retrieves bar chart data based on the specified search criteria.
     * The bar chart displays the average score for universities grouped by the chosen category.
     *
     * @param searchName The category for which to retrieve data ("country", "region", or "size").
     * @return An ObservableList of XYChart.Series representing the average scores for each category.
     */
    ObservableList<XYChart.Series<String, Double>> getBarChartData(String searchName) {
        ObservableList<XYChart.Series<String, Double>> seriesList = FXCollections.observableArrayList();
        XYChart.Series<String, Double> barData= new XYChart.Series<>();
        /*
            Your Code Here.
            Return the Bar Chart Data.
            Bar Chart shows the Avg. of the score.
            For example, when the user chooses "size", which means the searchName will be "size"
            And Return an XYChart.Series with XYChart.Data
            [
                key: "L", value: the Average score of the Large size universities,
                key: "M", value: the Average score of the Middle size universities,
                key: "S", value: the Average score of the Small size universities,
            ]
         */

        Map<String, Double> scoresMap = new HashMap<>();
        Map<String, Integer> occurrencesMap = new HashMap<>();
        double score = 0.0;
        switch (searchName) {
            case "country":
                for(int i=0; i<tableList.size();i++){
                    if(tableList.get(i).getCountry()!=null&&tableList.get(i).getScore()!=null){
                        String country = tableList.get(i).getCountry();
                        try {
                            score = Double.parseDouble(tableList.get(i).getScore());
                            scoresMap.put(country, scoresMap.getOrDefault(country, 0.0) + score);
                            occurrencesMap.put(country, occurrencesMap.getOrDefault(country, 0) + 1);
                        } catch (NumberFormatException e) {

                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    double temp = entry.getValue()/(occurrencesMap.get(entry.getKey()));
                    barData.getData().add(new XYChart.Data<>(entry.getKey(), temp));
                }
                break;
            case "region":
                for(int i=0; i<tableList.size();i++){
                    if(tableList.get(i).getRegion()!=null&&tableList.get(i).getScore()!=null){
                        String region = tableList.get(i).getRegion();
                        try {
                            score = Double.parseDouble(tableList.get(i).getScore());
                            scoresMap.put(region, scoresMap.getOrDefault(region, 0.0) + score);
                            occurrencesMap.put(region, occurrencesMap.getOrDefault(region, 0) + 1);
                        } catch (NumberFormatException e) {

                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    double temp = entry.getValue()/(occurrencesMap.get(entry.getKey()));
                    barData.getData().add(new XYChart.Data<>(entry.getKey(), temp));
                }
                break;
            case "size":
                for(int i=0; i<tableList.size();i++){
                    if(tableList.get(i).getSize()!=null&&tableList.get(i).getScore()!=null){
                        String size = tableList.get(i).getSize();
                        try {
                            score = Double.parseDouble(tableList.get(i).getScore());
                            scoresMap.put(size, scoresMap.getOrDefault(size, 0.0) + score);
                            occurrencesMap.put(size, occurrencesMap.getOrDefault(size, 0) + 1);
                        } catch (NumberFormatException e) {

                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    double temp = entry.getValue()/(occurrencesMap.get(entry.getKey()));
                    barData.getData().add(new XYChart.Data<>(entry.getKey(), temp));
                }
                break;
            case "type":
                for(int i=0; i<tableList.size();i++){
                    if(tableList.get(i).getType()!=null&&tableList.get(i).getScore()!=null){
                        String type = tableList.get(i).getType();
                        try {
                            score = Double.parseDouble(tableList.get(i).getScore());
                            scoresMap.put(type, scoresMap.getOrDefault(type, 0.0) + score);
                            occurrencesMap.put(type, occurrencesMap.getOrDefault(type, 0) + 1);
                        } catch (NumberFormatException e) {

                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    double temp = entry.getValue()/(occurrencesMap.get(entry.getKey()));
                    barData.getData().add(new XYChart.Data<>(entry.getKey(), temp));
                }
                break;
            case "researchOutput":
                for(int i=0; i<tableList.size();i++){
                    if(tableList.get(i).getResearchOutput()!=null&&tableList.get(i).getScore()!=null){
                        String ro = tableList.get(i).getResearchOutput();
                        try {
                            score = Double.parseDouble(tableList.get(i).getScore());
                            scoresMap.put(ro, scoresMap.getOrDefault(ro, 0.0) + score);
                            occurrencesMap.put(ro, occurrencesMap.getOrDefault(ro, 0) + 1);
                        } catch (NumberFormatException e) {

                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    double temp = entry.getValue()/(occurrencesMap.get(entry.getKey()));
                    barData.getData().add(new XYChart.Data<>(entry.getKey(), temp));
                }
                break;
        }


        seriesList.add(barData);
        return seriesList;
    }



    ObservableList<XYChart.Series<String, Double>> getBarChartDataRankA(String searchName) {
        ObservableList<XYChart.Series<String, Double>> seriesList = FXCollections.observableArrayList();
        XYChart.Series<String, Double> barData= new XYChart.Series<>();
        /*
            Your Code Here.
            Return the Bar Chart Data.
            Bar Chart shows the Avg. of the score.
            For example, when the user chooses "size", which means the searchName will be "size"
            And Return an XYChart.Series with XYChart.Data
            [
                key: "L", value: the Average score of the Large size universities,
                key: "M", value: the Average score of the Middle size universities,
                key: "S", value: the Average score of the Small size universities,
            ]
         */

        Map<String, Double> scoresMap = new HashMap<>();
        Map<String, Integer> occurrencesMap = new HashMap<>();
        double score = 0.0;
        switch (searchName) {
            case "country":
                for(int i=0; i<tableListRankA.size();i++){
                    if(tableListRankA.get(i).getCountry()!=null&&tableListRankA.get(i).getScore()!=null){
                        String country = tableListRankA.get(i).getCountry();
                        try {
                            score = Double.parseDouble(tableListRankA.get(i).getScore());
                            scoresMap.put(country, scoresMap.getOrDefault(country, 0.0) + score);
                            occurrencesMap.put(country, occurrencesMap.getOrDefault(country, 0) + 1);
                        } catch (NumberFormatException e) {

                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    double temp = entry.getValue()/(occurrencesMap.get(entry.getKey()));
                    barData.getData().add(new XYChart.Data<>(entry.getKey(), temp));
                }
                break;
            case "region":
                for(int i=0; i<tableListRankA.size();i++){
                    if(tableListRankA.get(i).getRegion()!=null&&tableListRankA.get(i).getScore()!=null){
                        String region = tableListRankA.get(i).getRegion();
                        try {
                            score = Double.parseDouble(tableListRankA.get(i).getScore());
                            scoresMap.put(region, scoresMap.getOrDefault(region, 0.0) + score);
                            occurrencesMap.put(region, occurrencesMap.getOrDefault(region, 0) + 1);
                        } catch (NumberFormatException e) {

                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    double temp = entry.getValue()/(occurrencesMap.get(entry.getKey()));
                    barData.getData().add(new XYChart.Data<>(entry.getKey(), temp));
                }
                break;
            case "size":
                for(int i=0; i<tableListRankA.size();i++){
                    if(tableListRankA.get(i).getSize()!=null&&tableListRankA.get(i).getScore()!=null){
                        String size = tableListRankA.get(i).getSize();
                        try {
                            score = Double.parseDouble(tableListRankA.get(i).getScore());
                            scoresMap.put(size, scoresMap.getOrDefault(size, 0.0) + score);
                            occurrencesMap.put(size, occurrencesMap.getOrDefault(size, 0) + 1);
                        } catch (NumberFormatException e) {

                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    double temp = entry.getValue()/(occurrencesMap.get(entry.getKey()));
                    barData.getData().add(new XYChart.Data<>(entry.getKey(), temp));
                }
                break;
            case "type":
                for(int i=0; i<tableListRankA.size();i++){
                    if(tableListRankA.get(i).getType()!=null&&tableListRankA.get(i).getScore()!=null){
                        String type = tableListRankA.get(i).getType();
                        try {
                            score = Double.parseDouble(tableListRankA.get(i).getScore());
                            scoresMap.put(type, scoresMap.getOrDefault(type, 0.0) + score);
                            occurrencesMap.put(type, occurrencesMap.getOrDefault(type, 0) + 1);
                        } catch (NumberFormatException e) {

                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    double temp = entry.getValue()/(occurrencesMap.get(entry.getKey()));
                    barData.getData().add(new XYChart.Data<>(entry.getKey(), temp));
                }
                break;
            case "researchOutput":
                for(int i=0; i<tableListRankA.size();i++){
                    if(tableListRankA.get(i).getResearchOutput()!=null&&tableListRankA.get(i).getScore()!=null){
                        String ro = tableListRankA.get(i).getResearchOutput();
                        try {
                            score = Double.parseDouble(tableListRankA.get(i).getScore());
                            scoresMap.put(ro, scoresMap.getOrDefault(ro, 0.0) + score);
                            occurrencesMap.put(ro, occurrencesMap.getOrDefault(ro, 0) + 1);
                        } catch (NumberFormatException e) {

                        }
                    }

                }

                for (Map.Entry<String, Double> entry : scoresMap.entrySet()) {
                    double temp = entry.getValue()/(occurrencesMap.get(entry.getKey()));
                    barData.getData().add(new XYChart.Data<>(entry.getKey(), temp));
                }
                break;
        }


        seriesList.add(barData);
        return seriesList;
    }


}
