package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;
import org.springframework.stereotype.Component;

public class FileUserDAO implements UserDao {
    
    File file;
    
    public FileUserDAO() {
        file = new File("kayttajat.txt");
    }
    
    public FileUserDAO(String nimi) throws Exception {
        file = new File(nimi);
    }

    @Override
    public List<User> listAll() {
        Scanner nimet = null;
        Scanner passut = null;
        List<User> kayttajat = new ArrayList<User>();
        try {
            nimet = new Scanner(file);
            passut = new Scanner(new File("salasanat.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (nimet.hasNextLine()) {
            String nimi = nimet.nextLine();
            String passu = passut.nextLine();
            kayttajat.add(new User(nimi,passu));
        }
        nimet.close();
        return kayttajat;
    }

    @Override
    public User findByName(String name) {
        Scanner nimet = null;
        Scanner passut = null;
        try {
            nimet = new Scanner(file);
            passut = new Scanner(new File("salasanat.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (nimet.hasNextLine()) {
            String nimi = nimet.nextLine();
            String passu = passut.nextLine();
            if (nimi.equals(name)) {
                nimet.close();
                return new User(name, passu);
            }
        }
        nimet.close();
        return null;
    }

    @Override
    public void add(User user) throws Exception {
        FileWriter names = new FileWriter(file);
        FileWriter pws = new FileWriter(new File("salasanat.txt"));
        String name = user.getUsername();
        String pw = user.getPassword();
        names.write(name + "\n");
        pws.write(pw + "\n");
        names.close();
        pws.close();
    }
    
}