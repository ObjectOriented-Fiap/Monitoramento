import java.util.ArrayList;
import java.util.List;

public class Sensor {
    private String id;
    private List<Double>leituras;

    public Sensor(String id) {
        this.id = id;
        this.leituras = new ArrayList<>();
    }

    public void RegistrarLeituras(List<Double>lista) throws LeituraInvalidaException {
        if (lista.size() != 100){
            throw new IllegalArgumentException("O total de temperaturas deve ser igual a 100");
        }
        for (int i =0; i<lista.size();i++){
            double temp = lista.get(i);
            if (temp < -60 || temp > 60){
                throw new LeituraInvalidaException(i,temp);
            }
        }
        this.leituras = lista;
    }

    public List<Double> getLeituras() {
        return leituras;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id='" + id + '\'' +
                ", leituras=" + leituras +
                '}';
    }
}
