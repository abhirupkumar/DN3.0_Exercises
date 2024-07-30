public class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);
        Customer customer = customerService.getCustomerById(50);
        System.out.println("Name: " + customer.getName());
        System.out.println("Customer ID: " + customer.getId());   
        }
}
