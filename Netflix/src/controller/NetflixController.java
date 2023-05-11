package controller;

import br.fatec.ListObject.ListObject;
import br.fatec.QueueObject.QueueObject;
import model.Serie;

import java.io.*;

public class NetflixController implements INetflixController
{
    private String path;
    private String fileName;
    private String filePath;

    public NetflixController(String path, String file)
    {
        this.path = path;
        this.fileName = file;
        this.filePath = this.path + "\\" + this.fileName;
    }

    private File openFile(String filePath) throws Exception {
        File file = new File(filePath);

        if (!file.isFile() && !file.exists())
            throw new Exception("File no exist");

        return file;
    }

    public void genMajorGenreCSVFiles() throws Exception {
        File file = openFile(filePath);
        FileReader readFile = new FileReader(file);
        BufferedReader buffer = new BufferedReader(readFile);

        String line;
        String[] lines;

        line = buffer.readLine();
        line = buffer.readLine();

        StringBuilder majorGenre = new StringBuilder();
        ListObject queues = new ListObject();

        while (line != null)
        {
            if (l)
            lines = line.split(";");
            Serie serie = new Serie();
            serie.setMajor_genre(lines[0]);
            serie.setTitle(lines[1]);
            serie.setSubgenre(lines[2]);
            serie.setPremiere_year(Integer.parseInt(lines[4]));
            serie.setEpisodes(lines[10]+" episodes");
            serie.setStatus(lines[6]);
            serie.setImdb_rating(Integer.parseInt(lines[11]));

            if(!majorGenre.toString().contains(lines[0]))
            {
                majorGenre.append(lines[0]);
                QueueObject q = new QueueObject();
                q.insert(serie);
                if (queues.isEmpty())
                    queues.addFirst(q);
                else
                    queues.addLast(q);
            }
            else
            {
                QueueObject q = (QueueObject) queues.get(queues.size()-1);
                q.insert(serie);
            }

            line = buffer.readLine();
        }

        readFile.close();
        buffer.close();

        genFiles_byQueues(queues);
    }

    private Serie genSerie(String line)
    {
        String[] lines = line.split(";")
    }

    private void genFiles_byQueues(ListObject queues) throws Exception {
        int size = queues.size();
        StringBuilder content = new StringBuilder();
        String fileName;

        while (size > 0)
        {
            QueueObject series = (QueueObject) queues.get(size-1);
            while (!series.isEmpty())
            {
                Serie serie = (Serie) series.remove();
                fileName = serie.major_genre + ".csv";
                File file = new File(path, fileName);
                FileWriter write = new FileWriter(file);
                PrintWriter fileWriter = new PrintWriter(write);
                content.append(serie.major_genre).append(";");
                content.append(serie.title).append(";");
                content.append(serie.subgenre).append(";");
                content.append(serie.premiere_year).append(";");
                content.append(serie.episodes).append(";");
                content.append(serie.status).append(";");
                content.append(serie.imdb_rating);
                fileWriter.write(content.toString());
                fileWriter.flush();
                fileWriter.close();
                write.close();
            }
            size--;
        }

    }


}
