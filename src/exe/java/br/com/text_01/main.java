package br.com.text_01;

import java.io.*;
import java.nio.Buffer;

public class main {
    public static void main(String[] args) {
        String arquivo1 = "tabua5.txt";
        String arquivo2 = "copiaTabuada5.txt";

        int tab;
        try {
            FileWriter fw = new FileWriter(arquivo1);

            for (int i = 0; i < 10; i++) {
                tab = (i +1) * 5;
                fw.write(i+1 +" * 5 = " + tab + "\n");
            }
            fw.close();

            BufferedReader br = new BufferedReader(new FileReader(arquivo1));
            BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo2));
            String linha;

            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
                bw.write(linha);
                bw.newLine();
            }

            br.close();
            bw.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
