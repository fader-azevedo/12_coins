/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 *
 * @author Fader Azevedo and Helio Sambo
 */
public class Transaction {

    public Transaction() {
    }
    
     public static void setNode(Node node,AnchorPane visual) {//metodo que faz a troca de paineis com animacao
        visual.getChildren().clear();
        visual.getChildren().add((Node) node);
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }
     
      public static void fadeTransition(AnchorPane visual,Node node) {//metodo que faz a troca de paineis com animacao
        visual.getChildren().clear();
        visual.getChildren().add((Node) node);
        FadeTransition ft = new FadeTransition(Duration.millis(1000));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }
    
    public static void fadeTransittion(Node node) {//metodo que faz a troca de paineis com animacao
        
        FadeTransition ft = new FadeTransition(Duration.seconds(3));
        ft.setNode(node);
        ft.setToValue(.2);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }
     
      public static void translateTransition(Node node,int x,int y) {//metodo que faz a troca de paineis com animacao
         
          TranslateTransition transition = new TranslateTransition();
          transition.setDuration(Duration.seconds(1));
          transition.setNode(node);
          transition.setToY(y);
          transition.setToX(x);
          transition.setAutoReverse(false);
          transition.setCycleCount(1);  
          transition.play();
    }
      
      public static void rotationTransition(Node node, int angle) {//metodo que faz a troca de paineis com animacao
        double ang =node.getRotate();
        double angI=0;
     
        if(ang < 0){
         angI=ang;
         ang=2*angle;
        }else if(ang > 0) 
          angI=ang;
        else if(ang > 0)
          angI=ang;
  
        
          RotateTransition rTransition = new RotateTransition();
          rTransition.setDuration(Duration.seconds(1));
          rTransition.setNode(node);
          rTransition.setFromAngle(angI);
          rTransition.setToAngle(angle);
          rTransition.setAutoReverse(false);
          rTransition.setCycleCount(1);
          rTransition.play();
    }
      
        public static void scaleTransition(Node node) {//metodo que faz a troca de paineis com animacao
          ScaleTransition rTransition = new ScaleTransition();
          rTransition.setDuration(Duration.seconds(.2));
          rTransition.setNode(node);
          rTransition.setToX(1.2);
          rTransition.setToY(1.2);
          rTransition.setAutoReverse(true);
          rTransition.setCycleCount(2);
        
          rTransition.play();
    }
}
