package org.example.util;

import org.example.model.Stack;
import org.example.model.StaticStack;

public class StackUtil {

    public static <T> Stack copy(Stack<T> stack) {
        Stack<T> aux = new StaticStack<>();
        Stack<T> aux2 = new StaticStack<>();

        while(!stack.isEmpty()) {
            aux.add(stack.getTop());
            aux2.add(stack.getTop());
            stack.remove();
        }

        while(!aux2.isEmpty()) {
            stack.add(aux2.getTop());
            aux2.remove();
        }

        while(!aux.isEmpty()) {
            aux2.add(aux.getTop());
            aux.remove();
        }

        return aux2;
    }

    public static <T> void print(Stack<T> stack) {
        Stack<T> copy = copy(stack);
        while(!copy.isEmpty()) {
            System.out.println(copy.getTop());
            copy.remove();
        }
    }


    public static <T> Stack<T> inverStack(Stack<T> stack) {

        Stack<T> aux = new StaticStack<>();


        // Transferir elementos de la pila original a la pila auxiliar
        while (!stack.isEmpty()) {
            aux.add(stack.getTop());
            stack.remove();
        }

        // Transferir los elementos de la pila auxiliar de vuelta a la pila original
   //     while (!aux.isEmpty()) {
   //         stack.add(aux.remove());
   //     }
        return aux;
    }
}
