/**
Stefan Quintana 191630
Estuardo Menendez 18072
Lucia Guzman 20262
Proyecto Estructuras de Datos
Interprete Lisp
* */
import java.util.ArrayList;
import java.util.Stack;


public class Interprete {

    private char[] operacion;
    private char[] operacionInterna;
    private String operandoInicial = "";
    private String subOperaciones = "";

    /**
     * @param operacion
     * Le va aingresar un String que va a ser la operacion
     */
    public void operacionesAritmeticas(String operacion){
        this.operacion = dividirCaracteres(operacion);
        operandoInicial = Character.toString(this.operacion[1]);

        for (int i = 2; i < this.operacion.length; i++) {
            if(this.operacion[i] == '('){
                while (this.operacion[i] != ')'){
                    subOperaciones += Character.toString(this.operacion[i]);
                    i++;
                }

                if(this.operacion[i] == ')'){
                    subOperaciones+=")"; //Fix sub operations when there's sub sub n sub operations (Operands)
                }

            }
        }
        Integer result = subOperaciones(subOperaciones); //Arreglar esto
        Integer number = Integer.parseInt(Character.toString(this.operacion[operacion.length()-2])); //arreglar esto

        if(operandoInicial.equals("+")){
            result += number;
        }else if(operandoInicial.equals("-")){
            result -= number;
        }else if(operandoInicial.equals("*")){
            result *= number;
        }else if(operandoInicial.equals("/")){
            result /= number;
        }
        System.out.println(result);
    }

    /**
     * @param subOperacion
     * Le va a entrar una subOperacions
     * @return
     * Retornar el resultado de la sub
     */
    public Integer subOperaciones(String subOperacion){
        String operador = "";
        ArrayList<Integer> digitos  = new ArrayList<>();
        String number1 = "";
        String number2 = "";
        String tempResult = "";
        Integer result = 0;

        System.out.println(subOperacion);
        operacionInterna = subOperacion.toCharArray();
        operador = Character.toString(operacionInterna[1]);

        for (int i = 0; i <this.operacionInterna.length ; i++) {
            if(Character.isDigit(operacionInterna[i])){
                digitos.add(Integer.parseInt(Character.toString(operacionInterna[i])));
            }
        }

        int counter = digitos.size();
        for (int i = 0; i < counter; i++) {
            try{
                number1 = digitos.remove(0).toString();
                number2 = digitos.remove(0).toString();
            }catch (Exception e){
                switch (operador){
                    case "+":  result += Integer.parseInt(number1);break;
                    case "-":  result -= Integer.parseInt(number1);break;
                    case "*":  result *= Integer.parseInt(number1);break;
                    case "/":  result /= Integer.parseInt(number1);break;
                }
                break;
            }

            if(operador.equals("+")){
                result += Integer.parseInt(number1) + Integer.parseInt(number2);
            }else if(operador.equals("-")){
                result += Integer.parseInt(number1) - Integer.parseInt(number2);
            }else if(operador.equals("*")){
                result += Integer.parseInt(number1) * Integer.parseInt(number2);
            }else if(operador.equals("/")){
                result += Integer.parseInt(number1) / Integer.parseInt(number2);
            }


            tempResult = result.toString();

        }


        return result;

    }


    /**
     * @param operacion
     * Separar cada operacion
     * @return
     * va a retornar los caracteres separadis
     */
    private char[] dividirCaracteres(String operacion){
        char[] caracteres_Expresion;
        int[] contadorParentesis = new int[2];
        caracteres_Expresion = new char[operacion.length()];
        caracteres_Expresion = operacion.toCharArray();

        for (int i = 0; i < caracteres_Expresion.length ; i++) {
            if(caracteres_Expresion[i] == '('){
                contadorParentesis[0] += 1;
            }
            else if(caracteres_Expresion[i] == ')'){
                contadorParentesis[1] += 1;
            }
        }

        return  caracteres_Expresion;
    }

    /**
     * @param comparado1
     * primer parametros String
     * @param comparado2
     * Segundo parametro String
     * @return
     * va a returnar true si son iguales o false si no
     */
    private boolean equals(String comparado1, String comparado2){
        return comparado1.equals(comparado2);
    }
}


