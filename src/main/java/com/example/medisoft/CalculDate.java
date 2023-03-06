/*
 * M�thodes outils pour g�rer des dates
 * CalculDate.java                               07/08/14
 */

package com.example.medisoft;



import java.util.*; // pour la classe StringTokenizer

/**
 * Classe contenant des m�thodes pour g�rer des dates : v�rification qu'une
 * cha�ne de caract�res contient une date �crite en toutes lettres, comme par
 * exemple : samedi 1 janvier 2000
 * 
 * @author INFO2
 */
public class CalculDate {

    /**
     * Tableau constant contenant tous les jours de la semaine
     */
    private static final String[] LISTE_JOUR = { "lundi", "mardi", "mercredi",
            "jeudi", "vendredi", "samedi", "dimanche" };

    /**
     * Tableau constant contenant tous les mois de l'ann�e
     */
    private static final String[] LISTE_MOIS = { "janvier", "fevrier", "mars",
            "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre",
            "novembre", "decembre" };

    /**
     * Constante �gale à la plus petite ann�e g�r�e
     */
    private static final int ANNEE_MIN = 1900;

    /**
     * Constante �gale à la plus grande ann�e g�r�e
     */
    private static final int ANNEE_MAX = 3000;

    /**
     * D�termine si la cha�ne argument contient un jour de la semaine (pas de
     * distinction entre les minuscules et les majuscules)
     * 
     * @param chaine
     *            cha�ne à tester
     * @return vrai ssi la cha�ne argument est un jour de la semaine
     */
    private static boolean estJour(String chaine) {
        int i; // indice de parcours du tableau LISTE_JOUR
        for (i = 0; i < LISTE_JOUR.length
                && !chaine.equalsIgnoreCase(LISTE_JOUR[i]); i++)
            ;
        return i < LISTE_JOUR.length;
    }

    /**
     * D�termine si la cha�ne argument contient un mois de l'ann�e (pas de
     * distinction entre les minuscules et les majuscules)
     * 
     * @param chaine
     *            cha�ne à tester
     * @return vrai ssi la cha�ne argument est un mois de l'ann�e
     */
    private static boolean estMois(String chaine) {
        int i; // indice de parcours du tableau LISTE_MOIS
        for (i = 0; i < LISTE_MOIS.length
                && !chaine.equalsIgnoreCase(LISTE_MOIS[i]); i++)
            ;
        return i < LISTE_MOIS.length;
    }

    /**
     * D�termine si la cha�ne argument contient un num�ro de jour : un entier
     * compris entre 1 et 31
     * 
     * @param chaine
     *            cha�ne à tester
     * @return vrai ssi la cha�ne contient un num�ro de jour
     */
    private static boolean estNumeroJour(String chaine) {
        try {
            int entier = Integer.parseInt(chaine);
            return entier >= 1 && entier <= 31;
        } catch (NumberFormatException ex) { // la cha�ne ne contient pas
            return false; // un entier
        }
    }

    /**
     * D�termine si la cha�ne argument contient une ann�e valide : un entier
     * compris entre 1900 et 3000
     * 
     * @param chaine
     *            cha�ne à tester
     * @return vrai ssi la cha�ne contient une ann�e valide
     */
    private static boolean estAnnee(String chaine) {
        try {
            int entier = Integer.parseInt(chaine);
            return entier >= ANNEE_MIN && entier <= ANNEE_MAX;
        } catch (NumberFormatException ex) { // la cha�ne ne contient pas
            return false; // un entier
        }
    }

