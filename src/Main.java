import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Sensor> listaSensor = new ArrayList<>();
        List<List<Double>> listaTemperatura = new ArrayList<>();


        for (int i=1;i<= 3;i++){
            listaSensor.add(new Sensor(String.valueOf(i)));
            listaTemperatura.add(gerar(i));
        }

        SistemaMonitoramento sistema = new SistemaMonitoramento();
        sistema.processarSensores(listaSensor,listaTemperatura);
        sistema.exibirRelatorio();

    }

    private static List<Double> gerar(int i) {
        Random random = new Random();
        List<Double> temperatura = new ArrayList<>();
        int total = 100;
        int limite = 60;

        switch (i){
            case 2 -> total = total/2;
            case 3 -> limite = limite *3/4;
        }

        for (int k=0;k<total;k++){
            temperatura.add(random.nextDouble(-limite,limite));
        }
        return temperatura;
    }
}
