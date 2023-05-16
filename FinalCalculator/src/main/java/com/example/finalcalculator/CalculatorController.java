package com.example.finalcalculator;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;


public class CalculatorController implements Initializable {

    private static List<String> operations;
    private boolean isOperator;

    @FXML
    public TextField output;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        operations = new ArrayList();
    }

    @FXML
    public void numZero(ActionEvent event){
        operations.add("0");
        updateOutput();
        isOperator = false;
    }

    @FXML
    public void numOne(ActionEvent event){
        operations.add("1");
        updateOutput();
        isOperator = false;
    }

    @FXML
    public void numTwo(ActionEvent event){
        operations.add("2");
        updateOutput();
        isOperator = false;
    }

    @FXML
    public void numThree(ActionEvent event){
        operations.add("3");
        updateOutput();
        isOperator = false;
    }

    @FXML
    public void numFour(ActionEvent event){
        operations.add("4");
        updateOutput();
        isOperator = false;
    }

    @FXML
    public void numFive(ActionEvent event){
        operations.add("5");
        updateOutput();
        isOperator = false;
    }

    @FXML
    public void numSix(ActionEvent event){
        operations.add("6");
        updateOutput();
        isOperator = false;
    }

    @FXML
    public void numSeven(ActionEvent event){
        operations.add("7");
        updateOutput();
        isOperator = false;
    }

    @FXML
    public void numEight(ActionEvent event){
        operations.add("8");
        updateOutput();
        isOperator = false;
    }

    @FXML
    public void numNine(ActionEvent event){
        operations.add("9");
        updateOutput();
        isOperator = false;
    }

    @FXML
    public void charDot(ActionEvent event){
        operations.add(".");
        updateOutput();
        isOperator = true;
    }


    @FXML
    public void funcPlus(ActionEvent event){
        if(!isOperator) operations.add("?+?");
        else operations.set(operations.size()-1, "?+?");
        updateOutput();
        isOperator = true;
    }

    @FXML
    public void funcEqual(ActionEvent event){
        String operationsString = "";
        for(String e : operations){
            operationsString = operationsString + e;
        }

        String[] elements = operationsString.split("\\?");
        List<String> elementsList = new ArrayList();
        for(String e : elements){
            elementsList.add(e);
        }
        double num1 = 0.0;
        double num2;

        boolean added = true;
        while(added){
            added = false;
            for(int i = 0; i < elementsList.size(); i++){
                if(i%2 != 0 && elementsList.get(i).equals("*") || elementsList.get(i).equals("/")){
                    num1 = Double.parseDouble(elementsList.get(i-1));
                    num2 = Double.parseDouble(elementsList.get(i+1));
                    num1 = doOperations(elementsList.get(i), num1, num2);
                    elementsList.set(i+1, num1 + "");
                    elementsList.remove(i);
                    elementsList.remove(i-1);
                    added = true;
                }
            }
        }

        added = true;
        while(added){
            added = false;
            for(int i = 0; i < elementsList.size(); i++){
                if(i%2 != 0){
                    num1 = Double.parseDouble(elementsList.get(i-1));
                    num2 = Double.parseDouble(elementsList.get(i+1));
                    num1 = doOperations(elementsList.get(i), num1, num2);
                    elementsList.set(i+1, num1 + "");
                    elementsList.remove(i);
                    elementsList.remove(i-1);
                    added = true;
                }
            }
        }

        operations.add("?=" + num1);
        updateOutput();

    }

    @FXML
    public void funcMinus(ActionEvent event){
        if(!isOperator) operations.add("?-?");
        else operations.set(operations.size()-1, "?-?");
        updateOutput();
        isOperator = true;
    }

    @FXML
    public void funcMulti(ActionEvent event){
        if(!isOperator) operations.add("?*?");
        else operations.set(operations.size()-1, "?*?");
        updateOutput();
        isOperator = true;
    }

    @FXML
    public void funcDiv(ActionEvent event){
        if(!isOperator) operations.add("?/?");
        else operations.set(operations.size()-1, "?/?");
        updateOutput();
        isOperator = true;
    }

    @FXML
    public void funcRoot(ActionEvent event){
        if(!isOperator){
            operations.add(Math.sqrt(Double.parseDouble(operations.get(operations.size()-1))) + "");
            operations.remove(operations.size()-2);
            updateOutput();
        }

    }


    @FXML
    public  void funcRemoveLine(ActionEvent event){
        operations = new ArrayList<>();
        output.clear();

    }

    private void updateOutput(){
        String toPrint = "";
        for(String e : operations){
            if(e.startsWith("?")){
                e = e.replace("?", "");
            }
            toPrint = toPrint + e;
        }
        output.setText(toPrint);
    }

    private double doOperations(String operator, double num1, double num2){
        switch (operator){
            case "+": return num1 + num2;
            case "*": return num1 * num2;
            case "/": return num1 / num2;
            case "-": return num1 - num2;
            default: return 0.0;
        }
    }
}
