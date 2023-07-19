package com.example.calculator.service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService{

    @Override
    public String calculate(String expression) {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = engineManager.getEngineByName("JavaScript");
        String resultStr = "";
        try {
            Object result = scriptEngine.eval(expression);
            resultStr = result.toString();
        } catch (ScriptException e) {
            e.printStackTrace();
            resultStr = "Error";
        }
        return resultStr;
    }
}
