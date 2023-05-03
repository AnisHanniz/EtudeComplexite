
public class triTab{


    protected int taille;
    protected Elem[] t;

    public triTab(int taille){
        this.taille=taille;
        t = new Elem[taille];
        for(int i =0;i<taille;i++){
            t[i]= new Elem();
        }
    }
	public triTab(triTab tt){
        this.taille=tt.taille;
        t = new Elem[this.taille];
        for(int i =0;i<this.taille;i++){
            t[i]= new Elem(tt.t[i].getCle(),tt.t[i].getContenu());
        }
    }
	public triTab(int j , int taille){
        this.taille=taille;
        t = new Elem[taille];
        for(int i =0;i<taille;i++){
            t[i]= new Elem(0,0);
        }
    }
    public double getElem(int c){
        for(int i = 0;i<taille;i++){
            if(t[i].getCle()==c)return t[i].getContenu();
        }
        System.out.println("Cette cle n'Ã©xiste pas ! ");
        return -1;
    }

    public int getTaille() {
        return taille;
    }

    public String toString(){
        String str="[ \n";
        System.out.println();
        for(int i =0 ; i<this.taille;i++){
            str+=t[i].toString()+"\n";
        }
        str+=" ]";
        return str;
    }

        public void triBulleV1() {
        for(int i = getTaille()-1; i>1;i--){
                boolean trie = true;
                for(int j = 0;j<getTaille()-1;j++){
                    if(t[j+1].getCle()<t[j].getCle()) {
                        Elem cc = t[j];
                        t[j]=t[j+1];
                        t[j+1]=cc;
                        trie = false;
                        }
                }
        if (trie) return;
        }
    }

    public void triBulleV2() {
            
        int passage = 0;
        boolean permutation = true;
        while(permutation){
                permutation = false;
                passage++;
                Elem cc = new Elem();
                for(int j = 0;j<getTaille()-passage;j++){
                    if(t[j+1].getCle()<t[j].getCle()) {
                        permutation = true;
                        cc = t[j];
                        t[j]=t[j+1];
                        t[j+1]=cc;
                }
            }
        }
    }
    
    public void triSelection() {
        for(int i = 0; i<getTaille();i++){
            for(int j = 0 ; j<getTaille();j++){
                if (t[j].getCle() > t[i].getCle()) {
                    Elem cc = new Elem(t[j].getCle(),t[j].getContenu());
                    t[j]=t[i];
                    t[i]=cc;
                }
            }
        }
    }

    
    public int partitionner(int bmin, int bmax,int pivot){
        int j = bmin;
        for(int i = bmin;i<bmax;i++){
            if(t[i].getCle()<t[bmax-1].getCle()){
                Elem cc = t[i];
                t[i]=t[j];
                t[j]=cc;
                j++;
            }
        }
        Elem c = t[bmax-1];
        t[bmax-1]=t[j];
        t[j]=c;
        return j;
    }
    public void triRapide(int bmin, int bmax) {
        if (getTaille()<2) return;
        if(bmin<bmax){
            int pivot = bmin;
            pivot = partitionner(bmin,bmax,pivot);
            triRapide(bmin,pivot-1);
            triRapide(pivot+1,bmax);
        }
    }



        
	public void triDenombrement(){
	//trouver le max
        int valMax = maxTab(this).getCle();
        int tComptage[] = new int[valMax+1];
        Elem  res[] = new Elem[getTaille()];
	//init a 0
	for(int i = 0;i<valMax+1;i++)
	tComptage[i]=0;
	
        //compter l'occurence de chaque element
	for(int i = 0;i<getTaille();i++)
	tComptage[t[i].getCle()]++;
        
        //accumuler 
        for(int i = 1;i<=valMax;i++)
        tComptage[i]+=tComptage[i-1];
        
        //trouver l'index de chaque element du tableau original dans le tableau de comptage
        //et permuter/placer les elements 
        for(int i = getTaille()-1;i>=0;i--){
            res[tComptage[t[i].getCle()]-1]= t[i];
            tComptage[t[i].getCle()]--;
	}
	
	//copier les elements triÃ©s dans le tableau original
	for(int i =0;i<getTaille();i++){
        t[i]= res[i];
    }
	}
    public boolean rechNaive(double a){
        for(int i = 0; i<getTaille();i++){
            if(t[i].getCle()==a)return true;
        }
        return false;
    }
    public boolean rechDichot(double a){
        int bmax = getTaille()-1;
        int bmin = 0;
        boolean trouve = false;
        while(trouve != true && bmin <= bmax) {
            int pivot = bmax + bmin /2;
            if(t[pivot].getCle()==a)return true;
                if (a < t[pivot].getCle()) {
                    bmax = pivot-1;
                } else {
                    bmin = pivot+1;
            }
        }
        return trouve;
    }

    public boolean rechDichotRec(int a,int bmin, int bmax){
        //if((t[bmin].getCle()==a) || (t[bmax].getCle()==a))return true;
        if(bmin<=bmax){
            if(t[bmin].getCle()==a)return true;
            return false;
        }else{
            int pivot = bmax/2;
            if(t[pivot].getCle()==a)return true;
            if(t[pivot].getCle()>a){return rechDichotRec(a,bmin,pivot-1);}
            else{
                return rechDichotRec(a,pivot+1,bmax);
        }
        }
    }
	public Elem maxTab(triTab t) {
		Elem max= new Elem(0,0);
		for(int i=0; i<t.getTaille();i++){
			if(t.t[i].getCle()>max.getCle())max=t.t[i];
		}
		return max;
	}
	public Elem minTab(triTab t) {
		Elem min= new Elem(1000,1000);
		for(int i=0; i<t.getTaille();i++){
			if(t.t[i].getCle()<min.getCle())min=t.t[i];
		}
		return min;
	}
}