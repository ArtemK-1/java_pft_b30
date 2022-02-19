package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests {

    @Test
    public void Test0(){
        Equation e = new Equation(1,1,1);
        Assert.assertEquals(e.rootNumber(),0);
    }

    @Test
    public void Test1(){
        Equation e = new Equation(1,2,1);
        Assert.assertEquals(e.rootNumber(),1);
    }

    @Test
    public void Test2(){
        Equation e = new Equation(1,5,6);
        Assert.assertEquals(e.rootNumber(),2);
    }

    @Test
    public void TestLinear(){
        Equation e = new Equation(0,1,1);
        Assert.assertEquals(e.rootNumber(),1);
    }

    @Test
    public void TestConstant(){
        Equation e = new Equation(0,0,1);
        Assert.assertEquals(e.rootNumber(),0);
    }

    @Test
    public void TestZero(){
        Equation e = new Equation(0,0,0);
        Assert.assertEquals(e.rootNumber(),-1);
    }
}