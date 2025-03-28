package dataStc2;
import java.util.ArrayList;
public class UM_Alanı {
	private String alanAdi;
	private ArrayList<String> ilAdlari;
	private int ilanYili;
	public UM_Alanı(String alanAdi, ArrayList<String> ilAdlari, int ilanYili) {
		super();
		this.alanAdi = alanAdi;
		this.ilAdlari = ilAdlari;
		this.ilanYili = ilanYili;
		
	}
	public String getAlanAdi() {
		return alanAdi;
	}
	public void setAlanAdi(String alanAdi) {
		this.alanAdi = alanAdi;
	}
	public ArrayList<String> getIlAdlari() {
		return ilAdlari;
	}
	public void setIlAdlari(ArrayList<String> ilAdlari) {
		this.ilAdlari = new ArrayList<String>(ilAdlari);
	}
	public int getIlanYili() {
		return ilanYili;
	}
	public void setIlanYili(int ilanYili) {
		this.ilanYili = ilanYili;
	}
	
	
	public ArrayList<UM_Alanı>[] addToRegion(UM_Alanı object,ArrayList<UM_Alanı>[] umAlanlarıDizisi) {
		
		if(object.ilAdlari.contains("Antalya")) {
			
			umAlanlarıDizisi[0].add(object);
			if(object.ilAdlari.contains("Muğla")) {}
			umAlanlarıDizisi[2].add(object);
		}
		else if(object.ilAdlari.contains("Kars")||object.ilAdlari.contains("Malatya")){
			umAlanlarıDizisi[1].add(object);
		}
		else if (object.ilAdlari.contains("İzmir")||object.ilAdlari.contains("Aydın")||object.ilAdlari.contains("Muğla")||
				object.ilAdlari.contains("Denizli") ||object.ilAdlari.contains("Afyon")) {
			umAlanlarıDizisi[2].add(object);
		}
		else if(object.ilAdlari.contains("Adıyaman")||object.ilAdlari.contains("Şanlıurfa")||object.ilAdlari.contains("Diyarbakır")) {
			umAlanlarıDizisi[3].add(object);
		
		}
		else if(object.ilAdlari.contains("Ankara")||object.ilAdlari.contains("Çorum")||object.ilAdlari.contains("Sivas")
				||object.ilAdlari.contains("Konya")||object.ilAdlari.contains("Nevşehir")||object.ilAdlari.contains("Eskişehir")) {
			umAlanlarıDizisi[4].add(object);
			
		}
		else if(object.ilAdlari.contains("Karabük")|| object.ilAdlari.contains("Kastamonu")) {
			umAlanlarıDizisi[5].add(object);
		}
		else if(object.ilAdlari.contains("İstanbul")||object.ilAdlari.contains("Çanakkkale")||object.ilAdlari.contains("Edirne")||object.ilAdlari.contains("Bursa")) {
			umAlanlarıDizisi[6].add(object);
		}
		return umAlanlarıDizisi;
		
		
	}
	
	
	
	
	
	

}


