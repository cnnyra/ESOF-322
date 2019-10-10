public class Client {
    public static void main(String[] args) {
        // initializing all necessary classes
        DatabaseSoftware software = new DatabaseSoftware();
        DatabaseStrategy relational = new Relational();
        DatabaseStrategy nosql = new NoSQL();
        DatabaseStrategy graph = new Graph();

        // calls the default store method
        software.store();

        // changing strategy to relational
        software.setStoreStrategy(relational);
        System.out.println("Storage strategy has been set to Relational.");
        software.store();

        // changing strategy to noSQL
        software.setStoreStrategy(nosql);
        System.out.println("Storage strategy has been set to NoSQL.");
        software.store();

        // changing strategy to graph
        software.setStoreStrategy(graph);
        System.out.println("Storage strategy has been set to Graph.");
        software.store();
    }
}

class DatabaseSoftware {
    DatabaseSoftware() {
        //constructor for class
    }

    private DatabaseStrategy strategy;

    void store() {
        if (strategy == null)
        {
            System.out.println("Storage strategy has not been set - default store will be used.");
        }
        else {
            strategy.store();
        }
    }
    // sets the store strategy for the database
    void setStoreStrategy(DatabaseStrategy storeStrategy) {
        this.strategy = storeStrategy;
    }
}

abstract class DatabaseStrategy {
    abstract void store();
}

class Relational extends DatabaseStrategy {
    void store() {
        tableStore();
    }
    private void tableStore() {
        System.out.println("Using Relational Database Tool - implementing Table Store strategy.");
    }
}

class NoSQL extends DatabaseStrategy {
    void store() {
        documentStore();
    }
    private void documentStore() {
        System.out.println("Using NoSQL Database Tool - implementing Document Store strategy.");
    }
}

class Graph extends DatabaseStrategy {
    void store() {
        nodeStore();
    }
    private void nodeStore() {
        System.out.println("Using Graph Database Tool - implementing Node Store strategy.");
    }
}