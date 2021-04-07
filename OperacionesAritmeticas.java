/**
Stefan Quintana 191630
Estuardo Menendez 18072
Lucia Guzman 20262
Proyecto Estructuras de Datos
Interprete Lisp
* */
import java.util.*;

//Referencia de la idea: http://norvig.com/lispy.html
public class OperacionesAritmeticas {

    private LinkedList<String> definiciones = new LinkedList<>();
    private Stack<String> subDefiniciones = new Stack<>();
    private char[] parser;
    private int contador;
    private String numeroVariosDigitos = "";
    private double resultado = 0.0;
    private boolean isDecimal;

    public OperacionesAritmeticas(String procedimiento){
        parser = procedimiento.toCharArray();
        contador = 0;
        hacerOperacionesAritmeticas();
    }
    private void hacerOperacionesAritmeticas() { //Metodo que realiza una operacion aritmetica dentro de un parentesis
        this.isDecimal = false;
        switch (parser[contador]){//va  a ir cambiando el contador y se va a ir con el switch viendo que tipo de operacion es

            case '+': definiciones.addFirst("+"); contador++; break;
            case '-': definiciones.addFirst("-"); contador++;break;
            case '*': definiciones.addFirst("*"); contador++;break;
            case '/': definiciones.addFirst("/"); contador++;break;
            case ')': try{ resultadoRecursivo();}catch (Exception e){} contador++; break;
            default: if(Character.isDigit(parser[contador])) {
                try {
                    if(parser[contador + 1] == '.'){
                        numeroVariosDigitos += Character.toString(parser[contador])  + Character.toString(parser[contador +1])
                                + Character.toString(parser[contador + 2]);
                        contador+=3;
                        isDecimal = true;
                        definiciones.addFirst(numeroVariosDigitos);
                        break;
                    }
                    if (Character.isDigit(parser[contador + 2]) && parser[contador + 1] != ' ') {// Si es un digito lo va a separar y se le va agregando a la posicion contador +1
                        numeroVariosDigitos = Character.toString(parser[contador]) + Character.toString(parser[contador + 1]) + Character.toString(parser[contador + 2]);
                        contador += 3;
                        definiciones.addFirst(numeroVariosDigitos); //Se va agregando el numero a nuestra LinkedList
                        break;
                    } }catch (Exception e){}if (Character.isDigit(parser[contador + 1]) && isDecimal == false) {
                    numeroVariosDigitos = Character.toString(parser[contador]) + Character.toString(parser[contador + 1]);// Verifica si es un numero de 2 digitos
                    contador++; //contador++
                    break;
                }
                else {
                    definiciones.addFirst(Character.toString(parser[contador])); //Se convierte de caracter a String y se apregar al parser en la poscion contador
                    contador++;
                }

                break; //Break

            }else{
                contador++;
            }
        }


        if(contador == parser.length){
            System.out.println(resultado);
            return; //Cuando el contador sea = al larfgo de nuestro parser, que es un array se va a printear
        }else{
            hacerOperacionesAritmeticas(); // si no se cumple, se va a operar la operacion
        }
    }

    /**
     * Recursividad en operar y encontrar el resultado de las operaciones
     */
    private void resultadoRecursivo(){
        if(!definiciones.peekFirst().equals("+") && !definiciones.peekFirst().equals("-") && !definiciones.peekFirst().equals("*")
                && !definiciones.peekFirst().equals("/")){
            subDefiniciones.push(definiciones.removeFirst());
            resultadoRecursivo();
        }else{
            resultado = Float.parseFloat(subDefiniciones.pop());
            subResultado();

            definiciones.remove(0);
            definiciones.addFirst(String.valueOf(resultado)); //6

            return;
        }

    }

    /**
     * Metodo para obtener el resultado de las subOperaciones
     */
    private void subResultado(){
        if(subDefiniciones.size() > 0){
            if(definiciones.get(0).equals("+")){
                resultado += Float.parseFloat(subDefiniciones.pop());
            }else if(definiciones.get(0).equals("-")){
                resultado -= Float.parseFloat(subDefiniciones.pop());
            }else if(definiciones.get(0).equals("*")){
                resultado *= Float.parseFloat(subDefiniciones.pop());
            }else if(definiciones.get(0).equals("/")){
                resultado /= Float.parseFloat(subDefiniciones.pop());
            }
            subResultado();
        }else{
            return;
        }



    }
}

