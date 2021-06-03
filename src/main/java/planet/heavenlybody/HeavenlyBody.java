package planet.heavenlybody;

import java.util.HashSet;
import java.util.Set;

enum BodyType {
    STAR, PLANET, MOON, ASTEROID, DEFAULT
}

public class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    //    using hash sets
    private final Set<HeavenlyBody> satellites;
    private final BodyType bodyType;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this(name, orbitalPeriod, BodyType.DEFAULT);
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        satellites = new HashSet<>();
        this.bodyType = bodyType;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody body) {
        if ((this.bodyType == BodyType.PLANET) && (body.getBodyType() != BodyType.MOON)) {
            System.out.println("Planets can only have Moon as satellites");
            return false;
        }

        return this.satellites.add(body);

    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    //    Ovveriding Hash method to check equality of an object
    @Override
    public final boolean equals(Object obj) {
//        if this object and passed object are equal, that mean is the sam object so no more checking is necessary
        if (this == obj) {
            return true;
        }
//         check if obj is null and then check if they are the same class (in case of subclasses)
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        if (this.bodyType != ((HeavenlyBody) obj).getBodyType()) {
            return false;
        }
        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    //    check if class are equal, the same class should always generate the same hashCode
    @Override
    public final int hashCode() {
//        using some number (any number 57 in this case) and adding to hash generated by String class
//        this way we know that hash will always be the same for the same object
        return this.name.hashCode() + 57 + bodyType.ordinal();
    }
}