    /**
     * D�termine si une cha�ne de caract�res contient une date dans le format
     * suivant : jour de la semaine, num�ro de jour (de 1 à 31), mois, ann�e
     * 
     * @param chaine
     *            à tester
     * @return un bool�en �gal à vrai ssi la cha�ne respcte le format
     */
    public static boolean respecteFormatDate(String chaine) {
        // on extrait de la cha�ne les diff�rents "tokens" ou sous-cha�nes
        StringTokenizer listeToken = new StringTokenizer(chaine, " ");
        int nombreToken = listeToken.countTokens();

        // si le nombre de sous-chaines n'est pas �gal à 4
        if (nombreToken != 4) {
            return false; // la cha�ne argument ne respecte pas le format
        }

        // on v�rifie que les quatres parties de la cha�ne sont valides
        return (estJour(listeToken.nextToken()) && // jour de la semaine
                estNumeroJour(listeToken.nextToken()) && // num�ro jour
                estMois(listeToken.nextToken()) && // mois
        estAnnee(listeToken.nextToken())); // ann�e
    }

    /**
     * D�termine si le num�ro de jour de la date est valide. La date doit
     * respecter le format impos�.
     * 
     * @param chaine
     *            la cha�ne à tester
     * @return un bool�en �gal à vrai ssi la cha�ne argument est valide
     */
    public static boolean dateAvecNumeroJourValide(String chaine) {
        // le format n'est pas respect�
        if (!respecteFormatDate(chaine)) {
            return false;
        }
        // on extrait de la cha�ne les diff�rents "tokens" ou sous-cha�nes
        StringTokenizer listeToken = new StringTokenizer(chaine, " ");
        listeToken.nextToken(); // pour d�passer le jour de la semaine
        // extraction des 3 sous-cha�nes à tester
        String chaineJour = listeToken.nextToken(); // num�ro de jour
        String chaineMois = listeToken.nextToken(); // mois de l'ann�e
        String chaineAnnee = listeToken.nextToken(); // ann�e

        // on d�termine si la date est valide
        try {
            return dateValide(Integer.parseInt(chaineJour),
                    numeroMois(chaineMois), Integer.parseInt(chaineAnnee));
        } catch (NumberFormatException ex) { // lev�e par parseInt si
            // la cha�ne argument ne contient pas un entier (ne doit pas se
            // produire dans ce code)
            return false;
        }
    }

    /**
     * D�termine le num�ro du mois (un entier entre 1 et 12) associ� au mois
     * argument
     * 
     * @param chaine
     *            une cha�ne contenant un mois de l'ann�e
     * @return resultat le num�ro du mois (de 1 à 12) ou -1 si la cha�ne
     *         argument ne contient pas un mois
     */
    private static int numeroMois(String chaine) {
        int resultat = -1;
        // on parcourt le tableau LISTE_MOIS à la recherche de la chaine
        for (int i = 0; resultat == -1 && i < LISTE_MOIS.length; i++) {
            // si la cha�ne est le mois d'indice i
            if (chaine.equalsIgnoreCase(LISTE_MOIS[i])) {
                resultat = i + 1; // on transforme l'indice en mois
            }
        }
        return resultat; // on renvoie le num�ro du mois
    }

    /**
     * D�termine si l'ann�e argument est bissextile
     * @param annee � tester
     * @return un bool�en �gal �vrai ssi l'ann�e est bissextile
     */
    private static boolean anneeBissextile(int annee) {
        return (annee % 4 == 0 && annee % 100 != 0) || annee % 400 == 0;
    }

    /**
     * D�termine le nombre de jours dans un mois et une ann�e donn�e
     * @param mois  mois pour lequel la m�thode calcule le nombre de jours
     * @param annee ann�e du mois
     * @return nombreJour le nombre de jours dans le mois ou -1 si le mois n'est
     *         pas valide
     */
    private static int nombreJourMois(int mois, int annee) {
        int nombreJour; // nombre de jours dans le mois
        switch (mois) { // mois de f�vrier
        case 2:
            nombreJour = anneeBissextile(annee) ? 29 : 28;
            break;
        case 4:
        case 6: // mois de 30 jours
        case 9:
        case 11:
            nombreJour = 30;
            break;
        case 1:
        case 3: // mois de 31 jours
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            nombreJour = 31;
            break;
        default:
            nombreJour = -1; // mois invalide
        }
        return nombreJour;
    }

