package Probleme;

import java.util.Scanner;

public class Probleme {


    //todo:  Să se scrie un program "java" care citeşte de la tastatură un cuvânt format din cel mult 20 de caractere, doar litere mici ale alfabetului englez.
    //       Programul determină transformarea cuvântului citit prin înlocuirea fiecărei vocale a cuvântului, cu un şir format din două caractere /şi anume vocala respectivă urmată de litera mare corespunzătoare, restul literelor nemodificându-se, ca în exemplu. Programul afişează pe ecran cuvântul obţinut, pe o singură linie. Se consideră vocale literele din mulţimea {a,e,i,o,u}.

    public void sol1() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Introduceti un text: ");
        String text = scanner1.nextLine();

        String textFinal = inserareMajusculaDupaVocala(text);
        System.out.println(textFinal);
    }

    private boolean isVocala(char ch) {
        if (!Character.isAlphabetic(ch)) {
            return false;
        }
        String vocale = "AEIOUaeiou";
        return vocale.contains(ch + "");
    }

    public String inserareMajusculaDupaVocala(String str) {
        String aux = "";
        for (int i = 0; i < str.length(); i++) {
            if (isVocala(str.charAt(i)) == true) {
                aux += str.charAt(i);
                aux += Character.toUpperCase(str.charAt(i));
            } else {
                aux += str.charAt(i);
            }
        }
        return aux;
    }


    //todo: Scrieţi un program "java" care să citească de la tastatură un număr natural nenul n (n≤100) şi apoi un şir de n numere naturale de cel mult 8 cifre fiecare, toate numerele din şir fiind strict mai mari decât 1.
    //      Folosind apeluri utile ale subprogramului f, programul va determina şi va afişa pe ecran toate numerele prime din şirul citit. Numerele determinate se vor afişa pe ecran, separate prin câte un spaţiu, în ordine crescătoare a valorii lor. Dacă nu există astfel de numere se va afişa pe ecran mesajul NU EXISTA

    public void sol2() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Introduceti un text: ");
        String text = scanner1.nextLine();

        String textFinal = numerePrime(text);
        System.out.println(textFinal);
    }

    public String numerePrime(String str) {

        String[] split = str.split(" ");
        String aux = "";
        for (int i = 0; i < split.length; i++) {
            if (estePrim(split[i]) == true) {
                aux += split[i];
                aux += " ";
            }
        }
        return aux;
    }

    public boolean estePrim(String str) {
        int i = Integer.parseInt(str);
        if (numarDiv(i) == 2) {
            return true;
        }
        return false;
    }

    public int numarDiv(int n) {
        int nrd = 0;
        for (int x = 1; x <= n; x++) {
            if (n % x == 0) {
                nrd++;
            }
        }
        return nrd;
    }


    //todo:Să se scrie un program "java" care, folosind un algoritm eficient din punct de vedere al memoriei utilizate şi al timpului de executare, citeşte din fişier toţi termenii şirului şi afişează pe ecran, pe o singură linie, fiecare termen distinct al şirului urmat de numărul de apariţii ale acestuia în şir. Valorile afişate sunt separate prin câte un spaţiu.

    public void sol3() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Introduceti un text: ");
        String text = scanner1.nextLine();

        String textFinal = caractereCuNrDeAparitii(text);
        System.out.println(textFinal);
    }

    public String caractereCuNrDeAparitii(String str) {
        String[] split = str.split(" ");
        String aux = "";
        for (int i = 0; i < split.length; i++) {
            if (apareInString(aux, split[i].charAt(0)) == false) {
                aux += split[i].charAt(0);
                aux += " ";
                aux += nrApartiiChar(str, split[i].charAt(0));
            }
        }
        return aux;
    }

    public boolean apareInString(String str, char ch) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }

    private int nrApartiiChar(String str, char ch) {
        int nr = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                nr++;
            }
            return nr;
        }
        return nr;
    }



    //todo:Pe prima linie a fişierului text BAC.TXT se află o valoare naturală n (1<n≤50), iar pe a doua linie n numere naturale cu maximum 4 cifre fiecare, despărţite prin câte un spaţiu. În şirul numerelor de pe a doua linie a fişierului există cel pzâin două numere pătrate perfecte.
    //     Scrieţi un program "java" care citeşte toate numerele din fişier şi afişează pe ecran expresia aritmetică reprezentând suma numerelor de pe a doua linie a fişierului care au proprietatea că sunt pătrate perfecte, cu simbolul + între ele şi, după un semn =, valoarea acestei sume, ca în exemplu


    public void sol4() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Introduceti un text: ");
        String text = scanner1.nextLine();

        String textFinal = exprimareSumaNumerePatratePerfecte(text);
        System.out.println(textFinal);
    }

    public String exprimareSumaNumerePatratePerfecte(String str) {
        String[] split = str.split(" ");
        String aux = "";
        for (int i = 0; i < split.length; i++) {
            if (isPatratPefect(split[i]) == true) {
                aux += split[i];
                aux += "+";
            }
        }
        aux+= "=" + sumaNumereString(aux);
        return aux;
    }
    public Boolean isPatratPefect(String str) {
        if (Math.sqrt(Integer.parseInt(str)) == (int)Math.sqrt(Integer.parseInt(str))) {
            return true;
        }
        return false;
    }
    public int sumaNumereString(String str) {
        String[] split = str.split(" ");
        int s =0;
        for (int i = 0; i < split.length; i++) {
            s+= Integer.parseInt(split[i]);
        }
        return s;
    }



    //todo:In fisierul cuvinte.in pe prima linie se afla un numar natural n (0 < n < 50). Pe fiecare dintre urmatoarele n liniii se afla un cuvant avand cel mult 30 de caractere, care sunt litere mici. Cuvintele din sir sunt distincte.
    //     Scrie un program "java" care citeste datele din fisierul de intrare si afiseaza in fisierul cuvinte.out, primul cuvant si ultimul cuvant in ordine alfabetica, dinte cuvintele citite.

    public void sol5() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Introduceti numarul: ");
        int nr = scanner1.nextInt();

        String[] cuvinte = new String[nr];
        int ctr =0;
        while (ctr < nr) {
            Scanner scanner2 = new Scanner(System.in);
            String aux = scanner2.nextLine();
            cuvinte[ctr] = aux;
            ctr++;
        }

        afisarePrimulSiUltimulCuvantDupaOrdonareaAlfabetica(cuvinte);
    }

    private void afisarePrimulSiUltimulCuvantDupaOrdonareaAlfabetica(String[] str) {
        String aux = "";
        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[i].compareTo(str[j]) > 0) {
                    aux = str[i];
                    str[i] = str[j];
                    str[j] = aux;
                }
            }
        }

        System.out.println(str[0]);
        System.out.println(str[str.length-1]);
    }



    //todo:Se citeste de la tastatura un text, avand cel mult 200 de caractere, format din mai multe cuvinte, separate prin unul sau mai multe spatii sau semne de punctuatie: .,?! . Textul se incheie cu punct. Cuvintele contin numai litere mici ale alfabetului englez.
    //     Cuvintele contin numai litere mici ale alfabetului englez. Scrie un program "java" care obtine un nou text format din toate cuvintele textului citit care incep si se incheie cu o vocala, separate intre ele printr-un spatiu.

    public void sol6() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti un text: ");
        String text = scanner.nextLine();

        String textFinal = cuvinteCuPcSiUcVocale(text);
        System.out.println(textFinal);

    }

    private boolean primaSiUltimaCifraSuntVocale(String str) {
        if (isVocala(str.charAt(0)) == true && isVocala(str.charAt(str.length()-1)) == true) {
            return true;
        }
        return false;
    }

    private String cuvinteCuPcSiUcVocale(String str) {
        String[] split = str.split("[.,?!]");
        String aux = "";
        for (int i =0; i < split.length; i++) {
            if (primaSiUltimaCifraSuntVocale(split[i]) == true) {
                aux += split[i];
                aux += " ";
            }
        }
        return aux;
    }



    //todo:Se citeste de la tastatura un sir de caractere e, avand cel putin 4 caractere si cel mult 200 se caractere care reprezinta o expresie aritmetica, formata din litere mici si cifre (care reprezinta o expresie aritmetica, formata din litere mici si cifre (care reprezinta operanzi).
    //     Expreisa e este corecta daca daca sunt indeplinite urmatoarele conditii:
    //              -expreisa nu contine doi operatori situati pe pozitii cosecutive
    //              -un operator nu este precedat de o paranteza deschisa
    //              -fiecare operand este format dintr-o litera mica sau o cifra
    //              -expersia data contine doar litere mici, cifre, paranteze si operatorii mentionati.

    public void sol7() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti un text: ");
        String text = scanner.nextLine();

        if (esteOperatieCorecta(text) == true) {
            System.out.println("Este o operatie corecta");
        }
        else {
            System.out.println("Nu este o operatie corecta");
        }
    }

    private boolean isOperator(char ch) {
        String operatori = "+-*/";
        if (operatori.contains(ch + "") == true) {
            return true;
        }
        return false;
    }
    private boolean isParantezaDeschisa(char ch) {
        String paranteze = "([";
        if (paranteze.contains(ch + "") == true) {
            return true;
        }
        return false;
    }

    private boolean esteOperatieCorecta(String str) {
        for (int i =0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i)) == true && Character.isUpperCase(str.charAt(i)) == true) {
                return false;
            }
            else if (isOperator(str.charAt(i)) == true && isOperator(str.charAt(i)) == true) {
                return false;
            }
            else if (isOperator(str.charAt(i)) == true && isParantezaDeschisa(str.charAt(i)) == true) {
                return false;
            }
        }
        return true;
    }



    //todo:Se citeste de la tastatura o vocala v, un numar natural n si un sir de caractere s format din n litere mici. Scrie un program "java" care afiseaza pe ecran secventa de lungime maxima din sirul s, care incepe si se incheie cu o vocala v.

    public void sol8() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Introduceti un text: ");
        String text = scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Introduceti o vocala: ");
        char vocala = scanner2.nextLine().charAt(0);

        String textFinal = ceaMaiMareSecventaDeLitereIntreVocala(text,vocala);
        System.out.println(textFinal);
    }

    private int numarLitere(String str) {
        int nr =0;
        for (int i =0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i)) == true) {
                nr++;
            }
        }
        return nr;
    }
    private String ceaMaiMareSecventaDeLitereIntreVocala(String str, char vocala) {
        String auxMax = "";
        for (int i =0; i < str.length(); i++) {
            String aux = "";
            if (str.charAt(i) == vocala) {
                int st = 0;
                for (int j =i ; j < str.length() && st == 0; j++) {
                    if (j == 0) {
                        aux+= str.charAt(j);
                    }
                    else if (str.charAt(j) != vocala) {
                        aux+= str.charAt(j);
                    }
                    else if (str.charAt(j) == vocala) {
                        aux+= str.charAt(j);
                        st = 1;
                    }
                }
            }
            if (numarLitere(aux) > numarLitere(auxMax)) {
                auxMax = aux;
            }
        }
        return auxMax;
    }




    //todo:Se citeste de la tastatura un text t, avand cel mult 400 de caractere, format din mai multe cuvinte, separate prin spatiu. Cuvintele din text sunt formate din litere.
    //         Scrie un program "java" care determina primul cuvant din text care contine doua vocale. situate pe pozitii consecutive, afiseaza pe ecran acest cuvant si numarul sau de aparitii in text.


    public void sol9() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introducet un text: ");
        String text = scanner.nextLine();

        String textFinal = primulCuvantCuDouaVocaleConsecutive(text);
        System.out.println(textFinal);
    }

    private boolean areDouaVocaleConsecutive(String str) {
        for (int i =0; i < str.length()-1; i++) {
            if (isVocala(str.charAt(i)) == true && isVocala(str.charAt(i+1)) == true) {
                return true;
            }
        }
        return false;
    }

    private String primulCuvantCuDouaVocaleConsecutive(String str) {
        String[] split = str.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (areDouaVocaleConsecutive(split[i]) == true) {
                return split[i];
            }
        }
        return "";
    }



    //todo:In fisierul cuvinte.in pe prima linie se afla doua numere naturale n si lg (0 < n < 40, 1 < lg < 20). Pe fiecare dintre urmatoarele n linii se afla un cuvant avand cel mult 30 de caractere, care sunt litere mici.
    //         Scrie un program C++ care citeste datele din fisierul der intrare si afiseaza in fisierul cuvinte.out, cuvintele citite care au lungimea egala cu lg.


    public void sol10() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Introduceti numarul: ");
        int nr = scanner1.nextInt();

        String[] cuvinte = new String[nr];
        int ctr =0;
        while (ctr < nr) {
            Scanner scanner2 = new Scanner(System.in);
            String aux = scanner2.nextLine();
            cuvinte[ctr] = aux;
            ctr++;
        }

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Introduceti lungimea: ");
        int l = scanner3.nextInt();

        afisareCuvinteCuLungimeaL(cuvinte,l);
    }

    private void afisareCuvinteCuLungimeaL(String str[], int l) {
        for (int i =0; i < str.length; i++) {
            if (numarLitere(str[i]) == l) {
                System.out.println(str[i]);
            }
        }
    }


    //todo:Scrieti un program "java" care citeste de la tastatura o fraza de maximum 255 de caractere(litere mari ale alfabetului englez si spatii), ale carei cuvinte sun despartite prin cate un spatiu si afiseaza pe primul rand al ecranunui numarul total al cuvintelor din fraaza
    //      Iar oe rand de ecran in ordine alfabetica, scrise o singura data. consoanele care nu apar in fraza.

    public void sol11() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text=scanner.nextLine();
        String solutie = "";
        solutie += "Numarul de cuvinte in text este: " + numarCuvinte(text) + " " ;
        System.out.println(solutie);
        String textFinal = consoaneCareNuAparInFraza(text);
        System.out.println(textFinal);

    }

    private int numarCuvinte(String str) {
        int nr =0;
        String[] split = str.split(" ");
        for (int i =0; i < split.length; i++) {
            nr++;
        }
        return nr;
    }

    private String consoaneCareNuAparInFraza(String str) {
        String consoane = "BCDFGHJKLMNPQRSTVWXYZ";
        String aux = " ";
        for (int i =0; i < consoane.length(); i++) {
            if(apareInString(str,consoane.charAt(i)) == true) {
                aux+= consoane.charAt(i);
                aux+= " ";
            }
        }
        return aux;
    }




    //todo: Un sir cu maximum 255 de caractere contine cuvinte separate prin unul sau mai multe spatii. Cuvintele sunt formate numai din litere mici ale alfabetului englez.
    //      Scrieti un program "Java" care cisteste un astfel de sir si il afiseaza modificat, prima si ultima litera a fiecarui cvant fiind afisata ca litera mare.


    public void sol12() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text=scanner.nextLine();
        String textFinal = tranformarePcSiUcInLitereMariLaFiecareCuvant(text);
        System.out.println(textFinal);
    }

    private String tranformarePcSiUcInLitereMariLaFiecareCuvant(String str) {
        String[] split = str.split(" ");
        String aux = "";
        for(int i =0; i < split.length; i++) {
            aux += tranformarePrimaSiUltimaLiteraInLitereMari(split[i]);
            aux += " ";
        }
        return aux;
    }
    private String tranformarePrimaSiUltimaLiteraInLitereMari(String str) {
        char pl = Character.toUpperCase(str.charAt(0));
        char ul = Character.toUpperCase(str.charAt(str.length()-1));
        String aux = "";
        for (int i =0; i < str.length(); i++) {
            if (i == 0) {
                aux+= pl;
            }
            else if (i == str.length()-1) {
                aux+= ul;
            }
            else {
                aux+= str.charAt(i);
            }
        }
        return aux;
    }




    //todo: Un sir cu maximum 255 de caractere contine cuvinte separate prin cate un spatiu. Cuvintele sunt formate numai din litere mici ale alfabetului englez.
    //      Scrieti un program "Java" care citeste de la tastatura un astfel de sir si il afiseaza pe ecran modificat, inversand prin oglindire doar cuvintele care incep cu vocala, ca in exemplu.


    void sol13() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text=scanner.nextLine();
        String textFinal = inversareCuvinteCareIncepCuVocala(text);
        System.out.println(textFinal);
    }

    private String inversareCuvinteCareIncepCuVocala(String str) {
        String[] split = str.split(" ");
        String aux = "";
        for (int i =0; i < split.length; i++) {
            if (incepeCuVocala(split[i]) == true) {
                aux+= inversareCuvant(split[i]);
                aux+= " ";
            }
            else {
                aux+= split[i];
                aux+= " ";
            }
        }
        return aux;
    }

    private boolean incepeCuVocala(String str) {
        if (isVocala(str.charAt(0)) == true) {
            return true;
        }
        return false;
    }

    private String inversareCuvant(String str) {
        String aux = "";
        for (int i = str.length()-1; i >= 0; i--) {
            aux+= str.charAt(i);
        }
        return aux;
    }




    //todo:Un sir de maximum 255 de caractere contine cuvinte formate numai din litere mici ale alfabetului englez. Fiecare cuvant este urmat de un caracter *.
    //     Scieti un program "Java" care citeste un astfel de sir si afiseaza pe ecran sirul obtinut prin eliminarea tuturor apartitiilor primului cuvant,ca in exemplu.


    public void sol14() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text=scanner.nextLine();
        String textFinal = eliminareAparitiiAlePrimuluiCuvant(text);
        System.out.println(textFinal);
    }

    public String eliminareAparitiiAlePrimuluiCuvant(String str) {
        String[] split = str.split("[*]");
        String pc = split[0];
        String aux = "*";
        for (int i =1; i < split.length; i++) {
            if (split[i].contains(pc) == true) {
                aux+= split[i].replace(pc,"");
            }
            else {
                aux+= split[i];
            }
            aux+= "*";
        }
        return aux;
    }



    //todo:Se consideră o propoziție care are maximum 250 de caractere. Ea cuprinde separator. Creați un program ce va afişa pe ecran fiecare cuvânt din propoziție pe unul sau mai mulți separatori. Orice caracter care nu este literă va fi considerat  câte o linie. Cuvintele vor avea prima literă majusculă.

    public void sol15() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text = scanner.nextLine();
        afisareCuvintePeLiniiNoi(text);
    }

    private void afisareCuvintePeLiniiNoi(String str) {
        String[] split = str.split("[,.!?;: ]");
        for (int i = 1; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }



    //todo:Să se scrie un program "java" care citeşte de la tastatură un număr natural n (0<n<25) şi apoi n numere naturale nenule cu maximum 9 cifre fiecare. Programul calculează, folosind apeluri ale funcţiei sum, şi afişează pe ecran câte numere prime conţine şirul citit

    public void sol16() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text=scanner.nextLine();
        int nr = nrNumerePrime(text);
        System.out.println(nr);
    }
    public int nrNumerePrime(String str) {
        String[] split = str.split(" ");
        int nr = 0;
        for (int i = 0; i < split.length; i++) {
            if (estePrim(split[i]) == true) {
                nr ++;
            }
        }
        return nr;
    }



    //todo: Scrieţi un program "java" care citeşte de la tastatură o valoare naturală nenulă n (n≤20), apoi un şir de n numere naturale, având fiecare exact 5 cifre. Dintre cele n numere citite, programul determină pe acelea care au toate cifrele egale şi le afişează pe ecran.

    public void sol17() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text=scanner.nextLine();
        String textFinal = numerePalindrom(text);
        System.out.println(textFinal);
    }

    public String numerePalindrom(String str) {
        String[] split = str.split(" ");
        String aux = "";
        for (int i = 0; i < split.length; i++) {
            if (isPalindrom(split[i]) == true) {
                aux += split[i];
                aux += " ";
            }
        }
        return aux;
    }
    public boolean isPalindrom(String str) {
        if (str == inversareCuvant(str)) {
            return true;
        }
        return false;
    }



    //todo:Pe prima linie a fişierului text BAC.IN se găsesc, separate prin câte un spaţiu, mai multe numere naturale de cel mult 9 cifre fiecare. Scrieţi programul C/C++ care citeşte numerele din acest fişier, utilizând apeluri ale subprogramului P elimină toate cifrele impare din fiecare dintre aceste numere şi apoi scrie în fişierul text BAC.OUT

    public void sol18() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text=scanner.nextLine();
        String textFinal = eliminareCifreImpare(text);
        System.out.println(textFinal);
    }

    public String eliminareCifreImpare(String str) {
        String[] split = str.split(" ");
        String aux = "";
        for (int i = 0; i < split.length; i++) {
            aux += eliminareCifreImpareNumar(split[i]);
            aux += " ";
        }
        return aux;
    }

    public String eliminareCifreImpareNumar(String cuv) {
        String aux = "";
        for (int i = 0; i < cuv.length(); i++) {
            if (cuv.charAt(i) % 2 == 0 ) {
                aux += cuv.charAt(i);
                aux += " ";
            }
        }
        return aux;
    }


    //todo:Se citeşte de la intrarea standard un şir de maximum 200 de caractere reprezentând o propoziție. Cuvintele sunt secvenţe de litere mici sau mari ale alfabetului englezesc. Realizați un program care afişează propoziția după ce cuvintele au fost ordonate lexicografic. După fiecare cuvânt vor fi afişaţi separatorii prezenți în propoziția inițială după cuvântul cu numărul de ordine respectiv.

    public void sol19() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text = scanner.nextLine();
        String textFinal = reordonarePropozitieInOridneAlfabetica(text);
        System.out.println(textFinal);
    }

    public String reordonarePropozitieInOridneAlfabetica(String str) {
        String[] split = str.split(" ");
        String aux = "";
        for (int i = 0; i < split.length; i++) {
            for (int j = i + 1; j < split.length; j++) {
                if (split[i].compareTo(split[j]) > 0) {
                    aux = split[i];
                    split[i] = split[j];
                    split[j] = aux;
                }
            }
        }
        String fin = "";
        for (int k = 0; k < split.length; k++) {
            fin += split[k];
            fin += " ";
        }
        return fin;
    }


    //todo:Se consideră un şir de cel mult 100 de caractere, citit de pe prima linie a fişierului in.txt. Să se afişeze toate şirurile de caractere de lungime maximă 2*k obținute prin concatenarea prefixelor cu sufixele de aceeaşi lungime ale acestui şir.


    public void sol20() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text = scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Introduceti k ");
        int k = scanner2.nextInt();

        afisarePrefixeSiSufixeCombinate(text, k);
    }

    public void afisarePrefixeSiSufixeCombinate(String str, int k) {
        int ctr = 1;
        while (ctr <= k) {
            String aux = "";
            for (int i =0 ; i < ctr; i++) {
                aux+= str.charAt(i);
            }
            for (int j = str.length()-1; j > str.length() - ctr; j--) {
                aux+= str.charAt(j);
            }
            System.out.println(aux);
            ctr++;
        }
    }




    //todo:Fişierul in.txt conține un text dispus pe mai multe linii. Orice caracter care nu reprezintă o litera mică a alfabetului englezesc se consideră separator. Numărul de caractere ale unei linii nu depăşeşte 200. Realizați un program care afişează numărul de apariții ale unui cuvânt, preluat de la tastatură, în textul din fişier.ton


    public void sol21() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text = scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Introduceti  un cuvant");
        String cuv = scanner2.nextLine();

        int nr = nrAparitiiCuvant(text,cuv);

        String solutie = "Numarul de apartii al cuvantului " + cuv + " este: " + nr;
        System.out.println(solutie);
    }

    public int nrAparitiiCuvant(String str, String cuv) {
        int nr =0;
        String[] split = str.split("[,.!?;: ]");
        for (int i =0; i < split.length; i++) {
            if (split[i].equals(cuv) == true) {
                nr++;
            }
        }
        return nr;
    }



    //todo:Conținutul fişierul virus.txt a fost deteriorat, iar valorile naturale care inițial erau separate în cadrul liniilor prin câte un singur spațiu, au acum ca separatori orice caracter ce nu reprezintă o cifră. Realizați un program care creează fişierul sum.txt în care pe fiecare linie se află suma numerelor aflate în fişierul virus.txt.

    public void sol22() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text = scanner.nextLine();
        int s = sumaNumerelorDinFisierVirus(text);
        System.out.println(s);
    }

    public int sumaNumerelorDinFisierVirus(String str) {
        int s =0;
        String[] split = str.split("[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz]");
        for (int i =0; i < split.length; i++) {
            //    s+= split[i]; ??
        }
        return s;
    }



    //todo:Se consideră o propozitie de maximum 50 de caractere, citită de la tastatură. Să se realizeze un program care afişează propoziția după eliminarea tuturor cuvintelor de lungime p.

    public void sol23() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text = scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Introduceti p ");
        int p = scanner2.nextInt();

        String textFinal = eliminareCuvinteDeLungimeP(text,p);
        System.out.println(textFinal);
    }


    public String eliminareCuvinteDeLungimeP(String str, int p) {
        String aux = "";
        String[] split = str.split("[,.!?;: ]");
        for (int i =0; i < split.length; i++) {
            if (numarCuvinte(split[i]) == p) {
                aux += "";
            }
            else {
                aux+= split[i];
                aux+= " ";
            }
        }
        return aux;
    }

    //todo:Se consideră un cuvânt format din literele mici şi mari ale alfabetului englez. Să se scrie un program care afişează cuvintele obținute din cuvântul inițial prin eliminarea succesivă a primului şi ultimului caracter al şirului.


    public void sol24() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text = scanner.nextLine();
        afisareCuvinteDupaEliminarePcSiUcSuccesiv(text);
    }

    private void afisareCuvinteDupaEliminarePcSiUcSuccesiv(String str) {
        int ctr = str.length();
        String mainAux = str;
        while (ctr >= 0) {
            String aux = "";
            for (int i = 0; i < mainAux.length(); i++) {
                if (i == 0) {
                    aux += "";
                } else if (i == mainAux.length() - 1) {
                    aux += "";

                } else {
                    aux += mainAux.charAt(i);
                }
            }
            mainAux = aux;
            System.out.println(mainAux);
            ctr--;
        }
    }


    //todo:Să se creeze un program care transformă literele mici ale unui cuvânt în litere mari şi literele mari în litere mici. Exemplu: Pentru cuvântul 'MiorItIC' se va afişa: 'mIORiTic'.

    public void sol25() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text = scanner.nextLine();
        String textFinal = transformareLitereMiciInMariSiMariInMici(text);
        System.out.println(textFinal);
    }

    private String transformareLitereMiciInMariSiMariInMici(String str) {
        String aux = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i)) == true) {
                aux += Character.toUpperCase(str.charAt(i));
            } else if (Character.isUpperCase(str.charAt(i)) == true) {
                aux += Character.toLowerCase(str.charAt(i));
            }
        }
        return aux;
    }


    //todo:Se consideră un şir de n cuvinte. Să se determine cuvântul de lungime maximă care se poate forma prin concatenarea a două dintre cuvintele citite


    public void sol26() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text = scanner.nextLine();
        String textFinal = cuvantulCombinatCuLungimeMaxima(text);
        System.out.println(textFinal);
    }

    private int lungimeCuvant(String str) {
        int l = 0;
        for (int i = 0; i < str.length(); i++) {
            l++;
        }
        return l;
    }

    private String cuvantulCombinatCuLungimeMaxima(String str) {
        String[] split = str.split(" ");
        int lMax = -1;
        String cuvMax = "";
        for (int i = 1; i < split.length - 1; i++) {
            String aux = split[i] + split[i + 1];
            if (lungimeCuvant(aux) > lMax) {
                lMax = lungimeCuvant(aux);
                cuvMax = aux;
            }

        }
        return cuvMax;
    }


    //todo:Se consideră un şir de n cuvinte. Să se determine cuvântul cel mai mic în ordine lexicografică obținut prin concatenarea a două dintre cuvintele citite.

    public void sol27() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text = scanner.nextLine();
        String textFinal = celMaiMicCuvantCombinatInOrdineLexicografica(text);
        System.out.println(textFinal);
    }

    private String celMaiMicCuvantCombinatInOrdineLexicografica(String str) {
        String[] split = str.split(" ");
        String cuvMin = "";
        for (int i = 1; i < split.length - 2; i++) {
            String aux = split[i] + split[i + 1];
            String aux2 = split[i + 1] + split[i + 2];
            if (aux.compareTo(aux2) < 0) {
                cuvMin = aux;
            }
            else {
                cuvMin = aux2;
            }

        }
        return cuvMin;
    }


    //todo:Considerăm un text de maximum 255 de caractere. Propozițiile sunt delimitate prin caracterele punct (.) sau prin semnul exclamării (!). Realizați un program care afişează fiecare propoziție pe o singură linie, fiecare cuvânt începînd cu majusculă.


    public void sol28() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text = scanner.nextLine();
        afisarePropozitiiPeLiniiNoi(text);
    }

    private void afisarePropozitiiPeLiniiNoi(String str) {
        String[] split = str.split(".");
        for (int i = 1; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }


    //todo:Se consideră o listă cu n (n<100) prenume ale elevilor dintr-o clasă. Prenumele unei fete este recunoscut datorită faptului că fie are ulima literă 'a', fie este 'Carmen' sau 'Alice'. Să se creeze un program care afişează numărul fetelor din clasă şi cel mai mare prenume în sens lexicografic ale cărui litere vor fi transformate în majuscule.

    public void sol29() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti  un text");
        String text = scanner.nextLine();
        String solutie = "";
        solutie += nrFete(text) + transformareCuvantInMajuscule(celMaiMareNumeLexicografic(text));
        System.out.println(solutie);
    }

    private boolean esteNumeDeFata(String str) {
        if (str.contains("AnaMariaIoanaAndreeaAliceCarmen") == true) {
            return true;
        }
        return false;
    }

    private int nrFete(String str) {
        String[] split = str.split(" ");
        int nr =0;
        for (int i = 1; i < split.length; i++) {
            if (esteNumeDeFata(split[i]) == true) {
                nr++;
            }
        }
        return nr;
    }

    private String transformareCuvantInMajuscule(String  str) {
        String aux = "";
        for (int i = 0; i < str.length(); i++) {
            aux += Character.toUpperCase(str.charAt(i));
        }
        return aux;
    }

    private String celMaiMareNumeLexicografic(String str) {
        String[] split = str.split(" ");
        String cuvMax = "";
        for (int i = 1; i < split.length -1; i++) {
            if (split[i].compareTo(split[i+1]) > 0) {
                cuvMax = split[i];
            }
            else {
                cuvMax = split[i+1];
            }

        }
        return cuvMax;
    }



    //todo:Se consideră 2 cuvinte ce conțin numai litere mici. Considerăm că ultima silabă a unui cuvânt este subşirul care începe cu ultima lui vocală. Verificați dacă aceste cuvinte rimează (dacă au ultima silabă identică). Dacă un cuvânt nu conţine vocale, atunci ultima silabă este întregul cuvânt.

    public void sol30() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Introduceti primul cuvant");
        String cuv1 = scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Introduceti al doilea cuvant");
        String cuv2 = scanner2.nextLine();

        if (rimeaza(cuv1,cuv2) == true) {
            System.out.println("Cuvintele rimeaza");
        }
        else {
            System.out.println("Cuvintele nu rimeaza");
        }

    }

    private int pozitieUltimaVocala(String str) {
        int ultPoz = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isVocala(str.charAt(i)) == true) {
                ultPoz = i;
            }
        }
        return ultPoz;
    }

    private String ultimaSilaba(String str) {
        String aux = "";
        for (int i = pozitieUltimaVocala(str); i < str.length(); i++) {
            aux += str.charAt(i);
        }
        return aux;
    }
    private boolean rimeaza(String cuv1, String cuv2) {
        if (ultimaSilaba(cuv1).equals(ultimaSilaba(cuv2)) == true) {
            return true;
        }
        return false;
    }



}