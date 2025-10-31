package Model;


public class Revenue {
    private double monthlyRevenue; // doanh thu tháng hiện tại

    public Revenue() {}

    public Revenue(double monthlyRevenue) {
        this.monthlyRevenue = monthlyRevenue;
    }

    //Getter & setter
    public double getMonthlyRevenue() {
        return monthlyRevenue;
    }

    public void setMonthlyRevenue(double monthlyRevenue) {
        this.monthlyRevenue = monthlyRevenue;
    }

    @Override
    public String toString() {
        return String.format("%,.0f VNĐ", monthlyRevenue);
    }
}
