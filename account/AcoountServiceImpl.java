package account;

import common.AbstractService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AcoountServiceImpl extends AbstractService<Account> implements AccountService  {
    private  static AcoountServiceImpl instance = new AcoountServiceImpl();

    List<Account> list ;

    private AcoountServiceImpl(){
        this.list = new ArrayList<>();;
    }
    public static AcoountServiceImpl getInstance(){
        return instance;
    }






    @Override
    public String deposit(Account acoount) {

        return "";

    }

    @Override
    public String withdraw(Account account) {
        return "";

    }

    @Override
    public String getBalance(String accountNumber) {
        return null;
    }





    @Override
    public String save(Account account) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Optional getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Account account) {
        return null;
    }



    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Boolean existById(Long id) {
        return null;
    }
}