    /**
     * D�termine si les 3 entiers argument forment une date valide
     * @param jour  jour de la date
     * @param mois mois de la date
     * @param annee ann�e de la date
     * @return un bool�en �gal à vrai ssi la date argument est valide
     */
    private static boolean dateValide(int jour, int mois, int annee) {
        return annee >= ANNEE_MIN && annee <= ANNEE_MAX && mois >= 1
                && mois <= 12 && jour >= 1
                && jour <= nombreJourMois(mois, annee);
    }

    /**
     * D�termine le nombre de jours d'une ann�e
     * @param annee annn�e dont la m�thode calcule le nombre de jours
     * @return le nombre de jours de l'ann�e argument
     */
    private static int nombreJourAnnee(int annee) {
        return anneeBissextile(annee) ? 366 : 365;
    }

    /**
     * D�termine si les 2 dates argument sont ordonn�es
     * @param jour1 jour de la premi�re date
     * @param mois1  mois de la premi�re date
     * @param an1 ann�e de la premi�re date
     * @param jour2 jour de la deuxi�me date
     * @param mois2 mois de la deuxi�me date
     * @param an2 ann�e de la deux�me date
     * @return vrai ssi la premi�re date est ant�rieure à la deuxi�me
     */
    private static boolean datesOrdonnees(int jour1, int mois1, int an1,
            int jour2, int mois2, int an2) {
        
        // si les ann�es sont diff�rentes
        if (an1 != an2) {
            return an1 < an2;
        }
        
        // else : les ann�es sont �gales
        if (mois1 != mois2) {
            return mois1 < mois2;
        }
        
        // else : les mois sont �gaux
        return jour1 <= jour2;
    }

    /**
     * D�termine l'�cart entre 2 dates situ�es dans une m�me ann�e. Les dates
     * argument doivent �tre ordonn�es
     * @param jour1 jour de la date 1
     * @param mois1 mois de la date 1
     * @param jour2 jour de la date 2
     * @param mois2 mois de la date 2
     * @param an ann�e des deux dates
     * @return le nombre de jours qui s�parent les 2 dates ou -1 si les dates ne
     *         sont pas ordonn�es
     */
    public static int ecartDateMemeAnnee(int jour1, int mois1, int jour2,
                                         int mois2, int an) {
        if (!datesOrdonnees(jour1, mois1, an, jour2, mois2, an)) {
            return -1;          // les dates ne sont pas ordonn�es
        }
        
        // le calcul est possible
        int ecart = 0;              // nombre de jours qui s�parent les 2 dates
        if (mois1 == mois2) {       // les dates sont dans le m�me mois
            ecart = jour2 - jour1;  // l'�cart est la diff�rence des jours
        } else {
            
            /*
             * on parcourt les mois complets entre les 2 dates, et on ajoute
             * leur nombre de jours
             */
            for (int mois = mois1 + 1; mois < mois2; mois++) {
                ecart += nombreJourMois(mois, an);
            }
            
            // on ajoute les jours de s�paration pour les mois incomplets
            ecart += jour2 + (nombreJourMois(mois1, an) - jour1);
        }
        return ecart;
    }

    
    /**
     * D�termine l'�cart entre 2 dates. L'�cart est un nombre de jours en valeur
     * absolue
     * @param jour1 jour de la date 1
     * @param mois1 mois de la date 1
     * @param an1 ann�e de la date 1
     * @param jour2 jour de la date 2
     * @param mois2 mois de la date 2
     * @param an2 ann�e de la date 2
     * @return le nombre de jours qui s�parent les 2 dates
     */
    public static int ecartDate(int jour1, int mois1, int an1, int jour2,
                                int mois2, int an2) {
        if (!datesOrdonnees(jour1, mois1, an1, jour2, mois2, an2)) {
            
            // appel r�cursif en permutant les 2 dates argument
            return ecartDate(jour2, mois2, an2, jour1, mois1, an1);
        }
        
        // les dates sont ordonn�es
        int ecart = 0;              // nombre de jours qui s�parent les 2 dates
        if (an1 == an2) {           // les dates appartiennent à la même ann�e
            ecart = ecartDateMemeAnnee(jour1, mois1, jour2, mois2, an1);
        } else {
            
            /*
             * on parcourt les ann�es compl�tes entre les 2 dates, et on cumule
             * le nombre de jours de ces ann�es
             */            
            for (int annee = an1 + 1; annee < an2; annee++) {
                ecart += nombreJourAnnee(annee);
            }
            
            
            /*
             * on calcule le nombre de jours qui s�parent la date 1 de la fin de
             * son ann�e
             */            
            ecart += ecartDateMemeAnnee(jour1, mois1, 31, 12, an1);
            
            /*
             * on calcule le nombre de jours entre le 1er janvier de l'ann�e de
             * la date 2, et la date 2 elle-m�me
             */            
            ecart += ecartDateMemeAnnee(1, 1, jour2, mois2, an2) + 1;
        }
        return ecart;
    }

