/**
Stefan Quintana 191630
Estuardo Menendez 18072
Lucia Guzman 20262
Proyecto Estructuras de Datos
Interprete Lisp
* */
import java.util.LinkedList;

/**
 * @author user
 * @param <E>
 *     Genericos
 */
public class Predicados<E extends Comparable<Integer> > {

    LinkedList<String> listas = new LinkedList<>(); //Linked List para mis predicados


    /**
     *Se agregan a la lista lo siguiente
     */
    public Predicados(){
        listas.add("(list"); //Se agregan los Strings con el parentesis
        listas.add("(cons");
        listas.add("'(");
    }

    /**
     * @param valorA
     * Primer parametro para comparar
     * @param valorB
     * Segundo parametro para comparar
     * @return
     * Verdadero si es igual y falso si no lo es
     */
    //Metodo para hacer equals. El mas facil JAJA
    public boolean equals(E valorA, E valorB){ //Tenemos 2 genericos y si son iguales regresa true, sino false
        return  valorA.equals(valorB);
    }

    /**
     * @param valorA
     * Primer parametro para comparar
     * @param valorB
     * Segundo parametro para comparar
     * @return
     * Verdadero si es mayor A que B y falso si no lo es
     */
    //Metodo mayor que. Funciona solo con numeros (ints) devuelve true o false
    public Boolean mayorMenor(int valorA, int valorB ){
        if(valorA > valorB){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @param valorA
     * Primer parametro para comparar
     * @param valorB
     * Segundo parametro para comparar
     * @return
     * Verdadero si es menor A que B y falso si no lo es
     */
    //Metodo menor que. Funciona con numeros (ints) devuelve true o false
    public Boolean menorMayor(int valorA, int valorB ){
        if(valorA < valorB){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @param valor
     * String a procesar
     * @return
     * verdadero si es atom o falso si no
     */
    //Booleano para decirme si es atom o no
    public boolean atom(String valor){
        boolean esAtom = true; //Boolenado true
        //se separa el texto y se busca cuando se puso "Atom"
        String[] split= valor.split(" ");
        int i = 0;
        for(i=0; i <split.length ; i++) {
        	if(split[i].contains("Atom")) {
        		i=i+1;
        		break;
        	}
        	
        }
        //Se borran los parentesis del lado derecho (en caso de que se hayan separado por espacios)
        int j=0;
        if(split[split.length-1].equals("))")) {
        	j=j+1; 
        	
        }
        //Se borran los parentesis de la izquierda(en caso de que se hayan separado por espacios)
        if(split[i].equals("(")) {
        	j=j+1; 
        	
        }
        // se revisa si el largo es el indicado
        if((split.length-i-j)>1) {
        	
        	esAtom=false;
        }
        return esAtom;//De lo contrario se regresa el booleano original
    }

    /**
     * @param valor
     * String a procesar
     * @return
     * Verdadero o Falso si es Atom
     */
    //Si no es atom, debe ser lista. Se usa algo similar a atom
    public  boolean lista(String valor){
        boolean esLista = false;
        String[] split= valor.split(" ");
        int i = 0;
        for(i=0; i <split.length ; i++) {
        	if(split[i].contains("List")) {
        		i=i+1;
        		break;
        	}
        	
        }
        //Se borran los parentesis del lado derecho (en caso de que se hayan separado por espacios)
        int j=0;
        if(split[split.length-1].equals("))")) {
        	j=j+1; 
        	
        }
        //Se borran los parentesis de la izquierda(en caso de que se hayan separado por espacios)
        if(split[i].equals("(")) {
        	j=j+1; 
        	
        }
        // se revisa si el largo es el indicado
        if((split.length-i-j)>1) {
        	
        	esLista=true;
        }
        return esLista; //De lo contrario se regresa el booleano original
    }
    /**
     * @param valor
     * String a procesar
     * @return
     * String que se ingreso en quote
     */
    //Se separa y se busca el utlimo parentesis para eliminarlo 
    public String quote(String value) {
    	String[] split= value.split(" ");
        int i = 0;
        for(i=0; i <split.length-1; i++) {
        	if(split[i].contains("Quote")) {
        		i=i+1;
        		break;
        	}
        }
        if (split[split.length -1].contains("))")) {
        	split[split.length -1]=split[split.length -1].replace("))", "");
        }
        String res="";
        for(int j =i ; j<=split.length-1; j++) {
        	res=res+" "+split[j];
        }
    	return res; 
    }


}
