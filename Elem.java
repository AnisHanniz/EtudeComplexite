import java.lang.Math;
public class Elem {
    protected int cle;
    protected double contenu;
    public Elem(){
        this.cle = (int)(Math.random() * 101);
        this.contenu= Math.random() * 101;
    }
    public Elem(int a,double b){
        this.cle = a;
        this.contenu = b;
    }
    public int getCle(){
        return cle;
    }
    public double getContenu(){
        return contenu;
    }
    public void setCle(int c){
        this.cle=c;
    }
    public void setContenu(double c){
        this.contenu=c;
    }
    public String toString() {
        String str = " Cle : " + cle + "->" ;
		String cont = String.format("%.4f",contenu);
		str += "Contenu  : "+cont;
	return str;
    }

}