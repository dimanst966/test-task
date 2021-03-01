import service.AccountOperation;

import java.util.*;

public class Bank {


    public class Account {
        private String id;
        private String name;
        private int money = 0;
        private List<AccountOperation> operations = new ArrayList<AccountOperation>();

        public Account(String id, String name, int money) {
            this.money = money;
            this.id = id;
            this.name = name;
        }

        public void open() {
            accounts.put(id, this);
        }

        public void close() {
            accounts.remove(this);
        }

    }

    Map<String, Account> accounts = new HashMap<String, Account>();


    public static class Banker {
        public Bank createBank() {
            return new Bank();
        }
    }

    private Bank() {

    }

    public void putMoney(String id, final int amount) {
        Account account = accounts.get(id);
        AccountOperation operation = new AccountOperation() {
            public Date getDate() {
                return new Date();
            }

            public int amount() {
                return amount;
            }
        };

        account.operations.add(operation);
    }

    public void getMoney(String id, int amount) {
        Account account = accounts.get(id);
        if (account == null) {
            return;
        }
        account.money = account.money - amount;

    }

}
