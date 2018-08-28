package com.tp.javableu.services;

import com.tp.javableu.model.Contenu;
import com.tp.javableu.model.Data;
import com.tp.javableu.model.Serveur;
import com.tp.javableu.repositories.ContenuRepository;
import com.tp.javableu.repositories.DataRepository;
import com.tp.javableu.repositories.ServeurRepository;
import com.tp.javableu.services.Interface.ISaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.util.*;

@Service
public class SaveService implements ISaveService {

    @Autowired
    private ServeurRepository serveurRepository;
    @Autowired
    private DataRepository dataRepository;
    @Autowired
    private ContenuRepository contenuRepository;

    @Override
    public void save() {
        List<File> all = findFilesRecursively(new File("D:\\Import"), ".csv");

        for (File item: all ) {
            readFirstLine(item);
        }
    }

    @Transactional
    public void readFirstLine(File file) {
        Serveur server = new Serveur();
        server.setFileName(file.getName());
        server.setFilePath(file.getPath());
        serveurRepository.save(server);
        Map<Integer, Contenu> mapContenu = new HashMap<>();

        List<Contenu> listCol  = new ArrayList<>();
        try {
            List<Data> datas = new ArrayList<>();
            int nbLine = 0;

            FileReader fr = new FileReader(file);
            BufferedReader in = new BufferedReader(fr);

            String line = in.readLine();

            while (line != null && !"".equals(line)) {
                nbLine ++;
                if (nbLine == 1)
                {
                    System.out.println(line);
                    List<String> results = Arrays.asList(line.split(";"));
//                    String[] results = line.split(";");
                    results.size();
                    int indexColumn=0;
                    for (String item: results) {
                        Contenu contenu = new Contenu();
                        contenu.setNomCol(item);
                        contenu.setServeur(server);
                        contenu.setIndexColonne(indexColumn);
                        mapContenu.put(indexColumn,contenu);
                        indexColumn++;

                        listCol.add(contenu);
                    }
                    contenuRepository.save(listCol);
                }
                else {
                    String[] dataLines = line.split(";");
                    for (int i=0 ; i< dataLines.length ; i++){
                        String dataLine = dataLines[i];
                        Data data = new Data();
                        data.setValue(dataLine);
                        data.setContenu(mapContenu.get(i));
                        data.setLineNumber(nbLine);
                        datas.add(data);
                    }
                }
                line = in.readLine();
            }

            dataRepository.save(datas);

        } catch (FileNotFoundException flfe) {
            //On gére cette exception si new FileReader("fichier.csv") a échoué
            System.out.println("Erreur : Le fichier n'existe pas, est un dossie ou ne peut être lu.");
        } catch (IOException ioe) {
            //On gère cette expcetion si inputStream.readLine() a échoué
            System.out.println("Erreur IO.");
        }
    }


    private List<File> findFilesRecursively(File file, final String extension) {
        //Liste des fichiers correspondant a l'extension souhaitee
        List<File> all = new ArrayList<>();

        final File[] children = file.listFiles(f -> f.getName().endsWith(extension)
        );
        if (children != null) {
            //Pour chaque fichier recupere, on appelle a nouveau la methode
            for (File child : children) {
                all.add(child);
                all.addAll(findFilesRecursively(child, extension));
            }
        }
        return all;
    }


    /*public List<Data> readData(File file){
        List<Data> listData  = new ArrayList<>();
        try {

            int nbLine = 0;

            FileReader fr = new FileReader(file);
            BufferedReader in = new BufferedReader(fr);

            for (String x = in.readLine(); x != null; x = in.readLine())
            {
                nbLine ++;
                if (nbLine < 1)
                {
                    String line = in.readLine();
                    System.out.println(line);
                    String[] results = line.split(";");

                    for (String item: results) {
                        Data data = new Data();
                        data.setLineNumber(nbLine);
                        data.setValue(item);
                        listData.add(data);
                    }
                }
            }
        } catch (FileNotFoundException flfe) {
            //On gére cette exception si new FileReader("fichier.csv") a échoué
            System.out.println("Erreur : Le fichier n'existe pas, est un dossie ou ne peut être lu.");
        } catch (IOException ioe) {
            //On gère cette expcetion si inputStream.readLine() a échoué
            System.out.println("Erreur IO.");
        }
        return listData;
    }*/
}
