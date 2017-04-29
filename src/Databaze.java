import java.util.*;




public class Databaze {
	Databaze()
	{
		prvkyDatabaze=new ArrayList<Stroj>();
	}
		
	public boolean setStroj(int ID, char a)
	{
		return	prvkyDatabaze.add(new Stroj(ID,a));
		
	}
	
	public Stroj getStroj(int ID) 
	{
		return prvkyDatabaze.get(ID);
	}
	

    public boolean vymazStroja(int ID)
	{
		Iterator<Stroj> iter= prvkyDatabaze.iterator();
		while(iter.hasNext()){
			Stroj stud = iter.next();
			if(stud.getID() == ID){
				iter.remove();
				return true;
			}
		}
		System.out.println("Stroj nenalezen");
		return false;
	

		
	}
    public int max_kapacita(){
	    int maxkapacita=0;
        for (Stroj mujstroj:prvkyDatabaze) {
            maxkapacita+=mujstroj.getKapacita();
        }
        return maxkapacita;
    }
    public int max_kapacita_sroubky(){
        int maxkapacita=0;
        for (Stroj mujstroj:prvkyDatabaze) {
            if (mujstroj.getStroj()=='b')
            maxkapacita+=mujstroj.getKapacita();
        }
        return maxkapacita;
    }

    public boolean setPracepodlozky(int pracepodlozky) {
        if(pracepodlozky<=max_kapacita()) {
            this.pracepodlozky = pracepodlozky;
            prideleniprace();
            return true;
        }
        return false;
    }

    public boolean setPracesroubky(int pracesroubky) {
        if(pracepodlozky<=max_kapacita_sroubky()) {
            this.pracesroubky = pracesroubky;
            return true;
        }
        return false;
    }
    public boolean setporucha(int ID){
        for (Stroj stroj:prvkyDatabaze){
            if(stroj.getID()==ID){
                if(stroj.getStroj()!='a'){
                    stroj.setPorucha();
                    return true;
                }else{
                    System.out.println("Stroj A se nemuze porouchat");
                }
            }
        }
        return false;
    }
    public boolean setoprava(int ID){
        for (Stroj stroj:prvkyDatabaze){
            if(stroj.getID()==ID){
                stroj.setPorucha();
                return true;
            }
        }
        return false;
    }

    public void setridDatabazi(){

		Collections.sort(prvkyDatabaze);
		System.out.println("Databaze setridena");

	}

	public void vypisDatabaze()
	{
		for (Stroj mujStroj:prvkyDatabaze)
			System.out.println("ID: " + mujStroj.getID() + " stroj: " + mujStroj.getStroj() + " Pouzivany: "+ mujStroj.getAkt_kapacita()+ " max " + mujStroj.getKapacita() + " Porouchan: " + mujStroj.isPorucha());
	}
    public void prideleniprace(){
        //zde bude logika pri pridelovani prace
        int i=0;
        int polozky=0;
        //plni se nez se doplnej
        for (Stroj str:prvkyDatabaze){
            while (str.getAkt_kapacita()<str.getKapacita()){
                i++;
                polozky++;
                str.setAkt_kapacita(i);
            }
            if(polozky==pracepodlozky) break;
            i=0;
        }
    }
    public void odebraniprace(){
        //zde bude logika pri odebirani prace
    }
	public void porovnanistrojuspotreba(){
        //zde bude logika pri porovnani
    }
	private List<Stroj>  prvkyDatabaze;
    private int pracesroubky;
    private int pracepodlozky;
    }