package edu.eci.cvds.calculadora;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "calculadoraBean")
@SessionScoped
public class calc {

    private ArrayList<Double> numeros = new ArrayList<>();
    private ArrayList<ArrayList<Double>> ingresados = new ArrayList<>();
    private double media = 0;
    private double moda = 0;
    private double dEstandar = 0;
    private double varianza = 0;

    public calc(){}

    public double getMedia() {
        return media;
    }

    public double getModa() {
        return moda;
    }

    public double getdEstandar() {
        return dEstandar;
    }

    public double getVarianza() {
        return varianza;
    }

    public ArrayList<ArrayList<Double>> getIngresados(){
        return ingresados;
    }

    public void setNumeros(ArrayList<Double> numeros) {
        this.numeros = numeros;
    }

    public double calculateMean(ArrayList<Double> numeros){
        double res = 0;
        for(int i=0; i< numeros.size(); i++){
            res += numeros.get(i);
        }
        media =  res/numeros.size();
        return media;
    }

    public double calculateStandardDeviation(ArrayList<Double> numeros){
        calculateVariance(numeros);
        dEstandar = Math.sqrt(varianza);
        return dEstandar;
    }

    public double calculateVariance(ArrayList<Double> numeros){
        calculateMean(numeros);
        double sumatoria = 0;
        for(int i=0; i< numeros.size(); i++){
            sumatoria += Math.pow((numeros.get(i)-media),2);
        }
        varianza = sumatoria/(numeros.size()-1);
        return varianza;
    }

    public double calculateMode(ArrayList<Double> numeros){
        int mayor_repeticiones = 0;
        for(int i=0; i< numeros.size(); i++){
            int repeticiones_numi=0;
            for (int j=0; j<numeros.size();j++){
                if(numeros.get(i)==numeros.get(j)){
                    repeticiones_numi += 1;
                }
            }
            if(repeticiones_numi >= mayor_repeticiones){
                mayor_repeticiones = repeticiones_numi;
                moda = numeros.get(i);
            }
        }
        return moda;
    }

     public void restart(){
        numeros.clear();
        ingresados.clear();
        media = 0;
        moda = 0;
        dEstandar = 0;
        varianza = 0;

     }

     public void calcular(String nums){
        ingresados.add((ArrayList<Double>) numeros.clone());
        numeros.clear();

        String[] numeros_temp = nums.split(";");
        for(String s: numeros_temp){
            numeros.add(Double.parseDouble(s));
        }
        calculateMode(numeros);
        calculateStandardDeviation(numeros);

     }



}