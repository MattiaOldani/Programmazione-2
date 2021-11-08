package PolySparse;

import java.util.List;
import java.util.ArrayList;

/*
 * Gli oggetti di questa classe rappresentano polinomi sparsi
 * Gli oggetti di questa classe sono immutabili
 */
public class PolySparse {
    /*
     * Questo record rappresenta un termine del polinomio
     * Viene rappresentato come una coppia (coefficiente, esponente)
     */
    private record Term(int coeff, int degree) {
        public Term {
            if (degree < 0)
                throw new NegativeDegreeException("Il grado deve essere non negativo");
        }
    }

    // ATTRIBUTI    
    /*
     * I termini del polimonio
     * ((1,2), (3,4)) --> x^2 + 3x^4
     * I termini del polinomio sono ordinati in modo crescente in base al grado
     */
    List<Term> term;

    // COSTRUTTORI
    /*
     * Costruisce il polinomio zero
     */
    public PolySparse() {
        term = new ArrayList<>();
    }

    /*
     * Costruisce il polinomio coeff * x ^ degree
     */
    public PolySparse(int coeff, int degree) {
        this();
        term.add(new Term(coeff, degree));
    }

    // METODI
    /*
     * POST-CONDIZIONI: restituisce il grado del polinomio
     */
    int degree() {
        if (term.size() == 0)
            return -1;
        else
            return term.get(term.size() - 1).degree;
    }

    /*
     * PRE-CONDIZIONI: degree >= 0
     * POST-CONDIZIONI: restituisce il coefficiente del termine di grado 'degree'
     */
    int coeff(int degree) {
        if (find(degree) >= 0)
            return term.get(find(degree)).coeff();
        else
            return 0;
    }

    /*
     * PRE-CONDIZIONI: degree >= 0
     * POST-CONDIZIONI: restituisce l'indice della lista dove è salvato 'degree'
     */
    private int find(int degree) {
        int min = 0;
        int max = term.size();
        while (min < max) {
            int m = (min + max) / 2;
            if (term.get(m).degree == degree)
                return m;
            else if (term.get(m).degree < degree)
                min = m + 1;
            else
                max = m;
        }
        return -(min + 1);
    }

    /*
     * PRE-CONDIZIONI: p diverso da null
     * POST-CONDIZIONI: restituisce il polinomio this + p
     */
    PolySparse sum(PolySparse p) {
        int indexThis = 0, indexP = 0;
        PolySparse result = new PolySparse();
        while (indexThis < term.size() && indexP < p.term.size()) {
            int degree1 = term.get(indexThis).degree;
            int degree2 = term.get(indexP).degree;
            int coeff1 = term.get(indexThis).coeff;
            int coeff2 = p.term.get(indexThis).coeff;
            if (degree1 == degree2) {    
                result.term.add(new Term(coeff1 + coeff2, degree1));
            } else if (degree1 > degree2) {
                result.term.add(new Term(degree2, coeff2));
                indexP++;
            } else {
                result.term.add(new Term(degree1, coeff1));
                indexThis++;
            }
        }
        for (; indexThis < term.size(); indexThis++)
            result.term.add(term.get(indexThis));
        for (; indexP < term.size(); indexP++)
            result.term.add(term.get(indexP));
        return result;
    }

    /*
     * PRE-CONDIZIONI: p diverso da null
     * POST-CONDIZIONI: restituisce il polinomio this * p
     */
    PolySparse mul(PolySparse p) {
        if (degree() == -1 || p.degree() == -1)
            return new PolySparse();
        PolySparse result = new PolySparse();
        for (int i = 0; i < term.size(); i++)
            for (int j = 0; j < p.term.size(); j++) {
                int newCoeff = term.get(i).coeff * p.term.get(j).coeff;
                int newDegree = term.get(i).degree + p.term.get(j).degree;
                int index = result.find(newDegree);
                if (index >= 0)
                    result.term.set(index, new Term(result.term.get(index).coeff + newCoeff, newDegree));
                else
                    result.term.add(-index - 1, new Term(newCoeff, newDegree));
            }
        return result;
    }

    /*
     * PRE-CONDIZIONI: p diverso da null
     * POST-CONDIZIONI: restituisce il polinomio this - p
     */
    PolySparse diff(PolySparse p) {
        int indexThis = 0, indexP = 0;
        PolySparse result = new PolySparse();
        while (indexThis < term.size() && indexP < p.term.size()) {
            int degree1 = term.get(indexThis).degree;
            int degree2 = term.get(indexP).degree;
            int coeff1 = term.get(indexThis).coeff;
            int coeff2 = p.term.get(indexThis).coeff;
            int diff = coeff1 - coeff2;
            if (diff != 0)
                if (degree1 == degree2) {    
                    result.term.add(new Term(coeff1 - coeff2, degree1));
                } else if (degree1 > degree2) {
                    result.term.add(new Term(coeff2, -degree2));
                    indexP++;
                } else {
                    result.term.add(new Term(coeff1, degree1));
                    indexThis++;
                }
        }
        for (; indexThis < term.size(); indexThis++)
            result.term.add(term.get(indexThis));
        for (; indexP < term.size(); indexP++) {
            Term t = term.get(indexP);
            Term newTerm = new Term(-t.coeff, t.degree);
            result.term.add(newTerm);
        }
        return result;
    }

    /*
     * POST-CONDIZIONI: restituisce il polinomio - this
     */
    PolySparse minus() {
        PolySparse result = new PolySparse();
        for (int i = 0; i < term.size(); i++) {
            result.term.add(new Term(-term.get(i).coeff, term.get(i).degree));
        }
        return result;
    }
}