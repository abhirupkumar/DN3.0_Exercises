public class CustomerRepositoryImpl implements CustomerRepository {
    public Customer findCustomerById(int id) {
        return new Customer(id, "Meenakshi Sharma");
    }
}

