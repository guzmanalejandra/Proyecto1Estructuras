/**
Stefan Quintana 191630
Estuardo Menendez 18072
Lucia Guzman 20262
Proyecto Estructuras de Datos
Interprete Lisp
* */
//(* 2 5)
//(Cond (< 3 2))
//(< 2 3)
//(Defun multi (a,b) (* a b))
//(multi 3 2)

import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        Analizador analizador = new Analizador();
        Condicionales condicionales;
        OperacionesAritmeticas operacionesAritmeticas;
        HashMap<String, Double> hashmap= new HashMap<String, Double>();
        

    while (true) {
        try {
                System.out.println("Si utilizará parametros para las funciones por favor  utilice ");
                System.out.println("letras en orden alfabetico en minuscula. Gracias");
                System.out.print("Lisp> ");
                String operacion = leer.nextLine();
                if (operacion.contains("Defun")) {
                    analizador.definirFunciones(operacion);
                } else if (operacion.contains("Cond")) {
                    condicionales = new Condicionales(operacion);
                } else if (operacion.contains("+") || operacion.contains("-") || operacion.contains("*") || operacion.contains("/")) {
                    operacionesAritmeticas = new OperacionesAritmeticas(operacion);
                } else if (operacion.contains("<") || operacion.contains(">") || operacion.contains("Atom") || operacion.contains("List") || operacion.contains("Equal")|| operacion.contains("Quote")) {
                    condicionales = new Condicionales("(Cond " + operacion + ")");
                } else if(operacion.contains("Setq")){
                	String res= operacion.substring(operacion.indexOf("Setq") +5, operacion.length()-1);
                	String[] split= res.split(" ");
                	hashmap.put(split[0], Double.parseDouble(split[1]));
                	System.out.println("Esta hecho ");
                } else {
                	Set<String> set= hashmap.keySet();
                	boolean cosito=false; 
                	for(String  element: set) {
                		if (operacion.contains(element)) {
                			cosito=true;
                			;
                		}
                	if(cosito) {
                		for(String  elements: set) {
                    		if (operacion.contains(elements)) {
                    			System.out.println(String.valueOf(hashmap.get(elements)));
                    			;
                    		}
                	}
                	}else {
                		 analizador.realizarFunciones(operacion);
                	}
                	}

                }

        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    }
}