/*
 * Moda.java
 *
 * Created on 17 de Novembro de 2006, 17:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.teoni.fpreader.math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Teoni
 */
public class Moda {
    
    private Map valores = new HashMap();
   
    public Moda() {}
   
    public void adicionar(int numero) {
       
        Integer n = new Integer(numero);
       
        /** Verifica se j� existe esse elemento no mapa */
        if (valores.get(n) != null) {
            valores.put(n, new Integer(((Integer)valores.get(n)).intValue() + 1));
        }
        else {
            valores.put(n, new Integer(1));
        }
    }
   
    public Map getValores() {
        return valores;
    }
   
    public Integer calcular() {
       
        /** Maior valor encontrado at� o momento */
        Integer maior = null;
       
        Set resultado = new HashSet();
       
        Iterator iterator = valores.keySet().iterator();
        while (iterator.hasNext()) {
           
            /** N�mero atual sendo avaliado */
            Integer valor = (Integer)iterator.next();
           
            /** Quantidade de ocorr�ncias do n�mero atual */
            Integer current = (Integer)valores.get(valor);
           
            if (maior == null) {
                maior = current;
            }
           
            /** Encontrou um n�mero com mais ocorr�ncias */
            if (maior.compareTo(current) <= 0) {
                maior = current;
                resultado.add(valor);
            }
        }
       
        iterator = resultado.iterator();
       
        while (iterator.hasNext()) {
           
            Integer numero = (Integer)iterator.next();

            /**
             * N�o tem o mesmo n�mero de ocorr�ncias que o maior n�mero de
             * ocorr�ncias encontrado?
             */
            if (((Integer)valores.get(numero)).compareTo(maior) < 0) {
                iterator.remove(); // J� era!
            }
        }
       
        return maior;
    }
    
}
