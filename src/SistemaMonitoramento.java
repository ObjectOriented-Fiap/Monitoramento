import java.util.ArrayList;
import java.util.List;

public class SistemaMonitoramento {
    private List<Sensor> sensoresValidos;
    private List<ErroSensor> sensoresComErro;

    public SistemaMonitoramento() {
        this.sensoresValidos = new ArrayList<>();
        this.sensoresComErro = new ArrayList<>();
    }

    public void processarSensores(List<Sensor> listaSensor,List<List<Double>> listaTemperatura){
        for (int i=0;i<listaSensor.size();i++){
            Sensor sensor = listaSensor.get(i);
            List<Double> temperatura = listaTemperatura.get(i);

            try {
                sensor.RegistrarLeituras(temperatura);
                sensoresValidos.add(sensor);
            }
            catch (LeituraInvalidaException | IllegalArgumentException e){
                sensoresComErro.add(new ErroSensor(sensor.getId(), e.getMessage()));
            }
        }
    }

    public void exibirRelatorio(){
        System.out.println("===== Sensores válidos =====");
        for (Sensor sensor : sensoresValidos){
            System.out.println("Sensor: "+ sensor.getId());
        }

        System.out.println("\n ===== Sensores com erro =====");
        for (ErroSensor sensor: sensoresComErro){
            System.out.print("Sensor: "+ sensor.getIdSensor());
            System.out.println(" --> "+sensor.getMensagemErro());
        }
    }
}
