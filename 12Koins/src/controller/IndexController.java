/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import model.Transaction;


public class IndexController implements Initializable {
    @FXML
    private Rectangle balanca;
    @FXML
    private Pane pesagem;
    private Ellipse arc1, arc2;
    private Path quadr1, quadr2;
    @FXML
    private Label lbMessage;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
//        arc1 = new Arc(285, 364, 50, 50, 0, -180);
        arc1 = new Ellipse();
        arc1.setFill(Color.WHITE);
        arc1.setStroke(Color.BROWN);
//        arc1.setType(ArcType.CHORD);
        arc1.setRadiusX(50);
        arc1.setRadiusY(15);
        arc1.setCenterX(285);
        arc1.setCenterY(364);

//        arc2 = new Arc(660, 364, 50, 50, 0, -180);
        arc2 = new Ellipse();
        arc2.setFill(Color.WHITE);
        arc2.setStroke(Color.BROWN);
        arc2.setRadiusX(50);
        arc2.setRadiusY(15);
        arc2.setCenterX(660);
        arc2.setCenterY(364);
//        arc2.setType(ArcType.CHORD);

        quadr1 = new Path(new MoveTo(235, 364), new LineTo(285, 235), new LineTo(335, 364));
        quadr1.setStrokeWidth(1.3);
        quadr1.setStroke(Color.BROWN);

        quadr2 = new Path(new MoveTo(610, 364), new LineTo(660, 235), new LineTo(710, 364));
        quadr2.setStrokeWidth(1.3);
        quadr2.setStroke(Color.BROWN);
        
        pesagem.getChildren().add(arc1);
        pesagem.getChildren().add(arc2);
        pesagem.getChildren().add(quadr1);
        pesagem.getChildren().add(quadr2);
    }


    @FXML
    private void resetBalance() {
        System.err.println("Reset");
        lbMessage.setText("");
        Transaction.rotationTransition(balanca, 0);
        Transaction.translateTransition(quadr1, 0, 0);
        Transaction.translateTransition(arc1, 0, 0);
        Transaction.translateTransition(quadr2, 0, 0);
        Transaction.translateTransition(arc2, 0, 0);
    }

    @FXML
    public void close() {
        System.exit(0);
    }

    @FXML
    public void setBalance(){
        Balance balance = new Balance();
        int groupA = balance.getGroupA();
        int groupB = balance.getGroupB();

        lbMessage.setText(balance.answer());

        if (groupA > groupB) {
            Transaction.rotationTransition(balanca, -15);
            Transaction.translateTransition(quadr1, 10, 50);
            Transaction.translateTransition(arc1, 10, 50);
            Transaction.translateTransition(quadr2, -10, -50);
            Transaction.translateTransition(arc2, -10, -50);

        } else if (groupA == groupB) {
            Transaction.rotationTransition(balanca, 0);
            Transaction.translateTransition(quadr1, 0, 0);
            Transaction.translateTransition(arc1, 0, 0);
            Transaction.translateTransition(quadr2, 0, 0);
            Transaction.translateTransition(arc2, 0, 0);
        }else{
            Transaction.rotationTransition(balanca, 15);
            Transaction.translateTransition(quadr2, -10, 50);
            Transaction.translateTransition(arc2, -10, 50);
            Transaction.translateTransition(quadr1, 10, -50);
            Transaction.translateTransition(arc1, 10, -50);
        }
    }
}