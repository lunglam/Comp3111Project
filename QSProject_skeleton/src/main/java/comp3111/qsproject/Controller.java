package comp3111.qsproject;

import javafx.application.HostServices;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    /* T1 Controller */
    public TableView<QSItem> t1DataTable;

    @FXML
    public ChoiceBox<String> t1YearChoiceBox;

    @FXML
    public BarChart<String, Double> t1BarChart;

    @FXML
    public TableColumn<QSItem, String> t1Rank;

    @FXML
    public TableColumn<QSItem, String> t1University;

    @FXML
    public TableColumn<QSItem, String> t1Score;

    @FXML
    public TableColumn<QSItem, String> t1Country;

    @FXML
    public TableColumn<QSItem, String> t1City;

    @FXML
    public TableColumn<QSItem, String> t1Type;

    public TableColumn<QSItem, String> t1Grade;

    public TableColumn<QSItem, Hyperlink> t1Link;

    public TableColumn<QSItem, Hyperlink> t1Logo;

    @FXML
    public PieChart t1PieChart;

    @FXML
    public ChoiceBox<String> t1PieChartChoiceBox;

    @FXML
    public Label t1PieChartLabel;

    @FXML
    public ChoiceBox<String> t1BarChartChoiceBox;

    @FXML
    public Label t1BarChartLabel;

    @FXML
    public CategoryAxis t1BarChartTypeXaxis;

    /* T2 Controller */
    @FXML
    public ChoiceBox<String> t2University1ChoiceBox;
    @FXML
    public ChoiceBox<String> t2University2ChoiceBox;
    @FXML
    public ChoiceBox<String> t2CountryRegion1ChoiceBox;
    @FXML
    public ChoiceBox<String> t2CountryRegion2ChoiceBox;

    @FXML
    public CheckBox t22017CheckBox;
    @FXML
    public CheckBox t22018CheckBox;
    @FXML
    public CheckBox t22019CheckBox;
    @FXML
    public CheckBox t22020CheckBox;
    @FXML
    public CheckBox t22021CheckBox;
    @FXML
    public CheckBox t22022CheckBox;
    @FXML
    public CheckBox t22017CheckBox2;
    @FXML
    public CheckBox t22018CheckBox2;
    @FXML
    public CheckBox t22019CheckBox2;
    @FXML
    public CheckBox t22020CheckBox2;
    @FXML
    public CheckBox t22021CheckBox2;
    @FXML
    public CheckBox t22022CheckBox2;

    @FXML
    public BarChart<Double, String> t21RankBarChart;
    @FXML
    public BarChart<Double, String> t21ScoreBarChart;
    @FXML
    public BarChart<Double, String> t21FacultyBarChart;
    @FXML
    public BarChart<Double, String> t21InternationalBarChart;
    @FXML
    public BarChart<Double, String> t21SFRBarChart;
    @FXML
    public LineChart<String, Double> t21LineChart;

    @FXML
    public BarChart<Double, String> t22RankBarChart;
    @FXML
    public BarChart<Double, String> t22ScoreBarChart;
    @FXML
    public BarChart<Double, String> t22FacultyBarChart;
    @FXML
    public BarChart<Double, String> t22InternationalBarChart;
    @FXML
    public BarChart<Double, String> t22SFRBarChart;
    @FXML
    public LineChart<String, Double> t22LineChart;

    /* T3 Controller */

    @FXML
    public TextField t3TopRankTextField;
    @FXML
    public TextField t3BottomRankTextField;
    @FXML
    public ChoiceBox<String> t3TypeChoiceBox;
    @FXML
    public ChoiceBox<String> t3RegionChoiceBox;
    @FXML
    public TableView<RecommendItem> t3TableView;

    @FXML
    public TableColumn<RecommendItem, String> t3University;

    @FXML
    public TableColumn<RecommendItem, String> t3BestYear;

    @FXML
    public TableColumn<RecommendItem, String> t3BestRank;

    @FXML
    public TableColumn<RecommendItem, String> t3RecentYear;

    @FXML
    public TableColumn<RecommendItem, String> t3RecentRank;

    ObservableList<String> yearList = FXCollections.observableArrayList("2017", "2018", "2019", "2020", "2021", "2022");
    ObservableList<String> stringPropertyList = FXCollections.observableArrayList("country", "region", "size", "type", "researchOutput");

    T1Analysis t1;

    String currentYear;

    @FXML
    private void initialize() {
        // Whole Program Information
        QSList.initialize();
        // T1
        t1YearChoiceBox.setItems(yearList);
        t1YearChoiceBox.setValue("2017");
        currentYear = "0";
        t1PieChartChoiceBox.setItems(stringPropertyList);
        t1PieChartChoiceBox.setValue("size");
        t1PieChartLabel.setText("");
        t1BarChartChoiceBox.setItems(stringPropertyList);
        t1BarChartChoiceBox.setValue("type");
        t1BarChartLabel.setText("");


        t1PieChartChoiceBox.setOnAction(this::handlePieChartChoiceBoxSelection);
        t1BarChartChoiceBox.setOnAction(this::handleBarChartChoiceBoxSelection);

        T1_onClickSearch();
        T1_onClickClear();

        // T2
        /*
            Your Code Here.
            1. Initialize the Choice boxes of university.
            2. Initialize the Choice boxes of country/region.
            3. For choice boxes of country/region,
                you need to add a blank or "All" option representing selection of all the country/region.
         */
        // T3
        /*
            Your Code Here.
            1. Initialize the Choice boxes of type.
            2. Initialize the Choice boxes of region.
            3. For choice boxes of region,
                you need to add a blank or "All" option representing selection of all the region.
         */
    }

    @FXML
    private void T1_onClickClear() {
        /*
            Your Code Here.
            Reset the Page Task1. (including the choice box, labels and charts)
         */

        t1DataTable.getItems().clear();
        t1PieChart.getData().clear();
        t1BarChart.getData().clear();
        t1YearChoiceBox.setValue("2017");
        t1PieChartChoiceBox.setValue("size");
        t1PieChartLabel.setText("");
        t1BarChartChoiceBox.setValue("type");
        t1BarChartLabel.setText("");
        currentYear = "0";

    }

    @FXML
    private void T1_onClickSearch() {
        /*
            Your Code Here.
            When click search on Task1:
                1. Fetch the year from the choice box.
                2. Clear previous data.
                3. Make an Analyser.
                4. Update the Table view, which shows Information about universities.
                5. Update the Pie Chart, which shows the sum score of selected property (t1PieChartChoiceBox).
                6. Update the Bar Chart, which shows the average score of selected property (t1BarChartChoiceBox).
            Please notice that we need listeners for monitoring the changes of choice box in pie chart and bar chart.
         */

            if(!currentYear.equals(t1YearChoiceBox.getValue())){
                t1DataTable.getItems().clear();
                String selectedYear = t1YearChoiceBox.getValue();
                t1 = new T1Analysis(selectedYear);

                //t1Grade = new TableColumn<>("t1Grade");
                t1DataTable.setItems(t1.getTableList());

                t1Grade.setCellValueFactory(new PropertyValueFactory<>("grade"));
                t1Link.setCellValueFactory(new PropertyValueFactory<>("link"));
                t1Link.setCellFactory(column -> new HyperlinkTableCell<>(Application.hostServices));

                t1Logo.setCellValueFactory(new PropertyValueFactory<>("logo"));
                t1Logo.setCellFactory(column -> new LogoHyperlinkTableCell<>(Application.hostServices));

                t1Rank.setCellValueFactory(new PropertyValueFactory<>("rank"));
                t1University.setCellValueFactory(new PropertyValueFactory<>("name"));
                t1Score.setCellValueFactory(new PropertyValueFactory<>("score"));
                t1Country.setCellValueFactory(new PropertyValueFactory<>("country"));
                t1City.setCellValueFactory(new PropertyValueFactory<>("city"));
                t1Type.setCellValueFactory(new PropertyValueFactory<>("type"));


                t1PieChart.getData().clear();
                t1BarChart.getData().clear();
                t1PieChart.setData(t1.getPieChartData(t1PieChartChoiceBox.getValue()));
                t1BarChart.setData(t1.getBarChartData(t1BarChartChoiceBox.getValue()));
                t1PieChartLabel.setText(t1PieChartChoiceBox.getValue() + " & score " + t1YearChoiceBox.getValue());
                t1BarChartLabel.setText(t1BarChartChoiceBox.getValue() + " & score " + t1YearChoiceBox.getValue());
                currentYear = selectedYear;
            }

    }

    class HyperlinkTableCell<S, T> extends TableCell<S, T> {
        private final Hyperlink hyperlink;
        private final HostServices hostServices;

        public HyperlinkTableCell(HostServices hostServices) {
            this.hostServices = hostServices;
            hyperlink = new Hyperlink();
            hyperlink.setOnAction(event -> {
                String url = getItem().toString();
                hostServices.showDocument(url);
            });
        }

        @Override
        protected void updateItem(T item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setGraphic(null);
            } else {
                hyperlink.setText("link");
                setGraphic(hyperlink);
            }
        }
    }

    class LogoHyperlinkTableCell<S, T> extends TableCell<S, T> {
        private final Hyperlink hyperlink;
        private final HostServices hostServices;

        public LogoHyperlinkTableCell(HostServices hostServices) {
            this.hostServices = hostServices;
            hyperlink = new Hyperlink();
            hyperlink.setOnAction(event -> {
                String url = getItem().toString();
                hostServices.showDocument(url);
            });
        }

        @Override
        protected void updateItem(T item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setGraphic(null);
            } else {
                hyperlink.setText("logo");
                setGraphic(hyperlink);
            }
        }
    }


    private void handlePieChartChoiceBoxSelection(ActionEvent event) {
        String selectedChoice = t1PieChartChoiceBox.getValue();
        // Update data based on the selected choice (fetch from DB, modify existing data, etc.)
        if(t1!=null){
            t1PieChart.getData().clear();
            t1PieChart.setData(t1.getPieChartData(selectedChoice));
            t1PieChartLabel.setText(t1PieChartChoiceBox.getValue() + " & score " + t1YearChoiceBox.getValue());
        }
    }

    private void handleBarChartChoiceBoxSelection(ActionEvent event) {
        String selectedChoice = t1BarChartChoiceBox.getValue();
        // Update data based on the selected choice (fetch from DB, modify existing data, etc.)
        if(t1!=null){
            t1BarChart.getData().clear();
            t1BarChart.setData(t1.getBarChartData(selectedChoice));
            t1BarChartLabel.setText(t1BarChartChoiceBox.getValue() + " & score " + t1YearChoiceBox.getValue());
        }
    }

    @FXML
    private void T21_onClickClear() {
        /*
            Your Code Here.
            Reset the Page Task 2.1. (including the choice boxes, check boxes and charts)
         */
    }

    @FXML
    private void T21_onClickCompare() {
        /*
            Your Code Here.
            When click search on Task2.1:
                1. Fetch the two universities from the choice box.
                2. Fetch the selected years.
                3. Clear previous data.
                4. Make an Analyser.
                5. Update the Bar Charts, which shows the average of selected property.
                6. Update the line Chart, which shows two lines of score of each year.
         */
    }

    @FXML
    private void T22_onClickClear() {
        /*
            Your Code Here.
            Reset the Page Task 2.2. (including the choice boxes, check boxes and charts)
         */
    }

    @FXML
    private void T22_onClickCompare() {
        /*
            Your Code Here.
            When click search on Task2.2:
                1. Fetch the two country/region from the choice box.
                2. Fetch the selected years.
                3. Clear previous data.
                4. Make an Analyser.
                5. Update the Bar Charts, which shows the average of selected property.
                6. Update the line Chart, which shows two lines of score of each year.
         */
    }

    @FXML
    private void T3_onClickClear() {
        /*
            Your Code Here.
            Reset the Page Task 2.2. (including the text fields, choice boxes and the table view)
         */
    }

    @FXML
    private void T3_onClickRecommend() {
        /*
            Your Code Here.
            When click search on Task3:
                1. Fetch the top and bottom boundary requirement of score.
                2. Fetch the type and region requirements.
                3. Clear previous data.
                4. Make an Analyser.
                5. Update the Table View.
         */
    }

}