import javax.persistence.*;

@Entity
@Table(name ="workers")

public class Workers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "worker_ID")
    private int ID;
    @Column(name = "worker_name")
    String name;
    @Column(name = "worker_age")
    private int age;
    @Column(name = "worker_adress")
    private String adress;
    @Column(name = "worker_sellery")
    private double sellery;

    public Workers() {
    }

    public Workers(int age, String adress, double sellery) {
        this.age = age;
        this.adress = adress;
        this.sellery = sellery;
    }

    public Workers(int ID, int age, String adress, double sellery) {
        this.ID = ID;
        this.age = age;
        this.adress = adress;
        this.sellery = sellery;
    }

    public Workers(int ID, String name, int age, String adress, double sellery) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.sellery = sellery;
    }

    public Workers(String name, int age, String adress, double sellery) {
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.sellery = sellery;
    }

    public Workers(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getSellery() {
        return sellery;
    }

    public void setSellery(double sellery) {
        this.sellery = sellery;
    }


    @Override
    public String toString() {
        return "ID: " + getID() + " | " + "NAME: " + getName() + "  |  " + "ADRESS: " + getAdress() + "  |  " + "AGE: " + getAge() + " | "  +
                "SELLERY: " + getSellery() + "\n";
    }
}
