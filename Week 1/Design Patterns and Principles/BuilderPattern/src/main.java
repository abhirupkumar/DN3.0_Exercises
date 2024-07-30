
public class main {
    public static void main(String[] args) {
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                                .setStorage("1TB SSD")
                                .setGraphicsCard("NVIDIA RTX 3080")
                                .setPowerSupply("750W")
                                .setCoolingSystem("Liquid Cooling")
                                .build();

        Computer officeComputer = new Computer.Builder("Intel i5", "16GB")
                                .setStorage("512GB SSD")
                                .build();

        System.out.println("Gaming Computer: " + gamingComputer);
        System.out.println("Office Computer: " + officeComputer);
    }
}
