/**
Stefan Quintana 191630
Estuardo Menendez 18072
Lucia Guzman 20262
Proyecto Estructuras de Datos
Interprete Lisp
* */
//https://www.javatpoint.com/substring
public class Condicionales {

    String operaciones;
    Predicados p = new Predicados();
    String operador = "";

    /**
     * @param o
     */
    public Condicionales(String o){
        evaluarCondicionales(o);
    }

    /**
     * Tiene que entrar un String
     * @param o
     */
    //Desde la posicion inicial hasta que encuentre un espacio en blanco
    public void evaluarCondicionales(String o) {
        operaciones  = o.substring(1, o.indexOf(" ")); // This method returns new String object containing the substring of the given string from specified startIndex (inclusive).
        o = o.substring( o.indexOf(" ") + 1);//Quitar el espacio y empezar en operar. Esto lo recorta
        operaciones = o.substring(1, o.indexOf(")")); // This method returns new String object containing the substring of the given string from specified startIndex (inclusive).
        String a = ""; //dato para comparar
        String b = ""; //dato para comparar
        String operacion = "";
        String[] operandos =operaciones.split(" "); //Se van a guardar los operandos spliteados
        String operando = "";

        //Va a agregar operandos. y comparar 2 nums. Si encuentra un parentesis, va a seguir, si encuentra unn
        for (int i = 0; i <  operandos.length; i++) {
            if(!operandos[i].equals("")){
                if(Character.isDigit(operandos[i].charAt(0))){ //
                    if(a.equals("")){
                        a = Character.toString(operandos[i].charAt(0));
                    }else{
                        b = Character.toString(operandos[i].charAt(0));
                    }
                }
            }

        }
        for (int i = 0; i < operaciones.length(); i++) {

            //  En estas opciones se utilizan los metodos de nuestro predica. Lo de mayor, menor, atom, equal
            if(operaciones.contains(">")){
                System.out.println(p.mayorMenor((Integer.parseInt(a)),Integer.parseInt(b)));
                break;
            }

            if(operaciones.contains("<")){
                System.out.println(p.menorMayor((Integer.parseInt(a)),Integer.parseInt(b)));
                break;
            }

            if(operaciones.contains("=")){
                System.out.println(p.equals((Integer.parseInt(a)),Integer.parseInt(b)));
                break;
            }

            if(operaciones.contains("Equal")){
                System.out.println(p.equals((Integer.parseInt(a)),Integer.parseInt(b)));
                break;
            }

            if(operaciones.contains("Atom")){
                System.out.println(p.atom(o));
                break;
            }

            if(operaciones.contains("List")){
                System.out.println(p.lista(o));
                break;
            }
            if(operaciones.contains("Quote")){
                System.out.println(p.quote(o));
                break;
            }
            if(operaciones.contains("Setq")){
                System.out.println(p.quote(o));
                break;
            }

        }
    }
}
