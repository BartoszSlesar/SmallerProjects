package planet.heavenlybody;

public class Moon extends HeavenlyBody {
    public Moon(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.MOON);
    }

    @Override
    public boolean addSattelite(HeavenlyBody body) {
        return false;
    }
}
