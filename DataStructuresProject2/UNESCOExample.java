package dataStc2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UNESCOExample {
   
        public  static ArrayList<UM_Alanı>[] returnListMetod(){
        	String unescoVerileri = "Divriği Ulu Camii ve Darüşşifası (Sivas) 1985\n" +
                    "İstanbul'un Tarihi Alanları (İstanbul) 1985\n" +
                    "Göreme Millî Parkı ve Kapadokya (Nevşehir) 1985 (Karma Miras Alanı)\n" +
                    "Hattuşa: Hitit Başkenti (Çorum) 1986\n" +
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
                    "Eşrefoğlu Camii (Konya) 2023\n"+
                    "Mahmut Bey Camii (Kastamonu) 2023\n"+
                    "Sivrihisar Camii (Eskişehir) 2023\n"+
                    "Afyon Ulu Camii (Afyon) 2023\n"+
                    "Arslanhane Camii (Ankara) 2023";
                    
                    
        String[] satirlar = unescoVerileri.split("\n");

        
        String [] bolgelerListesi = {"Akdeniz","Doğu Anadolu","Ege","Güney Doğu Anadolu","İç Anadolu","Karadeniz","Marmara"};
        
        ArrayList<UM_Alanı> [] umAlanlarıDizisi = new ArrayList[7];
    	
		
			if (umAlanlarıDizisi[0] == null) {
	            for (int i = 0; i < 7; i++) {
	                umAlanlarıDizisi[i] = new ArrayList<>();
                                        }
			}
       
        for (String satir : satirlar) {
            
            String[] parcalar = satir.split("\\(|\\)");

           
            String alanAdi = parcalar[0].trim();

           
            String[] iller = parcalar[1].trim().split("-");
            List<String> ilListesi = Arrays.asList(iller);	

           
            int ilanYili = Integer.parseInt(parcalar[2].trim());

            
            UM_Alanı umAlan = new UM_Alanı(alanAdi, new ArrayList<>(ilListesi), ilanYili);
           umAlanlarıDizisi= umAlan.addToRegion(umAlan,umAlanlarıDizisi);
        
        }
           return umAlanlarıDizisi;

    
            
        }
    }

