package planet.heavenlybody;

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.PLANET);
    }

    @Override
    public boolean addSattelite(HeavenlyBody body) {
        if (body.getBodyType() != BodyType.MOON) {
            System.out.println("Planets can only have Moon as satellites");
            return false;
        }

        return super.addSattelite(body);
    }
}
