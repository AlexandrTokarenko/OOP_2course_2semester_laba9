package com.example.laba_92;

import com.example.laba_92.model.Lab4Main;
import com.example.laba_92.model.Point;
import com.example.laba_92.table.PointDTO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private Label textAverage;
    @FXML
    private Label textSum;
    @FXML
    private Label textMax;
    @FXML
    private Label textMin;
    @FXML
    private Label textStep;
    @FXML
    private TextArea startField;
    @FXML
    private TextArea stepField;
    @FXML
    private TextArea finishField;
    private Lab4Main lab;
    public void initialize() {

        lab = new Lab4Main();
        xCol.setCellValueFactory(new PropertyValueFactory<>("xStr"));
        yCol.setCellValueFactory(new PropertyValueFactory<>("yStr"));
    }

    @FXML
    private TableView<PointDTO> table;

    private List<Point> points = new ArrayList<>();

    @FXML
    private TableColumn<PointDTO, String> xCol;

    @FXML
    private TableColumn<PointDTO, String> yCol;

    public void writeAll() {

        textStep.setText("Кількість кроків: " + points.size());
        textMin.setText("При х=" + String.format("%.2f",points.get(lab.minIndex(points)).getX()) + ", y=" + String.format("%.2f",points.get(lab.minIndex(points)).getY()) + " - найменше значення функції");
        textMax.setText("При х=" + String.format("%.2f",points.get(lab.maxIndex(points)).getX()) + ", y=" + String.format("%.2f",points.get(lab.minIndex(points)).getY()) + " - найбільше значення функції");
        textSum.setText("Сума значень функції: " + String.format("%.2f",lab.sum(points)));
        textAverage.setText("Середнє арифметичне значення функції: " + String.format("%.2f",lab.average(points)));
    }

    public void calculateAndWrite() {

        double start = Double.parseDouble(startField.getText());
        double finish = Double.parseDouble(finishField.getText());
        double step = Double.parseDouble(stepField.getText());
        this.points = new ArrayList<>(lab.tabulate(start,finish,step));
        fillTable();
        writeAll();
    }

    public void fillTable() {

        List<PointDTO> list = points.stream().map(p -> new PointDTO(p.getX(), p.getY())).toList();
        table.setItems(FXCollections.observableList(list));
    }
}