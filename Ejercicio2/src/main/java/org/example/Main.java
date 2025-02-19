package org.example;


import org.example.model.Set;
import org.example.model.Stack;
import org.example.model.StaticSet;
import org.example.model.StaticStack;
import org.example.util.SetUtil;
import org.example.util.StackUtil;

public class Main {
    public static void main(String[] args) {

        //Desarrolle una función que reciba un Stack genérico e invierta sus elementos.
        Stack<Integer> stack = new StaticStack<>();

        stack.add(1);
        stack.add(2);
        stack.add(8);

        System.out.println("Stack original: ");
        StackUtil.print(stack);

        Stack<Integer> stackInver = StackUtil.inverStack(stack);

        System.out.println("Stack invertida: ");
        StackUtil.print(stackInver);

        //Desarrolle una función que copie un Set genérico.
        Set<Integer> setOri = new StaticSet<>();
        setOri.add(1);
        setOri.add(2);
        setOri.add(3);
        setOri.add(4);


        System.out.println("Set original: ");
        SetUtil.print(setOri);
        
        System.out.println("Set copia: ");
        Set<Integer> copiaSet = SetUtil.copy(setOri);

        SetUtil.print(copiaSet);

    }
}