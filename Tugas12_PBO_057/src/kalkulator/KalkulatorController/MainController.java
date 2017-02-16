/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator.KalkulatorController;

import com.sun.javafx.scene.control.skin.LabeledText;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.xml.bind.ParseConversionEvent;

/**
 *
 * @author Jayuk
 */
public class MainController 
{
    double temp1=0;
    double temp2=0;
    @FXML
    private TextField resultText;
    
    @FXML
    public void buttonReset(ActionEvent event)
    {
        resultText.setText("");
    }
    @FXML
    public void buttonClose(ActionEvent event)
    {
        System.exit(0);
    }
    @FXML
    public void buttonProgramer(ActionEvent event)
    {
        resultText.setText("Not Available");
    }
    @FXML
    public void buttonStandard(ActionEvent event)
    {
        resultText.setText("Standard Selected ...");
    }
    @FXML
    public void buttonScientific(ActionEvent event)
    {
        resultText.setText("Not Available");
    }
    @FXML
    public void buttonHelp(ActionEvent event)
    {
        resultText.setText("Nothing to do here : )");
    }
    @FXML
    public void buttonClear(ActionEvent event)
    {
        resultText.setText("");
        temp1=0;
        temp2=0;
    }
    
    @FXML
    public void buttonBackSpace(ActionEvent event)
    {
        resultText.setText(resultText.getText().substring(0, resultText.getLength()-1));
    }
    
    @FXML
    public void  buttonOne(ActionEvent event)
    {
        resultText.setText(resultText.getText()+1);
    }
    @FXML
    public void buttonTwo(ActionEvent event)
    {
        resultText.setText(resultText.getText()+2);
    }
    @FXML
    public void buttonSeven(ActionEvent event)
    {
        resultText.setText(resultText.getText()+7);
    }
    @FXML
    public void buttonFour(ActionEvent event)
    {
        resultText.setText(resultText.getText()+4);
    }
    @FXML
    public void buttonFive(ActionEvent event)
    {
        resultText.setText(resultText.getText()+5);
    }
    @FXML
    public void buttonSix(ActionEvent event)
    {
        resultText.setText(resultText.getText()+6);
    }
    @FXML
    public void buttonThree(ActionEvent event)
    {
        resultText.setText(resultText.getText()+3);
    }
    @FXML
    public void buttonEight(ActionEvent event)
    {
        resultText.setText(resultText.getText()+8);
    }
    @FXML
    public void buttonNine(ActionEvent event)
    {
        resultText.setText(resultText.getText()+9);
    }
    @FXML
    public void buttonZero(ActionEvent event)
    {
        resultText.setText(resultText.getText()+0);
    }
    @FXML
     public void buttonDiv(ActionEvent event)
    {
        resultText.setText(resultText.getText()+"/");
    }
    @FXML
     public void buttonSqrt(ActionEvent event)
    {
        resultText.setText(""+Math.sqrt(hasil()));
    }
    @FXML
     public void buttonMultiply(ActionEvent event)
    {
        resultText.setText(resultText.getText()+"X");
    }
    @FXML
     public void buttonMod(ActionEvent event)
    {
        resultText.setText(resultText.getText()+0);
    }
    @FXML
    public void  buttonSubstract(ActionEvent event)
    {
        resultText.setText(resultText.getText()+"-");
    }
    @FXML
    public void buttonOneDiv(ActionEvent event)
    {
        resultText.setText(""+(1/hasil()));
    }
    @FXML
    public void buttonAdder(ActionEvent event)
    {
        resultText.setText(resultText.getText()+"+");
    }
    @FXML
    public void  buttonResult(ActionEvent event)
    {
        resultText.setText(""+hasil());
    }
    @FXML
    public double hasil()
    {
        double temporaly = 0;
        double resultTemp = 0;
        int flagsDiv=0,flagsPlus=0;
        int flags=0;
        String temp="1+" + resultText.getText();        
        for(int i=temp.length()-1;i>=0;i--)
        {
            int k=0;
            if(Character.isDigit(temp.charAt(i)))
            {
                temporaly += (double) pangkat(((double)temp.charAt(i)-'0'),flags);
                flags++;
            }
            else
            {
                
                if(temp.charAt(i)=='x'||temp.charAt(i)=='X')/*
                    if(tempNum[0]==0)
                        resultTemp = tempNum[0];
                    else*/
                    {
                        if(flagsPlus==0)
                            resultTemp = temporaly;
                        else
                            resultTemp = resultTemp * temporaly;
                        flagsDiv++;
                        //k++;
                    }
                else if(temp.charAt(i)=='+')/*
                    if(tempNum[0]==0)
                        resultTemp += tempNum[0];
                    else*/
                    {
                        resultTemp += temporaly;
                        //k++;
                        flagsDiv++;
                        flagsPlus++;
                    }
                else if(temp.charAt(i)=='-')/*
                    if(tempNum[0]==0)
                        resultTemp = tempNum[0];
                    else*/
                    {
                        resultTemp -= temporaly;
                        //k++;
                        flagsDiv++;
                        flagsPlus++;
                    }
                else if(temp.charAt(i)=='/')/*
                    if(tempNum[0]==0)
                        resultTemp += tempNum[0];
                    else*/
                    {
                        if(flagsDiv==0)
                            resultTemp = 0;
                        else
                            resultTemp = (resultTemp / temporaly);
                        //k++;
                        flagsPlus++;
                    }
                flags=0;
                temporaly=0;
            }
        }
        resultText.setText(""+resultTemp);
        return resultTemp;
    }
    
    public static double pangkat(double a, int b)
    {
        if(b==0)
        {
            if(a==0)
                return 0;
            else
                return a * 1;
        }
        else if(b==1)
        {
            if(a==0)
                return 0;
            else
                return a * 10;
        }
        else if(b==2)
        {
            if(a==0)
                return 0;
            else
                return a * 100;
        }
        else if(b==3)
        {
            if(a==0)
                return 0;
            else
                return a * 1000;
        }
        else if(b==4)
        {
            if(a==0)
                return 0;
            else
                return a* 10000;
        }
        else 
            return 100;
    }
}
