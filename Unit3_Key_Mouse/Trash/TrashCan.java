public class TrashCan {
    
    public boolean trash;
    public TrashCan(){
        trash = ((int)(Math.random() * 2) == 0)?false:true;
    }

    public boolean getTrash(){return trash;}
    public void setTrash(boolean trash){this.trash = trash;}
}