    /**
     * D�termine le jour de la semaine pour une date donn�e
     * @param jour jour de la date
     * @param mois mois de la date
     * @param annee ann�e de la date
     * @return une cha�ne �gale à Lundi, Mardi, ... ou Dimanche ou
     *         "Date invalide" si la date est invalide
     */
    public static String jourSemaine(int jour, int mois, int annee) {
        if (!dateValide(jour, mois, annee)) { // la date est invalide
            return "Date invalide";
        }
        
        /*
         * la date est valide : on calcule le nombre de jours qui la s�parent
         * du 1/1/1900 (c'�tait un lundi)
         */
        int difference = ecartDate(1, 1, ANNEE_MIN, jour, mois, annee);
        return LISTE_JOUR[difference % 7];              // on renvoie le jour
    }

    /**
     * Transforme une date en une cha�ne de caract�res jour de la semaine +
     * numero jour + mois + ann�e
     * 
     * @param jour
     *            jour de la date
     * @param mois
     *            mois de la date
     * @param annee
     *            ann�e de la date
     * @return une cha�ne contenant la date ou "Date invalide" si la date est
     *         invalide
     */
    public static String transformeEnChaine(int jour, int mois, int annee) {
        if (!dateValide(jour, mois, annee)) { // la date est invalide
            return "Date invalide";
        }
        // la date est valide
        return jourSemaine(jour, mois, annee) + " " + jour + " "
                + LISTE_MOIS[mois - 1] + " " + annee;
    }

    /**
     * D�termine si la date argument est valide, dans le format jour de la
     * semaine + numero jour + mois + ann�e Le jour de la semaine est v�rifi�.
     * 
     * @param chaine
     *            la cha�ne à tester
     * @return un bool�en �gal à vrai ssi la cha�ne argument est valide
     */
    public static boolean dateEntierementValide(String chaine) {
        // le format n'est pas respect�
        if (!respecteFormatDate(chaine)) {
            return false;
        }
        // on extrait de la cha�ne les diff�rents "tokens" ou sous-cha�nes
        StringTokenizer listeToken = new StringTokenizer(chaine, " ");
        // on extrait d'abord le jour de la semaine
        String chaineJourSemaine = listeToken.nextToken(), chaineJour = listeToken
                .nextToken(), // num�ro de jour
        chaineMois = listeToken.nextToken(), // mois de l'ann�e
        chaineAnnee = listeToken.nextToken(); // ann�e

        // on d�termine si la date est valide et si son jour est correct
        try {
            return dateValide(Integer.parseInt(chaineJour),
                    numeroMois(chaineMois), Integer.parseInt(chaineAnnee))
                    && chaineJourSemaine.equalsIgnoreCase(jourSemaine(
                            Integer.parseInt(chaineJour),
                            numeroMois(chaineMois),
                            Integer.parseInt(chaineAnnee)));
        } catch (NumberFormatException ex) { // lev�e par parseInt si
            // la cha�ne argument ne contient pas un entier (ne doit pas se
            // produire dans ce code)
            return false;
        }
    }

}
