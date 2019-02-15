package com.talgreen;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DAO {
    private final Configuration con;
    private final SessionFactory sf;
    private final Session session;

    /*
    Configuration con = new Configuration().configure().addAnnotatedClass(Repository.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(getRepositories().get(0));

        tx.commit();
     */

    public DAO() {
        con = new Configuration().configure().addAnnotatedClass(Repository.class).addAnnotatedClass(GithubParser.class);
        sf = con.buildSessionFactory();
        session = sf.openSession();
    }

    public void save(GithubParser githubParser){
        Transaction tx = session.beginTransaction();
        session.save(githubParser);
        tx.commit();


    }
}
