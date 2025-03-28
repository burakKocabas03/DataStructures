package dataStc3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadAndCreate {

    
    public static BinarySearchTree returnTreeMetod() {
        
        BinarySearchTree bTree= new BinarySearchTree();

        String unescoVerileri = "Divriği Ulu Camii ve Darüşşifası s(Siva) 1985\n" +
                "İstanbul'un Tarihi Alanları (İstanbul) 1985\n" +
                "Göreme Millî Parkı ve Kapadokya (Nevşehir) 1985 (Karma Miras Alanı)\n" +
                "Hattuşaş Hitit Başkenti (Çorum) 1986\n" +
                "Nemrut Dağı (Adıyaman) 1987\n" +
                "Hieropolis-Pamukkale (Denizli) 1988 (Karma Miras Alanı)\n" +
                "Xanthos-Letoon (Antalya-Muğla) 1988\n" +
                "Safranbolu Şehri (Karabük) 1994\n" +
                "Truva Arkeolojik Alanı (Çanakkale) 1998\n" +
                "Edirne Selimiye Camii ve Külliyesi (Edirne) 2011\n" +
                "Çatalhöyük Neolitik Alanı (Konya) 2012\n" +
                "Bursa ve Cumalıkızık: Osmanlı İmparatorluğunun Doğuşu (Bursa) 2014\n" +
                "Bergama Çok Katmanlı Kültürel Peyzaj Alanı (İzmir) 2014\n" +
                "Diyarbakır Kalesi ve Hevsel Bahçeleri Kültürel Peyzajı (Diyarbakır) 2015\n" +
                "Efes (İzmir) 2015\n" +
                "Ani Arkeolojik Alanı (Kars) 2016\n" +
                "Aphrodisias (Aydın) 2017\n" +
                "Göbekli Tepe (Şanlıurfa) 2018\n" +
                "Arslantepe Höyüğü (Malatya) 2021\n" +
                "Gordion (Ankara) 2023\n"+
                "Anadolu’nun Ortaçağ Dönemi Ahşap Hipostil Camiileri (Konya-Kastamonu-Eskişehir-Afyon-Ankara) 2023";

        String[] paragraflar = unescoVerileri.split("\n");

        List<String> words = readWordsFromFile();

        for (int i = 0; i < paragraflar.length; i++) {
            String[] parcalar = paragraflar[i].split("\\(|\\)");

            String alanAdi = parcalar[0].trim();
            String[] iller = parcalar[1].trim().split("-");
            List<String> ilListesi = Arrays.asList(iller);
            int ilanYili = Integer.parseInt(parcalar[2].trim());

            // Her paragrafın kelimelerini dosyadan okuyoruz
            List<String> paragrafKelimeleri = Arrays.asList(words.get(i).split("\\s+"));

            UM_Alanı2 umAlan = new UM_Alanı2(alanAdi, ilListesi, ilanYili, paragrafKelimeleri);
            bTree.root= bTree.createTree(bTree.root, umAlan);
            
        }

        return bTree;
    }

    private static List<String> readWordsFromFile() {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("bilgiler.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    words.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}