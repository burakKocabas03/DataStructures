package dataStc3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class UM_Alanı2 {
		
		private String alanAdi;
		private List<String> ilAdlari;
		private List<String> ilInfo;
		private int ilanYili;
		public UM_Alanı2(String alanAdi,List<String> ilAdlari, int ilanYili,List<String> ilInfo) {
			this.alanAdi = alanAdi;
			this.ilAdlari = ilAdlari;
			this.ilanYili = ilanYili;
			this.ilInfo = ilInfo;
			
		}
		public List<String> getIlInfo() {
			return ilInfo;
		}
		public void setIlInfo(List<String> ilInfo) {
			this.ilInfo = ilInfo;
		}
		public String getAlanAdi() {
			return alanAdi;
		}
		public void setAlanAdi(String alanAdi) {
			this.alanAdi = alanAdi;
		}
		public List<String> getIlAdlari() {
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
		public static Comparator<UM_Alanı2> AlanAdiComparator = Comparator.comparing(UM_Alanı2::getAlanAdi);
	
		
		
		public String toString() {
		    return 
		            "AlanAdi= " + alanAdi    +"  "+
		            " ,İlListesi= " + ilAdlari + "  "+
		            " ,İlanYili= " + ilanYili + "\n"+
		            "İlInfo= " + ilInfo ;
		           
		}

}
