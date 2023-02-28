public class Toys {
    private int idToys;
    private String nameToys;
    private  int countToys;
    private  double weightToys;

    private Toys(ToysBuilder toysBuilder){
        idToys=toysBuilder.idToys;
        nameToys=toysBuilder.nameToys;
        countToys=toysBuilder.countToys;
        weightToys=toysBuilder.weightToys;
    }

    public void setIdToys(int idToys) {
        this.idToys = idToys;
    }

    public void setNameToys(String nameToys) {
        this.nameToys = nameToys;
    }

    public void setCountToys(int countToys) {
        this.countToys = countToys;
    }

    public void setWeightToys(double weightToys) {
        this.weightToys = weightToys;
    }

    public int getIdToys() {
        return idToys;
    }

    public String getNameToys() {
        return nameToys;
    }

    public int getCountToys() {
        return countToys;
    }

    public double getWeightToys() {
        return weightToys;
    }

    public static class ToysBuilder{
        private int idToys;
        private String nameToys;
        private  int countToys;
        private  double weightToys;

        public ToysBuilder(int idToys,String nameToys, int countToys, double weightToys){
            this.idToys=idToys;
            this.nameToys=nameToys;
            this.countToys=countToys;
            this.weightToys = weightToys;
            }

        public  Toys build(){
            return new Toys(this);
        }
    }
    @Override
   public String toString(){
        return "id=" + idToys + " name=" + nameToys + " count=" + countToys+ " weight=" + weightToys;
    }
}
