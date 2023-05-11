package view;

import controller.NetflixController;

public class Main
{
    public static void main(String[] args) {
        String path = "C:\\TEMP";
        String file = "1_netflix_originals_series_2.csv";

        NetflixController net = new NetflixController(path, file);

        try {
            net.genMajorGenreCSVFiles();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
